package testng;

import static org.testng.Assert.assertEquals;

import org.testng.Assert;

public class Topic_01_Assert {

	public static void main(String[] args) {
		
		// Mong đợi mệnh đề đưa vào là true
		Assert.assertTrue(3<4);
		
		String name = "Automation Testing";
		Assert.assertTrue(name.contains("Testing"));
		
		// Mong đợi mệnh đề truyền vào là sai
		Assert.assertFalse(name.contains("Hello"));
		
		//Mong đợi hai giá trị truyền vào bằng nhau
		//Nếu kiểu khác nhau -> tự convert về một kiểu để compare
		assertEquals(name, "Automation Testing");
	}

}
