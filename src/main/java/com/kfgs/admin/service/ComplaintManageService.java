package com.kfgs.admin.service;


import java.util.List;
import java.util.Map;

public interface ComplaintManageService {
    public Map<String,Object> getFinishList(Map searchMap);
    public Map<String,Object> getTodoList(Map searchMap);
    public int updateByExample(Map pData);
    public int insertByExample(Map pData);
    public int deleteByExample(List idList);
    public int showByExample(List showIdList);
}
