package com.app.ohrm.Generic;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.codehaus.plexus.util.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.io.FileHandler;

public class AutoLib implements IAutoConst {

	public WebDriver driver;

	public static void getPhoto(WebDriver driver,String path) {
		TakesScreenshot t= (TakesScreenshot) driver;
	//	EventFiringWebDriver efDriver=new EventFiringWebDriver(driver);
		File srcFile =t.getScreenshotAs(OutputType.FILE);
		File destFile = new File(path);
		try {
			FileUtils.copyFile(srcFile, destFile);
		}catch(IOException e) {
			e.printStackTrace();
			System.out.println("Failed to capture screenshot");
		}
	}
	public static String captureScreenShot(WebDriver driver) {
		TakesScreenshot t= (TakesScreenshot) driver;
	//	EventFiringWebDriver efDriver=new EventFiringWebDriver(driver);
		File srcFile =t.getScreenshotAs(OutputType.FILE);
		String path = System.getProperty("user.dir"+"/screenshot/"+BaseTest.getDate()+".png");
	//	File destFile = new File(path);
		try {
			FileUtils.copyFile(srcFile, new File(path));
		}catch(IOException e) {
			System.out.println("Exception/Failed while capturing screenshot");
			System.out.println("Full info about exception :"+e.getMessage());
		}
		return path;
	}
	public static String getScreenshot(WebDriver driver) {
		String path = System.getProperty("user.dir") + "\\screenshot\\Screenshot_" + getCurrentTime() + ".img";
		TakesScreenshot ts = (TakesScreenshot) driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		try {
		//	File destFile = new File(path);
			FileHandler.copy(src, new File(path));
		} catch (IOException e) {
			System.out.println("Failed to capture screenshot");
		}
		return path;
	}
	public static String getCurrentTime() {
		DateFormat df = new SimpleDateFormat("ss_mm_HH_dd_MM_yyyy");

		Date date = new Date();

		return df.format(date);

	}
	public WebDriver getDriver(String browserType) { //browserType=browser
		System.out.println("=====Browser is getting ready============");
		if(browserType.equalsIgnoreCase("firefox")) {
			System.setProperty(GECKO_KEY, GECKO_VALUE);
			driver = new FirefoxDriver();
		}else if(browserType.equalsIgnoreCase("chrome")) {
			System.setProperty(CHROME_KEY,CHROME_VALUE);
			driver = new ChromeDriver();
		}else if(browserType.equalsIgnoreCase("MSEDGE")) {
			System.setProperty(MSEDGE_KEY, MSEDGE_VALUE);
			driver = new EdgeDriver();
		}
		else if(browserType.equalsIgnoreCase("IE")) {
			System.setProperty(IE_KEY, IE_VALUE);
			driver = new InternetExplorerDriver();
		}
		return driver;
		
	}
	
}
