import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.swing.*;
import javax.swing.text.AbstractDocument;
import java.awt.*;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.lang.reflect.Array;
import java.security.Key;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class SetupScreenTest {

    GUIMain main;
    GUIFarm farm;

    @BeforeEach
    void Start()
    {
    farm = new GUIFarm();
    main = new GUIMain();
    main.launchSetupScreen();
    }


    @Test
    void userNameTest()
    {

        JPanel contentPane = (JPanel) main.setupScreen.getContentPane();
        JPanel infoPanel = (JPanel) contentPane.getComponent(1);
        JLabel userNameLabel = (JLabel) (infoPanel.getComponent(9));


        try {
            Robot bot = new Robot();

            bot.keyPress(KeyEvent.VK_S);
            bot.delay(250);
            bot.keyRelease(KeyEvent.VK_S);

            /*Checks if Error Label prints out the right message if username is too short*/
            assertEquals("Name too short!", (userNameLabel.getText()));

            for (int i = 0; i < 2; i++) {
                bot.keyPress(KeyEvent.VK_S);
                bot.delay(250);
                bot.keyRelease(KeyEvent.VK_S);
            }

            /*Checks if Error Label is empty if user name is valid*/
            assertEquals("", (userNameLabel.getText()));

            bot.keyPress(KeyEvent.VK_8);
            bot.delay(250);
            bot.keyRelease(KeyEvent.VK_8);

            /*Checks if Error Label states if there are invalid chars*/
            assertEquals("One or more invalid Characters!", (userNameLabel.getText()));

            bot.keyPress(KeyEvent.VK_BACK_SPACE);
            bot.delay(250);
            bot.keyRelease(KeyEvent.VK_BACK_SPACE);

            for (int i = 0; i < 13; i++) {
                bot.keyPress(KeyEvent.VK_S);
                bot.delay(250);
                bot.keyRelease(KeyEvent.VK_S);
            }

            assertEquals("Name too long!", (userNameLabel.getText()));

            /*This test only works on my computer due to mouse positioning*/
            bot.mouseMove(190, 470);
            bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
            bot.delay(250);
            bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
            bot.delay(250);

            assertEquals(Color.RED, (userNameLabel.getForeground()));

        }
        catch (AWTException e) {
            fail(e);
        }

    }

}