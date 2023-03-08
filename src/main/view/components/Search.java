package main.view.components;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Search extends JPanel
{
    private static final long        serialVersionUID = 1L;

    private JComboBox<String>        searchObjects;

    private final GridBagLayout      gridBag          = new GridBagLayout();

    private final GridBagConstraints gbc              = new GridBagConstraints();

    public Search(String[] columnNames)
    {
        // Define GridBagLayout
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

//        gbc.insets = new Insets(5, 5, 5, 5);
//        gbc.fill = GridBagConstraints.BOTH;
//        gbc.weightx = 1.0;

        // Selecting table section
        add(new JLabel("Object name: "));

        searchObjects = new JComboBox<>(columnNames);
        searchObjects.setSize(70, 20);
//        gbc.gridwidth = GridBagConstraints.REMAINDER;
        add(searchObjects);

//        gbc.gridwidth = GridBagConstraints.REMAINDER;
        JPanel dynamicPanel = new JPanel(gridBag);
        BoxLayout boxlayout = new BoxLayout(dynamicPanel, BoxLayout.Y_AXIS);
        dynamicPanel.setLayout(boxlayout);
//        gbc.gridwidth = GridBagConstraints.REMAINDER;
        this.add(dynamicPanel);
//        SearchController.RenderSearchUI sc = new SearchController.RenderSearchUI(dynamicPanel, searchObjects);
//        searchObjects.addItemListener(sc);

//        gbc.gridwidth = GridBagConstraints.REMAINDER;
        add(new JButton("Submit"));

    }
}
