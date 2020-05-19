package com.kfgs.firstweb.service;

import com.kfgs.domain.response.QueryResponseResult;

import java.util.Map;

public interface UploadService {

    public String updateByExampleSelective(Map pData);

    Map<String,Object>  selectByPrimaryKey(Map pData);

    QueryResponseResult saveShanXiProductInfo(Map pData);

    /*public void insertByExampleSelective(Map pData);*/
}
