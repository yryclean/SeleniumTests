import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Authentication {

    @Test
    public void Auth() throws InterruptedException {
        WebDriver chrome = new ChromeDriver();
//        WebDriverWait waitLoad = new WebDriverWait(chrome, 5);

        String username = "admin";
        String password = "admin";

        String URL = "https://" +username +":" +password +"@"+ "the-internet.herokuapp.com/digest_auth";
        chrome.get(URL);

        WebElement successLog = chrome.findElement(By.cssSelector("#content > div > h3"));
        successLog.getAccessibleName();

        System.out.println(successLog.getAccessibleName());

        Assert.assertEquals("Digest Auth", "Digest nAuth");

        chrome.close();
        chrome.quit();

    }

}

