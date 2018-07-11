import com.config.MyConfig;
import com.controller.HelloController;
import com.scope.DemoPrototyService;
import com.scope.DemoSingletonService;
import com.service.AspectService;
import com.service.UserHelloService;
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
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MyConfig.class);
        UserHelloService userHelloService = (UserHelloService)context.getBean("userHelloService");
        System.out.println(userHelloService.useSayHello("holley"));
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

        MyConfig myConfig = context.getBean(MyConfig.class);
        myConfig.outputResource();
        context.close();
    }
}
