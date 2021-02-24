package com.lzj.test;

import com.lzj.dao.BookDao;
import com.lzj.dao.impl.BookDaoImpl;
import com.lzj.pojo.Book;
import com.lzj.pojo.Page;
import com.lzj.service.BookService;
import com.lzj.service.impl.BookServiceImpl;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class BookServiceTest {

    BookService bookService = new BookServiceImpl();
    @Test
    public void addBook() {
        bookService.addBook(new Book(null,"钢铁是怎样炼成的","保尔柯察金",new BigDecimal(19.9),11,89,null));
    }

    @Test
    public void deleteBookById() {
    }

    @Test
    public void updateBook() {
        bookService.updateBook(new Book(23,"钢铁能练成","保尔",new BigDecimal(19.9),11,89,null));
    }

    @Test
    public void queryBookById() {
        System.out.println(bookService.queryBookById(23));
    }

    @Test
    public void queryBooks() {
        //System.out.println(Arrays.asList(bookService.queryBooks()));
        for (Book book :
                bookService.queryBooks()) {
            System.out.println(book);
        }
    }

    @Test
    public void page() {
        Page<Book> page = bookService.page(1, 4);
        System.out.println(page);
    }

    @Test
    public void pageByPrice() {
        System.out.println(bookService.pageByPrice(1, 4, 50, 100));
    }
}