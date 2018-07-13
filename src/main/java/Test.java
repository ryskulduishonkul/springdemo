import com.config.MyConfig;
import com.config.ThreadConfig;
import com.service.taskservice.AsyncTaskService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * 请输入一段话进行描述
 *
 * @author Holley
 * @create 2018-07-06 11:42
 **/
public class Test {
    public static void main(String[] args){
        // 使用AnnotationConfigApplicationContext作为spring容器
        //AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MyConfig.class);
        // 可以使用aop
        /*UserHelloService userHelloService = (UserHelloService)context.getBean("userHelloService");
        System.out.println(userHelloService.useSayHello("holley"));*/
        // 可以使用aop
        /*HelloController helloController = context.getBean(HelloController.class);
        System.out.println(helloController.hello("holley Java"));*/
        // 可以使用aop
        /*AspectService aspectService = context.getBean(AspectService.class);
        System.out.println(aspectService.sayhello("test"));*/

        // 验证scope模式
        /*DemoSingletonService demoSingletonService1 = (DemoSingletonService)context.getBean("demoSingletonService");
        DemoSingletonService demoSingletonService2 = (DemoSingletonService)context.getBean("demoSingletonService");
        System.out.println("demoSingletonService1与demoSingletonService2是否相等：" + demoSingletonService1.equals(demoSingletonService2));
        DemoPrototyService demoPrototyService1 = (DemoPrototyService)context.getBean("demoPrototyService");
        DemoPrototyService demoPrototyService2 = (DemoPrototyService)context.getBean("demoPrototyService");
        System.out.println("demoPrototyService1与demoPrototyService2是否相等：" + demoPrototyService1.equals(demoPrototyService2));*/
        // 测试资源调用（配置文件的注入）
        /*MyConfig myConfig = context.getBean(MyConfig.class);
        myConfig.outputResource();*/
        // 测试自定义事件发布
        /*EventPublish eventPublish = context.getBean(EventPublish.class);
        eventPublish.publish("发布事件-创建事件-事件监听器；");*/
        // 测试调用容器服务来获取beanName和加载的文件内容
        /*AwareService awareService = (AwareService)context.getBean("awareService");
        awareService.output();*/
        // 测试异步方法不是按顺序执行
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ThreadConfig.class);
        /*AsyncTaskService asyncTaskService = (AsyncTaskService)context.getBean("asyncTaskService");
        for(int i=0;i<10;i++){
            asyncTaskService.eat(i);
            asyncTaskService.drink(i);
        }*/

        // context.close();
    }
}
