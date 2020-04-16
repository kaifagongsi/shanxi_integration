package com.kfgs.admin.service.impl;

import com.kfgs.admin.service.UploadExcelService;
import com.kfgs.domain.TbClassification;
import com.kfgs.domain.TbProduct;
import com.kfgs.domain.TbProductShow;
import com.kfgs.domain.ext.ExcelSheetPO;
import com.kfgs.mapper.TbAdministrativeAreaMapper;
import com.kfgs.mapper.TbClassificationMapper;
import com.kfgs.mapper.TbProductMapper;
import com.kfgs.mapper.TbProductShowMapper;
import com.kfgs.utils.DatabasePropertiesUtils;
import com.kfgs.utils.ExportExcelUtil;
import com.kfgs.utils.ImportExcelSheetUtil;
import com.kfgs.utils.ListToModelUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * Date: 2020-04-15-14-43
 * Module:
 * Description:
 *
 * @author:
 */
@Service
@Transactional
public class UploadExcelServiceImpl implements UploadExcelService {


    @Autowired
    TbProductMapper tbProductMapper;

    @Autowired
    TbClassificationMapper tbClassificationMapper;

    @Autowired
    TbProductShowMapper tbProductShowMapper;

    @Autowired
    TbAdministrativeAreaMapper tbAdministrativeAreaMapper;

    @Override
    public void upload(MultipartFile file,String dataBasesType,String productType) {
        String originalFilename = file.getOriginalFilename();
        String extName = originalFilename.substring(originalFilename.lastIndexOf(".") + 1);
        try {
            // 设置excel读取15列数据
            List<ExcelSheetPO> list = ImportExcelSheetUtil.readExcel(file, null, 15);
            if("产品.xls".equals(originalFilename)){
                uploadProduct(list.get(0).getDataList());
            }else if("用标企业.xls".equals(originalFilename)){

            }else if("公告.xls".equals(originalFilename)){

            }else if("政策文件.xls".equals(originalFilename)){

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 功能描述:
     *  1.将产品插入到 tb_product
     *  2.将产品插入到分类表中
     *  3.将产品插入到产品tb_product_Show中
     * @param dataList 1
     * @return : void
     * @author : lxl
     * @date : 2020/4/16 14:40
     */
    private void uploadProduct(List<List<Object>> dataList) {
        List<TbProduct> productList = new ArrayList<>();
        List<TbClassification> tbClassificationList = new ArrayList<>();
        List<TbProductShow> tbProductShowList = new ArrayList<>();
        //每行
        Date date = new Date();
        for(int i = 1; i < dataList.size(); i++){
            List<Object> item = dataList.get(i);
            String name = item.get(0).toString();
            if(name !=null && !"".equals(name)){
                //1.设置产品实体
                TbProduct product = new TbProduct();
                item.add(0,0);
                item.add(4,date);
                item.add(5,0);
                try {
                    ListToModelUtils.listToModel(item,product);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                //放入企业表中
                //1.1设置产品的分类id
                TbClassification temp = tbClassificationMapper.selectMaxClassificationIdMaxLevelAndParentIdByName(product.getClassificationid());
                //product.setClassificationid(String.valueOf(Integer.parseInt(temp.getClassificationid()) + 1));
                product.setClassificationid(String.format("%04d",Integer.parseInt(temp.getClassificationid())));
                //1.2设置产品的行政区间id
                String area = tbAdministrativeAreaMapper.selectCityIdByCityName(product.getAdministrativeArea());
                product.setAdministrativeArea(area);
                productList.add(product);

                //2.放入分类表中（省内）
                TbClassification classification = new TbClassification();
                classification.setName(name);
                classification.setRootid("2");
                //设置分类
                classification.setClassificationid(String.format("%04d",Integer.parseInt(temp.getClassificationid())));
                classification.setParentid(temp.getParentid());
                classification.setCreateTime(date);
                classification.setIsdelete(0);
                classification.setLevel(String.valueOf(Integer.parseInt(temp.getLevel()) + 1));
                tbClassificationList.add(classification);


                //3.设置TbProductShow
                TbProductShow show = new TbProductShow();
                show.setTitle(name);
                show.setCreateTime(date);
                show.setIsdelete(0);
                show.setType("展示");
                tbProductShowList.add(show);
            }
        }
        //1.1插入到产品表
        int insertProductNum = tbProductMapper.insertList(productList);
        //2.1插入到分类表
        int insertTbClassificationNum = tbClassificationMapper.insertList(tbClassificationList);
        //3.1插入到tb_product_show表
        int insertTbProductShowNum =  tbProductShowMapper.insertList(tbProductShowList);
        System.out.println(insertProductNum + " " + insertTbClassificationNum+ " " + insertTbProductShowNum);
    }

    /**
     *  不使用当前方式下载excel
     *
     */
    @Override
    public void downLoadExcel(HttpServletResponse response, Integer index) {
        /**
         *  准备暴露的表
         *  用标企业，政策文件，产品，产品公告
         */
        List name_database = Arrays.asList(new String[] {"tb_enterprise","tb_policy_document","tb_product","tb_protection_notice"});
        List nameList = Arrays.asList(new String[] {"用标企业","政策文件","产品","产品公告"});
        try {
            if (response != null && index != null) {
                response.setContentType("application/vnd.ms-excel;charset=utf-8");
                response.setHeader("Content-Disposition", "attachment;filename=\"" + new String((nameList.get(index).toString() + ".xls").getBytes("utf-8"), "ISO8859-1"));
                ExportExcelUtil.exportExcel2003(nameList.get(index).toString(), DatabasePropertiesUtils.getHearders(name_database.get(index).toString()),null,response.getOutputStream(),null );
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
