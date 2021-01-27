package com.my.emplogin.config;

import cn.hutool.system.SystemUtil;
import com.my.emplogin.annotation.Operation;
import com.my.emplogin.entity.SysLog;
import com.my.emplogin.service.LogService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;

/**
 * 日志切面类
 *
 * @author : tanghuai
 * @date : 2021/1/15 10:12
 */
@Aspect
@Component
public class LogAspect {

    @Resource
    private LogService logService;

    /**
     * 定义切点，在注解位置切入代码
     */
    @Pointcut("@annotation(com.my.emplogin.annotation.Operation)")
    public void logPointCut(){}

    @AfterReturning("logPointCut()")
    public void saveLog(JoinPoint joinPoint) {
        // 保存日志
        SysLog sysLog = new SysLog();
        // 从切面织入点处通过反射机制获取织入点处的方法
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        // 获取切入点所在方法
        Method method = signature.getMethod();

        // 获取操作
        Operation operation = method.getAnnotation(Operation.class);
        if (operation != null){
            String value = operation.value();
            sysLog.setRequestDesc(value);
        }

        // 获取请求的类名
        String className = joinPoint.getTarget().getClass().getName();
        // 获取请求的方法名
        String methodName = method.getName();

        // IP地址获取工具hutool
        sysLog.setUserIp(SystemUtil.getHostInfo().getAddress());
        sysLog.setRequestMethod(className+"."+methodName);

        // 从请求中获取userId
        ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
        HttpServletRequest request = attr.getRequest();
        sysLog.setUserId((String) request.getAttribute("userId"));
        // 保存日志到数据库
        logService.saveLog(sysLog);
    }
}
