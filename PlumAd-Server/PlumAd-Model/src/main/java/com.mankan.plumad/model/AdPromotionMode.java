package com.mankan.plumad.model;

import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.annotations.TableLogic;
import com.baomidou.mybatisplus.annotations.Version;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
/**
 * <p>
 * 流量主推广方式
 * </p>
 *
 * @author lq
 * @since 2019-09-24
 */
@ApiModel(value ="流量主推广方式",description ="流量主推广方式")
@TableName("ad_promotion_mode")
public class AdPromotionMode extends Model<AdPromotionMode> {

    private static final long serialVersionUID = 1L;

    private String id;
    /**
     * 用户id
     */
    @ApiModelProperty(value = "用户id",name="userId")
    @TableField("user_id")
    private String userId;
    /**
     * 推广码
     */
    @ApiModelProperty(value = "推广码",name="promotionCode")
    @TableField("promotion_code")
    private String promotionCode;
    /**
     * 推广名称
     */
    @ApiModelProperty(value = "推广名称",name="promotionName")
    @TableField("promotion_name")
    private String promotionName;
    /**
     * 推广方式
     */
    @ApiModelProperty(value = "推广方式",name="promotionType")
    @TableField("promotion_type")
    private String promotionType;
    /**
     * 您的网站域名
     */
    @ApiModelProperty(value = "您的网站域名",name="webUrl")
    @TableField("web_url")
    private String webUrl;
    /**
     * 网站名称
     */
    @ApiModelProperty(value = "网站名称",name="webName")
    @TableField("web_name")
    private String webName;
    /**
     * 网站备案信息
     */
    @ApiModelProperty(value = "网站备案信息",name="webIcp")
    @TableField("web_icp")
    private String webIcp;
    /**
     * 网站类别
     */
    @ApiModelProperty(value = "网站类别",name="webType")
    @TableField("web_type")
    private String webType;
    /**
     * 日访问量
     */
    @ApiModelProperty(value = "日访问量",name="dailyVisits")
    @TableField("daily_visits")
    private Integer dailyVisits;
    /**
     * 网站描述
     */
    @ApiModelProperty(value = "网站描述",name="webRemarks")
    @TableField("web_remarks")
    private String webRemarks;
    /**
     * app名称
     */
    @ApiModelProperty(value = "app名称",name="appName")
    @TableField("app_name")
    private String appName;
    /**
     * app官网首页
     */
    @ApiModelProperty(value = "app官网首页",name="appIndex")
    @TableField("app_index")
    private String appIndex;
    /**
     * app下载地址
     */
    @ApiModelProperty(value = "app下载地址",name="appDownUrl")
    @TableField("app_down_url")
    private String appDownUrl;
    /**
     * app类型
     */
    @ApiModelProperty(value = "app类型",name="appType")
    @TableField("app_type")
    private String appType;
    /**
     * 日活量
     */
    @ApiModelProperty(value = "日活量",name="activityVisits")
    @TableField("activity_visits")
    private Integer activityVisits;
    /**
     * app描述
     */
    @ApiModelProperty(value = "app描述",name="appRemarks")
    @TableField("app_remarks")
    private String appRemarks;
    /**
     * qq群/微信群号
     */
    @ApiModelProperty(value = "qq群/微信群号",name="groupNumber")
    @TableField("group_number")
    private String groupNumber;
    /**
     * qq群/微信群名称
     */
    @ApiModelProperty(value = "qq群/微信群名称",name="groupName")
    @TableField("group_name")
    private String groupName;
    /**
     * 群人数
     */
    @ApiModelProperty(value = "群人数",name="groupNum")
    @TableField("group_num")
    private Integer groupNum;
    /**
     * 群类型
     */
    @ApiModelProperty(value = "群类型",name="groupType")
    @TableField("group_type")
    private String groupType;
    /**
     * 大V网红渠道(微信公众号/微博/抖音/快手/小红书/其他)
     */
    @ApiModelProperty(value = "大V网红渠道(微信公众号/微博/抖音/快手/小红书/其他)",name="davSource")
    @TableField("dav_source")
    private String davSource;
    /**
     * 其他渠道
     */
    @ApiModelProperty(value = "其他渠道",name="davOtherSource")
    @TableField("dav_other_source")
    private String davOtherSource;
    /**
     * 账号id
     */
    @ApiModelProperty(value = "账号id",name="davAccount")
    @TableField("dav_account")
    private String davAccount;
    /**
     * 关注人数
     */
    @ApiModelProperty(value = "关注人数",name="davFollow")
    @TableField("dav_follow")
    private Integer davFollow;
    /**
     * 网红类型
     */
    @ApiModelProperty(value = "网红类型",name="davType")
    @TableField("dav_type")
    private String davType;
    /**
     * 状态
     */
    @ApiModelProperty(value = "状态",name="status")
    private String status;
    /**
     * 说明
     */
    @ApiModelProperty(value = "说明",name="remarks")
    private String remarks;
    /**
     * 删除标记
     */
    @ApiModelProperty(value = "删除标记",name="deleteFlag")
    @TableField("delete_flag")
    @TableLogic
    private String deleteFlag;
    /**
     * 创建时间
     */
    @ApiModelProperty(value = "创建时间",name="createTime")
    @TableField("create_time")
    private Date createTime;
    /**
     * 修改时间
     */
    @ApiModelProperty(value = "修改时间",name="modifyTime")
    @TableField("modify_time")
    private Date modifyTime;
    /**
     * 创建人
     */
    @ApiModelProperty(value = "创建人",name="createUser")
    @TableField("create_user")
    private String createUser;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getPromotionCode() {
        return promotionCode;
    }

