package main.services;

import java.sql.Connection;

import main.model.BookModel;

public interface IBookService
{
    public BookModel findAllBook(Connection con);

    public BookModel findBookById(Connection con, Integer id);

    public boolean removeBookById(Connection con, Integer id);

    public boolean updateBookById(Connection con, Integer id, String name, String author);

    public boolean createBook(Connection con, String name, String author);
}
