package springbootcontainer;

import  org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import springbootcontainer.service.UserService;

@SpringBootApplication
public class SpringbootContainerApplication {

    public static void main(String[] args) {
        //获取容器对象
        //ConfigurableApplicationContext ctx = SpringApplication.run(SpringbootContainerApplication.class, args);
        ApplicationContext ctx = SpringApplication.run(SpringbootContainerApplication.class, args);
        //从容器中获取对象
        UserService userService = (UserService) ctx.getBean("userService");
        userService.SayHello("老六");
    }

}
