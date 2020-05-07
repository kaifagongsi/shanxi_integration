package com.kfgs.admin.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.kfgs.admin.service.AdminProductService;
import com.kfgs.admin.service.UploadExcelService;
import com.kfgs.domain.*;
import com.kfgs.domain.ext.TbProductExt;
import com.kfgs.domain.response.CommonCode;
import com.kfgs.domain.response.QueryResponseResult;
import com.kfgs.domain.response.QueryResult;
import com.kfgs.domain.response.ResultCode;
import com.kfgs.mapper.*;
import com.kfgs.utils.ListToModelUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

/**
 * Date: 2020-04-22-21-36
 * Module:
 * Description:
 *
 * @author:
 */
@Service
@Transactional
public class AdminProductImpl implements AdminProductService {

    @Autowired
    TbProductMapper tbProductMapper;

    @Autowired
    TbAdministrativeAreaMapper tbAdministrativeAreaMapper;

    @Autowired
    TbClassificationMapper tbClassificationMapper;

    @Autowired
    TbProtectionNoticeMapper  tbProtectionNoticeMapper;

    @Autowired
    TbProductShowMapper tbProductShowMapper;

    @Autowired
    TbProductProtectionNoticeMapper tbProductProtectionNoticeMapper;

    @Autowired
    TbClassficationCountryMapper tbClassficationCountryMapper;

    @Override
    public QueryResponseResult getProductContentByProductId(String id) {
        Map<String,Object> resultMap = new HashMap<>();
        List<TbProductShow>  model = tbProductShowMapper.selectContentByProductId(id);
        if (model !=null && model.size()== 1) {
            for (TbProductShow xx : model) {
                if(xx.getContent() == null){
                    resultMap.put("content","");

                }else {
                    resultMap.put("content", new String(xx.getContent()));
                }
            }
        }else if(model == null){
            resultMap.put("content","参数错误");
        }
        QueryResult queryResult = new QueryResult();
        queryResult.setMap(resultMap);
        QueryResponseResult queryResponseResult = new QueryResponseResult(CommonCode.SUCCESS,queryResult);
        return queryResponseResult;
    }

    @Override
    public QueryResponseResult deleteProduct(String id) {
        //删除关联表
        int productProtectionNoticeNum = tbProductProtectionNoticeMapper.deleteByProductId(id);
        //删除产品分类表
        int tbClassificationNum  = tbClassificationMapper.deleteByName(Integer.parseInt(id));
        //删除产品展示表
        int tbProductShowNum =  tbProductShowMapper.deleteByTitle(Integer.parseInt(id));
        //删除产品表
        int productDeleteNm =  tbProductMapper.deleteByPrimaryKey(Integer.parseInt(id));
        return new QueryResponseResult(CommonCode.SUCCESS,null);

    }



