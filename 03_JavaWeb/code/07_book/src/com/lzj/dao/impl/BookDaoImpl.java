package com.lzj.dao.impl;

import com.lzj.dao.BookDao;
import com.lzj.pojo.Book;

import java.util.List;

public class BookDaoImpl extends BaseDao implements BookDao {
    @Override
    public int addBoook(Book book) {
        String sql = "insert into t_book(`name` , `author` , `price` , `sales` , `stock` , `img_path`) " +
                "values(?,?,?,?,?,?)";
        return update(sql,book.getName(),book.getAuthor(),book.getPrice(),book.getSales(),book.getStock(),book.getImgPath());
    }

    @Override
    public int deleteBookById(Integer id) {
        String sql = "delete from t_book where id=?";
        return update(sql,id);
    }

    @Override
    public int updateBook(Book book) {
        String sql = "update t_book set `name`=?,`author`=?,`price`=?,`sales`=?,`stock`=?,`img_path`=? where id = ?";
        return update(sql,book.getName(),book.getAuthor(),book.getPrice(),book.getSales(),book.getStock(),book.getImgPath(),book.getId());
    }

    @Override
    public Book queryBookById(Integer id) {
        String sql = "select `id` ,`name` , `author` , `price` , `sales` , `stock` , `img_path` imgPath from t_book where id=?";
        return queryForOne(Book.class,sql,id);
    }

    @Override
    public List<Book> queryBooks() {
        String sql = "select `id` ,`name` , `author` , `price` , `sales` , `stock` , `img_path` imgPath from t_book";
        return queryForList(Book.class,sql);
    }

    @Override
    public Integer queryForPageTotalCount() {
        String sql = "select count(*) from t_book";
        Number count = (Number) querySingleValue(sql);
        return count.intValue();
    }



    @Override
    public List<Book> queryForItems(Integer begin, Integer pageSize) {
        String sql = "select `id` ,`name` , `author` , `price` , `sales` , `stock` , `img_path` imgPath from t_book limit ?,?";
        return queryForList(Book.class, sql, begin,pageSize);
    }

    @Override
    public Integer queryForPageTotalCountByPrice(Integer min, Integer max) {
        String sql = "SELECT COUNT('name') FROM t_book WHERE price BETWEEN ? AND ?";
        Number count = (Number) querySingleValue(sql, min, max);
        return count.intValue();
    }

    @Override
    public List<Book> queryForItemsByPrice(Integer begin, Integer pageSize, Integer min, Integer max) {
        String sql = "select `id` ,`name` , `author` , `price` , `sales` , `stock` , `img_path` imgPath from t_book where price BETWEEN ? AND ? order by price limit ?,?";

        return queryForList(Book.class,sql,min,max,begin,pageSize);
    }




}
