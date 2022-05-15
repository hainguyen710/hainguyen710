package anotherJava;

import java.util.Scanner;

public class Java54 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		while(a<b) {
			if(a %3==0 && a %5==0 ) {
				System.out.println(a);
			}
			a++;
		}
		
	}

}
