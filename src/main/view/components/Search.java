package main.view.components;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Search extends JPanel
{
    private static final long serialVersionUID = 1L;

    public Search(String[] objects)
    {
        // Define GridBagLayout
        GridBagLayout gridBag = new GridBagLayout();
        setLayout(gridBag);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.BOTH;
        gbc.weightx = 1.0;

        // Selecting table section
        add(new JLabel("Object name: "), gbc);

        JComboBox<String> searchObjects = new JComboBox<>(objects);
        searchObjects.setSize(70, 20);
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        add(searchObjects, gbc);

        // dynamic content
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        makeInputField("btn1", 30, gridBag, gbc);

        gbc.gridwidth = GridBagConstraints.REMAINDER;
        add(new JButton("Submit"), gbc);

    }

    private void makeInputField(String name, int size, GridBagLayout layout, GridBagConstraints cons)
    {
        JLabel label = new JLabel(name);
        JTextField input = new JTextField(size);

        layout.setConstraints(label, cons);
        layout.setConstraints(input, cons);

        add(label);
        add(input);
    }
}
