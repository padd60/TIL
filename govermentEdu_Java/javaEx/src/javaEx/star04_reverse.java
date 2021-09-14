package javaEx;

public class star04_reverse {

	public static void main(String[] args) {
		
		String[] star = new String [5];
		
		for(int i = 0; i < star.length; i++) {
			for(int j = 0; j < i+1; j++) {
				star[j] = "*";
				System.out.print(star[j]);
			}
			System.out.println();
		}

	}

}
