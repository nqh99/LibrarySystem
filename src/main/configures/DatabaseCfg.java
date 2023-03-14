package main.configures;

/**
 * Contain database configures for connection;
 * username
 * password
 * connectionURL
 * driver
 * 
 * @author ttl
 *
 */
public final class DatabaseCfg
{

    private String       username      = "db2inst1";

    private String       password      = "Nqh1999@";

    private String       driver;

    private String       port;

    private String       databaseName;

    private final String connectionURL = "jdbc:db2://" + "localhost:50002" + "/" + "demo";

    public String getUsername()
    {
        return username;
    }

    public void setUsername(String username)
    {
        this.username = username;
    }

    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

    public String getDriver()
    {
        return driver;
    }

    public void setDriver(String driver)
    {
        this.driver = driver;
    }

    public String getPort()
    {
        return port;
    }

    public void setPort(String port)
    {
        this.port = port;
    }

    public String getDatabaseName()
    {
        return databaseName;
    }

    public void setDatabaseName(String databaseName)
    {
        this.databaseName = databaseName;
    }

    public String getConnectionURL()
    {
        return connectionURL;
    }

}
