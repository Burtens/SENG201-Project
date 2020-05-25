import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * Screen Class that provides methods to
 * allow user view score at the end of the game.
 */
public class EndScreen {

    private JPanel mainPanel;
    private JLabel farmNameLabel;
    private JLabel playerNameLabel;
    private JLabel moneyLabel;
    private JLabel dayLabel;
    private JLabel pointsLabel;
    private JButton endButton;
    private Main controller;
    private static int points = (int) Status.getMoney() * 2;
    private static int i = 0;

    private void initialize() {
        farmNameLabel.setText("Farm name: " + controller.farm.getFarmName());
        playerNameLabel.setText("Player name:  " + controller.farm.getFarmerName());
        dayLabel.setText("Days:  " + controller.farm.getDays());
        moneyLabel.setText("Money:  $" + Status.getMoney());
        pointsLabel.setText("Points:");
        endButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                controller.closeEndScreen();
            }
        });
        points = pointsCalculator();
    }

    /**
     * creates the end screen and adds counting up points label
     * @param control
     */
    public EndScreen(Main control) {
        controller = control;
        initialize();
        ScheduledExecutorService exec = Executors.newScheduledThreadPool(1);
        Runnable counter = new Runnable() {
            public void run() {
                i ++;
                points--;
                pointsLabel.setText("Points: " + i);
                if (points == 0) {
                    exec.shutdown();
                }
            }
        };
        int delay = (int) 2000000 / points;
        exec.scheduleAtFixedRate(counter, 1000000, delay, TimeUnit.MICROSECONDS);
    }

    /**
     * calculates points using money, animals, and crops on farm
     * @return points
     */
    private int pointsCalculator() {
        Animals[] pens = controller.farm.getPens();
        Crop[] crops = controller.farm.getPlots();
        for (int i = 0; i < pens.length; i++) {
            if (pens[i] != null) {
                points += pens[i].getMaxValue();
            }
        }
        for (int i = 0; i < crops.length; i++) {
            if (crops[i] != null) {
                points += (int) crops[i].getValue();
            }
        }
        return points;
    }

    public JPanel getMainPanel() {
        return mainPanel;
    }
}
