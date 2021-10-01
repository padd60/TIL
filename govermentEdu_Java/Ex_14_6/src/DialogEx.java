import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JTextField;

class MyDialog extends JDialog{
	private JTextField tf = new JTextField(10);
	private JButton okButton = new JButton("OK");
	
	public MyDialog(JFrame frame, String title) {
		super(frame,title,true);
		this.setLayout(new FlowLayout());
		add(tf);
		add(okButton);
		
		this.setSize(230,100);
		
		okButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
			
		});
	}
}

public class DialogEx extends JFrame {
	private MyDialog dialog;
	
	public DialogEx() {
		super("dialog Ex");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JButton btn = new JButton("Show Dialog");
		
		dialog = new MyDialog(this, "Test Dialog");
		
		btn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				dialog.setVisible(true);
				
			}
			
		});
		
		this.getContentPane().add(btn);
		this.setSize(250,200);
		this.setVisible(true);
	}
	public static void main(String[] args) {
		new DialogEx();
	}

}
