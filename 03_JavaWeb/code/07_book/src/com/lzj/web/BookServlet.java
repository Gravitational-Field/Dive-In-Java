package com.lzj.web;

import com.lzj.pojo.Book;
import com.lzj.pojo.Page;
import com.lzj.service.BookService;
import com.lzj.service.impl.BookServiceImpl;
import com.lzj.util.WebUtils;

import javax.jnlp.BasicService;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class BookServlet extends BaseServlet{

    BookService bookService = new BookServiceImpl();

    protected void add(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Book book = WebUtils.copyParamToBean(req.getParameterMap(), new Book());
        Integer pageNo = WebUtils.parseInt(req.getParameter("pageNo"), 1);
        //System.out.println(book);
        bookService.addBook(book);
        //不能使用请求的转发（一次请求），而应该使用重定向（两次请求）
        //req.getRequestDispatcher("/manager/bookServlet?action=list").forward(req, resp);
        //当用户提交完请求，浏览器会记录下最后一次请求的全部信息。当用户按下功能键 F5，就会发起浏览器记录的最后一次 请求。  会发生表单重复提交问题，
        // 所以使用重定向

        resp.sendRedirect(req.getContextPath()+"/manager/bookServlet?action=page&pageNo="+pageNo);
    }

    protected void delete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer id = WebUtils.parseInt(req.getParameter("id"), 0);
        System.out.println(id);
        bookService.deleteBookById(id);
        //需要浏览区去进行解析
        resp.sendRedirect(req.getContextPath()+"/manager/bookServlet?action=page");
    }

    protected void getBook(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer id = WebUtils.parseInt(req.getParameter("id"), 0);
        Book book = bookService.queryBookById(id);

        //请求的转发，使用同一个request域，将book对象带给客户端
        req.setAttribute("book", book);
        req.getRequestDispatcher("/pages/manager/book_edit.jsp").forward(req, resp);

    }

    protected void update(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Book book = WebUtils.copyParamToBean(req.getParameterMap(), new Book());
        Integer id = WebUtils.parseInt(req.getParameter("id"), 0);
        Integer pageNo = WebUtils.parseInt(req.getParameter("pageNo"), 1);
        //System.out.println(book);
        book.setId(id);
        bookService.updateBook(book);
        resp.sendRedirect(req.getContextPath()+"/manager/bookServlet?action=page&pageNo="+pageNo);
    }

    protected void list(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1. 查询全部图书
        List<Book> books = bookService.queryBooks();
        //System.out.println(Arrays.asList(books));
        //2. 保存到request域中
        req.setAttribute("books", books);
        //3. 请求转发到/pages/manager/manager.jsp
        req.getRequestDispatcher("/pages/manager/book_manager.jsp").forward(req,resp);
    }

    //分页
    protected void page(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1. 获取pageNo与pageSize
        Integer pageNo = WebUtils.parseInt(req.getParameter("pageNo"), 1);
        Integer pageSize = WebUtils.parseInt(req.getParameter("pageSize"), Page.PAGE_SIZE);
        //2. 调用BookService.page(pageNo,pageSize)获取Page对象
        Page<Book> page = bookService.page(pageNo,pageSize);

        page.setUrl("manager/bookServlet?action=page");

        //3. 将page对象存入request域中
        req.setAttribute("page", page);
        //4. 请求转发至/pages/manager/book_manager.jsp页面
        req.getRequestDispatcher("/pages/manager/book_manager.jsp").forward(req, resp);
    }
}
