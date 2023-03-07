package main.model;

import java.sql.Date;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import main.domain.Book;
import main.domain.RealObject;

public class BookModel extends AbstractTableModel
{
    private static final long serialVersionUID = 1L;

    private List<RealObject>  bookList;

    private final String[]    columnNames      = new String[] { "Id", "Name", "Author", "Create Time", "Update Time" };

    @SuppressWarnings("rawtypes")
    private final Class[]     columnClass      = new Class[] { Integer.class, String.class, String.class, Date.class, Date.class };

    public BookModel()
    {

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
        return bookList.size();
    }

    @Override
    public Object getValueAt(int rowIndex, int colIndex)
    {
        Book row = (Book) bookList.get(rowIndex);
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
            obj = row.getAuthor();
            break;

        case 3:
            obj = row.getCreateTime();
            break;

        case 4:
            obj = row.getUpdateTime();
            break;

        default:
            obj = null;
            break;
        }

        return obj;
    }

    public void setBookList(List<RealObject> bookList)
    {
        if (bookList.size() != 0 && bookList.get(0).getClass() == Book.class)
        {
            this.bookList = bookList;
        }
    }

    public List<RealObject> getBookList()
    {
        return bookList;
    }

}
