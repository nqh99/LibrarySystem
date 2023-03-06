package main.view.components;

import java.awt.FlowLayout;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JPanel;

public class Navigation extends JPanel
{
    private static final long serialVersionUID = 1L;

    public Navigation(List<JButton> list, Integer hgap)
    {
        // Define layout
        FlowLayout layout = new FlowLayout();
        layout.setAlignment(FlowLayout.LEFT);
        layout.setHgap(hgap);

        setLayout(layout);

        for (JButton jBtn : list)
        {
            add(jBtn);
        }
    }

}
