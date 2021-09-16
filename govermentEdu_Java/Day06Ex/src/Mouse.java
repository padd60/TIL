
public class Mouse {
	public String leftButton;
	public String rightButton;
	
	public void mouseMove() {
		System.out.println("마우스 움직임 감지");
	}
	public void mouseClick(String c) {
		if(c == "leftClick") {
			this.leftButton = "click";
			System.out.println("왼쪽 버튼 클릭!");
		}else if(c == "rightClick") {
			this.rightButton = "click";
			System.out.println("오른쪽 버튼 클릭!");
		}else {
			System.out.println("마우스 버튼을 정확히 클릭해주시기 바랍니다.");
		}
	}
}
