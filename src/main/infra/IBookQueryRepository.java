package main.infra;

import java.sql.Connection;

import main.model.BookModel;

public interface IBookQueryRepository
{

    public BookModel findBookByNameOfAuthor(Connection con, String name, String author);

    public BookModel findBookByIdAndNameAndAuthor(Connection con, Integer id, String name, String author);

    BookModel findBookById(Connection con, Integer id);
}
