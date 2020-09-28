package com.kfgs.admin.service;

import com.kfgs.domain.response.QueryResponseResult;

import java.util.Map;

public interface AdminLandmarkService {

    public QueryResponseResult adminLandmarkListLoad(Map map);

    public int saveLandmark(Map landmarkEntity);

    QueryResponseResult getSelectMap();

    Map<String,Object>  initByProductNumber(Map pData);

}
