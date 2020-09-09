package com.kfgs.trademake.service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.kfgs.domain.TbGeographicalIndicationTrademark;
import com.kfgs.domain.TbGeographicalIndicationTrademarkExample;
import com.kfgs.domain.TbProtectionNotice;
import com.kfgs.domain.response.CommonCode;
import com.kfgs.domain.response.QueryResponseResult;
import com.kfgs.domain.response.QueryResult;
import com.kfgs.mapper.TbGeographicalIndicationTrademarkMapper;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class TrademarkService {

    @Autowired
    TbGeographicalIndicationTrademarkMapper tbGeographicalIndicationTrademarkMapper;

    public QueryResponseResult searchInit(Map map) {
        TbGeographicalIndicationTrademarkExample tbGeographicalIndicationTrademarkExample =new TbGeographicalIndicationTrademarkExample();
        String type = map.get("searchType").toString();
        String value = map.get("searchVal").toString();
        if(StringUtils.isNotBlank(value)){
            switch (type){
                case "0" :
                    break;
                case "1":
                    tbGeographicalIndicationTrademarkExample.createCriteria().andTradeNameLike("%" +  value + "%" );
                    break;
                case "2":
                    tbGeographicalIndicationTrademarkExample.createCriteria().andTrademarkTypeLike("%" +  value + "%");
                    break;
                case "3":
                    tbGeographicalIndicationTrademarkExample.createCriteria().andChineseNameOfRegisrantLike("%" +  value + "%");
                    break;
                case "4":
                    tbGeographicalIndicationTrademarkExample.createCriteria().andRegistrationNumberLike("%" +  value + "%");
                    break;
                case "5":
                    tbGeographicalIndicationTrademarkExample.createCriteria().andInternationalClassificationEqualTo(Integer.parseInt(value));
                    break;
                case "6":
                    tbGeographicalIndicationTrademarkExample.createCriteria().andChineseAddressOfRegistrantLike("%" +  value + "%");
                    break;
                case "7":
                    tbGeographicalIndicationTrademarkExample.createCriteria().andNameOfAgencyLike("%" +  value + "%");
                    break;
                case "8":
                    tbGeographicalIndicationTrademarkExample.createCriteria().andIssueNumOfPreliminaryExaminationAnnouncementEqualTo(Integer.parseInt(value));
                    break;
                case "9":
                    tbGeographicalIndicationTrademarkExample.createCriteria().andRegeistrationNoticeIssueNoEqualTo(Integer.parseInt(value));
                    break;
            }
        }
        PageHelper.startPage((Integer)map.get("pageNo"),(Integer)map.get("pageSize"));
        Page<TbGeographicalIndicationTrademark> page = (Page<TbGeographicalIndicationTrademark>) tbGeographicalIndicationTrademarkMapper.selectByExample(tbGeographicalIndicationTrademarkExample);
        QueryResult queryResult = new QueryResult();
        Map resultMap = new HashMap();
        resultMap.put("list",page.getResult());
        resultMap.put("total",page.getTotal());
        resultMap.put("totalPages",page.getPages());
        queryResult.setMap(resultMap);
        return new QueryResponseResult(CommonCode.SUCCESS,queryResult);
    }
}
