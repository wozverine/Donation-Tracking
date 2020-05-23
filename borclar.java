import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.*;
import java.awt.event.ActionEvent;

import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import javax.swing.*;
import javax.swing.GroupLayout.*;

import java.awt.*;

import javax.swing.LayoutStyle.ComponentPlacement;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.RoundRectangle2D;

import javax.swing.border.LineBorder;

public class borclar extends javax.swing.JFrame {
	ArrayList<person> pArr = new ArrayList<person>();
	Date date = new Date();
	LocalDate localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
	int year  = localDate.getYear();
	private javax.swing.JButton aidatlar_btn;
    private javax.swing.JButton geri_btn;
    private javax.swing.JButton borc_btn;
    private javax.swing.JButton kisiler_btn;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextArea borclar_txta;
    private javax.swing.JTextArea kisiler_txta;
    private javax.swing.JTextField ara_txtf;
    private javax.swing.JButton ara_btn;
    private JLabel borclar_lbl;
    private javax.swing.JButton exit_btn;
    private JButton minimize_btn;
    
	JFrame frmBorclar;
	private JScrollPane borclar_scrllpane;
	private JScrollPane borclu_scrllpane;
	private JScrollPane table_scrllpane;
	int posX;
	int posY;
	
	
	public borclar(ArrayList<person> list) {
		initialize(list);
	}

