import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

public class Database_methods {
	Date date = new Date();
	LocalDate localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
	int year  = localDate.getYear();
	MySQLConnection db = new MySQLConnection();
	Connection con = db.getmysql_connection();
	Connection con2 = db.getmysql_connection();

	// AddClient Method: the method which adds client to the client table in the
	// donation database.
	@SuppressWarnings("finally")
	public ArrayList<person> GetPerson() {
		ArrayList<person> pArr= new ArrayList<person>();
		int uyeNo_lbl;
		String cinsiyet_lbl = null;
		String ad_lbl = null;
		String soyad_lbl= null;
		String calismayer_lbl= null;
		String mail_lbl= null;
		long kimlikNo_lbl= 0;
		String mezTarihi_lbl= null;
		String bolum_lbl= null;
		long tel_lbl= 0;
		String adres_lbl= null;
		String il_lbl= null;
		String uyeDurumu_lbl= null;
		String girisTarihi_lbl= null;
		int []aidatarr=new int[year-2010+1];
		int []borcarr=new int[year-2010+1];
		int count=0;
		try {
			String query="SELECT * FROM `abtable` WHERE `ab_id`>-1";
			Statement stmt = (Statement) con.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			ResultSet rs2 = null;
			
			while (rs.next()) {
				uyeNo_lbl=(int) rs.getObject(1);
				System.out.println("no "+uyeNo_lbl);
				String query2="SELECT * FROM `client` WHERE `client_id`="+rs.getObject(1);
				Statement stmt2 = (Statement) con2.createStatement();
				rs2 = stmt2.executeQuery(query2);
				while (rs2.next()) {
					cinsiyet_lbl=(String) rs2.getObject(2);
					ad_lbl=(String) rs2.getObject(3);
					soyad_lbl=(String) rs2.getObject(4);
					calismayer_lbl=(String) rs2.getObject(5);
					mail_lbl=(String) rs2.getObject(6);
					kimlikNo_lbl= Long.valueOf((String) rs2.getObject(7));
					mezTarihi_lbl=(String) rs2.getObject(8);
					bolum_lbl=(String) rs2.getObject(9);
					tel_lbl=Long.valueOf((String) rs2.getObject(10));
					adres_lbl=(String) rs2.getObject(11);
					il_lbl=(String) rs2.getObject(12);
					uyeDurumu_lbl=(String) rs2.getObject(13);
					girisTarihi_lbl=(String) rs2.getObject(14);
				}
				//System.out.println("done");
				
				for(int arrx=0;arrx<aidatarr.length;arrx++) {
					aidatarr[arrx]=(int) rs.getObject(2*arrx+2);
					borcarr[arrx]=(int) rs.getObject(2*arrx+3);
				}
				//System.out.println(count+" aidat 0 "+Arrays.toString(aidatarr));
				//System.out.println(count+" borc 0 "+Arrays.toString(borcarr));
				
				person per=new person(uyeNo_lbl, cinsiyet_lbl,ad_lbl, soyad_lbl,calismayer_lbl, mail_lbl, kimlikNo_lbl
						,mezTarihi_lbl,bolum_lbl,tel_lbl,adres_lbl,
						il_lbl, aidatarr,borcarr, uyeDurumu_lbl, girisTarihi_lbl);
				//per.setBorcarray(borcarr);
				//per.setAidatarray(aidatarr);
				
				/*pArr.add(new person(uyeNo_lbl, cinsiyet_lbl,ad_lbl, soyad_lbl,calismayer_lbl, mail_lbl, kimlikNo_lbl
						,mezTarihi_lbl,bolum_lbl,tel_lbl,adres_lbl,il_lbl,borcarr, aidatarr, uyeDurumu_lbl, girisTarihi_lbl));*/
				pArr.add(per);
				System.out.println(pArr.size());
				System.out.println(count+" aidat 1 "+Arrays.toString(per.getAidatarray()));
				System.out.println(count+" borc 1 "+Arrays.toString(per.getBorcarray()));
				/*pArr.add(new person(uyeNo_lbl, cinsiyet_lbl,ad_lbl, soyad_lbl,calismayer_lbl, mail_lbl, kimlikNo_lbl
						,mezTarihi_lbl,bolum_lbl,tel_lbl,adres_lbl,
						il_lbl,aidatarr, borcarr, uyeDurumu_lbl, girisTarihi_lbl));*/
			
				count++;
            }
			System.out.println("f");
			rs.close();
			rs2.close();
		}catch (Exception e) {
			System.out.println("error: ");
			e.printStackTrace();
		}finally {
			System.out.println(pArr.size());
			System.out.println("kk0 "+Arrays.toString(pArr.get(0).getAidatarray()));
			System.out.println("kk0 "+pArr.get(0).getAd_lbl());
			System.out.println("kk1 "+Arrays.toString(pArr.get(1).getAidatarray()));
			System.out.println("kk1 "+pArr.get(1).getAd_lbl());
			System.out.println("kk2 "+Arrays.toString(pArr.get(2).getAidatarray()));
			System.out.println("kk2 "+pArr.get(2).getAd_lbl());
			return pArr;
		}
		
		//return pArr;
	};
	
