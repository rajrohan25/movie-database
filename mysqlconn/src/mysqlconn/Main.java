package mysqlconn;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
public class Main {
	public static void main(String[] args)throws Exception{
		Class.forName("com.mysql.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","");
		PreparedStatement statement=con.prepareStatement("select * from names");
		ResultSet res=statement.executeQuery();
		while(res.next()){
			System.out.println(res.getString(1)+" "+res.getString(2));
		}
				
		
	}

}