    public void setPromotionCode(String promotionCode) {
        this.promotionCode = promotionCode;
    }

    public String getPromotionName() {
        return promotionName;
    }

    public void setPromotionName(String promotionName) {
        this.promotionName = promotionName;
    }

    public String getPromotionType() {
        return promotionType;
    }

    public void setPromotionType(String promotionType) {
        this.promotionType = promotionType;
    }

    public String getWebUrl() {
        return webUrl;
    }

    public void setWebUrl(String webUrl) {
        this.webUrl = webUrl;
    }

    public String getWebName() {
        return webName;
    }

    public void setWebName(String webName) {
        this.webName = webName;
    }

    public String getWebIcp() {
        return webIcp;
    }

    public void setWebIcp(String webIcp) {
        this.webIcp = webIcp;
    }

    public String getWebType() {
        return webType;
    }

    public void setWebType(String webType) {
        this.webType = webType;
    }

    public Integer getDailyVisits() {
        return dailyVisits;
    }

    public void setDailyVisits(Integer dailyVisits) {
        this.dailyVisits = dailyVisits;
    }

    public String getWebRemarks() {
        return webRemarks;
    }

    public void setWebRemarks(String webRemarks) {
        this.webRemarks = webRemarks;
    }

    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }

    public String getAppIndex() {
        return appIndex;
    }

    public void setAppIndex(String appIndex) {
        this.appIndex = appIndex;
    }

    public String getAppDownUrl() {
        return appDownUrl;
    }

    public void setAppDownUrl(String appDownUrl) {
        this.appDownUrl = appDownUrl;
    }

    public String getAppType() {
        return appType;
    }

    public void setAppType(String appType) {
        this.appType = appType;
    }

    public Integer getActivityVisits() {
        return activityVisits;
    }

    public void setActivityVisits(Integer activityVisits) {
        this.activityVisits = activityVisits;
    }

    public String getAppRemarks() {
        return appRemarks;
    }

    public void setAppRemarks(String appRemarks) {
        this.appRemarks = appRemarks;
    }

    public String getGroupNumber() {
        return groupNumber;
    }

    public void setGroupNumber(String groupNumber) {
        this.groupNumber = groupNumber;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public Integer getGroupNum() {
        return groupNum;
    }

    public void setGroupNum(Integer groupNum) {
        this.groupNum = groupNum;
    }

    public String getGroupType() {
        return groupType;
    }

    public void setGroupType(String groupType) {
        this.groupType = groupType;
    }

    public String getDavSource() {
        return davSource;
    }

    public void setDavSource(String davSource) {
        this.davSource = davSource;
    }

    public String getDavOtherSource() {
        return davOtherSource;
    }

    public void setDavOtherSource(String davOtherSource) {
        this.davOtherSource = davOtherSource;
    }

    public String getDavAccount() {
        return davAccount;
    }

    public void setDavAccount(String davAccount) {
        this.davAccount = davAccount;
    }

    public Integer getDavFollow() {
        return davFollow;
    }

    public void setDavFollow(Integer davFollow) {
        this.davFollow = davFollow;
    }

    public String getDavType() {
        return davType;
    }

    public void setDavType(String davType) {
        this.davType = davType;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getDeleteFlag() {
        return deleteFlag;
    }

    public void setDeleteFlag(String deleteFlag) {
        this.deleteFlag = deleteFlag;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }

    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }

    @Override
    protected Serializable pkVal() {
        return null;
    }

    @Override
    public String toString() {
        return "AdPromotionMode{" +
        "id=" + id +
        ", userId=" + userId +
        ", promotionCode=" + promotionCode +
        ", promotionName=" + promotionName +
        ", promotionType=" + promotionType +
        ", webUrl=" + webUrl +
        ", webName=" + webName +
        ", webIcp=" + webIcp +
        ", webType=" + webType +
        ", dailyVisits=" + dailyVisits +
        ", webRemarks=" + webRemarks +
        ", appName=" + appName +
        ", appIndex=" + appIndex +
        ", appDownUrl=" + appDownUrl +
        ", appType=" + appType +
        ", activityVisits=" + activityVisits +
        ", appRemarks=" + appRemarks +
        ", groupNumber=" + groupNumber +
        ", groupName=" + groupName +
        ", groupNum=" + groupNum +
        ", groupType=" + groupType +
        ", davSource=" + davSource +
        ", davOtherSource=" + davOtherSource +
        ", davAccount=" + davAccount +
        ", davFollow=" + davFollow +
        ", davType=" + davType +
        ", status=" + status +
        ", remarks=" + remarks +
        ", deleteFlag=" + deleteFlag +
        ", createTime=" + createTime +
        ", modifyTime=" + modifyTime +
        ", createUser=" + createUser +
        "}";
    }
}
