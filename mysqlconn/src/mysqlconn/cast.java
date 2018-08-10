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

public class cast extends JFrame {

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
					cast frame = new cast();
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
	public cast() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 760, 476);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnActor = new JButton("ACTOR");
		btnActor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				admin ad=new admin();
				ad.setVisible(true);
				close();
			}
		});
		btnActor.setBounds(43, 29, 89, 23);
		contentPane.add(btnActor);
		
		JButton btnDirector = new JButton("DIRECTOR");
		btnDirector.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				director dr=new director();
				dr.setVisible(true);
				close();

			}
		});
		btnDirector.setBounds(179, 29, 89, 23);
		contentPane.add(btnDirector);
		
		JButton btnWriter = new JButton("WRITER");
		btnWriter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				writer w=new writer();
				w.setVisible(true);
				close();
			}
		});
		btnWriter.setBounds(328, 29, 89, 23);
		contentPane.add(btnWriter);
		
		JButton btnMusic = new JButton("MUSIC");
		btnMusic.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				singer s=new singer();
				s.setVisible(true);
				close();
			}
		});
		btnMusic.setBounds(463, 29, 89, 23);
		contentPane.add(btnMusic);
		
		JButton btnProducer = new JButton("PRODUCER");
		btnProducer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				producer p=new producer();
				p.setVisible(true);
				close();
			}
		});
		btnProducer.setBounds(43, 119, 89, 23);
		contentPane.add(btnProducer);
		
		JButton btnMovies = new JButton("MOVIES");
		btnMovies.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				movie m=new movie();
				m.setVisible(true);
				close();
			}
		});
		btnMovies.setBounds(179, 119, 89, 23);
		contentPane.add(btnMovies);
		
		JButton btnCast = new JButton("CAST");
		btnCast.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cast c=new cast();
				c.setVisible(true);
				close();
			}
		});
		btnCast.setBounds(328, 119, 89, 23);
		contentPane.add(btnCast);
		
		JButton btnRating = new JButton("RATING");
		btnRating.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rating r=new rating();
				r.setVisible(true);
				close();
			}
		});
		btnRating.setBounds(463, 119, 89, 23);
		contentPane.add(btnRating);
		
		JLabel lblMoviecast = new JLabel("MOVIE_CAST");
		lblMoviecast.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblMoviecast.setBounds(238, 184, 149, 23);
		contentPane.add(lblMoviecast);
		
		JLabel lblActid = new JLabel("ACT_ID");
		lblActid.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblActid.setBounds(82, 263, 73, 23);
		contentPane.add(lblActid);
		
		textField1 = new JTextField();
		textField1.setBounds(227, 266, 86, 20);
		contentPane.add(textField1);
		textField1.setColumns(10);
		
		JLabel lblMovid = new JLabel("MOV_ID");
		lblMovid.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblMovid.setBounds(82, 329, 73, 23);
		contentPane.add(lblMovid);
		
		textField2 = new JTextField();
		textField2.setBounds(227, 332, 86, 20);
		contentPane.add(textField2);
		textField2.setColumns(10);
		
		JLabel lblRole = new JLabel("ROLE");
		lblRole.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblRole.setBounds(82, 388, 46, 14);
		contentPane.add(lblRole);
		
		textField3 = new JTextField();
		textField3.setBounds(227, 385, 86, 20);
		contentPane.add(textField3);
		textField3.setColumns(10);
		
		JButton btnSubmit = new JButton("SUBMIT");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					Class.forName("com.mysql.jdbc.Driver");
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","root");
				String query="insert into movie_cast(act_id,mov_id,role)values(?,?,?)";
				PreparedStatement pst=con.prepareStatement(query);
				pst.setString(1,textField1.getText());
				pst.setString(2, textField2.getText());
				pst.setString(3, textField3.getText());
		
				pst.executeUpdate();
				JOptionPane.showMessageDialog(null,"Inserted sucessfully!");
				rating rt=new rating();
				rt.setVisible(true);
			close();
				
				}catch(Exception ex){
					JOptionPane.showMessageDialog(null, ex);
					
				}
			}
		});
		btnSubmit.setBounds(418, 265, 89, 23);
		contentPane.add(btnSubmit);
		
		JButton btnReset = new JButton("RESET");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField1.setText("");
				textField2.setText("");
				textField3.setText("");
			}
		});
		btnReset.setBounds(418, 332, 89, 23);
		contentPane.add(btnReset);
	}

}
