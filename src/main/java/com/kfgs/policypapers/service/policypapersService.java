package com.kfgs.policypapers.service;

import com.kfgs.domain.TbPolicyDocument;

import java.util.List;
import java.util.Map;

public interface policypapersService {

    public Map<String, List<TbPolicyDocument>> getList();

    public Map<String,Object> getList(Map searchMap);

    public int updateByExampleSelective(Map pData);

    Map<String,Object>  selectByPrimaryKey(Map pData);

}
