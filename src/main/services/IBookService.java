package main.services;

import main.model.BookModel;

public interface IBookService
{
    public BookModel findBookById(Integer id);

    public BookModel findBookByNameOfAuthor(String name, String author);

    public BookModel findBookByIdAndNameAndAuthor(Integer id, String name, String author);

}
