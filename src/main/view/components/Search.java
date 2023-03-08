package main.view.components;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.Map;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.table.AbstractTableModel;

import main.configures.ApplicationCfg;
import main.controller.SearchController;
import main.domain.ObjectType;

public class Search extends JPanel
{
    private static final long                         serialVersionUID = 1L;

    private final Map<ObjectType, AbstractTableModel> objectMap        = ApplicationCfg.getInstance().getObjectMap();

    private JComboBox<String>                         searchObjects;

    private ObjectType                                objectType       = null;

    private final GridBagLayout                       gridBag          = new GridBagLayout();

    private final GridBagConstraints                  gbc              = new GridBagConstraints();

    public Search(String[] columnNames)
    {
        // Define GridBagLayout
        setLayout(gridBag);

        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.BOTH;
        gbc.weightx = 1.0;

        // Selecting table section
        add(new JLabel("Object name: "), gbc);

        searchObjects = new JComboBox<>(columnNames);
        searchObjects.setSize(70, 20);
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        add(searchObjects, gbc);

        gbc.gridwidth = GridBagConstraints.REMAINDER;
        JPanel dynamicPanel = new JPanel(gridBag);
        BoxLayout boxlayout = new BoxLayout(dynamicPanel, BoxLayout.Y_AXIS);
        dynamicPanel.setLayout(boxlayout);
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        this.add(dynamicPanel);
        SearchController.RenderSearchUI sc = new SearchController.RenderSearchUI(dynamicPanel, searchObjects);
        searchObjects.addItemListener(sc);

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
