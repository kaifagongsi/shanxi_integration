package com.kfgs.domain.response;

import com.kfgs.domain.response.QueryResponseResult;
import com.kfgs.domain.response.QueryResult;
import com.kfgs.domain.response.ResultCode;

/**
 * <H3>shanxi</H3>
 * <p>产品返回列表</p>
 *
 * @author : 你的名字
 * @date : 2019-12-03 14:51
 */
public class TbProductQueryResponseResult extends QueryResponseResult {



    public TbProductQueryResponseResult(ResultCode resultCode, QueryResult queryResult) {
        super(resultCode, queryResult);
    }
}
