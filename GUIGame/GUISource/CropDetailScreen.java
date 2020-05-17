import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Array;
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
    private GUIMain controller;
    private GUIFarm farm;
    private int plotPos;
    private Crop currentCrop;


    CropDetailScreen(GUIMain master, int incomingPlotPos, GUIFarm farm)
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
                farm.tendCrop("wateringCan", plotPos);
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
                if (GUIBag.seeds.isEmpty())
                    JOptionPane.showMessageDialog(mainPanel, "Sorry you have no seeds please buy some at the shop");
                else {
                    Seeds selection = (Seeds) JOptionPane.showInputDialog(mainPanel,"Please select a seed", "Plant Crop",
                                                                            JOptionPane.PLAIN_MESSAGE, null, GUIBag.seeds.toArray(), null);
                    if (selection != null){
                        String seedName = selection.toString();
                        int seedPos = GUIBag.seeds.indexOf(selection);
                        farm.plantCrop(seedName, seedPos, plotPos);
                        refresh();


                    }
                }
            }
        });

        fertilizeCropButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (GUIBag.getGFertilizerAmount() == 0 && GUIBag.getVFertilizerAmount() == 0)
                    JOptionPane.showMessageDialog(mainPanel, "Sorry you have no fertilizer please buy some at the shop");
                else {
                    ArrayList<String> fertilizer = new ArrayList<>();
                    if (GUIBag.getVFertilizerAmount() > 0)
                        fertilizer.add("Value");
                    if (GUIBag.getGFertilizerAmount() > 0)
                        fertilizer.add("Growth");

                    String selection = (String) JOptionPane.showInputDialog(mainPanel, "Please select fertilizer to use", "Fertilize Crop",
                            JOptionPane.PLAIN_MESSAGE, null, fertilizer.toArray(), null);
                    if (selection != null) {
                        String fertilizerType = selection.toLowerCase();
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
        int actionsLeft = GUIStatus.getActions();

        if (GUIStatus.getActions() == 1)
            actionsLeftLabel.setText("Actions remaining: 1");
        else
            actionsLeftLabel.setText("Actions remaining: " + GUIStatus.getActions());

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
            currentCrop = farm.getPlots()[plotPos];
            nameLabel.setText(currentCrop.toString());
            growthLabel.setText(currentCrop.getGrowth() + "%");
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

            if ((GUIBag.getGFertilizerAmount() > 0 || GUIBag.getVFertilizerAmount() > 0) && actionsLeft > 0
                    && currentCrop.getGrowth() < 100 )
                fertilizeCropButton.setEnabled(true);
            else{
                fertilizeCropButton.setEnabled(false);
            }
        }
    }

    public JPanel getMainPanel() { return this.mainPanel; }



}