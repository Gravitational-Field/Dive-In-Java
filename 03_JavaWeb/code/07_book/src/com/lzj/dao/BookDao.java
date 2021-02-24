package com.lzj.dao;

import com.lzj.pojo.Book;
import org.omg.CORBA.PUBLIC_MEMBER;

import java.util.List;

public interface BookDao {

    public int addBoook(Book book);

    public int deleteBookById(Integer id);

    public int updateBook(Book book);

    public Book queryBookById(Integer id);

    public List<Book> queryBooks( );

    public Integer queryForPageTotalCount();

    public List<Book> queryForItems(Integer begin, Integer pageSize);


    public Integer queryForPageTotalCountByPrice(Integer min, Integer max);

    public List<Book> queryForItemsByPrice(Integer begin, Integer pageSize, Integer min, Integer max);
}
