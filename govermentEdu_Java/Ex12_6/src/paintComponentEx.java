import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Graphics;

import javax.swing.JButton;
import javax.swing.JFrame;

public class paintComponentEx extends JFrame{
	
	public paintComponentEx() {
		this.setTitle("새로운 버튼 만들기");	
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = this.getContentPane();
		c.setLayout(new FlowLayout());
		MyButton btn = new MyButton("New Button");
		btn.setOpaque(true);
		btn.setBackground(Color.CYAN);
		c.add(btn);
		this.setSize(250,200);
		this.setVisible(true);
	}
	class MyButton extends JButton{
		public MyButton(String s) {
			super(s);
		}
		
		@Override
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.setColor(Color.RED);
			g.drawOval(0, 0, this.getWidth()-1, this.getHeight()-1);
		}
		
	}
	public static void main(String[] args) {
		new paintComponentEx();
	}

}
