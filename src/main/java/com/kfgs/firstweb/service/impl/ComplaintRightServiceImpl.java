package com.kfgs.firstweb.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.kfgs.domain.TbComplaintsAboutRightsProtection;
import com.kfgs.domain.TbComplaintsAboutRightsProtectionExample;
import com.kfgs.firstweb.service.ComplaintRightService;
import com.kfgs.mapper.TbComplaintsAboutRightsProtectionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
@Transactional
public class ComplaintRightServiceImpl implements ComplaintRightService {

    @Autowired
    TbComplaintsAboutRightsProtectionMapper tbComplaintsAboutRightsProtectionMapper;

    @Override
    public Map getList(Map searchMap){
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
    public int insertByExample(Map pData){
        TbComplaintsAboutRightsProtection tbComplaintsAboutRightsProtection = new TbComplaintsAboutRightsProtection();
        tbComplaintsAboutRightsProtection.setObjectOfComplaint(pData.get("object").toString());
        tbComplaintsAboutRightsProtection.setDetailsOfComplaints(pData.get("detail").toString());
        String money = pData.get("money").toString();
        tbComplaintsAboutRightsProtection.setAmountOfComplaint(Double.valueOf(money));
        tbComplaintsAboutRightsProtection.setState(pData.get("state").toString());
        tbComplaintsAboutRightsProtection.setComplainant(pData.get("complainant").toString());
        tbComplaintsAboutRightsProtection.setContact(pData.get("contact").toString());
        tbComplaintsAboutRightsProtection.setPathOfEvidenceUpload(pData.get("filepath").toString());
        Date time= new java.sql.Date(new Date().getTime());
        tbComplaintsAboutRightsProtection.setCreateTime(time);
        TbComplaintsAboutRightsProtectionExample complaintsAboutRightsProtectionExample = new TbComplaintsAboutRightsProtectionExample();
        int returnResult = tbComplaintsAboutRightsProtectionMapper.insertComplain(tbComplaintsAboutRightsProtection);
        return returnResult;
    }
}
