package mysqlconn;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.mysql.jdbc.CallableStatement;
import com.mysql.jdbc.Connection;

import net.proteanit.sql.DbUtils;

import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;

public class update extends JFrame {

	private JPanel contentPane;
	private JTable table;
	static Connection con;
	private JScrollPane scrollPane;
	private JTextField textField;
	String str;
	String str1;
	CallableStatement stmt=null;
	private JButton btnLogout;
	private JButton btnDelete;
	private JTextField textField1;
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
					update frame = new update();
					frame.setVisible(true);
					Class.forName("com.mysql.jdbc.Driver");
					con=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","root");
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public update() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 937, 737);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 56, 790, 373);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JButton btnDetails = new JButton("DETAILS");
		btnDetails.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{
					Class.forName("com.mysql.jdbc.Driver");
					con=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","root");
					String query="SELECT a.act_name as ACTOR,m.mov_title as MOVIE,d.dir_name as DIRECTOR,p.p_name as PRODUCER,w.w_name as WRITER,s.m_name as MUSIC_BY,r.stars as STARS FROM actor a,movies m,director d,producer p,writer w,music_dir s,rating r,movie_cast c  WHERE a.act_id=c.act_id AND m.mov_id=c.mov_id AND m.dir_id=d.dir_id AND m.p_id=p.p_id AND m.m_id=s.m_id AND m.w_id=w.w_id AND m.mov_id=r.mov_id";
					PreparedStatement statement=con.prepareStatement(query);
					ResultSet res=statement.executeQuery();
					table.setModel(DbUtils.resultSetToTableModel(res));
				
				} catch (Exception e) {
					e.printStackTrace();
				}
				}
			
					
		});
		btnDetails.setBounds(294, 11, 89, 23);
		contentPane.add(btnDetails);
		
		JComboBox comboBox = new JComboBox();
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				 str=comboBox.getSelectedItem().toString();
			}
		});
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"ACTOR", "DIRECTOR", "PRODUCER", "WRITER", "MUSIC_DIR", "MOVIES"}));
		comboBox.setBounds(116, 473, 104, 20);
		contentPane.add(comboBox);
		
		textField = new JTextField();
		textField.setBounds(278, 473, 135, 22);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnSearch = new JButton("SEARCH");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(str=="ACTOR")
				try{
					
					  String query="Select * from actor where act_name=?";
						PreparedStatement statement=con.prepareStatement(query);
						statement.setString(1, textField.getText());
						ResultSet res=statement.executeQuery();
						table.setModel(DbUtils.resultSetToTableModel(res));
				}catch(Exception em){
					em.printStackTrace();
				}
				if(str=="DIRECTOR")
					try{
						
						  String query="Select * from director where dir_name=?";
							PreparedStatement statement=con.prepareStatement(query);
							statement.setString(1, textField.getText());
							ResultSet res=statement.executeQuery();
							table.setModel(DbUtils.resultSetToTableModel(res));
					}catch(Exception em){
						em.printStackTrace();
					}
				if(str=="PRODUCER")
					try{
						
						  String query="Select * from producer where p_name=?";
							PreparedStatement statement=con.prepareStatement(query);
							statement.setString(1, textField.getText());
							ResultSet res=statement.executeQuery();
							table.setModel(DbUtils.resultSetToTableModel(res));
					}catch(Exception em){
						em.printStackTrace();
					}
				if(str=="WRITER")
					try{
						
						  String query="Select * from writer where w_name=?";
							PreparedStatement statement=con.prepareStatement(query);
							statement.setString(1, textField.getText());
							ResultSet res=statement.executeQuery();
							table.setModel(DbUtils.resultSetToTableModel(res));
					}catch(Exception em){
						em.printStackTrace();
					}
				if(str=="MUSIC_DIR")
				try{
					
					  String query="Select * from music_dir where m_name=?";
						PreparedStatement statement=con.prepareStatement(query);
						statement.setString(1, textField.getText());
						ResultSet res=statement.executeQuery();
						table.setModel(DbUtils.resultSetToTableModel(res));
				}catch(Exception em){
					em.printStackTrace();
				}
				if(str=="MOVIES")
					try{
						
						  String query="Select * from movies where mov_title=?";
							PreparedStatement statement=con.prepareStatement(query);
							statement.setString(1, textField.getText());
							ResultSet res=statement.executeQuery();
							table.setModel(DbUtils.resultSetToTableModel(res));
					}catch(Exception em){
						em.printStackTrace();
					}
			}
		});
		btnSearch.setBounds(472, 472, 89, 23);
		contentPane.add(btnSearch);
		
		btnLogout = new JButton("LOGOUT");
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				welcome wl=new welcome();
				wl.setVisible(true);
				close();
			}
		});
		btnLogout.setBounds(606, 472, 89, 23);
		contentPane.add(btnLogout);
		
		btnDelete = new JButton("DELETE");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ei) {
				
				try{
					str1="{CALL sel(?)}";
					
					CallableStatement stm=(CallableStatement)con.prepareCall(str1);
					//String s2=textField1.getText().toString();
				//	stm.setString(1, textField1.getText().toString());
					stm.setString(1,textField1.getText());
					stm.execute();
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				/*try{String query="DELETE FROM movies WHERE mov_title=?";
				PreparedStatement statement=con.prepareStatement(query);
				statement.setString(1, textField.getText());
				statement.executeUpdate();
				}
				 catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();	1
					}*/
			}
		});
		btnDelete.setBounds(472, 532, 89, 23);
		contentPane.add(btnDelete);
		
		textField1 = new JTextField();
		textField1.setBounds(278, 533, 135, 23);
		contentPane.add(textField1);
		textField1.setColumns(10);
		
		JLabel lblMovieName = new JLabel("MOVIE NAME");
		lblMovieName.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblMovieName.setBounds(131, 530, 89, 23);
		contentPane.add(lblMovieName);
	}
}
