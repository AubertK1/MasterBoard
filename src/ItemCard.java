import javax.swing.*;
import java.awt.*;

public class ItemCard extends JPanel {
    AssociatedElements assoElements = new AssociatedElements();

    public ItemCard(){
        super(new GridBagLayout());

        layoutSetup();
    }
    private void layoutSetup(){
        JPanel panel2 = new JPanel(new GridBagLayout());
        panel2.setBorder(BorderFactory.createEtchedBorder());
        JLabel label2 =  new JLabel("Panel 2");
        label2.setHorizontalAlignment(SwingConstants.CENTER);
        panel2.add(label2,new GridBagConstraints(0, 0, 1, 1, 0, 0.6,
                GridBagConstraints.CENTER, GridBagConstraints.CENTER, new Insets(0, 0,0, 0),
                0, 0));


        JPanel panel3 = new JPanel(new GridBagLayout());
        panel3.setBorder(BorderFactory.createEtchedBorder());
        JLabel label3 =  new JLabel("Panel 3");
        label3.setHorizontalAlignment(SwingConstants.CENTER);
        panel3.add(label3,new GridBagConstraints(0, 0, 1, 1, 0, 0.6,
                GridBagConstraints.CENTER, GridBagConstraints.CENTER, new Insets(0, 0,0, 0),
                0, 0));

        JPanel panel4 = new JPanel(new GridBagLayout());
        panel4.setBorder(BorderFactory.createEtchedBorder());
        JLabel label4 =  new JLabel("Panel 4");
        label4.setHorizontalAlignment(SwingConstants.CENTER);
        panel4.add(label4,new GridBagConstraints(0, 0, 1, 1, 0, 0.6,
                GridBagConstraints.CENTER, GridBagConstraints.CENTER, new Insets(0, 0,0, 0),
                0, 0));

        JPanel panel5 = new JPanel(new GridBagLayout());
        panel5.setBorder(BorderFactory.createEtchedBorder());
        JLabel label5 =  new JLabel("Panel 5");
        label5.setHorizontalAlignment(SwingConstants.CENTER);
        panel5.add(label5,new GridBagConstraints(0, 0, 1, 1, 0, 0.6,
                GridBagConstraints.CENTER, GridBagConstraints.CENTER, new Insets(0, 0,0, 0),
                0, 0));

        this.add(panel2,  new GridBagConstraints(1, 0, 1, 1, 1.0, 0,
                GridBagConstraints.FIRST_LINE_START, GridBagConstraints.HORIZONTAL, new Insets(2, 2, 5, 2),
                0, 40));
        this.add(panel3,  new GridBagConstraints(1, 1, 1, 1, 1.0, .5,
                GridBagConstraints.WEST, GridBagConstraints.BOTH, new Insets(2, 2, 10, 2),
                0, 0));
        this.add(panel4,  new GridBagConstraints(1, 2, 1, 1, 1.0, .5,
                GridBagConstraints.WEST, GridBagConstraints.BOTH, new Insets(10, 2, 20, 2),
                0, 0));
        this.add(panel5,  new GridBagConstraints(2, 0, 1, 3, 1.0, 0.5,
                GridBagConstraints.WEST, GridBagConstraints.BOTH, new Insets(20, 10, 20, 10),
                350, 0));
    }
}
