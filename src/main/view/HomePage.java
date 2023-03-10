package main.view;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.AbstractTableModel;

import main.configures.ApplicationCfg;
import main.domain.ObjectType;
import main.services.IBookService;
import main.services.impl.BookService;
import main.utils.DatabaseUtils;

public class HomePage extends JFrame
{

    private static final long                         serialVersionUID = 1L;

    private Connection                                con;

    private ApplicationCfg                            applicationCfg   = ApplicationCfg.getInstance();

    private IBookService                              bookService      = BookService.getInstance();

    private final String[]                            tableNames       = ApplicationCfg.getInstance().getTableNames();

    private final Map<ObjectType, AbstractTableModel> objectMap        = ApplicationCfg.getInstance().getObjectMap();

    private JComboBox<String>                         tablesComboBox;

    private JPanel                                    searchFields;

    private JButton                                   searchBtn;

    private AbstractTableModel                        tableModel;

    private JTable                                    contentTable;

    private JPanel                                    contentPanel;

    private JPanel                                    tailPanel;

    private JButton                                   deleteBtn;

    private JButton                                   updateBtn;

    private boolean                                   isSelect         = false;

    public HomePage()
    {
        this.setLayout(new BorderLayout());

        JPanel searchPanel = new JPanel();
        searchPanel.setLayout(new BoxLayout(searchPanel, BoxLayout.Y_AXIS));
        searchPanel.add(new JLabel("Object name: "));

        tablesComboBox = new JComboBox<>(tableNames);
        tablesComboBox.setSize(70, 25);
        tablesComboBox.setSelectedIndex(-1);
        searchPanel.add(tablesComboBox);

        // Search fields
        searchFields = new JPanel();
        searchFields.setLayout(new BoxLayout(searchFields, BoxLayout.Y_AXIS));
        searchPanel.add(searchFields);

        tablesComboBox.addItemListener(new ItemListener()
        {

            @Override
            public void itemStateChanged(ItemEvent e)
            {
                if (e.getSource() == tablesComboBox)
                {
                    isSelect = true;
                    String seletedItem = String.valueOf(tablesComboBox.getSelectedItem());
                    tableModel = objectMap.get(ObjectType.fromValue(seletedItem));
                    if (searchFields != null)
                    {
                        searchFields.removeAll();
                    }
                    for (int i = 0; i < tableModel.getColumnCount() - 2; i++)
                    {
                        searchFields.add(new JTextField(tableModel.getColumnName(i), 20));
                        searchFields.revalidate();
                        searchFields.repaint();
                    }
                }
            }
        });

        searchBtn = new JButton("Search");
        searchPanel.add(searchBtn);

        searchBtn.addActionListener(new ActionListener()
        {

            @Override
            public void actionPerformed(ActionEvent e)
            {
                try
                {
                    con = DatabaseUtils.getConnection();
                    contentPanel.removeAll();
                    if (tablesComboBox.getSelectedItem() == ObjectType.BOOK.getValue())
                    {
                        List<JTextField> userInputs = new ArrayList<>();
                        for (Component input : searchFields.getComponents())
                        {
                            if (input instanceof JTextField)
                            {
                                userInputs.add((JTextField) input);
                            }
                        }

                        tableModel = bookService.findBookByIdAndNameAndAuthor(con, Integer.parseInt(userInputs.get(0).getText()), userInputs.get(1).getText(), userInputs.get(2).getText());

                        contentTable = new JTable(tableModel);
                        contentPanel.add(new JScrollPane(contentTable), BorderLayout.CENTER);
                        contentPanel.revalidate();
                        contentPanel.repaint();
                    }

                }
                catch (SQLException e1)
                {
                    e1.printStackTrace();
                }

            }
        });

        this.add(searchPanel, BorderLayout.NORTH);

        contentPanel = new JPanel();

        this.add(contentPanel, BorderLayout.CENTER);

        if ("admin".equals(applicationCfg.getUser().getRule()))
        {
            tailPanel = new JPanel(new FlowLayout());
            deleteBtn = new JButton("Delete");

            deleteBtn.addActionListener(new ActionListener()
            {

                @Override
                public void actionPerformed(ActionEvent e)
                {
                    if (isSelect)
                    {
                        new DeleteForm(tablesComboBox);
                    }
                    else
                    {
                        System.out.println("You aren't not select search field. Please check this!");
                    }
                }
            });
            deleteBtn.setSize(new Dimension(70, 40));

            updateBtn = new JButton("Update");
            updateBtn.setSize(new Dimension(70, 40));
            updateBtn.addActionListener(new ActionListener()
            {

                @Override
                public void actionPerformed(ActionEvent e)
                {
                    if (isSelect)
                    {
                        new UpdateForm(tablesComboBox);
                    }
                    else
                    {
                        System.out.println("You aren't not select search field. Please check this!");
                    }
                }
            });

            tailPanel.add(deleteBtn);
            tailPanel.add(updateBtn);

        }

        this.add(tailPanel, BorderLayout.SOUTH);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.setPreferredSize(new Dimension(700, 500));
        this.pack();

    }
}
