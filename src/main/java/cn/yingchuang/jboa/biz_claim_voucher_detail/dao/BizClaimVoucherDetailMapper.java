package cn.yingchuang.jboa.biz_claim_voucher_detail.dao;

import cn.yingchuang.jboa.biz_claim_voucher_detail.entity.BizClaimVoucherDetail;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by lyr_2 on 2018/3/13.
 */
public interface BizClaimVoucherDetailMapper {
    /**
     * 通过mainId 查询所有
     * @param id
     * @return
     */

    List<BizClaimVoucherDetail> queryClaimDetailByMainId(@Param("mainId") Integer id);

    /**
     * 测试方法-查全部
     *
     * @return
     */
    List<BizClaimVoucherDetail> queryAll();





    //    通过mainId查小表
    public List<BizClaimVoucherDetail> queryBizClaimDetailByMainId(Integer mainId);
    //    增加一条小表
    public Integer addBizClaimVoucherDetailByMainId(BizClaimVoucherDetail bizClaimVoucherDetail);
    //    删除一条小表
    public Integer deleteClaimDetailById(Integer id);
    //    删除mainId一样的小表
    public Integer deleteClaimDetailByMainId(Integer mainId);
}
