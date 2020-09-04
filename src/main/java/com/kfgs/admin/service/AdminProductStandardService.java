package com.kfgs.admin.service;

import com.kfgs.domain.TbStandard;
import com.kfgs.domain.response.QueryResponseResult;

public interface AdminProductStandardService {
    QueryResponseResult getProductStandardInfo(String id);

    QueryResponseResult saveProductStandard(TbStandard tbStandard);

    QueryResponseResult deleteProductStandard(String id);
}
