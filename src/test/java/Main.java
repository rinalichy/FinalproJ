import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.sql.Driver;

import static java.lang.Thread.*;

public class Main {

    @Test
    void setUPtest(){
        Helper.setupdriver();
    }

    @Test
    public static void navigateTEST() throws InterruptedException {
        Helper.setupdriver();
        WebDriver driver = new ChromeDriver();
        driver.get(Helper.WIKIMAINURL);
        sleep(3000);
        driver.navigate().to(Helper.WIKIHELICOPTER);
        sleep(3000);
        driver.navigate().to(Helper.WIKIAIRPLAN);
        sleep(3000);
        driver.navigate().back();
        sleep(3000);
        driver.navigate().forward();
        sleep(3000);
        driver.navigate().refresh();
        sleep(3000);
        driver.close();
    }
    @Test
    public static void screensizeTEST() throws InterruptedException {
        Helper.setupdriver();
        WebDriver driver = new ChromeDriver();
        driver.get(Helper.WIKIMAINURL);
        driver.manage().window().maximize();
        sleep(3000);
        driver.manage().window().fullscreen();
        sleep(3000);
        driver.manage().window().minimize();
        sleep(3000);
        driver.close();
    }

    @Test
    public static void tabsManageTest(){
        Helper.setupdriver();
        WebDriver driver = new ChromeDriver();
        driver.get(Helper.WIKIMAINURL);
        driver.switchTo().newWindow(WindowType.WINDOW);
        driver.get(Helper.WIKIAIRPLAN);

        

    }


}
