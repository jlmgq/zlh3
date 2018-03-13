package cn.yingchuang.jboa.sys_employee.controller;

import cn.yingchuang.jboa.sys_employee.entity.SysEmployee;
import cn.yingchuang.jboa.sys_employee.serivce.SysEmployeeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

/**
 * Created by 祖龙浩 on 2018/3/13.
 */
@Controller
@RequestMapping("employee")
public class SysEmployeeController {

    @Resource
    private SysEmployeeService sysEmployeeService;

    @RequestMapping("login")
    public String login(HttpSession session, SysEmployee sysEmployee, Model model) {
        SysEmployee loginUser = sysEmployeeService.login(sysEmployee);
        if(loginUser != null){
            session.setAttribute("loginUser",loginUser);
            return "welcome";
        }else{
            model.addAttribute("message", "用户名或密码错误");
            return "index";
        }


    }

    @RequestMapping("logout")
    public String logout(HttpSession session){
        session.removeAttribute("loginUser");
        return "index";
    }
}
