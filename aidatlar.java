


import javax.swing.JFrame;
import javax.swing.RowFilter;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class aidatlar extends javax.swing.JFrame {

    public aidatlar() {
        
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
        aidatlar_txtf = new javax.swing.JTextField();
        borclar_btn = new javax.swing.JButton();
        geri_btn = new javax.swing.JButton();
        aidatlar_btn = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        aidatlar_txta = new javax.swing.JTextArea();
        kisiler_btn = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        kisiler_txta = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jTable1.setFont(new java.awt.Font("Times New Roman", 0, 15)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"1", "ayşe", "50", "0", "70"},
                {"2", "mehmet", "50", "60", "70"},
                {"3", "nazan", "0", "60", "70"},
                {"4", "emre", "0", "60", "70"}
            },
            new String [] {
                "ID", "AD", "2010", "2011", "2012"
            }
        ));
        jTable1.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        jTable1.setGridColor(new java.awt.Color(68, 137, 246));
        jTable1.setPreferredSize(new java.awt.Dimension(1000, 500));
        jTable1.setRowHeight(25);
        jScrollPane1.setViewportView(jTable1);
        
        jScrollPane1.setBounds(0, 110, 1000, 250);
        getContentPane().add(jScrollPane1);
        
        jPanel1.setBackground(new java.awt.Color(68, 137, 246));
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
        ara_txtf.setBackground(new java.awt.Color(68, 137, 246));
        ara_txtf.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        ara_txtf.setText("ARA");

        aidatlar_txtf.setEditable(false);
        aidatlar_txtf.setBackground(new java.awt.Color(68, 137, 246));
        aidatlar_txtf.setFont(new java.awt.Font("Times New Roman", 0, 25)); // NOI18N
        aidatlar_txtf.setText("AİDATLAR");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addComponent(aidatlar_txtf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 616, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(row_txtf, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ara_txtf, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(27, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(ara_txtf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(row_txtf, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(aidatlar_txtf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27))))
        );
        jPanel1.setBounds(0, 0, 1000, 100);
        getContentPane().add(jPanel1);
        
        borclar_btn.setText("Borc");
        borclar_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BorclarActionPerformed(evt);
            }
        });
        borclar_btn.setBounds(10, 550, 100, 40);
        getContentPane().add(borclar_btn);
        

        geri_btn.setText("Geri");
        geri_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GeriActionPerformed(evt);
            }
        });
        getContentPane().add(geri_btn);
        geri_btn.setBounds(890, 550, 100, 40);

        aidatlar_btn.setText("Ödenen Toplam Aidat");
        aidatlar_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aidatlarActionPerformed(evt);
            }
        });
        getContentPane().add(aidatlar_btn);
        aidatlar_btn.setBounds(180, 360, 150, 60);

        jScrollPane2.setPreferredSize(new java.awt.Dimension(200, 70));

        aidatlar_txta.setEditable(false);
        aidatlar_txta.setColumns(20);
        aidatlar_txta.setFont(new java.awt.Font("Times New Roman", 0, 15)); // NOI18N
        aidatlar_txta.setRows(5);
        aidatlar_txta.setPreferredSize(new java.awt.Dimension(200, 70));
        jScrollPane2.setViewportView(aidatlar_txta);

        getContentPane().add(jScrollPane2);
        jScrollPane2.setBounds(120, 430, 270, 100);

        kisiler_btn.setText("Odeyen Kisi Sayısı");
        kisiler_btn.setPreferredSize(new java.awt.Dimension(135, 23));
        kisiler_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kisilerActionPerformed(evt);
            }
        });
        getContentPane().add(kisiler_btn);
        kisiler_btn.setBounds(670, 360, 150, 60);

        kisiler_txta.setEditable(false);
        kisiler_txta.setColumns(20);
        kisiler_txta.setFont(new java.awt.Font("Times New Roman", 0, 15)); // NOI18N
        kisiler_txta.setRows(5);
        jScrollPane3.setViewportView(kisiler_txta);

        getContentPane().add(jScrollPane3);
        jScrollPane3.setBounds(600, 430, 300, 100);

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
        int Y2010=0;
        int Y2011=0;
        int Y2012=0;
        int toplam=0;
        
        for(int y=0; y<jTable1.getRowCount(); y++){
            Y2010+=Integer.parseInt(jTable1.getValueAt(y, 2).toString());
            Y2011+=Integer.parseInt(jTable1.getValueAt(y, 3).toString());
            Y2012+=Integer.parseInt(jTable1.getValueAt(y, 4).toString());
        }
        toplam = Y2010+Y2011+Y2012;
        aidatlar_txta.setText(jTable1.getColumnName(2)+": "+Y2010+".00 TL\n"
                +jTable1.getColumnName(3)+": "+Y2011+".00 TL\n"
                +jTable1.getColumnName(4)+": "+Y2012+".00 TL\n"
                + "\nGENEL TOPLAM: "+toplam+".00 TL");
    }//GEN-LAST:event_jButton3ActionPerformed

    private void kisilerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        int K2010=0;
        int K2011=0;
        int K2012=0;
        int toplam=0;
        for(int y=0; y<jTable1.getRowCount(); y++){
            if(Integer.parseInt(jTable1.getValueAt(y, 2).toString()) !=0 ){
            K2010++;}
            if(Integer.parseInt(jTable1.getValueAt(y, 3).toString()) !=0 ){
            K2011++;}
            if(Integer.parseInt(jTable1.getValueAt(y, 4).toString()) !=0 ){
            K2012++;}
        }
        toplam = K2010+K2011+K2012;
        kisiler_txta.setText(jTable1.getColumnName(2)+": "+K2010+" kişi\n"
                +jTable1.getColumnName(3)+": "+K2011+" kişi\n"
                +jTable1.getColumnName(4)+": "+K2012+" kişi\n"
                + "\nTOPLAM: "+toplam+" kişi ödeme yapmayacaktır.");
                                        
    }//GEN-LAST:event_jButton4ActionPerformed

    private void BorclarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BorÃ§larActionPerformed
        // TODO add your handling code here:
    	setVisible(false);
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					debts window = new debts();
					window.frmAidatlar.setVisible(true);
					centreWindow(window.frmAidatlar);
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
    private javax.swing.JButton borclar_btn;
    private javax.swing.JButton geri_btn;
    private javax.swing.JButton aidatlar_btn;
    private javax.swing.JButton kisiler_btn;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextArea aidatlar_txta;
    private javax.swing.JTextArea kisiler_txta;
    private javax.swing.JTextField row_txtf;
    private javax.swing.JTextField ara_txtf;
    private javax.swing.JTextField aidatlar_txtf;
    // End of variables declaration//GEN-END:variables




}
