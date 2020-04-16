package com.kfgs.utils;

import com.kfgs.domain.ext.ExcelSheetPO;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Date: 2020-04-15-11-00
 * Module:
 * Description:
 *
 * @author:
 */
public class ImportExcelSheetUtil {
    private final static String xls = "xls";
    private final static String xlsx = "xlsx";
    /**
     * 读取excel文件里面的内容 支持日期，数字，字符，函数公式，布尔类型
     *
     * @param file
     * @param rowCount
     * @param columnCount
     * @return
     * @throws FileNotFoundException
     * @throws IOException
     */
    public static List<ExcelSheetPO> readExcel(MultipartFile file, Integer rowCount, Integer columnCount)
            throws FileNotFoundException, IOException {

        // 根据后缀名称判断excel的版本
        String extName = file.getOriginalFilename();
        Workbook wb = null;
        //获取excel文件的io流
        InputStream is = file.getInputStream();
        if (extName.endsWith(xls)) {
            wb = new HSSFWorkbook(is);

        } else if (extName.endsWith(xlsx)) {
            wb = new XSSFWorkbook(is);

        } else {
            // 无效后缀名称，这里之能保证excel的后缀名称，不能保证文件类型正确，不过没关系，在创建Workbook的时候会校验文件格式
            throw new IllegalArgumentException("Invalid excel version");
        }
        // 开始读取数据
        List<ExcelSheetPO> sheetPOs = new ArrayList<>();
        // 解析sheet
        for (int i = 0; i < wb.getNumberOfSheets(); i++) {
            Sheet sheet = wb.getSheetAt(i);
            List<List<Object>> dataList = new ArrayList<>();
            ExcelSheetPO sheetPO = new ExcelSheetPO();
            sheetPO.setSheetName(sheet.getSheetName());
            sheetPO.setDataList(dataList);
            int readRowCount = 0;
            if (rowCount == null || rowCount > sheet.getPhysicalNumberOfRows()) {
                readRowCount = sheet.getPhysicalNumberOfRows();
            } else {
                readRowCount = rowCount;
            }
            // 解析sheet 的行
            for (int j = sheet.getFirstRowNum(); j < readRowCount; j++) {

                Row row = sheet.getRow(j);

                if (row == null) {
                    continue;
                }
                if (row.getFirstCellNum() < 0) {
                    continue;
                }
                /* 读取的为有效数据
                int readColumnCount = 0;
                if (columnCount == null || columnCount > row.getLastCellNum()) {
                    readColumnCount = (int) row.getLastCellNum();
                } else {
                    readColumnCount = columnCount;
                } */
                List<Object> rowValue = new LinkedList<Object>();
                // 解析sheet 的列
                for (int k = 0; k < columnCount; k++) {
                    Cell cell = row.getCell(k);
                    rowValue.add(getCellValue(wb, cell));
                }
                dataList.add(rowValue);
            }
            sheetPOs.add(sheetPO);
        }
        return sheetPOs;
    }

    private static Object getCellValue(Workbook wb, Cell cell) {
        Object columnValue = null;
        if (cell != null) {
            switch (cell.getCellType()) {
                case Cell.CELL_TYPE_STRING:
                    columnValue = cell.getStringCellValue();
                /*if("是".equals(columnValue)){
                	columnValue = 1;
                }else if("否".equals(columnValue)){
                	columnValue = 2;
                }else{
                	columnValue = cell.getStringCellValue();
                }*/
                    break;
                case Cell.CELL_TYPE_NUMERIC:
                    if (HSSFDateUtil.isCellDateFormatted(cell)) {// 处理日期格式、时间格式
                        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");// 格式化日期字符串
                        Date date = cell.getDateCellValue();
                        //columnValue = sdf.format(date);
                        String format = sdf.format(date);
                        if(format.contains("1899")){
                            SimpleDateFormat sd = new SimpleDateFormat("HH:mm:ss");// 格式化日期字符串
                            columnValue = sd.format(date).toString();
                        }else{
                            columnValue = sdf.format(date);
                        }
                    } else {
                        double value = cell.getNumericCellValue();
                        CellStyle style = cell.getCellStyle();
                        DecimalFormat format = new DecimalFormat();
                        String temp = style.getDataFormatString();
                        // 单元格设置成常规
                        if (temp.equals("General")) {
                            format.applyPattern("#");
                        }
                        if(value % 1 == 0){// 是这个整数，小数点后面是0
                            columnValue = format.format(value);
                        }else{//不是整数，小数点后面不是0
                            columnValue = value + "";//format.format(value);
                        }
                        if (columnValue.toString().indexOf(",") >= 0) {
                            columnValue = columnValue.toString().replace(",", "");
                        }
                    }
                    break;
                case Cell.CELL_TYPE_BOOLEAN:
                    columnValue = cell.getBooleanCellValue();
                    break;
                case Cell.CELL_TYPE_BLANK:
                    columnValue = "";
                    break;
                case Cell.CELL_TYPE_FORMULA:
                    // 格式单元格
                    FormulaEvaluator evaluator = wb.getCreationHelper().createFormulaEvaluator();
                    evaluator.evaluateFormulaCell(cell);
                    CellValue cellValue = evaluator.evaluate(cell);
                    columnValue = cellValue.getNumberValue();
                    break;
                default:
                    columnValue = cell.toString();
            }
        }else {
            //默认给空值
            columnValue = "";
        }
        return columnValue;
    }

    /**
     * 将list按行写入到txt文件中(一般导入数据时过滤出错的信息，写入文本)
     * @param errorMessage
     * @param request
     * @throws Exception
     */
    public static void writeFileContext(List<Map<String,Object>> errorMessage, HttpServletRequest request) throws Exception {
        String p = request.getSession().getServletContext().getRealPath("");
        String path ="/WEB-INF/static/message/erroMessage.txt";
        File file = new File(p+path);
        //如果没有文件就创建
        if (!file.isFile()) {
            file.createNewFile();
        }
        Writer writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(p+path), "utf-8"));
        for (Map<String, Object> map : errorMessage) {
            String str = "第"+map.get("errorRow").toString()+"行："+map.get("errorString").toString().trim();
            writer.write(str + "\r\n");
        }
        writer.flush();
        writer.close();
    }
}
