package com.kfgs.admin.service;

import com.kfgs.domain.ext.TbEnterpriseExt;
import com.kfgs.domain.response.QueryResponseResult;

import java.util.Map;

public interface AdminEnterpriseService {

    QueryResponseResult getEnterpriseList(Map map);

    QueryResponseResult getSelectEnterprise();

    QueryResponseResult addEnterprise(TbEnterpriseExt tbEnterpriseExt);
}
