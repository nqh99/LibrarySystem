package main.services;

import java.sql.Connection;

import main.model.BookModel;

public interface IBookService
{
    public BookModel findAllBook(Connection con);

    public BookModel findBookById(Connection con, Integer id);

    public BookModel findBookByName(Connection con, String name, String author);

    public BookModel findBookByAuthor(Connection con, String author);

    public BookModel findBookByNameAndAuthor(Connection con, String name, String author);

    public BookModel findBookByIdAndNameAndAuthor(Connection con, Integer id, String name, String author);

    public int removeBookById(Connection con, Integer id);

    public int updateBookById(Connection con, Integer id, String name, String author);
}
