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
        user.setLoginName(request.getParameter("loginName"));
        user.setDelFlag("0");
        List<User> users = userService.findAllList();
        if (users != null && users.size() > 0) {
            model.addAttribute("user",users.get(0));
            return "modules/test/success";
        } else {
            return "modules/test/failed";
        }
    }

    @RequestMapping(value = "/register", method = {RequestMethod.POST, RequestMethod.GET})
    public String register(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return "modules/sys/register";
    }

}
