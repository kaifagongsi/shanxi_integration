package com.kfgs.mapper;

import com.kfgs.domain.TbProtectionNotice;
import com.kfgs.domain.TbProtectionNoticeExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TbProtectionNoticeMapper {
    int countByExample(TbProtectionNoticeExample example);

    int deleteByExample(TbProtectionNoticeExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TbProtectionNotice record);

    int insertSelective(TbProtectionNotice record);

    List<TbProtectionNotice> selectByExampleWithBLOBs(TbProtectionNoticeExample example);

    List<TbProtectionNotice> selectByExample(TbProtectionNoticeExample example);

    TbProtectionNotice selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TbProtectionNotice record, @Param("example") TbProtectionNoticeExample example);

    int updateByExampleWithBLOBs(@Param("record") TbProtectionNotice record, @Param("example") TbProtectionNoticeExample example);

    int updateByExample(@Param("record") TbProtectionNotice record, @Param("example") TbProtectionNoticeExample example);

    int updateByPrimaryKeySelective(TbProtectionNotice record);

    int updateByPrimaryKeyWithBLOBs(TbProtectionNotice record);

    int updateByPrimaryKey(TbProtectionNotice record);

    public List<TbProtectionNotice> selectAll();
}