package main.model;

import java.sql.Date;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import main.domain.Renter;

public class RenterModel extends AbstractTableModel
{
    private static final long serialVersionUID = 1L;

    private List<Renter>      renterList;

    private final String[]    columnNames      = new String[] { "Id", "Name", "Email", "Phone_Number", "Create_Time", "Update_Time" };

    @SuppressWarnings("rawtypes")
    private final Class[]     columnClass      = new Class[] { Integer.class, String.class, String.class, String.class, Date.class, Date.class };

    public RenterModel(List<Renter> renterList)
    {
        this.renterList = renterList;
    }

    @Override
    public String getColumnName(int column)
    {
        return columnNames[column];
    }

    @Override
    public Class<?> getColumnClass(int columnIndex)
    {
        return columnClass[columnIndex];
    }

    @Override
    public int getColumnCount()
    {
        return columnNames.length;
    }

    @Override
    public int getRowCount()
    {
        return renterList.size();
    }

    @Override
    public Object getValueAt(int rowIndex, int colIndex)
    {
        Renter row = renterList.get(rowIndex);
        Object obj;
        switch (colIndex)
        {
        case 0:
            obj = (row.getAudit()).getId();
            break;

        case 1:
            obj = (row.getAudit()).getName();
            break;

        case 2:
            obj = row.getEmail();
            break;

        case 3:
            obj = row.getPhoneNumber();
            break;

        case 4:
            obj = (row.getAudit()).getCreateTime();
            break;

        case 5:
            obj = (row.getAudit()).getUpdateTime();
            break;

        default:
            obj = null;
            break;
        }

        return obj;
    }

    public List<Renter> getRenterList()
    {
        return renterList;
    }

    public boolean setRenterList(List<Renter> renterList)
    {
        if (renterList == null || renterList.size() == 0)
        {
            return false;
        }

        this.renterList = renterList;

        return true;
    }
}