	public void updateClient(int ID, String Gender, String Name, String Surname, String Work, String Mail, long TC,
			String Graduation, String Department, long Phone, String Address, String City, String Mood, String Enter) {
		try {
			String query = "UPDATE client "+
			"set gender='"+Gender+"'"+
			", name='"+Name+"'"+
			", surname='"+Surname+"'"+
			", work='"+Surname+"'"+
			", mail='"+Mail+"'"+
			", tc='"+TC+"'"+
			", graduation='"+Graduation+"'"+
			", department='"+Department+"'"+
			", phone='"+Phone+"'"+
			", address='"+Address+"'"+
			", city='"+City+"'"+
			", mood='"+Mood+"'"+
			", enter='"+Enter+"'"+
			" WHERE client_id= "+ID;
			PreparedStatement preparedStmt = con.prepareStatement(query);
			preparedStmt.execute(query);
			//con.close();
			System.out.println("Update the client table is successful!");
		} catch (Exception e) {
			System.out.println("error: ");
			e.printStackTrace();
		}
	}
	
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
			//con.close();
			System.out.println("Insertion to the client table is successful!");
		} catch (Exception e) {
			System.out.println("error: ");
			e.printStackTrace();
		}
	}
	
	public void AddAB(int ID, int[]A,int[]B) {
		try {
			String query="INSERT INTO abtable(ab_id";
			String query_1="";
			for(int year_count=2010;year_count<year+1;year_count++) {
				query_1=query_1+","+"A"+String.valueOf(year_count)+","+"B"+String.valueOf(year_count);
				System.out.println(year_count);
			}
			String query_2="?,?,?";
			for(int year_count=2011;year_count<year+1;year_count++) {
				query_2=query_2+",?,?";
			}
			query=query+query_1+") VALUES ("+query_2+")";
			System.out.println(query);
			PreparedStatement preparedStmt = con.prepareStatement(query);
			preparedStmt.setInt(1, ID);
			int cd=2;
			for(int year_count=2010;year_count<year+1;year_count++) {
				preparedStmt.setInt(cd, A[year_count-2010]);
				preparedStmt.setInt(cd+1, B[year_count-2010]);
				cd=cd+2;
			}
			preparedStmt.execute();
			con.close();
			System.out.println("Insertion to the abtable is successful!");
		} catch (Exception e) {
			System.out.println("error: "+e);
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
			String query = "UPDATE abtable "+ "SET B" + (2010 + year) +  "= ?"+ " WHERE ab_id = ?";

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
			String query = "UPDATE abtable "+ "SET A" + (2010 + year) +  "= ?"+ " WHERE ab_id = ?";

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
