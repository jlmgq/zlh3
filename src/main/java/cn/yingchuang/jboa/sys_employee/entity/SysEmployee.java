package cn.yingchuang.jboa.sys_employee.entity;

import cn.yingchuang.jboa.sys_positions.entity.SysPositions;

/**
 * Created by Administrator on 2018\3\13 0013.
 */
public class SysEmployee {
    private Integer sn;
    private String name,password,status;
    private SysPositions sysPositions;

    public SysPositions getSysPositions() {
        return sysPositions;
    }

    public void setSysPositions(SysPositions sysPositions) {
        this.sysPositions = sysPositions;
    }

    @Override
    public String toString() {
        return "SysEmployee{" +
                "sn=" + sn +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", status='" + status + '\'' +
                ", sysPositions=" + sysPositions +
                '}';
    }

    public Integer getSn() {
        return sn;
    }

    public void setSn(Integer sn) {
        this.sn = sn;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
