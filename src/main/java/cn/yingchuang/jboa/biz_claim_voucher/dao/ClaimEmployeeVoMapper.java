package cn.yingchuang.jboa.biz_claim_voucher.dao;

import cn.yingchuang.jboa.biz_claim_voucher.entity.ClaimEmployeeVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by 祖龙浩 on 2018/3/13.
 */
public interface ClaimEmployeeVoMapper {

    /**
     * 部门经理查询所有待审核的报销单
     * @param status 报销单的审核状态
     * @return
     */
    List<ClaimEmployeeVo> queryClaimEmployeeVoByStatus(@Param("status") String status);


    /**
     *根据总经理的审核状态，查询所有给财务查阅和操作
     * @param status
     * @return
     */
    List<ClaimEmployeeVo> queryClaimEmployeeVoByCheckGM(@Param("status") String status);


    /**
     *  根据部门经理的审核状态 和金额>5000 查询所有 给总经理查看和操作
     * @param status
     * @return
     */
    List<ClaimEmployeeVo> queryClaimEmployeeVoByCheckDMAndMoney(@Param("status") String status);

    /**
     * 按报销单Id查询报销单及填写用户的基本信息
     * @param id
     * @return
     */
    ClaimEmployeeVo queryClaimEmployeeVoById(@Param("id") Integer id);

    /**
     * 根据员工编号查询所有报销单
     * @return
     */
    List<ClaimEmployeeVo> queryClaimEmployeeVoByCreateSn(@Param("sn")Integer createSn);
}
