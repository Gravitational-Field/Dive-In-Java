package com.lzj.service.impl;


import com.lzj.dao.BookDao;
import com.lzj.dao.impl.BookDaoImpl;
import com.lzj.pojo.Book;
import com.lzj.pojo.Page;
import com.lzj.service.BookService;

import java.util.List;

public class BookServiceImpl implements BookService {
    BookDao bookDao = new BookDaoImpl();

    @Override
    public void addBook(Book book) {
        bookDao.addBoook(book);
    }

    @Override
    public void deleteBookById(Integer id) {
        bookDao.deleteBookById(id);
    }

    @Override
    public void updateBook(Book book) {
        bookDao.updateBook(book);
    }



    @Override
    public Book queryBookById(Integer id) {
        return bookDao.queryBookById(id);
    }

    @Override
    public List<Book> queryBooks() {
        return bookDao.queryBooks();
    }

    @Override
    public Page<Book> page(Integer pageNo, Integer pageSize) {
        Page<Book> page = new Page<Book>();
        //求pageTotal、pageTotalCount、items
        Integer pageTotalCount = bookDao.queryForPageTotalCount();
        Integer pageTotal = pageTotalCount/pageSize;
        if(pageTotalCount%pageSize > 0){
            pageTotal += 1;
        }

        page.setPageSize(pageSize);
        page.setPageTotal(pageTotal);
        page.setPageTotalCount(pageTotalCount);
        //有顺序
        page.setPageNo(pageNo);
        Integer begin = (page.getPageNo()-1)*pageSize;
        List<Book> items = bookDao.queryForItems(begin,pageSize);
        page.setItems(items);


        return page;
    }

    @Override
    public Page<Book> pageByPrice(Integer pageNo, Integer pageSize, Integer min, Integer max) {
        Page<Book> page = new Page<>();
        //求pageTotal、pageTotalCount、items
        Integer pageTotalCount = bookDao.queryForPageTotalCountByPrice(min, max);
        Integer pageTotal = pageTotalCount/pageSize;
        if(pageTotalCount%pageSize > 0){
            pageTotal += 1;
        }

        page.setPageSize(pageSize);
        page.setPageTotal(pageTotal);
        page.setPageTotalCount(pageTotalCount);
        //有顺序
        page.setPageNo(pageNo);
        Integer begin = 0;
        List<Book> items = bookDao.queryForItemsByPrice(begin,page.getPageSize(),min,max);
        page.setItems(items);


        return page;
    }
}
