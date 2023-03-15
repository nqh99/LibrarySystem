package test;

import java.sql.Connection;
import java.sql.SQLException;

import main.configures.DatabaseCfg;
import main.services.IBookService;
import main.services.impl.BookService;
import main.utils.DatabaseUtils;

public class TestDatabase
{

    public static void main(String[] args)
    {
        Connection conn = null;
        DatabaseCfg databaseCfg = new DatabaseCfg();
        IBookService bookrepos = new BookService();
        try
        {
            conn = DatabaseUtils.getConnection(databaseCfg);
            System.out.println(bookrepos.updateBookById(conn, 2, "abc", "abc"));
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }

    }
}
