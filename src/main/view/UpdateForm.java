package main.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JTextField;

import main.domain.ObjectType;
import main.services.IBookService;
import main.services.impl.BookService;
import main.utils.DatabaseUtils;

public class UpdateForm extends JFrame
{

    private static final long serialVersionUID = 1L;

    private Connection        con;

    private IBookService      bookService      = BookService.getInstance();

    private JComboBox<String> tablesComboBox;

    private JTextField        id;

    private JButton           deleteBtn;

    public UpdateForm(JComboBox<String> tablesComboBox)
    {
        this.tablesComboBox = tablesComboBox;

        setLayout(new BorderLayout());

        id = new JTextField("Id", 10);
        this.add(id, BorderLayout.CENTER);

        deleteBtn = new JButton("Confirm");
        deleteBtn.setSize(70, 40);
        this.add(deleteBtn, BorderLayout.SOUTH);
        deleteBtn.addActionListener(new ActionListener()
        {

            @Override
            public void actionPerformed(ActionEvent e)
            {
                try
                {
                    con = DatabaseUtils.getConnection();
                    if (ObjectType.BOOK.getValue().equals(tablesComboBox.getSelectedItem()))
                    {
                        int num = bookService.removeBookById(con, Integer.parseInt(id.getText()));
                        System.out.println(num);
                    }
                }
                catch (SQLException e1)
                {
                    e1.printStackTrace();
                }
            }
        });

        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setPreferredSize(new Dimension(200, 100));
        this.pack();
    }

    public JComboBox<String> getTablesComboBox()
    {
        return tablesComboBox;
    }

}