    @Override
    public QueryResponseResult getProductByProductId(String id) {
        TbProductExt ext = new TbProductExt();
        TbProductExt shouli = null;
        TbProductExt pizhun = null;
        List<TbProductExt> tbProductExts = tbProductMapper.selectByProductIdReturnProductExt(id);
        if(tbProductExts == null || tbProductExts.size() == 0){
            return new QueryResponseResult(CommonCode.FAIL,null);
        }
        //估计会有bug  抽空优化
        for(TbProductExt e : tbProductExts){
            if("受理公告".equals(e.getArea())){
                shouli = e;
            }else{
                pizhun = e;
            }
        }
        //设置id
        //可能没有受理公告或者批准公告（原因是数据不全）
        if(shouli == null){
            ext.setId(Integer.parseInt(id));
            ext.setName(pizhun.getName());
            //设置类别
            ext.setClassificationid( pizhun.getClassificationid().substring(0,2) + "00");
            //申请机构
            ext.setApplicantOrganization(pizhun.getApplicantOrganization());
            //初审机构
            ext.setPreliminaryExaminationBody(pizhun.getPreliminaryExaminationBody());
            //省份名称
            ext.setProvinceName(pizhun.getProvinceName());
            //地市县区名称
            ext.setCityName(pizhun.getCityName());
            //保护范围
            ext.setProtectionScope(pizhun.getProtectionScope());
            //界定保护范围文件
            ext.setDocumentDefiningTheScopeOfProtection(pizhun.getDocumentDefiningTheScopeOfProtection());
            //技术规范
            ext.setTechnicalSpecifications(pizhun.getTechnicalSpecifications());
            //专用标志使用
            ext.setUseOfSpecialSigns(pizhun.getUseOfSpecialSigns());
            //批准机构
            ext.setApprovalAuthorityProduct(pizhun.getApprovalAuthorityProduct());
            //批准公告简称
            ext.setApprovalAnnouncementNoProduct(pizhun.getApprovalAnnouncementNoProduct());
            //批准公告全称（用于下啦框）
            ext.setApprovalAnnouncementNoProductAll(pizhun.getProtectionNoticeTitle());
            //受理公告 （用于下啦框）
            ext.setProtectionNoticeTitle(null);
            //行政区间 市级别
            ext.setAdministrativeAreaProv(pizhun.getAdministrativeArea().substring(0,4)+"00");
            //行政区间 县级别
            ext.setAdministrativeArea(pizhun.getAdministrativeArea());
        }else if(pizhun == null){
            ext.setId(Integer.parseInt(id));
            ext.setName(shouli.getName());
            //设置类别
            ext.setClassificationid( shouli.getClassificationid().substring(0,2) + "00");
            //申请机构
            ext.setApplicantOrganization(shouli.getApplicantOrganization());
            //初审机构
            ext.setPreliminaryExaminationBody(shouli.getPreliminaryExaminationBody());
            //省份名称
            ext.setProvinceName(shouli.getProvinceName());
            //地市县区名称
            ext.setCityName(shouli.getCityName());
            //保护范围
            ext.setProtectionScope(shouli.getProtectionScope());
            //界定保护范围文件
            ext.setDocumentDefiningTheScopeOfProtection(shouli.getDocumentDefiningTheScopeOfProtection());
            //技术规范
            ext.setTechnicalSpecifications(shouli.getTechnicalSpecifications());
            //专用标志使用
            ext.setUseOfSpecialSigns(shouli.getUseOfSpecialSigns());
            //批准机构
            ext.setApprovalAuthorityProduct(shouli.getApprovalAuthorityProduct());
            //批准公告简称
            ext.setApprovalAnnouncementNoProduct(shouli.getApprovalAnnouncementNoProduct());
            //批准公告全称（用于下啦框）
            ext.setApprovalAnnouncementNoProductAll(null);
            //受理公告 （用于下啦框）
            ext.setProtectionNoticeTitle(shouli.getProtectionNoticeTitle());
            //行政区间 市级别
            ext.setAdministrativeAreaProv(shouli.getAdministrativeArea().substring(0,4)+"00");
            //行政区间 县级别
            ext.setAdministrativeArea(shouli.getAdministrativeArea());
        }else{
            ext.setId(Integer.parseInt(id));
            ext.setName(shouli.getName());
            //设置类别
            ext.setClassificationid( shouli.getClassificationid().substring(0,2) + "00");
            //申请机构
            ext.setApplicantOrganization(shouli.getApplicantOrganization());
            //初审机构
            ext.setPreliminaryExaminationBody(shouli.getPreliminaryExaminationBody());
            //省份名称
            ext.setProvinceName(shouli.getProvinceName());
            //地市县区名称
            ext.setCityName(shouli.getCityName());
            //保护范围
            ext.setProtectionScope(shouli.getProtectionScope());
            //界定保护范围文件
            ext.setDocumentDefiningTheScopeOfProtection(shouli.getDocumentDefiningTheScopeOfProtection());
            //技术规范
            ext.setTechnicalSpecifications(shouli.getTechnicalSpecifications());
            //专用标志使用
            ext.setUseOfSpecialSigns(shouli.getUseOfSpecialSigns());
            //批准机构
            ext.setApprovalAuthorityProduct(shouli.getApprovalAuthorityProduct());
            //批准公告简称
            ext.setApprovalAnnouncementNoProduct(shouli.getApprovalAnnouncementNoProduct());
            //批准公告全称（用于下啦框）
            ext.setApprovalAnnouncementNoProductAll(pizhun.getProtectionNoticeTitle());
            //受理公告 （用于下啦框）
            ext.setProtectionNoticeTitle(shouli.getProtectionNoticeTitle());
            //行政区间 市级别
            ext.setAdministrativeAreaProv(shouli.getAdministrativeArea().substring(0,4)+"00");
            //行政区间 县级别
            ext.setAdministrativeArea(shouli.getAdministrativeArea());
        }

        Map<String,Object> resultMap = new HashMap<>();
        resultMap.put("item",ext);
        QueryResult queryResult = new QueryResult();
        queryResult.setMap(resultMap);
        QueryResponseResult queryResponseResult = new QueryResponseResult(CommonCode.SUCCESS,queryResult);
        return queryResponseResult;
    }




