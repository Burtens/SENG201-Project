import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * This Screen class provides the methods for the farm screen. This screen acts as a main hub to the rest of the game.
 * From here you will be able to access the shop and bag as well as accessing current crops and animals on the farm.
 */
public class FarmScreen {



    /*Components*/
    private JPanel mainPanel;
    private JButton shopButton;
    private JLabel dayLabel;
    private JLabel actionLabel;
    private JLabel moneyLabel;
    private JButton nextDayButton;
    private JButton bagButton;
    private JButton viewCropsButton;
    private JButton viewAnimalsButton;

    /*Stored Varibles*/
    private Main controller;

    public JPanel getMainPanel(){ return mainPanel; }

    FarmScreen(Main master){
        this.controller = master;
        initialise();
    }

    private void initialise(){
        dayLabel.setText(Integer.toString(Status.getDay()));
        actionLabel.setText(Integer.toString(Status.getActions()));
        moneyLabel.setText("$" + String.format("%.2f", Status.getMoney()));
         /* Copyright 2015, "Farming Tool Icons" by Calciumtrice,
            Found at: https://opengameart.org/content/farming-tool-icons
            Copyright licence: http://creativecommons.org/licenses/by/3.0/
         */
        bagButton.setIcon(new ImageIcon(getClass().getResource("BagIcon.png")));
        bagButton.setContentAreaFilled(false);

        nextDayButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (Status.getDay() < controller.farm.getDays()) {
                    Status.updateDay(controller.farm);
                    dayLabel.setText(Integer.toString(Status.getDay()));
                    actionLabel.setText(Integer.toString(Status.getActions()));
                    moneyLabel.setText("$" + String.format("%.2f", Status.getMoney()));
                    if (Status.getDay() == controller.farm.getDays())
                        nextDayButton.setText("End Game");
                }
                else {
                     controller.endGame();
                }

            }
        });

        shopButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                controller.launchShop();
            }
        });

        viewAnimalsButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                controller.launchPenScreen();
            }
        });

        viewCropsButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                controller.launchCropScreen();
            }
        });

        bagButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                controller.launchBag();
            }
        });
    }
}
