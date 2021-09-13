
public class AssignmentInDecoperator {

	public static void main(String[] args) {
		int a=3, b=3, c=3;
		a += 3;
		b *= 3;
		c %= 2;
		System.out.println("a=" + a + ", b=" + b + ", c=" + c);
		
		int d=3;
		a = d++;
		System.out.println("a=" + a + ", d=" + d);
		a = ++d;
		System.out.println("a=" + a + ", d=" + d);
		a = d--;
		System.out.println("a=" + a + ", d=" + d);
		a = --d;
		System.out.println("a=" + a + ", d=" + d);
		
		int x = 10;
		System.out.println("x=" + (x++));
		System.out.println("x=" + x);
		
		int m = 3, n = 5;
		
		System.out.println("두수의 차는 " + ((m > n) ? (m - n) : (n - m)));
	}

}
