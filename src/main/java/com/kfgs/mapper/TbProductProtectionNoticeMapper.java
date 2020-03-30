package com.kfgs.mapper;

import com.kfgs.domain.TbProductProtectionNotice;
import com.kfgs.domain.TbProductProtectionNoticeExample;
import com.kfgs.domain.TbProtectionNotice;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TbProductProtectionNoticeMapper {
    int countByExample(TbProductProtectionNoticeExample example);

    int deleteByExample(TbProductProtectionNoticeExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TbProductProtectionNotice record);

    int insertSelective(TbProductProtectionNotice record);

    List<TbProductProtectionNotice> selectByExample(TbProductProtectionNoticeExample example);

    TbProductProtectionNotice selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TbProductProtectionNotice record, @Param("example") TbProductProtectionNoticeExample example);

    int updateByExample(@Param("record") TbProductProtectionNotice record, @Param("example") TbProductProtectionNoticeExample example);

    int updateByPrimaryKeySelective(TbProductProtectionNotice record);

    int updateByPrimaryKey(TbProductProtectionNotice record);

    List<TbProtectionNotice> selectGongGaoTitleByProducrId(@Param("productId") String productId);
}