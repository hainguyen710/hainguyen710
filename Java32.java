package anotherJava;

import java.util.Scanner;

public class Java32 {
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		int n = sc.nextInt();
		if(n%2== 0) {
			System.out.println("n is an even number");
		}else {
			System.out.println("n is an odd number");
		}
	}

}
