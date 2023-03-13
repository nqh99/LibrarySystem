package test;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;

import main.infra.IBookQueryRepository;
import main.infra.impl.BookQueryRepository;
import main.services.IBookService;
import main.services.impl.BookService;
import main.utils.DatabaseUtils;
import main.utils.DateTimeUtils;

public class TestDatabase
{
    private static IBookQueryRepository bookRepo    = BookQueryRepository.getInstance();

    private static IBookService         bookService = BookService.getInstance();

    public static void main(String[] args)
    {
        Connection conn = null;
        try
        {
            conn = DatabaseUtils.getConnection();
            System.out.println(bookRepo.createBook(conn, "abc", "abc", Long.parseLong("2323223232"), Long.parseLong("2323223232")));
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        System.out.println(bookService.createBook(conn, "abc", "abc"));

        System.out.println(DateTimeUtils.getDateTime(new Date().getTime()));
    }
}
