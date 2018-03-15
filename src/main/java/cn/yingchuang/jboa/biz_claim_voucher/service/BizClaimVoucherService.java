package cn.yingchuang.jboa.biz_claim_voucher.service;

import cn.yingchuang.jboa.biz_claim_voucher.entity.BizClaimVoucher;
import cn.yingchuang.jboa.biz_claim_voucher_detail.entity.BizClaimVoucherDetail;

import java.util.List;

/**
 * Created by Administrator on 2018\3\13 0013.
 */
public interface BizClaimVoucherService {
    //查询所有大表
    public List<BizClaimVoucher> queryAllBizClaimVoucher();

    //    事务，增加一个大表同时增加若干小表
    public Integer addBizClaimVoucherAndBizClaimVoucherDetails
    (BizClaimVoucher bizClaimVoucher,
     List<BizClaimVoucherDetail> bizClaimVoucherDetails);

    //    修改大表
    public Integer updateBizClaimVoucherTotalAndEventById(BizClaimVoucher bizClaimVoucher);

    //    查询一个大表
    public BizClaimVoucher queryBizClaimVoucherById(Integer id);






    /**
     * 部门经理审核通过小于5000的报销单
     * @param id
     * @return
     */
    Integer updateCheckDmAndCheckGmById(Integer id);

    /**
     * 部门经理审核通过大于5000的报销单
     * @param id
     * @return
     */
    Integer updateCheckDmById(Integer id);


    /**
     * 部门经理审核拒绝或打回报销单
     * @param status
     * @param id
     * @return
     */
    Integer updateStatusById(String status, Integer id);


    /**
     * 经理审核通过的报销单
     * @param id
     * @return
     */
    Integer updateCheckGmById( Integer id);

    /**
     * 经理审核拒绝的报销单
     * @param id
     * @return
     */
    Integer updateCheckDmAndStatusById(Integer id);
    /**
     * 经理审核打回的报销单
     * @param id
     * @return
     */
    Integer updateCheckDmAndStatusById1(Integer id);

    /**
     * 财务通过审核的报销单
     * @param id
     * @return
     */
    Integer updateAllStatus(Integer id);



}
