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
import main.infra.IAuditRepository;
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
        IAuditRepository bookQueryRepository = new BookQueryRepository();

        try
        {
            Book book = bookQueryRepository.findById(con, id);
            bookModel.setBookList(Arrays.asList(book));
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        return bookModel;
    }

    @SuppressWarnings("unchecked")
    @Override
    public BookModel findAllBook(Connection con)
    {
        BookModel bookModel = (BookModel) objectMap.get(AuditType.BOOK);
        IAuditRepository bookQueryRepository = new BookQueryRepository();
        List<Book> list = new ArrayList<>();
        try
        {

            list.addAll((List<Book>) bookQueryRepository.findAll(con));
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
        IAuditRepository bookQueryRepository = new BookQueryRepository();
        try
        {
            result = bookQueryRepository.removeById(con, id);
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
        IAuditRepository bookQueryRepository = new BookQueryRepository();
        try
        {
            result = bookQueryRepository.updateById(con, id, name, author);
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

        IAuditRepository bookQueryRepository = new BookQueryRepository();

        try
        {
            result = bookQueryRepository.create(con, name, author);
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }

        return result;
    }

}
