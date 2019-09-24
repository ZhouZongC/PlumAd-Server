package com.mankan.plumad.dto;

import io.swagger.annotations.ApiModel;
import javax.validation.constraints.Min;
import com.mankan.plumad.model.UserFinance;
/**
 * <p>
 * 用户财务表
 * </p>
 *
 * @author lq
 * @since 2019-09-24
 */
@ApiModel(value ="用户财务表",description ="用户财务表")
public class UserFinanceQuery extends UserFinance {

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
