package mysqlconn;

import java.awt.BorderLayout;
import java.awt.*;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.mysql.jdbc.PreparedStatement;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;

public class login1 extends JFrame {

	private JPanel contentPane;
	private JTextField username;
	private JTextField password;

	/**
	 * Launch the application.
	 */
 public void close(){
		 
		 WindowEvent winClosingEvent=new WindowEvent(this,WindowEvent.WINDOW_CLOSING);
		 Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(winClosingEvent);
		 
		 }
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					login1 frame = new login1();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public login1() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 586, 386);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblUsername = new JLabel("USERNAME");
		lblUsername.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblUsername.setBounds(42, 113, 96, 20);
		contentPane.add(lblUsername);
		
		JLabel lblPassword = new JLabel("PASSWORD");
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblPassword.setBounds(42, 197, 96, 20);
		contentPane.add(lblPassword);
		
		username = new JTextField();
		username.setBounds(228, 115, 140, 18);
		contentPane.add(username);
		username.setColumns(10);
		
		password = new JTextField();
		password.setBounds(228, 200, 140, 20);
		contentPane.add(password);
		password.setColumns(10);
		
		JButton btnLogin = new JButton("LOGIN");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					Class.forName("com.mysql.jdbc.Driver");
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","root");
					String sql="select * from user where username=? and password=?";
					PreparedStatement pst=(PreparedStatement) con.prepareStatement(sql);
					pst.setString(1,username.getText());
					pst.setString(2, password.getText());
					ResultSet rs=pst.executeQuery();
					if(rs.next()){
						JOptionPane.showMessageDialog(null, "accepted");
						admin ad=new admin();
						ad.setVisible(true);
						close();
					}
					else{
						JOptionPane.showMessageDialog(null, "invalid user id or password");
						username.setText("");
						password.setText("");
					}
					con.close();
					}catch(Exception ex){
						JOptionPane.showMessageDialog(null,ex);
						
					}
			}
		});
		btnLogin.setBounds(105, 280, 89, 23);
		contentPane.add(btnLogin);
		
		JButton btnReset = new JButton("RESET");
		btnReset.setBounds(275, 280, 89, 23);
		contentPane.add(btnReset);
		
		JLabel lblAdminLogin = new JLabel("ADMIN LOGIN");
		lblAdminLogin.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblAdminLogin.setBounds(182, 45, 140, 20);
		contentPane.add(lblAdminLogin);
	}
}
