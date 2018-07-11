import com.config.MyConfig;
import com.controller.HelloController;
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
        context.close();
    }
}
