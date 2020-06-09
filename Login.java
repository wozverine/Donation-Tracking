import java.awt.BorderLayout;
import javax.swing.*;
import javax.swing.border.AbstractBorder;
import javax.swing.filechooser.FileSystemView;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.ResultSetMetaData;

import java.sql.*;
import java.time.LocalDate;
import java.time.ZoneId;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.RoundRectangle2D;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Scanner;

public class Login  extends javax.swing.JFrame{
	JPasswordField password_pf = new JPasswordField();  
	JTextField username_txtf = new JTextField();
	JLabel sifre_btn = new JLabel();
	JLabel username_lbl = new JLabel();
	JButton login_btn = new JButton();
	JButton exit_btn = new JButton();
	ArrayList<person> pArr= new ArrayList<person>();
	Date date = new Date();
	LocalDate localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
	int year = localDate.getYear();

	public Login() {
		//new year
		if(getYear(year)){
			String documentpath=FileSystemView.getFileSystemView().getDefaultDirectory().getPath()+"\\Donation Tracking";
	    	File file = new File(documentpath+"\\aidatlar.txt");
	    	int new_borc=0;
			try(Scanner fileReader = new Scanner(file)) {
				 new_borc=Integer.valueOf(fileReader.nextLine());
				 System.out.println(new_borc);
			} catch (FileNotFoundException e1) {
				e1.printStackTrace();
			}
			String aidat = "A"+year;
			String borc = "B"+year;
			MySQLConnection db = new MySQLConnection();
	    	Connection conn = db.getmysql_connection();
			String updateTableSQL = ("ALTER TABLE abtable ADD COLUMN "+aidat+" INT NOT NULL,"
					+ "ADD COLUMN "+borc+" INT NOT NULL DEFAULT("+new_borc+");");
			try {
				PreparedStatement preparedStatement = conn.prepareStatement(updateTableSQL);
				preparedStatement.executeUpdate(updateTableSQL);
				System.out.println("Done");
				preparedStatement.close();
				conn.close();
			}catch(Exception e) {
				System.out.println(e);
			}
		}
		//new year
		Database_methods dbmethods3 = new Database_methods();
		pArr=dbmethods3.GetPerson();
		
		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        		
		JLayeredPane layeredPane = new JLayeredPane();
		layeredPane.setBackground(Color.LIGHT_GRAY);
		layeredPane.setBounds(0, 0, 500, 500);
		getContentPane().add(layeredPane, BorderLayout.CENTER);
		layeredPane.setLayout(null);
		password_pf.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				password_pf.setText("");
			}
		});
		
		password_pf.setEchoChar('*');
		password_pf.setFont(new java.awt.Font("Calibri", 0, 20)); // NOI18N
		password_pf.setForeground(Color.BLACK);
		//password_pf.setText("Password");
		password_pf.setBorder(null);
		password_pf.setOpaque(false);
		password_pf.setBounds(460, 320, 308, 40);
		layeredPane.add(password_pf);
		
		login_btn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {		   
				try {
					for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
						if ("Nimbus".equals(info.getName())) {
							javax.swing.UIManager.setLookAndFeel(info.getClassName());
							break;
						}
					}
				} catch (ClassNotFoundException ex) {
					java.util.logging.Logger.getLogger(main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
				} catch (InstantiationException ex) {
					java.util.logging.Logger.getLogger(main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
				} catch (IllegalAccessException ex) {
					java.util.logging.Logger.getLogger(main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
				} catch (javax.swing.UnsupportedLookAndFeelException ex) {
					java.util.logging.Logger.getLogger(main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
				}
				//</editor-fold>
				
				java.awt.EventQueue.invokeLater(new Runnable() {
					public void run() {		        	
						System.out.println(username_txtf.getText().equals("tobb"));
						if(isPasswordCorrect(password_pf.getPassword())&&username_txtf.getText().equals("tobb")) {
							dispose();      		       
							main m=new main(pArr);	
							m.setVisible(false);
							m.dispose();
							m.setUndecorated(true);
							m.setShape(new RoundRectangle2D.Double(0, 0, m.getWidth(), m.getHeight(), 20, 20));
							m.setVisible(true);
							centreWindow(m);
						}else {
							JOptionPane.showMessageDialog(getParent(),"Password or username is wrong");
						}
					}
				});
			}
		});
		        
		login_btn.setIcon(new javax.swing.ImageIcon(getClass().getResource("login_button.png"))); // NOI18N
		login_btn.setBorder(null);
		login_btn.setBorderPainted(false);
		login_btn.setContentAreaFilled(false);
		login_btn.setBounds(392, 431, 232, 46);
		layeredPane.add(login_btn);
	
		exit_btn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
						if ("Nimbus".equals(info.getName())) {
							javax.swing.UIManager.setLookAndFeel(info.getClassName());
							break;
						}
					}
				} catch (ClassNotFoundException ex) {
					java.util.logging.Logger.getLogger(main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
				} catch (InstantiationException ex) {
					java.util.logging.Logger.getLogger(main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
				} catch (IllegalAccessException ex) {
					java.util.logging.Logger.getLogger(main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
				} catch (javax.swing.UnsupportedLookAndFeelException ex) {
					java.util.logging.Logger.getLogger(main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
				}
				//</editor-fold>
		
				/* Create and display the form */
				java.awt.EventQueue.invokeLater(new Runnable() {
					public void run() {
						System.exit(0);
					}
				});
			}
		});
		        
		exit_btn.setIcon(new javax.swing.ImageIcon(getClass().getResource("login_exit.png"))); // NOI18N
		exit_btn.setBorder(null);
		exit_btn.setBorderPainted(false);
		exit_btn.setContentAreaFilled(false);
		exit_btn.setBounds(600, 431, 232, 46);
		layeredPane.add(exit_btn);
		        
		username_txtf.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				username_txtf.setText("");
			}
		});

		username_txtf.setFont(new java.awt.Font("Calibri", 0, 20)); // NOI18N
		username_txtf.setForeground(Color.BLACK);
		username_txtf.setBorder(null);
		username_txtf.setOpaque(false);
		username_txtf.setBounds(460, 180, 308, 40);
		layeredPane.add(username_txtf);
		        
		sifre_btn.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N
		sifre_btn.setForeground(new java.awt.Color(255, 255, 255));
		sifre_btn.setHorizontalAlignment(SwingConstants.LEFT);
		sifre_btn.setText("Şifre");
		sifre_btn.setBounds(460, 280, 330, 30);
		layeredPane.add(sifre_btn);
		
		username_lbl.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N
		username_lbl.setForeground(new java.awt.Color(255, 255, 255));
		username_lbl.setHorizontalAlignment(SwingConstants.LEFT);
		username_lbl.setText("Kullanıcı Adı");
		username_lbl.setBounds(460, 140, 264, 30);
		layeredPane.add(username_lbl);
		        
		JLabel loginLeft_lbl = new JLabel("");
		loginLeft_lbl.setIcon(new javax.swing.ImageIcon(getClass().getResource("login_left.png")));
		loginLeft_lbl.setBounds(0, 0, 400, 500);
		layeredPane.add(loginLeft_lbl);
				
		JLabel loginRight_lbl = new JLabel("");
		loginRight_lbl.setIcon(new javax.swing.ImageIcon(getClass().getResource("login_right.png")));
		loginRight_lbl.setBounds(395, 0, 400, 500);
		layeredPane.add(loginRight_lbl);	
	}
	
	public static void centreWindow(JFrame frame) {
	    Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
	    int x = (int) ((dimension.getWidth() - frame.getWidth()) / 2);
	    int y = (int) ((dimension.getHeight() - frame.getHeight()) / 2);
	    frame.setLocation(x, y);
	}
	public static void main(String args[]) {
		
		MySQLConnection db = new MySQLConnection();
		db.getmysql_connection();
		
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Login l = new Login();
                l.setSize(795,500);
                l.setUndecorated(true);
                l.setShape(new RoundRectangle2D.Double(0, 0, l.getWidth(), l.getHeight(), 20, 20));
                centreWindow(l);
                l.setVisible(true);
            }
        });
    }
	public boolean getYear(int year){
    	MySQLConnection db = new MySQLConnection();
    	Connection con = db.getmysql_connection();
    	String query = "SELECT * FROM abtable";
    	PreparedStatement preparedStmt = null;
		try {
			preparedStmt = con.prepareStatement(query);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	ResultSet results = null;
		try {
			results = preparedStmt.executeQuery(query);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	 
    	ResultSetMetaData metadata = null;
		try {
			metadata = (ResultSetMetaData) results.getMetaData();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
    	 
    	int columnCount = 0;
		try {
			columnCount = metadata.getColumnCount();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	String old_year="";
    	 
    	try {
    		old_year=metadata.getColumnName(columnCount);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	int old=Integer. parseInt(old_year.split("B")[1]);
    	return !(old==year);
    }
	private static boolean isPasswordCorrect(char[] input) {
	    boolean isCorrect = true;
	    char[] correctPassword = { 't', 'o', 'b', 'b' };

	    if (input.length != correctPassword.length) {
	        isCorrect = false;
	    } else {
	        isCorrect = Arrays.equals (input, correctPassword);
	    }

	    //Zero out the password.
	    Arrays.fill(correctPassword,'0');

	    return isCorrect;
	}
}
