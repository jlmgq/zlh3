package cn.yingchuang.jboa.biz_claim_voucher_detail.serivce;

import cn.yingchuang.jboa.biz_claim_voucher_detail.dao.BizClaimVoucherDetailMapper;
import cn.yingchuang.jboa.biz_claim_voucher_detail.entity.BizClaimVoucherDetail;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by lyr_2 on 2018/3/13.
 */
@Service
public class BizClaimVoucherDetailServiceImpl implements BizClaimVoucherDetailService {
    @Resource
    private BizClaimVoucherDetailMapper bizClaimVoucherDetailMapper;

    @Override
    public List<BizClaimVoucherDetail> queryAll() {
        return bizClaimVoucherDetailMapper.queryAll();
    }

    @Override
    public List<BizClaimVoucherDetail> queryClaimDetailByMainId(Integer id) {
        return bizClaimVoucherDetailMapper.queryClaimDetailByMainId(id);
    }





    @Override
    public List<BizClaimVoucherDetail> queryBizClaimDetailByMainId(Integer mainId) {

        return bizClaimVoucherDetailMapper.queryBizClaimDetailByMainId(mainId);
    }

    @Override
    public Integer addBizClaimVoucherDetailByMainId(BizClaimVoucherDetail bizClaimVoucherDetail)
    {
        return bizClaimVoucherDetailMapper.addBizClaimVoucherDetailByMainId(bizClaimVoucherDetail);
    }

    @Override
    public Integer deleteClaimDetailById(Integer id) {
        return bizClaimVoucherDetailMapper.deleteClaimDetailById(id);
    }

    @Override
    public Integer deleteClaimDetailByMainId(Integer mainId) {

        return bizClaimVoucherDetailMapper.deleteClaimDetailByMainId(mainId);
    }
}
