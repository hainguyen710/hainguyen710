package anotherJava;

import java.util.Scanner;

public class Java56 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for(int i = 1; i <=100 ;i++) {
			if(i%2==0) {
				continue;
			}
			System.out.println(i);
		}
	}

}
