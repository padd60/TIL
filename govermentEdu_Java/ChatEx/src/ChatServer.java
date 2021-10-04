import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ChatServer extends JFrame implements ActionListener{
	
	private BufferedReader in = null;
	private BufferedWriter out = null;
	private ServerSocket listener = null;
	private Socket socket = null;
	private Receiver receiver;
	private JTextField sender;
	
	public ChatServer() {
		this.setTitle("���� ä��â");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.getContentPane().setLayout(new BorderLayout());
		
		receiver = new Receiver();
		receiver.setEditable(false);
		
		sender = new JTextField();
		sender.addActionListener(this);
		
		add(new JScrollPane(receiver),BorderLayout.CENTER);
		add(sender,BorderLayout.SOUTH);
		
		this.setSize(400,200);
		this.setVisible(true);
		
		try {
			setupConnection();
		} catch (IOException e) {
			handleError(e.getMessage());
		}
		
		Thread th = new Thread(receiver);
		th.start();
	}
	
	private void setupConnection() throws IOException{
		listener = new ServerSocket(9999);
		socket = listener.accept();
		receiver.append("Ŭ���̾�Ʈ�κ��� ���� �Ϸ�");
		int pos = receiver.getText().length();
		receiver.setCaretPosition(pos);
		
		in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
	}
	
	private static void handleError(String string) {
		System.out.println(string);
		System.exit(1);
	}
	
	class Receiver extends JTextArea implements Runnable{

		@Override
		public void run() {
			String msg = null;
			while(true) {
				try {
					msg = in.readLine();
				}catch(IOException e) {
					handleError(e.getMessage());
				}
				this.append("\n  Ŭ���̾�Ʈ : " + msg);
				int pos = receiver.getText().length();
				this.setCaretPosition(pos);
			}
		}
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == sender) {
			String msg = sender.getText();
			try {
				out.write(msg + "\n");
				out.flush();
				
				receiver.append("\n���� : " + msg);
				int pos = receiver.getText().length();
				receiver.setCaretPosition(pos);
				sender.setText(null);
			}catch(IOException e1) {
				handleError(e1.getMessage());
			}
		}
	}

	public static void main(String[] args) {
		new ChatServer();
	}
}
