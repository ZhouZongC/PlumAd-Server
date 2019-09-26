package com.mankan.plumad.dto;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.annotations.Version;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.validation.constraints.Min;

import com.mankan.plumad.model.PicInfo;
/**
 * <p>
 * 图片文件表
 * </p>
 *
 * @author lq
 * @since 2019-09-26
 */
@ApiModel(value ="图片文件表",description ="图片文件表")
public class PicInfoQuery extends PicInfo {

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
