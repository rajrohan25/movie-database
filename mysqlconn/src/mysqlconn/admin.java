package mysqlconn;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;
import javax.swing.JToggleButton;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.ButtonGroup;
import javax.swing.JComboBox;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.DefaultComboBoxModel;

public class admin extends JFrame {

	private JPanel contentPane;
	private JTextField textfield1;
	private final ButtonGroup buttonGroup = new ButtonGroup();
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
					admin frame = new admin();
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
	public admin() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 711, 503);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel adminpage = new JLabel("ACTORS");
		adminpage.setFont(new Font("Times New Roman", Font.BOLD, 16));
		adminpage.setBounds(237, 146, 100, 35);
		contentPane.add(adminpage);
		
		textfield1 = new JTextField();
		textfield1.setBounds(201, 253, 160, 20);
		contentPane.add(textfield1);
		textfield1.setColumns(10);
		
		JButton submit = new JButton("SUBMIT");
		submit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{
					Class.forName("com.mysql.jdbc.Driver");
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","root");
				String query="insert into actor(act_id,act_name,gender)values(?,?,?)";
				PreparedStatement pst=con.prepareStatement(query);
				pst.setString(1,textfield1.getText());
				pst.setString(2, textField2.getText());
				pst.setString(3,textField3.getText());
			
		
				pst.executeUpdate();
				JOptionPane.showMessageDialog(null,"Inserted sucessfully!");
				director d=new director();
				d.setVisible(true);
				close();
			
				
				}catch(Exception ex){
					JOptionPane.showMessageDialog(null, ex);
					
				}
				
			}
		});
		submit.setBounds(121, 401, 89, 23);
		contentPane.add(submit);
		
		JLabel lblActId = new JLabel("ACT ID");
		lblActId.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblActId.setBounds(33, 253, 67, 20);
		contentPane.add(lblActId);
		
		JLabel label = new JLabel("");
		label.setBounds(371, 231, 46, 14);
		contentPane.add(label);
		
		JButton btnReset = new JButton("RESET");
		btnReset.setBounds(263, 401, 89, 23);
		contentPane.add(btnReset);
		
		JLabel lblName = new JLabel("NAME");
		lblName.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblName.setBounds(37, 296, 46, 14);
		contentPane.add(lblName);
		
		textField2 = new JTextField();
		textField2.setBounds(203, 295, 158, 20);
		contentPane.add(textField2);
		textField2.setColumns(10);
		
		JLabel lblGender = new JLabel("GENDER");
		lblGender.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblGender.setBounds(37, 342, 63, 17);
		contentPane.add(lblGender);
		
		textField3 = new JTextField();
		textField3.setBounds(203, 342, 158, 20);
		contentPane.add(textField3);
		textField3.setColumns(10);
		
		JButton btnActors = new JButton("ACTORS");
		btnActors.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				admin ad=new admin();
				ad.setVisible(true);
				close();
			}
		});
		btnActors.setBounds(33, 26, 89, 23);
		contentPane.add(btnActors);
		
		JButton btnDirector = new JButton("DIRECTOR");
		btnDirector.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				director dr=new director();
				dr.setVisible(true);
				close();

			}
		});
		btnDirector.setBounds(180, 26, 89, 23);
		contentPane.add(btnDirector);
		
		JButton btnProducer = new JButton("PRODUCER");
		btnProducer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				producer p=new producer();
				p.setVisible(true);
				close();
			}
		});
		btnProducer.setBounds(330, 26, 89, 23);
		contentPane.add(btnProducer);
		
		JButton btnWriter = new JButton("WRITER");
		btnWriter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				writer w=new writer();
				w.setVisible(true);
				close();
			}
		});
		btnWriter.setBounds(478, 26, 89, 23);
		contentPane.add(btnWriter);
		
		JButton btnNewButton = new JButton("MUSIC");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				singer s=new singer();
				s.setVisible(true);
				close();
			}
		});
		btnNewButton.setBounds(33, 90, 89, 23);
		contentPane.add(btnNewButton);
		
		JButton btnMovie = new JButton("MOVIE");
		btnMovie.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				movie m=new movie();
				m.setVisible(true);
				close();
			}
		});
		btnMovie.setBounds(180, 90, 89, 23);
		contentPane.add(btnMovie);
		
		JButton btnCast = new JButton("CAST");
		btnCast.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cast c=new cast();
				c.setVisible(true);
				close();
			}
		});
		btnCast.setBounds(330, 90, 89, 23);
		contentPane.add(btnCast);
		
		JButton btnRating = new JButton("RATING");
		btnRating.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rating r=new rating();
				r.setVisible(true);
				close();
			}
		});
		btnRating.setBounds(478, 90, 89, 23);
		contentPane.add(btnRating);
	}
}
