package main.view.components;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;

public class CustomTable extends JPanel
{

    private static final long serialVersionUID = 1L;

    public CustomTable(AbstractTableModel model)
    {
        JTable table = new JTable(model);
        this.add(new JScrollPane(table));
    }

}
