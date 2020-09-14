package com.kfgs.landmark.service;

import java.util.List;
import java.util.Map;

public interface ProductLandmarkService {

    public List<Map<String,Object>> getShanxiMap();

    public Map<String,Object> getList(Map searchMap);

}
