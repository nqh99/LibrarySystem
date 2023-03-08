package main.infra;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import database.SqlQuery;
import main.domain.Renter;

/**
 * Singleton
 * 
 * @author ttl
 *
 */
public class RenterQueryRepository implements IRenterQueryRepository
{
    private static volatile RenterQueryRepository obj = null;

    private RenterQueryRepository()
    {
    }

    public static RenterQueryRepository getInstance()
    {
        if (obj == null)
        {
            synchronized (RenterQueryRepository.class)
            {
                if (obj == null)
                {
                    obj = new RenterQueryRepository();
                }
            }
        }
        return obj;
    }

    @Override
    public Renter findRenterById(Connection con, Integer id) throws SQLException
    {
        Renter renter = null;
        try (PreparedStatement stmt = con.prepareStatement(SqlQuery.RENTER_BY_ID_SQL))
        {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next())
            {
                renter = new Renter();
                renter.setId(id);
                renter.setName(rs.getString("NAME"));
                renter.setEmail(rs.getString("EMAIL"));
                renter.setPhoneNumber(rs.getString("PHONE_NUMBER"));
                renter.setCreateTime(rs.getLong("CREATE_TIME"));
                renter.setUpdateTime(rs.getLong("UPDATE_TIME"));
            }
        }
        catch (SQLException e)
        {
            throw new SQLException(e.getMessage());
        }
        return renter;
    }

    @Override
    public List<Renter> findRenterByName(Connection con, String name) throws SQLException
    {
        List<Renter> list = new ArrayList<>();
        try (PreparedStatement stmt = con.prepareStatement(SqlQuery.RENTER_BY_NAME_SQL))
        {
            stmt.setString(1, name);
            ResultSet rs = stmt.executeQuery();
            if (rs.next())
            {
                Renter renter = new Renter();
                renter.setId(rs.getInt("RENTER_ID"));
                renter.setName(name);
                renter.setEmail(rs.getString("EMAIL"));
                renter.setPhoneNumber(rs.getString("PHONE_NUMBER"));
                renter.setCreateTime(rs.getLong("CREATE_TIME"));
                renter.setUpdateTime(rs.getLong("UPDATE_TIME"));

                list.add(renter);
            }
        }
        catch (SQLException e)
        {
            throw new SQLException(e.getMessage());
        }
        return list;
    }

    @Override
    public Renter findRenterByEmail(Connection con, String email) throws SQLException
    {
        Renter renter = null;
        try (PreparedStatement stmt = con.prepareStatement(SqlQuery.RENTER_BY_ID_SQL))
        {
            stmt.setString(1, email);
            ResultSet rs = stmt.executeQuery();
            if (rs.next())
            {
                renter = new Renter();
                renter.setId(rs.getInt("RENTER_ID"));
                renter.setName(rs.getString("NAME"));
                renter.setEmail(email);
                renter.setPhoneNumber(rs.getString("PHONE_NUMBER"));
                renter.setCreateTime(rs.getLong("CREATE_TIME"));
                renter.setUpdateTime(rs.getLong("UPDATE_TIME"));
            }
        }
        catch (SQLException e)
        {
            throw new SQLException(e.getMessage());
        }
        return renter;
    }

    @Override
    public Renter findRenterByPhoneNumber(Connection con, String phone) throws SQLException
    {
        Renter renter = null;
        try (PreparedStatement stmt = con.prepareStatement(SqlQuery.RENTER_BY_ID_SQL))
        {
            stmt.setString(1, phone);
            ResultSet rs = stmt.executeQuery();
            if (rs.next())
            {
                renter = new Renter();
                renter.setId(rs.getInt("RENTER_ID"));
                renter.setName(rs.getString("NAME"));
                renter.setEmail(rs.getString("EMAIL"));
                renter.setPhoneNumber(phone);
                renter.setCreateTime(rs.getLong("CREATE_TIME"));
                renter.setUpdateTime(rs.getLong("UPDATE_TIME"));
            }
        }
        catch (SQLException e)
        {
            throw new SQLException(e.getMessage());
        }
        return renter;
    }

    @Override
    public Renter findRenterByNameAndEmail(Connection con, String name, String email) throws SQLException
    {
        Renter renter = null;
        try (PreparedStatement stmt = con.prepareStatement(SqlQuery.RENTER_BY_ID_SQL))
        {
            stmt.setString(1, name);
            stmt.setString(2, email);
            ResultSet rs = stmt.executeQuery();
            if (rs.next())
            {
                renter = new Renter();
                renter.setId(rs.getInt("RENTER_ID"));
                renter.setName(name);
                renter.setEmail(email);
                renter.setPhoneNumber(rs.getString("PHONE_NUMBER"));
                renter.setCreateTime(rs.getLong("CREATE_TIME"));
                renter.setUpdateTime(rs.getLong("UPDATE_TIME"));
            }
        }
        catch (SQLException e)
        {
            throw new SQLException(e.getMessage());
        }
        return renter;
    }

    @Override
    public Renter findRenterByNameAndPhoneNumber(Connection con, String name, String phone) throws SQLException
    {
        Renter renter = null;
        try (PreparedStatement stmt = con.prepareStatement(SqlQuery.RENTER_BY_ID_SQL))
        {
            stmt.setString(1, name);
            stmt.setString(2, phone);
            ResultSet rs = stmt.executeQuery();
            if (rs.next())
            {
                renter = new Renter();
                renter.setId(rs.getInt("RENTER_ID"));
                renter.setName(name);
                renter.setEmail(rs.getString("EMAIL"));
                renter.setPhoneNumber(phone);
                renter.setCreateTime(rs.getLong("CREATE_TIME"));
                renter.setUpdateTime(rs.getLong("UPDATE_TIME"));
            }
        }
        catch (SQLException e)
        {
            throw new SQLException(e.getMessage());
        }
        return renter;
    }

    @Override
    public Renter findRenterByEmailAndPhoneNumber(Connection con, String email, String phone) throws SQLException
    {
        Renter renter = null;
        try (PreparedStatement stmt = con.prepareStatement(SqlQuery.RENTER_BY_ID_SQL))
        {
            stmt.setString(1, email);
            stmt.setString(2, phone);
            ResultSet rs = stmt.executeQuery();
            if (rs.next())
            {
                renter = new Renter();
                renter.setId(rs.getInt("RENTER_ID"));
                renter.setName(rs.getString("NAME"));
                renter.setEmail(email);
                renter.setPhoneNumber(phone);
                renter.setCreateTime(rs.getLong("CREATE_TIME"));
                renter.setUpdateTime(rs.getLong("UPDATE_TIME"));
            }
        }
        catch (SQLException e)
        {
            throw new SQLException(e.getMessage());
        }
        return renter;
    }

    @Override
    public Renter findRenterByNameAndEmailAndPhoneNumber(Connection con, String name, String email, String phone) throws SQLException
    {
        Renter renter = null;
        try (PreparedStatement stmt = con.prepareStatement(SqlQuery.RENTER_BY_ID_SQL))
        {
            stmt.setString(1, name);
            stmt.setString(2, email);
            stmt.setString(3, phone);
            ResultSet rs = stmt.executeQuery();
            if (rs.next())
            {
                renter = new Renter();
                renter.setId(rs.getInt("RENTER_ID"));
                renter.setName(name);
                renter.setEmail(email);
                renter.setPhoneNumber(phone);
                renter.setCreateTime(rs.getLong("CREATE_TIME"));
                renter.setUpdateTime(rs.getLong("UPDATE_TIME"));
            }
        }
        catch (SQLException e)
        {
            throw new SQLException(e.getMessage());
        }
        return renter;
    }

    @Override
    public Renter findRenterByIdAndNameAndEmailAndPhoneNumber(Connection con, Integer id, String name, String email, String phone) throws SQLException
    {
        Renter renter = null;
        try (PreparedStatement stmt = con.prepareStatement(SqlQuery.RENTER_BY_ID_SQL))
        {
            stmt.setInt(1, id);
            stmt.setString(1, name);
            stmt.setString(2, email);
            stmt.setString(3, phone);
            ResultSet rs = stmt.executeQuery();
            if (rs.next())
            {
                renter = new Renter();
                renter.setId(id);
                renter.setName(name);
                renter.setEmail(email);
                renter.setPhoneNumber(phone);
                renter.setCreateTime(rs.getLong("CREATE_TIME"));
                renter.setUpdateTime(rs.getLong("UPDATE_TIME"));
            }
        }
        catch (SQLException e)
        {
            throw new SQLException(e.getMessage());
        }
        return renter;
    }
}
