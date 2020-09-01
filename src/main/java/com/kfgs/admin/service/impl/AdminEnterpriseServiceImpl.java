package com.kfgs.admin.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.kfgs.admin.service.AdminEnterpriseService;
import com.kfgs.domain.*;
import com.kfgs.domain.ext.TbEnterpriseExt;
import com.kfgs.domain.response.CommonCode;
import com.kfgs.domain.response.QueryResponseResult;
import com.kfgs.domain.response.QueryResult;
import com.kfgs.mapper.TbAdministrativeAreaMapper;
import com.kfgs.mapper.TbEnterpriseMapper;
import com.kfgs.mapper.TbProductMapper;
import com.kfgs.mapper.TbProtectionNoticeMapper;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.Id;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
@Transactional
public class AdminEnterpriseServiceImpl implements AdminEnterpriseService {

    @Autowired
    TbEnterpriseMapper tbEnterpriseMapper;
    @Autowired
    TbAdministrativeAreaMapper tbAdministrativeAreaMapper;

    @Autowired
    TbProductMapper tbProductMapper;

    @Autowired
    TbProtectionNoticeMapper tbProtectionNoticeMapper;

    @Override
    public QueryResponseResult getEnterpriseList(Map map) {
        PageHelper.startPage(Integer.parseInt(map.get("pageNo").toString()),Integer.parseInt(map.get("pageSize").toString()));
        Page<TbEnterpriseExt> page  = (Page<TbEnterpriseExt>) tbEnterpriseMapper.selectAdminEnterpriseList();
        Map resultMap = new HashMap<>();
        resultMap.put("enterpriseList",page.getResult());
        resultMap.put("totalPages",page.getPages());
        resultMap.put("total",page.getTotal());
        QueryResult queryResult = new QueryResult();
        queryResult.setMap(resultMap);
        return new QueryResponseResult(CommonCode.SUCCESS, queryResult);
    }

    /* *
     * 功能描述:
     * 〈获取用标企业表中的三个 下拉列表1行政区间，2产品，3核准公告。行政区间中具体的区县不获取〉
     *
     * @param  1
     * @return : com.kfgs.domain.response.QueryResponseResult
     * @author : mango
     * @date : 2020/5/5 21:30
     */
    @Override
    public QueryResponseResult getSelectEnterprise() {
        Map resultMap = new HashMap();
        //1获取行政区间市级别
        TbAdministrativeAreaExample adminExample = new  TbAdministrativeAreaExample();
        adminExample.createCriteria().andLevelEqualTo(1).andIsdeleteEqualTo(0);
        List<TbAdministrativeArea> areas = tbAdministrativeAreaMapper.selectByExample(adminExample);
        resultMap.put("entAreasCityList",areas);
        //2.获取产品
        //Map<Integer, Map> integerMapMap = tbProductMapper.selectByIdAndName();
        List<TbProduct> productList = tbProductMapper.selectByIdAndNameReturnList();
        resultMap.put("productList",productList);
        //3.获取核准公告
        TbProtectionNoticeExample example = new TbProtectionNoticeExample();
        example.createCriteria().andTypevalEqualTo("核准公告").andIsdeleteEqualTo(0);
        List<TbProtectionNotice> tbProtectionNotices = tbProtectionNoticeMapper.selectByExample(example);
        resultMap.put("protectionNoticesList",tbProtectionNotices);
        QueryResult quertResult = new QueryResult();
        quertResult.setMap(resultMap);
        return  new QueryResponseResult(CommonCode.SUCCESS,quertResult);
    }

    @Override
    public QueryResponseResult addEnterprise(TbEnterpriseExt tbEnterpriseExt) {
        int deleteNum = 0;
        if(tbEnterpriseExt.getId() != 0 ){
            deleteNum =  tbEnterpriseMapper.deleteById(tbEnterpriseExt.getId());
        }else{

        }
        if(StringUtils.isEmpty(tbEnterpriseExt.getAdministrativeId())){
            tbEnterpriseExt.setAdministrativeId("610000");
        }
        //设置批准公告
        TbProtectionNotice protectionNotice = tbProtectionNoticeMapper.selectById(tbEnterpriseExt.getApprovalAnnouncementNoEnterpriseAll());
        tbEnterpriseExt.setApprovalAnnouncementNoEnterpriseAll(protectionNotice.getTitle());
        //设置批准年度
        tbEnterpriseExt.setApprovalYear(protectionNotice.getNoticeTime().substring(0,4));
        //设置时间
        tbEnterpriseExt.setCreateTime(new Date());
        //设置是否删除
        tbEnterpriseExt.setIsdelete(0);
        System.out.println(tbEnterpriseExt);
        int insert = tbEnterpriseMapper.insertWithOutId(tbEnterpriseExt);
        if( 1 == insert ){
                System.out.println("插入成功");
            QueryResult queryResult = new QueryResult();
            Map resultMap = new HashMap();
            resultMap.put("item",tbEnterpriseExt);
            queryResult.setMap(resultMap);
            return new QueryResponseResult(CommonCode.SUCCESS,queryResult);
        }else{
            return new QueryResponseResult(CommonCode.FAIL,null);
        }
    }

    @Override
    public QueryResponseResult selectById(String id) {
        Map resultMap = new HashMap();
        TbEnterpriseExt ext = tbEnterpriseMapper.selectById(id);
        ext.setCity(ext.getAdministrativeId().substring(0,4)+"00");
        String noticeId = tbProtectionNoticeMapper.selectByName(ext.getApprovalAnnouncementNoEnterpriseAll());
        ext.setApprovalAnnouncementNoEnterpriseAll(noticeId);
        System.out.println(ext);
        QueryResult queryResult = new QueryResult();
        resultMap.put("item",ext);
        queryResult.setMap(resultMap);
        return new QueryResponseResult(CommonCode.SUCCESS,queryResult);
    }

    @Override
    public QueryResponseResult deleteEnterprise(String id) {
        System.out.println(id);
        int deleteNum = tbEnterpriseMapper.deleteById(Integer.parseInt(id));
        if(1 == deleteNum){
            return new QueryResponseResult(CommonCode.SUCCESS,null);
        }else{
            return new QueryResponseResult(CommonCode.FAIL,null);
        }

    }
}
