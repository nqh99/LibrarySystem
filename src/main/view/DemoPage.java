package main.view;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.BevelBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.table.AbstractTableModel;

import main.configures.ApplicationCfg;
import main.domain.ObjectType;
import main.services.IBookService;
import main.services.ILibraryService;
import main.services.IRenterService;
import main.services.impl.BookService;
import main.services.impl.LibraryService;
import main.services.impl.RenterService;
import main.utils.DatabaseUtils;

public class DemoPage extends JFrame
{

    private static final long  serialVersionUID = 1L;

    private Connection         con;

    private IBookService       bookService      = BookService.getInstance();

    private ILibraryService    libraryService   = LibraryService.getInstance();

    private IRenterService     renterService    = RenterService.getInstance();

    private ApplicationCfg     applicationCfg   = ApplicationCfg.getInstance();

    private String[]           tableNameList    = applicationCfg.getTableNames();

    private JLabel             tableNameLabel;

    private JComboBox<String>  tableComboBox;

    private AbstractTableModel tableModel;

    private JPanel             activitiesPanel;

    private JButton            btnSave;

    private JButton            btnUpdate;

    private JButton            btnDelete;

    private JTable             contentTable;

    private JScrollPane        jScrollPane;

//    private boolean            isSelect;

    public DemoPage()
    {
        initComponents();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Library System");
        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    private void initComponents()
    {
        // Title section
        tableNameLabel = new JLabel("Choose table: ");
        tableNameLabel.setFont(new Font("Tahoma", 0, 18));

        tableComboBox = new JComboBox<>(tableNameList);
        tableComboBox.setSelectedIndex(-1);
        tableComboBox.setSize(70, 25);
        tableComboBox.addItemListener(new ItemListener()
        {
            @Override
            public void itemStateChanged(ItemEvent e)
            {
                if (e.getSource() == tableComboBox)
                {
//                    isSelect = true;
                    String seletedItem = String.valueOf(tableComboBox.getSelectedItem());

                    try
                    {
                        con = DatabaseUtils.getConnection();
                    }
                    catch (SQLException sqlException)
                    {
                        sqlException.printStackTrace();
                    }

                    if (ObjectType.BOOK.getValue().equals(seletedItem))
                    {
                        tableModel = bookService.findAllBook(con);
                    }
                    else if (ObjectType.LIBRARY.getValue().equals(seletedItem))
                    {
                        tableModel = libraryService.findAllLibrary(con);
                    }
                    else if (ObjectType.RENTER.getValue().equals(seletedItem))
                    {
                        tableModel = renterService.findAllRenters(con);
                    }
                    else
                    {
                        System.out.println("Cannot get table.");
                    }

                    if (activitiesPanel.getComponentCount() != 0)
                    {
                        activitiesPanel.removeAll();
                    }
                    for (int i = 0; i < tableModel.getColumnCount() - 2; i++)
                    {
                        activitiesPanel.add(new JTextField(tableModel.getColumnName(i), 15));
                        activitiesPanel.add(Box.createRigidArea(new Dimension(0, 5)));

                    }

                    contentTable.setModel(tableModel);

                    activitiesPanel.revalidate();
                    activitiesPanel.repaint();

                    contentTable.revalidate();
                    contentTable.repaint();
                }
            }
        });

        // CRUD section (left side): fields, Buttons
        // TODO fields
        activitiesPanel = new JPanel();
        activitiesPanel.setLayout(new BoxLayout(activitiesPanel, BoxLayout.Y_AXIS));

        // TODO Buttons
        btnSave = new JButton("Save");
        btnSave.setBorder(new SoftBevelBorder(BevelBorder.RAISED));
        btnSave.setInheritsPopupMenu(true);
        btnSave.setIconTextGap(0);

        btnUpdate = new JButton("Update");
        btnUpdate.setBorder(new SoftBevelBorder(BevelBorder.RAISED));

        btnDelete = new JButton("Delete");
        btnDelete.setBorder(new SoftBevelBorder(BevelBorder.RAISED));

        // Content table section
        contentTable = new JTable();
        jScrollPane = new JScrollPane();
        jScrollPane.setViewportView(contentTable);

        // Set group layout of HomePage
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);

        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGap(218, 218, 218).addComponent(tableNameLabel).addComponent(tableComboBox).addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)).addGroup(layout.createSequentialGroup().addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(activitiesPanel).addGap(18, 18, 18).addGroup(layout.createSequentialGroup().addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE).addComponent(btnSave, GroupLayout.PREFERRED_SIZE, 72, GroupLayout.PREFERRED_SIZE).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE).addComponent(btnUpdate, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE).addGap(27, 27, 27).addComponent(btnDelete, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE).addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))).addPreferredGap(ComponentPlacement.RELATED).addComponent(jScrollPane, GroupLayout.PREFERRED_SIZE, 500, GroupLayout.PREFERRED_SIZE).addContainerGap()));

        layout.setVerticalGroup(layout.createParallelGroup(Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(Alignment.LEADING).addComponent(tableNameLabel).addComponent(tableComboBox)).addGap(30, 30, 30).addGroup(layout.createParallelGroup(Alignment.LEADING).addGroup(layout.createSequentialGroup().addComponent(activitiesPanel).addGap(30, 30, 30).addGroup(layout.createParallelGroup(Alignment.LEADING).addGroup(layout.createParallelGroup(Alignment.BASELINE).addComponent(btnDelete, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE).addComponent(btnUpdate, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)).addComponent(btnSave, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE))).addComponent(jScrollPane, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 400, GroupLayout.PREFERRED_SIZE)).addContainerGap(29, Short.MAX_VALUE))

        );
    }

    public static void main(String[] args)
    {
        new DemoPage();
    }

    private void btnSaveActionPerformed(ActionEvent e)
    {
        List<String> inputs = new ArrayList<>();
        for (Component component : activitiesPanel.getComponents())
        {
            if (component instanceof JTextField)
            {
                inputs.add(((JTextField) component).getText().trim());
            }
        }

        String seletedItem = String.valueOf(tableComboBox.getSelectedItem());

        if (ObjectType.BOOK.getValue().equals(seletedItem))
        {
            Integer id = Integer.parseInt(inputs.get(0));
            String name = inputs.get(1);
            String author = inputs.get(2);
            if (id != null && !name.isEmpty() && !author.isEmpty())
            {
                System.out.println("save");
            } else {
                alert("please fill in all the details");
            }
        }
        else if (ObjectType.LIBRARY.getValue().equals(seletedItem))
        {
            Integer id = Integer.parseInt(inputs.get(0));
            String name = inputs.get(1);
            String location = inputs.get(2);
            if (id != null && !name.isEmpty() && !location.isEmpty())
            {
                System.out.println("save");
            } else {
                alert("please fill in all the details");
            }
        }
        else if (ObjectType.RENTER.getValue().equals(seletedItem))
        {
            Integer id = Integer.parseInt(inputs.get(0));
            String name = inputs.get(1);
            String email = inputs.get(2);
            String phoneNumber = inputs.get(3);
            if (id != null && !name.isEmpty() && !email.isEmpty() && !phoneNumber.isEmpty())
            {
                System.out.println("save");
            } else {
                alert("please fill in all the details");
            }

        }
        else
        {
            System.out.println("Cannot get table.");
        }
        clearTextField(activitiesPanel.getComponents());
    }
    
    private void btnUpdateActionPerformed(ActionEvent e) {
        List<String> inputs = new ArrayList<>();
        for (Component component : activitiesPanel.getComponents())
        {
            if (component instanceof JTextField)
            {
                inputs.add(((JTextField) component).getText().trim());
            }
        }

        String seletedItem = String.valueOf(tableComboBox.getSelectedItem());
        int num = 0;
        if (ObjectType.BOOK.getValue().equals(seletedItem))
        {
            Integer id = Integer.parseInt(inputs.get(0));
            String name = inputs.get(1);
            String author = inputs.get(2);
            if (id != null && !name.isEmpty() && !author.isEmpty())
            {
                try
                {
                    con = DatabaseUtils.getConnection();
                    num = bookService.updateBookById(con, id, name, author); 
                }
                catch (SQLException e1)
                {
                    e1.printStackTrace();
                }
            } else {
                alert("There is nothing to update :(","No row selected");
            }
        }
        else if (ObjectType.LIBRARY.getValue().equals(seletedItem))
        {
            Integer id = Integer.parseInt(inputs.get(0));
            String name = inputs.get(1);
            String location = inputs.get(2);
            if (id != null && !name.isEmpty() && !location.isEmpty())
            {
                System.out.println("save");
            } else {
                alert("please fill in all the details");
            }
        }
        else if (ObjectType.RENTER.getValue().equals(seletedItem))
        {
            Integer id = Integer.parseInt(inputs.get(0));
            String name = inputs.get(1);
            String email = inputs.get(2);
            String phoneNumber = inputs.get(3);
            if (id != null && !name.isEmpty() && !email.isEmpty() && !phoneNumber.isEmpty())
            {
                System.out.println("save");
            } else {
                alert("please fill in all the details");
            }

        }
        else
        {
            System.out.println("Cannot get table.");
        }
        clearTextField(activitiesPanel.getComponents());
    }
    
    

    private void clearTextField(Component[] textfields)
    {
        for (Component component : textfields)
        {
            if (component instanceof JTextField)
            {
                ((JTextField) component).setText("");
            }
        }
    }

    // method to show an info alert
    public void alert(String msg)
    {
        JOptionPane.showMessageDialog(rootPane, msg);
    }

    // method to show an error alert
    public void alert(String msg, String title)
    {
        JOptionPane.showMessageDialog(rootPane, msg, title, JOptionPane.ERROR_MESSAGE);
    }
}
