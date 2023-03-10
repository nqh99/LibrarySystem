package main.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.AbstractTableModel;

import main.domain.ObjectType;
import main.domain.RealObject;
import main.model.BookModel;
import main.services.IBookService;
import main.services.impl.BookService;
import main.utils.DatabaseUtils;

public class UpdateForm extends JFrame
{

    private static final long  serialVersionUID = 1L;

    private Connection         con;

    private final IBookService bookService      = BookService.getInstance();

//    private final Map<ObjectType, AbstractTableModel> objectMap        = ApplicationCfg.getInstance().getObjectMap();

    private JPanel             contentPanel;

    private AbstractTableModel tableModel;

    private JList<String>      listData;

    private String             seletedItem;

    public UpdateForm(JComboBox<String> tablesComboBox)
    {
        this.setLayout(new BorderLayout());

        this.add(new JLabel(String.valueOf(tablesComboBox.getSelectedItem())), BorderLayout.NORTH);

        seletedItem = String.valueOf(tablesComboBox.getSelectedItem());

        contentPanel = new JPanel();
        listData = new JList<>();
        listData.setSelectionBackground(Color.LIGHT_GRAY);
        try
        {
            con = DatabaseUtils.getConnection();

            if (ObjectType.BOOK.getValue().equals(seletedItem))
            {
                tableModel = bookService.findAllBook(con);
                List<String> dataStr = new ArrayList<>();
                for (RealObject book : ((BookModel) tableModel).getBookList())
                {
                    dataStr.add(book.toString());
                }
                listData.setListData(dataStr.toArray(new String[0]));
            }
        }
        catch (SQLException e)
        {
            System.out.println(e.getMessage());
        }
        contentPanel.add(new JScrollPane(listData));

        listData.addListSelectionListener(new ListSelectionListener()
        {

            @Override
            public void valueChanged(ListSelectionEvent e)
            {
                JFrame popup = new JFrame();
                popup.setLayout(new BorderLayout());

                JPanel updatePanel = new JPanel();
                updatePanel.setLayout(new BoxLayout(updatePanel, BoxLayout.Y_AXIS));
                for (int i = 1; i < tableModel.getColumnCount() - 2; i++)
                {
                    updatePanel.add(new JTextField(tableModel.getColumnName(i), 20));
                }

                popup.add(updatePanel, BorderLayout.CENTER);

                JButton updateBtn = new JButton("update");
                updateBtn.setSize(100, 40);

                popup.add(updateBtn, BorderLayout.SOUTH);
                updateBtn.addActionListener(new ActionListener()
                {

                    @Override
                    public void actionPerformed(ActionEvent e)
                    {
                        try
                        {
                            con = DatabaseUtils.getConnection();
                            if (ObjectType.BOOK.getValue().equals(seletedItem))
                            {
                                List<JTextField> userInputs = new ArrayList<>();
                                for (Component input : updatePanel.getComponents())
                                {
                                    if (input instanceof JTextField)
                                    {
                                        userInputs.add((JTextField) input);
                                    }
                                }
                                Integer id = Integer.parseInt(userInputs.get(0).getText());
                                String name = userInputs.get(1).getText();
                                String author = userInputs.get(2).getText();
                                int num = bookService.updateBookById(con, id, name, author);
                                if (num > 0)
                                {
                                    System.out.println("Update success");
                                }
                                else
                                {
                                    System.out.println("Fail to update");
                                }
                            }

                        }
                        catch (SQLException sqlException)
                        {
                            System.out.println(sqlException.getMessage());
                        }
                    }

                });
                popup.pack();
                popup.setVisible(true);
                popup.setPreferredSize(new Dimension(300, 300));
                popup.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            }
        });

        this.add(contentPanel, BorderLayout.CENTER);

        this.pack();
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setPreferredSize(new Dimension(500, 700));
    }
}
