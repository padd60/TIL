class Rectangle{
	String name;
}


public class ClassSample {

	public static void main(String[] args) {
		Circle c = new Circle();
		
		c.name = "피자";
		System.out.println(c.name);
		
		Rectangle r = new Rectangle();
		
		r.name = "스마트폰";
		System.out.println(r.name);
	}

}
