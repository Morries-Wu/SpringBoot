package enterprise.Service.impl;

import enterprise.Bean.User;
import enterprise.Bean.UserExample;
import enterprise.Mapper.UserMapper;
import enterprise.Service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Resource
    private UserMapper userMapper;

    @Override
    public List<User> login(String username, String userpassword) {
        UserExample userExample = new UserExample();
        /*创建标准的查询*/
        UserExample.Criteria criteria = userExample.createCriteria();
        /*username='admin'*/
        criteria.andUsernameEqualTo(username);
        criteria.andUserpasswordEqualTo(userpassword);
        /*select * from user where username=? and userpassword=?*/
        return userMapper.selectByExample(userExample);
    }
}
