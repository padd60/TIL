import java.util.ArrayList;

public class ArrayListSample {

	public static void main(String[] args) {
		ArrayList<Integer> a = new ArrayList<Integer>();
		
		a.add(10);
		a.add(20);
		
		System.out.println(a.get(0));
		System.out.println(a.get(1));
		
		ArrayList<Integer> b = new ArrayList<Integer>();
		for(int i = 0; i < 10; i++) {
			b.add(i);
			System.out.println(b.get(i));
		}
	}

}
