package cn.youye.back.entity;


import com.fasterxml.jackson.annotation.JsonFormat;
import org.hibernate.validator.constraints.Length;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * Created by pc on 2016/7/25.
 */

//@Entity
//@Table(name="book")
public class Book extends DataEntity<Book> {

	private static final long serialVersionUID = 1L;
	private String name;		// 书名
	private String author;		// 作者
	private String interpreter;		// 译者
	private String type;		// 类别
	private String publish;		// 出版社
	private String price;		// 价格
	private String count;		// 总页数
	private Date printDate;		// 出版日期
	private String imgurl;		// 封面图URL
	private String description;		// 书籍介绍文本路径

	public Book() {
		super();
	}

	public Book(String id){
		super(id);
	}

	@Length(min=1, max=50, message="书名长度必须介于 1 和 50 之间")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Length(min=0, max=50, message="作者长度必须介于 0 和 50 之间")
	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	@Length(min=0, max=50, message="译者长度必须介于 0 和 50 之间")
	public String getInterpreter() {
		return interpreter;
	}

	public void setInterpreter(String interpreter) {
		this.interpreter = interpreter;
	}

	@Length(min=1, max=50, message="类别长度必须介于 1 和 50 之间")
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Length(min=0, max=50, message="出版社长度必须介于 0 和 50 之间")
	public String getPublish() {
		return publish;
	}

	public void setPublish(String publish) {
		this.publish = publish;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	@Length(min=0, max=11, message="总页数长度必须介于 0 和 11 之间")
	public String getCount() {
		return count;
	}

	public void setCount(String count) {
		this.count = count;
	}

	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getPrintDate() {
		return printDate;
	}

	public void setPrintDate(Date printDate) {
		this.printDate = printDate;
	}

	public String getImgurl() {
		return imgurl;
	}

	public void setImgurl(String imgurl) {
		this.imgurl = imgurl;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
