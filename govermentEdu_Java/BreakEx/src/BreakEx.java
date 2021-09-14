import java.util.Scanner;

public class BreakEx {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("exit를 입력하면 종료됩니다.");
		while(true) {
			System.out.print(">>");
			String text = scanner.nextLine();
			// nextLine은 엔터키 기준으로 토큰을 구분해 받아옴, 띄워쓰기는 상관 안함
			if(text.equals("exit")) {
				break;
			}
		}
		System.out.println("종료합니다...");
		scanner.close();
	}

}
