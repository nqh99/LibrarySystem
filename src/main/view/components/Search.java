package main.view.components;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

import main.controller.SearchController;

public class Search extends JPanel {
	private static final long serialVersionUID = 1L;

	public Search(String[] columnNames) {
		this.setLayout(new BorderLayout());

		// Selecting table section
		JPanel selectionPanel = new JPanel(new FlowLayout());
		selectionPanel.add(new JLabel("Object name: "));

		JComboBox<String> tablesComboBox = new JComboBox<>(columnNames);
		tablesComboBox.setSize(70, 25);
		tablesComboBox.setSelectedIndex(-1);

		selectionPanel.add(tablesComboBox);

		this.add(selectionPanel, BorderLayout.NORTH);

		JPanel contentPanel = new JPanel();
		contentPanel.setLayout(new BoxLayout(contentPanel, BoxLayout.Y_AXIS));

		this.add(contentPanel, BorderLayout.CENTER);
		SearchController.RenderSearchUI sc = new SearchController.RenderSearchUI(contentPanel, tablesComboBox);
		tablesComboBox.addItemListener(sc);

		JPanel southPanel = new JPanel();
		JButton searchBtn = new JButton("Search");
		searchBtn.setSize(100, 50);
		southPanel.add(searchBtn);

		this.add(southPanel, BorderLayout.SOUTH);
	}
}
