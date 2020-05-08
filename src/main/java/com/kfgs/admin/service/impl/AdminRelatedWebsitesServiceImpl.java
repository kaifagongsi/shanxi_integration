package com.kfgs.admin.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.kfgs.admin.service.AdminRelatedWebsitesService;
import com.kfgs.domain.TbClassficationCountry;
import com.kfgs.domain.ext.TbRelatedWebsitesExt;
import com.kfgs.domain.response.CommonCode;
import com.kfgs.domain.response.QueryResponseResult;
import com.kfgs.domain.response.QueryResult;
import com.kfgs.mapper.TbRelatedWebsitesMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Date: 2020-05-08-17-09
 * Module:
 * Description:
 *
 * @author:
 */
@Service
public class AdminRelatedWebsitesServiceImpl implements AdminRelatedWebsitesService {

    @Autowired
    TbRelatedWebsitesMapper tbRelatedWebsitesMapper;

    @Override
    public QueryResponseResult getRelatedWebsitesList(Map map) {
        Map<String,Object> resultMap = new HashMap<>();
        PageHelper.startPage(Integer.parseInt(map.get("pageNo").toString()),Integer.parseInt(map.get("pageSize").toString()));
        Page<TbRelatedWebsitesExt> page = (Page<TbRelatedWebsitesExt>) tbRelatedWebsitesMapper.getRelatedWebsitesList();
        resultMap.put("rows",page.getResult());
        resultMap.put("totalPages", page.getPages());
        resultMap.put("total",page.getTotal());
        QueryResult queryResult = new QueryResult();
        queryResult.setMap(resultMap);
        QueryResponseResult queryResponseResult = new QueryResponseResult(CommonCode.SUCCESS,queryResult);
        return queryResponseResult;
    }
}
