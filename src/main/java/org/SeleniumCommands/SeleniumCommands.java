package org.SeleniumCommands;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

import java.util.Iterator;
import java.util.Set;

public class SeleniumCommands {
  public static WebDriver driver;

    public void initDriver() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://www.lenskart.com");
        driver.manage().window().maximize();
    }
    public WebElement getWebElementUsingXpath(String xpath) {
        WebElement element = SeleniumCommands.driver.findElement(By.xpath(xpath));
        return element;
    }
    public void click(String xpath) {
        WebElement element = this.getWebElementUsingXpath(xpath);
        if (element.isEnabled()) {
            element.click();
        }
    }
    public void hoverOnElement(String xpath2) {
        WebElement element = this.getWebElementUsingXpath(xpath2);
        Actions actions = new Actions(SeleniumCommands.driver);
        Action act = actions.moveToElement(element).build();
        act.perform();
    }
    public void delayScript(int seconds) {
        try {
            Thread.sleep(seconds);
        } catch (Exception e) {
        }
    }
    public void Scroll(String Filter) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement down = driver.findElement(By.xpath("//div[text()='"+Filter+"']"));
        js.executeScript("arguments[0].scrollIntoView(true)", down);
    }
    public void ScrollUp(String Filter) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement up = driver.findElement(By.xpath("//div[text()='"+Filter+"']"));
        js.executeScript("arguments[0].scrollIntoView(false)", up);
    }
    public void windowHandle() {
        Set<String> win=driver.getWindowHandles();
        Iterator<String> it=win.iterator();
        String parentId=it.next();
        String childId=it.next();
        driver.switchTo().window(childId);
    }
}
