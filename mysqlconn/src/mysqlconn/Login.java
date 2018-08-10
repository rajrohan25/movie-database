package mysqlconn;

import java.awt.EventQueue;
import java.awt.event.*;
import java.awt.*;
import java.sql.*;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;

import com.mysql.jdbc.PreparedStatement;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.awt.event.ActionEvent;

public class Login {

	JFrame frame;
	private JTextField username;
	private JTextField password;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login window = new Login();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Login() {
		initialize();
	}
/*	 public void close(){
		 
		 WindowEvent winClosingEvent=new WindowEvent(this,WindowEvent.WINDOW_CLOSING);
		 Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(winClosingEvent);
		 
		 }*/

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lbl1 = new JLabel("USERNAME");
		lbl1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lbl1.setBounds(41, 66, 88, 29);
		frame.getContentPane().add(lbl1);
		
		JLabel lbl2 = new JLabel("PASSWORD");
		lbl2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lbl2.setBounds(41, 137, 88, 22);
		frame.getContentPane().add(lbl2);
		
		username = new JTextField();
		username.setBounds(204, 72, 141, 20);
		frame.getContentPane().add(username);
		username.setColumns(10);
		
		password = new JTextField();
		password.setBounds(204, 140, 141, 20);
		frame.getContentPane().add(password);
		password.setColumns(10);
	
		
		JButton btnLogin = new JButton("LOGIN");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{
				Class.forName("com.mysql.jdbc.Driver");
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","");
				String sql="select * from user where username=? and password=?";
				PreparedStatement pst=(PreparedStatement) con.prepareStatement(sql);
				pst.setString(1,username.getText());
				pst.setString(2, password.getText());
				ResultSet rs=pst.executeQuery();
				if(rs.next()){
					JOptionPane.showMessageDialog(null, "accepted");
					admin ad=new admin();
					ad.setVisible(true);
					
				}
				else{
					JOptionPane.showMessageDialog(null, "invalid user id or password");
					username.setText("");
					password.setText("");
				}
				con.close();
				}catch(Exception e){
					JOptionPane.showMessageDialog(null,e);
					
				}
			}
		});
		btnLogin.setBounds(127, 199, 89, 23);
		frame.getContentPane().add(btnLogin);
		
		JButton btnReset = new JButton("RESET");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				username.setText("");
				password.setText("");
			}
		});
		btnReset.setBounds(256, 199, 89, 23);
		frame.getContentPane().add(btnReset);
	}

protected void dispose() {
	// TODO Auto-generated method stub
	
}

protected void setVisible(boolean b) {
	// TODO Auto-generated method stub
	
}

	//public void setVisible(boolean b) {
		// TODO Auto-generated method stub
		
	//}
}
