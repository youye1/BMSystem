package cn.youye.back.entity;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;


/**
 * 单表Entity
 * @author Youye
 * @version 2016-08-11
 */
public class User extends DataEntity<User> {
	
	private static final long serialVersionUID = 1L;
	@NotEmpty
	private String name;		// 登录名
	private String password;		// 密码
	private String userName;		// 用户名
	private String phone;		// 联系方式
	private String imgurl;		// 头像
	private String introduction;		// 简介
	
	public User() {
		super();
	}

	public User(String id){
		super(id);
	}

	@Length(min=1, max=50, message="登录名长度必须介于 1 和 50 之间")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	@Length(min=1, max=50, message="密码长度必须介于 1 和 50 之间")
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	@Length(min=0, max=50, message="用户名长度必须介于 0 和 50 之间")
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	@Length(min=0, max=225, message="头像长度必须介于 0 和 225 之间")
	public String getImgurl() {
		return imgurl;
	}

	public void setImgurl(String imgurl) {
		this.imgurl = imgurl;
	}
	
	@Length(min=0, max=225, message="简介长度必须介于 0 和 225 之间")
	public String getIntroduction() {
		return introduction;
	}

	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}
	
}