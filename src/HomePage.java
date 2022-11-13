import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class HomePage {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "D:\\my chrome driver\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();

		driver.get("https://www.saucedemo.com");

		driver.manage().window().maximize();

		Thread.sleep(2000);

		String user_name = "standard_user";
		String password = "secret_sauce";

		driver.findElement(By.xpath("//*[@id=\"user-name\"]")).sendKeys(user_name);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys(password);
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id=\"login-button\"]")).click();

		String actualTitle = driver.getTitle();

		String expectedTitel = "Swag Labs";

		Assert.assertEquals(actualTitle, expectedTitel);

		List<WebElement> addCart = driver.findElements(By.className("btn"));
		for (int i = 0; i < addCart.size(); i++) {
			addCart.get(i).click();
		}

		String actualAddedResult = driver.findElement(By.xpath("//*[@id=\"shopping_cart_container\"]/a/span"))
				.getText();
		int expectedResult = 6;
		int actualResult = Integer.parseInt(actualAddedResult);
		Assert.assertEquals(actualResult, expectedResult);

	}

}
