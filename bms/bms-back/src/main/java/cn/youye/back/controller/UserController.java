package cn.youye.back.controller;

import cn.youye.back.entity.User;
import cn.youye.back.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by pc on 2016/8/10.
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

//    @RequestMapping(value = "/login",method = RequestMethod.POST)
//    public String list(HttpServletRequest request, Model model){
//        String loginName=request.getParameter("loginName");
//        String password=request.getParameter("password");
//        User user=new User();
//        List<User> list=new ArrayList<>();
//        user.setLoginName(loginName);
//        user.setPassword(password);
//        list=userService.findAllList();
//        model.addAttribute("list",list);
//        return "modules/user/userList";
//    }
    @ResponseBody
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public Map<String,Object> list(HttpServletRequest request, HttpServletResponse response){
        Map<String,Object> map=new HashMap<>();
        String loginName=request.getParameter("loginName");
        String password=request.getParameter("password");
        User user=new User();
        List<User> list=new ArrayList<>();
        user.setLoginName(loginName);
        user.setPassword(password);
        list=userService.findAllList();
        map.put("data",list);
        return map;
    }

}
