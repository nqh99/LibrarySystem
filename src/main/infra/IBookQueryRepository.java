package main.infra;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import main.domain.Book;

public interface IBookQueryRepository
{

    public List<Book> findAllBook(Connection con) throws SQLException;

    public Book findBookById(Connection con, Integer id) throws SQLException;

    public List<Book> findBookByName(Connection con, String name) throws SQLException;

    public List<Book> findBookByAuthor(Connection con, String author) throws SQLException;

    public List<Book> findBookByNameAndAuthor(Connection con, String name, String author) throws SQLException;

    public Book findBookByIdAndNameAndAuthor(Connection con, Integer id, String name, String author) throws SQLException;

    public int removeBookById(Connection con, Integer id) throws SQLException;

    public int updateBookById(Connection con, Integer id, String name, String author) throws SQLException;
}
