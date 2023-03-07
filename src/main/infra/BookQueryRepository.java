package main.infra;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
    public Book findBookById(Connection con, Integer id)
    {
        Book book = null;
        try (PreparedStatement stmt = con.prepareStatement(SqlQuery.BOOK_BY_ID_SQL))
        {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next())
            {
//                bookModel = new BookModel();
//                bookModel.setId(id);
//                bookModel.setAuthor(rs.getString("author"));
//                bookModel.setName(rs.getString("name"));
//                bookModel.setCreateTime(rs.getDate("create_time"));
//                bookModel.setUpdateTime(rs.getDate("update_time"));
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
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
