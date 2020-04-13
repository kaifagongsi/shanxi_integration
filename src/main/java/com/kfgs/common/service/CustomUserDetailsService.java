package com.kfgs.common.service;

import com.kfgs.domain.TbUser;
import com.kfgs.domain.ext.TbUserExt;
import com.kfgs.mapper.TbUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Date: 2020-04-13-13-49
 * Module:
 * Description:
 *
 * @author:
 */
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    TbUserMapper tbUserMapper;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        System.out.println("进过认证类："+s);
        TbUserExt user = tbUserMapper.selectByName(s);
        List<GrantedAuthority> list = new ArrayList();
        list.add(new SimpleGrantedAuthority(user.getType()));
        user.setAuthorities(list);
        return user;
    }
}
