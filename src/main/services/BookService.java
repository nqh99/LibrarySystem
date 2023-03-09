package main.services;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import javax.swing.table.AbstractTableModel;

import main.configures.ApplicationCfg;
import main.domain.Book;
import main.domain.ObjectType;
import main.domain.RealObject;
import main.infra.BookQueryRepository;
import main.infra.IBookQueryRepository;
import main.model.BookModel;

public class BookService implements IBookService
{
    private final IBookQueryRepository                bookQueryRepository = BookQueryRepository.getInstance();

    private final Map<ObjectType, AbstractTableModel> objectMap           = ApplicationCfg.getInstance().getObjectMap();

    private static volatile BookService               obj                 = null;

    private BookService()
    {

    }

    public static BookService getInstance()
    {
        if (obj == null)
        {
            synchronized (BookService.class)
            {
                if (obj == null)
                {
                    obj = new BookService();
                }
            }
        }
        return obj;
    }

    @Override
    public BookModel findBookById(Connection con, Integer id)
    {
        BookModel bookModel = (BookModel) objectMap.get(ObjectType.BOOK);
        try
        {
            Book book = bookQueryRepository.findBookById(con, id);
            bookModel.setBookList(Arrays.asList(book));
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        return bookModel;
    }

    @Override
    public BookModel findBookByName(Connection con, String name, String author)
    {
        BookModel bookModel = (BookModel) objectMap.get(ObjectType.BOOK);
        List<RealObject> list = new ArrayList<>();
        try
        {
            list.addAll(bookQueryRepository.findBookByName(con, name));
            bookModel.setBookList(list);
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        return bookModel;
    }

    @Override
    public BookModel findBookByAuthor(Connection con, String author)
    {
        BookModel bookModel = (BookModel) objectMap.get(ObjectType.BOOK);
        List<RealObject> list = new ArrayList<>();
        try
        {
            list.addAll(bookQueryRepository.findBookByAuthor(con, author));
            bookModel.setBookList(list);
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        return bookModel;
    }

    @Override
    public BookModel findBookByNameAndAuthor(Connection con, String name, String author)
    {
        BookModel bookModel = (BookModel) objectMap.get(ObjectType.BOOK);
        List<RealObject> list = new ArrayList<>();
        try
        {
            list.addAll(bookQueryRepository.findBookByNameAndAuthor(con, name, author));
            bookModel.setBookList(list);
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        return bookModel;
    }

    @Override
    public BookModel findBookByIdAndNameAndAuthor(Connection con, Integer id, String name, String author)
    {
        BookModel bookModel = (BookModel) objectMap.get(ObjectType.BOOK);
        try
        {
            Book books = bookQueryRepository.findBookByIdAndNameAndAuthor(con, id, name, author);
            bookModel.setBookList(Arrays.asList(books));
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        return bookModel;
    }

    @Override
    public int removeBookById(Connection con, Integer id)
    {
        int result = 0;
        try
        {
            result = bookQueryRepository.removeBookById(con, id);
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        return result;
    }

}
