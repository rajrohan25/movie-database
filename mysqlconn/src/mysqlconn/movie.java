package mysqlconn;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.UIManager;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.awt.event.ActionEvent;

public class movie extends JFrame {

	private JPanel contentPane;
	private JTextField t1;
	private JTextField t2;
	private JTextField t3;
	private JTextField t4;
	private JTextField t5;
	private JTextField t6;
	private JTextField t7;
	private JTextField t8;

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
					movie frame = new movie();
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
	public movie() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 866, 635);
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
		btnActor.setBounds(39, 43, 89, 23);
		contentPane.add(btnActor);
		
		JButton btnDirector = new JButton("DIRECTOR");
		btnDirector.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				director dr=new director();
				dr.setVisible(true);
				close();

			}
		});
		btnDirector.setBounds(220, 43, 89, 23);
		contentPane.add(btnDirector);
		
		JButton btnWriter = new JButton("WRITER");
		btnWriter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				writer w=new writer();
				w.setVisible(true);
				close();
			}
		});
		btnWriter.setBounds(397, 43, 89, 23);
		contentPane.add(btnWriter);
		
		JButton btnMusic = new JButton("MUSIC");
		btnMusic.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				singer s=new singer();
				s.setVisible(true);
				close();
			}
		});
		btnMusic.setBounds(558, 43, 89, 23);
		contentPane.add(btnMusic);
		
		JButton btnProducer = new JButton("PRODUCER");
		btnProducer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				producer p=new producer();
				p.setVisible(true);
				close();
			}
		});
		btnProducer.setBounds(39, 115, 89, 23);
		contentPane.add(btnProducer);
		
		JButton btnMovies = new JButton("MOVIES");
		btnMovies.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				movie m=new movie();
				m.setVisible(true);
				close();
			}
		});
		btnMovies.setBounds(220, 115, 89, 23);
		contentPane.add(btnMovies);
		
		JButton btnCast = new JButton("CAST");
		btnCast.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cast c=new cast();
				c.setVisible(true);
				close();
			}
		});
		btnCast.setBounds(397, 115, 89, 23);
		contentPane.add(btnCast);
		
		JButton btnRating = new JButton("RATING");
		btnRating.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rating r=new rating();
				r.setVisible(true);
				close();
			}
		});
		btnRating.setBounds(558, 115, 89, 23);
		contentPane.add(btnRating);
		
		JLabel lblMovies = new JLabel("MOVIES");
		lblMovies.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblMovies.setBounds(303, 214, 134, 23);
		contentPane.add(lblMovies);
		
		JLabel lblMovid = new JLabel("MOV_ID");
		lblMovid.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblMovid.setBounds(53, 281, 75, 23);
		contentPane.add(lblMovid);
		
		JLabel lblTitle = new JLabel("TITLE");
		lblTitle.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblTitle.setBounds(53, 335, 46, 14);
		contentPane.add(lblTitle);
		
		JLabel lblYear = new JLabel("YEAR");
		lblYear.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblYear.setBounds(53, 386, 46, 14);
		contentPane.add(lblYear);
		
		JLabel lblLanguage = new JLabel("LANGUAGE");
		lblLanguage.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblLanguage.setBounds(53, 427, 75, 14);
		contentPane.add(lblLanguage);
		
		JLabel lblDirid = new JLabel("DIR_ID");
		lblDirid.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDirid.setBounds(53, 474, 75, 19);
		contentPane.add(lblDirid);
		
		t1 = new JTextField();
		t1.setBounds(168, 284, 86, 20);
		contentPane.add(t1);
		t1.setColumns(10);
		
		t2 = new JTextField();
		t2.setBounds(168, 334, 226, 23);
		contentPane.add(t2);
		t2.setColumns(10);
		
		t3 = new JTextField();
		t3.setBounds(168, 385, 86, 20);
		contentPane.add(t3);
		t3.setColumns(10);
		
		t4 = new JTextField();
		t4.setBounds(168, 426, 86, 20);
		contentPane.add(t4);
		t4.setColumns(10);
		
		t5 = new JTextField();
		t5.setBounds(168, 473, 86, 20);
		contentPane.add(t5);
		t5.setColumns(10);
		
		JLabel lblPid = new JLabel("P_ID");
		lblPid.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPid.setBounds(332, 476, 62, 17);
		contentPane.add(lblPid);
		
		t6 = new JTextField();
		t6.setBounds(444, 473, 86, 20);
		contentPane.add(t6);
		t6.setColumns(10);
		
		JLabel lblMid = new JLabel("M_ID");
		lblMid.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblMid.setBounds(332, 388, 62, 17);
		contentPane.add(lblMid);
		
		JLabel lblWid = new JLabel("W_ID");
		lblWid.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblWid.setBounds(332, 429, 62, 17);
		contentPane.add(lblWid);
		
		t7 = new JTextField();
		t7.setBounds(444, 385, 86, 20);
		contentPane.add(t7);
		t7.setColumns(10);
		
		t8 = new JTextField();
		t8.setBounds(444, 426, 86, 20);
		contentPane.add(t8);
		t8.setColumns(10);
		
		JButton btnSubmit = new JButton("SUBMIT");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					Class.forName("com.mysql.jdbc.Driver");
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","root");
				String query="insert into movies(mov_id,mov_title,year,lang,dir_id,p_id,m_id,w_id)values(?,?,?,?,?,?,?,?)";
				PreparedStatement pst=con.prepareStatement(query);
				pst.setString(1,t1.getText());
				pst.setString(2, t2.getText());
				pst.setString(3, t3.getText());
				pst.setString(4, t4.getText());
				pst.setString(5, t5.getText());
				pst.setString(6, t6.getText());
				pst.setString(7, t7.getText());
				pst.setString(8, t8.getText());
		
				pst.executeUpdate();
				JOptionPane.showMessageDialog(null,"Inserted sucessfully!");
				cast c=new cast();
				c.setVisible(true);
			close();
				
				}catch(Exception ex){
					JOptionPane.showMessageDialog(null, ex);
					
				}
			}
		});
		btnSubmit.setBounds(168, 536, 89, 23);
		contentPane.add(btnSubmit);
		
		JButton btnReset = new JButton("RESET");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				t1.setText("");
				t2.setText("");
				t3.setText("");
				t4.setText("");
				t5.setText("");
				t6.setText("");
				t7.setText("");
				t8.setText("");
			}
		});
		btnReset.setBounds(365, 536, 89, 23);
		contentPane.add(btnReset);
	}

}
