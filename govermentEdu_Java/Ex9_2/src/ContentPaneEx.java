import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class ContentPaneEx extends JFrame {
	public ContentPaneEx() {
		this.setTitle("ContentPane과 JFrame");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container contentPane = this.getContentPane();
		contentPane.setBackground(Color.ORANGE);
		contentPane.setLayout(new FlowLayout(FlowLayout.LEFT,30,40));
		
		contentPane.add(new JButton("OK"));
		contentPane.add(new JButton("Cancel"));
		contentPane.add(new JButton("Ignore"));
		
		setSize(300, 150);
		setVisible(true);
	}

	public static void main(String[] args) {
		new ContentPaneEx();
	}

}
