import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class paintJPanelEx extends JFrame {

	private MyPanel panel = new MyPanel();
	
	public paintJPanelEx() {
		this.setTitle("paintComopent + JPanel 예제");	
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setContentPane(panel);
		this.setSize(250,200);
		this.setVisible(true);
		}
	
	class MyPanel extends JPanel{
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.setColor(Color.BLUE);
			g.drawRect(10, 10, 50, 50);
			g.drawRect(50, 50, 50, 50);
			g.setColor(Color.MAGENTA);
			g.drawRect(90, 90, 50, 50);
		}
	}
	public static void main(String[] args) {
		new paintJPanelEx();
	}

}
