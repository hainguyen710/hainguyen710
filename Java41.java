package anotherJava;

import java.util.Scanner;

public class Java41 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("x:");
			int x = sc.nextInt();
			
		System.out.println("y:");
			int y = sc.nextInt();
			if(x > 0 && y > 0) {
				System.out.println("This point lies in the First quadrant");
				
			}if(x<0 && y<0) {
				System.out.println("This point lies in the Third quadrant");
			}if(x>0 && y < 0) {
				System.out.println("This point lies in the Fourth quarant");
			}if(x<0 && y>0) {
				System.out.println("This point lies in the Second quarant");
			}
		}
	}


