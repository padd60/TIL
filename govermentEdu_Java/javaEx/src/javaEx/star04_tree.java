package javaEx;

public class star04_tree {

	public static void main(String[] args) {
		for(int i = 1; i < 6; i++) {
			for(int j = 0; j < 5 - i; j++) {
				System.out.print(" ");
			}
			for(int j = 0; j < 2*i - 1; j++) {
				System.out.print("*");
			}
			System.out.println();
		}

	}

}