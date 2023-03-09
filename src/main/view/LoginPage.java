package main.view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import main.configures.ApplicationCfg;
import main.model.UserModel;
import main.services.ILoginService;
import main.services.impl.LoginService;
import main.utils.DatabaseUtils;

public class LoginPage extends JFrame
{
    private static final long    serialVersionUID = 1L;

    private final ApplicationCfg applicationCfg   = ApplicationCfg.getInstance();

    private Connection           con;

    private final ILoginService  loginService     = LoginService.getInstance();

    private JTextField           username;

    private JPasswordField       password;

    public LoginPage() throws SQLException
    {
        this.setLayout(new BorderLayout());

        JPanel contentPanel = new JPanel();

        JPanel userPanel = new JPanel(new FlowLayout());
        userPanel.add(new JLabel("Username: "));
        username = new JTextField(15);
        userPanel.add(username);

        JPanel passwordPanel = new JPanel(new FlowLayout());
        userPanel.add(new JLabel("Password: "));
        password = new JPasswordField(15);
        userPanel.add(password);

        JButton button = new JButton("Login");
        button.addActionListener(new ActionListener()
        {

            @Override
            public void actionPerformed(ActionEvent e)
            {
                try
                {
                    con = DatabaseUtils.getConnection();
                    UserModel user = loginService.findUserByUsernameAndPassword(con, username.getText(), new String(password.getPassword()));
                    if (user.isAuthen())
                    {
                        applicationCfg.setUser(user);
                        new HomePage();
                        closeFrame();
                    }
                }
                catch (SQLException e1)
                {
                    e1.printStackTrace();
                }

            }
        });

        contentPanel.add(userPanel);
        contentPanel.add(passwordPanel);
        contentPanel.add(button);

        this.add(contentPanel, BorderLayout.CENTER);

        this.setTitle("Sign in");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(300, 100);
        this.setVisible(true);
        this.pack();
    }

    private void closeFrame()
    {
        this.dispose();
    }
}
