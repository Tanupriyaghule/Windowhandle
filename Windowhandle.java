package test_case.codes;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.OutputType;
import org.apache.commons.io.FileUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import java.io.File;

public class Windowhandle {
    public WebDriver driver;

    public Windowhandle() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }
public void endTest() {
        System.out.println("End Test: TestCases");
        driver.close();
        driver.quit();
    }
    public void testcase03() {
        try {
            // Step 1: Go to the URL
            driver.get("https://www.w3schools.com/jsref/tryit.asp?filename=tryjsref_win_open");

            // Step 2: Switch to the iframe containing the "Try it" button
            driver.switchTo().frame("iframeResult");

            // Locate and click the "Try it" button
            WebElement tryItButton = driver.findElement(By.xpath("//button[text()='Try it']"));
            tryItButton.click();

            // Step 3: Switch to the new window that opened
            for (String windowHandle : driver.getWindowHandles()) {
                driver.switchTo().window(windowHandle);
                String newWindowUrl = driver.getCurrentUrl();
                String newWindowTitle = driver.getTitle();

                // Take a screenshot (you may need to adjust the path)
                File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
                FileUtils.copyFile(screenshotFile, new File("screenshot.png"));

                // Close the new window
                driver.close();

                // Step 4: Switch back to the original window by using the window handle
                driver.switchTo().window(driver.getWindowHandles().iterator().next());
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Close the original window
            driver.quit();
 }}}