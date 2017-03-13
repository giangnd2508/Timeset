package com.codelovers.timeset.action;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class WebdriverAction {

	private WebDriver driver;

	public WebdriverAction(WebDriver driver) {
		this.driver = driver;
	}

	private By getBy(String locator) {
		By by = null;
		if (locator.startsWith("id=")) {

			locator.substring(3);
			by = By.id(locator);

		} else if (locator.startsWith("name=")) {

			locator.substring(5);
			by = By.name(locator);

		} else if (locator.startsWith("css=")) {

			locator.substring(4);
			by = By.cssSelector(locator);

		} else if (locator.startsWith("link=")) {

			locator.substring(5);
			by = By.linkText(locator);

		} else if (locator.startsWith("xpath=")) {

			by = By.xpath(locator);

		} else {
			System.out.println("Error: Executing | format does not support ");
		}
		return by;
	}

	public WebElement getWebElement(String locator) {
		return driver.findElement(getBy(locator));
	}

	public void click(String locator) {
		WebElement element = getWebElement(locator);
		element.click();
	}

	public void senKeys(String locator, String value) {
		WebElement element = getWebElement(locator);
		element.sendKeys(value);
	}

	public String getText(String locator) {
		WebElement element = getWebElement(locator);
		return element.getText();
	}

	public void close() {
		driver.close();
	}

	public void open(String url) {
		driver.get(url);
	}
}
