package com.kfgs.domain.ext;

import com.kfgs.domain.TbProduct;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

/**
 * <H3>shanxi</H3>
 * <p>产品返回列表</p>
 *
 * @author : 你的名字
 * @date : 2019-12-03 14:51
 */
@Data
@ToString
public class TbProductExt extends TbProduct implements Serializable {
    private String  administrativeAreaName;
    private String  classificationName;
    private String  area;
    private String  protectionNoticeTitle;
    private String  noticeTime;

    public TbProductExt(){}

    public TbProductExt(String noticeTime, String protectionNoticeTitle, String area, String administrativeAreaName, String classificationName, TbProduct tbProduct) {
        super(tbProduct);
        this.administrativeAreaName = administrativeAreaName;
        this.classificationName = classificationName;
        this.area = area;
        this.protectionNoticeTitle = protectionNoticeTitle;
        this.noticeTime = noticeTime;
    }
}
