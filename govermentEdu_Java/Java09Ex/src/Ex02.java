import java.awt.Container;
import java.util.Calendar;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class Ex02 extends JFrame {
	public Ex02 () {
		this.setTitle("지금 시간은?");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container c = this.getContentPane();
		c.setLayout(null);
		
		JLabel la = new JLabel();
		la.setSize(100, 30);
		la.setLocation(100, 110);
		Calendar cal = Calendar.getInstance();
		int hour = cal.get(Calendar.HOUR_OF_DAY);
		if(hour < 12) {
			la.setText("Good Morning");
		}else if(hour > 18) {
			la.setText("Good Evening");
		}else {
			la.setText("Good Afternoon");
		}
		c.add(la);
		
		this.setSize(300, 300);
		this.setVisible(true);
	}
	
	public static void main(String[] args) {
		new Ex02 ();
	}

}
