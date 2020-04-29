package com.kfgs.admin.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.kfgs.admin.service.ComplaintManageService;
import com.kfgs.domain.TbComplaintsAboutRightsProtection;
import com.kfgs.domain.TbComplaintsAboutRightsProtectionExample;
import com.kfgs.mapper.TbComplaintsAboutRightsProtectionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service
@Transactional
public class ComplaintManageServiceImpl implements ComplaintManageService {

    @Autowired
    TbComplaintsAboutRightsProtectionMapper tbComplaintsAboutRightsProtectionMapper;

    @Override
    public Map getFinishList(Map searchMap){
        PageHelper.startPage(Integer.parseInt(searchMap.get("pageNo").toString()),15);
        //返回页面结果集

        Map mapResult = new HashMap();
        TbComplaintsAboutRightsProtectionExample slectExample = new TbComplaintsAboutRightsProtectionExample();
        slectExample.createCriteria().andStateEqualTo("2");
        slectExample.setOrderByClause("  create_time desc  ");
        Page<TbComplaintsAboutRightsProtection> page = (Page<TbComplaintsAboutRightsProtection>) tbComplaintsAboutRightsProtectionMapper.selectByExample(slectExample);
        System.out.println(page.getTotal());
        mapResult.put("rows",page.getResult());
        mapResult.put("totalPages", page.getPages());
        mapResult.put("total",page.getTotal());
        return mapResult;
    }

    @Override
    public Map getTodoList(Map searchMap){
        PageHelper.startPage(Integer.parseInt(searchMap.get("pageNo").toString()),15);
        //返回页面结果集
        Map mapResult = new HashMap();
        TbComplaintsAboutRightsProtectionExample slectExample = new TbComplaintsAboutRightsProtectionExample();
        slectExample.createCriteria().andStateEqualTo("0");
        slectExample.setOrderByClause("  create_time desc  ");
        Page<TbComplaintsAboutRightsProtection> page = (Page<TbComplaintsAboutRightsProtection>) tbComplaintsAboutRightsProtectionMapper.selectByExample(slectExample);
        System.out.println(page.getTotal());
        mapResult.put("rows",page.getResult());
        mapResult.put("totalPages", page.getPages());
        mapResult.put("total",page.getTotal());
        return mapResult;
    }


    //更新维权处理
    @Override
    public int updateByExample(Map pData){
        TbComplaintsAboutRightsProtection tbComplaintsAboutRightsProtection = new TbComplaintsAboutRightsProtection();
        int id = Integer.parseInt(pData.get("complaintId").toString());
        String detail = pData.get("complaintDetail").toString();
        TbComplaintsAboutRightsProtectionExample complaintsAboutRightsProtectionExample = new TbComplaintsAboutRightsProtectionExample();
        complaintsAboutRightsProtectionExample.createCriteria().andIdEqualTo(id);
        //complaintsAboutRightsProtectionExample.createCriteria().andDetailsOfComplaintsEqualTo(detail);
        tbComplaintsAboutRightsProtection.setHandlingSituation(pData.get("handlingInfo").toString());
        int returnResult = tbComplaintsAboutRightsProtectionMapper.updateByExampleSelective(tbComplaintsAboutRightsProtection,complaintsAboutRightsProtectionExample);
        return returnResult;
    }

    //新增维权处理
    @Override
    public int insertByExample(Map pData){
        TbComplaintsAboutRightsProtection tbComplaintsAboutRightsProtection = new TbComplaintsAboutRightsProtection();
        int id = Integer.parseInt(pData.get("complaintId").toString());
        String detail = pData.get("complaintDetail").toString();
        TbComplaintsAboutRightsProtectionExample complaintsAboutRightsProtectionExample = new TbComplaintsAboutRightsProtectionExample();
        complaintsAboutRightsProtectionExample.createCriteria().andIdEqualTo(id);
        //complaintsAboutRightsProtectionExample.createCriteria().andDetailsOfComplaintsEqualTo(detail);
        tbComplaintsAboutRightsProtection.setHandlingSituation(pData.get("handlingInfo").toString());
        tbComplaintsAboutRightsProtection.setState("2");
        int returnResult = tbComplaintsAboutRightsProtectionMapper.updateByExampleSelective(tbComplaintsAboutRightsProtection,complaintsAboutRightsProtectionExample);
        return returnResult;
    }

    //批量删除
    @Override
    public int deleteByExample(List idList){
        int len = idList.size();
        int returnResult = 0;
        /*List list = new ArrayList();
        list = idList;*/
        //System.out.println(len);
        for(int i=0;i<len;i++){
            String id = idList.get(i).toString();
            System.out.println("**********************"+id);
            returnResult = tbComplaintsAboutRightsProtectionMapper.deleteByPrimaryKey(Integer.parseInt(id));
        }
        return returnResult;
    }


}
