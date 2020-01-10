package org.zoho.scripts;

import org.testng.annotations.Test;
import org.zoho.generics.BaseClass;
import org.zoho.generics.FWutills;
import org.zoho.objectRepository.HomePage;
import org.zoho.objectRepository.LoginPage;

public class TestCreateTaskPage extends BaseClass
{
	@Test
	public void newTask()
	{
		String user = FWutills.read_XL_Data(XL_DATA_PATH, "ValidLogin",1,0);
		String pass = FWutills.read_XL_Data(XL_DATA_PATH, "ValidLogin",1,1);
		String expTitleH = FWutills.read_XL_Data(XL_DATA_PATH, "HomePage",1,2);
		String expTitleT = FWutills.read_XL_Data(XL_DATA_PATH,"CreateTask",1,5);
		int rowData = FWutills.read_XL_DataRowCount(XL_DATA_PATH,"CreateTask");
		
		LoginPage lp = new LoginPage(driver);
		lp.setUserName(user);
		lp.setPassword(pass);
		lp.clickOnSignin();
		FWutills.verifieTitle(driver, expTitleH);
		HomePage hp = new HomePage(driver);
	
		for(int i=1;i<rowData;i++)
		{
			hp.clickOnNewTsak();
			FWutills.verifieTitle(driver, expTitleT);
			String sub = FWutills.read_XL_Data(XL_DATA_PATH,"CreateTask", i,0);
			hp.enterSubjectOfPro(sub);
			String des = FWutills.read_XL_Data(XL_DATA_PATH,"CreateTask",i,1);
			hp.enterDesOfPro(des);
			//String date = FWutills.read_XL_Data(XL_DATA_PATH,"CreateTask",i,2);
			//hp.selectDate(date);
			String emp = FWutills.read_XL_Data(XL_DATA_PATH,"CreateTask",i,3);
			hp.selectEmp(emp);
			String priority = FWutills.read_XL_Data(XL_DATA_PATH,"CreateTask",i,4);
			hp.selectPriority(priority);
			hp.clickOnSaveTask();
			hp.clickOnHome();
		}
		
	}
 
}

