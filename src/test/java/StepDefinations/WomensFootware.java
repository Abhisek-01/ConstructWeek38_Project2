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

public class WomensFootware {

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

	@Given("Open browser, Enter the naptol url")
	public void open_browser_enter_the_naptol_url() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.naaptol.com/");
		parentWindowHandle = driver.getWindowHandle(); // Set the parent window handle here
	}

	@Given("Mause hover and navigate to Womensfootware")
	public void mause_hover_and_navigate_to_womensfootware() throws InterruptedException, IOException {

		WebElement shoppingCategoryElement = driver.findElement(By.cssSelector("div[id='cate_head']"));
		WebElement footBagsElement = driver
				.findElement(By.xpath("(//a[@href='/shop-online/footwear-travel-bags.html'])[1]"));
		WebElement men1Element = driver.findElement(
				By.xpath("(//a[@href='/shop-online/footwear-travel-bags/womens-footwear/womens-sandals.html'])[1]"));

		capture(driver, 2);// Screenshot
		Actions actions = new Actions(driver);
		actions.moveToElement(shoppingCategoryElement).perform();
		actions.moveToElement(footBagsElement).perform();
		actions.moveToElement(men1Element).click().perform();
	}

	@Given("Navigate to persional serach section")
	public void navigate_to_persional_serach_section() throws InterruptedException {

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

	@When("Assert title for womens")
	public void assert_title_for_womens() {

		String actualTitle = driver.getTitle();
		System.out.println(actualTitle);
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertTrue(
				actualTitle.contains(
						"Womens Sandals - Buy Ladies Sandals Online in India at Best Price on Naaptol Online Shopping"),
				"Title does not match!");
		softAssert.assertAll(); // Ensure all assertions are validated
	}

	@When("Click on the women Product")
	public void click_on_the_women_product() throws InterruptedException {

		Thread.sleep(1000);
		WebElement prodImgElement = driver.findElement(By.xpath("(//div[@class='item_image'])[1]"));
		prodImgElement.click();
	}

	@When("Switch to tab1")
	public void switch_to_tab1() {

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

	@When("proceed to checkout sandel")
	public void proceed_to_checkout_sandel() throws InterruptedException {
		Thread.sleep(1000);
		WebElement proceedElement = driver.findElement(By.xpath("(//a[text()='Proceed to Checkout'])[1]"));
		proceedElement.click();
	}

	@Then("Return to main tab page")
	public void return_to_main_tab_page() throws InterruptedException, IOException {
		driver.switchTo().window(parentWindowHandle); // Switch back to the parent window
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//img[@alt='Online Shopping in India'])[2]")).click(); // Click on the home page
		capture(driver, 2);// Screenshot
		driver.quit();
	}

}
