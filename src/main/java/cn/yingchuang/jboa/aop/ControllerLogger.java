package cn.yingchuang.jboa.aop;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;

import java.util.Arrays;

/**
 * Created by Administrator on 2018/3/2 0002.
 */
public class ControllerLogger {
    private static  final Logger log = Logger.getLogger("ControllerLogger");
    public  void  before(JoinPoint jp){
        log.info("before  《《调用了"+jp.getTarget()+"的"+jp.getSignature().getName()+"方法，入参是"+ Arrays.toString(jp.getArgs()));
    }

    public void after(JoinPoint jp, Object result){
        log.info("after  《《调用了"+jp.getTarget()+"的"+jp.getSignature().getName()+"方法，返回参数是"+result);
    }
}
