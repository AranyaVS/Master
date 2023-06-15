package Loginpagetest;


import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import LoginPage.Login;
import LoginUtility.ReadExcelData;
public class Logintest extends Login{
	
@Test(dataProvider="getData")
	public void loggedin(String Username, String Password)
	{
		driver.findElement(By.xpath("//input[@id='user-name']")).sendKeys(Username);
		driver.findElement(By.id("password")).sendKeys(Password);
		driver.findElement(By.id("login-button")).click();
		driver.findElement(By.xpath("//select[@class='product_sort_container']")).click();
		driver.findElement(By.xpath("//option[text()='Price (low to high)']")).click();
		driver.findElement(By.xpath("//button[text()='Add to cart'][1]")).click();
		driver.findElement(By.xpath("//button[@id=\"add-to-cart-sauce-labs-bike-light\"]")).click();
		driver.findElement(By.xpath("//button[@id=\"add-to-cart-sauce-labs-bolt-t-shirt\"]")).click();
		driver.findElement(By.xpath("//button[@id=\"add-to-cart-test.allthethings()-t-shirt-(red)\"]")).click();
		driver.findElement(By.xpath("//button[@id=\"add-to-cart-sauce-labs-backpack\"]")).click();
		driver.findElement(By.xpath("//button[@id=\"add-to-cart-sauce-labs-fleece-jacket\"]")).click();
		driver.findElement(By.xpath("//span[@class='shopping_cart_badge']")).click();
		//code  for comparing the price
		List<WebElement> element = driver.findElements(By.xpath("//div[@class='item_pricebar']/div[@class='inventory_item_price']"));
				for (WebElement ele : element)
				{
				if ( Integer.parseInt(ele.getText()) < 15){
					driver.findElement(By.xpath("//*[text()=‘Remove’]"));
				}
				}
		/*driver.findElement(By.xpath("//div[@class=\"inventory_item_price\"][1]"));
		driver.findElement(By.xpath("//button[@id=\"remove-sauce-labs-onesie\"]")).click();
		driver.findElement(By.xpath("//button[@id=\"remove-sauce-labs-bike-light\"]")).click();*/
		driver.findElement(By.name("checkout")).click();		
		driver.findElement(By.id("first-name")).sendKeys("Aranya");
		driver.findElement(By.id("last-name")).sendKeys("arun");
		driver.findElement(By.id("postal-code")).sendKeys("678905");
		driver.findElement(By.id("continue")).click();
		driver.findElement(By.id("finish")).click();
		driver.findElement(By.id("back-to-products")).click();	
		driver.findElement(By.id("react-burger-menu-btn")).click();
		driver.findElement(By.id("logout_sidebar_link")).click();
		}
private String readTextFromElement(By inventoryItemBy) {
	// TODO Auto-generated method stub
	return null;
}
@DataProvider
public Object[][] getData()
{
	return ReadExcelData.readData("Test Data");
}

}
