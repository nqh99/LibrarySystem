package main.start;

import java.sql.SQLException;

import main.view.LoginPage;

/**
 * Run application
 * Using some technology stacks like: JDBC, db2, java swing
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
