import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

public class ColorMenuEx extends JFrame{
	JMenuBar mb;
	JMenu screenMenu;
	JMenuItem [] menuItem;
	String[] itemTitle = {"Red", "Blue", "Green"};
	JPanel panel = new JPanel();
	
	public ColorMenuEx() {
		this.setTitle("Color");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.createMenu();
		
		this.getContentPane().add(panel, BorderLayout.CENTER);
		
		this.setSize(250,200);
		this.setVisible(true);
	}
	public void createMenu() {
		mb = new JMenuBar();
		screenMenu = new JMenu("Color");
		menuItem = new JMenuItem[3];
		
		for(int i = 0; i < menuItem.length; i++) {
			menuItem[i] = new JMenuItem(itemTitle[i]);
			menuItem[i].addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					JMenuItem sm = (JMenuItem)e.getSource();
					String bg = sm.getActionCommand();
					if(bg == "Red") {
						panel.setBackground(Color.RED);
						screenMenu.setText(bg);
					} else if(bg == "Blue") {
						panel.setBackground(Color.BLUE);
						screenMenu.setText(bg);
					} else if(bg == "Green") {
						panel.setBackground(Color.GREEN);
						screenMenu.setText(bg);
					}
				}
				
			});
			screenMenu.add(menuItem[i]);
		}
		
		mb.add(screenMenu);
		
		setJMenuBar(mb);
	}
	public static void main(String[] args) {
		new ColorMenuEx();
	}

}
