import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class bookRent extends JFrame{

	DefaultTableModel model=null; // 테이블의 데이터
	JTable table=null;
	Connection conn=null;
	
	Statement stmt;  
	String query; //sql문
	
	public bookRent() {
		query="select s.id, s.name, b.title, br.rdate "
				+ "from student s"
				+ "join bookrent br"
				+ "on s.id = br.id"
				+ "join books b"
				+ "on br.bookno = b.no";
		
		try {
			//DB연결
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/sampledb", "root", "58545256");
			System.out.println("연결완료");
			stmt=conn.createStatement();
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		setTitle("학생관리");
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//x버튼 누르면 프로그램 종료
	    
	    setLayout(null);//레이아웃설정. 레이아웃 사용 안함.
	    
	    JLabel l_dept=new JLabel("학과");
	    l_dept.setBounds(10, 10, 30, 20);
	    add(l_dept);
	    
	    String[] dept={"전체","ComputerSystem","MultiMedia","ComputerScience"};
	    JComboBox cb_dept=new JComboBox(dept);
	    cb_dept.setBounds(45, 10, 100, 20);
	    add(cb_dept);
	    
	    cb_dept.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				query="select s.id, s.name, b.title, br.rdate "
						+ " from student s"
						+ " join bookrent br"
						+ " on s.id = br.id"
						+ " join books b"
						+ " on br.bookno = b.no";
				
				JComboBox cb=(JComboBox)e.getSource(); //이벤트가 발생한 콤보박스 구하기
				//동적쿼리
				if(cb.getSelectedIndex()==0) {
					//전체
					query+=" order by br.no";
				}else if(cb.getSelectedIndex()==1) {
					//컴퓨터시스템
					query+=" where s.dept='ComputerSystem' order by br.no";
				}else if(cb.getSelectedIndex()==2) {
					//멀티미디어
					query+=" where s.dept='MultiMedia' order by br.no";
				}else if(cb.getSelectedIndex()==3) {
					//컴퓨터공학
					query+=" where s.dept='ComputerScience' order by br.no";
				}		
				
				//목록출력
				list();
				
			}
	    });
	    
	    String colName[]={"학번","이름","도서명","대출일"}; // 컬럼명
	    model=new DefaultTableModel(colName,0); // 모델, 테이블의 데이터
	    table = new JTable(model); // model과 table이 binding
	    table.setPreferredScrollableViewportSize(new Dimension(470,200)); // 테이블크기
	    add(table);
	    JScrollPane sp=new JScrollPane(table); // 스크롤 구현
	    sp.setBounds(10, 40, 460, 250);
	    add(sp);  
	    
	    setSize(490, 400);//화면크기
	    setVisible(true);
	}
	
	public void list(){
	    try{
		     System.out.println(query);  //디버깅. 쿼리문을 출력.     
		     // Select문 실행     
		     ResultSet rs=stmt.executeQuery(query);
		    
		     //JTable 초기화
		     model.setNumRows(0);
		    
		     while(rs.next()){
		      String[] row=new String[4];//컬럼의 갯수가 4
		      row[0]=rs.getString("id");
		      row[1]=rs.getString("name");
		      row[2]=rs.getString("title");
		      row[3]=rs.getString("rdate");
		      model.addRow(row); // model에 행 추가
		     }
		     rs.close();
		    
		    }
		    catch(Exception e1){
		     //e.getStackTrace();
		     System.out.println(e1.getMessage());
	    }							
	 }
	
	public static void main(String[] args) {
		new bookRent();
	}

}
