package pages;

import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AbstractPage {

	WebDriver driver;

	public void openURL(WebDriver driver, String url) {
		driver.get(url);
	}

	public String getURL(WebDriver driver) {
		return driver.getCurrentUrl();
	}

	public String getTitle(WebDriver driver) {
		return driver.getTitle();
	}

	public void backURL(WebDriver driver) {
		driver.navigate().back();
	}

	public void forwardURL(WebDriver driver) {
		driver.navigate().refresh();
	}

	public void refreshURL(WebDriver driver) {
		driver.navigate().refresh();
	}

	public void clickToElement(WebDriver driver, String locator) {
		WebElement element = driver.findElement(By.xpath(locator));
		element.click();
	}

	public void clickToElement(WebDriver driver, String locator, String value) {
		locator = String.format(locator, value);
		WebElement element = driver.findElement(By.xpath(locator));
		element.click();
	}

	public void sendkeyToElement(WebDriver driver, String locator, String value) {
		WebElement element = driver.findElement(By.xpath(locator));
		element.clear();
		element.sendKeys(value);
	}

	public String getTextOfElement(WebDriver driver, String locator) {
		WebElement element = driver.findElement(By.xpath(locator));
		return element.getText();
	}

	public String getTextOfElement(WebDriver driver, String locator, String value) {
		locator = String.format(locator, value);
		WebElement element = driver.findElement(By.xpath(locator));
		return element.getText();
	}

	public String getAttributeOfElement(WebDriver driver, String locator) {
		WebElement element = driver.findElement(By.xpath(locator));
		return element.getAttribute(locator);
	}

	public void uncheckTheCheckbox(WebDriver driver, String locator) {
		WebElement element = driver.findElement(By.xpath(locator));
		if (element.isSelected()) {
			element.click();
		}
	}

	public boolean isControlDisplayed(WebDriver driver, String locator) {
		WebElement element = driver.findElement(By.xpath(locator));
		return element.isDisplayed();
	}

	public boolean isControlDisplay(WebDriver driver, String locator, String value) {
		locator = String.format(locator, value);
		WebElement element = driver.findElement(By.xpath(locator));
		return element.isDisplayed();
	}

	public boolean isControlSelected(WebDriver driver, String locator) {
		WebElement element = driver.findElement(By.xpath(locator));
		return element.isSelected();
	}

	public boolean isControlSelected(WebDriver driver, String locator, String value) {
		locator = String.format(locator, value);
		WebElement element = driver.findElement(By.xpath(locator));
		return element.isSelected();
	}

	public boolean isEnableElement(WebDriver driver, String locator) {
		WebElement element = driver.findElement(By.xpath(locator));
		return element.isEnabled();
	}

	public boolean isEnableElement(WebDriver driver, String locator, String value) {
		locator = String.format(locator, value);
		WebElement element = driver.findElement(By.xpath(locator));
		return element.isEnabled();
	}

	public void selectItemInDropdown(WebDriver driver, String locator, String value) {
		Select element = new Select(driver.findElement(By.xpath(locator)));
		element.deselectByVisibleText(value);
	}

	public String verifyDropdownSelected(WebDriver driver, String locator) {
		WebElement element = driver.findElement(By.xpath(locator));
		Select dropdownSelected = new Select(element);
		return dropdownSelected.getFirstSelectedOption().getText();
	}

	public void aceptAlert(WebDriver driver, String locator) {
		WebElement element = driver.findElement(By.xpath(locator));
		element.click();
		Alert alert = driver.switchTo().alert();
		alert.accept();
	}

	public void cancelAlert(WebDriver driver, String locator) {
		WebElement element = driver.findElement(By.xpath(locator));
		element.click();
		Alert alert = driver.switchTo().alert();
		alert.dismiss();
	}

	public String getTextAlert(WebDriver driver, String locator) {
		WebElement element = driver.findElement(By.xpath(locator));
		element.click();
		Alert alert = driver.switchTo().alert();
		return alert.getText();
	}

	public void sendkeyToAlert(WebDriver driver, String locator, String value) {
		WebElement element = driver.findElement(By.xpath(locator));
		element.click();
		Alert alert = driver.switchTo().alert();
		alert.sendKeys(value);
	}

	public Boolean selectByVisibleText(WebDriver driber, String locator, String expectedText) {
		WebElement element = driber.findElement(By.xpath(locator));
		String actualText = element.getText();
		return actualText.equals(expectedText);
	}

	public void switchWindowByID(WebDriver driver, String parent) {
		Set<String> allwindows = driver.getWindowHandles();
		for (String childWindows : allwindows) {
			if (!childWindows.equals(parent)) {
				driver.switchTo().window(childWindows);
				break;
			}
		}
	}

	public void switchWindowByTitle(WebDriver driver, String title) {
		Set<String> allWindows = driver.getWindowHandles();
		for (String childWindows : allWindows) {
			driver.switchTo().window(childWindows);
			String childTitle = driver.getTitle();
			if (childTitle.equals(title)) {
				break;
			}
		}
	}

	public void switchToIframe(WebDriver driver, String locator) {
		WebElement iframe = driver.findElement(By.xpath(locator));
		if (iframe.isDisplayed()) {
			driver.switchTo().frame(iframe);
		}
	}

	public void doubleClick(WebDriver driver, String locator) {
		WebElement element = driver.findElement(By.xpath(locator));
		Actions action = new Actions(driver);
		action.moveToElement(element).doubleClick().build().perform();
	}

	public void hoverMouse(WebDriver driver, String locator) {
		WebElement element = driver.findElement(By.xpath(locator));
		Actions action = new Actions(driver);
		action.moveToElement(element).build().perform();
	}

	public void rightClick(WebDriver driver, String locator) {
		WebElement element = driver.findElement(By.xpath(locator));
		Actions action = new Actions(driver);
		action.contextClick(element).perform();
	}

	public void drapAndDrop(WebDriver driver, String locatorSource, String locatorTarget) {
		WebElement source = driver.findElement(By.xpath(locatorSource));
		WebElement target = driver.findElement(By.xpath(locatorTarget));
		Actions action = new Actions(driver);
		action.dragAndDrop(source, target).build().perform();
	}

	public void keyPress(WebDriver driver, String locator) {
		WebElement element = driver.findElement(By.xpath(locator));
		Actions action = new Actions(driver);
		action.keyDown(element, Keys.CONTROL).build();
	}

	public void upload(WebDriver driver, String locator, String linkSetup, String filePath) throws Exception {
		WebElement element = driver.findElement(By.xpath(locator));
		element.click();
		Thread.sleep(3000);
		Runtime.getRuntime().exec(new String[] { linkSetup, filePath });
	}

	public Object excuteJavascriptToBrowser(WebDriver driver, String javaScript) {
		try {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			return js.executeScript(javaScript);
		} catch (Exception e) {
			e.getMessage();
			return null;
		}
	}

	public Object executeJavaScriptToElement(WebDriver driver, String javaScript, String locator) {
		try {
			WebElement element = driver.findElement(By.xpath(locator));
			JavascriptExecutor js = (JavascriptExecutor) driver;
			return js.executeScript(javaScript, element);
		} catch (Exception e) {
			e.getMessage();
			return null;
		}
	}

	public void scrollToBottom(WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
	}

	public void scrollToElement(WebDriver driver, String locator) {
		WebElement element = driver.findElement(By.xpath(locator));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
	}

	public void clickToElement_JE(WebDriver driver, String locator) {
		WebElement element = driver.findElement(By.xpath(locator));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", element);
	}

	public void waitForControlPresence(WebDriver driver, String locator) {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator)));
	}

	public void waitForControlVisible(WebDriver driver, String locator) {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
	}

	public void waitForControlClickAble(WebDriver driver, String locator) {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(locator)));
	}

	public boolean waitForContolNotVisible(WebDriver driver, String locator) {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		return wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(locator)));
	}

	public Object removeAttributeInDOM(WebDriver driver, String controlName, String attribute) {
		try {
			WebElement element = driver.findElement(By.xpath(controlName));
			JavascriptExecutor js = (JavascriptExecutor) driver;
			return js.executeScript("arguments[0].removeAttribute('" + attribute + "');", element);
		} catch (Exception e) {
			e.getMessage();
			return null;
		}
	}

}
