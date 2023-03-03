package main.services;

import main.model.UserModel;

public interface ILoginService
{
    public UserModel findUserByUsername(String username, String password);
}
