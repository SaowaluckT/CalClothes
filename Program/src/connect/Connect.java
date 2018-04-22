package connect;



import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Connect {
	public Connection conn;
	public Statement stmt = null;
	public boolean statusDB = false;
	public Connect() {
	}
	public void connect() {
		File db = new File("");
		try {	
			conn = DriverManager.getConnection("jdbc:ucanaccess://"+db.getAbsoluteFile()+"\\DB.mdb", "", "");
			stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
			this.statusDB=true;
			System.out.println("Connect DB");
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public void disConnect() {
		try {
			this.conn.close();
			this.stmt.close();
			System.out.println("close DB");
			this.statusDB=false;
		} catch (SQLException ee) {
			ee.printStackTrace();
		}
	}	
}