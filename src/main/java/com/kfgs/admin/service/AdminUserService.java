package com.kfgs.admin.service;

import com.kfgs.domain.response.QueryResponseResult;

public interface AdminUserService {

    QueryResponseResult getLoginUser();

    QueryResponseResult checkOldPassword(String username,String oldPassword);

    QueryResponseResult changePassword(String username, String newPassword);

}
