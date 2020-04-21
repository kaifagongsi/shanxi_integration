package com.kfgs.admin.service.impl;

import com.kfgs.admin.service.UploadExcelService;
import com.kfgs.domain.*;
import com.kfgs.domain.ext.ExcelSheetPO;
import com.kfgs.domain.ext.TbProductExcel;
import com.kfgs.mapper.*;
import com.kfgs.utils.DatabasePropertiesUtils;
import com.kfgs.utils.ExportExcelUtil;
import com.kfgs.utils.ImportExcelSheetUtil;
import com.kfgs.utils.ListToModelUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
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

    @Override
    public void upload(MultipartFile file,String dataBasesType,String productType) {
        String originalFilename = file.getOriginalFilename();
        String extName = originalFilename.substring(originalFilename.lastIndexOf(".") + 1);
        try {
            // 设置excel读取15列数据
            List<ExcelSheetPO> list = ImportExcelSheetUtil.readExcel(file, null, 17);
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
     *  4.将受理公告插入到tb_protection_notice中
     *  5.将批准（保护）公告插入到tb_protection_notice中
     * @param dataList 1
     * @return : void
     * @author : lxl
     * @date : 2020/4/16 14:40
     */
    private void uploadProduct(List<List<Object>> dataList) {
        List<TbProductExcel> productList = new ArrayList<>();
        List<TbClassification> tbClassificationList = new ArrayList<>();
        List<TbProductShow> tbProductShowList = new ArrayList<>();
        List<TbProtectionNotice> tbProtectionNotices = new ArrayList<>();
        List<TbProductProtectionNotice> tbProductProtectionNoticeList = new ArrayList<>();
        //每行
        Date date = new Date();
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
                TbClassification temp = tbClassificationMapper.selectMaxClassificationIdMaxLevelAndParentIdByName(productExcel.getClassificationid());
                productExcel.setClassificationid(String.format("%04d",Integer.parseInt(temp.getClassificationid())));
                //1.2设置产品的行政区间id
                String area = tbAdministrativeAreaMapper.selectCityIdByCityName(productExcel.getAdministrativeArea());
                productExcel.setAdministrativeArea(area);
                //1.3设置受理年度
                String acceptanceYearInit = productExcel.getAcceptanceYear().substring(0,10);
                String acceptanceYear = productExcel.getAcceptanceYear().substring(0,4) + "年";
                productExcel.setAcceptanceYear(acceptanceYear);
                //1.4设置批准年度
                //获取批准年度，后面会用到
                String approvalYearInit = productExcel.getApprovalYear().substring(0,10);
                String approvalYear = productExcel.getApprovalYear().substring(0,4) + "年";
                productExcel.setApprovalYear(approvalYear);
                productList.add(productExcel);

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
                if(tbClassificationList.contains(classification)){
                    return;
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
                    return;
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
                    return;
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
                    return;
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

        System.out.println(insertProductNum + " " + insertTbClassificationNum+ " " + insertTbProductShowNum + " " + insertTbProtectionNotice + "" + tbProductProtectionNoticeNum);
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
