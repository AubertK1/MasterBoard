import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PlayerCard extends JPanel {
    GenStats genStats = new GenStats();
    static boolean buttonCLicked = false;

    public PlayerCard(){
        super(new GridBagLayout());

        layoutSetup();
    }
    private void layoutSetup(){
        //setting up the panels (beside the sidebar and toolbar)


        //Top Bar
        JPanel topBar = new JPanel(new GridBagLayout());
        topBar.setPreferredSize(new Dimension(590/5,50/5));
        topBar.setBorder(BorderFactory.createEtchedBorder());
        JLabel label2 =  new JLabel("Panel 2");
        label2.setHorizontalAlignment(SwingConstants.CENTER);
        topBar.add(label2,new GridBagConstraints(0, 0, 1, 1, 0, 0.6,
                GridBagConstraints.CENTER, GridBagConstraints.CENTER, new Insets(0, 0,0, 0),
                0, 0));


        //General Stats
        //creating the panel
        JPanel generalStats = new JPanel(new GridBagLayout());
        generalStats.setPreferredSize(new Dimension(590/5, 305/5));
        //setting panel border
        generalStats.setBorder(BorderFactory.createEtchedBorder());
        //creating label
        JLabel gLabel = new JLabel("General Stats");
        gLabel.setPreferredSize(new Dimension((int)(590.0/5), (int)((305.0/5)*(2.0/10))));
        //creating text area
        JTextArea gTextArea = new JTextArea();
        gTextArea.setPreferredSize(new Dimension((int)(590/5*(2.0/3)), (int)((305.0/5)*(8.0/10))));
        //creating "Upload Image" feature as a button
        JButton gUploadBox = new JButton("Upload Image");
        gUploadBox.setPreferredSize(new Dimension((int)(590/5*(1.0/3)), (int)((305.0/5)*(8.0/10))));

        gUploadBox.setOpaque(false);
        gUploadBox.setContentAreaFilled(false);
        gUploadBox.setBorderPainted(true);
//        System.out.println(gUploadBox.getPreferredSize());
        gUploadBox.setPreferredSize(new Dimension((int)((gUploadBox.getPreferredSize().width*5)*(8.5/11)), gUploadBox.getPreferredSize().height*5));

        gUploadBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!buttonCLicked) {
                    addPic(gUploadBox, generalStats);
                }

            }
        });

        //adding label to panel
        generalStats.add(gLabel, new GridBagConstraints(0, 0, 2, 1, 1.0, 0,
                GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL, new Insets(20, 20, 10, 20),
                0, 0));
        //adding text area to panel
        generalStats.add(gTextArea, new GridBagConstraints(0, 1, 1, 1, .75, .8,
                GridBagConstraints.WEST, GridBagConstraints.BOTH, new Insets(10, 20, 20, 10),
                0, 0));
        gTextArea.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createEtchedBorder(), new EmptyBorder(20, 20, 20, 20)));
        //adding Upload Image button to panel
        generalStats.add(gUploadBox, new GridBagConstraints(1, 1, 1, 1, .25, 0.8,
                GridBagConstraints.EAST, GridBagConstraints.BOTH, new Insets(10, 5, 20, 20),
                0, 0));


        //Reminders
        //creating the panel
        JPanel reminders = new JPanel(new BorderLayout());
        reminders.setPreferredSize(new Dimension(590/5, 305/5));
        //creating the label
        JLabel rLabel = new JLabel("Reminders");
        rLabel.setPreferredSize(new Dimension((int)(590.0/5), (int)((305.0/5)*(5.0/10))));
        //creating the text box
        JTextArea rTextArea = new JTextArea();
        rTextArea.setPreferredSize(new Dimension((int)(590.0/5), (int)((305.0/5)*(6.0/10))));
        //setting the panel's layout to Border Layout so it is easier to fill the text box inside of it
        reminders.setLayout(new BorderLayout());
        //the BorderFactory.createCompoundBorder function allows me to put an outside border (border line) and inside border (insets)
        reminders.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createEtchedBorder(), new EmptyBorder(20, 20, 20, 20)));
        //adding the label to the panel
        reminders.add(rLabel, BorderLayout.NORTH);
        //adding the text box to the panel
        reminders.add(rTextArea, BorderLayout.CENTER);
        //setting the label's inside border (insets)
        rLabel.setBorder(new EmptyBorder(0, 0, 20, 0));
        //setting an outside border (an outline) and inside border (for the cursor position) to the text box
        rTextArea.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createEtchedBorder(), new EmptyBorder(20, 20, 20, 20)));


        //MasterBoard
        JPanel masterBoard = new JPanel(new GridBagLayout());
        masterBoard.setPreferredSize(new Dimension(640/5, 660/5));
        masterBoard.setBorder(BorderFactory.createEtchedBorder());
        JLabel label5 =  new JLabel("Panel 5");
        label5.setHorizontalAlignment(SwingConstants.CENTER);
        masterBoard.add(label5,new GridBagConstraints(0, 0, 1, 1, 0, 0.6,
                GridBagConstraints.CENTER, GridBagConstraints.CENTER, new Insets(0, 0,0, 0),
                0, 0));


        //adding each panel to panelx
        this.add(topBar,  new GridBagConstraints(1, 0, 1, 1, 1.0, 0,
                GridBagConstraints.FIRST_LINE_START, GridBagConstraints.HORIZONTAL, new Insets(2, 2, 5, 2),
                0, 40));
        this.add(generalStats,  new GridBagConstraints(1, 1, 1, 1, 1.0, .5,
                GridBagConstraints.WEST, GridBagConstraints.BOTH, new Insets(2, 2, 10, 2),
                0, 0));
        this.add(reminders,  new GridBagConstraints(1, 2, 1, 1, 1.0, .5,
                GridBagConstraints.WEST, GridBagConstraints.BOTH, new Insets(10, 2, 20, 2),
                0, 0));
        this.add(masterBoard,  new GridBagConstraints(2, 0, 1, 3, 1.0, 0.5,
                GridBagConstraints.WEST, GridBagConstraints.BOTH, new Insets(20, 10, 20, 10),
                350, 0));


    }
    public void addPic(JButton gUploadBox, JPanel generalStats) {
        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
            JFileChooser chooser = new JFileChooser();
            FileNameExtensionFilter filter = new FileNameExtensionFilter(
                    "JPG, PNG & GIF Images", "jpg", "gif", "png");
            chooser.setFileFilter(filter);
            int returnVal = chooser.showOpenDialog(generalStats);
            if(returnVal == JFileChooser.APPROVE_OPTION) {
                Image img1 = ImageIO.read(chooser.getSelectedFile());
                gUploadBox.setText("");
                gUploadBox.setIcon(new ScaledImageIcon(img1, gUploadBox.getHeight(), gUploadBox.getWidth()));
                generalStats.add(gUploadBox, new GridBagConstraints(1, 1, 1, 1, 0.25, 0,
                        GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(10, 5, 20, 20),
                        0, 0));

                gUploadBox.setMargin(new Insets(0, 0, 0, 0));
                gUploadBox.setBorder(BorderFactory.createEtchedBorder());
//                buttonCLicked = true;
            }
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }
}
