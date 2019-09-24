package com.mankan.plumad.dto;

import io.swagger.annotations.ApiModel;
import javax.validation.constraints.Min;
import com.mankan.plumad.model.AdPromotionMode;
/**
 * <p>
 * 流量主推广方式
 * </p>
 *
 * @author lq
 * @since 2019-09-24
 */
@ApiModel(value ="流量主推广方式",description ="流量主推广方式")
public class AdPromotionModeQuery extends AdPromotionMode {

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
