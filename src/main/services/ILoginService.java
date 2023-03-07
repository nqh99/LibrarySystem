package main.services;

import java.sql.Connection;

import main.model.UserModel;

public interface ILoginService
{
    public UserModel findUserByUsernameAndPassword(Connection con, String username, String password);

}
