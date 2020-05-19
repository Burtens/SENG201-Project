import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class BagScreen {
    private final Main controller;
    private JTabbedPane bagMenu;
    private JPanel MainPanel;
    private JButton closeBagButton;
    private JLabel turnipAmountLabel;
    private JLabel cornAmountLabel;
    private JLabel grapeAmountLabel;
    private JLabel potatoAmountLabel;
    private JLabel tomatoAmountLabel;
    private JLabel strawberryAmountLabel;
    private JLabel foodAmountLabel;
    private JLabel toyAmountLabel;
    private JLabel gFertilizerAmountLabel;
    private JLabel vFertilizerAmountLabel;

    public void initialize() {
        closeBagButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.closeBag();
            }
        });
        foodAmountLabel.setText(String.valueOf(Bag.getFoodAmount()));
        toyAmountLabel.setText(String.valueOf(Bag.getToyAmount()));
        gFertilizerAmountLabel.setText(String.valueOf(Bag.getGFertilizerAmount()));
        vFertilizerAmountLabel.setText(String.valueOf(Bag.getVFertilizerAmount()));

        bagMenu.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                if (bagMenu.getSelectedIndex() == 1)
                    setSeeds();
            }
        });

    }

    private void setSeeds() {
        ArrayList<Seeds> seeds = Bag.getSeeds();
        for (Seeds seed : seeds) {
            switch (seed.toString()) {
                case "Turnips":
                    turnipAmountLabel.setText(Integer.toString(seed.getAmount()));
                    break;
                case "Potatoes":
                    potatoAmountLabel.setText(Integer.toString(seed.getAmount()));
                    break;
                case "Corn":
                    cornAmountLabel.setText(Integer.toString(seed.getAmount()));
                    break;
                case "Grapes":
                    grapeAmountLabel.setText(Integer.toString(seed.getAmount()));
                    break;
                case "Strawberries":
                    strawberryAmountLabel.setText(Integer.toString(seed.getAmount()));
                    break;
                case "Tomatoes":
                    tomatoAmountLabel.setText(Integer.toString(seed.getAmount()));
                    break;
            }
        }
    }

    public BagScreen(Main master) {
        this.controller = master;
        initialize();
    }

    public JPanel getMainPanel() {
        return MainPanel;
    }
}
