package com.app.ohrm.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.app.ohrm.BasePage.BasePage;
import com.app.ohrm.Util.Utility;

public class PersonalDetailsPage extends BasePage {
	
	Utility util = new Utility(driver);
	public PersonalDetailsPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="btnSave") private WebElement editBTN;
	@FindBy(xpath="//input[@id='personal_txtEmpFirstName']") private WebElement pdFirstName_TxtBox;
	@FindBy(xpath="//input[@id='personal_txtEmpLastName']") private WebElement pdLastName_TxtBox;
	
	@FindBy(xpath="//input[@id='personal_optGender_2']") private WebElement selectGender_Rbtn;
	@FindBy(xpath="//select[@id='personal_cmbMarital']") private WebElement selectMaritalSt_Dropdown;
//	public static final By selectMaritalSt_Dropdown = By.xpath("//b[contains(text(),'PIM')]");
	
	@FindBy(xpath="//select[@id='personal_cmbNation']") private WebElement selectNationality_Dropdown;
//	public static final By selectNationality_Dropdown = By.id("personal_cmbNation");
	
	@FindBy(xpath="//input[@id='personal_DOB']") private WebElement enterDOB_DateField;
	public static final By allDates = By.xpath("//a[@class='ui-state-default']");
	
	@FindBy(xpath="//input[@id='btnSave']") private WebElement saveBTN;
	
	public void clickEditBTN() {
		editBTN.click();
	}
	public void setFirstName_PD(String fn) {
		Utility.waitForWebElement(driver, pdFirstName_TxtBox, 20);
		pdFirstName_TxtBox.sendKeys(fn);
	}
	public void setLastName_PD(String ln) {
		Utility.waitForWebElement(driver, pdLastName_TxtBox, 20);
		pdLastName_TxtBox.sendKeys(ln);
	}
	public void selectGender_RBTN() {
		Utility.waitForWebElement(driver, selectGender_Rbtn, 20);
		selectGender_Rbtn.click();
	}
	public void selectMaritalStatus_DropdnList(String value) {
		Utility.waitForWebElement(driver, selectMaritalSt_Dropdown, 20);
		Select select = new Select(selectMaritalSt_Dropdown);
		select.selectByValue(value);
	//	util.dropDownSelectByValue(selectMaritalSt_Dropdown, value);
	}

	public void selectNationlty_DropdownList(String value) {
		Utility.waitForWebElement(driver, selectNationality_Dropdown, 60);
		Select select = new Select(selectNationality_Dropdown);
		select.selectByVisibleText(value);
	//	util.dropDownSelectByValue(selectNationality_Dropdown, selNality);
		
	}
	public void setDateOfBirth(String dateValue, String dateValue1) {
		Utility.waitForWebElement(driver, enterDOB_DateField, 20);
		enterDOB_DateField.clear();
		enterDOB_DateField.sendKeys(dateValue);
	//	util.selectDateFromCalendar(allDates, dateValue1);
		
		}
	public void selectDOB() {
		Utility.waitForWebElement(driver, enterDOB_DateField, 20);
//		util.dropDownSelectByIndex(locatorName, i);
//		util.dropDownSelectByIndex(locatorName, i);
//		util.selectDateFromCalendar(allDates, dateValue1);
	}
	public void clickSaveBTN() {
		Utility.waitForWebElement(driver, saveBTN, 30);
		saveBTN.click();
	}
}
