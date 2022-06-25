package enterprise.Service;

import enterprise.Bean.User;

import java.util.List;

public interface UserService {
    List<User> login(String username, String userpassword);
}
