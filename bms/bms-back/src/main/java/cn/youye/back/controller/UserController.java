package cn.youye.back.controller;

import cn.youye.back.entity.User;
import cn.youye.back.service.UserService;
import cn.youye.back.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 单表Controller
 *
 * @author Youye
 * @version 2016-08-11
 */
@Controller
@RequestMapping(value = "/user")
public class UserController extends BaseController {

    @Autowired
    private UserService userService;

    @ModelAttribute
    public User get(@RequestParam(required = false) String id) {
        User entity = null;
        if (StringUtils.isNotBlank(id)) {
            entity = userService.get(id);
        }
        if (entity == null) {
            entity = new User();
        }
        return entity;
    }

    @RequestMapping(value = {"list", ""})
    public String list(User user, HttpServletRequest request, HttpServletResponse response, Model model) {
//		Page<User> page = userService.findPage(new Page<User>(request, response), user);
        List<User> list = userService.findList(user);
        model.addAttribute("list", list);
        return "modules/user/userList";
    }

    @RequestMapping(value = "form")
    public String form(User user, Model model) {
        model.addAttribute("user", user);
        return "modules/user/userForm";
    }

    @RequestMapping(value = "save")
    public String save(User user, Model model, RedirectAttributes redirectAttributes) {
        if (!beanValidator(model, user)) {
            return form(user, model);
        }
        userService.save(user);
        addMessage(redirectAttributes, "保存单表成功");
        return "redirect:" + "/user/?repage";
    }

    @RequestMapping(value = "delete")
    public String delete(User user, RedirectAttributes redirectAttributes) {
        userService.delete(user);
        addMessage(redirectAttributes, "删除单表成功");
        return "redirect:" + "/user/?repage";
    }

}