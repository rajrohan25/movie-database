package mysqlconn;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Toolkit;
import java.awt.Window;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.awt.event.ActionEvent;

public class welcome extends JFrame {

	private JPanel contentPane;

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
					welcome frame = new welcome();
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
	public welcome() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnAdmin = new JButton("ADMIN");
		btnAdmin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{
			
				login1 ll=new login1();
				ll.setVisible(true);
			    close();
				
			}catch(Exception e){
				JOptionPane.showMessageDialog(null,e);
			}
			}
		});
		btnAdmin.setBounds(138, 100, 89, 23);
		contentPane.add(btnAdmin);
		
		JButton btnGuest = new JButton("GUEST");
		btnGuest.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				guest1 g=new guest1();
				g.setVisible(true);
				close();
			}
		});
		btnGuest.setBounds(138, 162, 89, 23);
		contentPane.add(btnGuest);
		
		JLabel lblLoginAs = new JLabel("LOGIN AS");
		lblLoginAs.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblLoginAs.setBounds(138, 27, 100, 23);
		contentPane.add(lblLoginAs);
	}
}
