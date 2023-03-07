package main.services;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import main.configures.ApplicationCfg;
import main.domain.Book;
import main.domain.ObjectType;
import main.domain.RealObject;
import main.infra.BookQueryRepository;
import main.infra.IBookQueryRepository;
import main.model.BookModel;

public class BookService implements IBookService
{
    private final IBookQueryRepository  bookQueryRepository = BookQueryRepository.getInstance();

    private final BookModel             bookModel           = (BookModel) ApplicationCfg.getInstance().getObjectMap().get(ObjectType.BOOK);

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
    public BookModel findBookById(Connection con, Integer id)
    {

        try
        {
            Book book = bookQueryRepository.findBookById(con, id);

            List<RealObject> books = new ArrayList<>();
            books.add(book);
            bookModel.setBookList(books);
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        return bookModel;
    }

    @Override
    public BookModel findBookByNameOfAuthor(Connection con, String name, String author)
    {
        return null;
    }

    @Override
    public BookModel findBookByIdAndNameAndAuthor(Connection con, Integer id, String name, String author)
    {
        return null;
    }

}
