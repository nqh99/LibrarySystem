package main.model;

import java.sql.Date;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import main.domain.RealObject;
import main.domain.Renter;

public class RenterModel extends AbstractTableModel
{
    private static final long serialVersionUID = 1L;

    private List<RealObject>  renterList;

    private final String[]    columnNames      = new String[] { "Id", "Name", "Email", "Phone_Number", "Create_Time", "Update_Time" };

    @SuppressWarnings("rawtypes")
    private final Class[]     columnClass      = new Class[] { Integer.class, String.class, String.class, String.class, Date.class, Date.class };

    public RenterModel(List<RealObject> renterList)
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
        Renter row = (Renter) renterList.get(rowIndex);
        Object obj;
        switch (colIndex)
        {
        case 0:
            obj = row.getId();
            break;

        case 1:
            obj = row.getName();
            break;

        case 2:
            obj = row.getEmail();
            break;

        case 3:
            obj = row.getPhoneNumber();
            break;

        case 4:
            obj = row.getCreateTime();
            break;

        case 5:
            obj = row.getUpdateTime();
            break;

        default:
            obj = null;
            break;
        }

        return obj;
    }

    public List<RealObject> getRenterList()
    {
        return renterList;
    }

    public void setRenterList(List<RealObject> renterList)
    {
        this.renterList = renterList;
    }
}
