package com.kfgs.mapper;

import com.kfgs.domain.TbPolicyDocument;
import com.kfgs.domain.TbPolicyDocumentExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TbPolicyDocumentMapper {
    int countByExample(TbPolicyDocumentExample example);

    int deleteByExample(TbPolicyDocumentExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TbPolicyDocument record);

    int insertSelective(TbPolicyDocument record);

    List<TbPolicyDocument> selectByExampleWithBLOBs(TbPolicyDocumentExample example);

    List<TbPolicyDocument> selectByExample(TbPolicyDocumentExample example);

    TbPolicyDocument selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TbPolicyDocument record, @Param("example") TbPolicyDocumentExample example);

    int updateByExampleWithBLOBs(@Param("record") TbPolicyDocument record, @Param("example") TbPolicyDocumentExample example);

    int updateByExample(@Param("record") TbPolicyDocument record, @Param("example") TbPolicyDocumentExample example);

    int updateByPrimaryKeySelective(TbPolicyDocument record);

    int updateByPrimaryKeyWithBLOBs(TbPolicyDocument record);

    int updateByPrimaryKey(TbPolicyDocument record);
}