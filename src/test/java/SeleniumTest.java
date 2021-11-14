import com.google.common.annotations.VisibleForTesting;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SeleniumTest {
    @Test
    public void myFirstSeleniumTest() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, 10);

        driver.get("https://the-internet.herokuapp.com/");

        WebElement inLink = driver.findElement(By.linkText("Inputs"));
        inLink.click();

        WebElement input = driver.findElement(By.tagName("input"));
        input.sendKeys("12345678");

        WebElement newElement = wait.until(ExpectedConditions.presenceOfElementLocated(By.tagName("a")));


        String inputValue = input.getAttribute("value");

        Assert.assertTrue(inputValue.isEmpty());

        Thread.sleep(3000);
            driver.close();
            driver.quit();
    }
}
