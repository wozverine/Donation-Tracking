import java.sql.SQLException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MySQLConnection {
	private String kullanıcı_adı = "root";
	private String db_name = "donation";
	private String host = "localhost";
	private int port = 3307;

	private Connection con = null;

	private Statement statement = null;

	private PreparedStatement preparedstatement = null;

	String url = "jdbc:mysql://" + host + ":" + port + "/" + db_name;

	public void mysql_connection() {

		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("connection is successful");

		} catch (ClassNotFoundException ex) {
			Logger.getLogger(MySQLConnection.class.getName()).log(Level.SEVERE, null, ex);
		}
		try {
			con = (Connection) DriverManager.getConnection(url, "root", null);

		} catch (SQLException ex) {
			Logger.getLogger(MySQLConnection.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

	public Statement getStatement() {
		return statement;
	}

}
