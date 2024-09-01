package StepDefinations;

import java.io.File;
import java.io.IOException;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.asserts.SoftAssert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class MensFootware1 {

	WebDriver driver;
	private String parentWindowHandle; // Class-level declaration

	public static void capture(WebDriver driver, int n) throws IOException {
		// Step 1 : Calling takescreenshot interface and casting it to driver
		TakesScreenshot ts = (TakesScreenshot) driver;
		// Step 2 : Using getscreenshotAs() to take screenshot
		File image = ts.getScreenshotAs(OutputType.FILE);
		// Step 3 : We have to create a new File in our local machine using File class
		// by creating object.
		File img = new File("C:\\Users\\Abhisek Baral\\OneDrive\\Pictures\\Screenshots\\Screenshot2\\sc1" + n + ".png");
		FileUtils.copyFile(image, img);

	}

	@Given("Open browser, Enter naptol url")
	public void open_browser_enter_naptol_url() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.naaptol.com/");
		parentWindowHandle = driver.getWindowHandle(); // Set the parent window handle here

	}

	@Given("Mause hover and navigate to Mensfootware")
	public void mause_hover_and_navigate_to_mensfootware() throws InterruptedException, IOException {

		capture(driver, 0);// Screenshot
		WebElement shoppingCategoryElement = driver.findElement(By.cssSelector("div[id='cate_head']"));
		WebElement footBagsElement = driver
				.findElement(By.xpath("(//a[@href='/shop-online/footwear-travel-bags.html'])[1]"));
		WebElement men1Element = driver.findElement(
				By.xpath("(//a[@href='/shop-online/footwear-travel-bags/mens-footwear/footwear-combos.html'])[1]"));

		Actions actions = new Actions(driver);
		actions.moveToElement(shoppingCategoryElement).perform();
		actions.moveToElement(footBagsElement).perform();
		actions.moveToElement(men1Element).click().perform();
	}

	@Given("Navigate to persional serach")
	public void navigate_to_persional_serach() throws InterruptedException {

		WebElement caseOnElement = driver.findElement(By.cssSelector("input[id='iscod']"));
		WebElement setElement = driver.findElement(By.xpath("(//a[@class='button_1'])[1]"));
		WebElement manualPriceElement = driver.findElement(By.cssSelector("input[id='fromPriceRange']"));
		WebElement manualPriceElement2 = driver.findElement(By.cssSelector("input[id='toPriceRange']"));
		WebElement manualGoElement = driver.findElement(By.xpath("(//a[@class='button_1'])[2]"));

		caseOnElement.click();
		Thread.sleep(1000);
		setElement.click();
		Thread.sleep(1000);
		manualPriceElement.sendKeys("100");
		manualPriceElement2.sendKeys("5000");
		manualGoElement.click();
	}

	@When("Assert title")
	public void assert_title() {

		String actualTitle = driver.getTitle();
		System.out.println(actualTitle);
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertTrue(actualTitle.contains(
				"Footwear Combos Online Store in India - Buy Footwear Combos at Best Price on Naaptol Online Shopping"),
				"Title does not match!");
		softAssert.assertAll(); // Ensure all assertions are validated
	}

	@When("Click on the Product")
	public void click_on_the_product() throws InterruptedException {

		Thread.sleep(1000);
		WebElement prodImgElement = driver.findElement(By.xpath("(//div[@class='item_image'])[1]"));
		prodImgElement.click();
	}

	@When("Switch to tab")
	public void switch_to_tab() {

		Set<String> windowHandles = driver.getWindowHandles(); // This contains both parent and child window IDs

		for (String handle : windowHandles) {
			if (!handle.equals(parentWindowHandle)) {
				driver.switchTo().window(handle);
				break;
			}
		}

		WebElement quickViewElement = driver.findElement(By.xpath("//span[text()='Click here to Buy']"));
		quickViewElement.click();
	}

	@When("proceed to checkout")
	public void proceed_to_checkout() throws InterruptedException {
		Thread.sleep(1000);
		WebElement proceedElement = driver.findElement(By.xpath("(//a[text()='Proceed to Checkout'])[1]"));
		proceedElement.click();
	}

	@Then("Return to home page")
	public void return_to_home_page() throws InterruptedException {
		driver.switchTo().window(parentWindowHandle); // Switch back to the parent window
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//img[@alt='Online Shopping in India'])[2]")).click(); // Click on the home page
	}

