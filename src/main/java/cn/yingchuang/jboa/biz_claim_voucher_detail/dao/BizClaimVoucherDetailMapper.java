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
}
