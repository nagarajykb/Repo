package com.app.ohrm.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.app.ohrm.BasePage.BasePage;
import com.app.ohrm.Util.Utility;

public class PersonalDetailsPage extends BasePage {
	
	public PersonalDetailsPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="btnSave") private WebElement editBTN;
	@FindBy(xpath="//input[@id='personal_txtEmpFirstName']") private WebElement pdFirstName_TxtBox;
	@FindBy(xpath="//input[@id='personal_txtEmpLastName']") private WebElement pdLastName_TxtBox;
	
	@FindBy(xpath="//input[@id='personal_optGender_2']") private WebElement selectGender_Rbtn;
	@FindBy(xpath="//select[@id='personal_cmbMarital']") private WebElement selectMaritalSt_Dropdown;
	@FindBy(xpath="personal_cmbNation") private WebElement selectNationality_Dropdown;
//	@FindBy(xpath="//input[@id='personal_DOB']") private WebElement selectDOB;
	@FindBy(id="//input[@id='btnSave']") private WebElement saveBTN;
	
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
	public void selectMaritalStatus_DropdnList(String mStatus) {
		Utility.waitForWebElement(driver, selectMaritalSt_Dropdown, 20);
		Select select = new Select(selectMaritalSt_Dropdown);
		select.selectByValue(mStatus);
	}

	public void selectNationlty_DropdownList(String selNationality) {
		Utility.waitForWebElement(driver, selectNationality_Dropdown, 20);
		Select select = new Select(selectNationality_Dropdown);
		select.selectByValue(selNationality);
	}
	public void clickSaveBTN() {
		saveBTN.click();
	}
}
