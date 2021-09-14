package javaEx;

public class star04 {

	public static void main(String[] args) {
		
		String[][] star = new String [5][5];
		
		for(int i = 0; i < star.length; i++) {
			for(int j = i; j < star.length; j++) {
				star[i][j] = "*";
				System.out.print(star[i][j]);
			}
			System.out.println();
		}

	}

}
