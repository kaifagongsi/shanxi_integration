package com.kfgs.firstweb.service;

import java.util.Map;

public interface UploadService {

    public String updateByExampleSelective(Map pData);

    Map<String,Object>  selectByPrimaryKey(Map pData);

    /*public void insertByExampleSelective(Map pData);*/
}
