package com.codelovers.timeset.factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class A1ArticleListFactory {
	WebDriver driver;

	@FindBy(xpath = "//div[@id='btn-box']/a")
	WebElement addArticleButton;

	@FindBy(id = "action")
	WebElement dropdownAction;

	@FindBy(id = "doaction")
	WebElement actionButton;

	@FindBy(xpath = ".//*[@id='filter-subsubsub']")
	WebElement allPostButton;

	@FindBy(xpath = ".//*[@id='filter-by-date']")
	WebElement date;

	@FindBy(id = "cat")
	WebElement category;

	@FindBy(xpath = "//input[@name='search_param']")
	WebElement searchBar;

	@FindBy(xpath = "//button[@type='submit']")
	WebElement searchButton;

	@FindBy(id = "post-query-submit")
	WebElement queryPost;

	@FindBy(xpath = "//a[contains(text(),'タイトル')]")
	WebElement titleSort;

	@FindBy(xpath = "//a[contains(text(),'著作権')]")
	WebElement authorSort;

	@FindBy(xpath = "//a[contains(text(),'日付')]")
	WebElement dateSort;

	@FindBy(xpath = "//input[@id='checkDeleteAll']")
	WebElement selectAll;

	@FindBy(xpath = "//input[@id='checkDeleteAllBottom']")
	WebElement selectAllBottom;

	@FindBy(xpath = "//input[@id='50']")
	WebElement selectItem1;

	@FindBy(xpath = ".//*[@id='table-list']//tbody/tr[1]//td[6]/a[1]")
	WebElement editItem1;

	@FindBy(xpath = ".//*[@id='table-list']//tbody/tr[1]//td[6]/a[2]")
	WebElement previewItem1;

	@FindBy(xpath = ".//*[@id='table-list']//tbody/tr[1]//td[6]/a[3]")
	WebElement deleteItem1;

	public static final String ARTICLE_LIST = "記事一覧";
	public static final String NEW_ARTICLE = "新規追加";
	public static final String DELETE = "削除";
	public static final String BULK = "一括";
	public static final String ALL_ARTICLE = "全て";
	public static final String PUBLIC_ARTICLE = "公共";
	public static final String DRAFT_ARTICLE = "下書き";
	public static final String ALL_DAY = "すべての日";
	public static final String COPYRIGHTS = "著作権";
	public static final String DATE = "日付";
	public static final String TITLE = "タイトル";
	public static final String PREVIEW = "プレビュー";
	public static final String EDIT = "編集";

	public A1ArticleListFactory(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void selectBulk() {
		Select action = new Select(dropdownAction);
		action.selectByValue(BULK);
	}

	public void selectDelete() {
		Select action = new Select(dropdownAction);
		action.selectByValue(DELETE);
	}

	// ArticleList Function

	public void clickAddArticleButton() {
		addArticleButton.click();
	}

	public void clickActionButton() {
		actionButton.click();
	}

	public void selectAllPost() {
		Select select = new Select(allPostButton);
		select.selectByIndex(0);
	}

	public void selectPublishedPost() {
		Select select = new Select(allPostButton);
		select.selectByIndex(1);
	}

	public void selectDraftPost() {
		Select select = new Select(allPostButton);
		select.selectByIndex(2);
	}

	public void clickQueryPost() {
		queryPost.click();
	}

	public void clickAuthorSort() {
		authorSort.click();
	}

	public void clickTitleSort() {
		titleSort.click();
	}

	public void clickDateSort() {
		dateSort.click();
	}

	public void clickselectAll() {
		selectAll.click();
	}

	public void clickselectAllBottom() {
		selectAllBottom.click();
	}

	public void clickSelectItem1() {
		selectItem1.click();
	}

	public void clickEditItem1() {
		editItem1.click();
	}

	public void clickPreviewItem1() {
		previewItem1.click();
	}

	public void clickSearchButton() {
		searchButton.click();
	}

	public void sendKeysSearchBar(String value) {
		searchBar.clear();
		searchBar.sendKeys(value);
	}

	

}
