package javaTester.javaOOP;

import java.security.InvalidParameterException;

public class Topic_06_Getter_Setter {
	//following encapsulation rule, with the secret information, we need to define it by private variable
	// So, if i want to get/set variable, we can use the getter/setter method. These method usually defined with access modifier is public
	// This way will avoid that direct access to the properties of instance or object
	
	private String id;

	// if a variable was defined by public status, we don't need to create getter/setter method to get/set this variable
	// that's bad way if you create getter/setter method for a public variable
	// In addition, the variable was created to save value of variable, so the validate process doesn't execute.
	// (Cannot block user enter the invalid value to the fields)
	// so the setter method will take care it
	// We can validate the data before save it to the variable, if user enters the valid data, data will be saved
	// so, if user enters the invalid data, we need throw a exception to prevent it
	// This way can help the database decrease the junk data
	
	public void setId(String id) {
		if(id.length() != 9) {
			throw new InvalidParameterException("You entered the invalid value");
		}else {
			this.id = id;
		}
	}
	
	// In addition, we can return the difference value that dependented condition, you can see that in the BaseTest class (getDriver method) 
	public String getId() {
		return id;
	}
	
}
