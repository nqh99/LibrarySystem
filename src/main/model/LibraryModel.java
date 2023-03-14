package main.model;

import java.sql.Date;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import main.domain.Library;

public class LibraryModel extends AbstractTableModel
{
    private static final long serialVersionUID = 1L;

    private List<Library>     libraryList;

    private final String[]    columnNames      = new String[] { "Id", "Name", "Location", "Create_Time", "Update_Time" };

    @SuppressWarnings("rawtypes")
    private final Class[]     columnClass      = new Class[] { Integer.class, String.class, String.class, Date.class, Date.class };

    public LibraryModel(List<Library> libraryList)
    {
        this.libraryList = libraryList;
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
        return libraryList.size();
    }

    @Override
    public Object getValueAt(int rowIndex, int colIndex)
    {
        Library row = (Library) libraryList.get(rowIndex);
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
            obj = row.getLocation();
            break;

        case 3:
            obj = (row.getAudit()).getCreateTime();
            break;

        case 4:
            obj = (row.getAudit()).getUpdateTime();
            break;

        default:
            obj = null;
            break;
        }

        return obj;
    }

    public List<Library> getLibraryList()
    {
        return libraryList;
    }

    public boolean setLibraryList(List<Library> libraryList)
    {
        if (libraryList == null || libraryList.size() == 0)
        {
            return false;
        }

        this.libraryList = libraryList;

        return true;
    }

}
