import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JToolBar;

public class ToolBarEx extends JFrame{
	private Container contentPane;
	JButton btnNew = null;
	public ToolBarEx() {
		this.setTitle("ToolBar Example");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.contentPane = this.getContentPane();
		this.createToolBar();
		this.setSize(400,200);
		this.setVisible(true);
	}
	
	private void createToolBar() {
		JToolBar toolBar = new JToolBar("Sample Menu");
		toolBar.setBackground(Color.LIGHT_GRAY);
		
		btnNew = new JButton("New");
		btnNew.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// new 메뉴를 클릭했을때 발생하는 작업
				System.out.println("NEW");
			}
			
		});
		toolBar.add(btnNew);
		btnNew.setToolTipText("NEW");
		toolBar.add(new JButton(new ImageIcon("images/open.jpg")));
		toolBar.addSeparator();
		toolBar.add(new JButton(new ImageIcon("images/save.jpg")));
		toolBar.add(new JLabel("search"));
		toolBar.add(new JTextField("text field"));
		
		JComboBox<String> combo = new JComboBox<String>();
		combo.addItem("Java");
		combo.addItem("C#");
		combo.addItem("C");
		combo.addItem("C++");
		toolBar.add(combo);
		
		this.contentPane.add(toolBar, BorderLayout.NORTH);
	}
	public static void main(String[] args) {
		new ToolBarEx();
	}

}
