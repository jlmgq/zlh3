package cn.yingchuang.jboa.biz_claim_voucher.service;

import cn.yingchuang.jboa.biz_claim_voucher.entity.ClaimEmployeeVo;
import cn.yingchuang.jboa.command.util.PageUtil;

/**
 * Created by 祖龙浩 on 2018/3/13.
 */
public interface ClaimEmployeeVoService {
    /**
     * 部门经理查询所有待审核的报销单
     * @param status 报销单的审核状态
     * @return
     */
    PageUtil<ClaimEmployeeVo> queryClaimEmployeeVoByStatus(Integer pageNum,Integer pageSize,String status);
    /**
     *根据总经理的审核状态，查询所有给财务查阅和操作
     * @param status
     * @return
     */

    PageUtil<ClaimEmployeeVo> queryClaimEmployeeVoByCheckGM(Integer pageName,Integer pageSize,String status);

    /**
     *  根据部门经理的审核状态 和金额>5000 查询所有 给总经理查看和操作
     * @param status
     * @return
     */

    PageUtil<ClaimEmployeeVo> queryClaimEmployeeVoByCheckDMAndMoney(Integer pageName,Integer pageSize,String status);

}
