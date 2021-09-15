package javaEx;

import java.util.Scanner;

class Triangle {
	int width;
	int height;
	public Triangle() {
		this.width = 0;
		this.height = 0;
	}
}

public class Day05_03 {

	public static void main(String[] args) {
		Triangle t = new Triangle();
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("구하고자 하는 삼각형의 가로길이를 입력하세요.");
		t.width = scanner.nextInt();
		System.out.println("구하고자 하는 삼각형의 세로길이를 입력하세요.");
		t.height = scanner.nextInt();
		
		System.out.print("삼각형의 면적은 " + (t.width*t.height)/2 + "입니다.");
		scanner.close();
	}

}
