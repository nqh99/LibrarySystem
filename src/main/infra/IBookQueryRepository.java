package main.infra;

import java.sql.Connection;
import java.util.List;

import main.domain.Book;

public interface IBookQueryRepository
{

    public List<Book> findBookByNameOfAuthor(Connection con, String name, String author);

    public Book findBookByIdAndNameAndAuthor(Connection con, Integer id, String name, String author);

    public Book findBookById(Connection con, Integer id);
}
