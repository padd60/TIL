package javaEx;

import java.util.Scanner;

public class scoreAvg04 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("이름, 국어, 영어, 수학 점수를 순서대로 입력하세요.");
		System.out.println("exit를 입력하면 종료됩니다.");
		while(true) {
			System.out.println("이름을 입력하세요");
			String name = scanner.next();
			if(name.equals("exit")) {
				break;
			}
			
			System.out.println("국어점수를 입력하세요");
			String ko = scanner.next();
			if(ko.equals("exit")) {
				break;
			}

		
			System.out.println("영어점수를 입력하세요");
			String en = scanner.next();
			if(en.equals("exit")) {
				break;
			}

			
			System.out.println("수학점수를 입력하세요");
			String math = scanner.next();
			if(math.equals("exit")) {
				break;
			}
			
			int Ko = Integer.parseInt(ko);
			int En = Integer.parseInt(en);
			int Math = Integer.parseInt(math);
			
			System.out.println(name + "학생의 평균점수는 " + (Ko+En+Math)/3 + "입니다.");

		}
		System.out.print("종료합니다...");
		scanner.close();
	}
}
