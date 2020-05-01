package com.kfgs.admin.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.kfgs.admin.service.AdminEnterpriseService;
import com.kfgs.domain.ext.TbEnterpriseExt;
import com.kfgs.domain.response.CommonCode;
import com.kfgs.domain.response.QueryResponseResult;
import com.kfgs.domain.response.QueryResult;
import com.kfgs.mapper.TbEnterpriseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class AdminEnterpriseServiceImpl implements AdminEnterpriseService {

    @Autowired
    TbEnterpriseMapper tbEnterpriseMapper;

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
}
