import java.awt.*;
import javax.swing.*;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;
import org.apache.poi.xssf.usermodel.*;

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
	int posX = 0;
	int posY = 0;
	int changed=0;
	ArrayList<person> pArr = new ArrayList<person>();
	public Excel_Form(ArrayList<person> list){
		initComponents(list);
	}

	private void initComponents(ArrayList<person> list) {
		pArr=list;
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
				changed=1;
				dispose();
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
						Database_methods dbmethods3 = new Database_methods();
						int sizeOfClient = dbmethods3.getSize();
						int countColumnA = year-2010+1;
						
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
											for (int j = 0; j < words2.length-1; j++) {
												for (int t = 0; t < sizeOfClient; t++) {
													if ((words2[j]).equals(dbmethods3.getName(t)) && words2[j+1].equals(dbmethods3.getSurname(t))) {
														kim.add(t);
													}
													
												}
											}
										}
										for (int h = 0; h < kim.size(); h++) {
													int d = kim.get(h);
													int giriş = Integer
															.parseInt(dbmethods3.getEnter(d).substring(6)); //giriş tarihi
													
													int money = tutar.get(tutarC); //kişinin yatırdığı tutar 
													for(int p = giriş-2010; p<countColumnA; p++) { //BORÇ ARRAY
                         								 if(dbmethods3.getBorc(d,p) > 0) {
                         								if(money == dbmethods3.getBorc(d,p) && money>0) {
                         									dbmethods3.updateAidat(d, p, dbmethods3.getBorc(d,p));
                         									money -= dbmethods3.getBorc(d,p);
                         									dbmethods3.updateBorc(d,p,0); 
                         								}
                         								 }
													}
                         								for(int p = giriş-2010; p<countColumnA; p++) { //BORÇ ARRAY
                         									if(dbmethods3.getBorc(d,p) > 0) {
                         									if(money > dbmethods3.getBorc(d,p) && money>0 ) {
                         									dbmethods3.updateAidat(d, p, dbmethods3.getBorc(d,p));
                         									money -= dbmethods3.getBorc(d,p);
                         									dbmethods3.updateBorc(d,p,0); 
                         									}
                         									
                         								}
                         								}
                         								for(int p = giriş-2010; p<countColumnA; p++) { //BORÇ ARRAY
                         									if(dbmethods3.getBorc(d,p) > 0) {
                         										if(money < dbmethods3.getBorc(d,p) && money>0) {
                         									dbmethods3.updateAidat(d, p, money);
                         									dbmethods3.updateBorc(d,p,dbmethods3.getBorc(d,p)-money);
                         									money = 0;
                         								}
                         								
             
                         								}
                         							} 
										}
										tutarC++;
									}
									break;
								}
							}//cell
						}//row
					} catch (FileNotFoundException ex) {
						JOptionPane.showMessageDialog(null, ex.getMessage());
					} catch (IOException ex) {
						JOptionPane.showMessageDialog(null, ex.getMessage());
					}
				}
				Database_methods dbmethods3 = new Database_methods();
				pArr=dbmethods3.GetPerson();
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
				//setVisible(false);
				dispose();
				changed=1;

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

						for (int row = 1; row <= excelSheet.getLastRowNum(); row++) {
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
							
							
							pArr.add(new person(ID, Gender, Name, Surname, Work, Mail, TC, Graduation, Department,
									Phone, Address, City, A, B, Mood, Enter));
							
							Database_methods dbmethods = new Database_methods();					
							dbmethods.AddClient(ID, Gender, Name, Surname, Work, Mail, TC, Graduation, Department, Phone, Address,
									City, Mood, Enter);
							
							Database_methods dbmethods2 = new Database_methods();
							dbmethods2.AddAB(ID,A,B);
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
				dispose();
				if(changed==0) {
					main m = new main(pArr);
					m.setVisible(false);
					m.dispose();
					m.setUndecorated(true);
					m.setShape(new RoundRectangle2D.Double(0, 0, m.getWidth(), m.getHeight(), 20, 20));
					m.setVisible(true);
					centreWindow(m);
				}
				if(changed==1) {
					Database_methods dbmethods3 = new Database_methods();
					pArr=dbmethods3.GetPerson();
					main m = new main(pArr);
					m.setVisible(false);
					m.dispose();
					m.setUndecorated(true);
					m.setShape(new RoundRectangle2D.Double(0, 0, m.getWidth(), m.getHeight(), 20, 20));
					m.setVisible(true);
					centreWindow(m);
				}
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
				changed=1;
				yeni_uye y = new yeni_uye(list);
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
	}

	public static void centreWindow(JFrame frame) {
		Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
		int x = (int) ((dimension.getWidth() - frame.getWidth()) / 2);
		int y = (int) ((dimension.getHeight() - frame.getHeight()) / 2);
		frame.setLocation(x, y);
	}
}
