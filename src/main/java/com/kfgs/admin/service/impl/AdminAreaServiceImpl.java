package com.kfgs.admin.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.kfgs.admin.service.AdminAreaService;
import com.kfgs.domain.AreaCode;
import com.kfgs.domain.TbAdministrativeArea;
import com.kfgs.domain.TbAdministrativeAreaExample;
import com.kfgs.domain.response.CommonCode;
import com.kfgs.domain.response.QueryResponseResult;
import com.kfgs.domain.response.QueryResult;
import com.kfgs.mapper.TbAdministrativeAreaMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class AdminAreaServiceImpl implements AdminAreaService {

    @Autowired
    TbAdministrativeAreaMapper tbAdministrativeAreaMapper;

    @Override
    public String findTree() {
        TbAdministrativeAreaExample administrativeAreaExample = new TbAdministrativeAreaExample();
        //查询所有区域数据
        List<TbAdministrativeArea> areaList = tbAdministrativeAreaMapper.selectByExample(null);
        TbAdministrativeArea area = new TbAdministrativeArea();
        QueryResult queryResult = new QueryResult();
        queryResult.setList(areaList);
        int length = queryResult.getList().size();
        System.out.println("行政区域个数"+length);
        //遍历生成tree数据
        List<AreaCode> treelist = new ArrayList<>();
        for(int i=0;i<length;i++){
            AreaCode code = new AreaCode();
            area = areaList.get(i);
            code.id = area.getCityId();
            code.name = area.getName();
            code.pId= area.getParentId();
            if(area.getLevel() == 0 ){
                code.isParent=true;
                code.open = true;
            }
            if(area.getLevel() == 1){
                code.isParent = true;
            }
            treelist.add(code);
        }
        String nodes = JSONArray.toJSONString(treelist);

        return nodes;
    }

    @Override
    public QueryResponseResult findParent() {
        List<TbAdministrativeArea> administrativeAreas = tbAdministrativeAreaMapper.selectByExample(null);
        QueryResult queryResult = new QueryResult();
        queryResult.setList(administrativeAreas);
        return new QueryResponseResult(CommonCode.SUCCESS, queryResult);
    }

    @Override
    public QueryResponseResult findListByParentId(String parentId) {
        return null;
    }
}
