import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class MasterFrame extends JFrame implements KeyListener {
    PanelList<MasterCard> playerCards = new PanelList<>();
    PanelList<MasterCard> npcCards = new PanelList<>();
    PanelList<MasterCard> itemCards = new PanelList<>();
    PanelList<MasterCard> locationCards = new PanelList<>();
    PanelList<MasterCard> storyCards = new PanelList<>();
    PanelList<MasterCard> currentCards;
    public MasterFrame(){
        super("Master Board");
        super.setSize(1280,720);
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        super.setExtendedState(JFrame.MAXIMIZED_BOTH);

        playerCards.add(new PlayerCard());
        npcCards.add(new PlayerCard());
        itemCards.add(new ItemCard());
        locationCards.add(new ItemCard());
        storyCards.add(new StoryCard());
        currentCards = playerCards;

        layoutSetup();
    }
    private void layoutSetup(){
        this.getContentPane().setLayout(new GridBagLayout());

        //Setup some panels with labels
        JPanel sideCard = new JPanel(new GridBagLayout());
        sideCard.setCursor(Cursor.getDefaultCursor());
        sideCard.setPreferredSize(new Dimension(50, 660));
        sideCard.setBorder(BorderFactory.createEtchedBorder());
        JLabel label1 =  new JLabel("Panel 1");
        label1.setHorizontalAlignment(SwingConstants.CENTER);
        sideCard.add(label1,new GridBagConstraints(0, 0, 1, 1, 0, 0.6,
                GridBagConstraints.CENTER, GridBagConstraints.CENTER, new Insets(0, 0,0, 0),
                0, 0));

        JPanel panelx = new PlayerCard();
        panelx.setCursor(Cursor.getDefaultCursor());

        JPanel toolBar = new JPanel(new GridBagLayout());
        toolBar.setCursor(Cursor.getDefaultCursor());
        toolBar.setPreferredSize(new Dimension(720, 60));
        toolBar.setBorder(BorderFactory.createEtchedBorder());
        JLabel label6 =  new JLabel("Tool Bar");
        label6.setHorizontalAlignment(SwingConstants.CENTER);
        JButton drawButt = new JButton("Draw");
        JButton eraseButt = new JButton("Erase");
        JButton size3 = new JButton("Size: 3");
        JButton size5 = new JButton("Size: 5");
        JButton size10 = new JButton("Size: 10");
        JButton size20 = new JButton("Size: 20");
        JButton sizeM = new JButton("Size: -2");
        JButton sizeP = new JButton("Size: +2");
        drawButt.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                //fixme put this back after show case
/*                if(Panel.eraseMode){
                    for (int i = 0; i < Panel.drawing.lines.size(); i++) {
                        if(Panel.drawing.lines.get(i).eVals.size() > 0) {
                            Panel.drawing.lines.remove(Panel.drawing.lines.get(i));
                        }
                    }
                }*/
                Panel.drawMode = true;
                Panel.eraseMode = false;
                Brush.circleColor = Color.BLACK;
            }
        });
        eraseButt.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                Panel.drawMode = true;
                Panel.eraseMode = true;
                Brush.circleColor = Color.WHITE;
            }
        });
        size3.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                Panel.diameter = 3;
                Canvas.diameter = 3;
                Drawing.diameter = 3;
                Brush.diameter = 3+3;            }
        });
        size5.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                Panel.diameter = 5;
                Canvas.diameter = 5;
                Drawing.diameter = 5;
                Brush.diameter = 5+3;
            }
        });
        size10.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                Panel.diameter = 10;
                Canvas.diameter = 10;
                Drawing.diameter = 10;
                Brush.diameter = 10;
            }
        });
        size20.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                Panel.diameter = 20;
                Canvas.diameter = 20;
                Drawing.diameter = 20;
                Brush.diameter = 20;
            }
        });
        sizeM.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                Panel.diameter = Panel.diameter - 2;
                Canvas.diameter = Canvas.diameter - 2;
                Drawing.diameter = Drawing.diameter - 2;
                if(Brush.diameter < 7)
                    Brush.diameter = Drawing.diameter + 2;
                else
                    Brush.diameter = Brush.diameter - 2;
            }
        });
        sizeP.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                Panel.diameter = Panel.diameter + 2;
                Canvas.diameter = Canvas.diameter + 2;
                Drawing.diameter = Drawing.diameter + 2;
                if(Brush.diameter < 7)
                    Brush.diameter = Drawing.diameter + 2;
                else
                    Brush.diameter = Brush.diameter + 2;
            }
        });
        toolBar.add(label6,new GridBagConstraints(0, 0, 1, 2, 0.33, 0.6,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0,0, 0),
                0, 0));
        toolBar.add(drawButt,new GridBagConstraints(1, 0, 1, 2, 0.33, 0.6,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0,0, 0),
                0, 0));
        toolBar.add(eraseButt,new GridBagConstraints(2, 0, 1, 2, 0.33, 0.6,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0,0, 0),
                0, 0));
        toolBar.add(size3,new GridBagConstraints(3, 0, 1, 1, 0.33, 0.6,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0,0, 0),
                0, 0));
        toolBar.add(size5,new GridBagConstraints(4, 0, 1, 1, 0.33, 0.6,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0,0, 0),
                0, 0));
        toolBar.add(size10,new GridBagConstraints(3, 1, 1, 1, 0.33, 0.6,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0,0, 0),
                0, 0));
        toolBar.add(size20,new GridBagConstraints(4, 1, 1, 1, 0.33, 0.6,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0,0, 0),
                0, 0));
        toolBar.add(sizeM,new GridBagConstraints(5, 0, 1, 1, 0.33, 0.6,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0,0, 0),
                0, 0));
        toolBar.add(sizeP,new GridBagConstraints(5, 1, 1, 1, 0.33, 0.6,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0,0, 0),
                0, 0));

        //Here goes the interesting code
        //side card
        this.getContentPane().add(sideCard,  new GridBagConstraints(0, 0, 1, 3, 0, 0.6,
                GridBagConstraints.WEST, GridBagConstraints.VERTICAL, new Insets(2, 2,2, 10),
                50, 0));
        //toolbar
        this.getContentPane().add(toolBar,  new GridBagConstraints(0, 3, 3, 1, 1.0, 0,
                GridBagConstraints.NORTH, GridBagConstraints.BOTH, new Insets(2, 2, 2, 2),
                0, 55));
        this.getContentPane().add(panelx,  new GridBagConstraints(1, 0, 2, 3, 1.0, .6,
                GridBagConstraints.EAST, GridBagConstraints.BOTH, new Insets(2, 2, 2, 2),
                0, 124));
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_D){
            if(Panel.eraseMode){
                for (int i = 0; i < Panel.drawing.lines.size(); i++) {
                    if(Panel.drawing.lines.get(i).eVals.size() > 0) {
                        Panel.drawing.lines.remove(Panel.drawing.lines.get(i));
                    }
                }
            }
            Panel.drawMode = true;
            Panel.eraseMode = false;
        }
        else if(e.getKeyCode() == KeyEvent.VK_E){
            Panel.drawMode = true;
            Panel.eraseMode = true;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
