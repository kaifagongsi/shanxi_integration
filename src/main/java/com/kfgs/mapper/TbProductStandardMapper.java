package com.kfgs.mapper;

import com.kfgs.domain.TbStandard;
import com.kfgs.domain.TbStandardExample;

import java.util.List;

public interface TbProductStandardMapper {

    List<TbStandard> selectByExample(TbStandardExample tbStandardExample);
}
