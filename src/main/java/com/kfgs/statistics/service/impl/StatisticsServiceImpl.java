package com.kfgs.statistics.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.kfgs.domain.*;
import com.kfgs.domain.ext.TbProductExt;
import com.kfgs.domain.response.CommonCode;
import com.kfgs.domain.response.QueryResponseResult;
import com.kfgs.domain.response.QueryResult;
import com.kfgs.mapper.TbAdministrativeAreaMapper;
import com.kfgs.mapper.TbClassificationMapper;
import com.kfgs.mapper.TbEnterpriseMapper;
import com.kfgs.mapper.TbProductMapper;
import com.kfgs.statistics.service.StatisticsService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.UnsupportedEncodingException;
import java.util.*;

/**
 * Date: 2019-12-04-14-16
 * <p>Module:</p>
 * <p>Description:</p>
 *
 * @author:
 */
@Service
@Transactional
public class StatisticsServiceImpl  implements StatisticsService {

    //两个map充当暂时缓存
    public Map productIdAndName = new HashMap<>();
    public Map enterpriseIdAndName = new HashMap<>();


    @Autowired
    TbProductMapper tbProductMapper;
    @Autowired
    TbAdministrativeAreaMapper tbAdministrativeAreaMapper;
    @Autowired
    TbEnterpriseMapper tbEnterpriseMapper;
    @Autowired
    TbClassificationMapper tbClassificationMapper;

    /**
     * 统计返回产品是省的有多少个，统计返回产品是市的有多少个，统计返回产品是区的有多少个。
     * 统计中第一个标签页中的饼状图。
     * @return
     */
    @Override
    public QueryResponseResult getPieChart() {
        //获取省的数量
        TbProductExample provinceExample = new TbProductExample();
        //由于知道陕西省的id所以直接使用了
        provinceExample.createCriteria().andAdministrativeAreaEqualTo("610000");
        List<TbProduct> tbProductsPovince = tbProductMapper.selectByExample(provinceExample);

        //获取各个市的数量。
        TbAdministrativeAreaExample administrativeAreaExample = new TbAdministrativeAreaExample();
        administrativeAreaExample.createCriteria().andLevelEqualTo(1);
        List<TbAdministrativeArea> areaCity = tbAdministrativeAreaMapper.selectByExample(administrativeAreaExample);
        //获取城市id
        List<String> cityId = new ArrayList<>();
        for ( TbAdministrativeArea area : areaCity){
            cityId.add(area.getCityId());
        }
        //获取所有cityId为list中的
        TbProductExample produceCityExample = new TbProductExample();
        produceCityExample.createCriteria().andAdministrativeAreaIn(cityId);
        List<TbProduct> tbProductsCity = tbProductMapper.selectByExample(produceCityExample);

        //获取各个县的数量。
        cityId.clear();
        administrativeAreaExample  = new TbAdministrativeAreaExample();
        administrativeAreaExample.createCriteria().andLevelEqualTo(2);
        areaCity = tbAdministrativeAreaMapper.selectByExample(administrativeAreaExample);
        //获取城市id
        for ( TbAdministrativeArea area : areaCity){
            cityId.add(area.getCityId());
        }

        //获取所有cityId为list中的
        produceCityExample.createCriteria().andAdministrativeAreaIn(cityId);
        List<TbProduct> tbProductsCounty = tbProductMapper.selectByExample(produceCityExample);

        Map map = new HashMap();
        map.put("pov",tbProductsPovince);
        map.put("city",tbProductsCity);
        map.put("country",tbProductsCounty);
        QueryResult queryResult = new QueryResult();
        queryResult.setMap(map);
        queryResult.setTotal(tbProductsCity.size()+tbProductsCounty.size()+tbProductsPovince.size());
        return new QueryResponseResult(CommonCode.SUCCESS, queryResult);
    }

    @Override
    public QueryResponseResult getLineChartByYear() {
        return new QueryResponseResult(CommonCode.FAIL, null);
    }

    @Override
    public QueryResponseResult getLineChartByEnterpriseYear() {
        return new QueryResponseResult(CommonCode.FAIL, null);
    }

    @Override
    public QueryResponseResult getProductHistogram(String areaId,String approvalYear,String classificationId) {
        //1.获取符合条件的数据
        List<TbProduct> list = getMeetACondition(areaId,approvalYear,classificationId);
        if(list != null  && list.size() >= 0){
            //2.处理获取到的产品，将其按照前台规则划分
            //区域 数量
            //年份 数量
            //产品分类数量
            List<Map<String,Map>> map = splitAsRequired(list);
            //3.返回数据
            QueryResult queryResult = new QueryResult();
            queryResult.setList(map);
            //queryResult.setMap(map);
            queryResult.setTotal(list.size());
            return new QueryResponseResult(CommonCode.SUCCESS,queryResult);
        }else{
            return new QueryResponseResult(CommonCode.FAIL,null);
        }

    }

