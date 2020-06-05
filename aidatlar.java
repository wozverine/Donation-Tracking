import java.awt.event.*;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.*;

import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import javax.swing.*;
import javax.swing.GroupLayout.*;

import java.awt.*;

import javax.swing.LayoutStyle.ComponentPlacement;

import java.awt.geom.RoundRectangle2D;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.border.LineBorder;

public class aidatlar extends javax.swing.JFrame {
	ArrayList<person> pArr = new ArrayList<person>();
	Date date = new Date();
	LocalDate localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
	int year  = localDate.getYear();
	private javax.swing.JButton borclar_btn;
    private javax.swing.JButton geri_btn;
    private javax.swing.JButton toplamaidat_btn;
    private javax.swing.JButton aidatkisiler_btn;
    private javax.swing.JButton exportTable;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextArea borclar_txta;
    private javax.swing.JTextArea kisiler_txta;
    private javax.swing.JTextField ara_txtf;
    private javax.swing.JButton ara_btn;
    private JLabel aidatlar_lbl;
    private javax.swing.JButton exit_btn;
    private JButton minimize_btn;
    
	JFrame frmAidatlar;
	private JScrollPane aidatlar_scrllpane;
	private JScrollPane kisiler_scrllpane;
	private JScrollPane table_scrllpane;
	int posX;
	int posY;
	
	public aidatlar(ArrayList<person> list) {
		initialize(list);
	}

