package com.kfgs.admin.service;

import com.kfgs.domain.TbGeographicalIndicationTrademark;
import com.kfgs.domain.response.QueryResponseResult;
import org.springframework.http.HttpRequest;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

public interface AdminTrademarkService {
    QueryResponseResult getList(Map searchMap);

    QueryResponseResult selectOne(String id);

    QueryResponseResult saveTrademark(MultipartFile file, TbGeographicalIndicationTrademark trademark, HttpServletRequest httpRequest);

    QueryResponseResult deleteTrademark(String id);
}
