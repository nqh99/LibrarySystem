package main.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.SQLException;

import javax.swing.JTextField;

import main.model.UserModel;
import main.services.LoginService;
import main.utils.DatabaseUtils;

public class LoginController implements ActionListener
{

    private final LoginService loginService = LoginService.getInstance();

    private final Connection   con;

    private JTextField         username;

    private JTextField         password;

    public LoginController(JTextField username, JTextField password) throws SQLException
    {
        super();
        this.username = username;
        this.password = password;
        con = DatabaseUtils.getConnection();
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        UserModel user = loginService.findUserByUsernameAndPassword(con, username.getText(), password.getText());
        System.out.println(user.getMessage());
    }

}
