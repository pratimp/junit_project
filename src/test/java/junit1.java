import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class junit1 {
    WebDriver driver;
    @BeforeAll
    public void setup(){
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30)); //implicit waiter
    }

    @Test
    public void submitform() throws InterruptedException {
        driver.get("https://www.digitalunite.com/practice-webform-learners");
        WebElement cookie= driver.findElement(By.id("onetrust-accept-btn-handler"));
        cookie.click();

        WebElement nameelement= driver.findElement(By.id("edit-name"));
        driver.findElement(By.id("edit-name")).sendKeys("Parthan Pratim DEb");

        Utils.doscroll(driver);
        WebElement uploadElement = driver.findElement(By.id("edit-uploadocument-upload"));
        uploadElement.sendKeys("F:\\test.xlsx");
        Thread.sleep(3000);

        WebElement checkBoxElement = driver.findElement(By.cssSelector("label[for='edit-age']"));
        boolean isDisplayed = checkBoxElement.isDisplayed();
        if (isDisplayed == true) {
            checkBoxElement.click();
        }

        WebElement submit=driver.findElement(By.id("edit-submit"));
        submit.click();
        String message=driver.findElement(By.id("block-pagetitle")).getText();
        String expectedmessage="Thank you for your submission!";
        Assertions.assertTrue(message.contains(expectedmessage));
        System.out.println(expectedmessage);
    }

    @AfterAll
    public void closeDriver(){
        driver.close();
    }
}