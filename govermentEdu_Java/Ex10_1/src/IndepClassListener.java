import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class IndepClassListener extends JFrame implements ActionListener{
	public IndepClassListener(){
		this.setTitle("이벤트처리");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container c = this.getContentPane();
		c.setLayout(new FlowLayout());
		JButton btn = new JButton("Action");
		btn.addActionListener(new MyActionListener());
		c.add(btn);
		
		JButton btn2 = new JButton("Action2");
		btn2.addActionListener(new MyActionListener());
		c.add(btn2);
		
		JButton btn3 = new JButton("Action3");
		btn3.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("버튼3번이 클릭됨");				
			}
			
		});
		c.add(btn3);
		
		JButton btn4 = new JButton("Action4");
		btn4.addActionListener(this);
		c.add(btn4);
		
		this.setSize(350, 150);
		this.setVisible(true);
	}
	
	private class MyActionListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			JButton b = (JButton)e.getSource(); // 이벤트가 발생한 컴포넌트(버튼)을 불러온다.
			if(b.getText().equals("Action")) {
				b.setText("액션");
			}else if (b.getText().equals("Action2")){
				b.setText("두번째 버튼");
			}
			IndepClassListener.this.setTitle(b.getText());
		}
	}
	
	public static void main(String[] args) {
		new IndepClassListener();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("버튼4가 클릭됨");		
	}

}


