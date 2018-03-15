package cn.yingchuang.jboa.biz_claim_voucher.controller;

import cn.yingchuang.jboa.biz_claim_voucher.entity.BizClaimVoucher;
import cn.yingchuang.jboa.biz_claim_voucher.entity.ClaimEmployeeVo;
import cn.yingchuang.jboa.biz_claim_voucher.service.BizClaimVoucherService;
import cn.yingchuang.jboa.biz_claim_voucher.service.ClaimEmployeeVoService;
import cn.yingchuang.jboa.biz_claim_voucher_detail.entity.BizClaimVoucherDetail;
import cn.yingchuang.jboa.biz_claim_voucher_detail.serivce.BizClaimVoucherDetailService;
import cn.yingchuang.jboa.command.util.Message;
import cn.yingchuang.jboa.command.util.PageUtil;
import cn.yingchuang.jboa.sys_employee.entity.SysEmployee;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by Administrator on 2018\3\13 0013.
 */
@Controller
@RequestMapping("bizClaimVoucher")
public class BizClaimVoucherController {
    @Resource
    private BizClaimVoucherService bizClaimVoucherService;
    @Resource
    private ClaimEmployeeVoService claimEmployeeVoService;
    @Resource
    private BizClaimVoucherDetailService bizClaimVoucherDetailService;

    @RequestMapping("toBizClaimVoucher")
    public String toBizClaimVoucher(HttpSession session, Model model) {
        SysEmployee sysEmployee = (SysEmployee) session.getAttribute("loginUser");
        Integer posId = sysEmployee.getSysPositions().getId();
        if (posId == 1) {
            return "claimVoucher-worker";
        }
        return "claimVoucher";
    }


    @ResponseBody
    @RequestMapping(value = "queryAll", method = RequestMethod.GET, produces = {"application/json;charset=utf-8"})
    public String queryAllBizClaimVoucher() {
        List<BizClaimVoucher> bizClaimVoucherList = bizClaimVoucherService.queryAllBizClaimVoucher();
        return JSONArray.toJSONString(bizClaimVoucherList);
    }


    @RequestMapping(value = "toCheck", method = RequestMethod.GET, produces = {"application/json;charset=utf-8"})
    public String toCheck(Integer id, Model model) {
        ClaimEmployeeVo claimEmployeeVo = claimEmployeeVoService.queryClaimEmployeeVoById(id);
        Integer mainId = claimEmployeeVo.getId();
        List<BizClaimVoucherDetail> bcdList = bizClaimVoucherDetailService.queryBizClaimDetailByMainId(mainId);
        model.addAttribute("claimEmployeeVo", claimEmployeeVo);
        model.addAttribute("bcdList", bcdList);
        return "checkClaim";
    }


    @ResponseBody
    @RequestMapping(value = "queryClaimEmployeeVoByStatus", method = RequestMethod.GET, produces = {"application/json;charset=utf-8"})
    public String queryClaimEmployeeVoByStatus(Integer page, Integer rows) {
        PageUtil<ClaimEmployeeVo> pageUtil = claimEmployeeVoService.queryClaimEmployeeVoByStatus(page, rows, "审核中");
        return JSON.toJSONString(pageUtil);
    }

    @ResponseBody
    @RequestMapping(value = "queryClaimEmployeeVoByCheckGM", method = RequestMethod.GET, produces = {"application/json;charset=utf-8"})
    public String queryClaimEmployeeVoByCheckGM(Integer page, Integer rows) {
        PageUtil<ClaimEmployeeVo> pageUtil = claimEmployeeVoService.queryClaimEmployeeVoByCheckGM(page, rows, "审核通过");
        return JSON.toJSONString(pageUtil);
    }

    @ResponseBody
    @RequestMapping(value = "queryClaimEmployeeVoByCheckDMAndMoney", method = RequestMethod.GET, produces = {"application/json;charset=utf-8"})
    public String queryClaimEmployeeVoByCheckDMAndMoney(Integer page, Integer rows) {
        PageUtil<ClaimEmployeeVo> pageUtil = claimEmployeeVoService.queryClaimEmployeeVoByCheckDMAndMoney(page, rows, "审核通过");
        return JSON.toJSONString(pageUtil);
    }


