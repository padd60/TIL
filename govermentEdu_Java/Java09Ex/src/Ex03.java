import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Ex03 extends JFrame {
	static JLabel la = new JLabel();

	public Ex03 () {
		this.setTitle("지금 시간은?");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container c = this.getContentPane();
		c.setLayout(null);
		
		la.setSize(200, 30);
		la.setLocation(65, 80);
		c.add(la);

		JButton btn1 = new JButton("외부클래스");
		btn1.addActionListener(new MyActionListener());
		btn1.setSize(100,30);
		btn1.setLocation(15, 180);
		c.add(btn1);
		
		JButton btn2 = new JButton("내부클래스");
		btn2.addActionListener(new MyActionListener2());
		btn2.setSize(100, 30);
		btn2.setLocation(115, 180);
		c.add(btn2);
		
		JButton btn3 = new JButton("익명클래스");
		btn3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Calendar cal = Calendar.getInstance();
				Date now = cal.getTime();
				la.setText(String.format("%tY년 %<tm월 %<td일 %<tH시 %<tM분 %<tS초", now));
			}
		});
		btn3.setSize(100,30);
		btn3.setLocation(215, 180);
		c.add(btn3);
		
		this.setSize(330, 300);
		this.setVisible(true);
		
	}
	
	class MyActionListener2 implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			JButton b = (JButton)e.getSource();
			Calendar cal = Calendar.getInstance();
			Date now = cal.getTime();
			la.setText(String.format("%tY년 %<tm월 %<td일 %<tH시 %<tM분 %<tS초", now));
		}
	}
	
	public static void main(String[] args) {
		new Ex03 ();
	}

}

class MyActionListener implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		Calendar cal = Calendar.getInstance();
		Date now = cal.getTime();
		Ex03.la.setText(String.format("%tY년 %<tm월 %<td일 %<tH시 %<tM분 %<tS초", now));
	}
}
