import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class GraphicSample extends JFrame{
	private MyPanel panel = new MyPanel();
	

	public GraphicSample() {
		this.setTitle("Chart");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.setContentPane(panel);
		
		this.setSize(1200, 1200);
		this.setVisible(true);
	}
	
	class MyPanel extends JPanel{
		
		// 막대그래프 변수
		private int vGap = 10;
		private int height = 20;
		private int strX = 50;
		
		// 꺽은선 그래프 변수
		private int hGap = 100;
		
		// 파이 차트 변수
		private int n = 360 - ((360*200)/1100 + (360*300)/1100 + (360*350)/1100 + (360*250)/1100);
		
		@Override
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			
			g.drawString("분기별 매출", 300, 50);
			
			// 막대그래프
			g.fillRect(100, 100, 200, height);
			g.drawString("1/4분기", strX, 115);
			
			g.fillRect(100, 100 + height + vGap, 300, height);
			g.drawString("2/4분기", strX, 115 + height + vGap);
			
			g.fillRect(100, 100 + (height + vGap)*2, 350, height);
			g.drawString("3/4분기", strX, 115 + (height + vGap)*2);
			
			g.fillRect(100, 100 + (height + vGap)*3, 250, height);
			g.drawString("4/4분기", strX, 115 + (height + vGap)*3);
			
			// 꺽은선 그래프
			g.setColor(Color.RED);
			g.drawLine(100, 800, 100 + hGap, 800 - 200);
			g.drawLine(100 + hGap, 800 - 200, 100 + hGap*2, 800 - 300);
			g.drawLine(100 + hGap*2, 800 - 300, 100 + hGap*3, 800 - 350);
			g.drawLine(100 + hGap*3, 800 - 350, 100 + hGap*4, 800 - 250);
			g.setColor(Color.black);
			g.drawLine(100, 400, 100, 800);
			g.drawLine(100, 800, 600, 800);
			g.drawString("매출액(억)", 40, 500);
			g.drawString("1/4분기", 100 + hGap - 15, 820);
			g.drawString("2/4분기", 100 + hGap*2 - 15, 820);
			g.drawString("3/4분기", 100 + hGap*3 - 15, 820);
			g.drawString("4/4분기", 100 + hGap*4 - 15, 820);
			g.setColor(Color.red);
			g.fillOval(100 + hGap - 5, 800 - 200 - 5, 10, 10);
			g.fillOval(100 + hGap*2 - 5, 800 - 300 - 5, 10, 10);
			g.fillOval(100 + hGap*3 - 5, 800 - 350 - 5, 10, 10);
			g.fillOval(100 + hGap*4 - 5, 800 - 250 - 5, 10, 10);
			
			// 파이 차트
			g.setColor(Color.GREEN);
			g.fillArc(650, 350, 400, 400, 0, (360*200)/1100);
			g.setColor(Color.blue);
			g.fillArc(650, 350, 400, 400, (360*200)/1100, (360*300)/1100);
			g.setColor(Color.orange);
			g.fillArc(650, 350, 400, 400, (360*200)/1100 + (360*300)/1100, (360*350)/1100);
			g.setColor(Color.MAGENTA);
			g.fillArc(650, 350, 400, 400, (360*200)/1100 + (360*300)/1100 + (360*350)/1100, (360*250)/1100 + n);
			g.setColor(Color.black);
			g.drawString("1/4분기", 1050, 430);
			g.drawString("200억", 950, 490);
			g.drawString("2/4분기", 720, 320);
			g.drawString("300억", 780, 450);
			g.drawString("3/4분기", 600, 680);
			g.drawString("350억", 750, 630);
			g.drawString("4/4분기", 1030, 720);
			g.drawString("250억", 920, 630);
			
		}
		
	}
	
	public static void main(String[] args) {
		new GraphicSample();
	}

}
