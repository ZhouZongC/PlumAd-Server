package com.mankan.plumad.model;

import java.math.BigDecimal;
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
 * 用户财务表
 * </p>
 *
 * @author lq
 * @since 2019-09-24
 */
@ApiModel(value ="用户财务表",description ="用户财务表")
@TableName("user_finance")
public class UserFinance extends Model<UserFinance> {

    private static final long serialVersionUID = 1L;

    private String id;
    /**
     * 用户id
     */
    @ApiModelProperty(value = "用户id",name="userId")
    @TableField("user_id")
    private String userId;
    /**
     * 充值可消费金额
     */
    @ApiModelProperty(value = "充值可消费金额",name="rechargeAmount")
    @TableField("recharge_amount")
    private BigDecimal rechargeAmount;
    /**
     * 分润可提现余额
     */
    @ApiModelProperty(value = "分润可提现余额",name="withdrawAmount")
    @TableField("withdraw_amount")
    private BigDecimal withdrawAmount;
    /**
     * 历史充值金额
     */
    @ApiModelProperty(value = "历史充值金额",name="totalRechargeAmount")
    @TableField("total_recharge_amount")
    private BigDecimal totalRechargeAmount;
    /**
     * 历史总分润金额
     */
    @ApiModelProperty(value = "历史总分润金额",name="totalWithdrawAmount")
    @TableField("total_withdraw_amount")
    private BigDecimal totalWithdrawAmount;
    /**
     * 分润提现处理中金额
     */
    @ApiModelProperty(value = "分润提现处理中金额",name="handleAmount")
    @TableField("handle_amount")
    private BigDecimal handleAmount;
    /**
     * 冻结金额
     */
    @ApiModelProperty(value = "冻结金额",name="frozenAmount")
    @TableField("frozen_amount")
    private BigDecimal frozenAmount;
    /**
     * 收款银行
     */
    @ApiModelProperty(value = "收款银行",name="bankCode")
    @TableField("bank_code")
    private String bankCode;
    /**
     * 开户地分行
     */
    @ApiModelProperty(value = "开户地分行",name="bankInfo")
    @TableField("bank_info")
    private String bankInfo;
    /**
     * 银行账号
     */
    @ApiModelProperty(value = "银行账号",name="cardnum")
    private String cardnum;
    /**
     * 收款人名称
     */
    @ApiModelProperty(value = "收款人名称",name="cardName")
    @TableField("card_name")
    private String cardName;
    /**
     * 乐观锁
     */
    @ApiModelProperty(value = "乐观锁",name="version")
    @Version
    private String version;
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

    public BigDecimal getRechargeAmount() {
        return rechargeAmount;
    }

    public void setRechargeAmount(BigDecimal rechargeAmount) {
        this.rechargeAmount = rechargeAmount;
    }

    public BigDecimal getWithdrawAmount() {
        return withdrawAmount;
    }

    public void setWithdrawAmount(BigDecimal withdrawAmount) {
        this.withdrawAmount = withdrawAmount;
    }

    public BigDecimal getTotalRechargeAmount() {
        return totalRechargeAmount;
    }

    public void setTotalRechargeAmount(BigDecimal totalRechargeAmount) {
        this.totalRechargeAmount = totalRechargeAmount;
    }

    public BigDecimal getTotalWithdrawAmount() {
        return totalWithdrawAmount;
    }

    public void setTotalWithdrawAmount(BigDecimal totalWithdrawAmount) {
        this.totalWithdrawAmount = totalWithdrawAmount;
    }

    public BigDecimal getHandleAmount() {
        return handleAmount;
    }

    public void setHandleAmount(BigDecimal handleAmount) {
        this.handleAmount = handleAmount;
    }

    public BigDecimal getFrozenAmount() {
        return frozenAmount;
    }

    public void setFrozenAmount(BigDecimal frozenAmount) {
        this.frozenAmount = frozenAmount;
    }

    public String getBankCode() {
        return bankCode;
    }

    public void setBankCode(String bankCode) {
        this.bankCode = bankCode;
    }

    public String getBankInfo() {
        return bankInfo;
    }

    public void setBankInfo(String bankInfo) {
        this.bankInfo = bankInfo;
    }

    public String getCardnum() {
        return cardnum;
    }

    public void setCardnum(String cardnum) {
        this.cardnum = cardnum;
    }

    public String getCardName() {
        return cardName;
    }

    public void setCardName(String cardName) {
        this.cardName = cardName;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
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
        return this.id;
    }

    @Override
    public String toString() {
        return "UserFinance{" +
        "id=" + id +
        ", userId=" + userId +
        ", rechargeAmount=" + rechargeAmount +
        ", withdrawAmount=" + withdrawAmount +
        ", totalRechargeAmount=" + totalRechargeAmount +
        ", totalWithdrawAmount=" + totalWithdrawAmount +
        ", handleAmount=" + handleAmount +
        ", frozenAmount=" + frozenAmount +
        ", bankCode=" + bankCode +
        ", bankInfo=" + bankInfo +
        ", cardnum=" + cardnum +
        ", cardName=" + cardName +
        ", version=" + version +
        ", status=" + status +
        ", remarks=" + remarks +
        ", deleteFlag=" + deleteFlag +
        ", createTime=" + createTime +
        ", modifyTime=" + modifyTime +
        ", createUser=" + createUser +
        "}";
    }
}
