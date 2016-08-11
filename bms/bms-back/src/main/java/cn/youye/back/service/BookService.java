package cn.youye.back.service;

import cn.youye.back.dao.BookDao;
import cn.youye.back.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by pc on 2016/7/25.
 */
@Service
@Transactional(readOnly = true)
public class BookService extends CrudService<BookDao,Book> {

    public Book get(String id) {
        return super.get(id);
    }

    public List<Book> findList(Book book) {
        return super.findList(book);
    }

//    public Page<Book> findPage(Page<Book> page, Book book) {
//        return super.findPage(page, book);
//    }

    @Transactional(readOnly = false)
    public void save(Book book) {
        super.save(book);
    }

    @Transactional(readOnly = false)
    public void delete(Book book) {
        super.delete(book);
    }
}
