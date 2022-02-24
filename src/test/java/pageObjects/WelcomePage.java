package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class WelcomePage {
	WebDriver ldriver;

	public WelcomePage(WebDriver rdriver) {
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}

	@FindBy(xpath = "/html/body/div[3]/input[1]")
	WebElement removeButton;

	@FindBy(name = "allbox")
	WebElement toggleAllButton;

	@FindBy(xpath = "/html/body/div[4]/input[1]")
	WebElement addListItemDataField;

	@FindBy(name = "category")
	WebElement categoryDropdown;

	@FindBy(name = "due_day")
	WebElement dueDayDropdown;

	@FindBy(name = "due_month")
	WebElement dueMonthDropdown;

	@FindBy(name = "due_year")
	WebElement dueYearDropdown;

	@FindBy(xpath = "/html/body/div[4]/input[2]")
	WebElement addButton;

	@FindBy(name = "categorydata")
	WebElement categoryDataField;

	@FindBy(xpath = "//*[@id='extra']/input[2]")
	WebElement addCategoryButton;

	@FindBy(name = "colour")
	WebElement colorDropdown;

	@FindBy(xpath = "//*[@id=\'extra\']/button[1]")
	WebElement setSkyBlueBackgroundButton;

	@FindBy(xpath = "//*[@id=\'extra\']/button[2]")
	WebElement setWhiteBackgroundButton;

	@FindBy(xpath = "//*[@id=\'todos-content\']/form/ul/li[1]/input")
	WebElement radioButtonFirstItem;

	public void setListItem(String itemName) {
		addListItemDataField.sendKeys(itemName);
	}

	public void setCategory(String category) {
		Select drpCategory = new Select(categoryDropdown);
		drpCategory.selectByVisibleText(category);
	}

	public void setDueDay(String dueDay) {
		Select drpDay = new Select(dueDayDropdown);
		drpDay.selectByVisibleText(dueDay);
	}

	public void setDueMonth(String dueMonth) {
		Select drpMonth = new Select(dueMonthDropdown);
		drpMonth.selectByVisibleText(dueMonth);
	}

	public void setDueYear(String dueYear) {
		Select drpYear = new Select(dueYearDropdown);
		drpYear.selectByVisibleText(dueYear);
	}

	public void clickAddButton() {
		addButton.click();
	}

	public void setCategoryDataField(String newCategory) {
		categoryDataField.sendKeys(newCategory);
	}

	public void setColor(String color) {
		Select drpColor = new Select(colorDropdown);
		drpColor.selectByVisibleText(color);
	}

	public void clickAddCategoryButton() {
		addCategoryButton.click();
	}

	public void clickSetSkyBlueBackgroundButton() {
		setSkyBlueBackgroundButton.click();
	}

	public void clickSetWhiteBackgroundButton() {
		setWhiteBackgroundButton.click();
	}

	public void clickRemoveButton() {
		removeButton.click();
	}

	public void clickToggleAllButton() {
		toggleAllButton.click();
	}

	public void clickRadioButtonFirstItem() {
		radioButtonFirstItem.click();
	}
}
