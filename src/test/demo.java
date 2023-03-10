package test;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import main.model.BookModel;
import main.services.impl.BookService;
import main.utils.DatabaseUtils;

public class demo extends JFrame
{
    private static final long serialVersionUID = 1L;

    public demo() throws SQLException
    {
        BookService bs = BookService.getInstance();
        Connection c = DatabaseUtils.getConnection();

        BookModel model = bs.findBookById(c, 1);

        JTable table = new JTable(model);

        this.add(new JScrollPane(table));

        this.setTitle("Editable Table Example");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        this.setVisible(true);
    }

    public static void main(String[] args)
    {
        List<String> strlist = new ArrayList<String>();
        strlist.add("sdfs1");
        strlist.add("sdfs2");
        String[] strarray = strlist.toArray(new String[0]);
        for (int i = 0; i < strarray.length; i++)
        {
            System.out.println(strarray[i]);
        }
    }

}
