package com.kfgs.statistics.controller;

import com.kfgs.domain.response.QueryResponseResult;
import com.kfgs.statistics.service.AdministrativeAreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <H3>shanxi</H3>
 * <p>地区管理的控制层类</p>
 *
 * @author : 你的名字
 * @date : 2019-12-02 17:25
 */
@RestController
@RequestMapping("/area")
public class AdministrativeAreaController {

    @Autowired
    private AdministrativeAreaService administrativeAreaService;


    @GetMapping("/selectByParentId")
    public QueryResponseResult selectByParentId(String id){
        return administrativeAreaService.findListByParentId(id);
    }


    @GetMapping("/selectAll")
    public QueryResponseResult selectAll(){
        return administrativeAreaService.findAll();
    }


}
