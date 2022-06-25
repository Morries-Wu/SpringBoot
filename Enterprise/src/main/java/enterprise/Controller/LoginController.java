package enterprise.Controller;

import enterprise.Bean.User;
import enterprise.Service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;


@Controller
public class LoginController {

    /*注入UserService*/
    @Resource
    private UserService userService;

    @RequestMapping("/loginPage")
    public String loginPage() {
        return "login";
    }

    @RequestMapping("login")
    public String login(String username, String userpassword, String code, HttpSession session, Model model) {
        /*从session中获取验证码*/
        String vrifyCode = (String) session.getAttribute("vrifyCode");
        /*判断验证码和输入验证码*/
        if (code != null && !"".equals(code) && vrifyCode.equals(code)) {
            /*查询用户*/
            List<User> userList = userService.login(username, userpassword);
            /*跳转首页*/
            if (userList.size() > 0) {
                /*把用户信息存入session*/
                session.setAttribute("user", userList.get(0));
                return "redirect:queryAuctions";
            } else {
                model.addAttribute("errorMsg", "用户名或密码出错");
                return "login";
            }
        } else {
            model.addAttribute("errorMsg", "验证码错误");
            return "login";
        }

    }
}
