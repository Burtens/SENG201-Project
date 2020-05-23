import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
    private JPanel cropPanel;
    private JLabel actionLabel;
    private JButton tendFarmButton;

    /*Stored Variables*/
    private Main controller;
    private final Farm farm;


    CropScreen(Main master, Farm farm){
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
    }

    private void refresh(){
        if (Status.getActions() == 1)
            actionLabel.setText("Actions remaining: 1");
        else
            actionLabel.setText("Actions remaining: " + Status.getActions());

        Crop[] plots = farm.getPlots();
        int totalPlots = plots.length;
        int totalCrops = 0;
        for (int i = 0; i < totalPlots; i++) {
            final int plotNum = i;
            JButton currButton = (JButton) cropPanel.getComponent(i);

            currButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    controller.launchCropDetailScreen(plotNum);
                }
            });

            if (plots[i] != null) {
                Crop currCrop = plots[i];
                totalCrops++;
                currButton.setIcon(new ImageIcon(getClass().getResource(currCrop.getCurrImage())));
                currButton.setText(currCrop.toString());
            }
            currButton.setContentAreaFilled(false);
            currButton.setVisible(true);


            if (totalCrops == 1)
                totalCropsLabel.setText("You have: " + totalCrops + " crop");
            else
                totalCropsLabel.setText("You have: " + totalCrops + " crops");

            if (Status.getActions() == 0 || farm.getPlots().length == 12)
                tendFarmButton.setEnabled(false);
            else
                tendFarmButton.setEnabled(true);
        }
    }
    public JPanel getMainPanel(){ return mainPanel; }
}
