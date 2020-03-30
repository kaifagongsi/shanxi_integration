package com.kfgs.statistics.controller;

import com.kfgs.domain.response.QueryResponseResult;
import com.kfgs.domain.response.QueryResponseResult;
import com.kfgs.statistics.service.StatisticsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * <H3>shanxi</H3>
 * <p>统计分析控制层</p>
 *
 * @author : 你的名字
 * @date : 2019-12-03 14:38
 */
@RestController
@RequestMapping("/statistics")
public class StatisticsController {

    @Autowired
    StatisticsService statisticsService;




    /**
     * 饼状图
     * @return
     */
    @GetMapping("/pieChart")
    public QueryResponseResult getPieChart(){
        return statisticsService.getPieChart();
    }

    @GetMapping("/getBlock")
    public  QueryResponseResult getBlock(){
        return statisticsService.getFangKuaiDate();
    }

    /**
     * 折线图产品年度
     * @return QueryResponseResult
     */
    @GetMapping("/lineChartByYear")
    public QueryResponseResult getLineChart(){
        return statisticsService.getLineChartByYear();
    }

    /**
     *折线图统计批准年度
     * @return QueryResponseResult
     */
    @GetMapping("/lineChartByEnterpriseYear")
    public QueryResponseResult lineChartByEnterpriseYear(){
        return statisticsService.getLineChartByEnterpriseYear();
    }

    /**
     * 地标产品统计
     * @param areaId 行政区间id
     * @param approvalYear 批准年度
     * @param classificationId 分类id
     * @return  QueryResponseResult
     */
    @GetMapping("/getProductHistogram")
    public QueryResponseResult getProductHistogram(@RequestParam("areaId")String areaId, @RequestParam("approvalYear")String approvalYear, @RequestParam("classificationId")String classificationId){
        return statisticsService.getProductHistogram(areaId,approvalYear,classificationId);
    }

    //此方法需要修改web.xml中*.do 修改为/*
    //并开放静态资源
    /*@RequestMapping(value = "/testPathVariable.do/{id}")
    public QueryResponseResult getProductHistogram(@PathVariable("id")String areaId){
        System.out.println(areaId);
        return null;
    }*/





    @GetMapping("/secondTabInit")
    public  QueryResponseResult getSecondTabInit(   ){
        return statisticsService.getSecondTabInit();
    }


    @PostMapping("/secondTabSearch")
    public  QueryResponseResult getSecondTabSearch(@RequestBody Map map   ){
        return statisticsService.getSecondTabSearch(map);
    }


    @GetMapping("/thridTabInit")
    public QueryResponseResult thridTabInit(){
        return statisticsService.getThridTabInit();
    }

    @PostMapping("/thridTabSearch")
    public QueryResponseResult thridTabSearch(@RequestBody Map map){
        return statisticsService.getThridTabSearch(map);
    }

    @PostMapping("/getSecondList")
    public QueryResponseResult getSecondList(@RequestParam(value = "pageNo",defaultValue = "1") String pageNo, @RequestBody Map map ){
        System.out.println(pageNo + " " + map);
        return statisticsService.getSecondList(pageNo,map);
    }

}
