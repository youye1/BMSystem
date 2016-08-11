/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package cn.youye.back.service;

import cn.youye.back.dao.TypeDao;
import cn.youye.back.entity.Type;
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
public class TypeService extends CrudService<TypeDao, Type> {

	public Type get(String id) {
		return super.get(id);
	}
	
	public List<Type> findList(Type type) {
		return super.findList(type);
	}
	
//	public Page<Type> findPage(Page<Type> page, Type type) {
//		return super.findPage(page, type);
//	}
//
	@Transactional(readOnly = false)
	public void save(Type type) {
		super.save(type);
	}
	
	@Transactional(readOnly = false)
	public void delete(Type type) {
		super.delete(type);
	}
	
}