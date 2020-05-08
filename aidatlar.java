import java.awt.event.ActionListener;
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
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.border.LineBorder;

public class aidatlar extends javax.swing.JFrame {
	ArrayList<person> pArr = new ArrayList<person>();
	Date date = new Date();
	LocalDate localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
	int year  = localDate.getYear();
	private javax.swing.JButton borclar_btn;
    private javax.swing.JButton geri_btn;
    private javax.swing.JButton borc_btn;
    private javax.swing.JButton kisiler_btn;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextArea borclar_txta;
    private javax.swing.JTextArea kisiler_txta;
    private javax.swing.JTextField row_txtf;
    private javax.swing.JTextField ara_txtf;
    private javax.swing.JTextField aidatlar_txtf;
    
	JFrame frmAidatlar;

	
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
		
		aidatlar_txtf = new JTextField("Aidatlar");
		aidatlar_txtf.setEditable(false);
	    aidatlar_txtf.setBackground(new Color(220, 220, 220));
		aidatlar_txtf.setHorizontalAlignment(SwingConstants.LEFT);
		aidatlar_txtf.setFont(new java.awt.Font("Times New Roman", 0, 25)); // NOI18N
        aidatlar_txtf.setText("AİDATLAR");
		
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
        String [] rows= {"TC","İsim","Soyisim","2010","2011","2012","2013","2014","2015","2016","2017","2018","2019","2020"};
        
