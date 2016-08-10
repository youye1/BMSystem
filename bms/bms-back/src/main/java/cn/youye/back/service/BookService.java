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
@Transactional
public class BookService {

    @Autowired
    private BookDao bookDao;

    public void save(Book book) {
        bookDao.save(book);
    }

    public List<Book> findBook() {
        return (List<Book>) bookDao.findAll();
    }

    public Book get(String id) {
        return bookDao.get(id);
    }
}
