package connect;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Connect {
//--------------------------------Special variable-------------------------
	public Connection conn;
	public Statement stmt = null;
	public boolean statusDB = false; //สร้างตัวแปรสำหรับกำหนดการเชื่อมต่อ database
//-----------------------------End variable--------------------------------
	public Connect() {
	}
	public void connect() { //method ชื่อ connect ใช้เมื่อต้องการเชื่อม database
		File db = new File("");
		//-------------------------------------------connect database ------------------------------------------		
		try {	
			conn = DriverManager.getConnection("jdbc:ucanaccess://"+db.getAbsoluteFile()+"\\DB.mdb", "", ""); 
			stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
			this.statusDB=true; // statusDB=true เมื่อเชื่อมต่อ database
			System.out.println("Connect DB");
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		//------------------------------------------End connect database ----------------------------------------
	}
	public void disConnect() { // method ชื่อ disconnect ใช้เมื่อต้องการยกเลิกการเชื่อม database
		//-------------------------------------------disconnect database------------------------------------------
		try {
			this.conn.close();
			this.stmt.close();
			System.out.println("Close DB");
			this.statusDB=false; // statusDB=false เมื่อเชื่อมต่อ database
		} catch (SQLException ee) {
			ee.printStackTrace();
		}
		//------------------------------------------End disconnect database----------------------------------------
	}	
}