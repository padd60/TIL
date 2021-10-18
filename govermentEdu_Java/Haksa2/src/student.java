import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
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
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class student extends JPanel{
	JTextField txtId = null;
	JTextField txtName = null;
	JTextField txtDepartment = null;
	JTextField txtAddress = null;
		
	// CRUD 
	JButton btnInsert = null; // 등록 Create
	JButton btnSelect = null; // 목록 Read
	JButton btnUpdate = null; // 수정 Update
	JButton btnDelete = null; // 삭제 Delete
	
	//search
	JButton btnSearch = null;
	
	//table, model
	DefaultTableModel model=null; // 테이블의 데이터
	JTable table=null;
	

	
	public student() {
		
		this.setLayout(new FlowLayout());
				
		this.add(new JLabel("학번"));
		this.txtId = new JTextField(15);
		this.add(txtId);
		
		this.btnSearch = new JButton("검색");
		this.add(btnSearch);
		this.btnSearch.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try { 
					Class.forName("com.mysql.jdbc.Driver");
					Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/sampledb", "root","58545256");
					System.out.println("연결 성공");
					
					Statement stmt = conn.createStatement();
					
					
					ResultSet rs = stmt.executeQuery("select * from student where id = '"+ txtId.getText() +"' order by name");
					
				    //JTable 초기화
				    model.setNumRows(0);
					
					while(rs.next()) {
//						System.out.println(rs.getString("id")); 
//						System.out.println(rs.getString("name")); 
//						System.out.println(rs.getString("dept"));
						
//						taList.append(rs.getString("id") + '\t' + rs.getString("name") + '\t' + rs.getString("dept") + '\n');
						
						String [] row = new String[4];
						row[0]=rs.getString("id");
						row[1]=rs.getString("name");
						row[2]=rs.getString("dept");
						row[3]=rs.getString("address");
						model.addRow(row);
						
						txtId.setText(rs.getString("id"));
						txtName.setText(rs.getString("name"));
						txtDepartment.setText(rs.getString("dept"));
						txtAddress.setText(rs.getString("address"));
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
		
		this.add(new JLabel("이름"));
		this.txtName = new JTextField(22);
		this.add(txtName);
		
		this.add(new JLabel("학과"));
		this.txtDepartment = new JTextField(22);
		this.add(txtDepartment);
		
		this.add(new JLabel("주소"));
		this.txtAddress = new JTextField(22);
		this.add(txtAddress);
		
		String[] colname= {"학번", "이름", "학과", "주소"};
		this.model=new DefaultTableModel(colname,0);
		this.table=new JTable(model); // model과 table 바인딩
		table.setPreferredScrollableViewportSize(new Dimension(300,250)); //table 크기
		this.add(table);
		JScrollPane sp=new JScrollPane(table); // 스크롤 구현
	    this.add(sp);
		
	    this.table.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				table=(JTable)e.getComponent();
				model=(DefaultTableModel)table.getModel();
				txtId.setText((String)model.getValueAt(table.getSelectedRow(), 0)); // 학번
				txtName.setText((String)model.getValueAt(table.getSelectedRow(), 1)); // 이름
				txtDepartment.setText((String)model.getValueAt(table.getSelectedRow(), 2)); // 학과
				txtAddress.setText((String)model.getValueAt(table.getSelectedRow(), 3)); // 주소
			} 

			@Override
			public void mousePressed(MouseEvent e) {}

			@Override
			public void mouseReleased(MouseEvent e) {}

			@Override
			public void mouseEntered(MouseEvent e) {}

			@Override
			public void mouseExited(MouseEvent e) {}
	    	
	    });
		
		this.btnInsert = new JButton("등록");
		this.add(btnInsert);
		this.btnInsert.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// sql 연동
				try { 
					Class.forName("com.mysql.jdbc.Driver");
					Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/sampledb", "root","58545256");
					System.out.println("연결 성공");
					
					Statement stmt = conn.createStatement();
					
					//insert
					stmt.executeUpdate("insert into student values('"+ txtId.getText() +"', '"+ txtName.getText() +"', '"+ txtDepartment.getText() + "', '" + txtAddress.getText() + "')");
					
					//update
					//stmt.executeUpdate("update student set name='홍길동' where id = '1234567'");
					
					//delete
					//stmt.executeUpdate("delete from student where id = '1234567'");
					

					
					ResultSet rs = stmt.executeQuery("select * from student order by name");
					
				    //JTable 초기화
				    model.setNumRows(0);
					
					while(rs.next()) {
						
//						taList.append(rs.getString("id") + '\t' + rs.getString("name") + '\t' + rs.getString("dept") + '\n');
						
						String [] row = new String[4];
						row[0]=rs.getString("id");
						row[1]=rs.getString("name");
						row[2]=rs.getString("dept");
						row[3]=rs.getString("address");
						model.addRow(row);
					}
					rs.close();
					stmt.close();
					conn.close();
				} catch (ClassNotFoundException e1) { e1.printStackTrace();
				} catch (SQLException e1) {
					System.out.println("연결 실패");
					e1.printStackTrace();
				}
				
				JTextField [] check = {txtId, txtName, txtDepartment, txtAddress};
				boolean flag = false;
				
				for(int i = 0; i < check.length; i++) {
					if(check[i].getText().length() == 0) {
						flag = true;
					}
				}
				
				if(flag == true) {
					JOptionPane.showMessageDialog(getRootPane(), "내용을 입력해주세요", "Error", JOptionPane.ERROR_MESSAGE);
					return;
				}
				
				JOptionPane.showMessageDialog(getRootPane(), "등록되었습니다", "Message", JOptionPane.INFORMATION_MESSAGE);
				
				for(int i = 0; i < check.length; i++) {
					check[i].setText("");
				}
				
				
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
					
					ResultSet rs = stmt.executeQuery("select * from student order by name");
					
				    //JTable 초기화
				    model.setNumRows(0);
					
					while(rs.next()) {
//						System.out.println(rs.getString("id")); 
//						System.out.println(rs.getString("name")); 
//						System.out.println(rs.getString("dept"));						
//						taList.append(rs.getString("id") + '\t' + rs.getString("name") + '\t' + rs.getString("dept") + '\n');
						
						String [] row = new String[4];
						row[0]=rs.getString("id");
						row[1]=rs.getString("name");
						row[2]=rs.getString("dept");
						row[3]=rs.getString("address");
						model.addRow(row);
						
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
		this.btnUpdate.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try { 
					Class.forName("com.mysql.jdbc.Driver");
					Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/sampledb", "root","58545256");
					System.out.println("연결 성공");
					
					Statement stmt = conn.createStatement();
					
					//update
					stmt.executeUpdate("update student set name='"+ txtName.getText() +"', dept='"+ txtDepartment.getText() + "', address='"+ txtAddress.getText() +"' where id = '"+ txtId.getText() +"'");
					
					//delete
					//stmt.executeUpdate("delete from student where id = '1234567'");
					
					
					ResultSet rs = stmt.executeQuery("select * from student where id = '"+ txtId.getText() +"' order by name");
					
				    //JTable 초기화
				    model.setNumRows(0);
					
					while(rs.next()) {
						
//						taList.append(rs.getString("id") + '\t' + rs.getString("name") + '\t' + rs.getString("dept") + '\n');
					
						String [] row = new String[4];
						row[0]=rs.getString("id");
						row[1]=rs.getString("name");
						row[2]=rs.getString("dept");
						row[3]=rs.getString("address");
						model.addRow(row);
						
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
		
		this.btnDelete = new JButton("삭제");
		this.add(btnDelete);
		this.btnDelete.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int result = JOptionPane.showConfirmDialog(null, "삭제하시겠습니까?", "confirm", JOptionPane.YES_NO_CANCEL_OPTION);
				if(result == JOptionPane.YES_OPTION) {
					//Oracle 연동 삭제(delete)처리
					
					try { 
						Class.forName("com.mysql.jdbc.Driver");
						Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/sampledb", "root","58545256");
						System.out.println("연결 성공");
						
						Statement stmt = conn.createStatement();
						
						//delete
						stmt.executeUpdate("delete from student where id = '"+ txtId.getText() +"'");
						
						
						ResultSet rs = stmt.executeQuery("select * from student order by name");
						
					    //JTable 초기화
					    model.setNumRows(0);
						
						while(rs.next()) {
							
//							taList.append(rs.getString("id") + '\t' + rs.getString("name") + '\t' + rs.getString("dept") + '\n');
						
							String [] row = new String[4];
							row[0]=rs.getString("id");
							row[1]=rs.getString("name");
							row[2]=rs.getString("dept");
							row[3]=rs.getString("address");
							model.addRow(row);
						
						
						}
						txtId.setText("");
						txtName.setText("");
						txtDepartment.setText("");
						txtAddress.setText("");
						rs.close();
						stmt.close();
						conn.close();
					} catch (ClassNotFoundException e1) { e1.printStackTrace();
					} catch (SQLException e1) {
						System.out.println("연결 실패");
						e1.printStackTrace();
					}
					
					// 삭제 처리 후 메세지출력
					JOptionPane.showMessageDialog(null, "삭제되었습니다", "message", JOptionPane.INFORMATION_MESSAGE);
				}
			}
			
		});
		
		this.setSize(320,500);
		this.setVisible(true);
	}
	
	public static void main(String[] args) {
		new student();
	}

}

