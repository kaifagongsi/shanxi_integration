package com.kfgs.admin.service.impl;

import com.kfgs.admin.service.AdminUserService;
import com.kfgs.domain.ext.TbUserExt;
import com.kfgs.domain.response.CommonCode;
import com.kfgs.domain.response.QueryResponseResult;
import com.kfgs.domain.response.QueryResult;
import com.kfgs.mapper.TbUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * Date: 2020-05-07-10-28
 * Module:
 * Description:
 *
 * @author:
 */
@Service
public class AdminUserServiceImpl implements AdminUserService {

    @Autowired
    TbUserMapper tbUserMapper;

    @Override
    public QueryResponseResult getLoginUser(){
        Map resultMap = new HashMap();
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (!(authentication instanceof AnonymousAuthenticationToken)) {
            String currentUserName = authentication.getName();
            resultMap.put("user",currentUserName);
        }
        QueryResult queryResult = new QueryResult();
        queryResult.setMap(resultMap);
        return new QueryResponseResult(CommonCode.SUCCESS,queryResult);
    }

    @Override
    public QueryResponseResult checkOldPassword(String username,String oldPassword) {
        TbUserExt tbUserExt = tbUserMapper.selectByName(username);
        //密码解密
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        //将未经过加密的密码和已经过加密的密码传进去进行判断，返回布尔值。
        boolean matches = passwordEncoder.matches(oldPassword, tbUserExt.getPassword());
        Map resultMap = new HashMap();
        resultMap.put("oldPasswordFlag",matches);
        QueryResult queryResult = new QueryResult();
        queryResult.setMap(resultMap);
        return new QueryResponseResult(CommonCode.SUCCESS,queryResult);
    }

    @Override
    public QueryResponseResult changePassword(String username, String newPassword) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String password = passwordEncoder.encode(newPassword);
        int i = tbUserMapper.updatePasswordByName(password,username);
        if( i == 1){
            return new QueryResponseResult(CommonCode.SUCCESS,null);
        }else{
            return new QueryResponseResult(CommonCode.FAIL,null);
        }
    }
}
