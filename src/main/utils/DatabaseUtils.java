package main.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import main.configures.DatabaseCfg;

public class DatabaseUtils
{
    public static Connection getConnection(DatabaseCfg databaseCfg) throws SQLException
    {
        return DriverManager.getConnection(databaseCfg.getConnectionURL(), databaseCfg.getUsername(), databaseCfg.getPassword());
    }

    public static void closeConnection(Connection c) throws SQLException
    {
        c.close();
    }
}
