package samplepackage;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SelectTwoExpItems {
                static ChromeDriver driver;
                static String parentHandle;
                public static void main(String[] args) throws IOException {
                                try {
                                                System.setProperty("webdriver.chrome.driver", "D:\\Selenium\\sampleproject\\drivers\\chromedriver.exe");
                                                driver = new ChromeDriver();

                                                WebDriverWait wait = new WebDriverWait(driver, 10);
                                                driver.manage().window().maximize();
                                                driver.get("https://www.amazon.in/");

                                                //select category
                                                WebElement Category = driver.findElementById("searchDropdownBox");
                                                Select sel = new Select(Category);
                                                sel.selectByVisibleText("Watches");
                                                driver.findElementByXPath("//input[@type='submit']").click();
                                                driver.findElementByXPath("//img[@alt='Women']").click();

                                                //sort the items from highest to lowest
                                                driver.findElementByXPath("//span[@role='button']/span[text()='Sort by:']").click();
                                                driver.findElementByXPath("//li[contains(@class,'dropdown')]/a[text()='Price: High to Low']").click();

                                                //Add the two expensive items to the cart

                                                //Select the first item
                                                driver.findElementByXPath("(//span[@class='a-price'])[1]").click();                                           
                                                switchToWindow();

                                                wait.until(ExpectedConditions.presenceOfElementLocated(By.id("add-to-cart-button")));
                                                driver.findElementById("add-to-cart-button").click();

                                                //verify items added to cart
                                                String successMsg = driver.findElementById("huc-v2-order-row-confirm-text").getText();
                                                verifyMsg("Item1", successMsg, "Added to Cart");
                                                driver.close();
                                                driver.switchTo().window(parentHandle);

                                                //Select the first item
                                                driver.findElementByXPath("(//span[@class='a-price'])[2]").click();
                                                switchToWindow();

                                                wait.until(ExpectedConditions.presenceOfElementLocated(By.id("add-to-cart-button")));
                                                driver.findElementById("add-to-cart-button").click();
                                                verifyMsg("Item2", successMsg, "Added to Cart");
                                                driver.close();    
                                                driver.switchTo().window(parentHandle);

                                                //Select the cart and verify two items are added
                                                driver.findElementByXPath("(//a[@id='nav-cart'])[1]").click();
                                                int totalItemsAdded = driver.findElementsByXPath("//span[@class='a-list-item']/a").size();
                                                if (totalItemsAdded==2) {
                                                                System.out.println("The two items added to the cart successfully");         
                                                } else {
                                                                System.out.println("The two items added to the cart successfully");
                                                }
                                }
                                catch (NoSuchElementException e) {
                                                e.printStackTrace();
                                                takeScreenshot("Execution Not Completed");
                                } 
                                catch (Exception e) {
                                                e.printStackTrace();
                                                takeScreenshot("Execution Not Completed");
                                }
                                finally {
                                                takeScreenshot("Result");
                                                driver.quit();
                                }
                }

                public static void switchToWindow() {
                                parentHandle = driver.getWindowHandle();
                                Set<String> windows = driver.getWindowHandles();
                                Iterator<String> ite = windows.iterator();
                                while (ite.hasNext()) {
                                                String childHandle = ite.next();
                                                if (!parentHandle.equalsIgnoreCase(childHandle)) {
                                                                driver.switchTo().window(childHandle);
                                                }              
                                }
                }

                public static void verifyMsg(String Label, String expectedText, String actualText) {
                                if (expectedText.equals(actualText)) {
                                                System.out.println("The "+Label+" added to the cart successfully");                                                          
                                } else {
                                                System.out.println("The "+Label+" is not added to the cart successfully");
                                }
                }

                public static void takeScreenshot(String FileName) throws IOException {
                                TakesScreenshot ss =((TakesScreenshot)driver);
                                File srcFile = ss.getScreenshotAs(OutputType.FILE);
                                File DestFile=new File("D:\\Selenium\\sampleproject\\results"+FileName+".JPG");
                                FileUtils.copyFile(srcFile, DestFile);
                }
}
