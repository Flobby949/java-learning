package top.flobby.basedao.dao;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import top.flobby.basedao.context.DataContext;
import top.flobby.basedao.dao.impl.BookDaoImpl;
import top.flobby.basedao.entity.Book;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@Slf4j
@SuppressWarnings("unchecked")
class BaseDaoTest {

    private void init() {
        Book book1 = new Book(1L, "1001", "Java入门到精通", 88.8, LocalDate.of(2021, 11, 14));
        Book book2 = new Book(2L, "1002", "Java编程思想", 88.8, LocalDate.of(2017, 8, 8));
        Book book3 = new Book(3L, "1003", "Java并发编程", 108.8, LocalDate.of(2020, 11, 15));
        List<Book> bookList = new ArrayList<>(Arrays.asList(book1, book2, book3));
        DataContext.setData(bookList);
        log.info("***********************初始化***********************");
        printData();
    }

    private void printData() {
        List<Book> books = (List<Book>) DataContext.getData();
        books.forEach(item -> log.info(String.valueOf(item)));
    }

    @Test
    void add() {
        init();
        BookDao<Book> bookDao = new BookDaoImpl();
        Book book = new Book(4L, "1004", "添加测试", 78.8, LocalDate.of(2019, 11, 16));
        bookDao.add(book);
        assertEquals(4, ((List<Book>) DataContext.getData()).size());
        log.info("***********************新增***********************");
        printData();
    }

    @Test
    void delete() {
        init();
        BookDao<Book> bookDao = new BookDaoImpl();
        Book delBook = ((List<Book>) DataContext.getData()).get(1);
        bookDao.delete(delBook);
        assertEquals(2, ((List<Book>) DataContext.getData()).size());
        log.info("***********************删除***********************");
        printData();
    }

    @Test
    void get() {
        init();
        BookDao<Book> bookDao = new BookDaoImpl();
        Book book = bookDao.get(2L);
        assertEquals(((List<Book>) DataContext.getData()).get(1), book);
        log.info("***********************根据id查询***********************");
        log.info(String.valueOf(book));
    }

    @Test
    void findByField() {
        init();
        BookDao<Book> bookDao = new BookDaoImpl();
        List<Book> bookList = bookDao.findByField("price", "88.8");
        assertEquals(2, bookList.size());
        log.info("***********************根据字段查询***********************");
        bookList.forEach(item -> log.info(String.valueOf(item)));
    }

    @Test
    void update() {
        init();
        BookDao<Book> bookDao = new BookDaoImpl();
        Book newBook = new Book(1L, "1001", "更新测试", 99.8, LocalDate.of(2021, 11, 14));
        bookDao.update(newBook, 1L);
        assertEquals(99.8, ((List<Book>) DataContext.getData()).get(0).getPrice());
        log.info("***********************更新***********************");
        printData();
    }

    @Test
    void findAll() {
        init();
        BookDao<Book> bookDao = new BookDaoImpl();
        List<Book> books = bookDao.findAll();
        assertEquals(3, books.size());
        log.info("***********************查询所有***********************");
        books.forEach(item -> log.info(String.valueOf(item)));
    }
}