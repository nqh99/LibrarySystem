package main.infra;

import java.sql.Connection;
import java.sql.SQLException;

import main.domain.User;

public interface IUserQueryRepository
{
    User findUserByUsernameAndPassword(Connection con, String username, String password) throws SQLException;
    
    
}
