package connect;



import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Connect {
	public Connection conn;
	public Statement stmt = null;
	public Connect() {
	}
	public void connect() {
		File db = new File("");
		try {	
			conn = DriverManager.getConnection("jdbc:ucanaccess://"+db.getAbsoluteFile()+"\\DB.mdb", "", "");
			stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
			System.out.println("Connect DB");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void disConnect() {
		try {
			this.conn.close();
			this.stmt.close();
			System.out.println("close DB");
		} catch (SQLException ee) {
			// TODO Auto-generated catch block
			ee.printStackTrace();
		}
	}	
}