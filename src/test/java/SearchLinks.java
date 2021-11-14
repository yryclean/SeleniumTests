import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class SearchLinks {


    @Test
    public void searchLink() throws InterruptedException {
        WebDriver chrome = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(chrome, 5);
        chrome.get("https://the-internet.herokuapp.com/");

        List<WebElement> search = chrome.findElements(By.tagName("a"));
        System.out.println(search.size());

        for (int i = 0; i < search.size(); i++) {
            System.out.println(search.get(i).getText());
        }
        WebElement linkN = chrome.findElement(By.linkText("Digest Authentication"));
        linkN.click();

        Thread.sleep(3000);

        chrome.close();
        chrome.quit();
    }
}