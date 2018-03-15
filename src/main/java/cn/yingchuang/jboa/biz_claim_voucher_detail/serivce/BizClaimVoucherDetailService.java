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




    //    通过mainId查小表
    public List<BizClaimVoucherDetail> queryBizClaimDetailByMainId(Integer mainId);
    //    增加一条小表
    public Integer addBizClaimVoucherDetailByMainId(BizClaimVoucherDetail bizClaimVoucherDetail);
    //    删除一条小表
    public Integer deleteClaimDetailById(Integer id);
    //    删除mainId一样的小表
    public Integer deleteClaimDetailByMainId(Integer mainId);


}
