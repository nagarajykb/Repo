package com.app.ohrm.Testscript;

import org.testng.annotations.Test;
import com.app.ohrm.Generic.BaseTest;
import com.app.ohrm.Generic.Excel;
import com.app.ohrm.Pages.LoginPage;

public class ValidLogin extends BaseTest {
	
	@Test(priority=1)
	public void testValidLogin() throws InterruptedException {
		String un = Excel.getData(XL_PATH, "validLogin", 1, 0); //admin
		String pw = Excel.getData(XL_PATH, "validLogin", 1, 1); //manager
		String title = Excel.getData(XL_PATH, "validLogin", 1, 2);
		//Enter valid username
		LoginPage lp = new LoginPage(driver);
		Thread.sleep(2000);
		lp.setUsername(un);
		//Enter valid password
		lp.setPassword(pw);
		//click on login button
		lp.clickLogin();
		//Verify home page is displayed or not
	//	EnterTimeTrackPage timeTrack_hp = new EnterTimeTrackPage(driver);
	//	timeTrack_hp.verifyPageIsDisplayed(driver, ETO, title);

	}
}