//	-=-=-=-=-=--=-=-=-=-=-=-=-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-=--=-=--=-=-=-=-=--==-=-=-=-=-=-=-=-=-= 2ND Functionality

	@Given("Mause hover and navigate to Mensfootware2")
	public void mause_hover_and_navigate_to_mensfootware2() {

		WebElement shoppingCategoryElement = driver.findElement(By.cssSelector("div[id='cate_head']"));
		WebElement footBagsElement = driver
				.findElement(By.xpath("(//a[@href='/shop-online/footwear-travel-bags.html'])[1]"));
		WebElement men2Element = driver
				.findElement(By.xpath("(//a[@href='/shop-online/footwear-travel-bags/mens-footwear/boots.html'])[1]"));

		Actions actions = new Actions(driver);
		actions.moveToElement(shoppingCategoryElement).perform();
		actions.moveToElement(footBagsElement).perform();
		actions.moveToElement(men2Element).click().perform();

	}

	@Given("Navigate to persional serach2")
	public void navigate_to_persional_serach2() throws InterruptedException {

		WebElement caseOnElement = driver.findElement(By.cssSelector("input[id='iscod']"));
		WebElement setElement = driver.findElement(By.xpath("(//a[@class='button_1'])[1]"));
		WebElement manualPriceElement = driver.findElement(By.cssSelector("input[id='fromPriceRange']"));
		WebElement manualPriceElement2 = driver.findElement(By.cssSelector("input[id='toPriceRange']"));
		WebElement manualGoElement = driver.findElement(By.xpath("(//a[@class='button_1'])[2]"));

		caseOnElement.click();
		Thread.sleep(1000);
		setElement.click();
		Thread.sleep(1000);
		manualPriceElement.sendKeys("100");
		manualPriceElement2.sendKeys("5000");
		manualGoElement.click();

	}

	@When("Assert title2")
	public void assert_title2() {

		String actualTitle = driver.getTitle();
		System.out.println(actualTitle);
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertTrue(actualTitle
				.contains("Mens Boots - Buy Boots for Men's in India at Best Price on Naaptol Online Shopping"));
		softAssert.assertAll(); // Ensure all assertions are validated

	}

	@When("Click on the Product2")
	public void click_on_the_product2() throws InterruptedException {
		Thread.sleep(1500);
		WebElement prodImgElement = driver.findElement(By.xpath("(//div[@class='item_image'])[1]"));
		prodImgElement.click();
	}

	@When("Switch to tab2")
	public void switch_to_tab2() {

		Set<String> windowHandles = driver.getWindowHandles(); // This contains both parent and child window IDs

		String lastHandle = null;
		for (String handle : windowHandles) {
			lastHandle = handle; // Keep updating the lastHandle until the loop ends
		}

		if (lastHandle != null) {
			driver.switchTo().window(lastHandle); // Switch to the most recently opened tab
		}
	}

	@Then("Return to home page2")
	public void return_to_home_page2() throws InterruptedException {
		driver.switchTo().window(parentWindowHandle); // Switch back to the parent window
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//img[@alt='Online Shopping in India'])[2]")).click(); // Click on the home page

	}

