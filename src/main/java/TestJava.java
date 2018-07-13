import com.config.MyConfig;
import com.service.ProfileJavaBean;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * 测试配置不同环境调用不同的javaBean
 * @author Holley
 * @create 2018-07-11 10:35
 **/
public class TestJava {

    public static void main(String[] args){
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        // 先设置环境
        context.getEnvironment().setActiveProfiles("dev");
        // 再注册bean
        context.register(MyConfig.class);
        // 刷新容器
        context.refresh();
        ProfileJavaBean javaBean = context.getBean(ProfileJavaBean.class);
        System.out.println(javaBean.getContent());
        context.close();
    }
}
