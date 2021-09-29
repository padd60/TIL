import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class GraphicsDrawLineEx extends JFrame{

	private MyPanel panel = new MyPanel();
	
	public GraphicsDrawLineEx() {
		this.setTitle("drawLine 사용 예제");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setContentPane(panel);
		
		this.setSize(200,170);
		this.setVisible(true);
	}
	
	class MyPanel extends JPanel{
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.setColor(Color.RED);
			g.drawLine(20, 20, 100, 100);
		}
	}
	public static void main(String[] args) {
		new GraphicsDrawLineEx();
	}

}
