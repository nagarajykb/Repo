package com.app.ohrm.Util;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class Utility implements WebDriver {
	
	public  WebDriver driver;
	WebElement element;
	
	public Utility(WebDriver driver) {
		this.driver =driver;
	}
	
	// This method's will handle sync issue - It will wait for webelement and highlight webelement
	  public static WebElement waitForWebElement(WebDriver driver, By byLocator) {
		  WebDriverWait wait = new WebDriverWait(driver, 10); 
		  WebElement element = wait.until(ExpectedConditions.elementToBeClickable(byLocator)); 
	//	  wait.until(ExpectedConditions.presenceOfElementLocated(locatorName));
		  highLightElement(driver, element);
		  return element; }

	  public static WebElement waitForWebElement(WebDriver driver, By byLocator,int time) { 
		  WebDriverWait wait = new WebDriverWait(driver, time); 
		  WebElement element = wait.until(ExpectedConditions.elementToBeClickable(byLocator));
		  highLightElement(driver, element);
		  return element; }
	  
	  public static Boolean waitForWebElement(WebDriver driver, WebElement webElement) { 
		  WebDriverWait wait = new WebDriverWait(driver, 10); 
		  Boolean element = wait.until(ExpectedConditions.elementToBeSelected(webElement));
	//	  highLightElement(driver, element);
		  return element; }
	  
	  public static WebElement waitForWebElement(WebDriver driver, WebElement webElement,int time) {
		
			WebDriverWait wait = new WebDriverWait(driver, time);
			WebElement element = wait.until(ExpectedConditions.elementToBeClickable(webElement));
//			wait.until(ExpectedConditions.presenceOfElementLocated(locatorName));
			highLightElement(driver, element);
			return element;
	  		}

	  public void driverWiatForElementPresence(By locatorName) {
		  	WebDriverWait wait = new WebDriverWait(driver, 60);
			wait.until(ExpectedConditions.presenceOfElementLocated(locatorName));
			}
	  
	  public static void highLightElement(WebDriver driver, WebElement element){
		  	JavascriptExecutor js = (JavascriptExecutor) driver;

		js.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');", element);

			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
	
				System.out.println(e.getMessage());
			}
		js.executeScript("arguments[0].setAttribute('style','border: solid 2px white');", element);

	}
	  public static  List<WebElement> waitForMultipleWebElement(WebDriver driver, By byLocator) {
		  WebDriverWait wait = new WebDriverWait(driver, 15);
		  List<WebElement> allElements = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(byLocator));
		  return allElements;
	  	  }
	  public static  List<WebElement> waitForMultipleWebElement(WebDriver driver, By byLocator,int time) {
		  WebDriverWait wait = new WebDriverWait(driver, time);
		  List<WebElement> allElements = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(byLocator));
		  return allElements;
	  	  }
	
	  public void selectDateFromCalendar(By locatorName,String dateValue) {
		  List<WebElement> elements = driver.findElements(locatorName);
		  for(WebElement ele:elements) {
			String data = ele.getText();
			if(data.equalsIgnoreCase(dateValue)) {
				ele.click();
				break;
				}
		  	}
	  	  }
	  public List<String> getText(By locatorName) {
		  List<String> ls = new ArrayList<String>();
		  List<WebElement> allOptions = findElements(locatorName);
		  for(WebElement option:allOptions) {
			ls.add(option.getText().trim());
		  	}
		  	return ls;
	  	  }
	  public void customListBoxGetText(By locatorName, String exptecteValue) {
			List<WebElement> elements = driver.findElements(locatorName);
		//	int count = elements.size();
		//	System.out.println("No of values present in the dropdownList: "+count);
			for(WebElement option: elements){	
				String text = option.getText();
				if(text.equalsIgnoreCase(exptecteValue)) {
					 option.click();
					 break;
				 	}
				}
	  		}
	 
	  public void dropDownSelectByValue(By locatorName, String value) {
			WebElement ele;
			ele = driver.findElement(locatorName);
			Select sel = new Select(ele);
			sel.selectByValue(value);

		}

	  public void dropDownSelectByIndex(By locatorName, int i) {
			WebElement ele = null;
			ele = driver.findElement(locatorName);
			Select sele = new Select(ele);
			sele.selectByIndex(i);

		}

	  public void dropDownSelectByVisibleText(By locatorName, String arg) {
			WebElement ele;
			ele = driver.findElement(locatorName);
			Select sele = new Select(ele);
			sele.selectByVisibleText(arg);
		}
		
	
	  public static void acceptAlert(WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, 15);
		wait.until(ExpectedConditions.alertIsPresent()).accept();
	}
	  public static void dismissAlert(WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, 15);
		wait.until(ExpectedConditions.alertIsPresent()).dismiss();
	}
	  public static void verifyAlertText(WebDriver driver, String expectedText) {
		WebDriverWait wait = new WebDriverWait(driver, 15);
		String alert_text_actual = wait.until(ExpectedConditions.alertIsPresent()).getText();
		Assert.assertEquals(alert_text_actual, expectedText);
	}
	  public static void verifyTitle(WebDriver driver, String title) {
		WebDriverWait wait = new WebDriverWait(driver, 25);
		Assert.assertTrue(wait.until(ExpectedConditions.titleIs(title)));
	}
	  public static void verifyContainsTitle(WebDriver driver, String title) {
		WebDriverWait wait = new WebDriverWait(driver, 25);
		Assert.assertTrue(wait.until(ExpectedConditions.titleContains(title)));
	}
	  public static void verifyURL(WebDriver driver, String url) {
		WebDriverWait wait = new WebDriverWait(driver, 25);
		Assert.assertTrue(wait.until(ExpectedConditions.urlToBe(url)));
	}
	  public static void verifyURLContains(WebDriver driver, String url) {
		WebDriverWait wait = new WebDriverWait(driver, 25);
		Assert.assertTrue(wait.until(ExpectedConditions.urlContains(url)));
	}

		public void get(String url) {
		// TODO Auto-generated method stub
		
		}

		public String getCurrentUrl() {
			// TODO Auto-generated method stub
			return null;
		}
	
		public String getTitle() {
			// TODO Auto-generated method stub
			return null;
		}
	
		public List<WebElement> findElements(By locatorName) {
			  List<WebElement> elements = driver.findElements(locatorName); 
			  return elements; 
		}
	
		public WebElement findElement(By locatorName) {
			element = driver.findElement(locatorName);
			return element;
		}
	
		public String getPageSource() {
			// TODO Auto-generated method stub
			return null;
		}
	
		public void close() {
			// TODO Auto-generated method stub
			driver.close();
		}
	
		public void quit() {
			// TODO Auto-generated method stub
			driver.close();
		}
		public Navigation navigate() {
			// TODO Auto-generated method stub
			return null;
		}
	
		public Options manage() {
			// TODO Auto-generated method stub
			return null;
		}
		public Set<String> getWindowHandles() {
			String currentWindow= getWindowHandle();
			Set<String> handles = driver.getWindowHandles();
			handles.remove(currentWindow);
			String nextWindow= handles.iterator().next();
			Set<String> nw= new HashSet<String>();
			nw.add(nextWindow);
			return nw;
		}
		
		public String getWindowHandle() {
			 String window=driver.getWindowHandle();
			 return window;
		}
	
		public TargetLocator switchTo() {
			// TODO Auto-generated method stub
			return (TargetLocator) driver.switchTo().defaultContent();
		}
	
		public void switchToOtherWindow(String windowId){
			driver.switchTo().window(windowId);
		}
		public void sendKeys(By locatorName, String typeValue) {
			WebElement element = findElement(locatorName);
			element.sendKeys(typeValue);
		}
	
		public void click(By locatorName) {
			WebElement ele;
			ele = driver.findElement(locatorName);
			ele.click();
			//ele.clear();
		}
	
		public boolean isEnabled(By locatorName) {
			WebElement ele;
			ele = driver.findElement(locatorName);
			return ele.isEnabled();
		}
	
		public boolean isDisplayed(By locatorName) {
			WebElement ele;
			ele = driver.findElement(locatorName);
			return ele.isDisplayed();
		}
	
		public void mouseOverAction(By locatorName) {
			try { 
					WebElement element=findElement(locatorName);
					Actions builder = new Actions(driver);
					builder.moveToElement(element).build().perform();
										
				}catch(Exception e){
				
					}
		 	}
	/*
	 * public void mouseOverClick(By locatorName) { WebElement
	 * element=findElement(locatorName); Actions builder = new Actions(driver);
	 * builder.moveToElement(element).click(element).build().perform(); }
	 */


	
		 
}
