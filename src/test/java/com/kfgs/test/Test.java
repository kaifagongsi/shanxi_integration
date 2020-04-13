package com.kfgs.test;

import com.kfgs.mapper.TbUserMapper;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Date: 2020-04-13-14-13
 * Module:
 * Description:
 *
 * @author:
 */
@RunWith(SpringJUnit4ClassRunner.class) //表示继承了SpringJUnit4ClassRunner类
@ContextConfiguration(locations = { "classpath:spring/spring-*.xml","classpath:spring/applicationContext-*.xml" })
public class Test {

    @Autowired
    TbUserMapper tbUserMapper;

    @org.junit.Test
    public void updatePassword(){
        //密码加密
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String password = passwordEncoder.encode("123456");
        int i = tbUserMapper.updatePasswordById(1,password);
        System.out.println(i);
    }


}
