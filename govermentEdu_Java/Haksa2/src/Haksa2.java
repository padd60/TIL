import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

class LoginDialog extends JDialog{
	private JLabel id = new JLabel("아이디");
	private JTextField txtId = new JTextField(20);
	private JLabel pw = new JLabel("비밀번호");
	private JPasswordField txtPw = new JPasswordField(20);
	private JButton go = new JButton("확인");
	
	public LoginDialog(JFrame frame, String title) {
		super(frame, title, true);
		this.setLayout(null);
		this.add(id);
		id.setSize(70,30);
		id.setLocation(20, 25);
		this.add(txtId);
		txtId.setSize(200,30);
		txtId.setLocation(85, 25);
		this.add(pw);
		pw.setSize(70,30);
		pw.setLocation(20, 65);
		this.add(txtPw);
		txtPw.setSize(200,30);
		txtPw.setLocation(85, 65);
		this.add(go);
		go.setSize(100,40);
		go.setLocation(100, 120);
		
		this.setSize(300,200);
		
		go.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				boolean flag = false;
				
				if(txtId.getText().length() == 0 || txtPw.getPassword().length == 0) {
					flag = true;
				}
				
				if(flag == true) {		
					JOptionPane.showMessageDialog(rootPane, "내용을 입력해주세요", "Error", JOptionPane.ERROR_MESSAGE);
					return;
				}
				
				setVisible(false);
			}
			
		});
	}
}

public class Haksa2 extends JFrame{
	 JPanel panel;  // 메뉴별 화면이 출력되는 패널	
	LoginDialog login;
		
	public Haksa2() {
		this.setTitle("학사관리프로그램");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				
		this.createMenu();
		login = new LoginDialog(this,"로그인");
		
		panel = new JPanel();
		this.add(panel);
		
		this.setSize(480,500);
		this.setVisible(true);
	}
	
	private void createMenu() {
		//menu
		JMenuBar mb = new JMenuBar();
		JMenu menu1 = new JMenu("회원정보");		
		JMenu menu2 = new JMenu("학생관리");
		JMenu menu3 = new JMenu("도서관리");
		JMenuItem openLogin = new JMenuItem("Login");
		JMenuItem miStudent = new JMenuItem("학생정보");
		JMenuItem miBookRent = new JMenuItem("도서대출");

		
		openLogin.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				login.setVisible(true);
			}
		
		});
		menu1.add(openLogin);
		menu2.add(miStudent);
		menu3.add(miBookRent);
		
		mb.add(menu1);
		mb.add(menu2);
		mb.add(menu3);
		
		setJMenuBar(mb);
		
		miStudent.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
			    panel.removeAll(); //모든컴포넌트 삭제
			    panel.revalidate(); //다시 활성화
			    panel.repaint();    //다시 그리기
			    panel.add(new student()); //화면 생성.
			    panel.setLayout(null);//레이아웃적용안함
			}
			
		});
		
		miBookRent.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
			    panel.removeAll(); //모든컴포넌트 삭제
			    panel.revalidate(); //다시 활성화
			    panel.repaint();    //다시 그리기
			    panel.add(new bookRent()); //화면 생성.
			    panel.setLayout(null);//레이아웃적용안함
			}
			
		});
		
	}
	
	public static void main(String[] args) {
		new Haksa2();
	}

}

