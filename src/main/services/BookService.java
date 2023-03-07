package main.services;

import java.sql.Connection;
import java.sql.SQLException;

import main.infra.BookQueryRepository;
import main.infra.IBookQueryRepository;
import main.model.BookModel;
import main.utils.DatabaseUtils;

public class BookService implements IBookService
{
    private final IBookQueryRepository   bookQueryRepository = BookQueryRepository.getInstance();

    private static volatile BookService obj                 = null;

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
    public BookModel findBookById(Integer id)
    {
        Connection con = null;
        BookModel bookModel = null;
        try
        {
            con = DatabaseUtils.getConnection();
//            bookModel = bookQueryRepository.findBookById(con, id);
            DatabaseUtils.closeConnection(con);
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }

        return bookModel;
    }

    @Override
    public BookModel findBookByNameOfAuthor(String name, String author)
    {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public BookModel findBookByIdAndNameAndAuthor(Integer id, String name, String author)
    {
        // TODO Auto-generated method stub
        return null;
    }
}
