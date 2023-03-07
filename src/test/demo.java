package test;

import java.sql.Connection;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingUtilities;

import main.model.BookModel;
import main.services.BookService;
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
        SwingUtilities.invokeLater(new Runnable()
        {
            @Override
            public void run()
            {
                try
                {
                    new demo();
                }
                catch (SQLException e)
                {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        });

        System.out.println();
    }

}
