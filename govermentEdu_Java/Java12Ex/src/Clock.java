
import java.awt.Container;
import java.awt.Font;
import java.util.Calendar;

import javax.swing.JFrame;
import javax.swing.JLabel;

class TimerRunnable implements Runnable{
	private JLabel timerLabel;
	private Calendar now;
	String hour;
	String minute;
	String second;
	
	public TimerRunnable(JLabel timerLabel) {
		this.timerLabel = timerLabel;
	}
	
	@Override
	public void run() {
		while(true) {
			now = Calendar.getInstance();
			this.hour = Integer.toString(now.get(Calendar.HOUR_OF_DAY));
			if(hour.length() < 2) {
				this.hour = "0" + Integer.toString(now.get(Calendar.HOUR_OF_DAY));
			}
			
			this.minute = Integer.toString(now.get(Calendar.MINUTE));
			if(minute.length() < 2) {
				this.minute = "0" + Integer.toString(now.get(Calendar.MINUTE));
			}
			
			this.second = Integer.toString(now.get(Calendar.SECOND));
			if(second.length() < 2) {
				this.second = "0" + Integer.toString(now.get(Calendar.SECOND));
			}
			
			String time = hour + " : " + minute + " : " + second;
			this.timerLabel.setText(time);
			
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
				return;
			}
		}
	}
	
}

public class Clock extends JFrame{
	JLabel timerLabel = new JLabel();
	
	public Clock() {
		this.setTitle("Clock");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container c = this.getContentPane();
		c.setLayout(null);
		
		timerLabel.setFont(new Font("Gothic", Font.ITALIC, 80));
		timerLabel.setSize(500, 100);
		timerLabel.setLocation(70, 70);
		c.add(timerLabel);
		
		TimerRunnable runnable = new TimerRunnable(timerLabel);
		Thread th = new Thread(runnable);
		
		th.start();
		
		this.setSize(600,300);
		this.setVisible(true);
	}
	public static void main(String[] args) {
		new Clock();
	}

}
