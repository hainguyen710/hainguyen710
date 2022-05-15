package anotherJava;

import java.util.Scanner;

public class Java53 {
	public static void main(String[] args) {
		int count = 1;
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b= sc.nextInt();
		while(b>0) {
			count *= a;
			b--;
			
		}
		System.out.println(count);
				
	}

}
