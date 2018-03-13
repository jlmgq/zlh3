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
@ContextConfiguration("classpath:applicationContext.xml")
public class ClaimEmployeeVoServiceImplTest {
    @Resource
    private ClaimEmployeeVoService claimEmployeeVoService;
    @Test
    public void queryClaimEmployeeVoByStatus() throws Exception {

    }

}