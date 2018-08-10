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
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.awt.event.ActionEvent;

public class writer extends JFrame {

	private JPanel contentPane;
	private JTextField textField1;
	private JTextField textField2;
	private JTextField textField3;

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
					writer frame = new writer();
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
	public writer() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 708, 503);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblWriter = new JLabel("WRITER");
		lblWriter.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblWriter.setBounds(245, 151, 82, 19);
		contentPane.add(lblWriter);
		
		JLabel lblWid = new JLabel("W_ID");
		lblWid.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblWid.setBounds(40, 192, 57, 19);
		contentPane.add(lblWid);
		
		JLabel lblNewLabel = new JLabel("NAME");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(38, 256, 46, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblAddress = new JLabel("ADDRESS");
		lblAddress.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblAddress.setBounds(38, 311, 82, 19);
		contentPane.add(lblAddress);
		
		textField1 = new JTextField();
		textField1.setBounds(197, 181, 86, 20);
		contentPane.add(textField1);
		textField1.setColumns(10);
		
		textField2 = new JTextField();
		textField2.setBounds(197, 244, 130, 19);
		contentPane.add(textField2);
		textField2.setColumns(10);
		
		textField3 = new JTextField();
		textField3.setBounds(197, 312, 130, 19);
		contentPane.add(textField3);
		textField3.setColumns(10);
		
		JButton btnSubmit = new JButton("SUBMIT");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{
					Class.forName("com.mysql.jdbc.Driver");
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","root");
				String query="insert into writer(w_id,w_name,address)values(?,?,?)";
				PreparedStatement pst=con.prepareStatement(query);
				pst.setString(1,textField1.getText());
				pst.setString(2, textField2.getText());
				pst.setString(3, textField3.getText());
		
				pst.executeUpdate();
				JOptionPane.showMessageDialog(null,"Inserted sucessfully!");
				singer s=new singer();
				s.setVisible(true);
		        close();	
				
				}catch(Exception ex){
					JOptionPane.showMessageDialog(null, ex);
					
				}
			}
		});
		btnSubmit.setBounds(97, 384, 89, 23);
		contentPane.add(btnSubmit);
		
		JButton btnRerst = new JButton("RESET");
		btnRerst.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				textField1.setText("");
				textField2.setText("");
				textField3.setText("");

			}
		});
		btnRerst.setBounds(245, 384, 89, 23);
		contentPane.add(btnRerst);
		
		JButton btnActor = new JButton("ACTOR");
		btnActor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				admin ad=new admin();
				ad.setVisible(true);
				close();
			}
		});
		btnActor.setBounds(40, 40, 89, 23);
		contentPane.add(btnActor);
		
		JButton btnDirector = new JButton("DIRECTOR");
		btnDirector.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				director dr=new director();
				dr.setVisible(true);
				close();

			}
		});
		btnDirector.setBounds(197, 40, 89, 23);
		contentPane.add(btnDirector);
		
		JButton btnProducer = new JButton("PRODUCER");
		btnProducer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				producer p=new producer();
				p.setVisible(true);
				close();
			}
		});
		btnProducer.setBounds(334, 40, 89, 23);
		contentPane.add(btnProducer);
		
		JButton btnWriter = new JButton("WRITER");
		btnWriter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				writer w=new writer();
				w.setVisible(true);
				close();
			}
		});
		btnWriter.setBounds(476, 40, 89, 23);
		contentPane.add(btnWriter);
		
		JButton btnMusic = new JButton("MUSIC");
		btnMusic.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				singer s=new singer();
				s.setVisible(true);
				close();
			}
		});
		btnMusic.setBounds(40, 102, 89, 23);
		contentPane.add(btnMusic);
		
		JButton btnMovies = new JButton("MOVIES");
		btnMovies.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				movie m=new movie();
				m.setVisible(true);
				close();
			}
		});
		btnMovies.setBounds(197, 102, 89, 23);
		contentPane.add(btnMovies);
		
		JButton btnCast = new JButton("CAST");
		btnCast.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cast c=new cast();
				c.setVisible(true);
				close();
			}
		});
		btnCast.setBounds(334, 102, 89, 23);
		contentPane.add(btnCast);
		
		JButton btnRating = new JButton("RATING");
		btnRating.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rating r=new rating();
				r.setVisible(true);
				close();
			}
		});
		btnRating.setBounds(476, 102, 89, 23);
		contentPane.add(btnRating);
	}
}
