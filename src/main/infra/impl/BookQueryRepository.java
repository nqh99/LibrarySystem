package main.infra.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import database.SqlQuery;
import main.domain.Audit;
import main.domain.Book;
import main.infra.IAuditRepository;

/**
 * @author ttl
 *
 */
public class BookQueryRepository implements IAuditRepository
{

    @Override
    public Book findById(Connection con, Integer id) throws SQLException
    {
        Book book = null;
        Audit audit = null;
        try (PreparedStatement stmt = con.prepareStatement(SqlQuery.BOOK_BY_ID_SQL); ResultSet rs = stmt.executeQuery();)
        {
            stmt.setInt(1, id);
            if (rs.next())
            {
                book = new Book();
                audit = new Audit();
                audit.setId(id);
                audit.setName(rs.getString("NAME"));
                audit.setCreateTime(rs.getLong("CREATE_TIME"));
                audit.setUpdateTime(rs.getLong("UPDATE_TIME"));
                book.setAudit(audit);
                book.setAuthor(rs.getString("AUTHOR"));
            }
        }
        catch (SQLException e)
        {
            throw new SQLException(e);
        }
        return book;
    }

    @Override
    public List<Book> findAll(Connection con) throws SQLException
    {
        List<Book> list = new ArrayList<>();
        try (PreparedStatement stmt = con.prepareStatement(SqlQuery.ALL_BOOKS_SQL); ResultSet rs = stmt.executeQuery();)
        {
            while (rs.next())
            {
                Book book = new Book();

                Audit audit = new Audit();
                audit.setId(rs.getInt("BOOK_ID"));
                audit.setName(rs.getString("NAME"));
                audit.setCreateTime(rs.getLong("CREATE_TIME"));
                audit.setUpdateTime(rs.getLong("UPDATE_TIME"));
                book.setAudit(audit);
                book.setAuthor(rs.getString("AUTHOR"));

                list.add(book);
            }
        }
        catch (SQLException e)
        {
            throw new SQLException(e);
        }
        return list;
    }

    @Override
    public boolean create(Connection con, String name, String author) throws SQLException
    {
        boolean result = false;
        try (PreparedStatement stmt = con.prepareStatement(SqlQuery.INSERT_BOOK))
        {
            Long createTime = new Date().getTime();

            stmt.setString(1, name);
            stmt.setString(2, author);
            stmt.setLong(3, createTime);
            stmt.setNull(4, Types.NULL);

            int row = stmt.executeUpdate();
            if (row > 0)
            {
                result = true;
            }
        }
        catch (SQLException e)
        {
            throw new SQLException(e);
        }
        return result;
    }

    @Override
    public boolean updateById(Connection con, Integer id, String name, String author) throws SQLException
    {
        boolean result = false;
        try (PreparedStatement stmt = con.prepareStatement(SqlQuery.UPDATE_BOOK_BY_ID))
        {
            Long updateTime = new Date().getTime();

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
            throw new SQLException(e);
        }
        return result;
    }

    @Override
    public boolean removeById(Connection con, Integer id) throws SQLException
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
            throw new SQLException(e);
        }
        return result;
    }

}
