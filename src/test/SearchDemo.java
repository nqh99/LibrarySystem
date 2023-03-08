package test;

import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import main.services.ISearchService;
import main.services.SearchService;
import main.view.components.Search;

public class SearchDemo extends JFrame
{
    private static final long serialVersionUID = 1L;

    public SearchDemo() throws SQLException
    {
        String[] str = new String[] { "book", "library", "renter" };

        Search search = new Search(str);

        this.add(search);

        this.setTitle("Search");
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
                    new SearchDemo();
                }
                catch (SQLException e)
                {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        });

        ISearchService sear = SearchService.getInstance();
        System.out.println(sear.getClass());
    }

}
