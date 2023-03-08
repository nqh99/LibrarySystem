package main.infra;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import database.SqlQuery;
import main.domain.Library;

/**
 * Singleton
 * 
 * @author ttl
 *
 */
public class LibraryQueryRepository implements ILibraryQueryRepository
{
    private static volatile LibraryQueryRepository obj = null;

    private LibraryQueryRepository()
    {
    }

    public static LibraryQueryRepository getInstance()
    {
        if (obj == null)
        {
            synchronized (LibraryQueryRepository.class)
            {
                if (obj == null)
                {
                    obj = new LibraryQueryRepository();
                }
            }
        }
        return obj;
    }

    @Override
    public Library findLibraryById(Connection con, Integer id) throws SQLException
    {
        Library library = null;
        try (PreparedStatement stmt = con.prepareStatement(SqlQuery.LIBRARY_BY_ID_SQL))
        {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next())
            {
                library = new Library();
                library.setId(id);
                library.setName(rs.getString("NAME"));
                library.setLocation(rs.getString("LOCATION"));
                library.setCreateTime(rs.getLong("CREATE_TIME"));
                library.setUpdateTime(rs.getLong("UPDATE_TIME"));
            }
        }
        catch (Exception e)
        {
            throw new SQLException(e.getMessage());
        }
        return library;
    }

    @Override
    public List<Library> findLibraryByName(Connection con, String name) throws SQLException
    {
        List<Library> list = new ArrayList<>();
        try (PreparedStatement stmt = con.prepareStatement(SqlQuery.LIBRARY_BY_NAME_SQL))
        {
            stmt.setString(1, name);
            ResultSet rs = stmt.executeQuery();
            if (rs.next())
            {
                Library library = new Library();
                library.setId(rs.getInt("LIBRARY_ID"));
                library.setName(name);
                library.setLocation(rs.getString("LOCATION"));
                library.setCreateTime(rs.getLong("CREATE_TIME"));
                library.setUpdateTime(rs.getLong("UPDATE_TIME"));

                list.add(library);
            }
        }
        catch (Exception e)
        {// TODO Auto-generated method stub
            throw new SQLException(e.getMessage());
        }
        return list;
    }

    @Override
    public Library findLibraryByLocation(Connection con, String location) throws SQLException
    {
        Library library = null;
        try (PreparedStatement stmt = con.prepareStatement(SqlQuery.LIBRARY_BY_ID_SQL))
        {
            stmt.setString(1, location);
            ResultSet rs = stmt.executeQuery();
            if (rs.next())
            {
                library = new Library();
                library.setId(rs.getInt("LIBRARY_ID"));
                library.setName(rs.getString("NAME"));
                library.setLocation(location);
                library.setCreateTime(rs.getLong("CREATE_TIME"));
                library.setUpdateTime(rs.getLong("UPDATE_TIME"));
            }
        }
        catch (Exception e)
        {
            throw new SQLException(e.getMessage());
        }
        return library;
    }

    @Override
    public Library findLibraryByNameAndLocation(Connection con, String name, String location) throws SQLException
    {
        Library library = null;
        try (PreparedStatement stmt = con.prepareStatement(SqlQuery.LIBRARY_BY_ID_SQL))
        {
            stmt.setString(1, name);
            stmt.setString(2, location);
            ResultSet rs = stmt.executeQuery();
            if (rs.next())
            {
                library = new Library();
                library.setId(rs.getInt("LIBRARY_ID"));
                library.setName(name);
                library.setLocation(location);
                library.setCreateTime(rs.getLong("CREATE_TIME"));
                library.setUpdateTime(rs.getLong("UPDATE_TIME"));
            }
        }
        catch (Exception e)
        {
            throw new SQLException(e.getMessage());
        }
        return library;
    }

    @Override
    public Library findLibraryByIdAndNameAndLocation(Connection con, Integer id, String name, String location) throws SQLException
    {
        Library library = null;
        try (PreparedStatement stmt = con.prepareStatement(SqlQuery.LIBRARY_BY_ID_SQL))
        {
            stmt.setInt(1, id);
            stmt.setString(2, name);
            stmt.setString(3, location);
            ResultSet rs = stmt.executeQuery();
            if (rs.next())
            {
                library = new Library();
                library.setId(id);
                library.setName(name);
                library.setLocation(location);
                library.setCreateTime(rs.getLong("CREATE_TIME"));
                library.setUpdateTime(rs.getLong("UPDATE_TIME"));
            }
        }
        catch (Exception e)
        {
            throw new SQLException(e.getMessage());
        }
        return library;
    }

}