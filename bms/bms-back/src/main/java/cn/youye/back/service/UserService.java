package cn.youye.back.service;

import cn.youye.back.dao.UserDao;
import cn.youye.back.entity.User;
import cn.youye.back.sys.common.CrudService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 单表Service
 * @author Youye
 * @version 2016-08-11
 */
@Service
@Transactional(readOnly = true)
public class UserService extends CrudService<UserDao, User> {

	public User get(String id) {
		return super.get(id);
	}
	
	public List<User> findList(User user) {
		return super.findList(user);
	}

	@Transactional(readOnly = false)
	public void save(User user) {
		super.save(user);
	}
	
	@Transactional(readOnly = false)
	public void delete(User user) {
		super.delete(user);
	}
	
}