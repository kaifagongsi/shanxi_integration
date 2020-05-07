package com.kfgs.mapper;

import com.kfgs.domain.TbUser;
import com.kfgs.domain.TbUserExample;
import com.kfgs.domain.ext.TbUserExt;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TbUserMapper {
    int countByExample(TbUserExample example);

    int deleteByExample(TbUserExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TbUser record);

    int insertSelective(TbUser record);

    List<TbUser> selectByExample(TbUserExample example);

    TbUser selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TbUser record, @Param("example") TbUserExample example);

    int updateByExample(@Param("record") TbUser record, @Param("example") TbUserExample example);

    int updateByPrimaryKeySelective(TbUser record);

    int updateByPrimaryKey(TbUser record);

    TbUserExt selectByName(String username);

    int  updatePasswordById(@Param("id") int id,@Param("password") String password);

    int updatePasswordByName(@Param("password") String password,@Param("username") String username);

}