package com.kfgs.admin.service;

import com.kfgs.domain.ext.TbProductExt;
import com.kfgs.domain.response.QueryResponseResult;

import java.util.Map;

public interface AdminProductService {
    public QueryResponseResult adminProductListLoad(Map map);

    public QueryResponseResult addProduct(TbProductExt tbProductExt);

    QueryResponseResult getSelectMap();

    QueryResponseResult getProductByProductId(String id);

    QueryResponseResult getProductContentByProductId(String id);

    QueryResponseResult deleteProduct(String id);
}
