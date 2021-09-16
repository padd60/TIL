class Sample {
	public int a;
	private int b;
	int c; // 디폴트 접근 지정자
	public Sample() {}
}


public class AccessEx {

	public static void main(String[] args) {
	Sample s = new Sample();
	s.a = 10;
//	s.b = 10; // 같은 클래스가 아니라 private에 의해 접근이 막힌다.
	s.c = 10;
	}

}
