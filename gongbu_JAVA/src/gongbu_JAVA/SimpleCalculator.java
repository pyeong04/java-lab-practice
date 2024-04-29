package gongbu_JAVA;
import java.util.Scanner;
import java.io.*;

class AddZeroException extends Exception {
}
class SubtractZeroException extends Exception {
}
class OutOfRangeException extends Exception {
}

class myEx{
	int num1, num2;
	char op;
	myEx(int a, int b, char op){
		num1 = a;
		num2 = b;
		this.op = op;
	}
	
	public void ex1() throws AddZeroException {
		if(op == '+') {
			if (num1 == 0 || num2 == 0) {
				throw new AddZeroException();
			}
		}
	}
	public void ex2() throws SubtractZeroException {
		if(op == '-') {
			if (num1 == 0 || num2 == 0) {
				throw new SubtractZeroException();
			}
		}
	}
	public void ex3() throws OutOfRangeException{
		if(num1+num2<0 || num1+num2>1000 || num1 < 0 || num1 > 1000 || num2 < 0 || num2 > 1000) {
			throw new OutOfRangeException();
		}
	}
}

public class SimpleCalculator {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int a = 0, b = 0;
		char op = '+';
		String com = sc.nextLine(), tmp = "";
		
		for(int i = 0; i<com.length(); i++) {
			if (i == com.length() -1) {
				tmp += com.charAt(i);
				b = Integer.valueOf(tmp);
			}
			else if(com.charAt(i) == '+' || com.charAt(i) == '-') {
				a = Integer.valueOf(tmp);
				op = com.charAt(i);
				tmp = "";
			}
			else {
				tmp += com.charAt(i);
			}
		}
		
		myEx m = new myEx(a, b, op);
		
		try {
			m.ex1();
			m.ex2();
			m.ex3();
			if (op == '+') {
				System.out.print((a+b) + "\n");
			}
			else if (op == '-') {
				System.out.print((a-b) + "\n");
			}
		} catch(AddZeroException e1) {
			System.out.print("AddZeroException");
		} catch(SubtractZeroException e1) {
			System.out.print("SubtractZeroException");
		} catch(OutOfRangeException e1) {
			System.out.print("OutOfRangeException");
		}
		
		sc.close();
	}
}