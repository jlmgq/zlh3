package cn.yingchuang.jboa.biz_claim_voucher.service;

import cn.yingchuang.jboa.biz_claim_voucher.entity.ClaimEmployeeVo;
import cn.yingchuang.jboa.command.util.PageUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by 祖龙浩 on 2018/3/13.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class ClaimEmployeeVoServiceImplTest {
    @Test
    public void queryClaimEmployeeVoById() throws Exception {
       ClaimEmployeeVo claimEmployeeVo = claimEmployeeVoService.queryClaimEmployeeVoById(1);
        System.out.println(claimEmployeeVo);
    }

    @Test
    public void queryClaimEmployeeVoByStatus() throws Exception {
        PageUtil<ClaimEmployeeVo> pageUtil = claimEmployeeVoService.queryClaimEmployeeVoByStatus(1, 4, "新建");
        List<ClaimEmployeeVo> list = pageUtil.getRows();
        for (ClaimEmployeeVo claimEmployeeVo : list) {
            System.out.println(claimEmployeeVo);
        }
    }

    @Test
    public void queryClaimEmployeeVoByCheckGM() throws Exception {
        PageUtil<ClaimEmployeeVo> pageUtil = claimEmployeeVoService.queryClaimEmployeeVoByCheckGM(1, 2, "审核通过");
        List<ClaimEmployeeVo> list = pageUtil.getRows();
        for (ClaimEmployeeVo claimEmployeeVo : list) {
            System.out.println(claimEmployeeVo);
        }

    }

    @Test
    public void queryClaimEmployeeVoByCheckDMAndMoney() throws Exception {
        PageUtil<ClaimEmployeeVo> pageUtil = claimEmployeeVoService.queryClaimEmployeeVoByCheckDMAndMoney(1, 2, "审核通过");
        List<ClaimEmployeeVo> list = pageUtil.getRows();
        for (ClaimEmployeeVo claimEmployeeVo : list) {
            System.out.println(claimEmployeeVo);
        }
    }

    @Resource
    private ClaimEmployeeVoService claimEmployeeVoService;


}