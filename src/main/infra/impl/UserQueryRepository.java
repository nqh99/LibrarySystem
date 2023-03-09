package main.infra.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import database.SqlQuery;
import main.domain.User;
import main.infra.IUserQueryRepository;

/**
 * Singleton
 * 
 * @author ttl
 *
 */
public class UserQueryRepository implements IUserQueryRepository
{
    private static volatile UserQueryRepository obj = null;

    private UserQueryRepository()
    {
    }

    public static UserQueryRepository getInstance()
    {
        if (obj == null)
        {
            synchronized (UserQueryRepository.class)
            {
                if (obj == null)
                {
                    obj = new UserQueryRepository();
                }
            }
        }
        return obj;
    }

    @Override
    public User findUserByUsernameAndPassword(Connection con, String username, String password) throws SQLException
    {
        User user = null;
        try (PreparedStatement stmt = con.prepareStatement(SqlQuery.USER_SQL))
        {
            stmt.setString(1, username);
            stmt.setString(2, password);
            ResultSet rs = stmt.executeQuery();
            if (rs.next())
            {
                user = new User();
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                user.setRule(rs.getString("rule"));
            }
        }
        catch (Exception e)
        {
            throw new SQLException(e.getMessage());
        }
        return user;
    }
}