		borclar_btn = new JButton("Borçlar");
		borclar_btn.setFont(new Font("Calibri", Font.PLAIN, 15));
		borclar_btn.setForeground(Color.BLACK);
		borclar_btn.setBackground(new Color(169, 169, 169));
		borclar_btn.setBorder(new LineBorder(new Color(128, 0, 0), 2, true));
		borclar_btn.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        	
        		setVisible(false);
        		EventQueue.invokeLater(new Runnable() {
        			public void run() {
        				try {
        					frmAidatlar.setVisible(false);
        					borclar window = new borclar(list);
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
        	
        		EventQueue.invokeLater(new Runnable() {
        			public void run() {
        				try {
        					frmAidatlar.setVisible(false);
        					main m= new main(list);
        					m.setVisible(true);
        					centreWindow(m);
        					m.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        				} catch (Exception e) {
        					e.printStackTrace();
        				}
        			}
        		});
        		
        	}
        });
		
		JScrollPane top = new JScrollPane();
		
		ara_txtf = new JTextField("ARA");
		ara_txtf.setHorizontalAlignment(SwingConstants.CENTER);
		ara_txtf.setEnabled(false);
		ara_txtf.setEditable(false);
		ara_txtf.setForeground(Color.BLACK);
		ara_txtf.setFont(new Font("Times New Roman", Font.BOLD, 14));
		
		row_txtf = new JTextField();
		row_txtf.setColumns(10);
		row_txtf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                personalActionPerformed(evt);
            }
        });
        row_txtf.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField1KeyPressed(evt);
            }
        });

		
		borc_btn = new JButton("Ödenen aidat toplam");
        borc_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
               
               aidatlarActionPerformed(evt);
            }
        });
        
        kisiler_btn = new JButton("Aidat Ödeyen Sayısı");
        kisiler_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	kisilerActionPerformed(evt);
            }
        });
		
        borclar_txta = new JTextArea();
        borclar_txta.setFont(new Font("Times New Roman", Font.BOLD, 14));
        borclar_txta.setEditable(false);
		
        kisiler_txta = new JTextArea();
        kisiler_txta.setFont(new Font("Times New Roman", Font.BOLD, 14));
        kisiler_txta.setEditable(false);
        kisiler_txta.setColumns(10);
        GroupLayout groupLayout = new GroupLayout(frmAidatlar.getContentPane());
        groupLayout.setHorizontalGroup(
        	groupLayout.createParallelGroup(Alignment.LEADING)
        		.addGroup(groupLayout.createSequentialGroup()
        			.addGap(21)
        			.addComponent(aidatlar_txtf, GroupLayout.PREFERRED_SIZE, 411, GroupLayout.PREFERRED_SIZE)
        			.addPreferredGap(ComponentPlacement.RELATED, 655, Short.MAX_VALUE)
        			.addComponent(ara_txtf, 44, 44, 44)
        			.addGap(18)
        			.addComponent(row_txtf, GroupLayout.PREFERRED_SIZE, 177, GroupLayout.PREFERRED_SIZE)
        			.addGap(24))
        		.addGroup(groupLayout.createSequentialGroup()
        			.addContainerGap()
        			.addComponent(top, GroupLayout.DEFAULT_SIZE, 1330, Short.MAX_VALUE)
        			.addContainerGap())
        		.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
        			.addGap(237)
        			.addComponent(borc_btn)
        			.addPreferredGap(ComponentPlacement.RELATED, 630, Short.MAX_VALUE)
        			.addComponent(kisiler_btn)
        			.addGap(221))
        		.addGroup(groupLayout.createSequentialGroup()
        			.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
        				.addGroup(groupLayout.createSequentialGroup()
        					.addGap(42)
        					.addComponent(borclar_btn, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE))
        				.addGroup(groupLayout.createSequentialGroup()
        					.addGap(148)
        					.addComponent(borclar_txta, GroupLayout.PREFERRED_SIZE, 310, GroupLayout.PREFERRED_SIZE)))
        			.addPreferredGap(ComponentPlacement.RELATED, 447, Short.MAX_VALUE)
        			.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
        				.addGroup(groupLayout.createSequentialGroup()
        					.addComponent(geri_btn, GroupLayout.PREFERRED_SIZE, 82, GroupLayout.PREFERRED_SIZE)
        					.addGap(65))
        				.addGroup(groupLayout.createSequentialGroup()
        					.addComponent(kisiler_txta, GroupLayout.PREFERRED_SIZE, 318, GroupLayout.PREFERRED_SIZE)
        					.addGap(127))))
        );
        groupLayout.setVerticalGroup(
        	groupLayout.createParallelGroup(Alignment.LEADING)
        		.addGroup(groupLayout.createSequentialGroup()
        			.addContainerGap()
        			.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
        				.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
        					.addComponent(row_txtf, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        					.addComponent(ara_txtf, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        				.addComponent(aidatlar_txtf, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addComponent(top, GroupLayout.PREFERRED_SIZE, 306, GroupLayout.PREFERRED_SIZE)
        			.addGap(18)
        			.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(kisiler_btn)
        				.addComponent(borc_btn))
        			.addPreferredGap(ComponentPlacement.UNRELATED)
        			.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(kisiler_txta, GroupLayout.PREFERRED_SIZE, 206, GroupLayout.PREFERRED_SIZE)
        				.addComponent(borclar_txta, GroupLayout.PREFERRED_SIZE, 206, GroupLayout.PREFERRED_SIZE))
        			.addPreferredGap(ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
        			.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(geri_btn, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
        				.addComponent(borclar_btn, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))
        			.addGap(46))
        );
		
		jTable1 = new JTable();
		jTable1.setFont(new java.awt.Font("Times New Roman", 0, 15)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(o,rows));
        

      
        jTable1 = new JTable();
		jTable1.setFont(new java.awt.Font("Times New Roman", 0, 15)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(o,rows));
        jTable1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//frmAidatlar.setVisible(false);
				int rowSelected =jTable1.getSelectedRow(); 
        		personal p = new personal(list, rowSelected);
        		p.setSize(700, 600);
        		centreWindow(p);
        		p.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        	    p.setVisible(true);
        		
			}
		});		
		top.setViewportView(jTable1);
		frmAidatlar.getContentPane().setLayout(groupLayout);
		frmAidatlar.getContentPane().setBackground(new Color(220, 220, 220));
		
	}
	
	private void jTextField1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1KeyPressed
        DefaultTableModel model = (DefaultTableModel)jTable1.getModel();
        TableRowSorter<DefaultTableModel> tr = new TableRowSorter<DefaultTableModel>(model);
        jTable1.setRowSorter(tr);
        tr.setRowFilter(RowFilter.regexFilter(row_txtf.getText().trim()));
    }//GEN-LAST:event_jTextField1KeyPressed

    private void personalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
    	frmAidatlar.setVisible(false);
    	int rowSelected =jTable1.getSelectedRow();
		personal p = new personal(pArr,rowSelected); 
		p.setSize(700, 600);
		p.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    p.setVisible(true);
	    centreWindow(p);
    }//GEN-LAST:event_jTextField1ActionPerformed
	
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
