package AutomationJourney2019.WEBSites.Pages;

import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

public class PageBase {
	protected WebDriver driver;
	private JavascriptExecutor jse;
	private Actions action;
	
	public PageBase (WebDriver driver) 
	{
		PageFactory.initElements(driver, this);
	}
	
	protected static void clickButton(WebElement button) {
		if (button != null) {
			button.click();
		}
	}
	protected static void setTextElementText(WebElement textElement, String value) {
		if (textElement != null) {
			textElement.sendKeys(value);
		}
	}

	protected static void losefocusOfTextBox(WebElement textElement) {
		if (textElement != null) {
			textElement.sendKeys(Keys.TAB);
		}
	}
	
	public void scrollToBottom() {
		jse.executeScript("scrollBy(0,2500)");
	}
	
	public void scrollUP() {
		jse.executeScript("window.scrollBy(0,-2500)");
	}
	
	public void scrollToVisibilityOfElement(WebElement Element) {
		jse.executeScript("arguments[0].scrollIntoView(true);", Element);
	}
	
	public void clearText(WebElement Element) {
		if (Element != null) {
			Element.clear();
		}
	}
	public void refreshPage() {
		driver.navigate().refresh();
	}
	
	@SuppressWarnings("deprecation")
	public void waitForElementToBe(final String condition,final WebElement Element) {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
				.withTimeout(10, TimeUnit.SECONDS)
				.pollingEvery(2, TimeUnit.SECONDS)
				.ignoring(NoSuchElementException.class);
		switch (condition) {
		case "invisibilityOf":
			wait.until(ExpectedConditions.invisibilityOf(Element));
			break;
		case "elementToBeClickable":
			wait.until(ExpectedConditions.elementToBeClickable(Element));
			break;
		case "visibilityOf":
			wait.until(ExpectedConditions.visibilityOf(Element));
			break;
		default:
			break;
		}				
	}
	public void openPageURL(URL url) {
		driver.navigate().to(url);
	}
	public Boolean isElementPresent(By by) {
		try {
			driver.findElement(by);
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}
	}
}
