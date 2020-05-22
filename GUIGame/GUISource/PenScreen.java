import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * This screen class allows user to interact with individual animals on the farm.
 * From here user can play and feed animals as well as viewing their current stats.
 */
public class PenScreen {
    private JPanel animalPanel;
    private JLabel totalAnimalsLabel;
    private JPanel mainPanel;
    private JButton returnButton;
    private JButton tendFarmButton;
    private JLabel actionLabel;
    private Main controller;


    PenScreen(Main master){
        this.controller = master;
        initialise();
    }

    private void initialise() {
        /*Sets up and initialises all pens available */
        refresh();
        tendFarmButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Status.updateActions(-1);
                if (controller.farm.getPens().length < 12) {
                    controller.farm.updatePenSize();
                }
                controller.farm.setTended(true);
                refresh();
            }
        });
        returnButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                controller.closePenScreen();
            }
        });
    }

    private void refresh() {
        if (Status.getActions() == 0) {
            tendFarmButton.setEnabled(false);
        } else {
            tendFarmButton.setEnabled(true);
        }
        actionLabel.setText("Actions remaining: " + Status.getActions());
        Animals[] pens = controller.farm.getPens();
        int totalPens = pens.length;
        int totalAnimals = 0;
        for (int i = 0; i < totalPens; i++) {
            JButton currButton = (JButton) animalPanel.getComponent(i);

            if (pens[i] != null) {
                Animals currAnimal = pens[i];
                currButton.setIcon(new ImageIcon(getClass().getResource(pens[i].getClass().getSimpleName() + "Small.png")));
                totalAnimals++;
                int finalI = i;
                currButton.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        controller.launchAnimalScreen(finalI);
                    }
                });
            } else {
                currButton.setIcon(new ImageIcon(getClass().getResource("Empty.png")));
            }
            currButton.setVisible(true);
        }
        if (totalAnimals == 1)
            totalAnimalsLabel.setText("You have: " + totalAnimals + " animal");
        else
            totalAnimalsLabel.setText("You have: " + totalAnimals + " animals");
    }

    public JPanel getMainPanel() {
        return mainPanel;
    }
}
