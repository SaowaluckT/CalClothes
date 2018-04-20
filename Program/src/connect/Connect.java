package connect;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Connect {
	public Connection conn;
	public Statement stmt = null;
	
	public Connect() {
		try {	
			conn = DriverManager.getConnection("jdbc:ucanaccess://D:/CalClothes/DB.mdb", "", "");
			stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
		
}

//qry = "SELECT * FROM members WHERE username = '"
//					+ tfUser.getText()
//					+ "' AND password = '"
//					+ tfPass.getText()
//					+ "'"; 
//			result = stmt.executeQuery(qry);