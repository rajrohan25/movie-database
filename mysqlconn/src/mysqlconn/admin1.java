package mysqlconn;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.ActionEvent;

public class admin1 extends JFrame {

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
					admin1 frame = new admin1();
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
	public admin1() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 772, 465);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblWelcomeAdmin = new JLabel("WELCOME ADMIN");
		lblWelcomeAdmin.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblWelcomeAdmin.setBounds(254, 51, 234, 31);
		contentPane.add(lblWelcomeAdmin);
		
		JButton btnCheckAndUpdate = new JButton("CHECK AND UPDATE");
		btnCheckAndUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnCheckAndUpdate.setBounds(267, 174, 136, 23);
		contentPane.add(btnCheckAndUpdate);
		
		JButton btnInsert = new JButton("INSERT ");
		btnInsert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				admin ad=new admin();
				ad.setVisible(true);
				close();
			}
		});
		btnInsert.setBounds(292, 270, 89, 23);
		contentPane.add(btnInsert);
	}
}
