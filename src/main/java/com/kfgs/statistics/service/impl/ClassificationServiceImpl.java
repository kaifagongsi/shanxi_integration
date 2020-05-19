package com.kfgs.statistics.service.impl;

import com.kfgs.domain.TbClassification;
import com.kfgs.domain.TbClassificationExample;
import com.kfgs.mapper.TbClassificationMapper;
import com.kfgs.statistics.service.ClassificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Date: 2019-12-04-19-59
 * <p>Module:</p>
 * <p>Description:</p>
 *
 * @author:
 */
@Service
@Transactional
public class ClassificationServiceImpl implements ClassificationService {

    @Autowired
    TbClassificationMapper tbClassificationMapper;

    //查找顶级分类
    @Override
    public List getFirstClassification() {
        TbClassificationExample slectExample = new TbClassificationExample();
        slectExample.createCriteria().andParentidEqualTo("0000").andIsdeleteEqualTo(0);
        List<TbClassification> tbClassifications = tbClassificationMapper.selectByExample(slectExample);
        return tbClassifications;
    }
}
