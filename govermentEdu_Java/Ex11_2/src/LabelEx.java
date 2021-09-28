import java.awt.Container;
import java.awt.FlowLayout;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class LabelEx extends JFrame{

	public LabelEx() {
		this.setTitle("레이블 예제");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container c = this.getContentPane();
		c.setLayout(new FlowLayout());
		
		ImageIcon beauty = new ImageIcon("images/beauty.jpg");
		JLabel imageLabel = new JLabel(beauty);
		c.add(imageLabel);
		
		ImageIcon normalIcon = new ImageIcon("images/normalIcon.gif");
		JLabel label = new JLabel("보고싶으면 전화하세요", normalIcon, SwingConstants.CENTER);
		c.add(label);
		
		this.setSize(400,600);
		this.setVisible(true);
	}
	public static void main(String[] args) {
		new LabelEx();
	}

}
