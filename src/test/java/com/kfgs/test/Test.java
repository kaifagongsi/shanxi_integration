package com.kfgs.test;

import com.kfgs.mapper.TbUserMapper;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
        int i = tbUserMapper.updatePasswordById(2,password);
        System.out.println(i);
    }

    @org.junit.Test
    public void TestStringFormat(){
        int youNumber = 1;

        // 0 代表前面补充0

        // 4 代表长度为4

        // d 代表参数为正数型

        String str = String.format("%04d", youNumber);

        System.out.println(str); // 0001
    }
    @org.junit.Test
    public void distinctListObject() {
        List<People> listPeople = new ArrayList<People>();
        listPeople.add(new People("张三", 1, "13355556666", 23, "新员工"));
        listPeople.add(new People("张三", 2, "15522223333", 23, "老员工"));
        listPeople.add(new People("李四", 3, "13355556666", 23, "实习生"));
        listPeople.add(new People("提莫", 4, "13311112222", 23, "经理"));
        listPeople.add(new People("张三", 5, "13355556666", 23, "会计"));
        listPeople.add(new People("德玛", 6, "3344", 23, "开发"));
        listPeople.add(new People("卡特", 7, "13355556666", 23, "测试"));
        listPeople.add(new People("提莫", 8, "13355556666", 23, "美工"));
        listPeople.add(new People("提莫", 9, "13311112222", 23, "实施"));
        listPeople.add(new People("卡兹克", 10, "13356786666", 23, "售前"));
        listPeople.add(new People("亚索", 11, "13355556666", 23, "销售"));

        Set<People> setData = new HashSet<People>();
        setData.addAll(listPeople);

        System.out.println("list- size----" + listPeople.size());
        System.out.println("list-----" + listPeople.toString());

        System.out.println("set- size----" + setData.size());
        System.out.println("set-----" + setData.toString());

        for (People pp : setData) {
            System.out.println("p--" + pp.toString());

        }

    }
}
