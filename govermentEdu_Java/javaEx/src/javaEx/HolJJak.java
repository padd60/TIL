package javaEx;

import java.util.Scanner;

public class HolJJak {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("아무 숫자나 입력해주세요.");
		int num = scanner.nextInt();
		
		if(num%2 == 0) {
			System.out.println("짝수입니다!");
		}else {
			System.out.println("홀수입니다!");
		}
		scanner.close();
	}

}
