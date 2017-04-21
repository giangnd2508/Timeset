package com.codelovers.timeset.factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class A2AddPostFactory {
	WebDriver driver;

	@FindBy(xpath = "//h3[@class = 'box-title']")
	WebElement boxPageTitle;

	@FindBy(xpath = "//form[@id='post-validate']//label[Text()='タイトル']']")
	WebElement aritleTitle;

	@FindBy(id = "PostTitle")
	WebElement postTitleInput;

	@FindBy(xpath = "//form[@id='post-validate']//label[Text()='短い説明']")
	WebElement descriptionTitle;

	@FindBy(id = "PostShortDescription")
	WebElement descriptionInput;

	@FindBy(xpath = ".//div[@id='media']/div[1]")
	WebElement addMedia1;

	@FindBy(id = "tinymce")
	WebElement contentInput;

	@FindBy(xpath = "//form[@id='post-validate']//h3[text()='公開']")
	WebElement releaseTitle;

	@FindBy(xpath = ".//form[@id='post-validate']//input[@value='下書きとして保存']")
	WebElement saveDraftButton;

	@FindBy(xpath = ".//form[@id='post-validate']//input[@value='公開']")
	WebElement publishButton;

	@FindBy(xpath = "//h3[@class = 'box-title']")
	WebElement categoryTitle;

	@FindBy(xpath = ".//*[@id='add-category']//input[@type='checkbox']")
	WebElement category1;

	@FindBy(id = "show-hidden-form")
	WebElement showAndHideCategoryButton;

	@FindBy(id = "newcategory")
	WebElement newCategoryInput;

	@FindBy(id = "newcategory_parent")
	WebElement categoryDropdown;

	@FindBy(id = "add-category-ajax")
	WebElement addNewCategoryButton;

	@FindBy(xpath = "//div[@id='post-validate']//h3[text()='アイキャッチ画像']")
	WebElement addMediaTitle;

	@FindBy(xpath = "//*[@id='media']/a")
	WebElement addMedia2;

	public static final String PAGE_TITLE = "新規投稿";
	public static final String BOX_PAGE_TITLE = "新規投稿";
	public static final String POST_TITLE = "タイトル";
	public static final String POST_DESCRIPTION = "短い説明";
	public static final String ADD_MEDIA_1 = " メディアを追加";
	public static final String RELEASE_TITLE = "公開";
	public static final String SAVE_DRAFT_BUTTON = "下書きとして保存";
	public static final String PUBLISH_BUTTON = "カテゴリー";
	public static final String CATEGOTY_TITLE = "公開";
	public static final String SHOW_AND_HIDE_CATEGORY_BUTTON = "新規カテゴリーを追加";
	public static final String ADD_NEW_CATEGORY = "新規カテゴリーを追加";
	public static final String ADD_MEDIA_TITLE = "アイキャッチ画像";
	public static final String ADD_MEDIA_2 = "アイキャッチ画像を設定";

	public static final String DATA_100_CHAR = "Hiệp hội taxi TPHCM vừa có văn bản cảm ơn Bộ Tài chính đã giải đáp kịp thời những kiến nghị của hiệp";
	public static final String DATA_101_CHAR = "Hiệp hội taxi TPHCM vừa có văn bản cảm ơn Bộ Tài chính đã giải đáp kịp thời những kiến nghị của hiệp ";
	public static final String DATA_255_CHAR = "Hiệp hội taxi TPHCM vừa có văn bản cảm ơn Bộ Tài chính đã giải đáp kịp thời những kiến nghị của hiệp hội này về chính sách thuế đối với hoạt động taxi.Trước đó, do yêu cầu của các hãng taxi, hồi tháng 1/2017, Hiệp hội taxi TPHCM đã có văn bản gửi tới Bộ 1";
	public static final String DATA_256_CHAR = "1Hiệp hội taxi TPHCM vừa có văn bản cảm ơn Bộ Tài chính đã giải đáp kịp thời những kiến nghị của hiệp hội này về chính sách thuế đối với hoạt động taxi.Trước đó, do yêu cầu của các hãng taxi, hồi tháng 1/2017, Hiệp hội taxi TPHCM đã có văn bản gửi tới Bộ 1";

	public A2AddPostFactory(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void senkeysPostTitle(String title) {
		postTitleInput.clear();
		postTitleInput.sendKeys(title);
	}

	public void senkeysDescription(String description) {
		descriptionInput.clear();
		descriptionInput.sendKeys(description);
	}

	public void senkeysContent(String content) {
		driver.switchTo().frame(0);
		contentInput.clear();
		contentInput.sendKeys(content);
		driver.switchTo().defaultContent();
	}

	public void clickSaveDraftButton() {
		saveDraftButton.click();
	}

	public void clickPublishButton() {
		publishButton.click();
	}

	public void clickSelectCategory() {
		category1.click();
	}

	public void clickShowAndHideCategory() {
		showAndHideCategoryButton.click();
	}

	public void sendKeysNewCategory(String newCategory) {
		newCategoryInput.sendKeys(newCategory);
	}

	public void clickAddNewCategory() {
		addNewCategoryButton.click();
	}

	public void clickAddMedia1() {
		addMedia1.click();
	}

	public void clickAddMedia2() {
		addMedia2.click();
	}

	public void selectCategory(int index) {
		Select CategorySelect = new Select(categoryDropdown);
		CategorySelect.selectByIndex(index);
	}

	public void selectCategory(String categoryName) {
		Select CategorySelect = new Select(categoryDropdown);
		CategorySelect.selectByValue(categoryName);
	}

	public String getPageTitle() {
		String actualPageTitle = driver.getTitle();
		return actualPageTitle;
	}
}
