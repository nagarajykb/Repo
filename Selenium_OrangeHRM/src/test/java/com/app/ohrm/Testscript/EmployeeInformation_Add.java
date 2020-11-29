package com.app.ohrm.Testscript;

import org.testng.annotations.Test;

import com.app.ohrm.Generic.BaseTest;
import com.app.ohrm.Generic.Excel;
import com.app.ohrm.Pages.EmpInformation_Add;
import com.app.ohrm.Pages.LoginPage;

public class EmployeeInformation_Add extends BaseTest{
	
	@Test
	public void testEmpInformation_Add() {
		String fn = Excel.getData(XL_PATH, "AddEmployee", 2, 0);
		String ln = Excel.getData(XL_PATH, "AddEmployee", 2, 1);
		String eUN = Excel.getData(XL_PATH, "AddEmployee", 2, 2);
		String pwd = Excel.getData(XL_PATH, "AddEmployee", 2, 3);
		String rePWD = Excel.getData(XL_PATH, "AddEmployee", 2, 4);
		//Enter valid username
		LoginPage lp = new LoginPage(driver);
		lp.login(un, pw);
		//Add employee through EmployeeInformation page
		EmpInformation_Add empInf_add = new EmpInformation_Add(driver);
		empInf_add.goToSubmenu_PIM_EmployeeList();
		empInf_add.clickAddButton();
		empInf_add.setFirstName(fn);
		empInf_add.setLastName(ln);
		empInf_add.setUserName(eUN);
		empInf_add.setUserPWD(pwd);
		empInf_add.setRePWD(rePWD);
		empInf_add.clickSaveBTN();
	}

}
