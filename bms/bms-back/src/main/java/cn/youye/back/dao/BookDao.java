package cn.youye.back.dao;

import cn.youye.back.entity.Book;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * Created by pc on 2016/7/25.
 */
public interface BookDao extends PagingAndSortingRepository<Book,String> {

    @Query(value = "SELECT * from book  where id=?1",nativeQuery = true)
    public Book get(String id);
}
