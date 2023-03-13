package main.infra.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import database.SqlQuery;
import main.domain.Renter;
import main.infra.IRenterQueryRepository;

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
            while (rs.next())
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

    @Override
    public List<Renter> findAllRenters(Connection con) throws SQLException
    {
        List<Renter> list = new ArrayList<>();
        try (PreparedStatement stmt = con.prepareStatement(SqlQuery.ALL_RENTERS_SQL))
        {
            ResultSet rs = stmt.executeQuery();
            while (rs.next())
            {
                Renter renter = new Renter();
                renter.setId(rs.getInt("RENTER_ID"));
                renter.setName(rs.getString("NAME"));
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
    public boolean createRenter(Connection con, String name, String email, String phoneNumber, Long createTime, Long updateTime) throws SQLException
    {
        boolean result = false;
        try (PreparedStatement stmt = con.prepareStatement(SqlQuery.INSERT_BOOK))
        {
            stmt.setString(1, name);
            stmt.setString(2, email);
            stmt.setString(3, phoneNumber);
            stmt.setLong(4, createTime);
            stmt.setLong(5, updateTime);

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
    public boolean removeRenterById(Connection con, Integer id) throws SQLException
    {
        boolean result = false;
        try (PreparedStatement stmt = con.prepareStatement(SqlQuery.DELETE_RENTER_BY_ID))
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
    public boolean updateRenterById(Connection con, Integer id, String name, String email, String phoneNumber, Long updateTime) throws SQLException
    {
        boolean result = false;
        try (PreparedStatement stmt = con.prepareStatement(SqlQuery.UPDATE_RENTER_BY_ID))
        {
            stmt.setString(1, name);
            stmt.setString(2, email);
            stmt.setString(3, phoneNumber);
            stmt.setLong(4, updateTime);
            stmt.setInt(5, id);
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
