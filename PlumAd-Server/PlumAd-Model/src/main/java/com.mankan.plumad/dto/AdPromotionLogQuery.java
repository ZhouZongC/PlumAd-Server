package com.mankan.plumad.dto;

import io.swagger.annotations.ApiModel;
import javax.validation.constraints.Min;
import com.mankan.plumad.model.AdPromotionLog;
/**
 * <p>
 * 流量主推广日志
 * </p>
 *
 * @author lq
 * @since 2019-09-24
 */
@ApiModel(value ="流量主推广日志",description ="流量主推广日志")
public class AdPromotionLogQuery extends AdPromotionLog {

    @Min(value = 1)
    private int pageNum;
    @Min(value = 5)
    private int pageSize;


    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

}
