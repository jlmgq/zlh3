package cn.yingchuang.jboa.biz_claim_voucher.entity;

import java.util.Date;

/**
 * Created by Administrator on 2018\3\13 0013.
 */
public class BizClaimVoucher {
    private Integer id,createSn;
    private Double totalAccount;
    private String event,status,checkDm,checkGm,checkFa;
    private Date createTime;

    @Override
    public String toString() {
        return "BizClaimVoucher{" +
                "id=" + id +
                ", createSn=" + createSn +
                ", totalAccount=" + totalAccount +
                ", event='" + event + '\'' +
                ", status='" + status + '\'' +
                ", checkDm='" + checkDm + '\'' +
                ", checkGm='" + checkGm + '\'' +
                ", checkFa='" + checkFa + '\'' +
                ", createTime=" + createTime +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCreateSn() {
        return createSn;
    }

    public void setCreateSn(Integer createSn) {
        this.createSn = createSn;
    }

    public Double getTotalAccount() {
        return totalAccount;
    }

    public void setTotalAccount(Double totalAccount) {
        this.totalAccount = totalAccount;
    }

    public String getEvent() {
        return event;
    }

    public void setEvent(String event) {
        this.event = event;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCheckDm() {
        return checkDm;
    }

    public void setCheckDm(String checkDm) {
        this.checkDm = checkDm;
    }

    public String getCheckGm() {
        return checkGm;
    }

    public void setCheckGm(String checkGm) {
        this.checkGm = checkGm;
    }

    public String getCheckFa() {
        return checkFa;
    }

    public void setCheckFa(String checkFa) {
        this.checkFa = checkFa;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
