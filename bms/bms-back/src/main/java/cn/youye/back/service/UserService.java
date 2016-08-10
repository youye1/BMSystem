package cn.youye.back.service;

import cn.youye.back.dao.UserDao;
import cn.youye.back.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * Created by pc on 2016/8/10.
 */
@Service
public class UserService {

    @Autowired
    UserDao userDao;

    public List<User> findAllList() {

        return userDao.findAllList();
    }
    public List<User> get(User user){
        return userDao.get(user);
    }
}
