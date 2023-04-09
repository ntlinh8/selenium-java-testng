package testng;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class Topic_03_Priority {
	/* 1. Priority
	 * Co che cua cac testing framework -> sap xep tc theo A-Z 0-9
	 * Neu ko set priority -> Edit -> Move -> View -> Register
	 * -> Nen dung priority
	 * -> Thuc te ho ko dung priority -> Danh so vao ten tc luon
	 * Loi ich: 
	 * Sap xep test case chay dung thu tu
	 * Neu fail test case -> nhin stt -> tra ra nhanh hon
	 * 
	 * 2. Skip test case
	 * enable = False (default = true)
	 * 
	 * 3. Description
	 * Mieu ta tc duoi dang van noi -> de doc cho nguoi moi vao du an
	 * Hoac gan tc voi mot id/ticket thuc te nao do -> day du thong tin
	 * De luc run thong tin duoc log ra -> failed thi de check
	 * 
	 * == 
	 * Neu muon set before test cho all packet -> create BaseTest.java
	 * voi 2 ham la before va after (alwaysRun = true)
	 * Cho cac class trong package extend BaseTest (No se ke thuc 2 ham before and after cua lop nay)
	 * tao ham before test cho class do (alwaysRun = true)
	 * --
	 * Thu tu run: Before Test (BaseTest.java) -> BeforeTest (class hien tai dang run) -> test case -> after test (class hien tai dang run) -> after test (BaseTest.java)
	 */
	
//  Priority
//	@Test(priority = 1)
//	public void User_Register_New_Employee() {
//	}
//
//	@Test(priority = 2)
//	public void User_View_New_Employee() {
//	}
//
//	@Test(priority = 3)
//	public void User_Edit_New_Employee() {
//	}
//
//	@Test(priority = 4)
//	public void User_Move_New_Employee() {
//	}
	
	@Test(enabled = false, description = "Jira9823 - Create a new employee and verify create successful")
	public void TC01_User_Register_New_Employee() {
	}

	@Test(enabled = false)
	public void TC02_User_View_New_Employee() {
	}

	@Test
	public void TC03_User_Edit_New_Employee() {
	}

	@Test
	public void TC04_User_Move_New_Employee() {
	}
}
