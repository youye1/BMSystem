package cn.youye.back.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import org.hibernate.validator.constraints.Length;

/**
 * 单表Entity
 * @author Youye
 * @version 2016-08-11
 */
public class Type extends DataEntity<Type> {
	
	private static final long serialVersionUID = 1L;
	private String name;		// 名称
	private Type parent;		// 父类别
	
	public Type() {
		super();
	}

	public Type(String id){
		super(id);
	}

	@Length(min=1, max=50, message="名称长度必须介于 1 和 50 之间")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	@JsonBackReference
	public Type getParent() {
		return parent;
	}

	public void setParent(Type parent) {
		this.parent = parent;
	}
	
}