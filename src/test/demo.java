package test;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingUtilities;

import main.configures.ApplicationCfg;
import main.domain.Book;
import main.domain.ObjectType;
import main.domain.RealObject;
import main.model.BookModel;

public class demo extends JFrame
{
    private static final long serialVersionUID = 1L;

    public demo()
    {
        Book b1 = new Book();
        b1.setName("abc");
//        b1.setCreateTime(2323223232L);
//        b1.setId(1);
        b1.setUpdateTime(2323223232L);
        System.out.println(b1.toString());
        Book b2 = new Book();
        b2.setName("abcd");
        Book b3 = new Book();
        b3.setName("abcde");

        List<RealObject> list = new ArrayList<>();
        list.add(b1);
        list.add(b2);
        list.add(b3);

        ApplicationCfg cfg = ApplicationCfg.getInstance();

        BookModel model = (BookModel) cfg.getObjectMap().get(ObjectType.BOOK);
        model.setBookList(list);

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
                new demo();
            }
        });
        
        System.out.println();
    }

}
