package main.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;

import main.model.UserModel;
import main.services.LoginService;

public class LoginController implements ActionListener
{
    
    private final LoginService loginService = LoginService.getInstance();

    private JTextField username;

    private JTextField password;

    public LoginController(JTextField username, JTextField password)
    {
        super();
        this.username = username;
        this.password = password;
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        UserModel user = loginService.findUserByUsername(username.getText(), password.getText());
        if(user.isAuthen()) {
            System.out.println("success");
        } else {
            System.out.println("false");
        }
    }

}