    @Override
    public QueryResponseResult adminProductListLoad(Map map) {
        //0.初始化map  不使用sql方式查询是因为太慢了
        Map<String,String> areaMap =  getClassificationMap();
        Map<String,Object> resultMap = new HashMap<>();
        PageHelper.startPage(Integer.parseInt(map.get("pageNo").toString()),Integer.parseInt(map.get("pageSize").toString()));
        /*List<TbProduct> productList  = tbProductMapper.selectProductIdAndNameAndAdminAreaAndProductClassificationAndApprovalAnnouncementNoProductAndProtectionNotice();*/
        Page<TbProductExt> page  = (Page<TbProductExt> ) tbProductMapper.selectAdminProductList();
        for(TbProductExt p : page.getResult()){
            p.setClassificationName(areaMap.get(p.getClassificationid().substring(0,2)+"00"));
        }
        resultMap.put("rows",page.getResult());
        resultMap.put("totalPages", page.getPages());
        resultMap.put("total",page.getTotal());
        QueryResult queryResult = new QueryResult();
        queryResult.setMap(resultMap);
        QueryResponseResult queryResponseResult = new QueryResponseResult(CommonCode.SUCCESS,queryResult);
        return queryResponseResult;
    }

    @Override
    public QueryResponseResult addProduct(TbProductExt tbProductExt) {
        TbProduct product1 = tbProductMapper.selectByPrimaryKey(tbProductExt.getId());
        if(product1 != null){
            //存在，直接删除
            tbProductMapper.deleteByPrimaryKey(tbProductExt.getId());
        }else{
            //不存在，直接插入
        }
        Date currentDate = new Date();
        //1.向tbproduct表中插入数据
        System.out.println(tbProductExt);
        tbProductExt.setCreateTime(currentDate);
        tbProductExt.setIsdelete(0);
        //获取最大产品类别
        String classificationid = tbProductExt.getClassificationid();
        TbClassification classification = tbClassificationMapper.selectMaxClassificationIdMaxLevelAndParentIdByClassificationId(classificationid);
        tbProductExt.setClassificationid(String.format("%04d",Integer.parseInt(classification.getClassificationid())));

        if(StringUtils.isBlank(tbProductExt.getAdministrativeArea())){
            //默认设置为陕西
            tbProductExt.setAdministrativeArea("610000");
        }
        //设置批准年度啊
        TbProtectionNotice e = tbProtectionNoticeMapper.selectByPrimaryKey(Integer.parseInt(tbProductExt.getApprovalAnnouncementNoProductAll()));
        tbProductExt.setApprovalYear(e.getNoticeTime().substring(0,4) + "年");
        tbProductExt.setApprovalAnnouncementNoProductAll(e.getTitle());
        //1.向product表插入数据
        TbProduct product = new TbProductExt(null,null,null,null,null,null,tbProductExt);
        int insertProduct  = tbProductMapper.insertProduct(product);
        //2.向tbProductShwo插入数据
        TbProductShow tbProductShow  = new TbProductShow();
        tbProductShow.setTitle(tbProductExt.getName());
        tbProductShow.setType("展示");
        tbProductShow.setCreateTime(currentDate);
        tbProductShow.setIsdelete(0);
        List productShwoList = new ArrayList();
        productShwoList.add(tbProductShow);
        int insertList = tbProductShowMapper.insertList(productShwoList);
        //3.向tb_classification表中插入数据
        TbClassification tbClassification = new TbClassification();
        tbClassification.setName(tbProductExt.getName());
        tbClassification.setIsdelete(0);
        tbClassification.setCreateTime(currentDate);
        tbClassification.setRootid("2");
        tbClassification.setParentid(classification.getParentid());
        tbClassification.setClassificationid(String.format("%04d",Integer.parseInt(tbProductExt.getClassificationid())));
        tbClassification.setLevel(classification.getLevel());
        int insertClassification = tbClassificationMapper.insert(tbClassification);
        //4.向tb_product_protection_notice 插入关联数据 批准公告
        TbProductProtectionNotice ppn = new TbProductProtectionNotice();
        ppn.setCreateTime(currentDate);
        ppn.setProductId(String.valueOf(product.getId()));
        ppn.setProtectionNoticeId(String.valueOf(e.getId()));
        int insertPPN = tbProductProtectionNoticeMapper.insert(ppn);
        //4.1向tb_product_protection_notice 插入关联数据 受理公告
        TbProductProtectionNotice ppn1 = new TbProductProtectionNotice();
        ppn1.setCreateTime(currentDate);
        ppn1.setProductId(String.valueOf(product.getId()));
        ppn1.setProtectionNoticeId(tbProductExt.getProtectionNoticeTitle());
        int insertPPN2 = tbProductProtectionNoticeMapper.insert(ppn1);
        if( 1 == insertPPN && 1 == insertClassification && 1 == insertList && 1 == insertProduct && 1 == insertPPN2){
            return new QueryResponseResult(CommonCode.SUCCESS,null);
        }else{
            return new QueryResponseResult(CommonCode.FAIL,null);
        }
    }

