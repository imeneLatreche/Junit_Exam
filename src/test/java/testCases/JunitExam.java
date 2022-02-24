package testCases;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import pageObjects.WelcomePage;

public class JunitExam extends BaseClassJunit {

	// Question 1: Validate when the toggle all check box is CHECKED, all check
	// boxes for list items are also CHECKED ON.
	@Test
	public void question1() throws IOException, InterruptedException {

		WelcomePage wpage = new WelcomePage(driver);
		if (driver.getPageSource().contains("Warning")) {
			addNItems(1);
			Thread.sleep(2000);
			driver.navigate().refresh();
			Thread.sleep(2000);
			addNItems(4);
		} else {
			// --Adding five Items
			addNItems(5);
		}
		// getting the size of the list of items
		int numberOfAllItems = getNumberOfAllItems();

		// Click toggleAll button
		wpage.clickToggleAllButton();

		// Checking if all the items are checked individually
		allItemsChecked(numberOfAllItems);

		Thread.sleep(1500);
	}

	// Question 2: Validate that a single list item could be removed using the
	// remove button when a single checkbox is selected.
	@Test
	public void question2() throws InterruptedException {
		
		// Getting the number of item listed
		int n = getNumberOfAllItems();
		
		// Getting item description
		WelcomePage wpage = new WelcomePage(driver);
		String element1 = driver.findElement(By.xpath("//*[@id=\'todos-content\']/form/ul/li[1]")).getText();
		element1 = element1.substring(2, element1.length());

		// Checking first item is present before removal
		Assert.assertTrue("Element not Present before removal", driver.getPageSource().contains(element1));

		// Removing single item
		wpage.clickRadioButtonFirstItem();
		wpage.clickRemoveButton();

		// Checking item removed not present
		Assert.assertFalse("Element Present After Removal", driver.getPageSource().contains(element1));
		
		// Double checking by the number of items
		Assert.assertEquals("number of items didn't decrease!!",(n - 1),getNumberOfAllItems());
		Thread.sleep(1500);
	}

	// Question 3: Validate that all list item could be removed using the remove
	// button and when "Toggle All" functionality is on.
	@Test
	public void question3() throws InterruptedException {
		WelcomePage wpage = new WelcomePage(driver);
		
		// Removing all item with toggleAll button
		wpage.clickToggleAllButton();
		wpage.clickRemoveButton();
		driver.navigate().refresh();
		
		//Validation of the removal of all elements
		if (getNumberOfAllItems() == 0) {
			Assert.assertTrue(true);
		} else {
			Assert.assertTrue(false);
		}
		Thread.sleep(1500);
	}

	// captureScreen(driver,"question1");

	/*---------------------- helper methods------------------------*/
	public void addItem(String itemName, String category, String dueDay, String dueMonth, String dueYear) {
		WelcomePage wpage1 = new WelcomePage(driver);
		wpage1.setListItem(itemName);
		wpage1.setCategory(category);
		wpage1.setDueDay(dueDay);
		wpage1.setDueMonth(dueMonth);
		wpage1.setDueYear(dueYear);
		wpage1.clickAddButton();
	}

	public void allItemsChecked(int size) {
		for (int i = 1; i <= size; i++) {
			WebElement radio = driver.findElement(By.xpath("//*[@id=\'todos-content\']/form/ul/li[" + i + "]/input"));
			Assert.assertTrue(radio.isSelected());
		}
	}

	public void addNItems(int N) throws InterruptedException {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern(" mm:ss");
		LocalDateTime now = LocalDateTime.now();
		// Adding items
		for (int i = 0; i < N; i++) {
			addItem("Item" + i + dtf.format(now), "abc", "1", "Dec", "2021");
		}
	}

	public int getNumberOfAllItems() {
		List<WebElement> allItems = driver.findElements(By.xpath("//*[@id=\'todos-content\']/form/ul/li"));
		int numberOfItems = allItems.size();
		return numberOfItems;
	}

	public List<WebElement> getAllItems() {
		List<WebElement> allItems = driver.findElements(By.xpath("//*[@id=\'todos-content\']/form/ul/li"));
		return allItems;
	}

}
