
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TextAreaFrame extends JFrame {

    private final JTextArea textArea1;
    private final JTextArea textArea2;
    private final JButton copyButton;

    public TextAreaFrame() {
        super("TextArea Demo");
        Box box = Box.createHorizontalBox();

        String demo = "This is a demo1 string to\n" + "illustrate copying text\nfrom one textarea to \n" + "another textarea using an \nexternal event\n";
        textArea1 = new JTextArea(demo, 10, 15);
        box.add(new JScrollPane(textArea1));

        copyButton = new JButton("Copy >>>");
        box.add(copyButton);

        textArea2 = new JTextArea(10, 15);
        textArea2.setEditable(false);
        box.add(new JScrollPane(textArea2));

        copyButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                String selectedText = textArea1.getSelectedText();
                if (selectedText != null) {
                    textArea2.setText(selectedText);
                } else {
                    textArea2.setText(textArea1.getText());
                }
            }
        });
        add(box);
    }
}
