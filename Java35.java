package anotherJava;

import java.util.Scanner;

public class Java35 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String a = sc.nextLine();
		String b = sc.nextLine();
		
		if(a.equals(b)) {
			System.out.println("two people have the same name");
			
		}else {
			System.out.println("two people dont't have the same name");
		}
		
	}

}
