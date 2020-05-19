import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SetupScreen {

    /*Form Variables*/
    private JPanel mainPanel;
    private JPanel infoPanel;
    private JPanel inputPanel;
    private JLabel farmThumbnail;
    private JTextField userNameField;
    private JSlider gameLengthSlider;
    private JTextField farmNameField;
    private JComboBox farmTypeBox;
    private JButton startButton;
    private JLabel cropGrowthLabel;
    private JLabel animalHappinessLabel;
    private JLabel userNameErrorLabel;
    private JLabel farmNameErrorLabel;

    /*Stored Variables*/
    private Main controller;
    private FarmType selectedFarmType = FarmType.BASIC;
    private boolean isValid = false;


    public SetupScreen(Main master){
        controller = master;
        initialize();

    }

    private void initialize() {
        gameLengthSlider.setLabelTable(new JSlider().createStandardLabels(5));
        /*Adds all farm types to dropdown box*/
        for (FarmType farmType : FarmType.values())
            farmTypeBox.addItem(farmType.toString().toLowerCase());

        /*Changes information stored in infoPanel based on selection*/
        farmTypeBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String value = String.valueOf(farmTypeBox.getSelectedItem());
                switch (value) {
                    case "basic":
                        farmThumbnail.setIcon(new ImageIcon(getClass().getResource("BasicThumb.png")));
                        selectedFarmType = FarmType.BASIC;
                        break;
                    case "river":
                        selectedFarmType = FarmType.RIVER;
                        farmThumbnail.setIcon(new ImageIcon(getClass().getResource("RiverThumb.png")));
                        break;
                    case "meadow":
                        farmThumbnail.setIcon(new ImageIcon(getClass().getResource("MeadowThumb.png")));
                        selectedFarmType = FarmType.MEADOW;
                        break;
                    case "barron":
                        selectedFarmType = FarmType.BARRON;
                         /* Copyright 2016, "Free Desert Top-Down Tileset" by Franco Giachetti,
                        Found at: https://opengameart.org/content/free-desert-top-down-tileset
                        Copyright licence: http://creativecommons.org/licenses/by/3.0/
                        */
                        farmThumbnail.setIcon(new ImageIcon(getClass().getResource("BarronThumb.png")));
                        break;
                }
                if (value.equals("basic")) {
                    cropGrowthLabel.setText("None");
                    animalHappinessLabel.setText("None");
                }
                else {
                    cropGrowthLabel.setText(selectedFarmType.getCropPercent() + "%");
                    animalHappinessLabel.setText(selectedFarmType.getAnimalPercent() + "%");
                }
            }
        });
        /*Waits for user to click start button then closes window and sets chosen values to farm*/
        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (farmNameField.getText().length() == 0){
                    isValid = false;
                    farmNameErrorLabel.setText("Farm name cannot be empty!");
                }

                if (userNameField.getText().length() == 0){
                    isValid = false;
                    userNameErrorLabel.setText("Farmer name cannot be empty!");
                }

                if (!isValid) {
                    userNameErrorLabel.setForeground(Color.RED);
                    farmNameErrorLabel.setForeground(Color.RED);
                }
                else
                    finishedWindow();
            }
        });
        /*Checks on text update if Farmer name is valid alerts user using userNameErrorLabel*/
        userNameField.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                errorCheck();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                errorCheck();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                errorCheck();
            }

            private void errorCheck(){
                userNameErrorLabel.setForeground(Color.black);
                isValid = false;
                if (userNameField.getText().length() < 3)
                    userNameErrorLabel.setText("Name too short!");
                else if (userNameField.getText().length() > 15)
                    userNameErrorLabel.setText("Name too long!");
                else if (checkString(userNameField.getText()))
                    userNameErrorLabel.setText("One or more invalid Characters!");
                else {
                    userNameErrorLabel.setText("");
                    isValid = true;
                }
            }

        });

    }

    private boolean checkString(String s)
    {
        boolean ISVALID = true;
        int strLen = s.length();
        for (int i = 0; i < strLen; i++)
        {
            if (!Character.isLetter(s.charAt(i)) && !Character.isSpaceChar(s.charAt(i)))
                ISVALID = false;
        }
        return ISVALID;
    }

    /*Closes window by calling function in controller*/
    private void finishedWindow() { controller.closeSetupScreen(this, selectedFarmType);}

    /*Getters for values on page*/
    public JPanel getMainPanel() { return mainPanel; }

    public String getFarmName() { return farmNameField.getText(); }

    public int getDays() { return gameLengthSlider.getValue(); }

    public String getFarmerName() { return userNameField.getText(); }
}
