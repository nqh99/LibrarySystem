package main.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.table.AbstractTableModel;

import main.configures.ApplicationCfg;
import main.domain.ObjectType;
import main.services.ISearchService;
import main.services.impl.LoginService;
import main.services.impl.SearchService;
import main.utils.DatabaseUtils;

public class SearchController
{

    private static volatile SearchController                 obj           = null;

    private static final Map<ObjectType, AbstractTableModel> objectMap     = ApplicationCfg.getInstance().getObjectMap();

    private static final ISearchService                      searchService = SearchService.getInstance();

    private SearchController()
    {

    }

    public static SearchController getInstance()
    {
        if (obj == null)
        {
            synchronized (LoginService.class)
            {
                if (obj == null)
                {
                    obj = new SearchController();
                }
            }
        }
        return obj;
    }

    public static class RenderSearchUI implements ItemListener
    {
        private JPanel             panel;

        private JComboBox<String>  comboBox;

        private AbstractTableModel tableModel;

        private List<JTextField>   columnValues;

        public RenderSearchUI(JPanel panel, JComboBox<String> comboBox, List<JTextField> columnValues)
        {
            this.panel = panel;
            this.comboBox = comboBox;
            this.columnValues = columnValues;
        }

        @Override
        public void itemStateChanged(ItemEvent e)
        {
            if (e.getSource() == comboBox)
            {
                System.out.println(comboBox.getSelectedItem());
                tableModel = objectMap.get(ObjectType.fromValue(String.valueOf(comboBox.getSelectedItem())));
                panel.removeAll();
                if (columnValues != null && columnValues.size() != 0)
                {
                    columnValues.removeAll(columnValues);
                }
                for (int i = 0; i < tableModel.getColumnCount() - 2; i++)
                {
                    JPanel itemPanel = new JPanel();

                    JLabel label = new JLabel(tableModel.getColumnName(i));
                    itemPanel.add(label);

                    JTextField textField = new JTextField(30);
                    itemPanel.add(textField);
                    columnValues.add(textField);

                    panel.add(itemPanel);
                    panel.revalidate();
                    panel.repaint();

                }
            }
        }

    }

    public static class GetSearchContent implements ActionListener
    {

        private Connection         con;

        private String             tableName;

        private List<JTextField>   columnValues;

        private AbstractTableModel tableModel;

        public GetSearchContent(String tableName, List<JTextField> columnValues)
        {
            this.tableName = tableName;
            this.columnValues = columnValues;
        }

        @Override
        public void actionPerformed(ActionEvent e)
        {
            try
            {
                con = DatabaseUtils.getConnection();
                JTextField idColumn = columnValues.get(0);
                switch (tableName)
                {
                case "book":
                    tableModel = searchService.findBookById(con, Integer.parseInt(idColumn.getText()));
                    break;

                default:
                    break;
                }
            }
            catch (SQLException e1)
            {
                e1.printStackTrace();
            }

        }

        public AbstractTableModel getTableModel()
        {
            return tableModel;
        }

        public void setTableModel(AbstractTableModel tableModel)
        {
            this.tableModel = tableModel;
        }

        public String getTableName()
        {
            return tableName;
        }

        public void setTableName(String tableName)
        {
            this.tableName = tableName;
        }

    }

}
