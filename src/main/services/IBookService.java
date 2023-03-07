package main.services;

import java.sql.Connection;

import main.model.BookModel;

public interface IBookService
{
    public BookModel findBookById(Connection con, Integer id);

    public BookModel findBookByNameOfAuthor(Connection con, String name, String author);

    public BookModel findBookByIdAndNameAndAuthor(Connection con, Integer id, String name, String author);

}
