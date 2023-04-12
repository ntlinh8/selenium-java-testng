package javaTester.javaBasic;

public class Topic_07_Primitive_Casting {
	public static void main(String[] args) {
		// Implicit Casting
		// ép kiểu ngầm định, thường được sử dụng khi gán giá trị của biến có size nhỏ cho biến size lớn
		// cho biến có size lớn
		long lNumber1 = 2131231;
		int iNumber1 = 3;
		lNumber1 = iNumber1;
		
		// Explicit Casting
		// ép kiểu tường minh, thường sử dụng khi gán giá trị của biến có size lớn cho biến size nhỏ
		// Khi ép kiểu như vậy sẽ gây mất mát thông tin
		long lNumber2 = 2131231;
		int iNumber2 = 3;
		iNumber2 = (int) lNumber2;
		
	}
}
