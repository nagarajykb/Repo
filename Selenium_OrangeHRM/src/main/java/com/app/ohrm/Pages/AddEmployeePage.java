package com.app.ohrm.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.app.ohrm.BasePage.BasePage;
import com.app.ohrm.Util.Utility;
//Derived page or child page or subclass
public class AddEmployeePage extends BasePage {
	
	public AddEmployeePage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//input[@id='firstName']") private WebElement firstName_TxtBox;
	@FindBy(xpath="//input[@id='lastName']") private WebElement lastName_TxtBox;
	
	@FindBy(xpath="//input[@id='chkLogin']") private WebElement chkLogin_CheckBox;
	@FindBy(xpath="//input[@id='user_name']") private WebElement userName_TxtBox;
	@FindBy(xpath="//input[@id='user_password']") private WebElement userPWD_TxtBox;
	@FindBy(xpath="//input[@id='re_password']") private WebElement rePWD_TxtBox;
	@FindBy(xpath="//input[@id='btnSave']") private WebElement save_SaveBTN;
	
	public void setFirstName(String fn) {
		Utility.waitForWebElement(driver, firstName_TxtBox, 5);
	//	firstName_TxtBox.click();
		firstName_TxtBox.sendKeys(fn);
	}
		public void setLastName(String ln) {
			lastName_TxtBox.sendKeys(ln);
		}
			public void clickLoginChkBox() {
				chkLogin_CheckBox.click();
			}
				public void setUserName(String eUN) {
					userName_TxtBox.sendKeys(eUN);;
				}
					public void setUserPWD(String pwd) {
						userPWD_TxtBox.sendKeys(pwd);;
					}
						public void setRePWD(String rePWD) {
							rePWD_TxtBox.sendKeys(rePWD);;
						}
							public void clickSaveBTN() {
								save_SaveBTN.click();
							}
}
