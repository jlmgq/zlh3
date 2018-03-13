package cn.yingchuang.jboa.sys_employee.serivce;

import cn.yingchuang.jboa.sys_employee.entity.SysEmployee;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by 祖龙浩 on 2018/3/13.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class SysEmployeeServiceImplTest {
    @Test
    public void login() throws Exception {
        SysEmployee sys = new SysEmployee();
        sys.setName("张三");
        sys.setPassword("asdf");
        SysEmployee sysEmployee = sysEmployeeService.login(sys);
        System.out.println(sysEmployee);
    }

    @Resource
    private SysEmployeeService sysEmployeeService;
    @Test
    public void queryAll() throws Exception {
            List<SysEmployee> list = sysEmployeeService.queryAll();
            for (SysEmployee sysEmployee : list) {
                System.out.println(sysEmployee);
            }

    }

}