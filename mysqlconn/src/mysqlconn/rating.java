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

public class rating extends JFrame {

	private JPanel contentPane;
	private JTextField textField1;
	private JTextField textField2;

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
					rating frame = new rating();
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
	public rating() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 710, 510);
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
		btnActor.setBounds(65, 33, 89, 23);
		contentPane.add(btnActor);
		
		JButton btnDirector = new JButton("DIRECTOR");
		btnDirector.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				director dr=new director();
				dr.setVisible(true);
				close();

			}
		});
		btnDirector.setBounds(211, 33, 89, 23);
		contentPane.add(btnDirector);
		
		JButton btnWriter = new JButton("WRITER");
		btnWriter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				writer w=new writer();
				w.setVisible(true);
				close();
			}
		});
		btnWriter.setBounds(371, 33, 89, 23);
		contentPane.add(btnWriter);
		
		JButton btnMusic = new JButton("MUSIC");
		btnMusic.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				singer s=new singer();
				s.setVisible(true);
				close();
				
			}
		});
		btnMusic.setBounds(516, 33, 89, 23);
		contentPane.add(btnMusic);
		
		JButton btnProducer = new JButton("PRODUCER");
		btnProducer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				producer p=new producer();
				p.setVisible(true);
				close();
			}
		});
		btnProducer.setBounds(65, 92, 89, 23);
		contentPane.add(btnProducer);
		
		JButton btnMovies = new JButton("MOVIES");
		btnMovies.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				movie m=new movie();
				m.setVisible(true);
				close();
			}
		});
		btnMovies.setBounds(211, 92, 89, 23);
		contentPane.add(btnMovies);
		
		JButton btnCast = new JButton("CAST");
		btnCast.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cast c=new cast();
				c.setVisible(true);
				close();
			}
		});
		btnCast.setBounds(371, 92, 89, 23);
		contentPane.add(btnCast);
		
		JButton btnRating = new JButton("RATING");
		btnRating.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rating r=new rating();
				r.setVisible(true);
				close();
			}
		});
		btnRating.setBounds(516, 92, 89, 23);
		contentPane.add(btnRating);
		
		JLabel lblRatng = new JLabel("RATING");
		lblRatng.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblRatng.setBounds(292, 169, 105, 23);
		contentPane.add(lblRatng);
		
		JLabel lblMovid = new JLabel("MOV_ID");
		lblMovid.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblMovid.setBounds(65, 255, 89, 23);
		contentPane.add(lblMovid);
		
		JLabel lblStars = new JLabel("STARS");
		lblStars.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblStars.setBounds(65, 337, 72, 17);
		contentPane.add(lblStars);
		
		textField1 = new JTextField();
		textField1.setBounds(211, 258, 86, 20);
		contentPane.add(textField1);
		textField1.setColumns(10);
		
		textField2 = new JTextField();
		textField2.setBounds(214, 337, 86, 20);
		contentPane.add(textField2);
		textField2.setColumns(10);
		
		JButton btnSubmit = new JButton("SUBMIT");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					Class.forName("com.mysql.jdbc.Driver");
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","root");
				String query="insert into rating(mov_id,stars)values(?,?)";
				PreparedStatement pst=con.prepareStatement(query);
				pst.setString(1,textField1.getText());
				pst.setString(2, textField2.getText());
			
		
				pst.executeUpdate();
				JOptionPane.showMessageDialog(null,"Inserted sucessfully!");
			
			close();
				
				}catch(Exception ex){
					JOptionPane.showMessageDialog(null, ex);
					
				}
			}
		});
		btnSubmit.setBounds(131, 398, 89, 23);
		contentPane.add(btnSubmit);
		
		JButton btnReset = new JButton("RESET");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField1.setText("");
				textField2.setText("");
			}
		});
		btnReset.setBounds(319, 398, 89, 23);
		contentPane.add(btnReset);
	}

}
