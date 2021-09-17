
public class MainClass {

	public static void main(String[] args) {
		//Mouse
		Mouse m = new Mouse();
		m.leftButton = "왼쪽 버튼";
		m.rightButton = "오른쪽 버튼";
		System.out.println("leftButton은 " + m.leftButton + ", rightButton은 " + m.rightButton);
		m.mouseClick("leftClick");
		m.mouseClick("rightClick");
		m.mouseClick("click");
		m.mouseMove();
		
		System.out.println();
		
		//WheelMouse
		WheelMouse wm = new WheelMouse();
		wm.mouseClick("click");
		wm.mouseClick("leftClick");
		wm.mouseClick("rightClick");
		wm.Wheel = "휠 생성";
		System.out.println("마우스에 " + wm.Wheel);
		wm.mouseMove();
		wm.mouseMove("move");
		wm.mouseMove("wheel");
		
		System.out.println();
		
		//RazorMouse
		WheelMouse rm = new RazorMouse(); // 업캐스팅
		rm.mouseClick("click");
		rm.mouseClick("leftClick");
		rm.mouseClick("rightClick");
		RazorMouse rm2 = (RazorMouse)rm; // 다운캐스팅
		rm2.Razor = "레이저 장착";
		//((RazorMouse)rm).Razor = "레이저 장착";
		// 업캐스팅을 하면 자식 필드가 다 부모에 포함되는 것이 아니라 
		// 자식타입의 레퍼런스를 부모의 레퍼런스로 끌어올린 것이다.
		// 따라서 부모타입의 레퍼런스가 가르킨 인스턴스에 해당하는 필드변수와 메서드만 접근이 가능하다.
		// 여기서 자식클래스의 인스턴스에 접근하기 위해서는 
		// 다운캐스팅으로 레퍼런스변수를 자식타입의 레퍼런스변수로 변환한 후 접근해야 가능하다.
		System.out.println("마우스에 " + rm2.Razor);
		rm.mouseMove();
		rm.mouseMove("move");
		rm.mouseMove("razor");
		
		System.out.println();
		
		//TouchMouse
		TouchMouse tm = new TouchMouse();
		tm.Touch = "터치 장착";
		System.out.println("마우스에 " + tm.Touch);
		tm.mouseMove("touch");
		
		m = new TouchMouse();
		TouchMouse tm2 = (TouchMouse)m;
		tm2.leftButton = "test";
		System.out.print(tm2.leftButton);
	}

}
