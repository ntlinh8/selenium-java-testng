package javaTester.javaOOP;

public class Topic_04_Non_Access_Modifier_2 extends Topic_04_Non_Access_Modifier_1{
	
	@Override
	public void clickToElement1(String elementName) {
		System.out.println(elementName);
	}
	
	// Lỗi ko đc overrider lại hàm final
//	public final void setCarName() {
//		
//	}


}
