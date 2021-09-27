import java.awt.Component;
import java.awt.Container;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class FlyingTextEx extends JFrame {
	private final int FLYING_UNIT = 10;
	private JLabel la = new JLabel("HELLO");
	
	public FlyingTextEx() {
		this.setTitle("상하좌우 키를 이용해 움직이기");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container c = this.getContentPane();
		c.setLayout(null);
		c.addKeyListener(new MyKeyListener());
		
		la.setLocation(50,50);
		la.setSize(100,20);
		c.add(la);
		
		this.setSize(300,300);
		this.setVisible(true);
		
		c.setFocusable(true);
		c.requestFocus();
		
		c.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent e) {
				Component com = (Component)e.getSource();
				com.setFocusable(true);
				com.requestFocus();
			}
		});
	}
	
	class MyKeyListener extends KeyAdapter{
		public void keyPressed(KeyEvent e) {
			int keyCode = e.getKeyCode();
			
			switch(keyCode) {
			case KeyEvent.VK_UP:{
				la.setLocation(la.getX(), la.getY() - FLYING_UNIT);
				break;
			}
			case KeyEvent.VK_DOWN:{
				la.setLocation(la.getX(), la.getY() + FLYING_UNIT);
				break;
			}
			case KeyEvent.VK_LEFT:{
				la.setLocation(la.getX() - FLYING_UNIT, la.getY());
				break;
			}
			case KeyEvent.VK_RIGHT:{
				la.setLocation(la.getX() + FLYING_UNIT, la.getY());
				break;
			}
			}
		}
	}
	public static void main(String[] args) {
		new FlyingTextEx();
	}

}
