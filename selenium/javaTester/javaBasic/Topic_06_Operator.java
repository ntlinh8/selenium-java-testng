package javaTester.javaBasic;

public class Topic_06_Operator {
	public static void main(String[] args) {
		//Assign
		int x = 5;
		System.out.println(x);
		
		x += 2;
		System.out.println(x);
		
		x -= 2;
		System.out.println(x);
		
		x *= 2;
		System.out.println(x);
		
		x /= 2;
		System.out.println(x);
		
		x %= 3;
		System.out.println(x);
		
		//Math
		int a = 7, b = 5;
		System.out.println(a+b);
		System.out.println(a-b);
		System.out.println(a*b);
		System.out.println(a/b);
		System.out.println(a%b);
		
		//now a=7
		System.out.println(a++);
		// print a = 7 hien thi ra man hinh
		// tang a len 1
		// hien thi a = 7, thuc te a = 8
		
		System.out.println(a--);
		//print a = 8
		// giam a xuong 1
		// hien thi a = 8, thuc te a = 7
		
		System.out.println(a);
		//print gia tri hien tai cua a = 7
		
		// chu y: number++ se khac voi ++number
		//number++ la hien thi ra man hinh trc sau do moi tang number len 1,
		//++number la tang gia tri cua number len 1, roi in ra man hinh gia tri cua number
		int number = 5;
		System.out.println(number++);
		// in ra number = 5 roi tang number len 1 don vi
		System.out.println(number);
		//in ra gia tri thuc cua number
		System.out.println(--number);
		// giam gia tri cua number di 1 -> in ra man hinh
		
		// Thứ tự thực hiện công thức toán học
		// Bước 1: Xử lý hết Prefix (++number)
		// Bước 2: Xử lý các phép toán còn lại
		// Bước 3: Gán giá trị cho toán hạng nằm phía bên trái
		// Bước 4: Xử lý Postfix
		
		int firstVar = 5, secondVar = 7;
		int result = firstVar++ + ++secondVar -8;
		// tăng secondVar len 1 -> secondVar = 8
		// thuc hien tinh toan 5 + 8 - 8 = 5
		// gán result = 5
		// tăng firstVar lên 1
		// firstVar = 6, secondVar = 8, result = 5
		System.out.println("FirstVar: " + firstVar);
		System.out.println("SecondVar: " + secondVar);
		System.out.println("Result: " + result);

		//Relation (true/false)
		int var1 = 5, var2 = 7;
		System.out.println(var1 > var2);
		System.out.println(var1 >= var2);
		System.out.println(var1 < var2);
		System.out.println(var1 <= var2);
		System.out.println(var1 == var2);
		System.out.println(var1 != var2);
		
		//Logic
		System.out.println((5>3) && (3>5));
		System.out.println((5>3) || (3>5));
		System.out.println((5>3) != (3>5));
		
		//Condition
		//Structure: condition (expression) ? value_true : value_false
		int aNumber = 5, bNumber = 3;
		System.out.println((aNumber>bNumber) ? aNumber-bNumber : bNumber-aNumber);
	}
}
