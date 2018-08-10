package mysqlconn;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.awt.event.ActionEvent;

public class producer extends JFrame {

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
					producer frame = new producer();
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
	public producer() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 731, 477);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnActor = new JButton("ACTOR");
		btnActor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				admin at=new admin();
				at.setVisible(true);
				close();
			}
		});
		btnActor.setBounds(28, 27, 89, 23);
		contentPane.add(btnActor);
		
		JButton btnDirector = new JButton("DIRECTOR");
		btnDirector.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				director dr=new director();
				dr.setVisible(true);
				close();

			}
		});
		btnDirector.setBounds(187, 27, 101, 23);
		contentPane.add(btnDirector);
		
		JButton btnMusic = new JButton("MUSIC");
		btnMusic.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {singer s=new singer();
			s.setVisible(true);
			close();
			}
		});
		btnMusic.setBounds(343, 27, 89, 23);
		contentPane.add(btnMusic);
		
		JButton btnProducer = new JButton("PRODUCER");
		btnProducer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				producer p=new producer();
				p.setVisible(true);
				close();
			}
		});
		btnProducer.setBounds(497, 27, 89, 23);
		contentPane.add(btnProducer);
		
		JButton btnMovies = new JButton("MOVIES");
		btnMovies.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				movie m=new movie();
				m.setVisible(true);
				close();
			}
		});
		btnMovies.setBounds(28, 92, 89, 23);
		contentPane.add(btnMovies);
		
		JButton btnMoviecast = new JButton("MOVIE_CAST");
		btnMoviecast.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cast c=new cast();
				c.setVisible(true);
				close();
			}
		});
		btnMoviecast.setBounds(187, 92, 101, 23);
		contentPane.add(btnMoviecast);
		
		JButton btnWriter = new JButton("WRITER");
		btnWriter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				writer w=new writer();
				w.setVisible(true);
				close();
			}
		});
		btnWriter.setBounds(343, 92, 89, 23);
		contentPane.add(btnWriter);
		
		JButton btnRating = new JButton("RATING");
		btnRating.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rating r=new rating();
				r.setVisible(true);
				close();
			}
		});
		btnRating.setBounds(497, 92, 89, 23);
		contentPane.add(btnRating);
		
		JLabel lblProducer = new JLabel("PRODUCER");
		lblProducer.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblProducer.setBounds(265, 155, 101, 34);
		contentPane.add(lblProducer);
		
		JLabel lblPid = new JLabel("P_ID");
		lblPid.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPid.setBounds(71, 231, 56, 22);
		contentPane.add(lblPid);
		
		JLabel lblName = new JLabel("NAME");
		lblName.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblName.setBounds(71, 284, 46, 14);
		contentPane.add(lblName);
		
		JLabel lblProductionHouse = new JLabel("ADDRESS");
		lblProductionHouse.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblProductionHouse.setBounds(71, 332, 156, 32);
		contentPane.add(lblProductionHouse);
		
		textField1 = new JTextField();
		textField1.setBounds(343, 230, 243, 23);
		contentPane.add(textField1);
		textField1.setColumns(10);
		
		textField2 = new JTextField();
		textField2.setBounds(346, 283, 240, 23);
		contentPane.add(textField2);
		textField2.setColumns(10);
		
		textField3 = new JTextField();
		textField3.setBounds(346, 340, 240, 24);
		contentPane.add(textField3);
		textField3.setColumns(10);
		
		JButton btnSubmit = new JButton("SUBMIT");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					Class.forName("com.mysql.jdbc.Driver");
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","root");
				String query="insert into producer(p_id,p_name,production)values(?,?,?)";
				PreparedStatement pst=con.prepareStatement(query);
				pst.setString(1,textField1.getText());
				pst.setString(2, textField2.getText());
				pst.setString(3, textField3.getText());
		
				pst.executeUpdate();
				JOptionPane.showMessageDialog(null,"Inserted sucessfully!");
				movie m=new movie();
				m.setVisible(true);
			close();
				
				}catch(Exception ex){
					JOptionPane.showMessageDialog(null, ex);
					
				}
			}
		});
		btnSubmit.setBounds(171, 404, 89, 23);
		contentPane.add(btnSubmit);
		
		JButton btnReset = new JButton("RESET");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField1.setText("");
				textField2.setText("");
				textField3.setText("");

			}
		});
		btnReset.setBounds(407, 404, 89, 23);
		contentPane.add(btnReset);
	}
}
