import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class Utils {

    public static void doscroll(WebDriver driver) {
        JavascriptExecutor js=(JavascriptExecutor) driver;
        js.executeScript  ("window.scrollBy(0,500)");

    }

    }

