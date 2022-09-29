import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;

public class Helper {
      public static void setupdriver (){
        System.setProperty("webdriver.chrome.driver","res/chromedriver");
     }

    public static final String WIKIMAINURL = "https://www.wikipedia.org";
    public static final String WIKIHELICOPTER = "https://en.wikipedia.org/wiki/Helicopter";
    public static final String WIKIAIRPLAN = "https://en.wikipedia.org/wiki/Airplane";

    public static final String SEARCHFIELDID = "searchInput";
    public static final String SERCHBUTTONID = "searchButton";

    public static final String WIKIPHARAGHRAPHXPATH = "/html/body/div[3]/div[3]/div[5]/div[1]/p[6]";
    public static final String DPATH = "/Users/rina_l/";
    public static final String TXT = ".txt";
    public static final String JPG = ".jpg";








}
