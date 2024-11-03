
import java.awt.FlowLayout;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import java.awt.Font;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JTextField;

public class CheckBoxFrame extends JFrame {

    private final JTextField textField;
    private final JCheckBox boldJCheckBox;
    private final JCheckBox italiJCheckBox;

    public CheckBoxFrame() {
        super("JChackbox testing");
        setLayout((new FlowLayout()));
        textField = new JTextField("Watch the font style change", 20);
        textField.setFont(new Font("Serif", Font.PLAIN, 14));
        add(textField);
        boldJCheckBox = new JCheckBox("Bold");
        italiJCheckBox = new JCheckBox("Italic");
        add(boldJCheckBox);
        add(italiJCheckBox);
        CheckBoxHandler handler = new CheckBoxHandler();
        boldJCheckBox.addItemListener(handler);
        ;
        italiJCheckBox.addItemListener(handler);
    }

    private class CheckBoxHandler implements ItemListener {

        public void itemStateChanged(ItemEvent event) {
            Font font = null;
            if (boldJCheckBox.isSelected() && italiJCheckBox.isSelected()) {
                font = new Font("Serif", Font.BOLD + Font.ITALIC, 14);
            } else if (boldJCheckBox.isSelected()) {
                font = new Font("Serif", Font.BOLD, 14);
            } else if (italiJCheckBox.isSelected()) {
                font = new Font("Serif", Font.ITALIC, 14);
            } else {
                font = new Font("Serif", Font.PLAIN, 14);
            }
            textField.setFont(font);
        }
    }
}
