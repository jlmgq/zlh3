package cn.yingchuang.jboa.biz_claim_voucher.entity;

import cn.yingchuang.jboa.sys_employee.entity.SysEmployee;

/**
 * Created by 祖龙浩 on 2018/3/13.
 */
public class ClaimEmployeeVo extends BizClaimVoucher{

    private SysEmployee sysEmployee;

    public ClaimEmployeeVo() {
    }

    @Override
    public String toString() {
        return "ClaimEmployeeVo{" +
                "sysEmployee=" + sysEmployee +
                "} " + super.toString();
    }

    public SysEmployee getSysEmployee() {
        return sysEmployee;
    }

    public void setSysEmployee(SysEmployee sysEmployee) {
        this.sysEmployee = sysEmployee;
    }
}
