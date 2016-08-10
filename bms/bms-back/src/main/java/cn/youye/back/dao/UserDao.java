package cn.youye.back.dao;

import cn.youye.back.entity.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("userDao")
public interface UserDao {

    List<User> findAllList();

    List<User> get(User user);

}