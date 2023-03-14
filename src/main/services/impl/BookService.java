package main.services.impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import javax.swing.table.AbstractTableModel;

import main.configures.ApplicationCfg;
import main.domain.AuditType;
import main.domain.Book;
import main.infra.IBookQueryRepository;
import main.infra.impl.BookQueryRepository;
import main.model.BookModel;
import main.services.IBookService;

public class BookService implements IBookService
{

    private final Map<AuditType, AbstractTableModel> objectMap = ApplicationCfg.getInstance().getObjectMap();

    @Override
    public BookModel findBookById(Connection con, Integer id)
    {
        BookModel bookModel = (BookModel) objectMap.get(AuditType.BOOK);
        IBookQueryRepository bookQueryRepository = new BookQueryRepository();

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
    public BookModel findAllBook(Connection con)
    {
        BookModel bookModel = (BookModel) objectMap.get(AuditType.BOOK);
        IBookQueryRepository bookQueryRepository = new BookQueryRepository();
        List<Book> list = new ArrayList<>();
        try
        {

            list.addAll(bookQueryRepository.findAllBook(con));
            bookModel.setBookList(list);
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        return bookModel;
    }

    @Override
    public boolean removeBookById(Connection con, Integer id)
    {
        boolean result = false;
        IBookQueryRepository bookQueryRepository = new BookQueryRepository();
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

    @Override
    public boolean updateBookById(Connection con, Integer id, String name, String author)
    {
        boolean result = false;
        IBookQueryRepository bookQueryRepository = new BookQueryRepository();
        try
        {
            result = bookQueryRepository.updateBookById(con, id, name, author);
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public boolean createBook(Connection con, String name, String author)
    {
        boolean result = false;

        IBookQueryRepository bookQueryRepository = new BookQueryRepository();

        try
        {
            result = bookQueryRepository.createBook(con, name, author);
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }

        return result;
    }

}
