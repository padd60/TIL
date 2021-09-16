
public class WheelMouse extends Mouse {
	public String Wheel;
	
    public void mouseMove(String s) { // 오버로딩
    	this.Wheel = s;
    	if(this.Wheel == "wheel") {
    		System.out.println("스크롤 움직임 감지");
    	}else {
    		System.out.println("움직임이 감지되지 않습니다. 다시 시도해보세요.");
    	}
    }
}
