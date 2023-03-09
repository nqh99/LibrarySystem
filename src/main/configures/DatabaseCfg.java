package main.configures;

public final class DatabaseCfg
{

    private final String                username      = "db2inst1";

    private final String                password      = "112233";

    private final String                connectionURL = "jdbc:db2://" + "localhost:25000" + "/" + "demo";

    private static volatile DatabaseCfg obj           = null;

    private DatabaseCfg()
    {
    }

    public static DatabaseCfg getInstance()
    {
        if (obj == null)
        {
            synchronized (DatabaseCfg.class)
            {
                if (obj == null)
                {
                    obj = new DatabaseCfg();
                }
            }
        }
        return obj;
    }

    public String getUsername()
    {
        return username;
    }

    public String getPassword()
    {
        return password;
    }

    public String getConnectionURL()
    {
        return connectionURL;
    }

}
