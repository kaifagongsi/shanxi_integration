package com.kfgs.proclamation.service;

import com.kfgs.domain.TbProtectionNotice;

import java.util.List;
import java.util.Map;

public interface ProclamtionService {
    public String text();

    public Map<String,List<TbProtectionNotice>> getList();

    public List<TbProtectionNotice> getList(int page);

    public Map<String,Object> search(Map searchMap);


    public Map<String,Object> getList(Map searchMap);

    public int updateByExampleSelective(Map pData);

    Map<String,Object>  selectByPrimaryKey(Map pData);


}
