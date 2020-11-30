set projectLocation=C:\Users\Dell\git\repository2\Selenium_OrangeHRM
cd %projectLocation%
set classpath=%projectLocation%\bin;%projectLocation%\lib\*
java -cp ".\bin;.\lib\*" org.testng.TestNG testng1.xml