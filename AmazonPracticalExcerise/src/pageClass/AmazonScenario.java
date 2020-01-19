package pageClass;

import java.util.List;

import org.openqa.selenium.WebElement;

import uiproperties.AmazonPage;
import baselibrary.FunctionLibrary;
import baselibrary.LaunchLogin;

public class AmazonScenario {
	public static void SelectTwoExpItems(){
		//select category
		FunctionLibrary.selectDropdown(AmazonPage.category, "Watches");
		FunctionLibrary.clickElement(AmazonPage.submitButton);
		FunctionLibrary.highlightElement(AmazonPage.subCategory);
		FunctionLibrary.clickElement(AmazonPage.subCategory);

		//sort the items from highest to lowest
		FunctionLibrary.highlightElement(AmazonPage.sortButton);
		FunctionLibrary.clickElement(AmazonPage.sortButton);
		FunctionLibrary.clickElement(AmazonPage.priceSort);	

		//Add the two expensive items to the cart
		List<WebElement> priceList = LaunchLogin.driver.findElements(AmazonPage.products);
		for(int i=0; i<2;i++) {
			//Select the item
			WebElement price = priceList.get(i);
			FunctionLibrary.highlightElement(price);
			
			price.click();
			FunctionLibrary.switchToWindow();
			FunctionLibrary.waitForElementUsingPresence(AmazonPage.addToCart, 15);
			FunctionLibrary.highlightElement(AmazonPage.addToCart);
			FunctionLibrary.clickElement(AmazonPage.addToCart);
			
			//verify items added to cart
			FunctionLibrary.highlightElement(AmazonPage.confirmText);
			String successMsg = FunctionLibrary.getText(AmazonPage.confirmText);
			verifyMsg("Item"+i, successMsg, "Added to Cart");
			LaunchLogin.driver.close();
			FunctionLibrary.switchToParentWindow();
		}
		
		//Select the cart and verify two items are added
		FunctionLibrary.clickElement(AmazonPage.cartButton);
		int totalItemsAdded = LaunchLogin.driver.findElements(AmazonPage.noOfItems).size();
		for(int i=0; i<totalItemsAdded;i++) {
		FunctionLibrary.highlightElement(LaunchLogin.driver.findElements(AmazonPage.noOfItems).get(i));
		}
		
		if (totalItemsAdded==2) {
			System.out.println("The two items added to the cart successfully");	
		} else {
			System.out.println("The two items are not added to the cart successfully");
		}
	}

	public static void verifyMsg(String Label, String expectedText, String actualText) {
		if (expectedText.equals(actualText)) {
			System.out.println("The "+Label+" added to the cart successfully");				
		} else {
			System.out.println("The "+Label+" is not added to the cart successfully");
		}
	}
}