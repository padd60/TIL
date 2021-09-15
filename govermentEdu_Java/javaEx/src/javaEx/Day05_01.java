package javaEx;

import java.util.Scanner;

public class Day05_01 {

	public static void main(String[] args) {
		String [] student = new String [5];
		String [] subject = new String [5];
		
		Scanner scanner = new Scanner(System.in);
		
		for(int i = 0; i < student.length; i++) {			
			System.out.println("등록할 학생의 이름을 입력하고 엔터를 누르세요.");
			student[i] = scanner.nextLine();
			
			System.out.println("등록할 학생의 학과를 입력하고 엔터를 누르세요.");
			subject[i] = scanner.nextLine();
		}
		
		for(int i = 0; i < student.length; i++) {
			
			System.out.print(student[i] + " : " + subject[i]);
			System.out.println();
		}
		
		scanner.close();
	}

}
