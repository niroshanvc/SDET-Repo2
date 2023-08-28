package utils;


import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class BasePage {
	private WebDriver driver;

	public BasePage(WebDriver driver) {
		this.driver = driver;
	}

	public void waitUntilElementVisible(int seconds, By byLocator) {
		WebDriverWait wait = new WebDriverWait(driver, seconds);
		wait.until(ExpectedConditions.visibilityOfElementLocated(byLocator));
	}

	public void waitUntilPresenceOfElementLocated(int seconds, By byLocator) {
		WebDriverWait wait = new WebDriverWait(driver, seconds);
		wait.until(ExpectedConditions.presenceOfElementLocated(byLocator));
	}

	public void clickWithJavaScript(By locator) {
		WebElement ele = getElement(locator);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", ele);
	}

	public WebElement getElement(By locator) {
		return driver.findElement(locator);
	}

	public List<WebElement> findAllElements(By locator) {
		return driver.findElements(locator);
	}

	public void acceptAllCookies() {
		waitUntilPresenceOfElementLocated(30, By.id("onetrust-accept-btn-handler"));
		clickWithJavaScript(By.id("onetrust-accept-btn-handler"));
	}
	
	public void closeBrowser() {
        if (driver != null) {
            driver.quit();
        }
    }
}
