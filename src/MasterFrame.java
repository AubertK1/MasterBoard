import javax.swing.*;
import java.awt.*;

public class MasterFrame extends JFrame {
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
        sideCard.setPreferredSize(new Dimension(50, 660));
        sideCard.setBorder(BorderFactory.createEtchedBorder());
        JLabel label1 =  new JLabel("Panel 1");
        label1.setHorizontalAlignment(SwingConstants.CENTER);
        sideCard.add(label1,new GridBagConstraints(0, 0, 1, 1, 0, 0.6,
                GridBagConstraints.CENTER, GridBagConstraints.CENTER, new Insets(0, 0,0, 0),
                0, 0));

        JPanel panelx = new PlayerCard();

        JPanel toolBar = new JPanel(new GridBagLayout());
        toolBar.setPreferredSize(new Dimension(720, 60));
        toolBar.setBorder(BorderFactory.createEtchedBorder());
        JLabel label6 =  new JLabel("Panel 6");
        label6.setHorizontalAlignment(SwingConstants.CENTER);
        toolBar.add(label6,new GridBagConstraints(0, 0, 1, 1, 0, 0.6,
                GridBagConstraints.CENTER, GridBagConstraints.CENTER, new Insets(0, 0,0, 0),
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
}
