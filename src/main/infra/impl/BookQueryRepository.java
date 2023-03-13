package main.infra.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import database.SqlQuery;
import main.domain.Book;
import main.infra.IBookQueryRepository;

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
                book.setName(rs.getString("NAME"));
                book.setAuthor(rs.getString("AUTHOR"));
                book.setCreateTime(rs.getLong("CREATE_TIME"));
                book.setUpdateTime(rs.getLong("UPDATE_TIME"));
            }
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        return book;
    }

    @Override
    public List<Book> findBookByName(Connection con, String name) throws SQLException
    {
        List<Book> list = new ArrayList<>();
        try (PreparedStatement stmt = con.prepareStatement(SqlQuery.BOOK_BY_NAME_SQL))
        {
            stmt.setString(1, name);
            ResultSet rs = stmt.executeQuery();
            while (rs.next())
            {
                Book book = new Book();
                book.setId(rs.getInt("BOOK_ID"));
                book.setName(name);
                book.setAuthor(rs.getString("AUTHOR"));
                book.setCreateTime(rs.getLong("CREATE_TIME"));
                book.setUpdateTime(rs.getLong("UPDATE_TIME"));

                list.add(book);
            }
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public List<Book> findBookByAuthor(Connection con, String author) throws SQLException
    {
        List<Book> list = new ArrayList<>();
        try (PreparedStatement stmt = con.prepareStatement(SqlQuery.BOOK_BY_AUTHOR_SQL))
        {
            stmt.setString(1, author);
            ResultSet rs = stmt.executeQuery();
            while (rs.next())
            {
                Book book = new Book();
                book.setId(rs.getInt("BOOK_ID"));
                book.setName(rs.getString("NAME"));
                book.setAuthor(author);
                book.setCreateTime(rs.getLong("CREATE_TIME"));
                book.setUpdateTime(rs.getLong("UPDATE_TIME"));

                list.add(book);
            }
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public List<Book> findBookByNameAndAuthor(Connection con, String name, String author) throws SQLException
    {
        List<Book> list = new ArrayList<>();
        try (PreparedStatement stmt = con.prepareStatement(SqlQuery.BOOK_BY_NAME_AND_AUTHOR_SQL))
        {
            stmt.setString(1, name);
            stmt.setString(2, author);
            ResultSet rs = stmt.executeQuery();
            while (rs.next())
            {
                Book book = new Book();
                book.setId(rs.getInt("BOOK_ID"));
                book.setName(name);
                book.setAuthor(author);
                book.setCreateTime(rs.getLong("CREATE_TIME"));
                book.setUpdateTime(rs.getLong("UPDATE_TIME"));

                list.add(book);
            }
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public Book findBookByIdAndNameAndAuthor(Connection con, Integer id, String name, String author) throws SQLException
    {
        Book book = null;
        try (PreparedStatement stmt = con.prepareStatement(SqlQuery.BOOK_BY_ID_AND_NAME_AND_AUTHOR_SQL))
        {
            stmt.setInt(1, id);
            stmt.setString(2, name);
            stmt.setString(3, author);
            ResultSet rs = stmt.executeQuery();
            if (rs.next())
            {
                book = new Book();
                book.setId(id);
                book.setName(name);
                book.setAuthor(author);
                book.setCreateTime(rs.getLong("CREATE_TIME"));
                book.setUpdateTime(rs.getLong("UPDATE_TIME"));
            }
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        return book;
    }

    @Override
    public boolean removeBookById(Connection con, Integer id) throws SQLException
    {
        boolean result = false;
        try (PreparedStatement stmt = con.prepareStatement(SqlQuery.DELETE_BOOK_BY_ID))
        {
            stmt.setInt(1, id);
            int rows = stmt.executeUpdate();
            if (rows > 0)
            {
                result = true;
            }
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public List<Book> findAllBook(Connection con) throws SQLException
    {
        List<Book> list = new ArrayList<>();
        try (PreparedStatement stmt = con.prepareStatement(SqlQuery.ALL_BOOKS_SQL))
        {
            ResultSet rs = stmt.executeQuery();
            while (rs.next())
            {
                Book book = new Book();
                book.setId(rs.getInt("BOOK_ID"));
                book.setName(rs.getString("NAME"));
                book.setAuthor(rs.getString("AUTHOR"));
                book.setCreateTime(rs.getLong("CREATE_TIME"));
                book.setUpdateTime(rs.getLong("UPDATE_TIME"));

                list.add(book);
            }
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public boolean createBook(Connection con, String name, String author, Long createTime, Long updateTime) throws SQLException
    {
        boolean result = false;
        try (PreparedStatement stmt = con.prepareStatement(SqlQuery.INSERT_BOOK))
        {
            stmt.setString(1, name);
            stmt.setString(2, author);
            stmt.setLong(3, createTime);
            stmt.setLong(4, updateTime);

            int row = stmt.executeUpdate();
            if (row > 0)
            {
                result = true;
            }
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public boolean updateBookById(Connection con, Integer id, String name, String author, Long updateTime) throws SQLException
    {
        boolean result = false;
        try (PreparedStatement stmt = con.prepareStatement(SqlQuery.UPDATE_BOOK_BY_ID))
        {
            stmt.setString(1, name);
            stmt.setString(2, author);
            stmt.setLong(3, updateTime);
            stmt.setInt(4, id);
            int rows = stmt.executeUpdate();
            if (rows > 0)
            {
                result = true;
            }
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        return result;
    }

}
