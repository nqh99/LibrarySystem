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
import main.domain.Library;
import main.infra.IAuditRepository;
import main.infra.ILibraryQueryRepository;

/**
 * 
 * @author ttl
 *
 */
public class LibraryQueryRepository implements IAuditRepository
{

    @Override
    public Library findLibraryById(Connection con, Integer id) throws SQLException
    {

    }

    @Override
    public List<Library> findAllLibraries(Connection con) throws SQLException
    {

    }

    @Override
    public boolean createLibrary(Connection con, String name, String location) throws SQLException
    {

    }

    @Override
    public boolean removeLibraryById(Connection con, Integer id) throws SQLException
    {

    }

    @Override
    public boolean updateLibraryById(Connection con, Integer id, String name, String location) throws SQLException
    {

    }

    @Override
    public Book findById(Connection con, Integer id) throws SQLException
    {
        Library library = null;
        Audit audit = null;
        try (PreparedStatement stmt = con.prepareStatement(SqlQuery.LIBRARY_BY_ID_SQL); ResultSet rs = stmt.executeQuery();)
        {
            stmt.setInt(1, id);
            if (rs.next())
            {
                library = new Library();

                audit = new Audit();
                audit.setId(id);
                audit.setName(rs.getString("NAME"));
                audit.setCreateTime(rs.getLong("CREATE_TIME"));
                audit.setUpdateTime(rs.getLong("UPDATE_TIME"));

                library.setAudit(audit);
                library.setLocation(rs.getString("LOCATION"));
            }
        }
        catch (Exception e)
        {
            throw new SQLException(e);
        }
        return library;
    }

    @Override
    public List<?> findAll(Connection con) throws SQLException
    {
        List<Library> list = new ArrayList<>();
        try (PreparedStatement stmt = con.prepareStatement(SqlQuery.ALL_LIBRARIES_SQL); ResultSet rs = stmt.executeQuery();)
        {

            while (rs.next())
            {
                Library library = new Library();

                Audit audit = new Audit();
                audit.setId(rs.getInt("LIBRARY_ID"));
                audit.setName(rs.getString("NAME"));
                audit.setCreateTime(rs.getLong("CREATE_TIME"));
                audit.setUpdateTime(rs.getLong("UPDATE_TIME"));

                library.setAudit(audit);
                library.setLocation(rs.getString("LOCATION"));

                list.add(library);
            }
        }
        catch (Exception e)
        {
            throw new SQLException(e);
        }
        return list;
    }

    @Override
    public boolean create(Connection con, String name, String author) throws SQLException
    {
        boolean result = false;
        try (PreparedStatement stmt = con.prepareStatement(SqlQuery.INSERT_LIBRARY))
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
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public boolean updateById(Connection con, Integer id, String name, String author) throws SQLException
    {
        boolean result = false;
        try (PreparedStatement stmt = con.prepareStatement(SqlQuery.UPDATE_LIBRARY_BY_ID))
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
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public boolean removeById(Connection con, Integer id) throws SQLException
    {
        boolean result = false;
        try (PreparedStatement stmt = con.prepareStatement(SqlQuery.DELETE_LIBRARY_BY_ID))
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

}
