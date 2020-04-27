import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Utilities {

    public boolean checkString(String s)
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

    public void waitTimer(int seconds){
      // TODO: 27/04/2020 Update this to allow main class to deal with issues if this occurs.
        /*Waits a second before continuing */
        try
        {
            TimeUnit.SECONDS.sleep(seconds);
            System.out.print("\n\n");
        }
        catch (InterruptedException e) { e.printStackTrace(); }

    }
}
