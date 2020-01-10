package org.zoho.scripts;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.Test;
import org.zoho.generics.BaseClass;
import org.zoho.generics.FWutills;
import org.zoho.objectRepository.LoginPage;

public class TestLoginPage extends BaseClass
{
    @Test
   public void validLogin() 
   {
   String un = FWutills.read_XL_Data(XL_DATA_PATH, "ValidLogin",1, 0);
   String pw = FWutills.read_XL_Data(XL_DATA_PATH, "ValidLogin",1, 1);
   String expTitle = FWutills.read_XL_Data(XL_DATA_PATH, "HomePage",1, 2);
	LoginPage lp = new LoginPage(driver);
	lp.setUserName(un);
   lp.setPassword(pw);
   lp.clickOnCheckBox();
   lp.clickOnSignin();
   FWutills.verifieTitle(driver, expTitle);

   }
}
