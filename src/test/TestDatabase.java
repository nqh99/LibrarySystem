package test;

import java.sql.Connection;
import java.sql.SQLException;

import main.model.BookModel;
import main.services.ISearchService;
import main.services.SearchService;
import main.utils.DatabaseUtils;

public class TestDatabase
{

    private final static ISearchService searchService = SearchService.getInstance();

    public static void main(String[] args)
    {
        Connection con = null;
        try
        {
            con = DatabaseUtils.getConnection();
            BookModel model = searchService.findBookById(con, 1);

            System.out.println(model.getBookList());
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }

    }

}
