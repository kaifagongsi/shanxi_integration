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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    @Override
    public QueryResponseResult adminProductListLoad(Map map) {
        //0.初始化map  不使用sql方式查询是因为太慢了
        Map<String,String> areaMap =  getClassificationMap();
        Map<String,Object> resultMap = new HashMap<>();
        PageHelper.startPage(Integer.parseInt(map.get("pageNo").toString()),Integer.parseInt(map.get("pageSize").toString()));
        /*List<TbProduct> productList  = tbProductMapper.selectProductIdAndNameAndAdminAreaAndProductClassificationAndApprovalAnnouncementNoProductAndProtectionNotice();*/
        Page<TbProductExt> page  = (Page<TbProductExt> ) tbProductMapper.selectAdminProductList();
        for(TbProductExt p : page.getResult()){
          //  p.set
            p.setClassificationName(areaMap.get(p.getClassificationid()));
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
        System.out.println(tbProductExt);
        return null;
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


}
