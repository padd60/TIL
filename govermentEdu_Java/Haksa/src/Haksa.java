import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

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

public class Haksa extends JFrame{
	JTextField txtId = null;
	JTextField txtName = null;
	JTextField txtDepartment = null;
	JTextField txtAddress = null;
	JTextArea taList = null;
	LoginDialog login;
	
	// CRUD 
	JButton btnInsert = null; // 등록 Create
	JButton btnSelect = null; // 목록 Read
	JButton btnUpdate = null; // 수정 Update
	JButton btnDelete = null; // 삭제 Delete
	
	public Haksa() {
		this.setTitle("학사관리프로그램");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.setLayout(new FlowLayout());
		
		this.createMenu();
		login = new LoginDialog(this,"로그인");
		
		this.add(new JLabel("학번"));
		this.txtId = new JTextField(22);
		this.add(txtId);
		
		this.add(new JLabel("이름"));
		this.txtName = new JTextField(22);
		this.add(txtName);
		
		this.add(new JLabel("학과"));
		this.txtDepartment = new JTextField(22);
		this.add(txtDepartment);
		
		this.add(new JLabel("주소"));
		this.txtAddress = new JTextField(22);
		this.add(txtAddress);
		
		this.taList = new JTextArea(15,25);
		this.add(new JScrollPane(taList));
		
		this.btnInsert = new JButton("등록");
		this.add(btnInsert);
		this.btnInsert.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				JTextField [] check = {txtId, txtName, txtDepartment, txtAddress};
				boolean flag = false;
				
				for(int i = 0; i < check.length; i++) {
					if(check[i].getText().length() == 0) {
						flag = true;
					}
				}
				
				if(flag == true) {		
					JOptionPane.showMessageDialog(rootPane, "내용을 입력해주세요", "Error", JOptionPane.ERROR_MESSAGE);
					return;
				}
				
				for(int i = 0; i < check.length; i++) {
					check[i].setText("");
				}
				
				JOptionPane.showMessageDialog(rootPane, "등록되었습니다", "Message", JOptionPane.INFORMATION_MESSAGE);
				
			}
			
		});
		
		this.btnSelect = new JButton("목록");
		this.add(btnSelect);
		this.btnSelect.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try { 
					Class.forName("com.mysql.jdbc.Driver");
					Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/sampledb", "root","58545256");
					System.out.println("연결 성공");
					
					Statement stmt = conn.createStatement();
					
					//insert
					//stmt.executeUpdate("insert into student values('1234567', '왕건', '국문학과')");
					
					//update
					//stmt.executeUpdate("update student set name='홍길동' where id = '1234567'");
					
					//delete
					//stmt.executeUpdate("delete from student where id = '1234567'");
					
					ResultSet rs = stmt.executeQuery("select * from student order by name");
					while(rs.next()) {
						System.out.println(rs.getString("id")); 
						System.out.println(rs.getString("name")); 
						System.out.println(rs.getString("dept"));
					}
					rs.close();
					stmt.close();
					conn.close();
				} catch (ClassNotFoundException e1) { e1.printStackTrace();
				} catch (SQLException e1) {
					System.out.println("연결 실패");
					e1.printStackTrace();
				}
				
			}
			
		});

		this.btnUpdate = new JButton("수정");
		this.add(btnUpdate);
		
		this.btnDelete = new JButton("삭제");
		this.add(btnDelete);
		this.btnDelete.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int result = JOptionPane.showConfirmDialog(null, "삭제하시겠습니까?", "confirm", JOptionPane.YES_NO_CANCEL_OPTION);
				if(result == JOptionPane.YES_OPTION) {
					//Oracle 연동 삭제(delete)처리
					
					// 삭제 처리 후 메세지출력
					JOptionPane.showMessageDialog(null, "삭제되었습니다", "message", JOptionPane.INFORMATION_MESSAGE);
				}
			}
			
		});
		
		
		this.setSize(320,500);
		this.setVisible(true);
	}
	
	private void createMenu() {
		JMenuBar mb = new JMenuBar();
		JMenu Menu = new JMenu("Menu");
		JMenuItem openItem = new JMenuItem("Login");
		
		openItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				login.setVisible(true);
			}
			
		});
		Menu.add(openItem);
		mb.add(Menu);
		setJMenuBar(mb);
	}
	
	public static void main(String[] args) {
		new Haksa();
	}

}

