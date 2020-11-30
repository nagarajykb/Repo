package com.app.ohrm.Testscript;

import org.testng.annotations.Test;

import com.app.ohrm.Generic.BaseTest;
import com.app.ohrm.Generic.Excel;
import com.app.ohrm.Pages.AddEmployeePage;
import com.app.ohrm.Pages.LoginPage;

public class AddEmployeeTest extends BaseTest {
	
	@Test
	public void testAddEmployee() throws InterruptedException {
		String fn = Excel.getData(XL_PATH,"AddEmployee", 1, 0);
		String ln = Excel.getData(XL_PATH, "AddEmployee", 1, 1);
		String eUN = Excel.getData(XL_PATH, "AddEmployee", 1, 2);
		String pwd = Excel.getData(XL_PATH, "AddEmployee", 1, 3);
		String rePWD = Excel.getData(XL_PATH, "AddEmployee", 1, 4);
		//Enter valid username
		LoginPage lp = new LoginPage(driver);
		lp.login(un, pw);
			// Add Employee
			AddEmployeePage addEmp = new AddEmployeePage(driver);
				addEmp.goToSubmenu_PIM_AddEmployee();
				addEmp.setFirstName(fn);
				addEmp.setLastName(ln);
				addEmp.clickLoginChkBox();
				addEmp.setUserName(eUN);
				addEmp.setUserPWD(pwd);
				addEmp.setRePWD(rePWD);
				addEmp.clickSaveBTN();
				
	}
	

}
