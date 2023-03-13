package main.view;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
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
import main.model.UserModel;
import main.services.IBookService;
import main.services.ILibraryService;
import main.services.IRenterService;
import main.services.impl.BookService;
import main.services.impl.LibraryService;
import main.services.impl.RenterService;
import main.utils.DatabaseUtils;

public class HomePage extends JFrame
{

    private static final long  serialVersionUID = 1L;

    private Connection         con;

    private IBookService       bookService      = BookService.getInstance();

    private ILibraryService    libraryService   = LibraryService.getInstance();

    private IRenterService     renterService    = RenterService.getInstance();

    private ApplicationCfg     applicationCfg   = ApplicationCfg.getInstance();

    private UserModel          user             = applicationCfg.getUser();

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

    private Integer            idOfRecord;

    private boolean            isSelectTable;

    private boolean            isSelectRecord;

    public HomePage()
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
        // Title sectiongetValueAt
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
                    String selectedItem = String.valueOf(tableComboBox.getSelectedItem());
                    isSelectTable = true;
                    try
                    {
                        con = DatabaseUtils.getConnection();
                        fetchData(con, selectedItem);
                        renderFields(selectedItem, tableModel);
                    }
                    catch (Exception exception)
                    {
                        System.out.println(exception.getMessage());
                    }
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
        btnSave.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                if (isSelectTable)
                {
                    btnSaveActionPerformed(e);
                }
                else
                {
                    alert("Please choose table!");
                }
            }
        });

        btnUpdate = new JButton("Update");
        btnUpdate.setBorder(new SoftBevelBorder(BevelBorder.RAISED));
        btnUpdate.addActionListener(new ActionListener()
        {

            @Override
            public void actionPerformed(ActionEvent actionEvent)
            {
                if (isSelectTable && isSelectRecord)
                {
                    btnUpdateActionPerformed(actionEvent);
                }
                else if (isSelectTable)
                {
                    alert("Please choose record on table to update or delete!");
                }
                else if (isSelectRecord)
                {
                    alert("Please choose table!");
                }
                else
                {
                    alert("Please choose table and then select record to update or delete!");
                }
            }
        });

        btnDelete = new JButton("Delete");
        btnDelete.setBorder(new SoftBevelBorder(BevelBorder.RAISED));
        btnDelete.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent var1)
            {
                if (isSelectTable && isSelectRecord)
                {
                    btnDeleteActionListener(var1);
                }
                else if (isSelectTable)
                {
                    alert("Please choose record on table to update or delete!");
                }
                else if (isSelectRecord)
                {
                    alert("Please choose table!");
                }
                else
                {
                    alert("Please choose table and then select record to update or delete!");
                }
            }
        });

        // Content table section
        contentTable = new JTable();
        contentTable.addMouseListener(new MouseAdapter()
        {
            public void mouseClicked(MouseEvent evt)
            {
                isSelectRecord = true;
                tableMouseClicked(evt);
            }
        });
        jScrollPane = new JScrollPane();
        jScrollPane.setViewportView(contentTable);

        // Authenticate user
        if ("user".equals(user.getRule()))
        {
            activitiesPanel.setVisible(false);
            btnSave.setVisible(false);
            btnUpdate.setVisible(false);
            btnDelete.setVisible(false);
        }

        // Set group layout of HomePage
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);

        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGap(218, 218, 218).addComponent(tableNameLabel).addComponent(tableComboBox).addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)).addGroup(layout.createSequentialGroup().addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(activitiesPanel).addGap(18, 18, 18).addGroup(layout.createSequentialGroup().addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE).addComponent(btnSave, GroupLayout.PREFERRED_SIZE, 72, GroupLayout.PREFERRED_SIZE).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE).addComponent(btnUpdate, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE).addGap(27, 27, 27).addComponent(btnDelete, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE).addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))).addPreferredGap(ComponentPlacement.RELATED).addComponent(jScrollPane, GroupLayout.PREFERRED_SIZE, 500, GroupLayout.PREFERRED_SIZE).addContainerGap()));

        layout.setVerticalGroup(layout.createParallelGroup(Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(Alignment.LEADING).addComponent(tableNameLabel).addComponent(tableComboBox)).addGap(30, 30, 30).addGroup(layout.createParallelGroup(Alignment.LEADING).addGroup(layout.createSequentialGroup().addComponent(activitiesPanel).addGap(30, 30, 30).addGroup(layout.createParallelGroup(Alignment.LEADING).addGroup(layout.createParallelGroup(Alignment.BASELINE).addComponent(btnDelete, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE).addComponent(btnUpdate, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)).addComponent(btnSave, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE))).addComponent(jScrollPane, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 400, GroupLayout.PREFERRED_SIZE)).addContainerGap(29, Short.MAX_VALUE))

        );
    }

    public static void main(String[] args)
    {
        new HomePage();
    }

    /**
     * ActionListerner for save button
     * render table content from database
     * render JTextField area
     * 
     * @param e: save button event
     */
    private void btnSaveActionPerformed(ActionEvent e)
    {
        List<String> inputs = getTextField();
        String seletedItem = String.valueOf(tableComboBox.getSelectedItem());

        boolean isSaveSuccess = false;
        if (ObjectType.BOOK.getValue().equals(seletedItem))
        {
            String name = inputs.get(0);
            String author = inputs.get(1);
            if (!name.isEmpty() && !author.isEmpty())
            {
                try
                {
                    con = DatabaseUtils.getConnection();
                    isSaveSuccess = bookService.createBook(con, name, author);
                }
                catch (SQLException e1)
                {
                    System.out.println(e1.getMessage());
                }
            }
            else
            {
                alert("Please fill in all the details!");
            }
        }
        else if (ObjectType.LIBRARY.getValue().equals(seletedItem))
        {
            String name = inputs.get(0);
            String location = inputs.get(1);
            if (!name.isEmpty() && !location.isEmpty())
            {
                try
                {
                    con = DatabaseUtils.getConnection();
                    isSaveSuccess = libraryService.createLibrary(con, name, location);
                }
                catch (SQLException e1)
                {
                    System.out.println(e1.getMessage());
                }
            }
            else
            {
                alert("Please fill in all the details!!");
            }
        }
        else if (ObjectType.RENTER.getValue().equals(seletedItem))
        {
            String name = inputs.get(0);
            String email = inputs.get(1);
            String phoneNumber = inputs.get(2);
            if (!name.isEmpty() && !email.isEmpty() && !phoneNumber.isEmpty())
            {
                try
                {
                    con = DatabaseUtils.getConnection();
                    isSaveSuccess = renterService.createRenter(con, name, email, phoneNumber);
                }
                catch (SQLException e1)
                {
                    System.out.println(e1.getMessage());
                }
            }
            else
            {
                alert("Please fill in all the details!!");
            }
        }

        if (isSaveSuccess)
        {
            alert("Success!");
        }

        clearTextField(activitiesPanel.getComponents());
    }

    /**
     * ActionListerner for update button
     * update record and update table content from database
     * 
     * @param e: event
     */
    private void btnUpdateActionPerformed(ActionEvent e)
    {
        List<String> inputs = getTextField();

        String seletedItem = String.valueOf(tableComboBox.getSelectedItem());
        boolean isUpdateSuccess = false;
        if (ObjectType.BOOK.getValue().equals(seletedItem))
        {
            String name = inputs.get(0);
            String author = inputs.get(1);
            if (!name.isEmpty() && !author.isEmpty())
            {
                try
                {
                    con = DatabaseUtils.getConnection();
                    isUpdateSuccess = bookService.updateBookById(con, idOfRecord, name, author);
                }
                catch (SQLException e1)
                {
                    System.out.println(e1.getMessage());
                }
            }
            else
            {
                alert("There is nothing to update :(", "No row selected");
            }
        }
        else if (ObjectType.LIBRARY.getValue().equals(seletedItem))
        {
            String name = inputs.get(0);
            String location = inputs.get(1);
            if (!name.isEmpty() && !location.isEmpty())
            {
                try
                {
                    con = DatabaseUtils.getConnection();
                    isUpdateSuccess = libraryService.updateLibraryById(con, idOfRecord, name, location);
                }
                catch (SQLException e1)
                {
                    System.out.println(e1.getMessage());
                }
            }
            else
            {
                alert("Please fill in all the details!");
            }
        }
        else if (ObjectType.RENTER.getValue().equals(seletedItem))
        {
            String name = inputs.get(0);
            String email = inputs.get(1);
            String phoneNumber = inputs.get(2);
            if (!name.isEmpty() && !email.isEmpty() && !phoneNumber.isEmpty())
            {
                try
                {
                    con = DatabaseUtils.getConnection();
                    isUpdateSuccess = renterService.updateRenterById(con, idOfRecord, name, email, phoneNumber);
                }
                catch (SQLException e1)
                {
                    System.out.println(e1.getMessage());
                }
            }
            else
            {
                alert("Please fill in all the details!");
            }

        }

        if (isUpdateSuccess)
        {
            fetchData(con, seletedItem);
            alert("Update successfully!");
        }

        clearTextField(activitiesPanel.getComponents());
    }

    private void btnDeleteActionListener(ActionEvent e)
    {
        String seletedItem = String.valueOf(tableComboBox.getSelectedItem());
        boolean isDeleteSuccess = false;
        if (ObjectType.BOOK.getValue().equals(seletedItem))
        {
            try
            {
                con = DatabaseUtils.getConnection();
                isDeleteSuccess = bookService.removeBookById(con, idOfRecord);
            }
            catch (SQLException e1)
            {
                System.out.println(e1.getMessage());
            }
        }
        else if (ObjectType.LIBRARY.getValue().equals(seletedItem))
        {
            try
            {
                con = DatabaseUtils.getConnection();
                isDeleteSuccess = libraryService.removeLibraryById(con, idOfRecord);
            }
            catch (SQLException e1)
            {
                System.out.println(e1.getMessage());
            }
        }
        else if (ObjectType.RENTER.getValue().equals(seletedItem))
        {
            try
            {
                con = DatabaseUtils.getConnection();
                isDeleteSuccess = renterService.removeRenterById(con, idOfRecord);
            }
            catch (SQLException e1)
            {
                System.out.println(e1.getMessage());
            }
        }

        if (isDeleteSuccess)
        {
            fetchData(con, seletedItem);
            alert("Delete successfully!");
        }
    }

    /**
     * MouseClick action listener on content table
     * update idOfRecord variable: id field of record
     * 
     * @param evt: mouse click event
     */
    private void tableMouseClicked(MouseEvent evt)
    {
        Integer row = contentTable.getSelectedRow();
        tableModel = (AbstractTableModel) contentTable.getModel();

        idOfRecord = (Integer) tableModel.getValueAt(row, 0);
    }

    /**
     * Clear user inputs in text field section.
     * 
     * @param textfields: JTextField list
     */
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

    /**
     * method to show an info alert
     * 
     * @param msg: message
     */
    public void alert(String msg)
    {
        JOptionPane.showMessageDialog(rootPane, msg);
    }

    /**
     * method to show an error alert
     * 
     * @param msg: message
     */
    public void alert(String msg, String title)
    {
        JOptionPane.showMessageDialog(rootPane, msg, title, JOptionPane.ERROR_MESSAGE);
    }

    /**
     * fetch all records from database for corresponding table
     * 
     * @param seletedItem: is a table name
     */
    private void fetchData(Connection con, String seletedItem)
    {
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
            alert("Cannot get table!");
        }

        contentTable.setModel(tableModel);

        contentTable.revalidate();
        contentTable.repaint();
    }

    /**
     * Render text fields corresponding with table column of UPDATE, SAVE
     * 
     * @param seletedItem: table column name
     */
    private void renderFields(String seletedItem, AbstractTableModel tableModel)
    {
        if (activitiesPanel.getComponentCount() != 0)
        {
            activitiesPanel.removeAll();
        }
        for (int i = 1; i < tableModel.getColumnCount() - 2; i++)
        {
            activitiesPanel.add(new JTextField(tableModel.getColumnName(i), 15));
            activitiesPanel.add(Box.createRigidArea(new Dimension(0, 5)));

        }

        activitiesPanel.revalidate();
        activitiesPanel.repaint();
    }

    /**
     * get inputs of user in text fields section.
     * 
     * @return
     */
    private List<String> getTextField()
    {
        List<String> inputs = new ArrayList<>();
        for (Component component : activitiesPanel.getComponents())
        {
            if (component instanceof JTextField)
            {
                inputs.add(((JTextField) component).getText().trim());
            }
        }
        return inputs;
    }
}
