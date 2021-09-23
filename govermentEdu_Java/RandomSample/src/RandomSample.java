import java.util.Random;

public class RandomSample {

	public static void main(String[] args) {
		// Math 클래스의 메서드 사용 인스턴스 생성 필요 없음(static)
		int n = (int)(Math.random()*100 + 1);
		// 0.0 ~ .999... * 100 + 1 = 1 ~ 100.99... / int로 강제 캐스팅하면 뒤 소수점 버림 
		System.out.println(n);
		
		// Random 클래스 사용 인스턴스 생성필요
		Random r = new Random();
		
		int m = r.nextInt(); // int 범위의 모든 정수 나옴
		int o = r.nextInt(100); // 0~99까지의 정수 나옴
		System.out.println(m);
		System.out.println(o);
	}

}
