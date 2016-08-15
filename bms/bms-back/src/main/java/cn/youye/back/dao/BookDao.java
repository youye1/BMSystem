package cn.youye.back.dao;

import cn.youye.back.entity.Book;
import cn.youye.back.sys.common.CrudDao;
import org.springframework.stereotype.Repository;

/**
 * jpa连接数据库查询方式
 * Created by pc on 2016/7/25.
 */
//public interface BookDao extends PagingAndSortingRepository<Book,String> {
//
//    @Query(value = "SELECT * from book  where id=?1",nativeQuery = true)
//    public Book get(String id);
//}
@Repository("BookDao")
public interface BookDao extends CrudDao<Book> {

}