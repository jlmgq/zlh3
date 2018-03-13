package cn.yingchuang.jboa.biz_claim_voucher_detail.serivce;

import cn.yingchuang.jboa.biz_claim_voucher_detail.entity.BizClaimVoucherDetail;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by lyr_2 on 2018/3/13.
 */
public interface BizClaimVoucherDetailService {
    /**
     * @return 查询所有用于测试
     */
    List<BizClaimVoucherDetail> queryAll();

    /**
     * @param id
     * @return 通过mainId 查询某个审批单里的具体的费用项目
     */

    List<BizClaimVoucherDetail> queryClaimDetailByMainId(@Param("mainId") Integer id);


}
