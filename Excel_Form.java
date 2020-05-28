import java.awt.*;
import javax.swing.*;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;
import org.apache.poi.xssf.usermodel.*;
import java.sql.*;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

import java.awt.event.*;
import java.awt.geom.RoundRectangle2D;
import java.io.BufferedInputStream;
import java.io.*;
import java.text.SimpleDateFormat;
import java.time.*;
import java.util.*;
import java.util.Date;

public class Excel_Form extends javax.swing.JFrame {

	private javax.swing.JButton liste_ekle_btn;
	private javax.swing.JPanel jPanel1;
	Date date = new Date();
	LocalDate localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
	int year = localDate.getYear();

	public Excel_Form(ArrayList<person> list) {
		initComponents(list);
	}

	int posX = 0;
	int posY = 0;

	// AddClient Method: the method which adds client to the client table in the
	// donation database.
	private void AddClient(int ID, String Gender, String Name, String Surname, String Work, String Mail, long TC,
			String Graduation, String Department, long Phone, String Address, String City, String Mood, String Enter) {
		try {
			String phoneString = String.valueOf(Phone);
			String tcString = String.valueOf(TC);
			MySQLConnection db = new MySQLConnection();
			Connection con = db.getmysql_connection();
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
			System.out.println("error while inserting to the client table");
		}
	}

	// AddAB Method: the method which adds aidat and borc to the ABtable in the
	// donation database.

	private void AddAB(int ID, int A2010, int B2010, int A2011, int B2011, int A2012, int B2012, int A2013, int B2013,
			int A2014, int B2014, int A2015, int B2015, int A2016, int B2016, int A2017, int B2017, int A2018,
			int B2018, int A2019, int B2019, int A2020, int B2020) {
		try {
			MySQLConnection db = new MySQLConnection();
			Connection con = db.getmysql_connection();
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
			System.out.println("error while inserting to the abtable");

		}
	}

