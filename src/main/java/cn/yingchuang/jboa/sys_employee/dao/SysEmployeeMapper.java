package cn.yingchuang.jboa.sys_employee.dao;

import cn.yingchuang.jboa.sys_employee.entity.SysEmployee;

import java.util.List;

/**
 * Created by 祖龙浩 on 2018/3/13.
 */
public interface SysEmployeeMapper {

    /**
     * 测试方法--查全部
     * @return
     */
    List<SysEmployee> queryAll();


    /**
     * 登录方法
     * @param sysEmployee
     * @return
     */
    SysEmployee login(SysEmployee sysEmployee);

}
