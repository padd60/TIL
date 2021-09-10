package com.naver;

	/**
	 * Hello World를 출력하는 클래스
	 * 
	 * @author kimjunghwan
	 *
	 */

public class HelloWorld3 {
	public static int sum(int n, int m) {
		return n+m;
	}
	
	/**
	 * 프로그램의 시작점, 자동으로 호출
	 * 
	 * @param args 실행될 때 전달, 옵
	 */

	public static void main(String[] args) {
		int i=20;
		int s;
		char a;
//		s = sum(i,10);
//		System.out.println(s);
		
		System.out.println(sum(i,10));
		
//		System.out.print("Hello World!");
	}

}
