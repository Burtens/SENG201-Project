import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.Scanner;

public class ShopScreen {

    private JTabbedPane shopMenu;
    private JButton foodButton;
    private JButton toysButton;
    private JButton growthFertilizerButton;
    private JButton valueFertilizerButton;
    private JButton carrotsButton;
    private JButton cornButton;
    private JButton lettuceButton;
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
    private GUIMain controller;

    public void initialize() {
        buyAmountSpinner.setModel(new SpinnerNumberModel(1, 1, 100, 1));
        JFormattedTextField tf = ((JSpinner.DefaultEditor) buyAmountSpinner.getEditor()).getTextField();
        tf.setEditable(false);
        bagButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.launchBag();
            }
        });
        foodButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int amount = (int) buyAmountSpinner.getValue();
                GUIBag.updateFoodAmount(amount);
                buyText.setText("Thanks for buying " + amount + " pieces of food.");
            }
        });
        toysButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int amount = (int) buyAmountSpinner.getValue();
                GUIBag.updateToyAmount(amount);
                buyText.setText("Thanks for buying " + amount + " toys.");
            }
        });
        growthFertilizerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int amount = (int) buyAmountSpinner.getValue();
                GUIBag.updateGFertilizerAmount(amount);
                buyText.setText("Thanks for buying " + amount + " bags of growth fertilizer.");
            }
        });
        valueFertilizerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int amount = (int) buyAmountSpinner.getValue();
                GUIBag.updateVFertilizerAmount(amount);
                buyText.setText("Thanks for buying " + amount + " bags of value fertilizer.");
            }
        });
        carrotsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int amount = (int) buyAmountSpinner.getValue();
                GUIBag.updateSeeds("Turnips", amount);
                buyText.setText("Thanks for buying " + amount + " turnip seeds.");
            }
        });
        cornButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int amount = (int) buyAmountSpinner.getValue();
                GUIBag.updateSeeds("Corn", amount);
                buyText.setText("Thanks for buying " + amount + " corn seeds.");
            }
        });
        lettuceButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int amount = (int) buyAmountSpinner.getValue();
                GUIBag.updateSeeds("Grapes", amount);
                buyText.setText("Thanks for buying " + amount + " grape seeds.");
            }
        });
        potatosButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int amount = (int) buyAmountSpinner.getValue();
                GUIBag.updateSeeds("Potatoes", amount);
                buyText.setText("Thanks for buying " + amount + " potato seeds.");
            }
        });
        tomatosButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int amount = (int) buyAmountSpinner.getValue();
                GUIBag.updateSeeds("Tomatoes", amount);
                buyText.setText("Thanks for buying " + amount + " tomato seeds.");
            }
        });
        strawberriesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int amount = (int) buyAmountSpinner.getValue();
                GUIBag.updateSeeds("Strawberries", amount);
                buyText.setText("Thanks for buying " + amount + " strawberry seeds.");
            }
        });
        returnToFarmButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.closeShop();
            }
        });
    }

    public ShopScreen(GUIMain control) {
        controller = control;
        initialize();
    }

    public JPanel getMainPanel() {
        return MainPanel;
    }
}