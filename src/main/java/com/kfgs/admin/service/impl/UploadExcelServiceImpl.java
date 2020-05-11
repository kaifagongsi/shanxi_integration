package com.kfgs.admin.service.impl;

import com.kfgs.admin.service.UploadExcelService;
import com.kfgs.domain.*;
import com.kfgs.domain.ext.ExcelSheetPO;
import com.kfgs.domain.ext.TbEnterpriseExcel;
import com.kfgs.domain.ext.TbProductExcel;
import com.kfgs.mapper.*;
import com.kfgs.utils.DatabasePropertiesUtils;
import com.kfgs.utils.ExportExcelUtil;
import com.kfgs.utils.ImportExcelSheetUtil;
import com.kfgs.utils.ListToModelUtils;
import com.sun.org.apache.xpath.internal.operations.Bool;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;

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

    @Autowired
    TbProtectionNoticeMapper tbProtectionNoticeMapper;


    @Autowired
    TbProductProtectionNoticeMapper tbProductProtectionNoticeMapper;


    @Autowired
    TbEnterpriseMapper tbEnterpriseMapper;

    @Autowired
    TbPolicyDocumentMapper tbPolicyDocumentMapper;

    @Override
    public Boolean upload(MultipartFile file,String dataBasesType,String productType) {
        String originalFilename = file.getOriginalFilename();
        String extName = originalFilename.substring(originalFilename.lastIndexOf(".") + 1);
        try {
            if("1".equals(dataBasesType)){//产品
                // 设置excel读取15列数据
                List<ExcelSheetPO> list = ImportExcelSheetUtil.readExcel(file, null, 17);
                return uploadProduct(list.get(0).getDataList());
            }else if("2".equals(dataBasesType)){//用标企业
                // 设置excel读取13列数据
                List<ExcelSheetPO> list = ImportExcelSheetUtil.readExcel(file, null, 12);
                return uploadEnterprise(list.get(0).getDataList());
            }else if("3".equals(dataBasesType)){//政策文件
                List<ExcelSheetPO> list = ImportExcelSheetUtil.readExcel(file, null, 3);
                return uploadPolicyDocument(list.get(0).getDataList());
            }else if("4".equals(dataBasesType)){ //公告文件
                List<ExcelSheetPO> list = ImportExcelSheetUtil.readExcel(file, null, 3);
                return uploadProtectionNotice(list.get(0).getDataList());
            }else{
                return  false;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return  false;
    }

    private Boolean uploadProtectionNotice(List<List<Object>> dataList) {
        boolean b = false;
        System.out.println(dataList);
        try {
            List<TbProtectionNotice> noticeList = new ArrayList();
            Date date = new Date();
            for(int i = 1; i < dataList.size(); i++){
                TbProtectionNotice notice = new TbProtectionNotice();
                List<Object> item = dataList.get(i);
                String noticeTime = item.get(2).toString();
                item.add(0,0);
                item.add(2,"");
                item.add(3,date);
                item.add(4,0);
                item.set(6,noticeTime.substring(0,10));
                item.add(7,new byte[1]);
                ListToModelUtils.listToModel(item,notice);
                noticeList.add(notice);
            }
            int insertNumber = tbProtectionNoticeMapper.insertList(noticeList);
            if(insertNumber == dataList.size() - 1){
                b = true;
                System.out.println("插入ok");
            }else{
                System.out.println("插入失败");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return b;
    }

    private Boolean uploadPolicyDocument(List<List<Object>> dataList) {
        boolean b = false;
        try {
            List<TbPolicyDocument> documentList = new ArrayList();
            Date date = new Date();
            for(int i = 1; i < dataList.size(); i++){
                TbPolicyDocument tbPolicyDocument = new TbPolicyDocument();
                List<Object> item = dataList.get(i);
                item.add(0,0);
                item.add(2,date);
                item.add(3,0);
                item.add(5,new byte[1]);
                ListToModelUtils.listToModel(item,tbPolicyDocument);
                documentList.add(tbPolicyDocument);
            }
            int insertNumber = tbPolicyDocumentMapper.insertList(documentList);
            if(insertNumber == dataList.size() - 1){
                b = true;
                System.out.println("插入ok");
            }else{
                System.out.println("插入失败");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return b;
    }

    /**
     * 功能描述:
     * 〈〉
     * 1.将企业插入到tb_enterprise
     * 2.将核准公告插入到tb_protection_notice中
     * @param dataList 1
     * @return : void
     * @author : lxl
     * @date : 2020/4/22 9:28
     */
    private boolean uploadEnterprise(List<List<Object>> dataList) {
        boolean b = false;
        try {
            //设置tbproductMap
            Map<String,String> productIdAndNameMap = getProductIdAndNameMap();
            //设置行政区间Map
            Map<String,String> areaMap = getAdminAreaMap();
            List<TbEnterpriseExcel> enterpriseList = new ArrayList<>();
            List<TbProtectionNotice> noticesList = new ArrayList<>();
            Date date = new Date();
            for(int i = 1; i < dataList.size(); i++){
                List<Object> item = dataList.get(i);
                String name = item.get(1).toString();
                if(name !=null && !"".equals(name)){
                    //1.设置企业名称
                    TbEnterpriseExcel tbEnterpriseExcel = new TbEnterpriseExcel();
                    //创建时间
                    item.add(0,date);
                    //是否删除
                    item.add(1,0);
                    ListToModelUtils.listToModel(item,tbEnterpriseExcel);
                    //1.1设置产品ID
                    String productName = tbEnterpriseExcel.getProductName();
                    tbEnterpriseExcel.setProductName(productIdAndNameMap.get(productName));
                    //1.2设置行政区间
                    tbEnterpriseExcel.setAdministrativeId(areaMap.get(tbEnterpriseExcel.getAdministrativeId()));
                    enterpriseList.add(tbEnterpriseExcel);
                    //1.3设置核准年度
                    String approvalYear = tbEnterpriseExcel.getApprovalYear();
                    tbEnterpriseExcel.setApprovalYear(approvalYear.substring(0,4) + "年");
                    //2.1设置核准公告
                    TbProtectionNotice tbProtectionNotice = new TbProtectionNotice();
                    tbProtectionNotice.setTitle(tbEnterpriseExcel.getApprovalAnnouncementNoEnterpriseAll());
                    tbProtectionNotice.setNoticeTime(approvalYear.substring(0,10));
                    tbProtectionNotice.setCreateTime(date);
                    tbProtectionNotice.setIsdelete(0);
                    tbProtectionNotice.setTypeval("核准公告");
                    noticesList.add(tbProtectionNotice);
                }
            }
            int inserEnterprise = tbEnterpriseMapper.insertList(enterpriseList);
            int tbProductProtectionNoticeNum = tbProtectionNoticeMapper.insertList(noticesList);
            if(inserEnterprise != 0 &&  0 != tbProductProtectionNoticeNum){
                b = true;
            }
            System.out.println(inserEnterprise + tbProductProtectionNoticeNum);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return b;
    }

    private Map<String, String> getProductIdAndNameMap() {
        return  ListToModelUtils.listToMap(tbProductMapper.selectProductIdAndName());
    }

    /**
     * 功能描述:
     *  1.将产品插入到 tb_product
     *  2.将产品插入到分类表中
     *  3.将产品插入到产品tb_product_Show中
     *  4.将受理公告插入到tb_protection_notice中
     *  5.将批准（保护）公告插入到tb_protection_notice中
     * @param dataList 1
     * @return : void
     * @author : lxl
     * @date : 2020/4/16 14:40
     */
    private boolean uploadProduct(List<List<Object>> dataList) {
        boolean b = false;
        try{
            //判断文件是否只有标题
            if(dataList.size() == 1){
                return false;
            }
            //初始化行政区间map
            Map<String,String> areaMap = getAdminAreaMap();

            /**
             * 初始化获取当前最大类别的产品id
             */
            Map<String,String> classificationAreaMap = getClassificationMap(1,1);

            /**
             * 初始化获取当前层级id
             */
            Map<String,String> classificationLevelMap = getClassificationMap(2,1);
            /**
             * 初始化获取当前一级类的id
             */
            Map<String,String> classificationParentIdMap = getClassificationMap(3,1);

            List<TbProductExcel> productList = new ArrayList<>();
            List<TbClassification> tbClassificationList = new ArrayList<>();
            List<TbProductShow> tbProductShowList = new ArrayList<>();
            List<TbProtectionNotice> tbProtectionNotices = new ArrayList<>();
            List<TbProductProtectionNotice> tbProductProtectionNoticeList = new ArrayList<>();
            //每行
            Date date = new Date();
            //第0行是标题列表
            for(int i = 1; i < dataList.size(); i++){
                List<Object> item = dataList.get(i);
                String name = item.get(0).toString();
                if(name !=null && !"".equals(name)){
                    //1.设置产品实体
                    TbProductExcel productExcel = new TbProductExcel();
                    item.add(0,date);
                    item.add(1,0);
                    item.add(2,0);
                    try {
                        ListToModelUtils.listToModel(item,productExcel);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    //放入产品表中
                    //1.1设置产品的分类id
                    String classificationName = productExcel.getClassificationid();
                    String areaName = productExcel.getAdministrativeArea();
                    //TbClassification temp = tbClassificationMapper.selectMaxClassificationIdMaxLevelAndParentIdByName(productExcel.getClassificationid());
                    productExcel.setClassificationid(String.format("%04d",Integer.parseInt(classificationAreaMap.get(classificationName) ) + i ));
                    //1.2设置产品的行政区间id
                    // String area = tbAdministrativeAreaMapper.selectCityIdByCityName(productExcel.getAdministrativeArea());
                    productExcel.setAdministrativeArea(areaMap.get(areaName));
                    //1.3设置受理年度
                    String acceptanceYearInit = productExcel.getAcceptanceYear().substring(0,10);
                    String acceptanceYear = acceptanceYearInit.substring(0,4) + "年";
                    productExcel.setAcceptanceYear(acceptanceYear);
                    //1.4设置批准年度
                    //获取批准年度，后面会用到
                    String approvalYearInit = productExcel.getApprovalYear().substring(0,10);
                    String approvalYear = approvalYearInit.substring(0,4) + "年";
                    productExcel.setApprovalYear(approvalYear);
                    productList.add(productExcel);

                    //2.放入分类表中（省内）
                    TbClassification classification = new TbClassification();
                    classification.setName(name);
                    classification.setRootid("2");
                    //设置分类
                    classification.setClassificationid(String.format("%04d",Integer.parseInt(classificationAreaMap.get(classificationName) ) + i ));
                    classification.setParentid(  classificationParentIdMap.get(classificationName)   );
                    classification.setCreateTime(date);
                    classification.setIsdelete(0);
                    classification.setLevel(String.valueOf(Integer.parseInt(  classificationLevelMap.get(classificationName)) + 1));
                    if(tbClassificationList.contains(classification)){
                        return false;
                    }else{
                        tbClassificationList.add(classification);
                    }

                    //3.设置TbProductShow
                    TbProductShow show = new TbProductShow();
                    show.setTitle(name);
                    show.setCreateTime(date);
                    show.setIsdelete(0);
                    show.setType("展示");
                    if(tbProductShowList.contains(show)){
                        return false;
                    }else{
                        tbProductShowList.add(show);
                    }
                    //4.将受理公告插入到tb_protection_notice中
                    TbProtectionNotice tbProtectionNotice = new TbProtectionNotice();
                    tbProtectionNotice.setTitle(productExcel.getAcceptanceAnnouncement());
                    tbProtectionNotice.setCreateTime(  date);
                    tbProtectionNotice.setIsdelete(0);
                    tbProtectionNotice.setTypeval("受理公告");
                    tbProtectionNotice.setNoticeTime(acceptanceYearInit);
                    if(tbProtectionNotices.contains(tbProtectionNotice)){
                        return false;
                    }else{
                        tbProtectionNotices.add(tbProtectionNotice);
                    }
                    //5.将批准（保护）公告插入到tb_protection_notice中
                    TbProtectionNotice tbProtectionNotice1 = new TbProtectionNotice();
                    tbProtectionNotice1.setTitle(productExcel.getApprovalAnnouncementNoProductAll());
                    tbProtectionNotice1.setCreateTime( date);
                    tbProtectionNotice1.setIsdelete(0);
                    tbProtectionNotice1.setTypeval("批准公告");
                    tbProtectionNotice1.setNoticeTime(approvalYearInit);
                    if(tbProtectionNotices.contains(tbProtectionNotice1)){
                        return false;
                    }else{
                        tbProtectionNotices.add(tbProtectionNotice1);
                    }
                }
            }
            //1.1插入到产品表
            int insertProductNum = tbProductMapper.insertList(productList);
            //2.1插入到分类表
            int insertTbClassificationNum = tbClassificationMapper.insertList(tbClassificationList);
            //3.1插入到tb_product_show表
            int insertTbProductShowNum =  tbProductShowMapper.insertList(tbProductShowList);
            //4.1 插入公告插入到tb_protection_notice中
            int insertTbProtectionNotice = tbProtectionNoticeMapper.insertList(tbProtectionNotices);

            //5关系表插数据
            //5.1生成临时关系map
            Map<String,String> productNoticeMap = new HashMap();
            for(TbProtectionNotice notice : tbProtectionNotices){
                productNoticeMap.put(notice.getTitle(),String.valueOf(notice.getId()));
            }
            //5.2构建关系实体
            for(TbProductExcel product : productList){
                TbProductProtectionNotice n1  = new TbProductProtectionNotice();//受理公告
                TbProductProtectionNotice n2  = new TbProductProtectionNotice();//保护公告
                n1.setProductId(String.valueOf(product.getId()));
                n1.setCreateTime(date);
                n2.setProductId(String.valueOf(product.getId()));
                n2.setCreateTime(date);
                //受理公告
                String acceptanceAnnouncementId = productNoticeMap.get(product.getAcceptanceAnnouncement());
                //保护公告
                String approvalAnnouncementNoProductAllId = productNoticeMap.get(product.getApprovalAnnouncementNoProductAll());
                if(StringUtils.isNotBlank(acceptanceAnnouncementId)){
                    n1.setProtectionNoticeId(acceptanceAnnouncementId);
                    tbProductProtectionNoticeList.add(n1);
                }
                if(StringUtils.isNotBlank(approvalAnnouncementNoProductAllId)){
                    n2.setProtectionNoticeId(approvalAnnouncementNoProductAllId);
                    tbProductProtectionNoticeList.add(n2);
                }
            }
            int tbProductProtectionNoticeNum = tbProductProtectionNoticeMapper.insertList(tbProductProtectionNoticeList);
            if(insertProductNum != 0 && insertTbClassificationNum !=0 &&  insertTbProductShowNum!=0 && insertTbProtectionNotice!=0 && tbProductProtectionNoticeNum !=0){
                System.out.println(insertProductNum + " " + insertTbClassificationNum+ " " + insertTbProductShowNum + " " + insertTbProtectionNotice + "" + tbProductProtectionNoticeNum);
                b = true;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return  b;
    }
    /**
     * 功能描述:
     * 〈〉
     *
     * @param field 1 name为key，最大分类id为value， 2 表示 name 为key ，最大层级level为value，3 表示 name为key 分类id为value（）
     * @param county 1 表示为 陕西省内，2表示为国内陕省外
     * @return : java.util.Map<java.lang.String,java.lang.String>
     * @author : lxl
     * @date : 2020/4/22 15:12
     */
    private Map<String, String> getClassificationMap(int field, int county) {
        // 陕西省内
        if(1 == county){
            if(1 == field){
                List<HashMap<String, String>> mapList = tbClassificationMapper.selectNameAndClassificationIdReturnMap("tb_classification");
                return ListToModelUtils.listToMap(mapList);
            }else if(2 == field){
                List<HashMap<String, String>> mapList = tbClassificationMapper.selectNameAndLevelReturnMap("tb_classification");
                return ListToModelUtils.listToMap(mapList);
            }else if(3 == field){
                List<HashMap<String, String>> mapList = tbClassificationMapper.selectNameAndParentIdReturnMap("tb_classification");
                return ListToModelUtils.listToMap(mapList);
            }else{
                return null;
            }
        }else {
            // 国内陕西省外
            if(1 == field){
                List<HashMap<String, String>> mapList = tbClassificationMapper.selectNameAndClassificationIdReturnMap("tb_classfication_country");
                return ListToModelUtils.listToMap(mapList);
            }else if(2 == field){
                List<HashMap<String, String>> mapList = tbClassificationMapper.selectNameAndLevelReturnMap("tb_classfication_country");
                return ListToModelUtils.listToMap(mapList);
            }else if(3 == field){
                List<HashMap<String, String>> mapList = tbClassificationMapper.selectNameAndParentIdReturnMap("tb_classfication_country");
                return ListToModelUtils.listToMap(mapList);
            }else{
                return null;
            }
        }
    }

    /**
     *  初始化行政区间map对象
     */
    @Override
    public Map<String, String> getAdminAreaMap() {
        List<HashMap<String,String>> list = tbAdministrativeAreaMapper.selectCityIdAndNameReturnMap();
        return  ListToModelUtils.listToMap(list);
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
