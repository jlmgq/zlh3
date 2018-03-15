package cn.yingchuang.jboa.biz_claim_voucher.dao;

import cn.yingchuang.jboa.biz_claim_voucher.entity.BizClaimVoucher;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by 祖龙浩 on 2018/3/13.
 */
public interface BizClaimVoucherMapper {

    /**
     * 部门经理审核通过小于5000的报销单
     * @param id
     * @return
     */
    Integer updateCheckDmAndCheckGmById(@Param("id")Integer id);

    /**
     * 部门经理审核通过大于5000的报销单
     * @param id
     * @return
     */
    Integer updateCheckDmById(@Param("id")Integer id);


    /**
     * 部门经理审核拒绝或打回报销单
     * @param status
     * @param id
     * @return
     */
    Integer updateStatusById(@Param("status")String status,@Param("id") Integer id);


    /**
     * 经理审核通过的报销单
     * @param id
     * @return
     */
    Integer updateCheckGmById(@Param("id") Integer id);

    /**
     * 经理审核拒绝的报销单
     * @param id
     * @return
     */
    Integer updateCheckDmAndStatusById(@Param("id") Integer id);
    /**
     * 经理审核打回的报销单
     * @param id
     * @return
     */
    Integer updateCheckDmAndStatusById1( @Param("id") Integer id);

    /**
     * 财务通过审核的报销单
     * @param id
     * @return
     */
    Integer updateAllStatus(@Param("id") Integer id);






    //查询所有大表
    public List<BizClaimVoucher> queryAllBizClaimVoucher();

    //    添加大表
    public Integer addBizClaimVoucher(BizClaimVoucher bizClaimVoucher);

    //    修改大表
    public Integer updateBizClaimVoucherTotalAndEventById(BizClaimVoucher bizClaimVoucher);

    //    查询一个大表
    public BizClaimVoucher queryBizClaimVoucherById(Integer id);

}
