package com.app.ohrm.Generic;

public interface IAutoConst {
	
	String CHROME_KEY="webdriver.chrome.driver";//public static final Sting Chrome_key
//	String CHROME_VALUE="C:\\Users\\Welcome\\git\\Framework\\FrameWork\\Driver\\chromedriver.exe";
	String CHROME_VALUE="./Browsers/chromedriver.exe";
	String GECKO_KEY="webdriver.gecko.driver";
	String GECKO_VALUE="./Browsers/geckodriver.exe";
	String IE_KEY = "webdriver.ie.driver";
	String IE_VALUE = "./Browsers/IEDriverServer.exe";
	String MSEDGE_KEY = "webdriver.edge.driver";
	String MSEDGE_VALUE="./Browsers/MicrosoftWebDriver.exe";
	String APP_URL="http://127.0.0.1/orangehrm/symfony/web/index.php/auth/login";
	String XL_PATH="./testdata/Books.xlsx";
	String IMG_PATH="./screenshot/";
	String browser = "Chrome";
	long ITO=60;
	long ETO=10;
	String un = "admin";
	String pw = "admin123";
	String fname = "Swati";
	String lname = "Beekly";
}
