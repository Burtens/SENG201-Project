import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PenScreen {
    private JPanel animalPanel;
    private JButton animalButton1;
    private JButton animalButton2;
    private JButton animalButton3;
    private JButton animalButton4;
    private JButton animalButton5;
    private JButton animalButton6;
    private JButton animalButton7;
    private JButton animalButton8;
    private JButton animalButton9;
    private JButton animalButton10;
    private JButton animalButton11;
    private JButton animalButton12;
    private JLabel totalAnimalsLabel;
    private JPanel mainPanel;
    private JButton returnButton;
    private JButton tendFarmButton;
    private JLabel actionLabel;
    private GUIMain controller;


    PenScreen(GUIMain master){
        this.controller = master;
        initialise();
    }

    private void initialise() {
        /*Sets up and initialises all pens available */
        refresh();
        tendFarmButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                controller.farm.updatePenSize();
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
        if (GUIStatus.getActions() == 0 || controller.farm.getPens().length == 12) {
            tendFarmButton.setEnabled(false);
        } else {
            tendFarmButton.setEnabled(true);
        }
        actionLabel.setText("Actions remaining: " + GUIStatus.getActions());
        GUIAnimals[] pens = controller.farm.getPens();
        int totalPens = pens.length;
        int totalAnimals = 0;
        for (int i = 0; i < totalPens; i++) {
            JButton currButton = (JButton) animalPanel.getComponent(i);

            if (pens[i] != null) {
                GUIAnimals currAnimal = pens[i];
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
