import javax.swing.*;

public class Description {
    private JTextField textField = new JTextField();
    private JLabel label = new JLabel();
    private JPanel panel = new JPanel();

    public Description(){


        label.setText("Description");
        panel.add(label);
        panel.add(textField);
    }
}
