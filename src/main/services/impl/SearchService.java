package main.services.impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import javax.swing.table.AbstractTableModel;

import main.configures.ApplicationCfg;
import main.domain.Book;
import main.domain.Library;
import main.domain.ObjectType;
import main.domain.RealObject;
import main.domain.Renter;
import main.infra.IBookQueryRepository;
import main.infra.ILibraryQueryRepository;
import main.infra.IRenterQueryRepository;
import main.infra.impl.BookQueryRepository;
import main.infra.impl.LibraryQueryRepository;
import main.infra.impl.RenterQueryRepository;
import main.model.BookModel;
import main.model.LibraryModel;
import main.model.RenterModel;
import main.services.ISearchService;

public class SearchService implements ISearchService
{
    private final IBookQueryRepository                bookQueryRepository    = BookQueryRepository.getInstance();

    private final ILibraryQueryRepository             libraryQueryRepository = LibraryQueryRepository.getInstance();

    private final IRenterQueryRepository              renterQueryRepository  = RenterQueryRepository.getInstance();

    private final Map<ObjectType, AbstractTableModel> objectMap              = ApplicationCfg.getInstance().getObjectMap();

    private static volatile SearchService             obj                    = null;

    private SearchService()
    {

    }

    public static SearchService getInstance()
    {
        if (obj == null)
        {
            synchronized (SearchService.class)
            {
                if (obj == null)
                {
                    obj = new SearchService();
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
    public LibraryModel findLibraryById(Connection con, Integer id)
    {
        LibraryModel libraryModel = (LibraryModel) objectMap.get(ObjectType.LIBRARY);
        try
        {
            Library library = libraryQueryRepository.findLibraryById(con, id);
            libraryModel.setLibraryList(Arrays.asList(library));
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        return libraryModel;
    }

    @Override
    public LibraryModel findLibraryByName(Connection con, String name)
    {
        LibraryModel libraryModel = (LibraryModel) objectMap.get(ObjectType.LIBRARY);
        List<RealObject> list = new ArrayList<>();
        try
        {
            list.addAll(libraryQueryRepository.findLibraryByName(con, name));
            libraryModel.setLibraryList(list);
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        return libraryModel;
    }

    @Override
    public LibraryModel findLibraryByLocation(Connection con, String location)
    {
        LibraryModel libraryModel = (LibraryModel) objectMap.get(ObjectType.LIBRARY);
        try
        {
            Library library = libraryQueryRepository.findLibraryByLocation(con, location);
            libraryModel.setLibraryList(Arrays.asList(library));
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        return libraryModel;
    }

    @Override
    public LibraryModel findLibraryByNameAndLocation(Connection con, String name, String location)
    {
        LibraryModel libraryModel = (LibraryModel) objectMap.get(ObjectType.LIBRARY);
        try
        {
            Library library = libraryQueryRepository.findLibraryByNameAndLocation(con, name, location);
            libraryModel.setLibraryList(Arrays.asList(library));
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        return libraryModel;
    }

    @Override
    public LibraryModel findLibraryByIdAndNameAndLocation(Connection con, Integer id, String name, String location)
    {
        LibraryModel libraryModel = (LibraryModel) objectMap.get(ObjectType.LIBRARY);
        try
        {
            Library library = libraryQueryRepository.findLibraryByIdAndNameAndLocation(con, id, name, location);
            libraryModel.setLibraryList(Arrays.asList(library));
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        return libraryModel;
    }

    @Override
    public RenterModel findRenterById(Connection con, Integer id)
    {
        RenterModel renterModel = (RenterModel) objectMap.get(ObjectType.RENTER);
        try
        {
            Renter renter = renterQueryRepository.findRenterById(con, id);
            renterModel.setRenterList(Arrays.asList(renter));
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        return renterModel;
    }

    @Override
    public RenterModel findRenterByName(Connection con, String name)
    {
        RenterModel renterModel = (RenterModel) objectMap.get(ObjectType.RENTER);
        List<RealObject> list = new ArrayList<>();
        try
        {
            list.addAll(renterQueryRepository.findRenterByName(con, name));
            renterModel.setRenterList(list);
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        return renterModel;
    }

    @Override
    public RenterModel findRenterByEmail(Connection con, String email)
    {
        RenterModel renterModel = (RenterModel) objectMap.get(ObjectType.RENTER);
        try
        {
            Renter renter = renterQueryRepository.findRenterByEmail(con, email);
            renterModel.setRenterList(Arrays.asList(renter));
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        return renterModel;
    }

    @Override
    public RenterModel findRenterByPhoneNumber(Connection con, String phone)
    {
        RenterModel renterModel = (RenterModel) objectMap.get(ObjectType.RENTER);
        try
        {
            Renter renter = renterQueryRepository.findRenterByPhoneNumber(con, phone);
            renterModel.setRenterList(Arrays.asList(renter));
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        return renterModel;
    }

    @Override
    public RenterModel findRenterByNameAndEmail(Connection con, String name, String email)
    {
        RenterModel renterModel = (RenterModel) objectMap.get(ObjectType.RENTER);
        try
        {
            Renter renter = renterQueryRepository.findRenterByNameAndEmail(con, name, email);
            renterModel.setRenterList(Arrays.asList(renter));
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        return renterModel;
    }

    @Override
    public RenterModel findRenterByNameAndPhoneNumber(Connection con, String name, String phone)
    {
        RenterModel renterModel = (RenterModel) objectMap.get(ObjectType.RENTER);
        try
        {
            Renter renter = renterQueryRepository.findRenterByNameAndPhoneNumber(con, name, phone);
            renterModel.setRenterList(Arrays.asList(renter));
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        return renterModel;
    }

    @Override
    public RenterModel findRenterByEmailAndPhoneNumber(Connection con, String email, String phone)
    {
        RenterModel renterModel = (RenterModel) objectMap.get(ObjectType.RENTER);
        try
        {
            Renter renter = renterQueryRepository.findRenterByEmailAndPhoneNumber(con, email, phone);
            renterModel.setRenterList(Arrays.asList(renter));
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        return renterModel;
    }

    @Override
    public RenterModel findRenterByNameAndEmailAndPhoneNumber(Connection con, String name, String email, String phone)
    {
        RenterModel renterModel = (RenterModel) objectMap.get(ObjectType.RENTER);
        try
        {
            Renter renter = renterQueryRepository.findRenterByNameAndEmailAndPhoneNumber(con, name, email, phone);
            renterModel.setRenterList(Arrays.asList(renter));
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        return renterModel;
    }

    @Override
    public RenterModel findRenterByIdAndNameAndEmailAndPhoneNumber(Connection con, Integer id, String name, String email, String phone)
    {
        RenterModel renterModel = (RenterModel) objectMap.get(ObjectType.RENTER);
        try
        {
            Renter renter = renterQueryRepository.findRenterByIdAndNameAndEmailAndPhoneNumber(con, id, name, email, phone);
            renterModel.setRenterList(Arrays.asList(renter));
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        return renterModel;
    }
}