	private void initialize(ArrayList<person> list) {
		pArr=list;
		Color maroon=Color.decode("#800000");
		frmAidatlar = new JFrame();
		frmAidatlar.setTitle("Aidatlar");
		Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
		frmAidatlar.setBounds(0, 0,screen.width,screen.height);
		//frmAidatlar.setMinimumSize(new Dimension(720, 600));
		frmAidatlar.setExtendedState(Frame.MAXIMIZED_BOTH);
		frmAidatlar.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		aidatlar_lbl = new JLabel("Aidatlar");
	    aidatlar_lbl.setBackground(new Color(220, 220, 220));
		aidatlar_lbl.setHorizontalAlignment(SwingConstants.LEFT);
		aidatlar_lbl.setFont(new java.awt.Font("Times New Roman", 0, 25)); // NOI18N
        aidatlar_lbl.setText("AİDATLAR");
        
        ara_txtf = new JTextField();
		ara_txtf.setColumns(10);
		ara_txtf.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                araActionPerformed(evt);
            }
        });
        Object[][] o=new Object[list.size()][year-2010+4];
       
        for (Object[] row: o) {Arrays.fill(row, "");}
        

        for (int count=0;count<list.size();count++) {
        	o[count][0]=list.get(count).getKimlikNo_lbl();
        	o[count][1]=list.get(count).getAd_lbl();
        	o[count][2]=list.get(count).getSoy_lbl();
        	int giriş = Integer.parseInt(list.get(count).getGirisTarihi_lbl().substring(6));
        	for(int d=giriş-2010;d<(year-2010+1);d++) {
        		o[count][d+3]=list.get(count).getAidatcarray()[d];        		
        	}
        }
        String rows[]=new String[year-2010+4];
        rows[0]="TC";
        rows[1]="İsim";
        rows[2]="Soyisim";
        for (int x=2010;x<year+1;x++) {
        	rows[x-2007]=""+x;
        }
        //String [] rows= {"TC","İsim","Soyisim","2010","2011","2012","2013","2014","2015","2016","2017","2018","2019","2020"};
        
		borclar_btn = new JButton("Borçlar");
		borclar_btn.setFont(new Font("Calibri", Font.PLAIN, 15));
		borclar_btn.setForeground(Color.BLACK);
		borclar_btn.setBackground(new Color(169, 169, 169));
		borclar_btn.setBorder(new LineBorder(new Color(128, 0, 0), 2, true));
		borclar_btn.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		//frmAidatlar.dispatchEvent(new WindowEvent(frmAidatlar, WindowEvent.WINDOW_CLOSING));
        		//setVisible(false);
        		//dispose();
        		//frmAidatlar.setVisible(false);
        		//dispose();
        		EventQueue.invokeLater(new Runnable() {
        			public void run() {
        				try {
        					frmAidatlar.setVisible(false);
        					borclar window = new borclar(list);
        					window.frmBorclar.setVisible(false);
        					window.frmBorclar.dispose();
        					window.frmBorclar.setUndecorated(true);
        					window.frmBorclar.setShape(new RoundRectangle2D.Double(0, 0, window.frmBorclar.getWidth(), window.frmBorclar.getHeight(), 20, 20));
        					window.frmBorclar.setVisible(true);
        				} catch (Exception e) {
        					e.printStackTrace();
        				}
        			}
        		});       		
        	}
        });
		
		geri_btn = new JButton("Geri");
		geri_btn.setFont(new Font("Calibri", Font.PLAIN, 15));
		geri_btn.setForeground(Color.BLACK);
		geri_btn.setBackground(new Color(169, 169, 169));
		geri_btn.setBorder(new LineBorder(new Color(128, 0, 0), 2, true));
		geri_btn.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		//frmAidatlar.dispatchEvent(new WindowEvent(frmAidatlar, WindowEvent.WINDOW_CLOSING));
        		//setVisible(false);
        		//dispose();
        		EventQueue.invokeLater(new Runnable() {
        			public void run() {
        				try {
        					frmAidatlar.setVisible(false);
        					main m=new main(pArr);	
        					m.setVisible(false);
	        		        m.dispose();
	        		        m.setUndecorated(true);
	        		        m.setShape(new RoundRectangle2D.Double(0, 0, m.getWidth(), m.getHeight(), 20, 20));
	        		        m.setVisible(true);
	        		        centreWindow(m);
        				} catch (Exception e) {
        					e.printStackTrace();
        				}
        			}
        		});
        		
        	}
        });
		
		ara_btn = new JButton("ARA");
		ara_btn.setHorizontalAlignment(SwingConstants.CENTER);
		ara_btn.setForeground(Color.BLACK);
		ara_btn.setFont(new Font("Times New Roman", Font.BOLD, 14));
		ara_btn.addActionListener(new java.awt.event.ActionListener() {
			@Override
			public void actionPerformed(ActionEvent evt) {
				araButtonAction(evt);
			}
        });
			
		toplamaidat_btn = new JButton("Ödenen aidat toplam");
        toplamaidat_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
               
               aidatlarActionPerformed(evt);
            }
        });
        
        aidatkisiler_btn = new JButton("Aidat Ödeyen Sayısı");
        aidatkisiler_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	kisilerActionPerformed(evt);
            }
        });
        
        exportTable = new JButton("Ödenen Aidatları Tabloya Aktar");
        exportTable.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	toExcel(evt);
            }
        });
        
        exit_btn = new JButton("x");
		exit_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {		
				System.exit(0);
			}
        });
		
        minimize_btn = new JButton("_");
		minimize_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {		
				frmAidatlar.setExtendedState(frmAidatlar.getExtendedState() | Frame.ICONIFIED);
			}
        });
        
        table_scrllpane = new JScrollPane();
        aidatlar_scrllpane = new JScrollPane();		
		kisiler_scrllpane = new JScrollPane();
		
        GroupLayout groupLayout = new GroupLayout(frmAidatlar.getContentPane());
        groupLayout.setHorizontalGroup(
        	groupLayout.createParallelGroup(Alignment.TRAILING)
        		.addGroup(groupLayout.createSequentialGroup()
        			.addGap(42)
        			.addComponent(borclar_btn, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)
        			.addPreferredGap(ComponentPlacement.RELATED, 1071, Short.MAX_VALUE)
        			.addComponent(geri_btn, GroupLayout.PREFERRED_SIZE, 82, GroupLayout.PREFERRED_SIZE)
        			.addGap(65))
        		.addGroup(groupLayout.createSequentialGroup()
        			.addGap(20)
        			.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
        				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
        					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
        						.addGroup(groupLayout.createSequentialGroup()
        							.addGap(11)
        							.addComponent(aidatlar_lbl, GroupLayout.PREFERRED_SIZE, 411, GroupLayout.PREFERRED_SIZE)
        							.addPreferredGap(ComponentPlacement.RELATED, 657, Short.MAX_VALUE)
        							.addComponent(ara_txtf, GroupLayout.PREFERRED_SIZE, 177, GroupLayout.PREFERRED_SIZE)
        							.addPreferredGap(ComponentPlacement.RELATED)
        							.addComponent(ara_btn, GroupLayout.PREFERRED_SIZE, 68, GroupLayout.PREFERRED_SIZE))
        						.addGroup(groupLayout.createSequentialGroup()
        							.addComponent(table_scrllpane, GroupLayout.DEFAULT_SIZE, 1326, Short.MAX_VALUE)
        							.addPreferredGap(ComponentPlacement.RELATED, 4, GroupLayout.PREFERRED_SIZE))
        						.addGroup(groupLayout.createSequentialGroup()
        							.addGap(109)
        							.addComponent(aidatlar_scrllpane, GroupLayout.PREFERRED_SIZE, 321, GroupLayout.PREFERRED_SIZE)
        							.addPreferredGap(ComponentPlacement.RELATED, 486, Short.MAX_VALUE)
        							.addComponent(kisiler_scrllpane, GroupLayout.PREFERRED_SIZE, 319, GroupLayout.PREFERRED_SIZE)
        							.addGap(95)))
        					.addContainerGap())
        				.addGroup(groupLayout.createSequentialGroup()
        					.addGap(206)
        					.addComponent(toplamaidat_btn)
        					.addGap(200)
        					.addComponent(exportTable)
        					.addPreferredGap(ComponentPlacement.RELATED, 679, Short.MAX_VALUE)
        					.addComponent(aidatkisiler_btn)
        					.addGap(183)
        						)))
        		.addGroup(groupLayout.createSequentialGroup()
        			.addContainerGap(1256, Short.MAX_VALUE)
        			.addComponent(minimize_btn)
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addComponent(exit_btn)
        			.addContainerGap())
        );
        groupLayout.setVerticalGroup(
        	groupLayout.createParallelGroup(Alignment.TRAILING)
        		.addGroup(groupLayout.createSequentialGroup()
        			.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(exit_btn)
        				.addComponent(minimize_btn))
        			.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        			.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
        				.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
        					.addComponent(ara_btn)
        					.addComponent(ara_txtf, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        				.addComponent(aidatlar_lbl, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addComponent(table_scrllpane, GroupLayout.PREFERRED_SIZE, 306, GroupLayout.PREFERRED_SIZE)
        			.addGap(18)
        			.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(toplamaidat_btn)
        				.addComponent(aidatkisiler_btn)
        				.addComponent(exportTable))
        			.addPreferredGap(ComponentPlacement.UNRELATED)
        			.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(aidatlar_scrllpane, GroupLayout.PREFERRED_SIZE, 189, GroupLayout.PREFERRED_SIZE)
        				.addComponent(kisiler_scrllpane, GroupLayout.PREFERRED_SIZE, 189, GroupLayout.PREFERRED_SIZE))
        			.addGap(27)
        			.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(geri_btn, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
        				.addComponent(borclar_btn, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))
        			.addGap(46))
        );
		
        borclar_txta = new JTextArea();
        borclar_txta.setFont(new Font("Times New Roman", Font.BOLD, 14));
        borclar_txta.setEditable(false);
        aidatlar_scrllpane.setViewportView(borclar_txta);
		
        kisiler_txta = new JTextArea();
        kisiler_txta.setFont(new Font("Times New Roman", Font.BOLD, 14));
        kisiler_txta.setEditable(false);
        kisiler_scrllpane.setViewportView(kisiler_txta);
        kisiler_txta.setColumns(10);
        
        jTable1 = new JTable();
		jTable1.setFont(new java.awt.Font("Times New Roman", 0, 15)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(o,rows));
        jTable1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//frmAidatlar.setVisible(false);
				int rowSelected =jTable1.getSelectedRow(); 
				personal p = new personal(list, rowSelected);
        		p.setVisible(false);
        		p.dispose();
        		p.setUndecorated(true);
        		p.setSize(700, 562);
		        p.setShape(new RoundRectangle2D.Double(0, 0, p.getWidth(), p.getHeight(), 20, 20));
        		centreWindow(p);
        		p.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        	    p.setVisible(true);
			}
		});		
		table_scrllpane.setViewportView(jTable1);
		frmAidatlar.getContentPane().setLayout(groupLayout);
		frmAidatlar.getContentPane().setBackground(new Color(220, 220, 220));
		
	}
	
	private void araActionPerformed(KeyEvent evt) {                                            
    	DefaultTableModel model = (DefaultTableModel)jTable1.getModel();
    	TableRowSorter<DefaultTableModel> tr = new TableRowSorter<DefaultTableModel>(model);
    	jTable1.setRowSorter(tr);
    	tr.setRowFilter(RowFilter.regexFilter(ara_txtf.getText().trim()));
    }                                           
    private void araButtonAction(java.awt.event.ActionEvent evt) {                                            
    	DefaultTableModel model = (DefaultTableModel)jTable1.getModel();
        TableRowSorter<DefaultTableModel> tr = new TableRowSorter<DefaultTableModel>(model);
        jTable1.setRowSorter(tr);
        tr.setRowFilter(RowFilter.regexFilter(ara_txtf.getText().trim()));
    }
	
	private void aidatlarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
		 double toplam = 0;
         int count=0;
         String[] name = new String[50] ;
         int [] yearsum = new int[50];
         for (int y = 3; y < jTable1.getColumnCount(); y++) {
        	 for (int x = 0; x < jTable1.getRowCount(); x++) {    
        		 if(jTable1.getValueAt(x, y).toString() != ""){
        			 toplam = toplam + Double.parseDouble(jTable1.getValueAt(x, y).toString());
                  }     
        	 }
        	 yearsum[count]= (int)toplam;
        	 name[count] = jTable1.getColumnName(y);
        	 count++;
        	 toplam=0;
         }
         
         String show = "";
         int toplamx = 0;
         for(int i=0; i<count; i++){
        	 show = show + name[i]+  ": " + (int) yearsum[i] + ".00 TL\n";
        	 toplamx = toplamx +(int) yearsum[i];
         }
         borclar_txta.setText(show +  "TOPLAM: " +toplamx+".00 TL ödeme yapılmıştır");
    }//GEN-LAST:event_jButton3ActionPerformed
	
	private void kisilerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
		double toplam = 0;
        int count=0;
        String[] name = new String[50] ;
        int [] yearsum = new int[50];
        for (int y = 3; y < jTable1.getColumnCount(); y++) {
        	for (int x = 0; x < jTable1.getRowCount(); x++) {                
        		if(jTable1.getValueAt(x, y).toString() != "" && Double.parseDouble(jTable1.getValueAt(x, y).toString()) != 0.0 ){
        	toplam = toplam + 1;    
        		}                     
        	}
	        yearsum[count]= (int)toplam;
	        name[count] = jTable1.getColumnName(y);
	        count++;
	        toplam=0;
        }
        String show = "";
        int toplamx = 0;
        for(int i=0; i<count; i++){
        	show = show + name[i]+  ": " + (int) yearsum[i] + " kişi\n";
        	toplamx = toplamx +(int) yearsum[i];
        }    
        kisiler_txta.setText(show + "TOPLAM: " +toplamx + " kişi ödeme yapmıştır");                                  
	}
	
	
	public void toExcel(java.awt.event.ActionEvent evt){
	    try{
	        TableModel model = jTable1.getModel();
	        File excelFile;
			FileInputStream excelFIS = null;
			BufferedInputStream excelBIS = null;
			XSSFWorkbook excelImport = null;
			String yourDesktopPath2 = System.getProperty("user.home") + "\\Desktop\\";
			JFileChooser excelFileChooser = new JFileChooser(yourDesktopPath2);
			int excelChooser = excelFileChooser.showOpenDialog(null);
			if (excelChooser == JFileChooser.APPROVE_OPTION) {
			
					excelFile = excelFileChooser.getSelectedFile();
					FileWriter excel = new FileWriter(excelFile);

	        for(int i = 3; i < model.getColumnCount(); i++){
	            excel.write(model.getColumnName(i) + "\t");
	        }

	        excel.write("\n");
	        int check=0;

	        for(int i=0; i< model.getRowCount(); i++) {
	            for(int j=3; j < model.getColumnCount(); j++) {
	            	if(model.getValueAt(i,j).toString().equals("")) {
	            		check=0;
	            	}
	            	else {
	            	check = Integer.parseInt(model.getValueAt(i,j).toString());
	            	}
	            	
	            	if(check > 0) {
	            	excel.write(model.getValueAt(i,0).toString()+ " " + model.getValueAt(i,1).toString()+ " "+ model.getValueAt(i,2).toString() + "\t");
	            	}
	            	else {
	            		excel.write("\t");
	            	}
	            	}
	            excel.write("\n");
	        }

	        excel.close();

	    }
	    }	
	    catch(IOException e){
	    	System.out.println(e); 
	    }
	    }
	    
	
	public static void centreWindow(JFrame frame) {
	    Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
	    int x = (int) ((dimension.getWidth() - frame.getWidth()) / 2);
	    int y = (int) ((dimension.getHeight() - frame.getHeight()) / 2);
	    frame.setLocation(x, y);
	}
}
