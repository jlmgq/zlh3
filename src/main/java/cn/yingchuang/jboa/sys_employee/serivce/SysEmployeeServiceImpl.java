package cn.yingchuang.jboa.sys_employee.serivce;

import cn.yingchuang.jboa.sys_employee.dao.SysEmployeeMapper;
import cn.yingchuang.jboa.sys_employee.entity.SysEmployee;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by 祖龙浩 on 2018/3/13.
 */
@Service
public class SysEmployeeServiceImpl implements SysEmployeeService {
    @Resource
    private SysEmployeeMapper sysEmployeeMapper;

    @Override
    public List<SysEmployee> queryAll() {
        return sysEmployeeMapper.queryAll();
    }

    @Override
    public SysEmployee login(SysEmployee sysEmployee) {
        return sysEmployeeMapper.login(sysEmployee);
    }
}
