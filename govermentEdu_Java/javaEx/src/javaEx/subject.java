package javaEx;

import java.util.Scanner;

public class subject {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("순서대로 국어, 영어, 수학의 점수를 한칸씩 띄워서 입력해주세요.");
		int ko = scanner.nextInt();
		int en = scanner.nextInt();
		int math = scanner.nextInt();
		
		System.out.println("세 과목의 평균값은 " + (ko + en + math)/3 + "입니다.");
		
		scanner.close();
	}

}
