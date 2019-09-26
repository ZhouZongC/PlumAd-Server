package com.mankan.plumad.model;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.annotations.Version;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
/**
 * <p>
 * 图片文件表
 * </p>
 *
 * @author lq
 * @since 2019-09-26
 */
@ApiModel(value ="图片文件表",description ="图片文件表")
@TableName("pic_info")
public class PicInfo extends Model<PicInfo> {

    private static final long serialVersionUID = 1L;

    private String id;
    /**
     * 图片url
     */
    @ApiModelProperty(value = "图片url",name="picUrl")
    @TableField("pic_url")
    private String picUrl;
    /**
     * 图片path
     */
    @ApiModelProperty(value = "图片path",name="picPath")
    @TableField("pic_path")
    private String picPath;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }

    public String getPicPath() {
        return picPath;
    }

    public void setPicPath(String picPath) {
        this.picPath = picPath;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "PicInfo{" +
        "id=" + id +
        ", picUrl=" + picUrl +
        ", picPath=" + picPath +
        "}";
    }
}