//-=-=-=-=---==-=-=-=-=-=-==-=-=-=-=-=-=-=-=-=-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+--+-+-+-+--=-=-=-=-=-=-=-=-=-= 3RD Functionality

	@Given("Mause hover and navigate to Mensfootware3")
	public void mause_hover_and_navigate_to_mensfootware3() throws InterruptedException {

		WebElement shoppingCategoryElement = driver.findElement(By.cssSelector("div[id='cate_head']"));
		WebElement footBagsElement = driver
				.findElement(By.xpath("(//a[@href='/shop-online/footwear-travel-bags.html'])[1]"));
		WebElement men1Element = driver.findElement(
				By.xpath("(//a[@href='/shop-online/footwear-travel-bags/mens-footwear/sports-shoes.html'])[1]"));

		Actions actions = new Actions(driver);
		actions.moveToElement(shoppingCategoryElement).perform();
		actions.moveToElement(footBagsElement).perform();
		actions.moveToElement(men1Element).click().perform();
	}

	@Given("Navigate to persional serach3")
	public void navigate_to_persional_serach3() throws InterruptedException {

		WebElement caseOnElement = driver.findElement(By.cssSelector("input[id='iscod']"));
		WebElement setElement = driver.findElement(By.xpath("(//a[@class='button_1'])[1]"));
		WebElement manualPriceElement = driver.findElement(By.cssSelector("input[id='fromPriceRange']"));
		WebElement manualPriceElement2 = driver.findElement(By.cssSelector("input[id='toPriceRange']"));
		WebElement manualGoElement = driver.findElement(By.xpath("(//a[@class='button_1'])[2]"));

		caseOnElement.click();
		Thread.sleep(1000);
		setElement.click();
		Thread.sleep(1000);
		manualPriceElement.sendKeys("100");
		manualPriceElement2.sendKeys("5000");
		manualGoElement.click();
	}

	@When("Assert title3")
	public void assert_title3() {

		String actualTitle = driver.getTitle();
		System.out.println(actualTitle);
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertTrue(actualTitle.contains(
				"Mens Sports Shoes - Buy Sports Shoes for Men's in India at Best Price on Naaptol Online Shopping"),
				"Title does not match!");
		softAssert.assertAll(); // Ensure all assertions are validated
	}

	@When("Click on the Product3")
	public void click_on_the_product3() throws InterruptedException {

		Thread.sleep(1000);
		WebElement prodImgElement = driver.findElement(By.xpath("(//div[@class='item_image'])[1]"));
		prodImgElement.click();
	}

	@When("Switch to tab3")
	public void switch_to_tab3() {

		Set<String> windowHandles = driver.getWindowHandles(); // This contains both parent and child window IDs

		String lastHandle2 = null;
		for (String handle : windowHandles) {
			lastHandle2 = handle; // Keep updating the lastHandle until the loop ends
		}

		if (lastHandle2 != null) {
			driver.switchTo().window(lastHandle2); // Switch to the most recently opened tab
		}

		WebElement color = driver.findElement(By.linkText("Blue"));
		WebElement size = driver.findElement(By.linkText("8"));
		WebElement quickViewElement = driver.findElement(By.xpath("//span[text()='Click here to Buy']"));

		color.click();
		size.click();
		quickViewElement.click();
	}

	@When("proceed to checkout3")
	public void proceed_to_checkout3() throws InterruptedException, IOException {
		Thread.sleep(1000);

		WebElement proceedElement = driver.findElement(By.xpath("(//a[text()='Proceed to Checkout'])[1]"));
		capture(driver, 1);// Screenshot
		proceedElement.click();
	}

	@Then("Return to home page3")
	public void return_to_home_page3() throws InterruptedException {
		driver.switchTo().window(parentWindowHandle); // Switch back to the parent window
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//img[@alt='Online Shopping in India'])[2]")).click(); // Click on the home page
	}

