package uiproperties;

import org.openqa.selenium.By;

public class AmazonPage {
	public static By category = By.id("searchDropdownBox");
	public static By submitButton = By.xpath("//input[@type='submit']");
	public static By subCategory = By.xpath("//img[@alt='Women']");
	
	public static By sortButton = By.xpath("//span[@role='button']/span[text()='Sort by:']");
	public static By priceSort = By.xpath("//li[contains(@class,'dropdown')]/a[text()='Price: High to Low']");

	public static By products =  By.xpath("//span[@class='a-price']");
	public static By addToCart = By.id("add-to-cart-button");
	public static By confirmText = By.id("huc-v2-order-row-confirm-text");
	
	public static By cartButton = By.xpath("(//a[@id='nav-cart'])[1]");
	public static By noOfItems =  By.xpath("//span[@class='a-list-item']/a");
	
}
