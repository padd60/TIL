
public class RazorMouse extends WheelMouse {
	public String Razor;
	
    public void mouseMove(String s) { // 오버라이딩
    	this.Razor = s;
    	if(this.Razor == "razor") {
    		System.out.println("레이저 마우스 움직임 감지");
    	}else {
    		System.out.println("움직임이 감지되지 않습니다. 다시 시도해보세요.");
    	}
    }
}
