import java.util.ArrayList;
import java.util.Scanner;

public class arrayList {

	public static void main(String[] args) {
		ArrayList<String> book = new ArrayList<String>();
		Scanner scanner = new Scanner(System.in);
		System.out.println("책제목을 입력하세요.");
		String title = scanner.nextLine();
		System.out.println("저자를 입력하세요.");
		String author = scanner.nextLine();
		System.out.println("출판사를 입력하세요.");
		String publish = scanner.nextLine();
		System.out.println("가격을 입력하세요.");
		String cost = scanner.nextLine();
		
		book.add(title);
		book.add(author);
		book.add(publish);
		book.add(cost);
		
		String result = "";
		for(int i = 0; i < book.size(); i++) {
			result += book.get(i) + " ";
		}
		System.out.println(result);
		scanner.close();
	}

}
