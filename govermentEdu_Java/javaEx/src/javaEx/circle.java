package javaEx;

import java.util.Scanner;

public class circle {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		final double PI = 3.14;
		
		System.out.print("구하고자하는 원의 반지름을 입력하세요 : ");
		int r = scanner.nextInt();
		
		System.out.println("원의 면적은 " + r*r*PI + "입니다.");
		scanner.close();
	}

}
