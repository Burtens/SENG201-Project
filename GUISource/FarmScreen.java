import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * This class houses the functionality of the farm screen. This screen acts as a main hub to the rest of the game.
 * From here you will be able to access the shop and bag as well as accessing current crops and animals on the farm.
 *
 *
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
    private GUIMain controller;

    public JPanel getMainPanel(){ return mainPanel; }

    FarmScreen(GUIMain master){
        this.controller = master;
        initialise();
    }

    private void initialise(){
        dayLabel.setText(Integer.toString(GUIStatus.getDay()));
        actionLabel.setText(Integer.toString(GUIStatus.getActions()));
        moneyLabel.setText("$" + String.format("%.2f", GUIStatus.getMoney()));

        nextDayButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (GUIStatus.getDay() < controller.farm.getDays()) {
                    GUIStatus.updateDay(controller.farm);
                    dayLabel.setText(Integer.toString(GUIStatus.getDay()));
                    actionLabel.setText(Integer.toString(GUIStatus.getActions()));
                    moneyLabel.setText("$" + String.format("%.2f", GUIStatus.getMoney()));
                }
                else {
                     controller.endGame();
                }

            }
        });

        shopButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // TODO: Takes user to the shop
            }
        });

        viewAnimalsButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // TODO: Take user to animals
            }
        });

        viewCropsButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // TODO: Take user to animals
            }
        });

    }
}
