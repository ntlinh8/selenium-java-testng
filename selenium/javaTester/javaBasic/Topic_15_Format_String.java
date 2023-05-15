package javaTester.javaBasic;

public class Topic_15_Format_String {
	public static final String DYNAMIC_LOCATOR = "//a[text()='%s']";
	public static void main(String[] args) {
		clickToLink("Search");
		clickToLink("My Account");
		clickToLink("Product");
		
		// for handle locator type
		String firstStr = "xpath=//input[@id='name']";
		String secondStr = "css=input[id='name']";
		String thirdStr = "name=UserName";
		
		System.out.println(firstStr.substring(6));
		System.out.println(secondStr.substring(4));
		System.out.println(thirdStr.substring(5));
	}
	
	public static void clickToLink(String linkLabel) {
		System.out.println("Click to link " + String.format(DYNAMIC_LOCATOR, linkLabel));
	}

}
