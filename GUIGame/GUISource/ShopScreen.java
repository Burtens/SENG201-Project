import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
    private JTextPane buyText;
    private JLabel moneyLabel;
    private JButton hoeButton;
    private JButton bonemealButton;
    private Main controller;

    private void initialize() {
        buyAmountSpinner.setModel(new SpinnerNumberModel(1, 1, 100, 1));

        JFormattedTextField tf = ((JSpinner.DefaultEditor) buyAmountSpinner.getEditor()).getTextField();

        tf.setBackground(new Color(174, 141, 62));
        tf.setEditable(false);

        moneyLabel.setText("Money:  $" + String.format("%.2f", Status.getMoney()));
        if (Bag.hasHoe())
            hoeButton.setEnabled(false);

        bagButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                controller.launchBag();
            }
        });
        foodButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int amount = (int) buyAmountSpinner.getValue();
                if (buyButton("pieces of food.", amount, -50 * amount)) {
                    Bag.updateFoodAmount(amount);
                }
            }
        });
        toysButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int amount = (int) buyAmountSpinner.getValue();
                if (buyButton("toys.", amount, -30 * amount)) {
                    Bag.updateToyAmount(amount);
                }
            }
        });
        growthFertilizerButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int amount = (int) buyAmountSpinner.getValue();
                if (buyButton("bags of growth fertilizer.", amount, -10 * amount)) {
                    Bag.updateGFertilizerAmount(amount);
                }
            }
        });
        valueFertilizerButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int amount = (int) buyAmountSpinner.getValue();
                if (buyButton("bags of value fertilizer.", amount, -10 * amount)) {
                    Bag.updateVFertilizerAmount(amount);
                }
            }
        });
        hoeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (buyButton("hoe.", 1, -300)){
                    Bag.setHasHoe(true);
                    hoeButton.setEnabled(false);
                }

            }
        });
        bonemealButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int amount = (int) buyAmountSpinner.getValue();
                if (buyButton("bonemeal.", amount, -5 * amount)) {
                    Bag.updateBonemealAmount(amount);
                }
            }
        });
        turnipsButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int amount = (int) buyAmountSpinner.getValue();
                if (buyButton("turnip seeds.", amount, -12 * amount)) {
                    Bag.updateSeeds("Turnips", amount);
                }
            }
        });
        cornButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int amount = (int) buyAmountSpinner.getValue();
                if (buyButton("corn seeds.", amount, -5 * amount)) {
                    Bag.updateSeeds("Corn", amount);
                }
            }
        });
        grapesButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int amount = (int) buyAmountSpinner.getValue();
                if (buyButton("grape seeds.", amount, -15 * amount)) {
                    Bag.updateSeeds("Grapes", amount);
                }
            }
        });
        potatosButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int amount = (int) buyAmountSpinner.getValue();
                if (buyButton("potato seeds.", amount, -7 * amount)) {
                    Bag.updateSeeds("Potatoes", amount);
                }
            }
        });
        tomatosButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int amount = (int) buyAmountSpinner.getValue();
                if (buyButton("tomato seeds.", amount, -20 * amount)) {
                    Bag.updateSeeds("Tomatoes", amount);
                }
            }
        });
        strawberriesButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int amount = (int) buyAmountSpinner.getValue();
                if (buyButton("strawberry seeds.", amount, -10 * amount)) {
                    Bag.updateSeeds("Strawberries", amount);
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
        if (Status.getMoney() + cost < 0) {
            buyText.setText("Sorry not enough money.");
            return false;
        } else {
            buyText.setText("Thanks for buying " + amount + " " + item);
            Status.updateMoney(cost);
            moneyLabel.setText("Money:  $" + String.format("%.2f", Status.getMoney()));
            return true;
        }
    }

    private boolean animalBuyButton(String item, int cost, Animals animal) {
        if (Status.getMoney() + cost < 0) {
            buyText.setText("Sorry not enough money.");
            return false;
        } else if (!controller.farm.newAnimal(animal)) {
            buyText.setText("Sorry no empty pens.");
            return false;
        } else {
            buyText.setText("Thanks for buying a " + item);
            Status.updateMoney(cost);
            moneyLabel.setText("Money:  $" + Status.getMoney());
            return true;
        }
    }

    public ShopScreen(Main control) {
        controller = control;
        initialize();
    }

    public JPanel getMainPanel() {
        return MainPanel;
    }
}