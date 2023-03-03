package main.utils;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class LayoutUtils
{
    public static JPanel createInputField(String labelString)
    {
        JPanel frame = new JPanel();

        JLabel label = new JLabel();
        label.setText(labelString);

        JTextField input = new JTextField(15);

        frame.add(label);
        frame.add(input);
        return frame;
    }

}
