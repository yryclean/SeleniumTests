import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SeleniumLinkTest {


    @Test
    public void myLinkTest() {
        WebDriver chrome = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(chrome, 5);

        chrome.get("https://the-internet.herokuapp.com/");

        WebElement getLink = chrome.findElement(By.linkText("Context Menu"));
        getLink.click();

        WebElement gotLink = chrome.findElement(By.id("hot-spot"));
        Actions rightClick = new Actions(chrome);
        rightClick.contextClick(gotLink).build().perform();

        Alert closedAlert = wait.until(ExpectedConditions.alertIsPresent());
        closedAlert.accept();

        Assert.assertTrue(gotLink.isDisplayed());
        chrome.close();
        chrome.quit();
    }
}
