package com.kfgs.landmark.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.kfgs.domain.TbAdministrativeArea;
import com.kfgs.domain.TbAdministrativeAreaExample;
import com.kfgs.domain.TbProductLandmark;
import com.kfgs.domain.TbProductLandmarkExample;
import com.kfgs.domain.response.CommonCode;
import com.kfgs.domain.response.QueryResponseResult;
import com.kfgs.domain.response.QueryResult;
import com.kfgs.landmark.service.ProductLandmarkService;
import com.kfgs.mapper.TbAdministrativeAreaMapper;
import com.kfgs.mapper.TbProductLandmarkMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ProductLandmarkServiceImpl implements ProductLandmarkService {

    @Autowired
    private TbProductLandmarkMapper tbProductLandmarkMapper;

    @Autowired
    TbAdministrativeAreaMapper tbAdministrativeAreaMapper;

    /*@Override
    public List<Map<String,Object>> getIndustryAndType() {
        //返回结果集
        List<Map<String,Object>> list = new ArrayList<>();
        List<String> industryList = new ArrayList<>();
        industryList = tbProductLandmarkMapper.selectIndustry();
        if (industryList != null){
            for (int i=0;i<industryList.size();i++){
                Map<String,Object> map = new HashMap<>();
                String industry = industryList.get(i);
                map.put("index",i);
                map.put("industry",industry);
                List<String> typeList = new ArrayList<>();
                typeList = tbProductLandmarkMapper.selectTypeByIndustry(industry);
                map.put("type",typeList);
                list.add(map);
            }
        }
        return list;
    }*/
    @Override
    public List<Map<String,Object>> getShanxiMap() {
        List<Map<String,Object>> list = new ArrayList<>();
        List<String> cityList = new ArrayList<>();

        TbAdministrativeAreaExample administrativeAreaExample = new TbAdministrativeAreaExample();
        administrativeAreaExample.createCriteria().andIsdeleteEqualTo(0);
        List<TbAdministrativeArea> administrativeAreas = tbAdministrativeAreaMapper.selectByExample(administrativeAreaExample);
        QueryResult queryResult = new QueryResult();
        queryResult.setList(administrativeAreas);

        return list;
        //return new QueryResponseResult(CommonCode.SUCCESS, queryResult);


        /*//返回结果集
        List<Map<String,Object>> list = new ArrayList<>();
        List<String> cityList = new ArrayList<>();
        cityList = tbProductLandmarkMapper.selectCity();
        if (cityList != null){
            for (int i=0;i<cityList.size();i++){
                Map<String,Object> map = new HashMap<>();
                String city = cityList.get(i);
                map.put("index",i);
                map.put("industry",city);
                List<String> countyList = new ArrayList<>();
                countyList = tbProductLandmarkMapper.selectCountyByCity(city);
                map.put("county",countyList);
                list.add(map);
            }
        }
        return list;*/
    }

    @Override
    public Map<String, Object> getList(Map searchMap) {
        //返回页面结果集
        Map<String,Object> map = new HashMap<>();
        TbProductLandmarkExample tbProductLandmarkExample = new TbProductLandmarkExample();
        String industry = "";
        String type = "";
        String city = "";
        String county = "";
        String year = "";
        String keywords = "";
        if (searchMap.get("selectIndustry") != null){
           industry = searchMap.get("selectIndustry").toString();
        }
        if (searchMap.get("selectType") != null){
            type = searchMap.get("selectType").toString();
        }
        if (searchMap.get("selectCity") != null){
            city = searchMap.get("selectCity").toString();
        }
        if (searchMap.get("selectCounty") != null){
            county = searchMap.get("selectCounty").toString();
        }
        if (searchMap.get("selectYear") != null){
            year = searchMap.get("selectYear").toString();
        }
        if (searchMap.get("keywords") != null){
            keywords = searchMap.get("keywords").toString();
        }

        /*if (!"".equals(industry)){
            tbProductLandmarkExample.createCriteria().andIndustryEqualTo(industry);
        }
        if (!"".equals(type)){
            tbProductLandmarkExample.createCriteria().andTypeEqualTo(type);
        }
        if (!"".equals(city)){
            tbProductLandmarkExample.createCriteria().andCityEqualTo(city);
        }
        if (!"".equals(county)){
            tbProductLandmarkExample.createCriteria().andCountyEqualTo(county);
        }
        if (!"".equals(year)){
            tbProductLandmarkExample.createCriteria().andRegisterYearEqualTo(year);
        }*/
        PageHelper.startPage(Integer.parseInt(searchMap.get("pageNo").toString()),Integer.parseInt(searchMap.get("pageSize").toString()));
        Page<TbProductLandmark> page = (Page<TbProductLandmark>)tbProductLandmarkMapper.getList(industry,type,city,county,year,keywords);
        System.out.println(page.getPages());
        map.put("rows",page.getResult());
        map.put("totalPages", page.getPages());
        map.put("total",page.getTotal());
        return map;
    }
}
