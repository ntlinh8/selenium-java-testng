package javaTester.OOP;

public abstract class Person{
	public String name;
	public int age;
	protected boolean isHandsome;
	private String cardId;
	
	public Person(String name, int age, boolean isHandsome, String cardId) {
		super();
		this.name = name;
		this.age = age;
		this.isHandsome = isHandsome;
		this.cardId = cardId;
	}

	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		if(name == null || name.isEmpty()) {
			throw new IllegalArgumentException("You entered the invalid name");
		}else {
			this.name = name;
		}
	}
	
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		if(age < 18 || age > 60) {
			throw new IllegalArgumentException("You entered the invalid age. Age is in range [18, 60].");
		}else {
			this.age = age;
		}
	}
	public boolean isHandsome() {
		return isHandsome;
	}
	public void setHandsome(boolean isHandsome) {
		this.isHandsome = isHandsome;
	}
	
	public String getCardId() {
		return cardId;
	}
	public void setCardId(String cardId) {
		if(cardId.startsWith("0") || cardId.length() != 9) {
			throw new IllegalArgumentException("You entered the invalid cardId.");
		}else {
			this.cardId = cardId;
		}
	}
	
	protected void eat(String age) {
	}
}