    @Override
    public QueryResponseResult getSelectMap() {
        //查询产品信息页面中的5个下拉列表
        Map resultMap = new HashMap();
        //1.查询顶级产品分类
        List<TbClassification> adminArea = tbClassificationMapper.selectRootIdEqulesOne();
        resultMap.put("adminArea",adminArea);
        //2.1设置批准公告
        TbProtectionNoticeExample example = new TbProtectionNoticeExample();
        example.createCriteria().andTypevalEqualTo("批准公告");
        List<TbProtectionNotice>  noticeHeZhunList = tbProtectionNoticeMapper.selectByExample(example);
        resultMap.put("noticePiZhunList",noticeHeZhunList);
        //2.2设置受理公告
        example.clear();
        example.createCriteria().andTypevalEqualTo("受理公告");
        List<TbProtectionNotice>  noticeList = tbProtectionNoticeMapper.selectByExample(example);
        resultMap.put("noticeShouLiList",noticeList);
        //3.1获取行政区间市级别
        TbAdministrativeAreaExample adminExample = new  TbAdministrativeAreaExample();
        adminExample.createCriteria().andParentIdEqualTo("610000");
        List<TbAdministrativeArea> areas = tbAdministrativeAreaMapper.selectByExample(adminExample);
        resultMap.put("areasCityList",areas);
        //3.1设置县级别的
        adminExample.clear();
        adminExample.createCriteria().andParentIdNotEqualTo("610000").andParentIdNotEqualTo("000000");
        List<TbAdministrativeArea> areasCopuntyList = tbAdministrativeAreaMapper.selectByExample(adminExample);
        resultMap.put("areasCountyList",areasCopuntyList);
        QueryResult queryResult = new QueryResult();
        queryResult.setMap(resultMap);
        return new QueryResponseResult(CommonCode.SUCCESS,queryResult);
    }



    public Map<String, String> getClassificationMap() {
        List<HashMap<String,String>> list = tbClassificationMapper.selectClassificationIdAndNameReturnMap();
        return  ListToModelUtils.listToMap(list);
    }


    @Override
    public QueryResponseResult getProductCountryList(Map map) {
        Map<String,Object> resultMap = new HashMap<>();
        PageHelper.startPage(Integer.parseInt(map.get("pageNo").toString()),Integer.parseInt(map.get("pageSize").toString()));
        Page<TbClassficationCountry> page = (Page<TbClassficationCountry>)tbClassficationCountryMapper.getProductCountryList();
        resultMap.put("rows",page.getResult());
        resultMap.put("totalPages", page.getPages());
        resultMap.put("total",page.getTotal());
        QueryResult queryResult = new QueryResult();
        queryResult.setMap(resultMap);
        QueryResponseResult queryResponseResult = new QueryResponseResult(CommonCode.SUCCESS,queryResult);
        return queryResponseResult;
    }

    @Override
    public QueryResponseResult getCountryProductByProductId(String id) {
        Map<String,Object> resultMap = new HashMap<>();
        List<TbProductShow>  model = tbProductShowMapper.selectCountryInfoByProduct(id);
        if (model !=null && model.size()== 1) {
            for (TbProductShow xx : model) {
                if(xx.getContent() == null){
                    resultMap.put("content","");
                    resultMap.put("name",xx.getTitle());
                }else {
                    resultMap.put("content", new String(xx.getContent()));
                    resultMap.put("name",xx.getTitle());
                }
            }
        }else if(model == null){
            resultMap.put("content","参数错误");
        }
        QueryResult queryResult = new QueryResult();
        queryResult.setMap(resultMap);
        QueryResponseResult queryResponseResult = new QueryResponseResult(CommonCode.SUCCESS,queryResult);
        return queryResponseResult;
    }

    @Override
    public QueryResponseResult deleteCountryProduct(String id) {
        //删除两个地方
        //1.删除show表
        TbProductShow tbProductShow = new TbProductShow();
        int deleteShowNum  = tbProductShowMapper.deleteById(id);
        List<TbProductShow> shows = tbProductShowMapper.selectCountryInfoByProduct(id);
         if(shows != null && shows.size()== 1){
             tbProductShow = shows.get(0);
             //2.删除分类表
             int classNum = tbClassficationCountryMapper.deleteByName(tbProductShow.getTitle());
             if(1  == classNum && 1 == deleteShowNum){
                 return new QueryResponseResult(CommonCode.SUCCESS,null);
             }else{
                 return new QueryResponseResult(CommonCode.FAIL,null);
             }
         }else{
             return new QueryResponseResult(CommonCode.FAIL,null);
         }
    }
}
