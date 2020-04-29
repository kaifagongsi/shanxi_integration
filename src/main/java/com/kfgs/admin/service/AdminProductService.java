package com.kfgs.admin.service;

import com.kfgs.domain.ext.TbProductExt;
import com.kfgs.domain.response.QueryResponseResult;

import java.util.Map;

public interface AdminProductService {
    public QueryResponseResult adminProductListLoad(Map map);

    public QueryResponseResult addProduct(TbProductExt tbProductExt);

    QueryResponseResult getSelectMap();
}
