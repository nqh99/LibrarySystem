package main.infra;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import database.SqlQuery;
import main.model.UserModel;

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
    public UserModel findUserByUsername(Connection con, String username, String password)
    {
        UserModel userModel = new UserModel();
        try (PreparedStatement stmt = con.prepareStatement(SqlQuery.USER_SQL))
        {
            stmt.setString(1, username);
            stmt.setString(2, password);
            ResultSet rs = stmt.executeQuery();
            if (rs.next())
            {
                userModel.setUsername(rs.getString("USERNAME"));
                userModel.setPassword(rs.getString("password"));
                userModel.setRule(rs.getString("rule"));
                userModel.setAuthen(true);
                userModel.setMessage("Login success");
            }
            else
            {
                userModel.setAuthen(false);
                userModel.setMessage("Username or password is wrong. Please type in again!");
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
            userModel.setMessage(e.getMessage());
            userModel.setAuthen(false);
        }
        return userModel;
    }
}
