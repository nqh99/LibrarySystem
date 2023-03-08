package main.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.SQLException;

import javax.swing.JTextField;

import main.model.UserModel;
import main.services.LoginService;
import main.utils.DatabaseUtils;

public class LoginController
{

    private static volatile LoginController obj          = null;

    private final LoginService              loginService = LoginService.getInstance();

    private Connection                      con;

    private LoginController()
    {

    }

    public static LoginController getInstance()
    {
        if (obj == null)
        {
            synchronized (LoginService.class)
            {
                if (obj == null)
                {
                    obj = new LoginController();
                }
            }
        }
        return obj;
    }

    public class AuthenUserListerner implements ActionListener
    {

        private JTextField username;

        private JTextField password;

        public AuthenUserListerner(JTextField username, JTextField password) throws SQLException
        {
            super();
            this.username = username;
            this.password = password;
        }

        @Override
        public void actionPerformed(ActionEvent e)
        {
            try
            {
                con = DatabaseUtils.getConnection();
            }
            catch (SQLException e1)
            {
                e1.printStackTrace();
            }
            UserModel user = loginService.findUserByUsernameAndPassword(con, username.getText(), password.getText());
            System.out.println(user.getMessage());
        }

    }

}
