package com.codelovers.timeset.factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PointTypeFactory {
	WebDriver driver;

	@FindBy(xpath = "//h3[@class = 'box-title']")
	WebElement boxPageTitle;

	@FindBy(id = "EditDataName")
	WebElement pointInput;

	@FindBy(xpath = "//form[@id='PointTypeAdminIndexForm']//label[Text()='新規追加']")
	WebElement addPointButton;

	@FindBy(xpath = "//form[@id='PointTypeAdminIndexForm']//label[Text()='変更']")
	WebElement updatePointButton;

	@FindBy(xpath = "//form[@id='PointTypeAdminIndexForm']//label[Text()='削除']")
	WebElement deletePointButton;

	public static final String BOX_PAGE_TITLE = "";

	public PointTypeFactory(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public String getPageTitle() {
		String actualPageTitle = driver.getTitle();
		return actualPageTitle;
	}

	public String getBoxTitle() {
		String BoxTitle = driver.getTitle();
		return BoxTitle;
	}

	public void inputAddPoint(String value) {
		pointInput.sendKeys(value);
	}

	public void clickAddPointButton() {
		addPointButton.click();
	}

	public void clickUpdatePointButton() {
		updatePointButton.click();
	}

	public void clickDeletePointButton() {
		deletePointButton.click();
	}
}
