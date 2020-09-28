package com.kfgs.admin.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.kfgs.admin.service.AdminLandmarkService;
import com.kfgs.domain.TbAdministrativeArea;
import com.kfgs.domain.TbAdministrativeAreaExample;
import com.kfgs.domain.TbProductLandmark;
import com.kfgs.domain.TbProductLandmarkExample;
import com.kfgs.domain.response.CommonCode;
import com.kfgs.domain.response.QueryResponseResult;
import com.kfgs.domain.response.QueryResult;
import com.kfgs.mapper.TbAdministrativeAreaMapper;
import com.kfgs.mapper.TbProductLandmarkMapper;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.ParseException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class AdminLandmarkServiceImpl implements AdminLandmarkService {

    @Autowired
    TbProductLandmarkMapper tbProductLandmarkMapper;

    @Autowired
    TbAdministrativeAreaMapper tbAdministrativeAreaMapper;

    @Override
    public QueryResponseResult adminLandmarkListLoad(Map map) {
        Map<String,Object> resultMap = new HashMap<>();
        TbProductLandmarkExample tbProductLandmarkExample = new TbProductLandmarkExample();
        PageHelper.startPage(Integer.parseInt(map.get("pageNo").toString()),Integer.parseInt(map.get("pageSize").toString()));
        Page<TbProductLandmark> page = (Page<TbProductLandmark>)tbProductLandmarkMapper.selectByExample(tbProductLandmarkExample);
        //Page<TbProductLandmark> page  = (Page<TbProductLandmark> )tbProductLandmarkMapper.selectAdminLandmarkList();
        resultMap.put("rows",page.getResult());
        resultMap.put("totalPages", page.getPages());
        resultMap.put("total",page.getTotal());
        QueryResult queryResult = new QueryResult();
        queryResult.setMap(resultMap);
        QueryResponseResult queryResponseResult = new QueryResponseResult(CommonCode.SUCCESS,queryResult);
        return queryResponseResult;
    }

    @Override
    public int saveLandmark(Map landmarkEntity) {
        int returnResult = 0;
        TbProductLandmark tbProductLandmark = new TbProductLandmark();
        if (landmarkEntity.get("productName") == null || "".equals(landmarkEntity.get("productName").toString())){
            return returnResult;
        }
        if (landmarkEntity.get("productNumber") == null || "".equals(landmarkEntity.get("productNumber").toString())){
            return returnResult;
        }
        if (landmarkEntity.get("city") == null || "".equals(landmarkEntity.get("city"))){
            return returnResult;
        }
        if (landmarkEntity.get("county") == null || "".equals(landmarkEntity.get("county"))){
            return returnResult;
        }
        if (landmarkEntity.get("certificateHolder") == null || "".equals(landmarkEntity.get("certificateHolder"))){
            return returnResult;
        }
        if (landmarkEntity.get("registerYear") == null || "".equals(landmarkEntity.get("registerYear"))){
            return returnResult;
        }
        if (landmarkEntity.get("industry") == null || "".equals(landmarkEntity.get("industry"))){
            return returnResult;
        }
        if (landmarkEntity.get("type") == null || "".equals(landmarkEntity.get("type"))){
            return returnResult;
        }
        else try{
            //修改
            if (landmarkEntity.get("id") != "undefined" && landmarkEntity.get("id") != null && StringUtils.isNotBlank(ObjectUtils.toString(landmarkEntity.get("id"), ""))){
                tbProductLandmark.setId(Integer.parseInt(landmarkEntity.get("id").toString()));
                tbProductLandmark.setProductName(landmarkEntity.get("productName").toString());
                //tbProductLandmark.setProductNumber(landmarkEntity.get("productNumber").toString());
                tbProductLandmark.setCity(landmarkEntity.get("city").toString());
                tbProductLandmark.setCounty(landmarkEntity.get("county").toString());
                tbProductLandmark.setCertificateHolder(landmarkEntity.get("certificateHolder").toString());
                tbProductLandmark.setRegisterYear(landmarkEntity.get("registerYear").toString());
                tbProductLandmark.setIndustry(landmarkEntity.get("industry").toString());
                tbProductLandmark.setType(landmarkEntity.get("type").toString());
                tbProductLandmark.setContent(landmarkEntity.get("content").toString().getBytes());
                returnResult = tbProductLandmarkMapper.updateByPrimaryKeySelective(tbProductLandmark);
            }
            //新增
            else {
                tbProductLandmark.setProductName(landmarkEntity.get("productName").toString());
                tbProductLandmark.setProductNumber(landmarkEntity.get("productNumber").toString());
                tbProductLandmark.setCity(landmarkEntity.get("city").toString());
                tbProductLandmark.setCounty(landmarkEntity.get("county").toString());
                tbProductLandmark.setCertificateHolder(landmarkEntity.get("certificateHolder").toString());
                tbProductLandmark.setRegisterYear(landmarkEntity.get("registerYear").toString());
                tbProductLandmark.setIndustry(landmarkEntity.get("industry").toString());
                tbProductLandmark.setType(landmarkEntity.get("type").toString());
                tbProductLandmark.setContent(landmarkEntity.get("content").toString().getBytes());
                returnResult = tbProductLandmarkMapper.insertLandmark(tbProductLandmark);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return returnResult;
    }

    @Override
    public QueryResponseResult getSelectMap() {
        //查询农产品地理标志页面中的5个下拉列表
        Map resultMap = new HashMap();
        //1、获取行政区间市级别
        TbAdministrativeAreaExample adminExample = new  TbAdministrativeAreaExample();
        TbProductLandmarkExample productLandmarkExample = new TbProductLandmarkExample();

        adminExample.createCriteria().andParentIdEqualTo("610000").andIsdeleteEqualTo(0);
        List<TbAdministrativeArea> areas = tbAdministrativeAreaMapper.selectByExample(adminExample);
        resultMap.put("areasCityList",areas);

        /*//2、获取行政区间区县级别
        adminExample.clear();
        adminExample.createCriteria().andParentIdNotEqualTo("610000").andParentIdNotEqualTo("000000").andIsdeleteEqualTo(0);
        List<TbAdministrativeArea> areasCopuntyList = tbAdministrativeAreaMapper.selectByExample(adminExample);
        resultMap.put("areasCountyList",areasCopuntyList);*/

        //3、获取行业分类
        List<String> industryList = tbProductLandmarkMapper.selectIndustryList();
        resultMap.put("industryList",industryList);

        /*//4、获取所属分类
        List<String> typeList = tbProductLandmarkMapper.selectTypeList();
        resultMap.put("typeList",typeList);*/

        QueryResult queryResult = new QueryResult();
        queryResult.setMap(resultMap);
        return new QueryResponseResult(CommonCode.SUCCESS,queryResult);
    }

    @Override
    public Map<String, Object> initByProductNumber(Map pData) {
        Map<String,Object> map = new HashMap<>();
        if(pData.get("productNumber") != "undefined" && pData.get("productNumber") != null && StringUtils.isNotBlank(ObjectUtils.toString(pData.get("productNumber"), ""))  ){
            TbProductLandmark tbProductLandmark = tbProductLandmarkMapper.selectByProductNumber(pData.get("productNumber").toString());
            if(tbProductLandmark != null){
                if(tbProductLandmark.getContent() != null){
                    map.put("content",new String(tbProductLandmark.getContent()));
                }else {
                    map.put("content",new String("暂无数据"));
                }
            }
            map.put("id",tbProductLandmark.getId());
            map.put("productName",tbProductLandmark.getProductName());
            map.put("productNumber",tbProductLandmark.getProductNumber());
            map.put("city",tbProductLandmark.getCity());
            map.put("county",tbProductLandmark.getCounty());
            map.put("certificateHolder",tbProductLandmark.getCertificateHolder());
            map.put("registerYear",tbProductLandmark.getRegisterYear());
            map.put("industry",tbProductLandmark.getIndustry());
            map.put("type",tbProductLandmark.getType());
        }
        return map;
    }

}
