package cn.yingchuang.jboa.biz_claim_voucher.service;

import cn.yingchuang.jboa.biz_claim_voucher.dao.BizClaimVoucherMapper;
import cn.yingchuang.jboa.biz_claim_voucher.entity.BizClaimVoucher;
import cn.yingchuang.jboa.biz_claim_voucher_detail.dao.BizClaimVoucherDetailMapper;
import cn.yingchuang.jboa.biz_claim_voucher_detail.entity.BizClaimVoucherDetail;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Administrator on 2018\3\13 0013.
 */
@Service
public class BizClaimVoucherServiceImpl implements BizClaimVoucherService {
    @Resource
    private BizClaimVoucherMapper bizClaimVoucherMapper;
    @Resource
    private BizClaimVoucherDetailMapper bizClaimVoucherDetailMapper;
    //测试方法
    @Override
    public List<BizClaimVoucher> queryAllBizClaimVoucher() {
        return bizClaimVoucherMapper.queryAllBizClaimVoucher();
    }

    @Override
    public Integer updateBizClaimVoucherTotalAndEventById(BizClaimVoucher bizClaimVoucher) {
        return bizClaimVoucherMapper.updateBizClaimVoucherTotalAndEventById(bizClaimVoucher);
    }

    @Override
    public BizClaimVoucher queryBizClaimVoucherById(Integer id) {
        return bizClaimVoucherMapper.queryBizClaimVoucherById(id);
    }

    @Override
    public Integer updateCheckDmAndCheckGmById(Integer id) {
        return bizClaimVoucherMapper.updateCheckDmAndCheckGmById(id);
    }

    @Override
    public Integer updateCheckDmById(Integer id) {
        return bizClaimVoucherMapper.updateCheckDmById(id);
    }

    @Override
    public Integer updateStatusById(String status, Integer id) {
        return bizClaimVoucherMapper.updateStatusById(status,id);
    }

    @Override
    public Integer updateCheckGmById(Integer id) {
        return bizClaimVoucherMapper.updateCheckGmById(id);
    }

    @Override
    public Integer updateCheckDmAndStatusById(Integer id) {
        return bizClaimVoucherMapper.updateCheckDmAndStatusById(id);
    }

    @Override
    public Integer updateCheckDmAndStatusById1(Integer id) {
        return bizClaimVoucherMapper.updateCheckDmAndStatusById1(id);
    }

    @Override
    public Integer updateAllStatus(Integer id) {
        return bizClaimVoucherMapper.updateAllStatus(id);
    }

    @Override
    public Integer deleteBizClaimVoucherById(Integer id) {
        bizClaimVoucherDetailMapper.deleteClaimDetailByMainId(id);

        return bizClaimVoucherMapper.deleteBizClaimVoucherById(id);
    }

    /*通过id  修改status 状态*/

    @Override
    public Integer updataBizClaimVoucherStatusById(Integer id) {

        return bizClaimVoucherMapper.updataBizClaimVoucherStatusById(id);
    }





    //    一起添加两个表的方法
    @Override
    public Integer addBizClaimVoucherAndBizClaimVoucherDetails
            (BizClaimVoucher bizClaimVoucher,
             List<BizClaimVoucherDetail> bizClaimVoucherDetails) {
        System.out.println(bizClaimVoucher);
        System.out.println(bizClaimVoucherDetails);
//        需求：事务，先增加大表，返回获得主键，
        Integer n = bizClaimVoucherMapper.addBizClaimVoucher(bizClaimVoucher);
        Integer bizClaimVoucherId = bizClaimVoucher.getId();
//        然后添加小表把大表主键放进去
        for (BizClaimVoucherDetail bizClaimVoucherDetail : bizClaimVoucherDetails) {
            if(bizClaimVoucherDetail != null){
                bizClaimVoucherDetail.setMainId(bizClaimVoucherId);
                Integer r = bizClaimVoucherDetailMapper.
                        addBizClaimVoucherDetailByMainId(
                                bizClaimVoucherDetail);
            }

        }
//        疑问：判断，如果小表添加后的r 的 数和大表数，加起来不对，应该回滚
        return n;
    }
}
