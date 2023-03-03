package main.infra;

import java.sql.Connection;

import main.model.UserModel;

public interface IUserQueryRepository
{
    UserModel findUserByUsername(Connection con, String username, String password);
    
    
}
