import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.Format;
import java.util.Arrays;
import java.util.Scanner;

public class ShopScreen {

    private JTabbedPane shopMenu;
    private JButton foodButton;
    private JButton toysButton;
    private JButton growthFertilizerButton;
    private JButton valueFertilizerButton;
    private JButton turnipsButton;
    private JButton cornButton;
    private JButton grapesButton;
    private JButton potatosButton;
    private JButton tomatosButton;
    private JButton strawberriesButton;
    private JButton chickenButton;
    private JButton cowButton;
    private JButton pigButton;
    private JButton sheepButton;
    private JButton returnToFarmButton;
    private JButton bagButton;
    private JPanel MainPanel;
    private JSpinner buyAmountSpinner;
    private JLabel buyText;
    private JLabel moneyLabel;
    private GUIMain controller;

    public void initialize() {
        buyAmountSpinner.setModel(new SpinnerNumberModel(1, 1, 100, 1));
        JFormattedTextField tf = ((JSpinner.DefaultEditor) buyAmountSpinner.getEditor()).getTextField();
        tf.setBackground(new Color(174, 141, 62));
        tf.setEditable(false);
        moneyLabel.setText("Money:  $" + String.format("%.2f", GUIStatus.getMoney()));
        bagButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                controller.launchBag();
            }
        });
        foodButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int amount = (int) buyAmountSpinner.getValue();
                if (buyButton("pieces of food.", amount, -10 * amount)) {
                    GUIBag.updateFoodAmount(amount);
                }
            }
        });
        toysButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int amount = (int) buyAmountSpinner.getValue();
                if (buyButton("toys.", amount, -10 * amount)) {
                    GUIBag.updateToyAmount(amount);
                }
            }
        });
        growthFertilizerButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int amount = (int) buyAmountSpinner.getValue();
                if (buyButton("bags of growth fertilizer.", amount, -10 * amount)) {
                    GUIBag.updateGFertilizerAmount(amount);
                }
            }
        });
        valueFertilizerButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int amount = (int) buyAmountSpinner.getValue();
                if (buyButton("bags of value fertilizer.", amount, -10 * amount)) {
                    GUIBag.updateVFertilizerAmount(amount);
                }
            }
        });
        turnipsButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int amount = (int) buyAmountSpinner.getValue();
                if (buyButton("turnip seeds.", amount, -10 * amount)) {
                    GUIBag.updateSeeds("Turnips", amount);
                }
            }
        });
        cornButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int amount = (int) buyAmountSpinner.getValue();
                if (buyButton("corn seeds.", amount, -10 * amount)) {
                    GUIBag.updateSeeds("Corn", amount);
                }
            }
        });
        grapesButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int amount = (int) buyAmountSpinner.getValue();
                if (buyButton("grape seeds.", amount, -10 * amount)) {
                    GUIBag.updateSeeds("Grapes", amount);
                }
            }
        });
        potatosButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int amount = (int) buyAmountSpinner.getValue();
                if (buyButton("potato seeds.", amount, -10 * amount)) {
                    GUIBag.updateSeeds("Potatoes", amount);
                }
            }
        });
        tomatosButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int amount = (int) buyAmountSpinner.getValue();
                if (buyButton("tomato seeds.", amount, -10 * amount)) {
                    GUIBag.updateSeeds("Tomatoes", amount);
                }
            }
        });
        strawberriesButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int amount = (int) buyAmountSpinner.getValue();
                if (buyButton("strawberry seeds.", amount, -10 * amount)) {
                    GUIBag.updateSeeds("Strawberries", amount);
                }
            }
        });
        chickenButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                animalBuyButton("chicken.", -100, new Chicken());
            }
        });
        cowButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                animalBuyButton("cow.", -200, new Cow());
            }
        });
        pigButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                animalBuyButton("pig.", -160, new Pig());
            }
        });
        sheepButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                animalBuyButton("sheep.", -140, new Sheep());
            }
        });
        returnToFarmButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                controller.closeShop();
            }
        });
    }

    private boolean buyButton(String item, int amount, int cost) {
        if (GUIStatus.getMoney() + cost < 0) {
            buyText.setText("Sorry not enough money.");
            return false;
        } else {
            buyText.setText("Thanks for buying " + amount + " " + item);
            GUIStatus.updateMoney(cost);
            moneyLabel.setText("Money:  $" + String.format("%.2f", GUIStatus.getMoney()));
            return true;
        }
    }

    private boolean animalBuyButton(String item, int cost, GUIAnimals animal) {
        if (GUIStatus.getMoney() + cost < 0) {
            buyText.setText("Sorry not enough money.");
            return false;
        } else if (!controller.farm.newAnimal(animal)) {
            buyText.setText("Sorry no empty pens.");
            return false;
        } else {
            buyText.setText("Thanks for buying a " + item);
            GUIStatus.updateMoney(cost);
            moneyLabel.setText("Money:  $" + GUIStatus.getMoney());
            return true;
        }
    }

    public ShopScreen(GUIMain control) {
        controller = control;
        initialize();
    }

    public JPanel getMainPanel() {
        return MainPanel;
    }
}