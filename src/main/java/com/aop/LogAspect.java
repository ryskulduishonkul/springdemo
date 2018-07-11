package com.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * 自定义切面
 * @author Holley
 * @create 2018-07-11 11:26
 **/
@Aspect
@Component
public class LogAspect {

    /*@Pointcut("@annotation(myAnnotation)")
    public void samePointCut(MyAnnotation myAnnotation){};*/
    /**
      * @Author holley
      * @Description 如果将注解添加在service的实现类方法上，则必须使用这种个参数的形式
      * 此方法也可以将切点抽出，以实现代码复用，如：
      * @Pointcut("@annotation(myAnnotation)")
        public void severLog(MyAnnotation myAnnotation){ }
        @After("severLog(myAnnotation)")
        public void after(JoinPoint joinPoint,MyAnnotation myAnnotation){ xxxxxxxxxxxxx }
      * @Date 2018/7/11 15:20
      * @Param
      * @return
      */
    @After("@annotation(myAnnotation)")
    public void after(JoinPoint joinPoint,MyAnnotation myAnnotation){
        MethodSignature signature = (MethodSignature)joinPoint.getSignature();
        Method m = signature.getMethod();
        System.out.println("注解式拦截器：" + myAnnotation.name());
    }
    /**
     * @Author holley
     * @Description 定义切入点
     * @Date 2018/7/11 11:41
     * @Param
     * @return
     */
    /*@Pointcut("@annotation(com.aop.MyAnnotation)")
    public void annotationPointCut(){};*/
    /**
      * @Author holley
      * @Description 使用此方法时，不能将注解放在service的实现类的方法上
      * 这是因为使用Jdk动态代理实现Spring AOP，getBean获得的对象是Jdk动态代理生成的代理类的对象，
      *     这个代理类只是实现了UserHelloService接口，而没有继承UserHelloServiceImpl，如果使用此方法，则获取不到注解内容。 使用CGLib动态代理不会有这个问题，
      *     因为CGLib动态代理生成的代理类是继承我们的目标类的，而不是实现目标接口。
      * @Date 2018/7/11 15:20
      * @Param
      * @return
      */
    /*@After("annotationPointCut()")
    public void aftermethod(JoinPoint joinPoint){
        MethodSignature signature = (MethodSignature)joinPoint.getSignature();
        Method m = signature.getMethod();
        MyAnnotation myAnnotation = m.getAnnotation(MyAnnotation.class);
        System.out.println("注解式拦截器：" + myAnnotation.name());
    }*/

    /**
     * @Author holley
     * @Description 第二种设置切点的方式
     * 第一个星号：表示返回类型，*号表示所有类型
     *  第二个星号：表示设置为切点的类名，*号表示所有的类
     *  第三个星号：表示设置为切点的类的方法名，*号表示该类中所有的方法
     *  括弧里表示方法的参数，两个点表示任何参数
     * @Date 2018/7/11 11:48
     * @Param
     * @return
     */
    @Pointcut("execution(* com.service.HelloJavaService..*.*(..))")
    public void otherPoinCut(){};
    @Before("otherPoinCut()")
    public void before(JoinPoint joinPoint){
        MethodSignature signature = (MethodSignature)joinPoint.getSignature();
        Method m = signature.getMethod();
        System.out.println("方法式拦截器：" + m.getName());
    }

}
