import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;


public class PlayerCard extends JPanel {
    GenStats genStats = new GenStats();
    static boolean buttonCLicked = false;
    static BufferedImage myPic;
    static File imgFile;
    JButton reSizeImg = new JButton();
    JButton reSelect = new JButton();
    public PlayerCard(){
        super(new GridBagLayout());

        layoutSetup();
    }
    private void layoutSetup(){
        //setting up the panels (beside the sidebar and toolbar)


        //region Top Bar
        JPanel topBar = new JPanel(new GridBagLayout());
        topBar.setPreferredSize(new Dimension(590/5,50/5));
        topBar.setBorder(BorderFactory.createEtchedBorder());
        JLabel label2 =  new JLabel("Player Name");
        label2.setPreferredSize(new Dimension(393/5,50/5));
        String[] players = {"Player 1", "Player 2", "Player 3"};
        JComboBox dropList = new JComboBox(players);
        DefaultListCellRenderer listCellRenderer = new DefaultListCellRenderer();
        listCellRenderer.setHorizontalAlignment(DefaultListCellRenderer.CENTER);
        dropList.setRenderer(listCellRenderer);
        dropList.setPreferredSize(new Dimension(196/5,50/5));
        dropList.setSelectedIndex(2);
        topBar.add(label2, new GridBagConstraints(0, 0, 1, 1, 0.67, 0.2,
                GridBagConstraints.LINE_START, GridBagConstraints.NONE, new Insets(0, 20,0, 0),
                0, 0));
        topBar.add(dropList, new GridBagConstraints(1, 0, 1, 1, 0.33, 0.2,
                GridBagConstraints.LINE_END, GridBagConstraints.BOTH, new Insets(5, 0,5, 10),
                0, 0));


        //endregion


        //region General Stats
        //creating the panel
        JPanel generalStats = new JPanel(new GridBagLayout());
        //setting panel preferred size so the inner panels don't mess up
        generalStats.setPreferredSize(new Dimension(590/5, 305/5));
        //setting panel border
        generalStats.setBorder(BorderFactory.createEtchedBorder());
        //creating label
        JLabel gLabel = new JLabel("General Stats");
        //setting label preferred size
        gLabel.setPreferredSize(new Dimension((int)(590.0/5), (int)((305.0/5)*(2.0/10))));
        //creating text area
        JTextArea gTextArea = new JTextArea();
        //setting text area preferred size
        gTextArea.setPreferredSize(new Dimension((int)(590/5*(2.0/3)), (int)((305.0/5)*(8.0/10))));
        //creating "Upload Image" feature as a button with a panel to add other buttons on top
        JButton gUploadBox = new JButton("Upload Image");
        JPanel buttonPanel = new JPanel(new GridLayout());
        //initializing button and panel
        gUploadBox.setLayout(new GridBagLayout());
        buttonPanel.setPreferredSize(new Dimension((int)(590/5*(1.0/3)), (int)((305.0/5)*(8.0/10))));
        buttonPanel.setPreferredSize(new Dimension((int)((buttonPanel.getPreferredSize().width*5)*(8.5/11)),
                buttonPanel.getPreferredSize().height*5));
        gUploadBox.setPreferredSize(new Dimension((int)(590/5*(1.0/3)), (int)((305.0/5)*(8.0/10))));
        //making button blank
        gUploadBox.setOpaque(false);
        gUploadBox.setContentAreaFilled(false);
        gUploadBox.setBorderPainted(true);

        //"reselect button" to do obvious job
        reSelect.setOpaque(true);
        reSelect.setContentAreaFilled(false);
        reSelect.setBorderPainted(true);
        JPanel backPanel = new JPanel(); //giving the button transparency
        backPanel.setBounds(reSelect.getBounds()); // Same to buttons bounds.
        backPanel.setBackground(new Color(0, 0, 0, 50)); // Background with transparent
        reSelect.add(backPanel);

        //"resize image" button to readjust the image size when the window size changes
        reSizeImg.setOpaque(true);
        reSizeImg.setContentAreaFilled(false);
        reSizeImg.setBorderPainted(true);
        JPanel backPanel2 = new JPanel(); //giving the button transparency
        backPanel2.setBounds(reSizeImg.getBounds()); // Same to buttons bounds.
        backPanel2.setBackground(new Color(0, 0, 0, 50)); // Background with transparent
        reSizeImg.add(backPanel2);

        //setting more preferred sizes
        gUploadBox.setPreferredSize(new Dimension((int)((gUploadBox.getPreferredSize().width*5)*(8.5/11)),
                gUploadBox.getPreferredSize().height*5));
//        reSizeImg.setPreferredSize(new Dimension((int)((gUploadBox.getPreferredSize().height/5)),
//                gUploadBox.getPreferredSize().height/5));
//        reSelect.setPreferredSize(new Dimension((int)((gUploadBox.getPreferredSize().height/5)),
//                gUploadBox.getPreferredSize().height/5));

        //purely aesthetic choices
        gUploadBox.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseEntered(MouseEvent e){
                reSelect.setBorder(BorderFactory.createLineBorder(new Color(51, 51, 51),2, true));
                backPanel.setVisible(true);
                reSizeImg.setBorder(BorderFactory.createLineBorder(new Color(51, 51, 51),2, true));
                backPanel2.setVisible(true);
                //When enter we can not know our mouse successfully entered to the button. So I'd like to add Border
            }
            @Override
            public void mouseExited(MouseEvent e){
                reSelect.setBorder(null);
                backPanel.setVisible(false);
                reSizeImg.setBorder(null);
                backPanel2.setVisible(false);
                //When mouse exits no border.
            }
        });
        reSelect.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseEntered(MouseEvent a){
                reSelect.setBorder(BorderFactory.createLineBorder(new Color(51, 51, 51),2, true));
                backPanel.setVisible(true);
                backPanel.setBackground(new Color(0, 0, 0, 90));
                reSizeImg.setBorder(BorderFactory.createLineBorder(new Color(51, 51, 51),2, true));
                backPanel2.setVisible(true);
                //When enter we can not know our mouse successfully entered to the button. So I'd like to add Border
            }
            @Override
            public void mouseExited(MouseEvent a){
                reSelect.setBorder(null);
                backPanel.setVisible(false);
                backPanel.setBackground(new Color(0, 0, 0, 50));
                reSizeImg.setBorder(null);
                backPanel2.setVisible(false);
                //When mouse exits no border.
            }
        });
        reSizeImg.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseEntered(MouseEvent b){
                reSelect.setBorder(BorderFactory.createLineBorder(new Color(51, 51, 51),2, true));
                backPanel.setVisible(true);
                reSizeImg.setBorder(BorderFactory.createLineBorder(new Color(51, 51, 51),2, true));
                backPanel2.setBackground(new Color(0, 0, 0, 90));
                backPanel2.setVisible(true);
                //When enter we can not know our mouse successfully entered to the button. So I'd like to add Border
            }
            @Override
            public void mouseExited(MouseEvent b){
                reSelect.setBorder(null);
                backPanel.setVisible(false);
                reSizeImg.setBorder(null);
                backPanel2.setBackground(new Color(0, 0, 0, 50));
                backPanel2.setVisible(false);
                //When mouse exits no border.
            }
        });
        //makes buttons work
        gUploadBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!buttonCLicked) {
                    addPic(gUploadBox, buttonPanel);
                }
                else{
                    new BigWindow(myPic);
                }

            }
        });
        reSelect.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(buttonCLicked)
                addPic(gUploadBox, buttonPanel);
            }
        });
        reSizeImg.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(buttonCLicked)
                reAddPic(gUploadBox, buttonPanel, imgFile);
            }
        });
        //adds button to panels
        buttonPanel.add(gUploadBox, new GridLayout());

        //adding label to panel
        generalStats.add(gLabel, new GridBagConstraints(0, 0, 2, 1, 1.0, 0,
                GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL, new Insets(20, 20, 10, 20),
                0, 0));
        //adding text area to panel
        generalStats.add(gTextArea, new GridBagConstraints(0, 1, 1, 1, .75, .8,
                GridBagConstraints.WEST, GridBagConstraints.BOTH, new Insets(10, 20, 20, 10),
                0, 0));
        gTextArea.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createEtchedBorder(),
                new EmptyBorder(20, 20, 20, 20)));
        //adding Upload Image button to panel
        generalStats.add(buttonPanel, new GridBagConstraints(1, 1, 1, 1, .25, 0.8,
                GridBagConstraints.EAST, GridBagConstraints.BOTH, new Insets(10, 5, 20, 20),
                0, 0));
        //endregion


        //region Reminders
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
        reminders.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createEtchedBorder(),
                new EmptyBorder(20, 20, 20, 20)));
        //adding the label to the panel
        reminders.add(rLabel, BorderLayout.NORTH);
        //adding the text box to the panel
        reminders.add(rTextArea, BorderLayout.CENTER);
        //setting the label's inside border (insets)
        rLabel.setBorder(new EmptyBorder(0, 0, 20, 0));
        //setting an outside border (an outline) and inside border (for the cursor position) to the text box
        rTextArea.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createEtchedBorder(),
                new EmptyBorder(20, 20, 20, 20)));
        //endregion


        //MasterBoard
