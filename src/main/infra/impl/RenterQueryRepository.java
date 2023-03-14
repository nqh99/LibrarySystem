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

    @Override
    public Renter findRenterById(Connection con, Integer id) throws SQLException
    {
        Renter renter = null;
        Audit audit = null;
        try (PreparedStatement stmt = con.prepareStatement(SqlQuery.RENTER_BY_ID_SQL))
        {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next())
            {
                renter = new Renter();

                audit = new Audit();
                audit.setId(id);
                audit.setName(rs.getString("NAME"));
                audit.setCreateTime(rs.getLong("CREATE_TIME"));
                audit.setUpdateTime(rs.getLong("UPDATE_TIME"));

                renter.setEmail(rs.getString("EMAIL"));
                renter.setPhoneNumber(rs.getString("PHONE_NUMBER"));
                renter.setAudit(audit);
            }
        }
        catch (SQLException e)
        {
            throw new SQLException(e);
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

                Audit audit = new Audit();
                audit.setId(rs.getInt("RENTER_ID"));
                audit.setName(rs.getString("NAME"));
                audit.setCreateTime(rs.getLong("CREATE_TIME"));
                audit.setUpdateTime(rs.getLong("UPDATE_TIME"));

                renter.setEmail(rs.getString("EMAIL"));
                renter.setPhoneNumber(rs.getString("PHONE_NUMBER"));
                renter.setAudit(audit);

                list.add(renter);
            }
        }
        catch (SQLException e)
        {
            throw new SQLException(e);
        }
        return list;
    }

    @Override
    public boolean createRenter(Connection con, String name, String email, String phoneNumber) throws SQLException
    {
        boolean result = false;
        try (PreparedStatement stmt = con.prepareStatement(SqlQuery.INSERT_BOOK))
        {
            Long createTime = new Date().getTime();
            stmt.setString(1, name);
            stmt.setString(2, email);
            stmt.setString(3, phoneNumber);
            stmt.setLong(4, createTime);
            stmt.setNull(5, Types.NULL);

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
            throw new SQLException(e);
        }
        return result;
    }

    @Override
    public boolean updateRenterById(Connection con, Integer id, String name, String email, String phoneNumber) throws SQLException
    {
        boolean result = false;
        try (PreparedStatement stmt = con.prepareStatement(SqlQuery.UPDATE_RENTER_BY_ID))
        {
            Long updateTime = new Date().getTime();
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
            throw new SQLException(e);
        }
        return result;
    }
}
