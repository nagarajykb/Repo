package com.app.ohrm.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	public LoginPage(WebDriver driver) {
	//	this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="txtUsername")
	private WebElement unTB;
	
	@FindBy(id="txtPassword")
	private WebElement pwTB;
	
	@FindBy(id="btnLogin")
	private WebElement loginBTN;
	
	public void setUsername(String un) {  //un="admin" 
		//this.unTB = unTB;
		unTB.sendKeys(un);
	}
	public void setPassword(String pw) {  //pw=pwd
		//this.pwTB = pwTB;
		pwTB.sendKeys(pw);
	}
	public void clickLogin() {
		loginBTN.click();
	}

	public void login(String un, String pw) {
		unTB.sendKeys(un);
		pwTB.sendKeys(pw);
		loginBTN.click();
		
	}

}
