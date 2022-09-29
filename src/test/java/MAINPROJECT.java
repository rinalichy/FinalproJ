import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.Duration;

import static java.lang.Thread.onSpinWait;
import static java.lang.Thread.sleep;

public class MAINPROJECT {
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
    public static void tabsManageTest() throws InterruptedException {
        Helper.setupdriver();
        WebDriver driver = new ChromeDriver();
        driver.get(Helper.WIKIMAINURL);
        String windowOne = driver.getWindowHandle();
        Thread.sleep(2000);
        driver.switchTo().newWindow(WindowType.WINDOW);
        sleep(2000);
        driver.get(Helper.WIKIAIRPLAN);
        String windowTwo = driver.getWindowHandle();
        sleep(2000);
        driver.switchTo().window(windowOne);
        driver.close();

        driver.switchTo().window(windowTwo);
        driver.switchTo().newWindow(WindowType.TAB);
        sleep(2000);
        driver.get(Helper.WIKIHELICOPTER);
        String tabTwo = driver.getWindowHandle();
        driver.close();


    }


    @Test
    public static void copypasteTest() throws IOException {
        File wikitext = new File(Helper.DPATH + "wikiFile" + Helper.TXT);
        try {
            if (wikitext.createNewFile()){
                System.out.println("file was created");

            }else{
                System.out.println("already created");
            }
        } catch (IOException e) {
            System.out.println("path is incorrect");
        }
        Helper.setupdriver();
        WebDriver driver = new ChromeDriver();
        driver.get(Helper.WIKIHELICOPTER);
        WebElement textWiki = driver.findElement(By.xpath(Helper.WIKIPHARAGHRAPHXPATH));
        String bodyPharagraph = textWiki.getText();
        File fileOne = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        File fileTwo = new File(Helper.DPATH +"Wikipic" + Helper.JPG);
        FileUtils.copyFile(fileOne,fileTwo);
        try {
            FileWriter writer1 = new FileWriter(wikitext,true);
            writer1.write(bodyPharagraph);
            writer1.write("\nfive");
            writer1.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        driver.close();
    }
    @Test
    public static void actiontest (){
        Helper.setupdriver();
        WebDriver driver = new ChromeDriver();
        driver.get(SiteData.STOREHOMEURL);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(SiteData.TSHIRTSBUTTONXPATH))).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id(SiteData.CHECKBOXSIZESID))).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id(SiteData.CHECKCOLORBKUE))).click();

    }




}

