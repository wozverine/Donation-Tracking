import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

public class Database_methods {
	
	MySQLConnection db = new MySQLConnection();
	Connection con = db.getmysql_connection();

	// AddClient Method: the method which adds client to the client table in the
	// donation database.
		public void AddClient(int ID, String Gender, String Name, String Surname, String Work, String Mail, long TC,
				String Graduation, String Department, long Phone, String Address, String City, String Mood, String Enter) {
			try {
				String phoneString = String.valueOf(Phone);
				String tcString = String.valueOf(TC);
				String query = "INSERT INTO client(client_id, gender, name, surname, work, mail, tc, graduation,department, phone, address, city, mood, enter) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
				PreparedStatement preparedStmt = con.prepareStatement(query);
				preparedStmt.setInt(1, ID);
				preparedStmt.setString(2, Gender);
				preparedStmt.setString(3, Name);
				preparedStmt.setString(4, Surname);
				preparedStmt.setString(5, Work);
				preparedStmt.setString(6, Mail);
				preparedStmt.setString(7, tcString);
				preparedStmt.setString(8, Graduation);
				preparedStmt.setString(9, Department);
				preparedStmt.setString(10, phoneString);
				preparedStmt.setString(11, Address);
				preparedStmt.setString(12, City);
				preparedStmt.setString(13, Mood);
				preparedStmt.setString(14, Enter);
				preparedStmt.execute();
				con.close();
				System.out.println("Insertion to the client table is successful!");
			} catch (Exception e) {
				System.out.println("error: ");
				e.printStackTrace();
			}
		}

		// AddAB Method: the method which adds aidat and borc to the ABtable in the
		// donation database.

		public void AddAB(int ID, int A2010, int B2010, int A2011, int B2011, int A2012, int B2012, int A2013, int B2013,
				int A2014, int B2014, int A2015, int B2015, int A2016, int B2016, int A2017, int B2017, int A2018,
				int B2018, int A2019, int B2019, int A2020, int B2020) {
			try {
				String query = "INSERT INTO abtable(ab_id, A2010,B2010,A2011,B2011,A2012,B2012,A2013,B2013,A2014,B2014,A2015,B2015,A2016,B2016,A2017,B2017,A2018,B2018,A2019,B2019,A2020,B2020) "
						+ "VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
				PreparedStatement preparedStmt = con.prepareStatement(query);
				preparedStmt.setInt(1, ID);
				preparedStmt.setInt(2, A2010);
				preparedStmt.setInt(3, B2010);
				preparedStmt.setInt(4, A2011);
				preparedStmt.setInt(5, B2011);
				preparedStmt.setInt(6, A2012);
				preparedStmt.setInt(7, B2012);
				preparedStmt.setInt(8, A2013);
				preparedStmt.setInt(9, B2013);
				preparedStmt.setInt(10, A2014);
				preparedStmt.setInt(11, B2014);
				preparedStmt.setInt(12, A2015);
				preparedStmt.setInt(13, B2015);
				preparedStmt.setInt(14, A2016);
				preparedStmt.setInt(15, B2016);
				preparedStmt.setInt(16, A2017);
				preparedStmt.setInt(17, B2017);
				preparedStmt.setInt(18, A2018);
				preparedStmt.setInt(19, B2018);
				preparedStmt.setInt(20, A2019);
				preparedStmt.setInt(21, B2019);
				preparedStmt.setInt(22, A2020);
				preparedStmt.setInt(23, B2020);
				preparedStmt.execute();
				con.close();
				System.out.println("Insertion to the abtable is successful!");
			} catch (Exception e) {
				System.out.println("error: ");
				e.printStackTrace();

			}
		}
		
		public int getSize() {
			int count = 0;
			try {
			String query = "SELECT COUNT(client_id) from client";
			 Statement stmt = (Statement) con.createStatement();
		      ResultSet rs = stmt.executeQuery(query);
		      rs.next();
		      count= rs.getInt(1);
			}
			catch (Exception e) {
				e.printStackTrace();

			}
			return count;
		}
		public String getName(int index) {
			 String name  = "";
			try {
			 String query = "SELECT (name) from client WHERE client_id=?";
			   PreparedStatement pr= con.prepareStatement(query);
	            pr.setInt(1,index);
	            ResultSet rs = pr.executeQuery();
	 
	            while (rs.next()) {
	 
	                name = rs.getString("name");
	                System.out.println(name);
	            }
		     
			}
			catch (Exception e) {
				e.printStackTrace();
				System.out.println("error name hatası");

			}
			return name;
		}
		public String getSurname(int index) {
			 String surname  = "";
			try {
			 String query = "SELECT (surname) from client WHERE client_id= ?";
			   PreparedStatement pr= con.prepareStatement(query);
	            pr.setInt(1,index);
	            ResultSet rs = pr.executeQuery();
	 
	            while (rs.next()) {
	 
	               surname = rs.getString("surname");
	               
	                System.out.println(surname);
	            }
		     
			}
			catch (Exception e) {
				e.printStackTrace();
				System.out.println("error surname hatası");

			}
			return surname;
		}
		
		public String getEnter(int index) {
			 String enter  = "";
			try {
			 String query = "SELECT (enter) from client WHERE client_id= ?";
			   PreparedStatement pr= con.prepareStatement(query);
	            pr.setInt(1,index);
	            ResultSet rs = pr.executeQuery();
	 
	            while (rs.next()) {
	 
	               enter = rs.getString("enter");
	               
	                System.out.println(enter);
	            }
		     
			}
			catch (Exception e) {
				e.printStackTrace();
				System.out.println("error enter hatası");

			}
			return enter;
		}
		
		public int getBorc (int index, int year) { 
			int borc =0;
			try {
				
			 String query = "SELECT (B" + (2010 + year) + ") from abtable WHERE ab_id= ?";
			   PreparedStatement pr= con.prepareStatement(query);
	            pr.setInt(1,index);
	            ResultSet rs = pr.executeQuery();
	            rs.next();
	            borc= rs.getInt(1);
			}
			catch (Exception e) {
				e.printStackTrace();
				System.out.println("error borc hatası");

			}
			return borc;
		}
		
		public int getAidat (int index, int year) { 
			int aidat =0;
			try {
			 String query = "SELECT (A" + (2010 + year) + ") from abtable WHERE ab_id= ?";
			   PreparedStatement pr= con.prepareStatement(query);
	            pr.setInt(1,index);
	            ResultSet rs = pr.executeQuery();
	            rs.next();
	            aidat= rs.getInt(1);
			}
			catch (Exception e) {
				e.printStackTrace();
				System.out.println("error aidat hatası");

			}
			return aidat;
		}
		
		public void updateBorc (int index, int year, int değer) { 
			try {
			 String query = "UPDATE abtable "
			 		+ "SET B" + (2010 + year) +  "= ?"
			 				+ " WHERE ab_id = ?";

			   PreparedStatement pr= con.prepareStatement(query);
	            pr.setInt(1,değer);
	            pr.setInt(2, index);
				pr.execute();
	            
			}
			catch (Exception e) {
				e.printStackTrace();
				System.out.println("error updateborc hatası");

			}
		}
		public void updateAidat (int index, int year, int değer) { 
			try {
			 String query = "UPDATE abtable "
			 		+ "SET A" + (2010 + year) +  "= ?"
			 				+ " WHERE ab_id = ?";

			   PreparedStatement pr= con.prepareStatement(query);
	            pr.setInt(1,değer);
	            pr.setInt(2, index);
				pr.execute();
	            
			}
			catch (Exception e) {
				e.printStackTrace();
				System.out.println("error updateaidat hatası");

			}
		}
		
}
