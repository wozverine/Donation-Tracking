


import javax.swing.JFrame;
import javax.swing.RowFilter;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.GroupLayout.Alignment;
import javax.swing.GroupLayout;
import javax.swing.LayoutStyle.ComponentPlacement;

public class borclar extends javax.swing.JFrame {

    public borclar() {
        
        try{
            
            for(UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()){
                if("Windows".equals(info.getName())){
                    UIManager.setLookAndFeel(info.getClassName());
                }
            }
        }
        catch(Exception ex){
            ex.getMessage();
        }
        
        initComponents();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
    	Color maroon=Color.decode("#800000");
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jTable1.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		setVisible(false);
        		personal p = new personal();
        		//p.setExtendedState(JFrame.MAXIMIZED_BOTH); 
        		p.setSize(700, 600);
        		p.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        	    p.setVisible(true);
        		centreWindow(p);
        	}
        });
        jPanel1 = new javax.swing.JPanel();
        row_txtf = new javax.swing.JTextField();
        ara_txtf = new javax.swing.JTextField();
        borclar_txtf = new javax.swing.JTextField();
        aidatlar_btn = new javax.swing.JButton();
        aidatlar_btn.setFont(new Font("Tahoma", Font.PLAIN, 15));
        aidatlar_btn.setBackground(new Color(128, 0, 0));
        geri_btn = new javax.swing.JButton();
        borc_btn = new javax.swing.JButton();
        borc_btn.setFont(new Font("Tahoma", Font.PLAIN, 15));
        borc_btn.setBackground(new Color(128, 0, 0));
        jScrollPane2 = new javax.swing.JScrollPane();
        borclar_txta = new javax.swing.JTextArea();
        kisiler_btn = new javax.swing.JButton();
        kisiler_btn.setFont(new Font("Tahoma", Font.PLAIN, 15));
        kisiler_btn.setBackground(new Color(128, 0, 0));
        jScrollPane3 = new javax.swing.JScrollPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);
        Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        getContentPane().setBounds(0, 0,screen.width-150,screen.height -150);
        getContentPane().setMinimumSize(new Dimension(720, 600));
        
        String [] rows= {"ID","İsimler","2012","2013","2014","2015","2016"};
		Object [][] names= {{"1","Ayşe","50","25","25","20","8"},{"2","Mehmet","50","25","25","5","0"},
				{"3","Mahmut","30","0","0","0","20"},{"4","Seval","16","8","0","20","6"},{"5","Ayşe","50","25","25","20","8"},
				{"6","Mehmet","50","25","25","5","0"},{"7","Mahmut","30","0","0","0","20"},{"8","Seval","16","8","0","20","6"}};
        
        jTable1.setFont(new java.awt.Font("Times New Roman", 0, 15)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
        		names,rows
        ));
        jTable1.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        jTable1.setGridColor(new java.awt.Color(68, 137, 246));
        jTable1.setPreferredSize(new java.awt.Dimension(1000, 500));
        jTable1.setRowHeight(25);
        jScrollPane1.setViewportView(jTable1);
        
        jScrollPane1.setBounds(0, 82, 1000, 255);
        getContentPane().add(jScrollPane1);
        getContentPane().setBackground(Color.GRAY);
        
        jPanel1.setBackground(Color.GRAY);
        jPanel1.setPreferredSize(new java.awt.Dimension(1000, 100));

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

        ara_txtf.setEditable(false);
        ara_txtf.setBackground(Color.GRAY);
        ara_txtf.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        ara_txtf.setText("ARA");

        borclar_txtf.setEditable(false);
        borclar_txtf.setBackground(Color.GRAY);
        borclar_txtf.setFont(new java.awt.Font("Times New Roman", 0, 25)); // NOI18N
        borclar_txtf.setText("BORÇLAR");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1Layout.setHorizontalGroup(
        	jPanel1Layout.createParallelGroup(Alignment.TRAILING)
        		.addGroup(jPanel1Layout.createSequentialGroup()
        			.addGap(49)
        			.addComponent(borclar_txtf, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        			.addPreferredGap(ComponentPlacement.RELATED, 538, Short.MAX_VALUE)
        			.addComponent(ara_txtf, GroupLayout.PREFERRED_SIZE, 76, GroupLayout.PREFERRED_SIZE)
        			.addPreferredGap(ComponentPlacement.UNRELATED)
        			.addComponent(row_txtf, GroupLayout.PREFERRED_SIZE, 192, GroupLayout.PREFERRED_SIZE)
        			.addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
        	jPanel1Layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(jPanel1Layout.createSequentialGroup()
        			.addContainerGap(22, Short.MAX_VALUE)
        			.addGroup(jPanel1Layout.createParallelGroup(Alignment.LEADING)
        				.addGroup(jPanel1Layout.createParallelGroup(Alignment.BASELINE)
        					.addComponent(row_txtf, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
        					.addComponent(ara_txtf, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        				.addComponent(borclar_txtf, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        			.addGap(27))
        );
        jPanel1.setLayout(jPanel1Layout);
        jPanel1.setBounds(0, 0, 1000, 82);
        getContentPane().add(jPanel1);
        
        aidatlar_btn.setText("Aidatlar");
        aidatlar_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BorclarActionPerformed(evt);
            }
        });
        aidatlar_btn.setBounds(10, 550, 100, 40);
        getContentPane().add(aidatlar_btn);
        

        geri_btn.setText("Geri");
        geri_btn.setFont(new Font("Tahoma", Font.PLAIN, 15));
        geri_btn.setForeground(Color.BLACK);
		geri_btn.setBackground(new Color(128, 0, 0));
        geri_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GeriActionPerformed(evt);
            }
        });
        getContentPane().add(geri_btn);
        geri_btn.setBounds(890, 550, 100, 40);

        borc_btn.setText("Borç toplam");
        borc_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aidatlarActionPerformed(evt);
            }
        });
        getContentPane().add(borc_btn);
        borc_btn.setBounds(193, 348, 132, 45);

        jScrollPane2.setPreferredSize(new java.awt.Dimension(200, 70));

        borclar_txta.setEditable(false);
        borclar_txta.setColumns(20);
        borclar_txta.setFont(new java.awt.Font("Times New Roman", 0, 15)); // NOI18N
        borclar_txta.setRows(6);
        borclar_txta.setPreferredSize(new java.awt.Dimension(200, 70));
        jScrollPane2.setViewportView(borclar_txta);

        getContentPane().add(jScrollPane2);
        jScrollPane2.setBounds(121, 404, 280, 138);

        kisiler_btn.setText("Borçlu Sayısı");
        kisiler_btn.setPreferredSize(new java.awt.Dimension(135, 23));
        kisiler_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kisilerActionPerformed(evt);
            }
        });
        getContentPane().add(kisiler_btn);
        kisiler_btn.setBounds(686, 348, 132, 42);

        getContentPane().add(jScrollPane3);
        jScrollPane3.setBounds(600, 404, 299, 135);
        kisiler_txta = new javax.swing.JTextArea();
        kisiler_txta.setBounds(600, 405, 299, 134);
        getContentPane().add(kisiler_txta);
        
                kisiler_txta.setEditable(false);
                kisiler_txta.setColumns(20);
                kisiler_txta.setFont(new java.awt.Font("Times New Roman", 0, 15)); // NOI18N
                kisiler_txta.setRows(6);

        setSize(new java.awt.Dimension(1016, 639));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void GeriActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GeriActionPerformed
        // TODO add your handling code here:
    	
    	setVisible(false);
		main m = new main();
		m.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		m.setVisible(true);
		centreWindow(m);
    	
    }//GEN-LAST:event_GeriActionPerformed

    private void jTextField1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1KeyPressed
        DefaultTableModel model = (DefaultTableModel)jTable1.getModel();
        TableRowSorter<DefaultTableModel> tr = new TableRowSorter<DefaultTableModel>(model);
        jTable1.setRowSorter(tr);
        tr.setRowFilter(RowFilter.regexFilter(row_txtf.getText().trim()));
    }//GEN-LAST:event_jTextField1KeyPressed

    private void personalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    	setVisible(false);
		personal p = new personal();
		//p.setExtendedState(JFrame.MAXIMIZED_BOTH); 
		p.setSize(700, 600);
		p.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    p.setVisible(true);
	    centreWindow(p);
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void aidatlarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        int Y2012=0;
        int Y2013=0;
        int Y2014=0;
        int Y2015=0;
        int Y2016=0;
        int toplam=0;
        
        for(int y=0; y<jTable1.getRowCount(); y++){
        	Y2012+=Integer.parseInt(jTable1.getValueAt(y, 2).toString());
        	Y2013+=Integer.parseInt(jTable1.getValueAt(y, 3).toString());
            Y2014+=Integer.parseInt(jTable1.getValueAt(y, 4).toString());
            Y2015+=Integer.parseInt(jTable1.getValueAt(y, 5).toString());
            Y2016+=Integer.parseInt(jTable1.getValueAt(y, 6).toString());
        }
        toplam = Y2012+Y2013+Y2014+Y2015+Y2016;
        borclar_txta.setText(jTable1.getColumnName(2)+": "+Y2012+".00 TL\n"
                +jTable1.getColumnName(3)+": "+Y2013+".00 TL\n"
                +jTable1.getColumnName(4)+": "+Y2014+".00 TL\n"
                +jTable1.getColumnName(5)+": "+Y2015+".00 TL\n"
                +jTable1.getColumnName(6)+": "+Y2016+".00 TL\n"
                + "\nGENEL TOPLAM: "+toplam+".00 TL");
    }//GEN-LAST:event_jButton3ActionPerformed

    private void kisilerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
    	int K2012=0;
    	int K2013=0;
    	int K2014=0;
    	int K2015=0;
        int K2016=0;
        int toplam=0;
        for(int y=0; y<jTable1.getRowCount(); y++){
        	if(Integer.parseInt(jTable1.getValueAt(y, 2).toString()) !=0 ){K2012++;}
        	if(Integer.parseInt(jTable1.getValueAt(y, 3).toString()) !=0 ){K2013++;}
        	if(Integer.parseInt(jTable1.getValueAt(y, 4).toString()) !=0 ){K2014++;}
        	if(Integer.parseInt(jTable1.getValueAt(y, 5).toString()) !=0 ){K2015++;}
            if(Integer.parseInt(jTable1.getValueAt(y, 6).toString()) !=0 ){K2016++;}
        }
        toplam = K2012+K2013+K2014+K2015+K2016;
        kisiler_txta.setText(jTable1.getColumnName(2)+": "+K2012+" kişi\n"
                +jTable1.getColumnName(3)+": "+K2013+" kişi\n"
                +jTable1.getColumnName(4)+": "+K2014+" kişi\n"
                +jTable1.getColumnName(5)+": "+K2015+" kişi\n"
                +jTable1.getColumnName(6)+": "+K2016+" kişi\n"
                + "\nTOPLAM: "+toplam+" kişi ödeme yapmamıştır.");
                                        
    }//GEN-LAST:event_jButton4ActionPerformed

    private void BorclarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BorÃ§larActionPerformed
        // TODO add your handling code here:
    	setVisible(false);
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					aidatlar window = new aidatlar();
					window.setVisible(true);
					centreWindow(window);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
    }//GEN-LAST:event_BorÃ§larActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void centreWindow(JFrame frame) {
	    Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
	    int x = (int) ((dimension.getWidth() - frame.getWidth()) / 2);
	    int y = (int) ((dimension.getHeight() - frame.getHeight()) / 2);
	    frame.setLocation(x, y);
	}
    
    
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton aidatlar_btn;
    private javax.swing.JButton geri_btn;
    private javax.swing.JButton borc_btn;
    private javax.swing.JButton kisiler_btn;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextArea borclar_txta;
    private javax.swing.JTextArea kisiler_txta;
    private javax.swing.JTextField row_txtf;
    private javax.swing.JTextField ara_txtf;
    private javax.swing.JTextField borclar_txtf;
    // End of variables declaration//GEN-END:variables




}
