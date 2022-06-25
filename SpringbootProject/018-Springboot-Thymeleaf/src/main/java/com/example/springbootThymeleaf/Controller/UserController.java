package com.example.springbootThymeleaf.Controller;

import com.example.springbootThymeleaf.Bean.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class UserController {

    @RequestMapping("/userlist")
    public String userlist(Model model) {
        List<User> userList = new ArrayList<>();
        userList.add(new User(1, "吴锡祥", "66666", "捞仔"));
        userList.add(new User(2, "morries_wu", "888", "bali"));
        userList.add(new User(3, "lisa", "888", "bali"));
        userList.add(new User(4, "cool", "888", "bali"));
        model.addAttribute("userList", userList);
        return "userlist";
    }
}
