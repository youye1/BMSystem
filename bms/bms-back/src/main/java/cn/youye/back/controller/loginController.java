package cn.youye.back.controller;

import cn.youye.back.entity.User;
import cn.youye.back.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Created by pc on 2016/6/17.
 */
@Controller
public class loginController {

    @Autowired
    UserService userService;

    @RequestMapping(value = "/login")
    public String login(HttpServletRequest request, HttpServletResponse response, Model model) {
        User user = new User();
        user.setName(request.getParameter("userName"));
        user.setDelFlag("0");
        List<User> users = userService.findList(user);
        if (users != null && users.size() > 0) {
            return "redirect:"+"/book/";
        } else {
            model.addAttribute("msg", "登录出错");
            return "modules/sys/login";
        }
    }

    @RequestMapping(value = "/register", method = {RequestMethod.POST, RequestMethod.GET})
    public String register(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return "modules/sys/register";
    }
}