//-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-+-+-+-+-+++-+-+-+-+-+-+-+-+-+-+-+--=-=-=--=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-= 4TH Functionality

	@Given("Mause hover and navigate to Mensfootware4")
	public void mause_hover_and_navigate_to_mensfootware4() {

		WebElement shoppingCategoryElement = driver.findElement(By.cssSelector("div[id='cate_head']"));
		WebElement footBagsElement = driver
				.findElement(By.xpath("(//a[@href='/shop-online/footwear-travel-bags.html'])[1]"));
		WebElement men2Element = driver.findElement(
				By.xpath("(//a[@href='/shop-online/footwear-travel-bags/mens-footwear/formal-shoes.html'])[1]"));

		Actions actions = new Actions(driver);
		actions.moveToElement(shoppingCategoryElement).perform();
		actions.moveToElement(footBagsElement).perform();
		actions.moveToElement(men2Element).click().perform();

	}

	@Given("Navigate to persional serach4")
	public void navigate_to_persional_serach4() throws InterruptedException {

		WebElement caseOnElement = driver.findElement(By.cssSelector("input[id='iscod']"));
		WebElement setElement = driver.findElement(By.xpath("(//a[@class='button_1'])[1]"));
		WebElement manualPriceElement = driver.findElement(By.cssSelector("input[id='fromPriceRange']"));
		WebElement manualPriceElement2 = driver.findElement(By.cssSelector("input[id='toPriceRange']"));
		WebElement manualGoElement = driver.findElement(By.xpath("(//a[@class='button_1'])[2]"));

		caseOnElement.click();
		Thread.sleep(1000);
		setElement.click();
		Thread.sleep(1000);
		manualPriceElement.sendKeys("100");
		manualPriceElement2.sendKeys("5000");
		manualGoElement.click();

	}

	@When("Assert title4")
	public void assert_title4() {

		String actualTitle = driver.getTitle();
		System.out.println(actualTitle);
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertTrue(actualTitle.contains(
				"Formal Shoes Online Store in India - Buy Formal Shoes at Best Price on Naaptol Online Shopping"));
		softAssert.assertAll(); // Ensure all assertions are validated

	}

	@When("Click on the Product4")
	public void click_on_the_product4() throws InterruptedException {
		Thread.sleep(1000);
		WebElement prodImgElement = driver.findElement(By.xpath("(//div[@class='item_image'])[1]"));
		prodImgElement.click();
	}

	@When("Switch to tab4")
	public void switch_to_tab4() {

		Set<String> windowHandles = driver.getWindowHandles(); // This contains both parent and child window IDs

		String lastHandle3 = null;
		for (String handle : windowHandles) {
			lastHandle3 = handle; // Keep updating the lastHandle until the loop ends
		}

		if (lastHandle3 != null) {
			driver.switchTo().window(lastHandle3); // Switch to the most recently opened tab
		}
	}

	@Then("Return to home page4")
	public void return_to_home_page4() throws InterruptedException {
		driver.switchTo().window(parentWindowHandle); // Switch back to the parent window
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//img[@alt='Online Shopping in India'])[2]")).click(); // Click on the home page

	}

	// -=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-+-+-+-+-+++-+-+-+-+-+-+-+-+-+-+-+--=-=-=--=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
	// 5TH Functionality

	@Given("Mause hover and navigate to Mensfootware5")
	public void mause_hover_and_navigate_to_mensfootware5() {

		WebElement shoppingCategoryElement = driver.findElement(By.cssSelector("div[id='cate_head']"));
		WebElement footBagsElement = driver
				.findElement(By.xpath("(//a[@href='/shop-online/footwear-travel-bags.html'])[1]"));
		WebElement men2Element = driver.findElement(
				By.xpath("(//a[@href='/shop-online/footwear-travel-bags/mens-footwear/sandals.html'])[1]"));

		Actions actions = new Actions(driver);
		actions.moveToElement(shoppingCategoryElement).perform();
		actions.moveToElement(footBagsElement).perform();
		actions.moveToElement(men2Element).click().perform();

	}

	@Given("Navigate to persional serach5")
	public void navigate_to_persional_serach5() throws InterruptedException {

		WebElement setElement = driver.findElement(By.xpath("(//a[@class='button_1'])[1]"));
		WebElement manualPriceElement = driver.findElement(By.cssSelector("input[id='fromPriceRange']"));
		WebElement manualPriceElement2 = driver.findElement(By.cssSelector("input[id='toPriceRange']"));
		WebElement manualGoElement = driver.findElement(By.xpath("(//a[@class='button_1'])[2]"));

		setElement.click();
		Thread.sleep(1000);
		manualPriceElement.sendKeys("100");
		manualPriceElement2.sendKeys("5000");
		manualGoElement.click();

	}

	@When("Assert title5")
	public void assert_title5() {

		String actualTitle = driver.getTitle();
		System.out.println(actualTitle);
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertTrue(actualTitle
				.contains("Sandals Online Store in India - Buy Sandals at Best Price on Naaptol Online Shopping"));
		softAssert.assertAll(); // Ensure all assertions are validated

	}

	@When("Click on the Product5")
	public void click_on_the_product5() throws InterruptedException {
		Thread.sleep(1000);
		WebElement prodImgElement = driver.findElement(By.xpath("(//div[@class='item_image'])[1]"));
		prodImgElement.click();
	}

	@When("Switch to tab5")
	public void switch_to_tab5() {

		Set<String> windowHandles = driver.getWindowHandles(); // This contains both parent and child window IDs

		String lastHandle4 = null;
		for (String handle : windowHandles) {
			lastHandle4 = handle; // Keep updating the lastHandle until the loop ends
		}

		if (lastHandle4 != null) {
			driver.switchTo().window(lastHandle4); // Switch to the most recently opened tab
		}
	}

	@Then("Return to home page5")
	public void return_to_home_page5() throws InterruptedException, IOException {
		driver.switchTo().window(parentWindowHandle); // Switch back to the parent window
		Thread.sleep(1000);
		capture(driver, 2);// Screenshot
		driver.findElement(By.xpath("(//img[@alt='Online Shopping in India'])[2]")).click(); // Click on the home page

		driver.quit();
	}

}
