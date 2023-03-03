package main.view;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import main.controller.LoginController;

public class LoginPage extends JFrame
{
    private static final long serialVersionUID = 1L;

    private JButton           button;

    private JPanel            panel;

    private JLabel            userLabel;

    private JLabel            passwordLabel;

    private final JTextField  username;

    private final JTextField  password;

    public LoginPage()
    {
        userLabel = new JLabel();
        userLabel.setText("Username");

        username = new JTextField(15);

        passwordLabel = new JLabel();
        passwordLabel.setText("Password");

        password = new JPasswordField(15);

        button = new JButton("Login");
        LoginController loginController = new LoginController(username, password);
        button.addActionListener(loginController);

        panel = new JPanel(new GridLayout(3, 1));
        panel.add(userLabel);
        panel.add(username);
        panel.add(passwordLabel);
        panel.add(password);
        panel.add(button);

        add(panel, BorderLayout.CENTER);

//        button.addActionListener(this); // add action listener to button
        setTitle("Sign in");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(300, 100);
        setVisible(true);
        pack();
    }

    public static void main(String[] args)
    {
        LoginPage lp = new LoginPage();
        Component c = lp.getComponent(0);
        System.out.println(c.getTreeLock());
        SwingUtilities.invokeLater(null);
    }
}