	private void initialize(ArrayList<person> list) {
		pArr=list;
		Color maroon=Color.decode("#800000");
		frmBorclar = new JFrame();
		frmBorclar.setTitle("Borclar");
		Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
		frmBorclar.setBounds(0, 0,screen.width,screen.height);
		frmBorclar.setExtendedState(Frame.MAXIMIZED_BOTH);
		frmBorclar.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		borclar_lbl = new JLabel("Borclar");
		//borclar_lbl.setEditable(false);
	    borclar_lbl.setBackground(new Color(220, 220, 220));
		borclar_lbl.setHorizontalAlignment(SwingConstants.LEFT);
		borclar_lbl.setFont(new java.awt.Font("Times New Roman", 0, 25)); // NOI18N
        borclar_lbl.setText("BORÇLAR");
        
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
        		o[count][d+3]=list.get(count).getBorcarray()[d];
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
        
		aidatlar_btn = new JButton("Aidatlar");
		aidatlar_btn.setFont(new Font("Tahoma", Font.PLAIN, 15));
		aidatlar_btn.setForeground(Color.BLACK);
		aidatlar_btn.setBackground(new Color(169, 169, 169));
		aidatlar_btn.setBorder(new LineBorder(new Color(128, 0, 0), 2, true));
		aidatlar_btn.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		//setVisible(false);
        		//dispose();
        		EventQueue.invokeLater(new Runnable() {
        			public void run() {
        				try {
        					frmBorclar.setVisible(false);
        					aidatlar window = new aidatlar(list);
        					window.frmAidatlar.setVisible(false);
        					window.frmAidatlar.dispose();
        					window.frmAidatlar.setUndecorated(true);
        					window.frmAidatlar.setShape(new RoundRectangle2D.Double(0, 0, window.frmAidatlar.getWidth(), window.frmAidatlar.getHeight(), 20, 20));
        					window.frmAidatlar.setVisible(true);
        				} catch (Exception e) {
        					e.printStackTrace();
        				}
        			}
        		});        		
        	}
        });
		
		geri_btn = new JButton("Geri");
		geri_btn.setFont(new Font("Tahoma", Font.PLAIN, 15));
		geri_btn.setForeground(Color.BLACK);
		geri_btn.setBackground(new Color(169, 169, 169));
		geri_btn.setBorder(new LineBorder(new Color(128, 0, 0), 2, true));
		geri_btn.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		//setVisible(false);
        		//dispose();
        		EventQueue.invokeLater(new Runnable() {
        			public void run() {
        				try {
        					frmBorclar.setVisible(false);
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

		borc_btn = new JButton("Borç toplam");
        borc_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	aidatlarActionPerformed(evt);
             }
        });
        
        kisiler_btn = new JButton("Borçlu Sayısı");
        kisiler_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	kisilerActionPerformed(evt);
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
				frmBorclar.setExtendedState(frmBorclar.getExtendedState() | Frame.ICONIFIED);
			}
        });
		
        table_scrllpane = new JScrollPane();
		borclar_scrllpane = new JScrollPane();		
		borclu_scrllpane = new JScrollPane();

		GroupLayout groupLayout = new GroupLayout(frmBorclar.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(42)
					.addComponent(aidatlar_btn, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 1071, Short.MAX_VALUE)
					.addComponent(geri_btn, GroupLayout.PREFERRED_SIZE, 82, GroupLayout.PREFERRED_SIZE)
					.addGap(65))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(20)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(11)
							.addComponent(borclar_lbl, GroupLayout.PREFERRED_SIZE, 411, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 657, Short.MAX_VALUE)
							.addComponent(ara_txtf, GroupLayout.PREFERRED_SIZE, 177, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(ara_btn, GroupLayout.PREFERRED_SIZE, 68, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(table_scrllpane, GroupLayout.DEFAULT_SIZE, 1326, Short.MAX_VALUE)
							.addPreferredGap(ComponentPlacement.RELATED, 4, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(216)
							.addComponent(borc_btn)
							.addPreferredGap(ComponentPlacement.RELATED, 726, Short.MAX_VALUE)
							.addComponent(kisiler_btn)
							.addGap(208))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(109)
							.addComponent(borclar_scrllpane, GroupLayout.PREFERRED_SIZE, 321, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 486, Short.MAX_VALUE)
							.addComponent(borclu_scrllpane, GroupLayout.PREFERRED_SIZE, 319, GroupLayout.PREFERRED_SIZE)
							.addGap(95)))
					.addContainerGap())
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
						.addComponent(borclar_lbl, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(table_scrllpane, GroupLayout.PREFERRED_SIZE, 306, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(borc_btn)
						.addComponent(kisiler_btn))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(borclar_scrllpane, GroupLayout.PREFERRED_SIZE, 189, GroupLayout.PREFERRED_SIZE)
						.addComponent(borclu_scrllpane, GroupLayout.PREFERRED_SIZE, 189, GroupLayout.PREFERRED_SIZE))
					.addGap(27)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(geri_btn, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
						.addComponent(aidatlar_btn, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))
					.addGap(46))
		);
		
        kisiler_txta = new JTextArea();
        borclu_scrllpane.setViewportView(kisiler_txta);
        kisiler_txta.setFont(new Font("Times New Roman", Font.BOLD, 14));
        kisiler_txta.setEditable(false);
        kisiler_txta.setColumns(10);
		
        borclar_txta = new JTextArea();
        borclar_scrllpane.setViewportView(borclar_txta);
        borclar_txta.setFont(new Font("Times New Roman", Font.BOLD, 14));
        borclar_txta.setEditable(false);
		
		jTable1 = new JTable();
		jTable1.setFont(new java.awt.Font("Times New Roman", 0, 15)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(o,rows));
        jTable1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//frmBorclar.setVisible(false);
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
		frmBorclar.getContentPane().setLayout(groupLayout);
		frmBorclar.getContentPane().setBackground(new Color(220, 220, 220));
		
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
        borclar_txta.setText(show +  "TOPLAM: " +toplamx+".00 TL");
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
        kisiler_txta.setText(show + "TOPLAM: " +toplamx + " kişi");                                  
	}
	
	public static void centreWindow(JFrame frame) {
	    Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
	    int x = (int) ((dimension.getWidth() - frame.getWidth()) / 2);
	    int y = (int) ((dimension.getHeight() - frame.getHeight()) / 2);
	    frame.setLocation(x, y);
	}
}
