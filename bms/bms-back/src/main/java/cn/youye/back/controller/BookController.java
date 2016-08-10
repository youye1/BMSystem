package cn.youye.back.controller;

import cn.youye.back.entity.Book;
import cn.youye.back.service.BookService;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.util.*;

/**
 * Created by pc on 2016/7/25.
 */
@Controller
@RequestMapping("/book")
public class BookController {

    private static Logger logger = Logger.getLogger(BookController.class);

    @Autowired
    private BookService bookService;

    @RequestMapping("/save")
    public String save(Model model) {
        List<Book> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Book book = new Book();
            book.setId(UUID.randomUUID().toString());
            book.setName("雨季不再来" + i);
            book.setAuthor("三毛");
            bookService.save(book);
        }
        model.addAttribute("msg", "hello");
        logger.debug("123333333333");
        return "modules/test/test1";
    }

    @ResponseBody
    @RequestMapping("/findList")
    public JSONArray findAll() {
        List<Book> list = bookService.findBook();
        return null;
    }

    @ResponseBody
    @RequestMapping("/findList2")
    public Map<String, Object> findAll2(HttpServletResponse response) {
        response.setContentType("application/json");
        Map<String, Object> map = new HashMap<>();
        List<Book> list = bookService.findBook();
        map.put("data", JSONObject.toJSON(list));
        return map;
    }

    @ResponseBody
    @RequestMapping("/get")
    public Book get() {
        String id = "9a92a147-a64c-4dad-80de-a6112a2ab179";
        return bookService.get(id);
    }

}
