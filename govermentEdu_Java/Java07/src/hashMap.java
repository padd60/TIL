import java.util.HashMap;
import java.util.Scanner;

public class hashMap {

	public static void main(String[] args) {
		HashMap<String, String> book = new HashMap<String, String>();
		Scanner scanner = new Scanner(System.in);
		System.out.println("책제목을 입력하세요.");
		String title = scanner.nextLine();
		System.out.println("저자를 입력하세요.");
		String author = scanner.nextLine();
		System.out.println("출판사를 입력하세요.");
		String publish = scanner.nextLine();
		System.out.println("가격을 입력하세요.");
		String cost = scanner.nextLine();
		
		book.put("책제목", title);
		book.put("저자", author);
		book.put("출판사", publish);
		book.put("가격", cost);

		while(true) {
			System.out.println("찾고 싶은 책의 정보는 ?");
			String s = scanner.nextLine();
			if(s.equals("제목")) {
				System.out.println(book.get("책제목"));
				break;
			} else if(s.equals("저자")) {
				System.out.println(book.get("저자"));
				break;
			} else if(s.equals("출판사")) {
				System.out.println(book.get("출판사"));
				break;
			} else if(s.equals("가격")) {
				System.out.println(book.get("가격"));
				break;
			}
		}
		scanner.close();
	}

}
