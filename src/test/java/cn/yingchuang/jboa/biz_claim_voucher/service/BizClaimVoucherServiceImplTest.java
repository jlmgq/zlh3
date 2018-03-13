package cn.yingchuang.jboa.biz_claim_voucher.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

/**
 * Created by 祖龙浩 on 2018/3/13.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class BizClaimVoucherServiceImplTest {

    @Resource
    private BizClaimVoucherService bizClaimVoucherService;

    @Test
    public void updateCheckDmAndCheckGmById() throws Exception {
        Integer rows = bizClaimVoucherService.updateCheckDmAndCheckGmById(1);
        System.out.println(rows);
    }

    @Test
    public void updateCheckDmById() throws Exception {
        Integer rows = bizClaimVoucherService.updateCheckDmById(1);
        System.out.println(rows);
    }

    @Test
    public void updateStatusById() throws Exception {
        Integer rows = bizClaimVoucherService.updateStatusById("呵呵",1);
        System.out.println(rows);
    }

    @Test
    public void updateCheckGmById() throws Exception {
        Integer rows = bizClaimVoucherService.updateCheckGmById(1);
        System.out.println(rows);
    }

    @Test
    public void updateCheckDmAndStatusById() throws Exception {
        Integer rows = bizClaimVoucherService.updateCheckDmAndStatusById(1);
        System.out.println(rows);
    }

    @Test
    public void updateCheckDmAndStatusById1() throws Exception {
        Integer rows = bizClaimVoucherService.updateCheckDmAndStatusById1(1);
        System.out.println(rows);
    }

    @Test
    public void updateAllStatus() throws Exception {
        Integer rows = bizClaimVoucherService.updateAllStatus(1);
        System.out.println(rows);
    }

}