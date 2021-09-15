import java.util.Scanner;

public class DiviedeByZero {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		int dividend; // 분자
		int divisor; // 분모
		
		while(true) {
			try {
			System.out.print("나뉨수를 입력하세요 : ");
			dividend = scanner.nextInt();
			System.out.print("나눔수를 입력하세요 : ");
			divisor = scanner.nextInt();
			System.out.println(dividend + "를 " + divisor + "로 나누면 몫은 " + dividend/divisor + "입니다.");
			scanner.close();
			break;
			} catch(Exception e) {
				// e.printStackTrace(); // 디버깅할때
				System.out.println("0으로는 나눌 수 없습니다! 다시 입력하세요.");
			}
		}
		scanner.close();
	}

}
