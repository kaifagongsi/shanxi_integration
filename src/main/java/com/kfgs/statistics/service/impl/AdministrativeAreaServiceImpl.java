package com.kfgs.statistics.service.impl;

import com.kfgs.domain.TbAdministrativeArea;
import com.kfgs.domain.TbAdministrativeAreaExample;
import com.kfgs.domain.TbProductLandmark;
import com.kfgs.domain.TbProductLandmarkExample;
import com.kfgs.mapper.TbAdministrativeAreaMapper;
import com.kfgs.domain.response.CommonCode;
import com.kfgs.domain.response.QueryResponseResult;
import com.kfgs.domain.response.QueryResult;
import com.kfgs.statistics.service.AdministrativeAreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * <H3>shanxi</H3>
 * <p>获取地区</p>
 *
 * @author : 你的名字
 * @date : 2019-12-02 15:27
 */
@Service
@Transactional
public class AdministrativeAreaServiceImpl implements AdministrativeAreaService {


    @Autowired
    TbAdministrativeAreaMapper tbAdministrativeAreaMapper;

    @Override
    public QueryResponseResult findAll() {
        TbAdministrativeAreaExample administrativeAreaExample = new TbAdministrativeAreaExample();
        administrativeAreaExample.createCriteria().andIsdeleteEqualTo(0);
        List<TbAdministrativeArea> administrativeAreas = tbAdministrativeAreaMapper.selectByExample(administrativeAreaExample);
        QueryResult queryResult = new QueryResult();
        queryResult.setList(administrativeAreas);
        return new QueryResponseResult(CommonCode.SUCCESS, queryResult);
    }

    /**
     * @param parentId 父类id
     * @return
     */
    @Override
    public QueryResponseResult findListByParentId(String parentId) {
        TbAdministrativeAreaExample selectByExample = new TbAdministrativeAreaExample();
        TbAdministrativeAreaExample.Criteria criteria = selectByExample.createCriteria();
        criteria.andParentIdEqualTo(parentId).andIsdeleteEqualTo(0);
        List<TbAdministrativeArea> list = tbAdministrativeAreaMapper.selectByExample(selectByExample);
        QueryResult queryResult = new QueryResult();
        queryResult.setList(list);
        return new QueryResponseResult(CommonCode.SUCCESS, queryResult);
    }

    @Override
    public List<TbAdministrativeArea> findListLikePath(String path) {
        return null;
    }


}
