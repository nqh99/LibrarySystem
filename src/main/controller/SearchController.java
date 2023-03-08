package main.controller;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Map;

import javax.swing.BoxLayout;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.table.AbstractTableModel;

import main.configures.ApplicationCfg;
import main.domain.ObjectType;
import main.services.LoginService;

public class SearchController {

	private static volatile SearchController obj = null;

	private static final Map<ObjectType, AbstractTableModel> objectMap = ApplicationCfg.getInstance().getObjectMap();

	private SearchController() {

	}

	public static SearchController getInstance() {
		if (obj == null) {
			synchronized (LoginService.class) {
				if (obj == null) {
					obj = new SearchController();
				}
			}
		}
		return obj;
	}

	public static class RenderSearchUI implements ItemListener {
		private JPanel panel;

		private JComboBox<String> comboBox;

		public RenderSearchUI(JPanel panel, JComboBox<String> comboBox) {
			this.panel = panel;
			this.comboBox = comboBox;
		}

		@Override
		public void itemStateChanged(ItemEvent e) {
			if (e.getSource() == comboBox) {
				AbstractTableModel model = objectMap
						.get(ObjectType.fromValue(String.valueOf(comboBox.getSelectedItem())));
				panel.removeAll();
				for (int i = 0; i < model.getColumnCount(); i++) {
					JPanel itemPanel = new JPanel();

					JLabel label = new JLabel(model.getColumnName(i));
					itemPanel.add(label);

					JTextField textField = new JTextField(30);
					itemPanel.add(textField);

					panel.add(itemPanel);
					panel.revalidate();
					panel.repaint();

				}
			}
		}

	}

}
