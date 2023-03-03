package main.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import main.configures.DatabaseCfg;

public class DatabaseUtils
{
    private final static DatabaseCfg databaseCfg = DatabaseCfg.getInstance();

    public static Connection getConnection() throws SQLException
    {
        return DriverManager.getConnection(databaseCfg.getConnectionURL(), databaseCfg.getUsername(), databaseCfg.getPassword());
    }
    
    public static void closeConnection(Connection c) throws SQLException {
        c.close();
    }
}
