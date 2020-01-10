package org.zoho.scripts;

import org.testng.annotations.Test;
import org.zoho.generics.BaseClass;
import org.zoho.generics.FWutills;
import org.zoho.objectRepository.LoginPage;

public class TestInvalidLoginPage extends BaseClass
{
	@Test
	public void invalidLogin()
	{
		int rowsData = FWutills.read_XL_DataRowCount(XL_DATA_PATH, "InvalidLogin");
		LoginPage lp = new LoginPage(driver);
		for(int i=1;i<=rowsData;i++)
		{
			String user = FWutills.read_XL_Data(XL_DATA_PATH, "InvalidLogin",i,0);
			String pass = FWutills.read_XL_Data(XL_DATA_PATH, "InvalidLogin",i,1);
		     lp.setUserName(user);
		     lp.setPassword(pass);
		     lp.clickOnCheckBox();
		     lp.clickOnSignin();
		     lp.errMsgIs();
	    }
	}
}
