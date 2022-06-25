package springbootcommandlinerunner.service.imp;

import org.springframework.stereotype.Service;
import springbootcommandlinerunner.service.HelloService;

@Service("helloService")
public class HelloServiceImpl implements HelloService {
    @Override
    public String sayHello(String name) {
        return "你好:" + name;
    }
}
