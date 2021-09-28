import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.SwingConstants;

public class Ex01 extends JFrame {
	
	private JRadioButton [] radio = new JRadioButton [3];
	private String [] text = {"사과", "배", "체리"};
	private ImageIcon [] image = {
			new ImageIcon("images/apple.jpg"),
			new ImageIcon("images/pear.jpg"),
			new ImageIcon("images/cherry.jpg")
	};
	private JLabel imageLabel = new JLabel();
	
	private JButton btnPrev = new JButton("<");
	private JButton btnNext = new JButton(">");
	
	int num = 0;
	
	public Ex01() {
		this.setTitle("라디오버튼 예제");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container c = this.getContentPane();
		c.setLayout(new BorderLayout());
		
		JPanel radioPanel = new JPanel();
		radioPanel.setBackground(Color.GRAY);
		
		ButtonGroup g = new ButtonGroup();
		for(int i = 0; i < radio.length; i++) {
			radio[i] = new JRadioButton(text[i]);
			g.add(radio[i]);
			radioPanel.add(radio[i]);
			radio[i].addItemListener(new MyItemListener());
		}
		
		
		radio[0].setSelected(true);
		c.add(radioPanel, BorderLayout.NORTH);
		c.add(imageLabel, BorderLayout.CENTER);
		imageLabel.setHorizontalAlignment(SwingConstants.CENTER);	
		
		this.btnPrev.addActionListener(new ActionListener() {
			

			
			@Override
			public void actionPerformed(ActionEvent e) {
				num -= 1;
				if(num < 0) {
					num = 2;
				}
				System.out.println(num);
				radio[num].setSelected(true);
			}
			
		});
		c.add(btnPrev, BorderLayout.WEST);
		
		this.btnNext.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				num += 1;
				if(num > 2) {
					num = 0;
				}
				System.out.println(num);
				radio[num].setSelected(true);
			}
			
		});
		c.add(btnNext, BorderLayout.EAST);
		
		this.setSize(350,200);
		this.setVisible(true);
	}
	
	class MyItemListener implements ItemListener{

		@Override
		public void itemStateChanged(ItemEvent e) {
			if(e.getStateChange() == ItemEvent.DESELECTED) {
				return;
			}
			if(radio[0].isSelected()) {
				imageLabel.setIcon(image[0]);
			} else if(radio[1].isSelected()) {
				imageLabel.setIcon(image[1]);
			} else {
				imageLabel.setIcon(image[2]);
			}
		}
		
	}
	public static void main(String[] args) {
		new Ex01();
	}

}