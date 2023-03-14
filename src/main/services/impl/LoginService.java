package main.services.impl;

import java.sql.Connection;
import java.sql.SQLException;

import main.domain.User;
import main.infra.IUserQueryRepository;
import main.infra.impl.UserQueryRepository;
import main.model.UserModel;
import main.services.ILoginService;

public class LoginService implements ILoginService
{
    @Override
    public UserModel findUserByUsernameAndPassword(Connection con, String username, String password)
    {
        UserModel userModel = new UserModel();
        IUserQueryRepository userQueryRepository = new UserQueryRepository();
        try
        {
            User user = userQueryRepository.findUserByUsernameAndPassword(con, username, password);
            if (user == null)
            {
                userModel.setAuthen(false);
                userModel.setMessage("Username or password is wrong. Please type in again!");
                return userModel;
            }
            userModel.setUsername(user.getUsername());
            userModel.setRule(user.getRule());
            userModel.setAuthen(true);
            userModel.setMessage("Login success!");
        }
        catch (SQLException e)
        {
            userModel.setAuthen(false);
            userModel.setMessage(e.getMessage());
        }

        return userModel;
    }
}
