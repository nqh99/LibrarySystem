package test;

import javax.swing.JFrame;

import main.view.components.Search;

public class demo
{

    public static void main(String[] args)
    {
//        JFrame.setDefaultLookAndFeelDecorated(true);
        JFrame frame = new JFrame("BoxLayout Example X_AXIS");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        frame.setSize(600, 600);

        String country[] = { "India", "Aus", "U.S.A", "England", "Newzealand" };
        Search search = new Search(country);

        frame.add(search);

        frame.pack();
        frame.setVisible(true);
    }

}
