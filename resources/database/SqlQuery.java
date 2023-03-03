package database;

public final class SqlQuery
{
    public static final String USER_SQL = "select username, password, rule from Users where username=? and password=?";
}
