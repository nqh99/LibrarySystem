package test;

import java.sql.Connection;
import java.sql.SQLException;

import main.model.BookModel;
import main.services.ISearchService;
import main.services.impl.SearchService;
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
            BookModel model = searchService.findBookByIdAndNameAndAuthor(con, 1, "Con duong A", "Cao Ba A");

            System.out.println(model.getBookList());
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }

    }

}
