package cn.yingchuang.jboa.biz_claim_voucher_detail.entity;

/**
 * Created by Administrator on 2018\3\13 0013.
 */
public class BizClaimVoucherDetail {
    private Integer id,mainId;
    private String item,desc;
    private Double account;

    @Override
    public String toString() {
        return "BizClaimVoucherDetail{" +
                "id=" + id +
                ", mainId=" + mainId +
                ", item='" + item + '\'' +
                ", desc='" + desc + '\'' +
                ", account=" + account +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getMainId() {
        return mainId;
    }

    public void setMainId(Integer mainId) {
        this.mainId = mainId;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public Double getAccount() {
        return account;
    }

    public void setAccount(Double account) {
        this.account = account;
    }
}
