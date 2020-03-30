package com.kfgs.firstweb.service;

import java.util.Map;

public interface SydbqyService {

    public String text();

    public Map<String,Object> getList(Map searchMap);
}
