package com.lzj.test;

import com.lzj.dao.BookDao;
import com.lzj.dao.impl.BookDaoImpl;
import com.lzj.pojo.Book;
import com.lzj.pojo.Page;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.*;

public class BookDaoTest {

    BookDao bookDao = new BookDaoImpl();

    @Test
    public void addBoook() {

        System.out.println(bookDao.addBoook(new Book(null,"钢铁是怎样炼成的","保尔柯察金",new BigDecimal(19.9),11,89,null)));;
    }

    @Test
    public void deleteBookById() {
        System.out.println(bookDao.deleteBookById(21));
    }

    @Test
    public void updateBook() {
        System.out.println(bookDao.updateBook(new Book(21,"钢铁无法练成","柯察金",new BigDecimal(19.9),11,89,null)));

    }

    @Test
    public void queryBookById() {
        System.out.println(bookDao.queryBookById(21));
    }

    @Test
    public void queryBooks() {
        for (Book book:bookDao.queryBooks()) {
            System.out.println(book);
        }
    }

    @Test
    public void queryForPageTotalCount() {
        Integer integer = bookDao.queryForPageTotalCount();
        System.out.println(integer);
    }

    @Test
    public void queryForItems() {
        //String sql = "select `id` ,`name` , `author` , `price` , `sales` , `stock` , `img_path` imgPath from t_book limit ?,?";
        //return queryForList(Book.class, sql, begin,pageSize);
        List<Book> books = bookDao.queryForItems(0, Page.PAGE_SIZE);
        books.forEach(System.out::println);
        //books.forEach(item-> System.out.println());
    }

    @Test
    public void queryForPageTotalCountByPrice() {
        System.out.println(bookDao.queryForPageTotalCountByPrice(50, 100));
    }

    @Test
    public void queryForItemsByPrice() {
        bookDao.queryForItemsByPrice(1, Page.PAGE_SIZE, 50, 100).forEach(System.out::println);
    }
}