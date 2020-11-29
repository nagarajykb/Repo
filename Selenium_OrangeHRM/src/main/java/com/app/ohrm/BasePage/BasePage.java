package com.app.ohrm.BasePage;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.app.ohrm.Util.Utility;

public class BasePage {
	public WebDriver driver;
	Utility util = new Utility(driver);
	public BasePage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	//MainMenu's
	@FindBy(xpath = "//b[contains(text(),'Admin')]") private WebElement mMenu_admin;
	@FindBy(xpath = "//b[contains(text(),'PIM')]") private WebElement mainMenu_pim;
//	public static final By mainMenu_pim = By.xpath("//b[contains(text(),'PIM')]"); //instance method
	@FindBy(xpath = "//b[contains(text(),'Leave')]") private WebElement mMenu_leave;
	@FindBy(xpath = "//b[contains(text(),'Time')]") private WebElement mMenu_time;
	@FindBy(xpath = "//b[contains(text(),'Recruitment')]") private WebElement mMenu_recruitment;
	@FindBy(xpath = "//b[contains(text(),'My Info')]") private WebElement mMenu_myInfo;
	@FindBy(xpath = "//b[contains(text(),'Performance')]") private WebElement mMenu_performance;
	@FindBy(xpath = "//b[contains(text(),'Dashboard')]") private WebElement mMenu_dashboard;
	@FindBy(xpath = "//b[contains(text(),'Directory')]") private WebElement mMenu_directory;
	@FindBy(xpath = "//b[contains(text(),'Maintenance')]") private WebElement mMenu_maintenance;
	
	//submenu's
	public static final By pim_configuration = By.xpath("//a[@id='menu_pim_Configuration']");
	@FindBy(xpath = "//a[@id='menu_pim_viewEmployeeList']") WebElement pim_EmployeeList;
	@FindBy(xpath = "//a[@id='menu_pim_addEmployee']") WebElement pim_AddEmployee;

	
	public void gotoPIM() {  //not used
	//	Utility.waitForWebElement(driver, clickLink_pim, 20);
	//	clickLink_pim.click();
	//	Utility.waitForWebElement(driver, subMenu_addEmployee_link, 5);
	//	subMenu_addEmployee_link.click();
	//	subMenu_addEmployee_link.click();
	}
	public void goToSubmenu_PIM_AddEmployee() {
		Utility.waitForWebElement(driver, mainMenu_pim,15);
	//	util.mouseOverAction(mainMenu_pim);
		Actions builder = new Actions(driver);
		builder.moveToElement(mainMenu_pim).build().perform();
		pim_AddEmployee.click();   //sendKeys(Keys.RETURN);
	
	
	}
	public void goToSubmenu_PIM_EmployeeList() {
		Utility.waitForWebElement(driver, mainMenu_pim,15);
//		util.mouseOverAction(mainMenu_pim);
//		Actions builder = new Actions(driver);
//		builder.moveToElement(mainMenu_pim).build().perform();
		pim_EmployeeList.click();
	}
	
	
	
}