    public List<TbProduct> getMeetACondition(String areaId, String approvalYear, String classificationId){
        //1.查询选中的行政区间下属的行政区间的位置
        TbAdministrativeAreaExample areaExampl = new TbAdministrativeAreaExample();
        areaExampl.createCriteria().andParentIdEqualTo(areaId);
        List<TbAdministrativeArea> administrativeAreaList = tbAdministrativeAreaMapper.selectByExample(areaExampl);
        List<String> areaList = new ArrayList<>();
        for(TbAdministrativeArea area : administrativeAreaList){
            areaList.add(area.getCityId());
        }
        //注意添加自己的
        areaList.add(areaId);
        //2查询分类的下属子类
        TbClassificationExample classificationExample = new TbClassificationExample();
        classificationExample.createCriteria().andParentidEqualTo(classificationId);
        List<TbClassification> classificationList = tbClassificationMapper.selectByExample(classificationExample);
        List<String> classIdList = new ArrayList<>();
        for(TbClassification classification : classificationList){
            classIdList.add(classification.getClassificationid());
        }
        classIdList.add(classificationId);

        try {
            approvalYear = new String(approvalYear.getBytes("iso8859-1"),"UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return null;
        }
        TbProductExample example = new TbProductExample();
        TbProductExample.Criteria criteria = example.createCriteria();
        //行政区间
        if(StringUtils.isNotBlank(areaId )){
            if(areaId.equals("000000") || areaId.equals("610000")){//全省
                // criteria.andAdministrativeAreaEqualTo(areaId);
            }else{
                criteria.andAdministrativeAreaIn(areaList);
            }
        }else{
            System.out.println("areaId（行政区间） 为空");
            return null;
        }
        //分类
        if(StringUtils.isNotBlank(classificationId) ){
            if(classificationId.equals("0000") ){//全部分类
                // criteria.andClassificationidEqualTo(classificationId);
            }else{
                criteria.andClassificationidIn(classIdList);
            }
        }else{
            System.out.println("classificationId（产品分类） 为空");
            return null;
        }
        //批准年度
        if(StringUtils.isNotBlank(approvalYear)){
            if(approvalYear.equals("全部")){
            }else{
                criteria.andApprovalYearEqualTo(approvalYear);
            }
        }
        //获取到当前条件下有多少产品
        List<TbProduct> list = tbProductMapper.selectByExample(example);
        return list;
    }

    /**
     * 处理获取到的产品，将其按照前台规则划分
     *   区域 数量
     *   年份 数量
     *   产品分类数量
     * @param list
     * @return
     */
    public List<Map<String,Map>> splitAsRequired(List<TbProduct> list){
        //int areaCount = 0,yearCount = 0,classificationCount = 0;
        Map<String,Integer> areaMap = new HashMap<>();
        Map<String,Integer> yearMap = new HashMap<>();
        Map<String,Integer> classificationMap = new HashMap<>();
        for(TbProduct product : list){
            //处理行政区域
            TbAdministrativeAreaExample example = new TbAdministrativeAreaExample();
            example.createCriteria().andCityIdEqualTo(product.getAdministrativeArea());
            List<TbAdministrativeArea> areas = tbAdministrativeAreaMapper.selectByExample(example);
            for(TbAdministrativeArea area : areas){
                String areaName = area.getName();
                if(areaMap.containsKey(areaName)){
                    //地区域第N次出现
                   areaMap.put(areaName,areaMap.get(areaName) + 1);
                }else{
                    //该区域第一次出现
                    areaMap.put(area.getName(),1);
                }

            }

            //处理产品年份
            String yearName = product.getApprovalYear();
            if(yearMap.containsKey(yearName)){
                System.out.println(yearMap.get(yearName));
                yearMap.put(yearName,yearMap.get(yearName) + 1);
            }else{
                yearMap.put(yearName,1);
            }

            //处理分类
            TbClassificationExample classificationexample = new TbClassificationExample();
            classificationexample.createCriteria().andClassificationidEqualTo(product.getClassificationid());
            List<TbClassification> classifications = tbClassificationMapper.selectByExample(classificationexample);
            for(TbClassification classification : classifications){
                String classificationName = classification.getName();
                if(classificationMap.containsKey(classificationName)){
                    classificationMap.put(classificationName,classificationMap.get(classificationName) + 1);
                }else {
                    classificationMap.put(classificationName,1);
                }
            }
        }
        List<Map<String,Map>> listMap = new ArrayList<>();
        Map<String,Map> map1 = new  HashMap<String, Map>();
        map1.put("area",areaMap);
        listMap.add(map1);
        Map<String,Map> map2 = new  HashMap<String, Map>();
        map1.put("year",yearMap);
        listMap.add(map2);
        Map<String,Map> map3 = new  HashMap<String, Map>();
        map1.put("classification",classificationMap);
        listMap.add(map3);
        return listMap;
    }

    //list 去重
    private List<String> repeatListWayTwo(List<String> list){
        //初始化HashSet对象，并把list对象元素赋值给HashSet对象
        HashSet set = new HashSet(list);
        //把List集合所有元素清空
        list.clear();
        //把HashSet对象添加至List集合
        list.addAll(set);
        return list;
    }

    /**
     * 功能描述:
     * 〈在企业列表中查找多个 符合条件的提企业〉
     *
     * @param tbEnterpriseList 企业列表
     * @param enterpriseId  企业的id
     * @return : java.util.Map
     * @author : lxl
     * @date : 2019/12/25 9:55
     */
    private Map findEnterpriseName(List<TbEnterprise> tbEnterpriseList, String enterpriseId) {
        Map map1 = new HashMap();
        //解析 enterpriseId 格式
        String str[] = enterpriseId.split("-");
        List<String> list = Arrays.asList(str);
        List<String> enterpriseName = new ArrayList();
        for(String s : list){
            enterpriseName.add(String.valueOf(enterpriseIdAndName.get(s)));
        }
        //组装map
        // List map =   new ArrayList();

        Map m2Count = new HashMap();
        m2Count.put("$count",1);
        for(String s : enterpriseName){
            Map m = new HashMap();
            m.put(s,m2Count);
            //  map.add(m);
            map1.putAll(m);
        }
        return map1;
    }

    /**
     * 功能描述:
     * 〈获取每个产品有哪些公司在做〉
     *  展示形式为：统计中第一个标签页中的方块图
     * @param
     * @return : com.kfgs.model.response.QueryResponseResult
     * @author : lxl
     * @date : 2019/12/25 9:44
     */
    @Override
    public QueryResponseResult getFangKuaiDate() {
        //1.设置产品对应的id和key（id为主键，key为产品名称）
        Map<Integer, Map> mapProduct = tbProductMapper.selectByIdAndName();
        for(Map.Entry<Integer,Map> m : mapProduct.entrySet()){
            String key = String.valueOf(m.getKey());
            String value = ((HashMap<String,String>)m.getValue()).get("name");
            productIdAndName.put(key,value);
        }
        //2.设置企业中的id和key（id为主键，key为企业名称）
        Map<Integer,Map> mapEnterprise = tbEnterpriseMapper.selectByIdAndName();
        for(Map.Entry<Integer,Map> m : mapEnterprise.entrySet()){
            enterpriseIdAndName.put(String.valueOf(m.getKey()),((HashMap<String,String>)m.getValue()).get("enterprise_name"));
        }

        //3.设置对应关系 （产品名称（key） 和 使用这个产品的企业名称（value）组装为map）
        //3..1设置对应关系 （产品id（key） 和 使用这个产品的企业id（value）组装为map）
        //查找企业和产品对应的id   没有用表中对应的产品名称和企业名称是担心后续再添加产品和企业关系时，没有添加
        List<TbEnterprise> tbEnterprises = tbEnterpriseMapper.selectByExample(null);
        List<String> productId_list = new ArrayList<>();
        List<String> enterpriseId_list = new ArrayList<>();
        Map<String,String> product_enterprise_map = new HashMap();
        for(TbEnterprise tbEnterpriseChart : tbEnterprises){
            String productStr = tbEnterpriseChart.getProductId().toString();
            String enterpriseStr = tbEnterpriseChart.getId().toString();
            productId_list.add(productStr);
            enterpriseId_list.add(enterpriseStr);
            //map中可能有重复的
            if(product_enterprise_map.containsKey(productStr)){
                product_enterprise_map.put(productStr,product_enterprise_map.get(productStr) +"-" + enterpriseStr );
            }else{
                product_enterprise_map.put(productStr,enterpriseStr);
            }
        }
        //在企业表中，查找企业
        List<TbEnterprise> tbEnterpriseList = tbEnterpriseMapper.selectByIdInList(enterpriseId_list);
        //在产品表中，查找产品
        //List<TbProduct> tbProductsList = tbProductMapper.selectByIdInList(productId_list);
        //组合map
        List<Map> mapList = new ArrayList<>();
        Map mapRetuen = new HashMap();
        //产品去重
        productId_list =repeatListWayTwo(productId_list);
        //3.2设置对应关系 （产品名称（key） 和 使用这个产品的企业名称（value）组装为map）
        for(String str : productId_list){
            //1找到productName
            String productName = productIdAndName.get(str).toString();
            if(!StringUtils.isNotBlank(productName)){
                return new QueryResponseResult(CommonCode.FAIL,null);
            }
            //2找到多个enterpriseId
            String enterpriseId = product_enterprise_map.get(str);
            //3获取多个enterpriseName
            Map  enterpriseName = findEnterpriseName(tbEnterpriseList,enterpriseId);
            Map map = new HashMap();
            map.put(productName,enterpriseName);
            mapRetuen.putAll(map);
        }
        QueryResult queryResult = new QueryResult();
        System.out.println(mapList);
        queryResult.setList(mapList);
        queryResult.setMap(mapRetuen);
        queryResult.setTotal(mapList.size());
        return new QueryResponseResult(CommonCode.SUCCESS,queryResult);
    }


    /**
     * 功能描述:
     * 〈初始化统计中第二个标签页中的下拉框中的内容〉
     *
     * @param
     * @return : com.kfgs.model.response.QueryResponseResult
     * @author : lxl
     * @date : 2019/12/25 9:46
     */
    @Override
    public QueryResponseResult getSecondTabInit() {
        //获取行政区域
        List<TbAdministrativeArea> administrativeAreas = tbAdministrativeAreaMapper.selectByExample(null);
        Map map = new HashMap();
        map.put("select",administrativeAreas);
        //查找批准年度
        List<String> approvalYear = tbProductMapper.selectDistinctProductApprovalYear();
        //处理list
        map.put("approvalYear",approvalYear);
        //查找顶级分类
        map.put("classifications",getClassifications());
        QueryResult queryResult = new QueryResult();
        queryResult.setMap(map);
        return new QueryResponseResult(CommonCode.SUCCESS,queryResult);
    }

    public List getClassifications(){
        TbClassificationExample slectExample = new TbClassificationExample();
        slectExample.createCriteria().andParentidEqualTo("0000");
        return tbClassificationMapper.selectByExample(slectExample);
    }

    /**
     * 功能描述:
     * 〈根据下拉框中的内容进行查询数据，返回柱状图、饼状图。折线图的信息（折线图不会根据年份数据变化），列表〉
     * 展示形式为：统计中第二个标签页中的柱状图、饼状图、折线图，以及列表
     * @param map 1
     * @return : com.kfgs.model.response.QueryResponseResult
     * @author : lxl
     * @date : 2019/12/25 9:47
     */
    @Override
    public QueryResponseResult getSecondTabSearch(Map map) {
        Map resultMap = new HashMap();
        QueryResult queryResult = new QueryResult();
        //1 获取柱状图信息
        Map histogramData = getHistogramData(map);
        if(histogramData == null || histogramData.size() <=0 ){
            return new QueryResponseResult(CommonCode.FAIL,null);
        }
        resultMap.putAll(histogramData);
        //2.获取面积图信息
        Map pieAreaData = getPieAreaData(map);
        if(pieAreaData == null || pieAreaData.size() <= 0 ){
            return new QueryResponseResult(CommonCode.FAIL,null);
        }
        resultMap.putAll(pieAreaData);
        //3.获取折线图数据
        Map lineChartByYear = getLineChartByYear(map);
        if(lineChartByYear == null || lineChartByYear.size()<=0){
            return new QueryResponseResult(CommonCode.FAIL,null);
        }
        resultMap.putAll(lineChartByYear);
        //4.获取列表数据
        Map listMap =  getListSecondTable(map);
        if(listMap == null || listMap.size() <= 0){
            return new QueryResponseResult(CommonCode.FAIL,null);
        }
        resultMap.putAll(listMap);
        queryResult.setMap(resultMap);
        return new QueryResponseResult(CommonCode.SUCCESS,queryResult);
    }

    /**
     * 功能描述:
     * 〈根据选中的条件查询符合条件的数据list〉
     * 第二个标签页中的table中数据
     * @param map 行政区域，分类 ，批准年度
     * @return : java.util.Map
     * @author : lxl
     * @date : 2019/12/25 15:10
     */
    private Map getListSecondTable(Map map) {
        Map mapResult = new HashMap();
        String area =  map.get("area").toString();
        String approvalYear = "全部".equals(map.get("approvalYear").toString()) ? "" : map.get("approvalYear").toString();
        String classification = "全部".equals(map.get("classification").toString()) ? "" : map.get("classification").toString();
        PageHelper.startPage(1,10);
        Page<TbProductExt> page = (Page<TbProductExt>) tbProductMapper.selectListSecondTableByExt(approvalYear, classification, area);
        mapResult.put("rows",page.getResult());
        mapResult.put("total",page.getTotal());
        mapResult.put("totalPages",page.getPages());
        return mapResult;
    }

    /**
     * 功能描述:
     * 〈根据选中的条件，查询折线图〉
     * 第二个标签页中的折线图中数据
     * @param map 行政区域，分类 ，批准年度
     * @return : java.util.Map
     * @author : lxl
     * @date : 2019/12/25 15:09
     */
    public Map getLineChartByYear(Map map){
        Map mapLineChartDate = new HashMap();
        String area =  map.get("area").toString();
        String classification = "全部".equals(map.get("classification").toString()) ? "" : map.get("classification").toString();
        List<Map> lineChartDate = tbProductMapper.selectLineChartByYear(classification, area);
        List<String> lineCharList = new ArrayList<>();
        List<String> lineCharCount = new ArrayList<>();
        for(Map<String,String> m : lineChartDate){
            for(Map.Entry<String,String> en : m.entrySet()){
                String name = en.getKey();
                if(name.equalsIgnoreCase("years")){
                    lineCharList.add(en.getValue());
                }else if(name.equalsIgnoreCase("count(1)")){
                    lineCharCount.add(en.getValue());
                }else{
                    return null;
                }
            }
        }
        mapLineChartDate.put("lineChar",lineCharList);
        mapLineChartDate.put("lineCharDate",lineCharCount);
        return mapLineChartDate;
    }

    /**
     * 功能描述:
     * 〈根据选中的条件，查询产品饼状图数据〉
     * 第二个标签页中的饼状图图中数据
     * @param map 行政区域，分类 ，批准年度
     * @return : java.util.Map
     * @author : lxl
     * @date : 2019/12/25 15:20
     */
    private Map getPieAreaData(Map map) {
        Map mapPieAreaData = new HashMap();
        String area = map.get("area").toString();
        String approvalYear = "全部".equals(map.get("approvalYear").toString()) ? "" : map.get("approvalYear").toString();
        String classification = "全部".equals(map.get("classification").toString()) ? "" : map.get("classification").toString();
        List<Map> pieAreaData = tbProductMapper.selectPieAreaData(approvalYear, classification, area);
        List<String> pieAreaList = new ArrayList();
        List<String> pieAreaCount = new ArrayList();
        for(Map<String,String> m : pieAreaData){
            for(Map.Entry<String,String> en : m.entrySet()){
                String name = en.getKey();
                if(name.equals("pieArea")){
                    String areaCode = en.getValue();
                    if(areaCode.length()==2){
                        areaCode = areaCode + "00";
                    }
                    pieAreaList.add(areaCode);
                }else if(name.equals("count(1)")){
                    pieAreaCount.add(en.getValue());
                }else{
                    return null;
                }
            }
        }
        List pieAreaNameList = new ArrayList();
        TbClassificationExample example = new TbClassificationExample();
        if(pieAreaList != null && pieAreaList.size() > 0){
            example.createCriteria().andClassificationidIn(pieAreaList);
        }
        List<TbClassification> tbClassifications = tbClassificationMapper.selectByExample(example);
        for(String  str : pieAreaList){
            String classificationName  = getClassificationName(tbClassifications,str);
            if(StringUtils.isNotBlank(classificationName)){
                pieAreaNameList.add(classificationName);
            }else{
                return null;
            }
        }
        //将两个list拼接为map
        mapPieAreaData.put("pieArea_area",pieAreaNameList);
        mapPieAreaData.put("pieArea_count",pieAreaCount);
        mapPieAreaData.put("pieArea_name_key",getMapFromTwoList(pieAreaNameList,pieAreaCount));
        return mapPieAreaData;
    }


    /**
     * 功能描述:
     * 〈根据选中的条件，查询柱状图数据〉
     *第二个标签页中的状图数据
     * @param map 行政区域，分类 ，批准年度
     * @return : java.util.Map
     * @author : lxl
     * @date : 2019/12/25 15:20
     */
    public Map getHistogramData(Map map){
        Map mapHistogram = new HashMap();
        String area = map.get("area").toString();
        String approvalYear = "全部".equals( map.get("approvalYear").toString()) ? "" : map.get("approvalYear").toString();

        String classification = "全部".equals(map.get("classification").toString()) ? "" : map.get("classification").toString();
        //1 查询柱状图数据
        List<Map> histogramList = tbProductMapper.selectHistogramByPro(approvalYear, classification, area);
        //List<TbProduct> tbProducts = tbProductMapper.selectByExample(example);
        //queryResult.setList(tbProducts);
        List<String> areaList = new ArrayList();
        List<String> areaCount = new ArrayList();
        for(Map<String,String> m : histogramList){
            for(Map.Entry<String,String> en : m.entrySet()){
                String name = en.getKey();
                if(name.equals("area")){
                    String areaCode = en.getValue();
                    if(areaCode.length()==4){
                        areaCode = areaCode + "00";
                    }
                    areaList.add(areaCode);
                }else if(name.equals("countNum")){
                    areaCount.add(en.getValue());
                }else{
                    return null;
                }
            }
        }
        //处理areaList
        List areaNameList = new ArrayList();
        TbAdministrativeAreaExample example = new TbAdministrativeAreaExample();
        if(areaList != null && areaList.size() > 0){
            example.createCriteria().andCityIdIn(areaList);
        }
        List<TbAdministrativeArea> administrativeAreaList = tbAdministrativeAreaMapper.selectByExample(example);
        for(String  str : areaList){
            String name  = getCityName(administrativeAreaList,str);
            if(StringUtils.isNotBlank(name)){
                areaNameList.add(name);
            }else{
                return null;
            }
        }
        mapHistogram.put("histogramList_area",areaNameList);
        mapHistogram.put("histogramList_count",areaCount);
        return  mapHistogram;
    }

    /**
     * 功能描述:
     * 〈将第一个list中为key 第二个list 为value值，组合为map返回〉
     *
     * @param key map中的key
     * @param value map 中的value
     * @return : java.util.List<java.util.Map>
     * @author : lxl
     * @date : 2019/12/25 15:07
     */
    public  List<Map> getMapFromTwoList(List key,List value){
        List list = new ArrayList();
        for(int i=0; i < key.size(); i++){
            Map map = new HashMap();
            map.put("name",key.get(i));
            map.put("value",value.get(i));
            list.add(map);
        }
        return  list;
    }

    private String getClassificationName(List<TbClassification> tbClassifications, String str) {
        for(TbClassification area : tbClassifications){
            if(area.getClassificationid().equals(str)){
                return  area.getName();
            }
        }
        return "";
    }

    //在实体中list中根据ID 查找cityName
    public String getCityName(List<TbAdministrativeArea> administrativeAreaList , String cityId){
        for(TbAdministrativeArea area : administrativeAreaList){
            if(area.getCityId().equals(cityId)){
                return  area.getName();
            }
        }
        return "";
    }

    /**
     * 功能描述:
     * 〈初始化 第三个标签页中 的选中条件〉
     *
     * @return : com.kfgs.model.response.QueryResponseResult
     * @author : lxl
     * @date : 2019/12/25 15:22
     */
    @Override
    public QueryResponseResult getThridTabInit() {
        //获取行政区域
        List<TbAdministrativeArea> administrativeAreas = tbAdministrativeAreaMapper.selectByExample(null);
        Map map = new HashMap();
        map.put("select",administrativeAreas);
        //查找企业批准年度
        List<String> approvalYear = tbEnterpriseMapper.selectDistinctEnterpriseApprovalYear();
        //处理list
        map.put("approvalYear",approvalYear);
        //查找顶级分类
        map.put("classifications",getClassifications());
        QueryResult queryResult = new QueryResult();
        queryResult.setMap(map);
        return new QueryResponseResult(CommonCode.SUCCESS,queryResult);
    }

    /**
     * 功能描述:
     *〈根据下拉框中的内容进行查询数据，返回柱状图、饼状图。折线图的信息（折线图不会根据年份数据变化）〉
     * 展示形式为：统计中第三个标签页中的柱状图、饼状图，以及折线图
     * @param map 1
     * @return : com.kfgs.model.response.QueryResponseResult
     * @author : lxl
     * @date : 2019/12/25 15:21
     */
    @Override
    public QueryResponseResult getThridTabSearch(Map map) {
        Map resultMap = new HashMap();
        QueryResult queryResult = new QueryResult();
        String area = map.get("area").toString();
        String classification = "全部".equals(map.get("classification").toString()) ? "" : map.get("classification").toString();
        String approvalYear = "全部".equals(map.get("approvalYear").toString()) ? "" : map.get("approvalYear").toString();
        //1处理柱状图数据
        Map histogramByProEnt = getHistogramByProEnt(approvalYear, classification, area);
        if(histogramByProEnt == null || histogramByProEnt.size() < 0){
            return new QueryResponseResult(CommonCode.FAIL,null);
        }
        resultMap.putAll(histogramByProEnt);
        //2 处理面积饼图数据
        Map pieAreaEnt = getPieAreaEnt(approvalYear, classification, area);
        if(pieAreaEnt == null || pieAreaEnt.size() < 0){
            return new QueryResponseResult(CommonCode.FAIL,null);
        }
        resultMap.putAll(pieAreaEnt);
        //3 折线图的数据
        Map lineMap = getLineChartByYearEnt(area,classification);
        resultMap.putAll(lineMap);

        queryResult.setMap(resultMap);
        return new QueryResponseResult(CommonCode.SUCCESS,queryResult);
    }

    /**
     * 功能描述:
     * 〈根据选中的条件， 获取用标企业柱状图数量〉
     * @param approvalYear 批准年度
     * @param classification 产品分类
     * @param area 行政区域
     * @return : java.util.Map
     * @author : lxl
     * @date : 2019/12/25 15:26
     */
    public Map getHistogramByProEnt(String approvalYear,String classification,String area){
        Map mapHistogram = new HashMap();
        List<Map> histogramByProEntList = tbEnterpriseMapper.selectHistogramByProEnt(approvalYear,classification,area);
        //1.获取柱状图
        //List<Map> histogramByProEntList = tbEnterpriseMapper.selectHistogramByProEnt(approvalYear, classification, area);
        System.out.println(histogramByProEntList);
        mapHistogram.put("histogramList",histogramByProEntList);
        List<String> areaList = new ArrayList();
        List<String> areaCount = new ArrayList();
        for(Map<String,String> m : histogramByProEntList){
            for(Map.Entry<String,String> en : m.entrySet()){
                String name = en.getKey();
                if(name.equalsIgnoreCase("area")){
                    String areaCode = en.getValue();
                    if(areaCode.length()==4){
                        areaCode = areaCode + "00";
                    }
                    areaList.add(areaCode);
                }else if(name.equalsIgnoreCase("countNum")){
                    areaCount.add(en.getValue());
                }else{
                    return null;
                }
            }
        }
        //处理areaList
        List areaNameList = new ArrayList();
        TbAdministrativeAreaExample example = new TbAdministrativeAreaExample();
        if(areaList != null && areaList.size() > 0){
            example.createCriteria().andCityIdIn(areaList);
        }
        List<TbAdministrativeArea> administrativeAreaList = tbAdministrativeAreaMapper.selectByExample(example);
        for(String  str : areaList){
            String name  = getCityName(administrativeAreaList,str);
            if(StringUtils.isNotBlank(name)){
                areaNameList.add(name);
            }else{
                return null;
            }
        }
        //判断是否为空
        if( areaNameList.size() <=0 || areaNameList == null){
            mapHistogram.put("histogramListEnt_area",null);
        }else{
            mapHistogram.put("histogramListEnt_area",areaNameList);
        }
        if( getAllIsZero(areaCount)){
            mapHistogram.put("histogramListEnt_count",null);
        }else{
            mapHistogram.put("histogramListEnt_count",areaCount);
        }
        return mapHistogram;
    }

    /**
     * 功能描述:
     * 〈判断list中的值是否都为0〉
     * @param list 需要判断的list
     * @return : java.lang.Boolean   true 表示全为0  false表示 不全为0；
     * @author : lxl
     * @date : 2019/12/25 15:43
     */
    public Boolean getAllIsZero(List<String> list){
        int i = 0;
        for(int j = 0; j < list.size(); j++){
            String s = String.valueOf(list.get(j));
            if("0".equalsIgnoreCase(s)){
                i = i + 1;
            }
        }
        if(i == list.size()){
            return true;
        }else{
            return false;
        }

    }

    /**
     * 功能描述:
     * 根据选中的条件， 获取企业饼状图数量〉
     * @param approvalYear 批准年度
     * @param classification 产品分类
     * @param area 行政区域
     * @return : java.util.Map
     * @author : lxl
     * @date : 2019/12/25 15:27
     */
    public Map getPieAreaEnt(String approvalYear,String classification,String area){
        Map mapPieAreaEnt = new HashMap();
        String classificaion = "";
        if(StringUtils.isNotBlank(classification)){
            classificaion = classification.substring(0,2);
        }

        //List<Map> mapList = tbEnterpriseMapper.selectPieAreaEnt(approvalYear, classificaion, area);
        List<Map> mapList = tbEnterpriseMapper.selectPieAreaEnt(approvalYear,classificaion,area);
        System.out.println(mapList);
        //[{count(1)=5, substr(t1={classification_id, 1, 2)=04}}, {count(1)=6, substr(t1={classification_id, 1, 2)=05}}, {count(1)=12, substr(t1={classification_id, 1, 2)=07}},
        // {count(1)=35, substr(t1={classification_id, 1, 2)=08}}, {count(1)=37, substr(t1={classification_id, 1, 2)=02}},
        // {count(1)=39, substr(t1={classification_id, 1, 2)=06}}, {count(1)=60, substr(t1={classification_id, 1, 2)=03}}]
        //解析list
        List<Map> pieMap = new ArrayList<>();
        List xDate = new ArrayList();
        List firstClassification = getFirstClassification();
        for(Map<String, String> map : mapList){
            Map linshiMap = new HashMap();
            for (Map.Entry<String, String> m : map.entrySet()) {
                String name = m.getKey();

                if(name.equalsIgnoreCase("countNum")){
                    linshiMap.put("value",m.getValue());
                }else if (name.equalsIgnoreCase("pieArea")){
                    name = getFirstClassificationName(firstClassification,m.getValue()+"00");
                    linshiMap.put("name",name);
                    xDate.add(name);
                }

            }
            pieMap.add(linshiMap);
        }
        mapPieAreaEnt.put("pirAreaxdata",xDate);
        mapPieAreaEnt.put("pirAreaydata",pieMap);
        System.out.println(mapPieAreaEnt);
        return  mapPieAreaEnt;
    }

    public String getFirstClassificationName(List<TbClassification> list, String  classificationId){
        for(TbClassification classification : list){
            if(classification.getClassificationid().equalsIgnoreCase(classificationId)){
                return classification.getName();
            }
        }
        return  "";
    }

    //查询顶级分类
    public List getFirstClassification() {
        TbClassificationExample slectExample = new TbClassificationExample();
        slectExample.createCriteria().andParentidEqualTo("0000");
        List<TbClassification> tbClassifications = tbClassificationMapper.selectByExample(slectExample);
        return tbClassifications;
    }

    //折线图
    public Map getLineChartByYearEnt(String area,String classification){
        Map mapLineChartDate = new HashMap();
        List<Map> lineChartDate = tbEnterpriseMapper.selectLineChartByYearEnt(classification, area);
        List<String> lineCharListEnt = new ArrayList<>();
        List<String> lineCharCountEnt = new ArrayList<>();
        for(Map<String,String> m : lineChartDate){
            for(Map.Entry<String,String> en : m.entrySet()){
                String name = en.getKey();
                if(name.equalsIgnoreCase("years")){
                    lineCharListEnt.add(en.getValue());
                }else if(name.equalsIgnoreCase("count(1)")){
                    lineCharCountEnt.add(en.getValue());
                }else{
                    return null;
                }
            }
        }
        mapLineChartDate.put("lineCharEnt",lineCharListEnt);
        mapLineChartDate.put("lineCharDateEnt",lineCharCountEnt);
        return mapLineChartDate;
    }

    @Override
    public QueryResponseResult getSecondList(String pageNo, Map map) {
        QueryResult queryResult = new QueryResult();
        Map resultMap = new HashMap();
        String area = map.get("area").toString();
        String approvalYear = map.get("approvalYear").toString();
        String classification = map.get("classification").toString();
        PageHelper.startPage(Integer.valueOf(pageNo),10);
        Page<TbProductExt> page = (Page<TbProductExt>) tbProductMapper.selectListSecondTableByExt(approvalYear, classification, area);
        resultMap.put("rows",page.getResult());
        resultMap.put("total",page.getTotal());
        resultMap.put("totalPages",page.getPages());
        queryResult.setMap(resultMap);
        return new QueryResponseResult(CommonCode.SUCCESS,queryResult);
    }

    @Override
    public QueryResponseResult getCountNum() {
        int productNum =  tbProductMapper.selectProductNum();
        int entNum = tbEnterpriseMapper.selectCountWeiBianGen();
        Map resultMap = new HashMap();
        resultMap.put("productNum",productNum);
        resultMap.put("entNum",entNum);
        QueryResult queryResult = new QueryResult();
        queryResult.setMap(resultMap);
        return new QueryResponseResult(CommonCode.SUCCESS,queryResult);
    }
}

