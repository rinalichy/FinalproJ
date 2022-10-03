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
import java.time.Duration;

import static java.lang.Thread.sleep;

public class MainProject {
    @Test
    void setupTest(){
        Helper.setupdriver();
        WebDriver driver = new ChromeDriver();
        driver.close();
    }


    @Test
    public static void navigateTest() throws InterruptedException {
        Helper.setupdriver();
        WebDriver driver = new ChromeDriver();
        driver.get(Helper.WIKIMAINURL);
        driver.navigate().to(Helper.WIKIHELICOPTER);
        driver.navigate().to(Helper.WIKIAIRPLAN);
        driver.navigate().back();
        driver.navigate().forward();
        driver.navigate().refresh();
        driver.close();
    }
    @Test
    public static void screenSizeTest() throws InterruptedException {
        Helper.setupdriver();
        WebDriver driver = new ChromeDriver();
        driver.get(Helper.WIKIMAINURL);
        driver.manage().window().maximize();
        driver.manage().window().fullscreen();
        driver.manage().window().minimize();
        driver.close();
    }

    @Test
    public static void tabsManageTest() throws InterruptedException {
        Helper.setupdriver();
        WebDriver driver = new ChromeDriver();
        driver.get(Helper.WIKIMAINURL);
        String windowOne = driver.getWindowHandle();
        driver.switchTo().newWindow(WindowType.WINDOW);
        driver.get(Helper.WIKIAIRPLAN);
        String windowTwo = driver.getWindowHandle();
        driver.switchTo().window(windowOne);
        driver.close();

        driver.switchTo().window(windowTwo);
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get(Helper.WIKIHELICOPTER);
        String tabTwo = driver.getWindowHandle();
        driver.close();


    }


    @Test
    public static void copyPasteTest() throws IOException {
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
    public static void actionsTest () throws InterruptedException, IOException {
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
    }

    @Test
    public static void checkBoxesTest() throws IOException, InterruptedException {
    Helper.setupdriver();
    WebDriver driver =  new ChromeDriver();
    driver.get(Helper.CHECKBOXURl);
    WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
    WebElement check1 =
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(Helper.OPENOPTIONSXpath)));
    check1.click();
    WebElement littleCheck =
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(Helper.CHECKBOXDOCUMENTS)));
    littleCheck.click();
    Thread.sleep(3000);
    File file01 = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
    File file02 = new File(Helper.DPATH +"Checkbox" + Helper.JPG);
    FileUtils.copyFile(file01,file02);
    driver.close();

    }




    @Test
    public static void clicksTest () throws InterruptedException, IOException {
        Helper.setupdriver();
        WebDriver driver = new ChromeDriver();
        driver.get(Helper.CLICKBUTTONURL);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        Actions actions = new Actions(driver);
        WebElement optonsRightClick =
                wait.until(ExpectedConditions.presenceOfElementLocated(By.id(Helper.RIGHTCLICKId)));
        actions.contextClick(optonsRightClick).perform();
        Thread.sleep(3000);
        File file01 = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        File file02 = new File(Helper.DPATH +"OPTIONCLICK" + Helper.JPG);
        FileUtils.copyFile(file01,file02);
        Thread.sleep(3000);
        WebElement doulbelClick =
                wait.until(ExpectedConditions.presenceOfElementLocated(By.id(Helper.DOUBLEId)));
        actions.doubleClick(doulbelClick).perform();
        File file1 = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        File file2 = new File(Helper.DPATH +"doubleclick" + Helper.JPG);
        sleep(3000);
        driver.close();
    }

    @Test
    public static void alertTest () throws InterruptedException {
        Helper.setupdriver();
        WebDriver driver = new ChromeDriver();
        driver.get(Helper.ALERTURL);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement alertButton =
                wait.until(ExpectedConditions.presenceOfElementLocated(By.id(Helper.ALERTBUTTONid)));
        alertButton.click();
        Thread.sleep(2000);
        driver.switchTo().alert().accept();
        WebElement secondAlert =
                wait.until(ExpectedConditions.presenceOfElementLocated(By.id(Helper.ALERTBUTTONaccept_dissnisID)));
        secondAlert.click();
        driver.switchTo().alert().dismiss();
        sleep(2000);
        File file1 = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        File file2 = new File(Helper.DPATH +"alertmassege" + Helper.JPG);
        driver.close();
    }


}

