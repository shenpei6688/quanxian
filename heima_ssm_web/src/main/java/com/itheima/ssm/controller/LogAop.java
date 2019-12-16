package com.itheima.ssm.controller;

import com.itheima.ssm.domain.SysLog;
import com.itheima.ssm.service.ISysLogService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.util.Date;

@Component
@Aspect
public class LogAop {
    @Autowired
    private HttpServletRequest httpServletRequest;
    @Autowired
    private ISysLogService iSysLogService;

    private Class clazz;
    private Method method;
    private Date visitTime;


    //获取访问的操作者，获取访问的url，获取执行的时长
    @After("execution(* com.itheima.ssm.controller.*.*(..))")
    public void doAfter(JoinPoint jp) throws Exception {

        long time = System.currentTimeMillis() - visitTime.getTime();
        String ip;
        String url = null;
        //需要通过反射完成操作
        if (clazz != null && method != null && clazz != LogAop.class) {
      //获取类上的注解 @RequestMapping("/findById.do")
     //为什么要强转为requestmapping annotation?????

            RequestMapping classAnnotation = (RequestMapping) clazz.getAnnotation(RequestMapping.class);
            if (classAnnotation != null) {
                String[] classvalue = classAnnotation.value();
                //获取方法上注解值
                RequestMapping methodAnnotation = method.getAnnotation(RequestMapping.class);
                if (methodAnnotation != null) {
                    String[] methodvalue = methodAnnotation.value();
                    System.out.println(classvalue[0] + methodvalue);
                    System.out.println(classvalue[0] + methodvalue[0]);
                    url = classvalue[0] + methodvalue[0];


                    // 获取ip地址，通过request对象就可以获取，在web.xml中配置listener，contextloaderlistener
                    ip = httpServletRequest.getRemoteAddr();
                    System.out.println(ip);
                    // 获取操作者：可以通过springsecurity获取操作者，从上下文中获取当前登录的用户对象
                    SecurityContext context = SecurityContextHolder.getContext();
                    User user =(User)context.getAuthentication().getPrincipal();
                    String username = user.getUsername();
                    //将日志的相关信息封装到对象
                    SysLog sysLog = new SysLog();
                    sysLog.setExecutionTime(time);
                    sysLog.setIp(ip);
                    sysLog.setMethod("[类名]"+clazz.getName()+method.getName());

                    sysLog.setUrl(url);
                    sysLog.setUsername(username);
                    sysLog.setVisitTime(visitTime);
                    iSysLogService.save(sysLog);


                }
            }
        }


    }

    //拦截所有的controller写的所有类的所有方法
    //主要获取开始时间 执行哪个类 执行的哪个方法
    @Before("execution(* com.itheima.ssm.controller.*.*(..))")
    public void doBefore(JoinPoint jp) throws NoSuchMethodException {
        visitTime = new Date();
        //访问的类
        clazz = jp.getTarget().getClass();
        //获取访问方法的名字
        String methodname = jp.getSignature().getName();
        //获取访问方法的参数
        Object[] args = jp.getArgs();
        if (args == null || args.length == 0) {
            method = clazz.getMethod(methodname);//只能获取无参数的方法

        } else {
            //获取参数的所有类型
            Class[] classArgs = new Class[args.length];
            for(int i=0;i<args.length;i++){
                classArgs[i]=args[i].getClass();
            }
            method = clazz.getMethod(methodname, classArgs);

        }


    }
}
