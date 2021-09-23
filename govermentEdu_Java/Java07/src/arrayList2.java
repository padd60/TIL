import java.util.ArrayList;
import java.util.Scanner;

class Book{
	String t;
	String a;
	String p;
	String c;
	
	public Book(String t, String a, String p, String c) {
		this.t = t;
		this.a = a;
		this.p = p;
		this.c = c;
	}
	public String toString() {
		return t + " " + a + " " + p + " " + c;
	}
}

public class arrayList2 {

	public static void main(String[] args) {
		ArrayList<Book> book = new ArrayList<Book>();
		Scanner scanner = new Scanner(System.in);
		System.out.println("책제목을 입력하세요.");
		String title = scanner.nextLine();
		System.out.println("저자를 입력하세요.");
		String author = scanner.nextLine();
		System.out.println("출판사를 입력하세요.");
		String publish = scanner.nextLine();
		System.out.println("가격을 입력하세요.");
		String cost = scanner.nextLine();
		
		book.add(new Book(title, author, publish, cost));
		
		for(int i = 0; i < book.size(); i++) {
			Book b = book.get(i);
			System.out.println(b);
		}
		
		scanner.close();
	}

}
