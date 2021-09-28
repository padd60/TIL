import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Haksa extends JFrame{
	// TextField: txt, Button: btn, RadioButton: rdo
	JTextField txtId = null;
	JTextField txtName = null;
	JTextField txtDepartment = null;
	JTextField txtAddress = null;
	JTextArea taList = null;
	
	// CRUD 
	JButton btnInsert = null; // 등록 Create
	JButton btnSelect = null; // 목록 Read
	JButton btnUpdate = null; // 수정 Update
	JButton btnDelete = null; // 삭제 Delete
	
	public Haksa() {
		this.setTitle("학사관리프로그램");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.setLayout(new FlowLayout());
		
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
				System.out.println("등록");
			}
			
		});
		
		this.btnSelect = new JButton("목록");
		this.add(btnSelect);

		this.btnUpdate = new JButton("수정");
		this.add(btnUpdate);
		
		this.btnDelete = new JButton("삭제");
		this.add(btnDelete);
		
		
		
		this.setSize(320,500);
		this.setVisible(true);
	}
	public static void main(String[] args) {
		new Haksa();
	}

}
