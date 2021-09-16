
public class TouchMouse extends Mouse{
	public String Touch;
	
    public void mouseMove(String s) {
    	this.Touch = s;
    	if(this.Touch == "touch") {
    		System.out.println("마우스 터치 감지");
    	}else {
    		System.out.println("터치가 감지되지 않습니다. 다시 시도해보세요.");
    	}
    }
}
