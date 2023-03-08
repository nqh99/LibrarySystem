package main.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Map;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.table.AbstractTableModel;

import main.configures.ApplicationCfg;
import main.domain.ObjectType;

public class SearchController implements ActionListener
{
    private final Map<ObjectType, AbstractTableModel> objectMap = ApplicationCfg.getInstance().getObjectMap();

    public class RenderSearchUI implements ItemListener
    {
        private JPanel            panel;

        private JComboBox<String> comboBox;

        public RenderSearchUI(JPanel panel, JComboBox<String> comboBox)
        {
            this.panel = panel;
            this.comboBox = comboBox;
        }

        @Override
        public void itemStateChanged(ItemEvent e)
        {
            if (e.getSource() == comboBox)
            {
                AbstractTableModel model = objectMap.get(ObjectType.fromValue(String.valueOf(comboBox.getSelectedItem())));
                panel.removeAll();
                for (int i = 0; i < model.getColumnCount(); i++)
                {
                    JLabel label = new JLabel(model.getColumnName(i));
                    JTextField column = new JTextField(20);
                    panel.add(label);
                    panel.add(column);
                    panel.revalidate();
                    panel.repaint();

                }
            }
        }

    }

    @Override
    public void actionPerformed(ActionEvent arg0)
    {
        // TODO Auto-generated method stub

    }
}
