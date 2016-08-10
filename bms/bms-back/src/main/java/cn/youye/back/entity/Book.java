package cn.youye.back.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * Created by pc on 2016/7/25.
 */
@Entity
@Table(name="book")
public class Book extends BaseEntity{

    @NotNull
    private String name;        //书名
    private String author;      //作者
//
//    private String interpreter; //翻译者
//    private String publish;     //出版社
//    private String icon;        //封面
//    private String isbn;        //国际编号
//    private String description; //简介
//
//    @Column(name = "publish_date")
//    private Date publishDate;   //出版日期
//
//    @Column(name="print_count")
//    private int printCount;     //印刷次数
//
//    private double price;       //价格

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

//    public String getInterpreter() {
//        return interpreter;
//    }
//
//    public void setInterpreter(String interpreter) {
//        this.interpreter = interpreter;
//    }
//
//    public String getPublish() {
//        return publish;
//    }
//
//    public void setPublish(String publish) {
//        this.publish = publish;
//    }
//
//    public String getIcon() {
//        return icon;
//    }
//
//    public void setIcon(String icon) {
//        this.icon = icon;
//    }
//
//    public String getIsbn() {
//        return isbn;
//    }
//
//    public void setIsbn(String isbn) {
//        this.isbn = isbn;
//    }
//
//    public String getDescription() {
//        return description;
//    }
//
//    public void setDescription(String description) {
//        this.description = description;
//    }
//
//    public Date getPublishDate() {
//        return publishDate;
//    }
//
//    public void setPublishDate(Date publishDate) {
//        this.publishDate = publishDate;
//    }
//
//    public int getPrintCount() {
//        return printCount;
//    }
//
//    public void setPrintCount(int printCount) {
//        this.printCount = printCount;
//    }
//
//    public double getPrice() {
//        return price;
//    }
//
//    public void setPrice(double price) {
//        this.price = price;
//    }
}
