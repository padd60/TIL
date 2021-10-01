import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;

public class TabbedPanelEx extends JFrame {
	public TabbedPanelEx() {
		this.setTitle("tabPane Ex");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JTabbedPane pane = createTabbedPane();
		this.getContentPane().add(pane, BorderLayout.CENTER);
		this.setSize(300,300);
		this.setVisible(true);
	}
	private JTabbedPane createTabbedPane() {
		JTabbedPane pane = new JTabbedPane();
		
		pane.addTab("tab1", new JLabel(new ImageIcon("images/img1.jpg")));
		
		pane.addTab("tab2", new MyPanel2());
		
		pane.addTab("tab3", new MyPanel());
		
		return pane;
	}
	
	class MyPanel2 extends JPanel{
		JLabel id = new JLabel("아이디");
		JLabel pw = new JLabel("비밀번호");
		JButton login = new JButton("로그인");
		JTextField txt1 = new JTextField(15);
		JTextField txt2 = new JTextField(15);
		
		public MyPanel2() {
			this.setBackground(Color.LIGHT_GRAY);
			this.add(id);
			this.add(txt1);
			this.add(pw);
			this.add(txt2);
			this.add(login);
		}
		
	}
	
	class MyPanel extends JPanel{
		public MyPanel() {
			this.setBackground(Color.YELLOW);
		}

		@Override
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.setColor(Color.RED);
			g.fillRect(10, 10, 50, 50);
			g.setColor(Color.BLUE);
			g.fillOval(10, 70, 50, 50);
			g.setColor(Color.BLACK);
			g.drawString("tab3에 들어가는 JPanel", 30, 50);
		}
		
		
	}
	public static void main(String[] args) {
		new TabbedPanelEx();
	}
}
