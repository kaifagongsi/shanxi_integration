package com.kfgs.firstweb.service;

import java.util.Map;

public interface UploadService {

    public int updateByExampleSelective(Map pData);

    Map<String,Object>  selectByPrimaryKey(Map pData);

    /*public void insertByExampleSelective(Map pData);*/
}