//        JPanel masterBoard = new JPanel(new GridBagLayout());
//        masterBoard.setPreferredSize(new Dimension(640/5, 660/5));
        Panel masterBoard = new Panel(null);
        masterBoard.addMouseListener(masterBoard);
        masterBoard.addKeyListener(masterBoard);
        // Transparent 16 x 16 pixel cursor image.
        BufferedImage cursorImg = new BufferedImage(16, 16, BufferedImage.TYPE_INT_ARGB);
        // Create a new blank cursor.
        Cursor blankCursor = Toolkit.getDefaultToolkit().createCustomCursor(
                cursorImg, new Point(0, 0), "blank cursor");
        // Set the blank cursor to the JFrame.
        masterBoard.setCursor(blankCursor);
        Timer timer = new Timer(1, masterBoard);
//            JLabel board = new JLabel(new ImageIcon(img));
//            panel.add(board, null);
        masterBoard.setBackground(Color.WHITE);
        masterBoard.setFocusable(true);
        masterBoard.setBorder(BorderFactory.createEtchedBorder());
        masterBoard.requestFocus();
        timer.start();


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
                imgFile = chooser.getSelectedFile();

                generalStats.remove(gUploadBox);
                gUploadBox.remove(reSizeImg);
                gUploadBox.remove(reSelect);
                gUploadBox.setText("");
                gUploadBox.setIcon(new ScaledImageIcon(img1, gUploadBox.getHeight()));


                generalStats.add(gUploadBox, new GridLayout());
                gUploadBox.add(reSizeImg, new GridBagConstraints(3, 1, 1, 1, .1, .1,
                        GridBagConstraints.FIRST_LINE_END, GridBagConstraints.NONE, new Insets(5, 0, 0, 5),
                        20, 20));
                gUploadBox.add(reSelect, new GridBagConstraints(2, 1, 1, 1, .1, .1,
                        GridBagConstraints.FIRST_LINE_START, GridBagConstraints.NONE, new Insets(5, 5, 0, 0),
                        20, 20));

                gUploadBox.setMargin(new Insets(0, 0, 0, 0));
                gUploadBox.setBorder(BorderFactory.createLineBorder(new Color(51, 51, 51), 1));
                buttonCLicked = true;
                myPic = ImageIO.read(imgFile);
            }
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }
    public void reAddPic(JButton gUploadBox, JPanel generalStats, File imgFile) {
        try {
            Image img1 = ImageIO.read(imgFile);

            generalStats.remove(gUploadBox);
            gUploadBox.remove(reSizeImg);
            gUploadBox.remove(reSelect);
            gUploadBox.setText("");
            gUploadBox.setIcon(new ScaledImageIcon(img1, gUploadBox.getHeight()));


            generalStats.add(gUploadBox, new GridLayout());
            gUploadBox.add(reSizeImg, new GridBagConstraints(3, 1, 1, 1, .1, .5,
                    GridBagConstraints.FIRST_LINE_END, GridBagConstraints.NONE, new Insets(5, 0, 0, 5),
                    20, 20));
            gUploadBox.add(reSelect, new GridBagConstraints(2, 1, 1, 1, .1, .5,
                    GridBagConstraints.FIRST_LINE_START, GridBagConstraints.NONE, new Insets(5, 5, 0, 0),
                    20, 20));

            gUploadBox.setMargin(new Insets(0, 0, 0, 0));
            gUploadBox.setBorder(BorderFactory.createLineBorder(new Color(51, 51, 51), 1));
            buttonCLicked = true;
            myPic = ImageIO.read(imgFile);
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }

}
