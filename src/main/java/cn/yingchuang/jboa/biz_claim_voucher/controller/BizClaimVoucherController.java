package cn.yingchuang.jboa.biz_claim_voucher.controller;

import cn.yingchuang.jboa.biz_claim_voucher.entity.BizClaimVoucher;
import cn.yingchuang.jboa.biz_claim_voucher.entity.ClaimEmployeeVo;
import cn.yingchuang.jboa.biz_claim_voucher.service.BizClaimVoucherService;
import cn.yingchuang.jboa.biz_claim_voucher.service.ClaimEmployeeVoService;
import cn.yingchuang.jboa.command.util.PageUtil;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
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
    @ResponseBody
    @RequestMapping(value = "queryAll",method = RequestMethod.GET,produces = {"application/json;charset=utf-8"})
    public String  queryAllBizClaimVoucher(){
        List<BizClaimVoucher> bizClaimVoucherList=bizClaimVoucherService.queryAllBizClaimVoucher();
        return JSONArray.toJSONString(bizClaimVoucherList);
    }

    @ResponseBody
    @RequestMapping(value = "queryClaimEmployeeVoByStatus",method = RequestMethod.GET,produces = {"application/json;charset=utf-8"})
    public String queryClaimEmployeeVoByStatus(Integer page,Integer rows){
        PageUtil<ClaimEmployeeVo> pageUtil = claimEmployeeVoService.queryClaimEmployeeVoByStatus(page,rows,"审核中");
        return JSON.toJSONString(pageUtil);
    }

    @ResponseBody
    @RequestMapping(value = "queryClaimEmployeeVoByCheckGM",method = RequestMethod.GET,produces = {"application/json;charset=utf-8"})
    public String queryClaimEmployeeVoByCheckGM(Integer page,Integer rows){
        PageUtil<ClaimEmployeeVo> pageUtil = claimEmployeeVoService.queryClaimEmployeeVoByCheckGM(page,rows,"审核通过");
        return JSON.toJSONString(pageUtil);
    }

    @ResponseBody
    @RequestMapping(value = "queryClaimEmployeeVoByCheckDMAndMoney",method = RequestMethod.GET,produces = {"application/json;charset=utf-8"})
    public String queryClaimEmployeeVoByCheckDMAndMoney(Integer page,Integer rows){
        PageUtil<ClaimEmployeeVo> pageUtil = claimEmployeeVoService.queryClaimEmployeeVoByCheckDMAndMoney(page,rows,"审核通过");
        return JSON.toJSONString(pageUtil);
    }



}
