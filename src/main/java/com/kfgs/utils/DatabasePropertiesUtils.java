package com.kfgs.utils;

/**
 * Date: 2020-04-15-14-19
 * Module:
 * Description:
 *
 * @author:
 */
public class DatabasePropertiesUtils {

    public static String[] getHearders(String tableName){
        if("tb_enterprise".equalsIgnoreCase(tableName)){
            return new String[] {"企业编号","企业名称","企业地址","省","市","县","产品名称","商标","法人代表",
                    "核准公告号(简称)","核准公告全称","统一社会信用代码","批准机构","核准年度","核准申请/是否变更"};
        }else if("tb_product".equalsIgnoreCase(tableName)){
            return new String[] {"产品编号","产品名称","分类","行政区间","批准年度/批准时间","批准机构",
                    "批准公告(简称)","批准公告(全称)","省份名称","地市名称",};
        }else if("tb_policy_document".equalsIgnoreCase(tableName)){
            return null;
        }else if("tb_protection_notice".equalsIgnoreCase(tableName)){
            return null;
        }else {
            return null;
        }
    }
}
