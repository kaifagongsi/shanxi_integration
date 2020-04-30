package com.kfgs.admin.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.kfgs.admin.service.ClassficationService;
import com.kfgs.domain.*;
import com.kfgs.mapper.TbClassficationCountryMapper;
import com.kfgs.mapper.TbClassificationMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
@Transactional
public class ClassficationServiceImpl implements ClassficationService {

    @Autowired
    TbClassficationCountryMapper tbClassficationCountryMapper;

    @Autowired
    TbClassificationMapper tbClassificationMapper;

    @Override
    public Map<String, Object> getCountryClassList(Map searchMap) {
        PageHelper.startPage(Integer.parseInt(searchMap.get("pageNo").toString()),15);
        //返回页面结果集
        Map mapResult = new HashMap();
        TbClassficationCountryExample slectExample = new TbClassficationCountryExample();
        slectExample.createCriteria().andRootidEqualTo("1");
        //slectExample.setOrderByClause("  create_time desc  ");
        Page<TbClassficationCountry> page = (Page<TbClassficationCountry>) tbClassficationCountryMapper.selectByExample(slectExample);
        List<String> rootIdList = new ArrayList();
        rootIdList = tbClassificationMapper.selectParentId();
        String rootids = "";
        for(int i=0;i<rootIdList.size();i++){
            String id = rootIdList.get(i);
            rootids += id;
            if(i!=rootIdList.size()-1){
                rootids+=",";
            }
        }
        System.out.println(page.getTotal());
        mapResult.put("rows",page.getResult());
        mapResult.put("totalPages", page.getPages());
        mapResult.put("total",page.getTotal());
        mapResult.put("parentId",rootids);
        return mapResult;
    }

    @Override
    public Map<String, Object> getShanxiClassList(Map searchMap) {
        PageHelper.startPage(Integer.parseInt(searchMap.get("pageNo").toString()),15);
        //返回页面结果集
        Map mapResult = new HashMap();
        TbClassificationExample slectExample = new TbClassificationExample();
        slectExample.createCriteria().andRootidEqualTo("1");
        //slectExample.setOrderByClause("  create_time desc  ");
        slectExample.setOrderByClause("level asc");
        Page<TbClassification> page = (Page<TbClassification>) tbClassificationMapper.selectByExample(slectExample);
        TbClassificationExample tbClassificationExample = new TbClassificationExample();
        List<String> rootIdList = new ArrayList();
        rootIdList = tbClassificationMapper.selectParentId();
        String rootids = "";
        for(int i=0;i<rootIdList.size();i++){
            String id = rootIdList.get(i);
            rootids += id;
            if(i!=rootIdList.size()-1){
                rootids+=",";
            }
        }
        //System.out.println("&&&&&&&&&&&&&&&"+rootIdList.size());
        System.out.println(page.getTotal());
        mapResult.put("rows",page.getResult());
        mapResult.put("totalPages", page.getPages());
        mapResult.put("total",page.getTotal());
        mapResult.put("parentId",rootids);
        return mapResult;
    }

    @Override
    public int addCountryClass(String name,String path,String id){
        TbClassficationCountry classficationCountry = new TbClassficationCountry();
        TbClassficationCountryExample example = new TbClassficationCountryExample();
        classficationCountry.setName(name);
        classficationCountry.setClassificationid(id);
        classficationCountry.setParentid("0000");
        classficationCountry.setIsdelete(0);
        classficationCountry.setRootid("1");
        classficationCountry.setLevel(id.substring(0,2));
        Date time= new java.sql.Date(new Date().getTime());
        classficationCountry.setCreateTime(time);
        classficationCountry.setReserve(path);
        int returnResult = tbClassficationCountryMapper.insertSelective(classficationCountry);
        return returnResult;
    }

    @Override
    public int addShanxiClass(String name,String path,String id){
        TbClassification classification = new TbClassification();
        TbClassificationExample example = new TbClassificationExample();
        classification.setName(name);
        classification.setClassificationid(id);
        classification.setParentid("0000");
        classification.setIsdelete(0);
        classification.setRootid("1");
        classification.setLevel(id.substring(0,2));
        Date time= new java.sql.Date(new Date().getTime());
        classification.setCreateTime(time);
        classification.setReserve(path);
        int returnResult = tbClassificationMapper.insertSelective(classification);
        return returnResult;
    }

    @Override
    public int deleteShanxi(List idList){
        int len = idList.size();
        int returnResult = 0;
        for(int i=0;i<len;i++){
            String id = idList.get(i).toString();
            System.out.println("**********************"+id);
            returnResult = tbClassificationMapper.deleteByClassificationId(id);
        }
        return returnResult;
    }

    @Override
    public int deleteCountry(List idList){
        int len = idList.size();
        int returnResult = 0;
        for(int i=0;i<len;i++){
            String id = idList.get(i).toString();
            System.out.println("**********************"+id);
            returnResult = tbClassficationCountryMapper.deleteByClassificationId(id);
        }
        return returnResult;
    }
}
