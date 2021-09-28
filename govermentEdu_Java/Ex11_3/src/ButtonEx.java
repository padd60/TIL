import java.awt.Container;
import java.awt.FlowLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;

public class ButtonEx extends JFrame {

	public ButtonEx() {
		this.setTitle("버튼 예제");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container c = this.getContentPane();
		c.setLayout(new FlowLayout());
		
		ImageIcon normal = new ImageIcon("images/normalIcon.gif");
		ImageIcon pressed = new ImageIcon("images/pressedIcon.gif");
		ImageIcon rollover = new ImageIcon("images/rolloverIcon.gif");
		
		JButton btn = new JButton("call~~");
		btn.setIcon(normal);
		btn.setPressedIcon(pressed);
		btn.setRolloverIcon(rollover);
		c.add(btn);
		
		this.setSize(250,150);
		this.setVisible(true);
	}
	public static void main(String[] args) {
		new ButtonEx();
	}

}
