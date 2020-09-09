package com.kfgs.trademake.controller;

import com.kfgs.domain.response.QueryResponseResult;
import com.kfgs.trademake.service.TrademarkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/trademark")
public class TrademarkController {

    @Autowired
    TrademarkService trademarkService;

    @PostMapping("/search")
    public QueryResponseResult searchInit(@RequestBody Map map){
        return trademarkService.searchInit(map);
    }
}

