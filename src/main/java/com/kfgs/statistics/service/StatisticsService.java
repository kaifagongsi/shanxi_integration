package com.kfgs.statistics.service;

import com.kfgs.domain.response.QueryResponseResult;

import java.util.Map;

public interface StatisticsService {
    /**
     * 统计返回产品是省的有多少个，统计返回产品是市的有多少个，统计返回产品是区的有多少个。
     * @return
     */
    public QueryResponseResult getPieChart();

    /**
     * 查询折线图
     * 地标产品批准年度统计
     */
    public QueryResponseResult getLineChartByYear();


    /**
     * 查询折线图
     * 用标企业核准年度统计
     */
    public QueryResponseResult getLineChartByEnterpriseYear();


    /**
     * 查询柱状图
     * @param areaId  地区ID
     * @param approvalYear  产品批准年度
     * @param classificationId 分类id
     * @return
     */
    public QueryResponseResult getProductHistogram(String areaId, String approvalYear, String classificationId);

    /**
     * 查询方块图数据
     */
    public  QueryResponseResult getFangKuaiDate();

    /**
     * 查询第二个标签页的数据，初始化
     * @return
     */
    public QueryResponseResult getSecondTabInit();

    /**
     * 第二个标签页中的 搜索
     * @param map
     * @return
     */
    public QueryResponseResult getSecondTabSearch(Map map);

    /**
     * 第三个标签初始化操作
     */
    public QueryResponseResult getThridTabInit();


    public QueryResponseResult getThridTabSearch(Map map);

    public  QueryResponseResult getSecondList(String pageNo, Map map);

    QueryResponseResult getCountNum();

}
