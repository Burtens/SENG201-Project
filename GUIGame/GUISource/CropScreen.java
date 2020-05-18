import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.plaf.BorderUIResource;
import javax.swing.plaf.IconUIResource;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.io.File;
import java.io.IOException;
import java.security.KeyStore;
import java.util.Observer;

/**
 *
 * Acts as a way to view and interact with crops on the farm
 * any of the buttons will take user to a detailed description of the crop growing on a given plot.
 * In the case of there being no crops available clicking on a button will allow user to plant a crop
 * given that they have the seeds available.
 *
 */
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
    private JLabel actionLabel;
    private JButton tendFarmButton;

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
        refresh();

        tendFarmButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                farm.updatePlotSize();
                refresh();
            }
        });

        returnButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.closeCropScreen();
            }
        });

        cropButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int plot = 0;
                selectedPlot(plot);
            }
        });


        cropButton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int plot = 1;
                selectedPlot(plot);
            }
        });

        cropButton3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int plot = 2;
                selectedPlot(plot);
            }
        });

        cropButton4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int plot = 3;
                selectedPlot(plot);
            }
        });

        cropButton5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int plot = 4;
                selectedPlot(plot);
            }
        });

        cropButton6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int plot = 5;
                selectedPlot(plot);
            }
        });

        cropButton7.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int plot = 6;
                selectedPlot(plot);
            }
        });

        cropButton8.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int plot = 7;
                selectedPlot(plot);
            }
        });

        cropButton9.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int plot = 8;
                selectedPlot(plot);
            }
        });

        cropButton10.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int plot = 9;
                selectedPlot(plot);
            }
        });

        cropButton11.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int plot = 10;
                selectedPlot(plot);
            }
        });

        cropButton12.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int plot = 11;
                selectedPlot(plot);
            }
        });




    }

    private void refresh(){
        if (GUIStatus.getActions() == 1)
            actionLabel.setText("Actions remaining: 1");
        else
            actionLabel.setText("Actions remaining: " + GUIStatus.getActions());

        Crop[] plots = farm.getPlots();
        int totalPlots = plots.length;
        int totalCrops = 0;
        for (int i = 0; i < totalPlots; i++) {
            JButton currButton = (JButton) cropPanel.getComponent(i);

            if (plots[i] != null) {
                Crop currCrop = plots[i];
                totalCrops++;
                currButton.setIcon(new ImageIcon(currCrop.getCurrImage()));
                currButton.setText(currCrop.toString());
            }
            currButton.setContentAreaFilled(false);
            currButton.setVisible(true);


            if (totalCrops == 1)
                totalCropsLabel.setText("You have: " + totalCrops + " crop");
            else
                totalCropsLabel.setText("You have: " + totalCrops + " crops");

            if (GUIStatus.getActions() == 0 || farm.getPlots().length == 12)
                tendFarmButton.setEnabled(false);
            else
                tendFarmButton.setEnabled(true);
        }
    }

    private void selectedPlot(int plotNum){
        controller.launchCropDetailScreen(plotNum);
    }


    public JPanel getMainPanel(){ return mainPanel; }

}
