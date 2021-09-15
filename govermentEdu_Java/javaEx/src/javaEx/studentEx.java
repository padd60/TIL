package javaEx;

import java.util.Scanner;

public class studentEx {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("이름, 학번, 학과를 순서대로 한칸씩 띄어서 입력해주세요.");
		String name = scanner.next();
		int stNum = scanner.nextInt();
		String stSubject = scanner.next();
		
		System.out.println(name + "님 " + stSubject +"의 " + stNum + "으로 학생신분이 등록완료되었습니다.");

		scanner.close();
	}

}
