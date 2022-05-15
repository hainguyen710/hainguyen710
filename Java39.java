package anotherJava;

import java.util.Scanner;

public class Java39 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Insert scored please: ");
		int a = sc.nextInt();
		if(a>=0 && a <=10) {
			System.out.println("The score is valid");
		}else {
			System.out.println("The score is not valid");
		}
	}

}
