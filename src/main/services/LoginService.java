package main.services;

import java.sql.Connection;
import java.sql.SQLException;

import main.infra.IUserQueryRepository;
import main.infra.UserQueryRepository;
import main.model.UserModel;
import main.utils.DatabaseUtils;

public class LoginService implements ILoginService
{
    private final IUserQueryRepository   userQueryRepository = UserQueryRepository.getInstance();

    private static volatile LoginService obj                 = null;

    private LoginService()
    {

    }

    public static LoginService getInstance()
    {
        if (obj == null)
        {
            synchronized (LoginService.class)
            {
                if (obj == null)
                {
                    obj = new LoginService();
                }
            }
        }
        return obj;
    }

    @Override
    public UserModel findUserByUsername(String username, String password)
    {
        Connection con = null;
        try
        {
            con = DatabaseUtils.getConnection();
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        UserModel user = userQueryRepository.findUserByUsername(con, username, password);

        return user;
    }
}