    @ResponseBody
    @RequestMapping(value = "queryClaimEmployeeVoByCreateSn", method = RequestMethod.GET, produces = {"application/json;charset=utf-8"})
    public String queryClaimEmployeeVoByCreateSn(Integer page, Integer rows, Integer createSn) {
        PageUtil<ClaimEmployeeVo> pageUtil = claimEmployeeVoService.queryClaimEmployeeVoByCreateSn(page, rows, createSn);
        return JSON.toJSONString(pageUtil);
    }


    /**
     * 部门经理审核通过小于5000的报销单
     */
    @RequestMapping(value = "updateCheckDmAndCheckGmById", method = RequestMethod.POST, produces = {"application/json;charset=utf-8"})
    public String updateCheckDmAndCheckGmById(Integer id, HttpSession session, Model model) {
        Integer rows = bizClaimVoucherService.updateCheckDmAndCheckGmById(id);
        if (rows > 0) {
            model.addAttribute("message", Message.success());
        } else {
            model.addAttribute("message", Message.error());
        }

        return toBizClaimVoucher(session, model);
    }

    /**
     * 部门经理审核通过大于5000的报销单
     */
    @RequestMapping(value = "updateCheckDmById", method = RequestMethod.POST, produces = {"application/json;charset=utf-8"})
    public String updateCheckDmById(Integer id, HttpSession session, Model model) {
        Integer rows = bizClaimVoucherService.updateCheckDmById(id);
        if (rows > 0) {
            model.addAttribute("message", Message.success());
        } else {
            model.addAttribute("message", Message.error());
        }
        return toBizClaimVoucher(session, model);
    }


    /**
     * 部门经理审核拒绝或打回报销单
     */
    @RequestMapping(value = "updateStatusById", method = RequestMethod.POST, produces = {"application/json;charset=utf-8"})
    public String updateStatusById(String status, Integer id, HttpSession session, Model model) {
        if (status.equals("1")) {
            status = "拒绝";
        } else if (status.equals("2")) {
            status = "打回";
        }
        Integer rows = bizClaimVoucherService.updateStatusById(status, id);
        if (rows > 0) {
            model.addAttribute("message", Message.success());
        } else {
            model.addAttribute("message", Message.error());
        }
        return toBizClaimVoucher(session, model);
    }


    /**
     * 经理审核通过的报销单
     */
    @RequestMapping(value = "updateCheckGmById", method = RequestMethod.POST, produces = {"application/json;charset=utf-8"})
    public String updateCheckGmById(Integer id, HttpSession session, Model model) {
        Integer rows = bizClaimVoucherService.updateCheckGmById(id);
        if (rows > 0) {
            model.addAttribute("message", Message.success());
        } else {
            model.addAttribute("message", Message.error());
        }
        return toBizClaimVoucher(session, model);
    }

    /**
     * 经理审核拒绝的报销单
     */
    @RequestMapping(value = "updateCheckDmAndStatusById", method = RequestMethod.POST, produces = {"application/json;charset=utf-8"})
    public String updateCheckDmAndStatusById(Integer id, HttpSession session, Model model) {
        Integer rows = bizClaimVoucherService.updateCheckDmAndStatusById(id);
        if (rows > 0) {
            model.addAttribute("message", Message.success());
        } else {
            model.addAttribute("message", Message.error());
        }
        return toBizClaimVoucher(session, model);
    }

    /**
     * 经理审核打回的报销单
     */
    @RequestMapping(value = "updateCheckDmAndStatusById1", method = RequestMethod.POST, produces = {"application/json;charset=utf-8"})
    public String updateCheckDmAndStatusById1(Integer id, HttpSession session, Model model) {
        Integer rows = bizClaimVoucherService.updateCheckDmAndStatusById1(id);
        if (rows > 0) {
            model.addAttribute("message", Message.success());
        } else {
            model.addAttribute("message", Message.error());
        }
        return toBizClaimVoucher(session, model);
    }

