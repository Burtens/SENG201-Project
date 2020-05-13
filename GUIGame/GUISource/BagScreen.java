import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BagScreen {
    private final GUIMain controller;
    private JTabbedPane bagMenu;
    private JPanel MainPanel;
    private JButton closeBagButton;
    private JLabel carrotAmountLabel;
    private JLabel cornAmountLabel;
    private JLabel lettuceAmountLabel;
    private JLabel potatoAmountLabel;
    private JLabel tomatoAmountLabel;
    private JLabel strawberryAmountLabel;
    private JLabel foodAmountLabel;
    private JLabel toyAmountLabel;
    private JLabel gfertilizerAmountLabel;
    private JLabel vfertilizerAmountLabel;

    public void initialize() {
        closeBagButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.closeBag();
            }
        });
        foodAmountLabel.setText(String.valueOf(GUIBag.getFoodAmount()));
        toyAmountLabel.setText(String.valueOf(GUIBag.getToyAmount()));
        gfertilizerAmountLabel.setText(String.valueOf(GUIBag.getGFertilizerAmount()));
        vfertilizerAmountLabel.setText(String.valueOf(GUIBag.getVFertilizerAmount()));
        carrotAmountLabel.setText(GUIBag.getSeeds());
    }

    public BagScreen(GUIMain master) {
        this.controller = master
        initialize();
    }

    public JPanel getMainPanel() {
        return MainPanel;
    }
}
