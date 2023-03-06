package database;

public final class SqlQuery
{
    public static final String USER_SQL = "SELECT username, password, rule FROM USERS where username=? and password=?";
    
    public static final String BOOK_BY_ID_SQL = "SELECT * FROM BOOKS where book_id=?";
}
