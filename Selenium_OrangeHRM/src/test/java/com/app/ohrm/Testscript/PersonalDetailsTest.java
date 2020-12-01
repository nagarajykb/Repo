package com.app.ohrm.Testscript;

import org.testng.annotations.Test;

import com.app.ohrm.Generic.BaseTest;
import com.app.ohrm.Generic.Excel;
import com.app.ohrm.Pages.LoginPage;
import com.app.ohrm.Pages.PersonalDetailsPage;

public class PersonalDetailsTest extends BaseTest {

	@Test
	public void testPerDetails_MyInfo() throws InterruptedException{
		String fname = Excel.getData(XL_PATH,"PerDetails", 1, 0);
		String lname = Excel.getData(XL_PATH, "PerDetails", 1, 1);
	//	String mStatus = Excel.getData(XL_PATH, "PersnlDetails", 1, 2);
	//	String selNlty = Excel.getData(XL_PATH, "PersnlDetails", 1, 3);
	//	String dob = Excel.getData(XL_PATH, "PersnlDetails", 1, 4);
		
		//Enter valid Username
		LoginPage lp = new LoginPage(driver);
		lp.login(un, pw);
		// Add Personal Details
		PersonalDetailsPage pd = new PersonalDetailsPage(driver);
		pd.gotoMyInfo_PersonalDetails();
		pd.clickEditBTN();
		pd.setFirstName_PD(fname);
		pd.setLastName_PD(lname);
		pd.selectGender_RBTN();
		pd.selectMaritalStatus_DropdnList(mStatus);
		pd.selectNationlty_DropdownList(selNlty);
		pd.setDateOfBirth(dateValue,dateValue1);
		pd.clickSaveBTN();
		
		
	}
}
