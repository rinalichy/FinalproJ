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
    public static final String DPATH = "/Users/rina_l/Documents/IDEAproject/FinalproJ/pic&txt/";
    public static final String TXT = ".txt";
    public static final String JPG = ".jpg";

    public static final String CHECKBOXURl = "https://demoqa.com/checkbox";
    public static final String OPENOPTIONSXpath = "//*[@id=\"tree-node\"]/ol/li/span/button/svg";
    public static final String MAINCHECKBOXpath = "//*[@id=\"tree-node\"]/ol/li/span/label/span[1]/svg";
    public static final String CHECKBOXDOCUMENTS = "//*[@id=\"tree-node\"]/ol/li/ol/li[2]/span/label/span[1]/svg";
    public static final String CLICKBUTTONURL= "https://demoqa.com/buttons";
    public static final String DOUBLEId = "doubleClickBtn";
    public static final String RIGHTCLICKId = "doubleClickBtn";











}
