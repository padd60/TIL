import java.util.Scanner;

public class Id {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		while(true) {
			System.out.println("아이디를 입력하세요.");
			String id = scanner.next();
			if(id.contains("!") || id.contains("@") || id.contains("#") || id.contains("$") || id.contains("%") || id.contains("^")) {
				System.out.println("아이디에 !, @, #, $, %, ^가 포함되면 안됩니다.");
			} else {
				System.out.println(id);
				break;
			}
		}
		scanner.close();
	}

}
