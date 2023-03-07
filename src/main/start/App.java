package main.start;

import java.sql.SQLException;

import main.view.LoginPage;

/**
 * Run application
 * 
 * @author ttl
 *
 */
public class App
{

    public static void main(String[] args) throws SQLException
    {
        new LoginPage();
    }

}
