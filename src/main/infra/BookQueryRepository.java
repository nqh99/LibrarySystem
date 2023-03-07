package main.infra;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import database.SqlQuery;
import main.domain.Book;

/**
 * Singleton
 * 
 * @author ttl
 *
 */
public class BookQueryRepository implements IBookQueryRepository
{
    private static volatile BookQueryRepository obj = null;

    private BookQueryRepository()
    {
    }

    public static BookQueryRepository getInstance()
    {
        if (obj == null)
        {
            synchronized (BookQueryRepository.class)
            {
                if (obj == null)
                {
                    obj = new BookQueryRepository();
                }
            }
        }
        return obj;
    }

    @Override
    public Book findBookById(Connection con, Integer id) throws SQLException
    {
        Book book = null;
        try (PreparedStatement stmt = con.prepareStatement(SqlQuery.BOOK_BY_ID_SQL))
        {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next())
            {
                book = new Book();
                book.setId(id);
                book.setName(rs.getString("name"));
                book.setAuthor(rs.getString("author"));
                book.setCreateTime(rs.getLong("create_time"));
                book.setUpdateTime(rs.getLong("update_time"));
            }
        }
        catch (SQLException e)
        {
            throw new SQLException(e.getMessage());
        }
        return book;
    }

    @Override
    public List<Book> findBookByNameOfAuthor(Connection con, String name, String author)
    {
        return null;
    }

    @Override
    public Book findBookByIdAndNameAndAuthor(Connection con, Integer id, String name, String author)
    {
        return null;
    }

}
