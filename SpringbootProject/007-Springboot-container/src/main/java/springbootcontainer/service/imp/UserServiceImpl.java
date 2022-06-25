package springbootcontainer.service.imp;

import org.springframework.stereotype.Service;
import springbootcontainer.service.UserService;

@Service("userService")
public class UserServiceImpl implements UserService {

    @Override
    public void SayHello(String name) {
        System.out.println("执行了业务方法的SayHello:" + name);
    }
}
