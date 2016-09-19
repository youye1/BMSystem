package cn.youye.back.controller;

import cn.youye.back.entity.Book;
import cn.youye.back.entity.Type;
import cn.youye.back.service.BookService;
import cn.youye.back.service.TypeService;
import cn.youye.back.sys.common.BaseController;
import cn.youye.back.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.List;

/**
 * Created by pc on 2016/7/25.
 */
@Controller
@RequestMapping("/book")
public class BookController extends BaseController {
    @Autowired
    private BookService bookService;
    @Autowired
    TypeService typeService;

    @ModelAttribute
    public Book get(@RequestParam(required = false) String id) {
        Book entity = null;
        if (StringUtils.isNotBlank(id)) {
            entity = bookService.get(id);
        }
        if (entity == null) {
            entity = new Book();
        }
        return entity;
    }

    @RequestMapping(value = {"list", ""})
    public String list(Book book, HttpServletRequest request, HttpServletResponse response, Model model) {
//        Page<Book> page = bookService.findPage(new Page<Book>(request, response), book);
//        model.addAttribute("page", page);
        List<Book> list = bookService.findList(book);
        model.addAttribute("list", list);
        return "modules/book/bookList";
    }

    @RequestMapping(value = "form")
    public String form(Book book, Model model) {
        List<Type> list=typeService.findList(new Type());
        model.addAttribute("list",list);
        model.addAttribute("book", book);
        return "modules/book/bookForm";
    }

    @RequestMapping(value = "save")
    public String save(Book book, Model model, RedirectAttributes redirectAttributes) {
        if (!beanValidator(model, book)) {
            return form(book, model);
        }
        if (StringUtils.isBlank(book.getCount())) {
            book.setCount(null);
        }
        if (StringUtils.isBlank(book.getPrice())) {
            book.setPrice(null);
        }
        book.setUpdateDate(new Date());
        bookService.save(book);
        addMessage(redirectAttributes, "保存单表成功");
        return "redirect:" + "/book/?repage";
    }

    @RequestMapping(value = "delete")
    public String delete(Book book, RedirectAttributes redirectAttributes) {
        bookService.delete(book);
        addMessage(redirectAttributes, "删除单表成功");
        return "redirect:" + "/book/?repage";
    }


}