	private void initComponents(ArrayList<person> list) {
		ArrayList<person> pArr = new ArrayList<person>();

		jPanel1 = new javax.swing.JPanel();
		liste_ekle_btn = new javax.swing.JButton();
		JButton dekont_ekle = new JButton();
		JButton yeni_uye = new JButton();

		// move window
		this.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				posX = e.getX();
				posY = e.getY();
			}
		});
		this.addMouseMotionListener(new MouseAdapter() {
			public void mouseDragged(MouseEvent evt) {
				setLocation(evt.getXOnScreen() - posX, evt.getYOnScreen() - posY);
			}
		});
		// move window
		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

		dekont_ekle.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setVisible(false);
				File excelFileX;
				FileInputStream excelFISX = null;
				BufferedInputStream excelBISX = null;
				XSSFWorkbook excelJTableImport = null;
				String yourDesktopPath = System.getProperty("user.home") + "\\Desktop\\excel1.xlsx\\";
				try {
					excelFISX = new FileInputStream(yourDesktopPath);
					excelBISX = new BufferedInputStream(excelFISX);
					excelJTableImport = new XSSFWorkbook(excelBISX);
					XSSFSheet excelSheet = excelJTableImport.getSheetAt(0);
					for (int row = 1; row < excelSheet.getLastRowNum(); row++) {
						XSSFRow excelRow = excelSheet.getRow(row);

						XSSFCell[] x = new XSSFCell[12 + (year - 2010 + 1) * 2 + 2];
						for (int cou = 0; cou < x.length; cou++) {
							x[cou] = excelRow.getCell(cou);
						}
						SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
						String Graduation = sdf.format(x[7].getDateCellValue());
						String Enter = sdf.format(x[x.length - 1].getDateCellValue());

						int ID = (int) x[0].getNumericCellValue();
						long TC = (long) x[6].getNumericCellValue();
						long Phone = (long) x[9].getNumericCellValue();
						int A[] = new int[year - 2010 + 1];
						int B[] = new int[year - 2010 + 1];
						int a = 0;
						for (int cou = 0; cou < (year - 2010 + 1) * 2; cou++) {
							A[a] = (int) x[cou + 12].getNumericCellValue();
							B[a] = (int) x[cou + 13].getNumericCellValue();
							cou++;
							a++;
						}

						String Gender = x[1].getStringCellValue();
						String Name = x[2].getStringCellValue();
						String Surname = x[3].getStringCellValue();
						String Work = x[4].getStringCellValue();
						String Mail = x[5].getStringCellValue();
						String Department = x[8].getStringCellValue();
						String Address = x[10].getStringCellValue();
						String City = x[11].getStringCellValue();
						String Mood = x[x.length - 2].getStringCellValue();
						pArr.add(new person(ID, Gender, Name, Surname, Work, Mail, TC, Graduation, Department, Phone,
								Address, City, A, B, Mood, Enter));				
					}
				} catch (FileNotFoundException ex) {
					JOptionPane.showMessageDialog(null, ex.getMessage());
				} catch (IOException ex) {
					JOptionPane.showMessageDialog(null, ex.getMessage());
				}

				File excelFile;
				FileInputStream excelFIS = null;
				BufferedInputStream excelBIS = null;
				XSSFWorkbook excelImport = null;
				String yourDesktopPath2 = System.getProperty("user.home") + "\\Desktop\\";
				JFileChooser excelFileChooser = new JFileChooser(yourDesktopPath2);
				int excelChooser = excelFileChooser.showOpenDialog(null);
				if (excelChooser == JFileChooser.APPROVE_OPTION) {
					try {
						excelFile = excelFileChooser.getSelectedFile();
						excelFIS = new FileInputStream(excelFile);
						excelBIS = new BufferedInputStream(excelFIS);

						excelImport = new XSSFWorkbook(excelBIS);
						XSSFSheet excelSheetX = excelImport.getSheetAt(0);
						ArrayList<Integer> tutar = new ArrayList<Integer>();

						for (int rowX = 1; rowX <= excelSheetX.getLastRowNum(); rowX++) {
							XSSFRow excelRowX = excelSheetX.getRow(rowX);
							if (excelRowX == null) {
								continue;
							}
							for (int cell = 1; cell <= excelRowX.getLastCellNum(); cell++) {
								XSSFCell excelCellX = excelRowX.getCell(cell);
								if (excelCellX == null) {
									continue;
								}
								if (excelCellX.toString().equals("Tutar")) {
									for (int i = rowX + 1; i <= excelSheetX.getLastRowNum(); i++) {
										XSSFRow excelRowin = excelSheetX.getRow(i);
										XSSFCell excelCellin = excelRowin.getCell(cell);
										int tut = (int) excelCellin.getNumericCellValue();
										tutar.add(tut);
									}
									break;
								}
							}
						}
						for (int rowX = 1; rowX <= excelSheetX.getLastRowNum(); rowX++) {
							XSSFRow excelRowX = excelSheetX.getRow(rowX);
							if (excelRowX == null) {
								continue;
							}
							for (int cell = 1; cell <= excelRowX.getLastCellNum(); cell++) {
								XSSFCell excelCellX = excelRowX.getCell(cell);
								if (excelCellX == null) {
									continue;
								}
								if (excelCellX.toString().equals("Açıklama")) {
									int tutarC = 0;
									for (int i = rowX + 1; i <= excelSheetX.getLastRowNum(); i++) {
										ArrayList<Integer> kim = new ArrayList<Integer>();
										XSSFRow excelRowin = excelSheetX.getRow(i);
										XSSFCell excelCellin = excelRowin.getCell(cell);
										String arastır = excelCellin.getStringCellValue();
										String[] words1 = arastır.split("-");

										for (int k = 0; k < words1.length; k++) {
											String[] words2 = words1[k].split("\\s+");

											for (int j = 0; j < words2.length; j++) {
												for (int t = 0; t < pArr.size(); t++) {
													if ((words2[j]).equals(pArr.get(t).ad_lbl)) {
														kim.add(t);
													}
													if ((words2[j]).equals(pArr.get(t).soyad_lbl)) {
														kim.add(t);
													}
												}
											}
										}
										for (int h = 0; h < kim.size(); h++) {
											for (int f = h + 1; f < kim.size(); f++) {
												if (kim.get(h) == kim.get(f)) {
													int d = kim.get(h);
													int giriş = Integer
															.parseInt(pArr.get(d).getGirisTarihi_lbl().substring(6));
													int money = tutar.get(tutarC);
													
													for(int p = giriş-2010; p< pArr.get(h).getBorcarray().length; p++) {
                         								 if(pArr.get(d).getBorcarray()[p] >0) {
                         								if(money == pArr.get(d).getBorcarray()[p]) {
                         									pArr.get(d).getAidatcarray()[p] = pArr.get(d).getBorcarray()[p];
                         									money = money - pArr.get(d).getBorcarray()[p];
                         									pArr.get(d).getBorcarray()[p] = 0;
                         									
                         								}
                         								}
                         							}
                         							
                         						
                         						for(int p = giriş-2010; p< pArr.get(h).getBorcarray().length; p++) {
                         							if(money>0) {
                         								if(pArr.get(d).getBorcarray()[p] > 0 ) {	
                         									if(money > pArr.get(d).getBorcarray()[p]) {
                         										pArr.get(d).getAidatcarray()[p] = pArr.get(d).getBorcarray()[p];
                         										money= money-pArr.get(d).getBorcarray()[p];
                         										pArr.get(d).getBorcarray()[p]=0;
                         										
                         									}
                         									else {
                         										pArr.get(d).getBorcarray()[p] = pArr.get(d).getBorcarray()[p] -money;
                         										pArr.get(d).getAidatcarray()[p] = money;
                         										money = money - pArr.get(d).getAidatcarray()[p];
                         									}
                         						    }
                         								
                         							}
                         							else {
                         								break;
                         							}
                         							}
												}
											}
										}
										tutarC++;
									}
									break;
								}
							}
						}
					} catch (FileNotFoundException ex) {
						JOptionPane.showMessageDialog(null, ex.getMessage());
					} catch (IOException ex) {
						JOptionPane.showMessageDialog(null, ex.getMessage());
					}
				}
				main m = new main(pArr);
				m.setVisible(false);
				m.dispose();
				m.setUndecorated(true);
				m.setShape(new RoundRectangle2D.Double(0, 0, m.getWidth(), m.getHeight(), 20, 20));
				m.setVisible(true);
				centreWindow(m);
			}
		});

		liste_ekle_btn.setFont(new Font("Calibri", Font.PLAIN, 20)); // NOI18N
		liste_ekle_btn.setText("Üye Listesi Ekle");
		liste_ekle_btn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setVisible(false);

				File excelFile;
				FileInputStream excelFIS = null;
				BufferedInputStream excelBIS = null;
				XSSFWorkbook excelJTableImport = null;
				String yourDesktopPath = System.getProperty("user.home") + "\\Desktop\\";
				JFileChooser excelFileChooser = new JFileChooser(yourDesktopPath);
				int excelChooser = excelFileChooser.showOpenDialog(null);
				if (excelChooser == JFileChooser.APPROVE_OPTION) {
					try {
						excelFile = excelFileChooser.getSelectedFile();
						excelFIS = new FileInputStream(excelFile);
						excelBIS = new BufferedInputStream(excelFIS);

						excelJTableImport = new XSSFWorkbook(excelBIS);
						XSSFSheet excelSheet = excelJTableImport.getSheetAt(0);

						for (int row = 1; row < excelSheet.getLastRowNum(); row++) {
							XSSFRow excelRow = excelSheet.getRow(row);

							XSSFCell[] x = new XSSFCell[12 + (year - 2010 + 1) * 2 + 2];
							for (int cou = 0; cou < x.length; cou++) {
								x[cou] = excelRow.getCell(cou);
							}
							SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
							String Graduation = sdf.format(x[7].getDateCellValue());
							String Enter = sdf.format(x[x.length - 1].getDateCellValue());

							int ID = (int) x[0].getNumericCellValue();
							long TC = (long) x[6].getNumericCellValue();
							long Phone = (long) x[9].getNumericCellValue();
							int A[] = new int[year - 2010 + 1];
							int B[] = new int[year - 2010 + 1];
							int a = 0;
							for (int cou = 0; cou < (year - 2010 + 1) * 2; cou++) {
								A[a] = (int) x[cou + 12].getNumericCellValue();
								B[a] = (int) x[cou + 13].getNumericCellValue();
								cou++;
								a++;
							}

							// AddAB method.
							AddAB(ID, A[0], B[0], A[1], B[1], A[2], B[2], A[3], B[3], A[4], B[4], A[5], B[5], A[6], B[6],
									A[7], B[7], A[8], B[8], A[9], B[9], A[10], B[10]);
							String Gender = x[1].getStringCellValue();
							String Name = x[2].getStringCellValue();
							String Surname = x[3].getStringCellValue();
							String Work = x[4].getStringCellValue();
							String Mail = x[5].getStringCellValue();
							String Department = x[8].getStringCellValue();
							String Address = x[10].getStringCellValue();
							String City = x[11].getStringCellValue();
							String Mood = x[x.length - 2].getStringCellValue();

							pArr.add(new person(ID, Gender, Name, Surname, Work, Mail, TC, Graduation, Department,
									Phone, Address, City, A, B, Mood, Enter));

							// Adding Client into the client table in the donation database.
							AddClient(ID, Gender, Name, Surname, Work, Mail, TC, Graduation, Department, Phone, Address,
									City, Mood, Enter);

						}
					} catch (FileNotFoundException ex) {
						JOptionPane.showMessageDialog(null, ex.getMessage());
					} catch (IOException ex) {
						JOptionPane.showMessageDialog(null, ex.getMessage());
					}
				}
				main m = new main(pArr);
				m.setVisible(false);
				m.dispose();
				m.setUndecorated(true);
				m.setShape(new RoundRectangle2D.Double(0, 0, m.getWidth(), m.getHeight(), 20, 20));
				m.setVisible(true);
				centreWindow(m);
			}
		});

		JButton geri_btn = new JButton("Geri");
		geri_btn.setFont(new Font("Calibri", Font.PLAIN, 14));
		geri_btn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setVisible(false);
				main m = new main(pArr);
				m.setVisible(false);
				m.dispose();
				m.setUndecorated(true);
				m.setShape(new RoundRectangle2D.Double(0, 0, m.getWidth(), m.getHeight(), 20, 20));
				m.setVisible(true);
				centreWindow(m);
			}
		});

		dekont_ekle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		dekont_ekle.setText("Banka Dekontu Ekle");
		dekont_ekle.setFont(new Font("Calibri", Font.PLAIN, 20));

		yeni_uye.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		yeni_uye.setText("Yeni Üye Ekle");
		yeni_uye.setFont(new Font("Calibri", Font.PLAIN, 20));
		yeni_uye.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				yeni_uye y = new yeni_uye();
				y.setVisible(false);
				y.setSize(575, 600);
				y.dispose();
				y.setUndecorated(true);
				y.setShape(new RoundRectangle2D.Double(0, 0, y.getWidth(), y.getHeight(), 20, 20));
				y.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				y.setVisible(true);
				centreWindow(y);
			}
		});

		JButton close_btn = new JButton("x");
		close_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});

		JButton minimize_btn = new JButton("_");
		minimize_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setState(JFrame.ICONIFIED);
			}
		});
		minimize_btn.setHorizontalAlignment(SwingConstants.RIGHT);

		javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
		jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(Alignment.LEADING).addGroup(jPanel1Layout
				.createSequentialGroup().addContainerGap(46, Short.MAX_VALUE)
				.addGroup(jPanel1Layout.createParallelGroup(Alignment.TRAILING)
						.addGroup(jPanel1Layout.createSequentialGroup()
								.addGroup(jPanel1Layout.createParallelGroup(Alignment.TRAILING, false)
										.addComponent(liste_ekle_btn, Alignment.LEADING, GroupLayout.DEFAULT_SIZE,
												GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(yeni_uye, Alignment.LEADING, GroupLayout.DEFAULT_SIZE,
												GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(dekont_ekle, Alignment.LEADING))
								.addPreferredGap(ComponentPlacement.UNRELATED)
								.addComponent(geri_btn, GroupLayout.PREFERRED_SIZE, 77, GroupLayout.PREFERRED_SIZE))
						.addGroup(jPanel1Layout.createSequentialGroup()
								.addComponent(minimize_btn, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED).addComponent(close_btn)))));
		jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(Alignment.TRAILING)
				.addGroup(jPanel1Layout.createSequentialGroup()
						.addGroup(jPanel1Layout.createParallelGroup(Alignment.BASELINE)
								.addComponent(close_btn, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
								.addComponent(minimize_btn, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
						.addGroup(jPanel1Layout.createParallelGroup(Alignment.TRAILING)
								.addGroup(
										jPanel1Layout
												.createSequentialGroup()
												.addComponent(geri_btn, GroupLayout.PREFERRED_SIZE, 37,
														GroupLayout.PREFERRED_SIZE)
												.addContainerGap())
								.addGroup(jPanel1Layout.createSequentialGroup()
										.addComponent(liste_ekle_btn, GroupLayout.PREFERRED_SIZE, 47,
												GroupLayout.PREFERRED_SIZE)
										.addGap(18)
										.addComponent(dekont_ekle, GroupLayout.PREFERRED_SIZE, 47,
												GroupLayout.PREFERRED_SIZE)
										.addGap(18).addComponent(yeni_uye, GroupLayout.PREFERRED_SIZE, 47,
												GroupLayout.PREFERRED_SIZE)
										.addGap(42)))));
		jPanel1.setLayout(jPanel1Layout);

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		layout.setHorizontalGroup(layout.createParallelGroup(Alignment.TRAILING).addGroup(Alignment.LEADING,
				layout.createSequentialGroup().addGap(36)
						.addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, 332, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(55, Short.MAX_VALUE)));
		layout.setVerticalGroup(
				layout.createParallelGroup(Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap()
						.addComponent(jPanel1, GroupLayout.DEFAULT_SIZE, 264, Short.MAX_VALUE).addContainerGap()));
		getContentPane().setLayout(layout);

		pack();
	}// </editor-fold>//GEN-END:initComponents

	public static void centreWindow(JFrame frame) {
		Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
		int x = (int) ((dimension.getWidth() - frame.getWidth()) / 2);
		int y = (int) ((dimension.getHeight() - frame.getHeight()) / 2);
		frame.setLocation(x, y);
	}
}
