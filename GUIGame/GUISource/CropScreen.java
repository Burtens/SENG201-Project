import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.io.File;
import java.io.IOException;
import java.security.KeyStore;
import java.util.Observer;

public class CropScreen {


    /*Components*/
    private JPanel mainPanel;
    private JButton returnButton;
    private JLabel totalCropsLabel;
    private JButton cropButton1;
    private JButton cropButton2;
    private JButton cropButton3;
    private JButton cropButton4;
    private JButton cropButton5;
    private JButton cropButton6;
    private JButton cropButton7;
    private JButton cropButton8;
    private JButton cropButton9;
    private JButton cropButton10;
    private JButton cropButton11;
    private JButton cropButton12;
    private JPanel cropPanel;

    /*Stored Variables*/
    private GUIMain controller;
    private final GUIFarm farm;


    CropScreen(GUIMain master, GUIFarm farm){
        this.controller = master;
        this.farm = farm;
        initialise();
    }

    private void initialise() {
        /*Sets up and initialises all plots available */
        GUIBag.updateSeeds("Potatoes", 1);

        Crop[] plots = farm.getPlots();
        int totalPlots = plots.length;
        int totalCrops = 0;
        for (int i = 0; i < totalPlots; i++) {
            JButton currButton = (JButton) cropPanel.getComponent(i);

            if (plots[i] != null) {
                Crop currCrop = plots[i];
                totalCrops++;
            }

            currButton.setVisible(true);
        }
        if (totalCrops == 1)
            totalCropsLabel.setText("You have: " + totalCrops + " crop");
        else
            totalCropsLabel.setText("You have: " + totalCrops + " crops");
    }


    public JPanel getMainPanel(){ return mainPanel; }

}