    /**
     * 财务通过审核的报销单
     */
    @RequestMapping(value = "updateAllStatus", method = RequestMethod.POST, produces = {"application/json;charset=utf-8"})
    public String updateAllStatus(Integer id, HttpSession session, Model model) {
        Integer rows = bizClaimVoucherService.updateAllStatus(id);
        if (rows > 0) {
            model.addAttribute("message", Message.success());
        } else {
            model.addAttribute("message", Message.error());
        }
        return toBizClaimVoucher(session, model);
    }

    @ResponseBody
    @RequestMapping(value = "deleteBizClaimVoucherById", method = RequestMethod.POST, produces = {"application/json;charset=utf-8"})
    public String deleteBizClaimVoucherById(Integer id) {
        BizClaimVoucher bizClaimVoucher = bizClaimVoucherService.queryBizClaimVoucherById(id);
        String status = bizClaimVoucher.getStatus();
        if (status.equals("审核中")) {
            return JSON.toJSONString(new Message("0003", "审核中不能删除"));
        }
        int rows = bizClaimVoucherService.deleteBizClaimVoucherById(id);
        if (rows > 0) {
            return JSON.toJSONString(Message.success());
        } else {
            return JSON.toJSONString(Message.error());
        }
    }


    @ResponseBody
    @RequestMapping(value = "updataBizClaimVoucherById", method = RequestMethod.POST, produces = {"application/json;charset=utf-8"})
    public String updataBizClaimVoucherById(Integer id) {
        String status = bizClaimVoucherService.queryBizClaimVoucherById(id).getStatus();
        if (status.equals("审核中")) {
            return JSON.toJSONString(new Message("0004", "审核中不能再次提交"));
        }
        if (status.equals("拒绝")) {
            return JSON.toJSONString(new Message("0005", "已拒绝不能再次提交"));
        }
        if (status.equals("已付款")) {
            return JSON.toJSONString(new Message("0006", "已付款不能再次提交"));
        }
        int n = bizClaimVoucherService.updataBizClaimVoucherStatusById(id);
        if (n > 0) {
            return JSON.toJSONString(Message.success());
        }
        return JSON.toJSONString(Message.error());
    }



    /**
     * 去添加报销单页面
     */
    @RequestMapping("toAddBizClaimVoucher")
    public String toAddBizClaimVoucher() {


        return "claimVoucher-add";
    }

    /**
     * 添加报销单页面
     */
    @ResponseBody
    @RequestMapping(value = "doAddBizClaimVoucher", method = RequestMethod.POST,
            produces = {"application/json;charset=utf-8"})
    public String doAddBizClaimVoucher(String data, HttpSession session) {

        System.out.println("sss:" + data);
//        引入Gson包
        Gson gson = new Gson();
//        解析
        List<BizClaimVoucherDetail> people = gson.fromJson(data,
                new TypeToken<List<BizClaimVoucherDetail>>() {
                }.getType());
//=============
        Double conut = 0.0;
        for (BizClaimVoucherDetail bizClaimVoucherDetail : people) {
            if (bizClaimVoucherDetail != null) {
                conut += bizClaimVoucherDetail.getAccount();
            }
        }
        System.out.println(conut);

        SysEmployee sysEmployee = (SysEmployee) session.getAttribute("loginUser");

        System.out.println(sysEmployee);
        BizClaimVoucher bizClaimVoucher = new BizClaimVoucher();
        bizClaimVoucher.setCreateSn(sysEmployee.getSn());
        bizClaimVoucher.setTotalAccount(conut);
        bizClaimVoucher.setEvent("xx");

        Integer n=0;

        n=bizClaimVoucherService.addBizClaimVoucherAndBizClaimVoucherDetails(bizClaimVoucher,people);

        System.out.println(n);


            if(n>0){
                return JSON.toJSONString(
                        "ok了");
            }else {
                return JSON.toJSONString(
                        "没ok");
            }



        }

}
