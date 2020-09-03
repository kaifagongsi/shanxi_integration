package com.kfgs.standard.service;

import java.util.Map;

public interface ProductStandardService {

    public Map<String,Object> getList(Map searchMap);

    public Map<String,Object> getStandardInfo(String standardName);
}
