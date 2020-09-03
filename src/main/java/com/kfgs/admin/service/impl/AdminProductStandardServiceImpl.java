package com.kfgs.admin.service.impl;

import com.kfgs.admin.service.AdminProductStandardService;
import com.kfgs.domain.TbStandard;
import com.kfgs.domain.TbStandardExample;
import com.kfgs.domain.response.CommonCode;
import com.kfgs.domain.response.QueryResponseResult;
import com.kfgs.domain.response.QueryResult;
import com.kfgs.mapper.TbProductStandardMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class AdminProductStandardServiceImpl implements AdminProductStandardService {

    @Autowired
    private TbProductStandardMapper tbProductStandardMapper;

    @Override
    public QueryResponseResult getProductStandardInfo(String id) {
        TbStandardExample example = new TbStandardExample();
        example.createCriteria().andIdEqualTo(Integer.valueOf(id));
        List<TbStandard> tbStandards = tbProductStandardMapper.selectByExample(example);
        if(tbStandards.size() == 1){
            QueryResponseResult queryResponseResult = new QueryResponseResult();
            QueryResult queryResult = new QueryResult();
            Map map = new HashMap<>(1);
            map.put("item",tbStandards.get(0));
            queryResult.setMap(map);
            queryResponseResult.setQueryResult(queryResult);
            return queryResponseResult;
        }else{
            return new QueryResponseResult(CommonCode.FAIL,null);
        }
    }
}
