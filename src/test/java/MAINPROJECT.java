import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Driver;
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
    public static void actiontest () throws InterruptedException, IOException {
        Helper.setupdriver();
        WebDriver driver = new ChromeDriver();
        driver.get(SiteData.ASOSURL);
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        WebElement voucher = driver.findElement(By.xpath(SiteData.GIFTVOUCHER_BUTTENXpath));
        jse.executeScript("arguments[0].scrollIntoView();",voucher);
        voucher.click();
        Assert.assertEquals(driver.getCurrentUrl(),SiteData.VAUCHERURL);
        Thread.sleep(3000);
        WebElement step1 = driver.findElement(By.xpath(SiteData.VOUCHER_STEP1Xpath));
        jse.executeScript("arguments[0].scrollIntoView();",step1);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.presenceOfElementLocated
                (By.xpath(SiteData.VOUCHER_STYLEPINKXpath))).click();
        jse.executeScript("window.scrollBy(0,200)");
        WebElement amount = driver.findElement(By.xpath(SiteData.VOUCHER_AMOUNT240Xpath));
        amount.click();
        jse.executeScript("window.scrollBy(0,200)");
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id(SiteData.VOUCHER_EMAILFIELDid)))
                .sendKeys("abc@g.com");
        File fileOne = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        File fileTwo = new File(Helper.DPATH +"VOUCHERgift1" + Helper.JPG);
        FileUtils.copyFile(fileOne,fileTwo);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id(SiteData.VOUCHER_TO_NANEid)))
                .sendKeys("HAPPY BIRTHDAY");
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id(SiteData.VOUCHER_FROM_NAMEid)))
                        .sendKeys("HAPPY BIRTHDAY ROSSITA");
        jse.executeScript("window.scrollBy(0,200)");
        WebElement dropMenu = driver.findElement(By.id(SiteData.VOUCHER_DELIVERY_DROPDMENUid));
        dropMenu.click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id(SiteData.VOUCHER_DELIVERY_DROPOPTIONid)))
                .click();

        File fileh = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        File fileh1 = new File(Helper.DPATH +"VOUCHERgift" + Helper.JPG);
        FileUtils.copyFile(fileh,fileh1);

        driver.close();

       //
        //scroll till the end
        // click button
        // equal between two URL's
        // scroll till step1
        // click on pink color
        // scroll to the 2nd step
        // click on amount:250 sh
        // scroll till 3rd step
        // click on email field
        // insert email field
        // click on name field
        // insert the RECIPIENT'S NAME
        // scroll till "from"
        // click on your name field
        //insert your name
        // click on drop down menu
        // choose 240 sh
        // click on pay now button

       //
      //  wait.until(ExpectedConditions.presenceOfElementLocated(By.id(SiteData.))).click();
      //  wait.until(ExpectedConditions.presenceOfElementLocated(By.id(SiteData.))).click();

    }

    @Test
    public static void checkboxes() throws IOException, InterruptedException {
    Helper.setupdriver();
    WebDriver driver =  new ChromeDriver();
    driver.get("https://the-internet.herokuapp.com/checkboxes");
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.linkText("Checkboxes"))).click();
        if (driver.getCurrentUrl().equals("https://the-internet.herokuapp.com/checkboxes")){
            System.out.println("----------right URL-----------");
            WebElement checkbox1 =
                    wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"checkboxes\"]/input[1]")));
            WebElement checkbox2 =
                    wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"checkboxes\"]/input[2]")));
            Thread.sleep(3000);
            checkbox1.click();
            Thread.sleep(3000);

            System.out.println("checkbox1 is selected = " + checkbox1.isSelected());
            System.out.println("checkbox2 is selected = " + checkbox2.isSelected());
        }else{
            System.out.println("wrong URL");
        }
    }

      //  File file01 = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
      //  File file02 = new File(Helper.DPATH +"Checkbox" + Helper.JPG);
     //   FileUtils.copyFile(file01,file02);
      //  Thread.sleep(3000);
      //  driver.close();



    @Test
    public static void clicks () throws InterruptedException, IOException {
        Helper.setupdriver();
        WebDriver driver = new ChromeDriver();
        driver.get(Helper.CLICKBUTTONURL);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        Actions actions = new Actions(driver);
        WebElement optonsRightclick =
                wait.until(ExpectedConditions.presenceOfElementLocated(By.id(Helper.RIGHTCLICKId)));
        actions.contextClick(optonsRightclick).perform();
        Thread.sleep(3000);
        File file01 = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        File file02 = new File(Helper.DPATH +"OPTINCLICK" + Helper.JPG);
        FileUtils.copyFile(file01,file02);
        Thread.sleep(3000);
        WebElement doulbelclick =
                wait.until(ExpectedConditions.presenceOfElementLocated(By.id(Helper.DOUBLEId)));
        actions.doubleClick(doulbelclick).perform();
        File file1 = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        File file2 = new File(Helper.DPATH +"doubleclick" + Helper.JPG);
        sleep(3000);
        driver.close();
    }




}

