package springbootjsp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class JspController {


    /**
     * ModelAndView
     * @param model
     * @return
     */
    @RequestMapping("/myjsp")
    public String doJsp(Model model) {
        model.addAttribute("data", "SpringBoot使用jsp");
        //视图的逻辑名称
        return "index";
    }
}
