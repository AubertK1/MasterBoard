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
        JLabel label6 =  new JLabel("Panel 6");
        label6.setHorizontalAlignment(SwingConstants.CENTER);
        JButton drawButt = new JButton("draw");
        drawButt.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
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
        });
        JButton eraseButt = new JButton("erase");
        eraseButt.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                Panel.drawMode = true;
                Panel.eraseMode = true;
            }
        });
        toolBar.add(label6,new GridBagConstraints(0, 0, 1, 1, 0.33, 0.6,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0,0, 0),
                0, 0));
        toolBar.add(drawButt,new GridBagConstraints(1, 0, 1, 1, 0.33, 0.6,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0,0, 0),
                0, 0));
        toolBar.add(eraseButt,new GridBagConstraints(2, 0, 1, 1, 0.33, 0.6,
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
