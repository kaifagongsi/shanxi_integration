package com.kfgs.standard.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.kfgs.domain.TbStandard;
import com.kfgs.domain.TbStandardExample;
import com.kfgs.mapper.TbProductStandardMapper;
import com.kfgs.standard.service.ProductStandardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ProductStandardServiceImpl implements ProductStandardService {

    @Autowired
    private TbProductStandardMapper tbProductStandardMapper;

    @Override
    public Map<String, Object> getList(Map searchMap) {
        //返回页面结果集
        Map<String,Object> map = new HashMap<>();
        TbStandardExample tbStandardExample = new TbStandardExample();
        String type = searchMap.get("searchType").toString();
        String keywords = searchMap.get("searchVal").toString();
        if ("product".equals(type)){
            //产品名称
            tbStandardExample.createCriteria().andProductNameLike("%" + keywords + "%");
        }else if ("number".equals(type)){
            //标准号
            tbStandardExample.createCriteria().andStandardNumberLike("%" + keywords + "%");

        }else if ("name".equals(type)){
            //标准名称
            tbStandardExample.createCriteria().andStandardNameLike("%" + keywords + "%");
        }
        PageHelper.startPage(Integer.parseInt(searchMap.get("pageNo").toString()),Integer.parseInt(searchMap.get("pageSize").toString()));
        Page<TbStandard> page = (Page<TbStandard>)tbProductStandardMapper.selectByExample(tbStandardExample);
        System.out.println(page.getPages());
        map.put("rows",page.getResult());
        map.put("totalPages", page.getPages());
        map.put("total",page.getTotal());
        return map;
    }

    @Override
    public Map<String, Object> getStandardInfo(String standardNumber) {
        Map resultMap = new HashMap();
        if (standardNumber == null || standardNumber == "") {
            resultMap.put("state","200");
            resultMap.put("message","参数错误");
            return resultMap;
        }
        TbStandardExample tbStandardExample = new TbStandardExample();
        tbStandardExample.createCriteria().andStandardNumberEqualTo(standardNumber);
        List<TbStandard> list = tbProductStandardMapper.selectByExample(tbStandardExample);
        if (list.size() == 1){
            TbStandard tbStandard = list.get(0);
            resultMap.put("state","200");
            resultMap.put("data",tbStandard);
            return resultMap;
        }else {
            resultMap.put("state","200");
            resultMap.put("message","参数错误");
            return resultMap;
        }
    }
}
