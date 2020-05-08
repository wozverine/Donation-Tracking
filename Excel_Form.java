import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.GroupLayout.Alignment;
import javax.swing.GroupLayout;
import javax.swing.LayoutStyle.ComponentPlacement;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

public class Excel_Form extends javax.swing.JFrame {

	private javax.swing.JButton liste_ekle_btn;
    private javax.swing.JPanel jPanel1;
    public Excel_Form(ArrayList<person>list) {
        initComponents(list);     
    }
    int posX=0;
    int posY=0;
    private void initComponents(ArrayList<person>list) {
    	ArrayList<person> pArr = new ArrayList<person>();

        jPanel1 = new javax.swing.JPanel();
        liste_ekle_btn = new javax.swing.JButton();
        JButton dekont_ekle = new JButton();
        JButton yeni_uye = new JButton();
        
        
        this.addMouseListener(new MouseAdapter()
        {
           public void mousePressed(MouseEvent e)
           {
              posX=e.getX();
              posY=e.getY();
           }
        });
        this.addMouseMotionListener(new MouseAdapter()
        {
             public void mouseDragged(MouseEvent evt)
             {		
        		setLocation (evt.getXOnScreen()-posX,evt.getYOnScreen()-posY);
        					
             }
        });

        
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

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
                            
                          
                            XSSFCell CID = excelRow.getCell(0);
                            XSSFCell CGender = excelRow.getCell(1);
                            XSSFCell CName = excelRow.getCell(2);
                            XSSFCell CSurname = excelRow.getCell(3);
                            XSSFCell CWork = excelRow.getCell(4);
                            XSSFCell CMail = excelRow.getCell(5);
                            XSSFCell CTC = excelRow.getCell(6);
                            XSSFCell CGraduation = excelRow.getCell(7);
                            XSSFCell CDepartment = excelRow.getCell(8);
                            XSSFCell CPhone = excelRow.getCell(9);
                            XSSFCell CAddress = excelRow.getCell(10);
                            XSSFCell CCity = excelRow.getCell(11);
                            XSSFCell CA2010 = excelRow.getCell(12);
                            XSSFCell CB2010 = excelRow.getCell(13);
                            XSSFCell CA2011 = excelRow.getCell(14);
                            XSSFCell CB2011 = excelRow.getCell(15);
                            XSSFCell CA2012 = excelRow.getCell(16);
                            XSSFCell CB2012 = excelRow.getCell(17);
                            XSSFCell CA2013 = excelRow.getCell(18);
                            XSSFCell CB2013 = excelRow.getCell(19);
                            XSSFCell CA2014 = excelRow.getCell(20);
                            XSSFCell CB2014 = excelRow.getCell(21);
                            XSSFCell CA2015 = excelRow.getCell(22);
                            XSSFCell CB2015 = excelRow.getCell(23);
                            XSSFCell CA2016 = excelRow.getCell(24);
                            XSSFCell CB2016 = excelRow.getCell(25);
                            XSSFCell CA2017 = excelRow.getCell(26);
                            XSSFCell CB2017 = excelRow.getCell(27);
                            XSSFCell CA2018 = excelRow.getCell(28);
                            XSSFCell CB2018 = excelRow.getCell(29);
                            XSSFCell CA2019 = excelRow.getCell(30);
                            XSSFCell CB2019 = excelRow.getCell(31);
                            XSSFCell CA2020 = excelRow.getCell(32);
                            XSSFCell CB2020 = excelRow.getCell(33);
                            XSSFCell CMood = excelRow.getCell(34);
                            XSSFCell CEnter = excelRow.getCell(35);
                        
                            SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
                            String Graduation = sdf.format(CGraduation.getDateCellValue());
                            String Enter = sdf.format(CEnter.getDateCellValue());
                             
                            
                            
                          int ID = (int) CID.getNumericCellValue();
                          long TC = (long) CTC.getNumericCellValue();
                          long Phone = (long) CPhone.getNumericCellValue();
                          int A2010 =  (int) CA2010.getNumericCellValue();
                          int A2011 =  (int) CA2011.getNumericCellValue();
                          int A2012 =  (int) CA2012.getNumericCellValue();
                          int A2013 =  (int) CA2013.getNumericCellValue();
                          int A2014 =  (int) CA2014.getNumericCellValue();
                          int A2015 =  (int) CA2015.getNumericCellValue();
                          int A2016 =  (int) CA2016.getNumericCellValue();
                          int A2017 =  (int) CA2017.getNumericCellValue();
                          int A2018 =  (int) CA2018.getNumericCellValue();
                          int A2019 =  (int) CA2019.getNumericCellValue();
                          int A2020 =  (int) CA2020.getNumericCellValue();
                          int B2010 =  (int) CB2010.getNumericCellValue();
                          int B2011 =  (int) CB2011.getNumericCellValue();
                          int B2012 =  (int) CB2012.getNumericCellValue();
                          int B2013 =  (int) CB2013.getNumericCellValue();
                          int B2014 =  (int) CB2014.getNumericCellValue();
                          int B2015 =  (int) CB2015.getNumericCellValue();
                          int B2016 =  (int) CB2016.getNumericCellValue();
                          int B2017 =  (int) CB2017.getNumericCellValue();
                          int B2018 =  (int) CB2018.getNumericCellValue();
                          int B2019 =  (int) CB2019.getNumericCellValue();
                          int B2020 =  (int) CB2020.getNumericCellValue();
                         
                          
                          String Gender = CGender.getStringCellValue();
                          String Name = CName.getStringCellValue();
                          String Surname = CSurname.getStringCellValue();
                          String Work = CWork.getStringCellValue();
                          String Mail = CMail.getStringCellValue();
                          String Department = CDepartment.getStringCellValue();
                          String Address = CAddress.getStringCellValue();
                          String City = CCity.getStringCellValue();
                          String Mood = CMood.getStringCellValue();
                         
                          
                          int aidatlar[] = {A2010, A2011, A2012, A2013, A2014, A2015, A2016, A2017, A2018, A2019,A2020};
                          int borclar[] = {B2010, B2011, B2012, B2013, B2014, B2015, B2016, B2017, B2018, B2019,B2020};
                          
                         
                          
                          pArr.add(new person(ID, Gender, Name, Surname, Work, Mail, TC, Graduation, 
                        		  Department, Phone, Address, City, aidatlar, borclar, Mood, Enter));

                        }
                    } catch (FileNotFoundException ex) {
                        JOptionPane.showMessageDialog(null, ex.getMessage());
                    } catch (IOException ex) {
                        JOptionPane.showMessageDialog(null, ex.getMessage());

                    }
                }
				main m = new main(pArr);
				m.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				m.setVisible(true);
        		centreWindow(m);
        	}
        });

        
        JButton btnGeri = new JButton("Geri");
        btnGeri.setFont(new Font("Calibri", Font.PLAIN, 14));
        btnGeri.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {        		
        		setVisible(false);
				main m = new main(list);
				m.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
				y.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				y.setSize(585,600);
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
        //close_btn.setIcon(new javax.swing.ImageIcon(getClass().getResource("close.png")));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1Layout.setHorizontalGroup(
        	jPanel1Layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(jPanel1Layout.createSequentialGroup()
        			.addContainerGap(46, Short.MAX_VALUE)
        			.addGroup(jPanel1Layout.createParallelGroup(Alignment.LEADING)
        				.addGroup(Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
        					.addGroup(jPanel1Layout.createParallelGroup(Alignment.TRAILING, false)
        						.addComponent(liste_ekle_btn, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        						.addComponent(yeni_uye, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        						.addComponent(dekont_ekle, Alignment.LEADING))
        					.addPreferredGap(ComponentPlacement.UNRELATED)
        					.addComponent(btnGeri, GroupLayout.PREFERRED_SIZE, 77, GroupLayout.PREFERRED_SIZE))
        				.addComponent(close_btn, Alignment.TRAILING)))
        );
        jPanel1Layout.setVerticalGroup(
        	jPanel1Layout.createParallelGroup(Alignment.TRAILING)
        		.addGroup(jPanel1Layout.createSequentialGroup()
        			.addComponent(close_btn, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
        			.addPreferredGap(ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
        			.addGroup(jPanel1Layout.createParallelGroup(Alignment.LEADING)
        				.addGroup(Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
        					.addComponent(btnGeri, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
        					.addContainerGap())
        				.addGroup(Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
        					.addComponent(liste_ekle_btn, GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE)
        					.addGap(18)
        					.addComponent(dekont_ekle, GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE)
        					.addGap(18)
        					.addComponent(yeni_uye, GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE)
        					.addGap(42))))
        );
        jPanel1.setLayout(jPanel1Layout);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        layout.setHorizontalGroup(
        	layout.createParallelGroup(Alignment.TRAILING)
        		.addGroup(Alignment.LEADING, layout.createSequentialGroup()
        			.addGap(36)
        			.addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, 332, GroupLayout.PREFERRED_SIZE)
        			.addContainerGap(55, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
        	layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(layout.createSequentialGroup()
        			.addContainerGap()
        			.addComponent(jPanel1, GroupLayout.DEFAULT_SIZE, 264, Short.MAX_VALUE)
        			.addContainerGap())
        );
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
