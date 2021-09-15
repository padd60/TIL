package javaEx;

import java.util.Scanner;

class Student5{
	String name;
	public Student5(String name) {
		this.name = name;
	}
}

public class Day05_04 {

	public static void main(String[] args) {

		Student5 [] s = new Student5 [5];
		Scanner scanner = new Scanner(System.in);
		
		for(int i = 0; i < s.length; i++) {
			System.out.println("학생의 이름을 입력하세요.");
			String n = scanner.nextLine();
			s[i] = new Student5(n);
		}
		
		for(int i = 0; i < s.length; i++) {
			System.out.println(s[i].name);
		}

		scanner.close();
	}

}
