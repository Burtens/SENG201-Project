import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class CropDetailScreen {

    /*Components*/
    private JLabel cropImageIcon;
    private JPanel mainPanel;
    private JLabel growthLabel;
    private JLabel valueLabel;
    private JButton plantCropButton;
    private JPanel optionsPanel;
    private JButton harvestCropButton;
    private JButton tendToCropButton;
    private JButton fertilizeCropButton;
    private JButton backButton;
    private JLabel nameLabel;
    private JLabel actionsLeftLabel;
    private JLabel growthRateLabel;

    /*Stored Variables*/
    private Main controller;
    private Farm farm;
    private int plotPos;


    CropDetailScreen(Main master, int incomingPlotPos, Farm farm)
    {
        this.plotPos = incomingPlotPos;
        this.controller = master;
        this.farm = farm;
        initialise();

    }

    private void initialise() {
        refresh();

        tendToCropButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                ArrayList<String> tools = new ArrayList<>();
                tools.add("Watering Can");

                String selection = (String) JOptionPane.showInputDialog(mainPanel, "Please select tool to use", "Tend to Crop",
                        JOptionPane.PLAIN_MESSAGE, null, tools.toArray(), null);
                if (selection != null)
                    farm.tendCrop(selection, plotPos);
                refresh();
            }
        });

        harvestCropButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                farm.harvestCrop(plotPos);
                refresh();
            }
        });


        plantCropButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (Bag.seeds.isEmpty())
                    JOptionPane.showMessageDialog(mainPanel, "Sorry you have no seeds please buy some at the shop");
                else {
                    Seeds selection = (Seeds) JOptionPane.showInputDialog(mainPanel,"Please select a seed", "Plant Crop",
                                                                            JOptionPane.PLAIN_MESSAGE, null, Bag.seeds.toArray(), null);
                    if (selection != null){
                        String seedName = selection.toString();
                        int seedPos = Bag.seeds.indexOf(selection);
                        farm.plantCrop(seedName, seedPos, plotPos);
                        refresh();


                    }
                }
            }
        });

        fertilizeCropButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (Bag.getGFertilizerAmount() == 0 && Bag.getVFertilizerAmount() == 0 && Bag.getBonemealAmount() == 0)
                    JOptionPane.showMessageDialog(mainPanel, "Sorry you have no fertilizer please buy some at the shop");
                else {
                    ArrayList<String> fertilizer = new ArrayList<>();
                    if (Bag.getVFertilizerAmount() > 0)
                        fertilizer.add("Value Fertilizer");
                    if (Bag.getGFertilizerAmount() > 0)
                        fertilizer.add("Growth Fertilizer");
                    if (Bag.getBonemealAmount() > 0)
                        fertilizer.add("Bonemeal");

                    String selection = (String) JOptionPane.showInputDialog(mainPanel, "Please select item to use", "Fertilize Crop",
                            JOptionPane.PLAIN_MESSAGE, null, fertilizer.toArray(), null);
                    if (selection != null) {
                        String fertilizerType = selection;
                        farm.tendCrop(fertilizerType, plotPos);
                        refresh();

                    }

                }
            }
        });

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.closeCropDetailScreen();
            }
        });

    }

    private void refresh()
    {
        int actionsLeft = Status.getActions();

        if (Status.getActions() == 1)
            actionsLeftLabel.setText("Actions remaining: 1");
        else
            actionsLeftLabel.setText("Actions remaining: " + Status.getActions());

        if (farm.getPlots()[this.plotPos] == null)
        {
            nameLabel.setText("No Crop");
            harvestCropButton.setEnabled(false);
            tendToCropButton.setEnabled(false);
            fertilizeCropButton.setEnabled(false);

            cropImageIcon.setIcon(null);

            plantCropButton.setVisible(true);
            growthLabel.setText("None");
            growthRateLabel.setText("None");
            valueLabel.setText("$" + String.format("%.2f", 0.0));
        }
        else {

            plantCropButton.setVisible(false);
            Crop currentCrop = farm.getPlots()[plotPos];
            nameLabel.setText(currentCrop.toString());

            growthLabel.setText(currentCrop.daysTillHarvistable());

            growthRateLabel.setText(currentCrop.getGrowthRate() + "%");
            valueLabel.setText("$" + String.format("%.2f", currentCrop.getValue()));
            cropImageIcon.setIcon(new ImageIcon(currentCrop.getCurrImage()));

            if (currentCrop.getGrowth() == 100 && actionsLeft > 0)
                harvestCropButton.setEnabled(true);

            if (currentCrop.getGrowth() < 100 && actionsLeft > 0)
                tendToCropButton.setEnabled(true);

            else
                tendToCropButton.setEnabled(false);

            if (actionsLeft == 0){
                harvestCropButton.setEnabled(false);
                tendToCropButton.setEnabled(false);
            }

            if (actionsLeft > 0 && currentCrop.getGrowth() < 100 )
                fertilizeCropButton.setEnabled(true);
            else{
                fertilizeCropButton.setEnabled(false);
            }
        }
    }

    public JPanel getMainPanel() { return this.mainPanel; }



}
