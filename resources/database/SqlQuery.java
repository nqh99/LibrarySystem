package database;

public final class SqlQuery
{
    public static final String USER_SQL                                             = "SELECT username, password, rule FROM USERS where username=? and password=?";

    public static final String ALL_BOOKS_SQL                                        = "SELECT * FROM BOOKS";

    public static final String BOOK_BY_ID_SQL                                       = "SELECT * FROM BOOKS b WHERE BOOK_ID =?";

    public static final String BOOK_BY_NAME_SQL                                     = "SELECT * FROM BOOKS b WHERE NAME  =?";

    public static final String BOOK_BY_AUTHOR_SQL                                   = "SELECT * FROM BOOKS b WHERE AUTHOR =?";

    public static final String BOOK_BY_NAME_AND_AUTHOR_SQL                          = "SELECT * FROM BOOKS b WHERE NAME  =? AND AUTHOR =?";

    public static final String BOOK_BY_ID_AND_NAME_AND_AUTHOR_SQL                   = "SELECT * FROM BOOKS b WHERE BOOK_ID =? AND NAME  =? AND AUTHOR =?";

    public static final String ALL_LIBRARYS_SQL                                     = "SELECT * FROM LIBRARY";

    public static final String LIBRARY_BY_ID_SQL                                    = "SELECT * FROM LIBRARY l WHERE LIBRARY_ID =?";

    public static final String LIBRARY_BY_NAME_SQL                                  = "SELECT * FROM LIBRARY l WHERE NAME  =?";

    public static final String LIBRARY_BY_LOCATION_SQL                              = "SELECT * FROM LIBRARY l WHERE LOCATION  =?";

    public static final String LIBRARY_BY_NAME_AND_LOCATION_SQL                     = "SELECT * FROM LIBRARY l WHERE Name =? AND LOCATION =?";

    public static final String LIBRARY_BY_ID_AND_NAME_AND_LOCATION_SQL              = "SELECT * FROM LIBRARY l WHERE LIBRARY_ID =? AND Name =? AND LOCATION =?";

    public static final String ALL_RENTER_SQL                                       = "SELECT * FROM RENTER";

    public static final String RENTER_BY_ID_SQL                                     = "SELECT * FROM RENTERS r WHERE RENTER_ID  =?";

    public static final String RENTER_BY_NAME_SQL                                   = "SELECT * FROM RENTERS r WHERE NAME =?";

    public static final String RENTER_BY_EMAIL_SQL                                  = "SELECT * FROM RENTERS r WHERE EMAIL =?";

    public static final String RENTER_BY_PHONE_NUMBER_SQL                           = "SELECT * FROM RENTERS r WHERE PHONE_NUMBER =?";

    public static final String RENTER_BY_NAME_AND_EMAIL_SQL                         = "SELECT * FROM RENTERS r WHERE NAME =? AND EMAIL =?";

    public static final String RENTER_BY_NAME_AND_PHONE_NUMBER_SQL                  = "SELECT * FROM RENTERS r WHERE NAME =? AND PHONE_NUMBER =?";

    public static final String RENTER_BY_EMAIL_AND_PHONE_NUMBER_SQL                 = "SELECT * FROM RENTERS r WHERE EMAIL =? AND PHONE_NUMBER =?";

    public static final String RENTER_BY_NAME_AND_EMAIL_AND_PHONE_NUMBER_SQL        = "SELECT * FROM RENTERS r WHERE NAME =? AND EMAIL =? AND PHONE_NUMBER =?";

    public static final String RENTER_BY_ID_AND_NAME_AND_EMAIL_AND_PHONE_NUMBER_SQL = "SELECT * FROM RENTERS r WHERE RENTER_ID =? AND NAME =? AND EMAIL =? AND PHONE_NUMBER =?";

    public static final String DELETE_BOOK_BY_ID                                    = "DELETE FROM BOOKS WHERE BOOK_ID =?";

    public static final String DELETE_LIBRARY_BY_ID                                 = "DELETE FROM LIBRARY WHERE LIBRARY_ID =?";

    public static final String DELETE_RENTER_BY_ID                                  = "DELETE FROM RENTERS WHERE RENTER_ID =?";

    public static final String UPDATE_BOOK_BY_ID                                    = "UPDATE BOOKS SET NAME =?, AUTHOR =? WHERE BOOK_ID =?";

    public static final String UPDATE_LIBRARY_BY_ID                                 = "UPDATE LIBRARY SET NAME =?, LOCATION =? WHERE LIBRARY_ID =?";

    public static final String UPDATE_RENTER_BY_ID                                  = "UPDATE RENTER SET NAME =?, EMAIL=?, PHONE_NUMBER =? WHERE RENTER_ID =?";
}
