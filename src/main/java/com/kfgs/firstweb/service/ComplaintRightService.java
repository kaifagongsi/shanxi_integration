package com.kfgs.firstweb.service;

import java.util.Map;

public interface ComplaintRightService {

    public Map<String,Object> getList(Map searchMap);

    public int insertByExample(Map pData);
}
