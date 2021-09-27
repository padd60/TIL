import java.awt.Container;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Ex01 extends JFrame {
	public Ex01() {
		this.setTitle("Flow Ex");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		FlowLayout flow = new FlowLayout();
		
		Container c = this.getContentPane();
		c.setLayout(flow);
		flow.setAlignment(FlowLayout.LEFT);
		flow.setHgap(50);
		flow.setVgap(10);
		c.add(new JLabel("이름 "));
		c.add(new JTextField(10));
		c.add(new JLabel("학번 "));
		c.add(new JTextField(10));
		c.add(new JLabel("학과 "));
		c.add(new JTextField(10));
		c.add(new JLabel("과목 "));
		c.add(new JTextField(10));
		
		
		setSize(300, 200);
		setVisible(true);
	}
	public static void main(String[] args) {
		new Ex01();
	}

}
