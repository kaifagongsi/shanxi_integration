package com.kfgs.admin.service;

import java.util.List;
import java.util.Map;

public interface ClassficationService {
    public Map<String,Object> getCountryClassList(Map searchMap);
    public Map<String,Object> getShanxiClassList(Map searchMap);
    public int addShanxiClass(String name,String path,String id);
    public int addCountryClass(String name,String path,String id);
    public String updateCountryClass(Map editClass);
    public String updateShanxiClass(Map editClass);
    public int deleteShanxi(List idList);
    public int deleteCountry(List idList);
}
