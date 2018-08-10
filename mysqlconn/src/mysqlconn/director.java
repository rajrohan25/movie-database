package mysqlconn;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.sql.*;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.ActionEvent;
public class director extends JFrame {

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
					director frame = new director();
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
	public director() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 779, 502);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblDirector = new JLabel("DIRECTOR");
		lblDirector.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblDirector.setBounds(168, 124, 102, 26);
		contentPane.add(lblDirector);
		
		JLabel lblDirName = new JLabel("DIR ID");
		lblDirName.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDirName.setBounds(40, 197, 81, 14);
		contentPane.add(lblDirName);
		
		textField1 = new JTextField();
		textField1.setBounds(205, 185, 147, 26);
		contentPane.add(textField1);
		textField1.setColumns(10);
		
		JLabel lblDirName_1 = new JLabel("DIR NAME");
		lblDirName_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDirName_1.setBounds(40, 253, 81, 14);
		contentPane.add(lblDirName_1);
		
		JLabel lblNewLabel = new JLabel("ADDRESS");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(40, 305, 81, 20);
		contentPane.add(lblNewLabel);
		
		textField2 = new JTextField();
		textField2.setBounds(205, 241, 147, 26);
		contentPane.add(textField2);
		textField2.setColumns(10);
		
		textField3 = new JTextField();
		textField3.setBounds(205, 300, 147, 26);
		contentPane.add(textField3);
		textField3.setColumns(10);
		
		JButton btnSubmit = new JButton("SUBMIT");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					Class.forName("com.mysql.jdbc.Driver");
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","root");
				String query="insert into director(dir_id,dir_name,address)values(?,?,?)";
				PreparedStatement pst=con.prepareStatement(query);
				pst.setString(1,textField1.getText());
				pst.setString(2, textField2.getText());
				pst.setString(3, textField3.getText());
		
				pst.executeUpdate();
				JOptionPane.showMessageDialog(null,"Inserted sucessfully!");
				writer wr=new writer();
				wr.setVisible(true);
			    close();
				
				}catch(Exception ex){
					JOptionPane.showMessageDialog(null, ex);
					
				}
			}
		});
		btnSubmit.setBounds(86, 370, 89, 23);
		contentPane.add(btnSubmit);
		
		JButton btnReset = new JButton("RESET");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField1.setText("");
				textField2.setText("");
				textField3.setText("");
				
			}
		});
		btnReset.setBounds(238, 370, 89, 23);
		contentPane.add(btnReset);
		
		JButton btnActor = new JButton("ACTOR");
		btnActor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				admin ad=new admin();
				ad.setVisible(true);
				close();
			}
		});
		btnActor.setBounds(32, 26, 89, 23);
		contentPane.add(btnActor);
		
		JButton btnDirector = new JButton("DIRECTOR");
		btnDirector.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				director dr=new director();
				dr.setVisible(true);
				close();

			}
		});
		btnDirector.setBounds(168, 26, 89, 23);
		contentPane.add(btnDirector);
		
		JButton btnProducer = new JButton("PRODUCER");
		btnProducer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				producer p=new producer();
				p.setVisible(true);
				close();
			}
		});
		btnProducer.setBounds(308, 26, 89, 23);
		contentPane.add(btnProducer);
		
		JButton btnWriter = new JButton("WRITER");
		btnWriter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				writer w=new writer();
				w.setVisible(true);
				close();
			}
		});
		btnWriter.setBounds(448, 26, 89, 23);
		contentPane.add(btnWriter);
		
		JButton btnMusic = new JButton("MUSIC");
		btnMusic.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				singer s=new singer();
				s.setVisible(true);
				close();
			}
		});
		btnMusic.setBounds(32, 85, 89, 23);
		contentPane.add(btnMusic);
		
		JButton btnMovie = new JButton("MOVIE");
		btnMovie.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				movie m=new movie();
				m.setVisible(true);
				close();
			}
		});
		btnMovie.setBounds(168, 85, 89, 23);
		contentPane.add(btnMovie);
		
		JButton btnCast = new JButton("CAST");
		btnCast.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cast c=new cast();
				c.setVisible(true);
				close();
			}
		});
		btnCast.setBounds(308, 85, 89, 23);
		contentPane.add(btnCast);
		
		JButton btnRating = new JButton("RATING");
		btnRating.setBounds(448, 85, 89, 23);
		contentPane.add(btnRating);
	}
}
