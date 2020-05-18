import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AnimalScreen {
    private JButton feedButton;
    private JButton playButton;
    private JButton bagButton;
    private JButton returnButton;
    private JLabel animalType;
    private JLabel animalHealth;
    private JLabel animalHappiness;
    private JLabel animalValue;
    private JPanel animalImage;
    private JPanel menu;
    private JPanel stats;
    private JPanel main;
    private JLabel actionText;
    private JLabel animalIcon;
    private GUIMain controller;
    private int penPos;

    AnimalScreen(GUIMain control, int pen) {
        this.controller = control;
        penPos = pen;
        initialize();
    }

    public void initialize() {
        GUIAnimals[] pens = controller.farm.getPens();
        animalType.setText(pens[penPos].getClass().getSimpleName());
        animalHealth.setText(String.valueOf(pens[penPos].getHealth()));
        animalHappiness.setText(String.valueOf(pens[penPos].getHappiness()));
        animalValue.setText(String.valueOf(pens[penPos].getValue()));
        animalIcon.setIcon(new ImageIcon(getClass().getResource(pens[penPos].getClass().getSimpleName() + ".png")));
        feedButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (GUIBag.getFoodAmount() > 0 && GUIStatus.getActions() > 0) {
                    GUIStatus.updateActions(-1);
                    GUIBag.updateFoodAmount(-1);
                    actionText.setText("you feed the " + animalType.getText());
                    pens[penPos].feed();
                    animalHealth.setText(String.valueOf(pens[penPos].getHealth()));
                    animalHappiness.setText(String.valueOf(pens[penPos].getHappiness()));
                } else if (GUIStatus.getActions() == 0) {
                    actionText.setText("No more actions.");
                } else {
                    actionText.setText("Not enough food.");
                }
            }
        });
        playButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (GUIBag.getToyAmount() > 0 && GUIStatus.getActions() > 0) {
                    GUIStatus.updateActions(-1);
                    GUIBag.updateToyAmount(-1);
                    actionText.setText("you play with the " + animalType.getText());
                    pens[penPos].play();
                    animalHappiness.setText(String.valueOf(pens[penPos].getHappiness()));
                } else if (GUIStatus.getActions() == 0) {
                    actionText.setText("No more actions.");
                } else {
                    actionText.setText("Not enough toys.");
                }
            }
        });
        bagButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                controller.launchBag();
            }
        });
        returnButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                controller.closeAnimalScreen();
            }
        });
    }

    public JPanel getMain() {
        return main;
    }
}
