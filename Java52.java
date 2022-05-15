package anotherJava;

import java.util.Scanner;

public class Java52 {
	public static void main(String[] args) {
		int i = 1, count = 0;
		Scanner sc  = new Scanner(System.in);
		int n = sc.nextInt();
		while(i <=n) {
			if(n%i == 0) {
			System.out.println(i);
			count++;
		}
		i++;
	}
		System.out.println(count);

}
}