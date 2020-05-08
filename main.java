import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.table.*;

public class main extends javax.swing.JFrame {
	private javax.swing.JButton kisiler_btn;
    private javax.swing.JButton borc_btn;
    private javax.swing.JButton aidat_btn;
    private javax.swing.JButton dosya_btn;
    private javax.swing.JButton ara_btn;
    private javax.swing.JLabel kisiler_lbl;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField ara_txtf;
    private JButton exit_btn;
    private JButton minimize_btn;
    int posX;
    int posY;
    public main(ArrayList<person> list) {
    	initComponents(list);
    }

    private void initComponents(ArrayList<person> list) {
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
    	
    	kisiler_btn = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jTable1.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent arg0) {
        		//setVisible(false);
        		int rowSelected =jTable1.getSelectedRow();
        		personal p = new personal(list, rowSelected);
        		p.setSize(700, 600);
        		p.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        	    p.setVisible(true);
        		centreWindow(p);
        	}
        });
        borc_btn = new javax.swing.JButton();
        
        borc_btn.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        	
        		setVisible(false);
        		EventQueue.invokeLater(new Runnable() {
        			public void run() {
        				try {
        					borclar window = new borclar(list);
        					window.frmBorclar.setVisible(true);
        				} catch (Exception e) {
        					e.printStackTrace();
        				}
        			}
        		});
        		
        	}
        });
        aidat_btn = new javax.swing.JButton();
        aidat_btn.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        	
        		setVisible(false);
        		EventQueue.invokeLater(new Runnable() {
        			public void run() {
        				try {
        					aidatlar window = new aidatlar(list);
        					window.frmAidatlar.setVisible(true);
        				} catch (Exception e) {
        					e.printStackTrace();
        				}
        			}
        		});
        		
        	}
        });
        dosya_btn = new javax.swing.JButton();
        dosya_btn.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent arg0) {
        		setVisible(false);
        		Excel_Form exc = new Excel_Form(list);
        		exc.setVisible(false);
        		exc.dispose();
        		exc.setUndecorated(true);
        		exc.setSize(370,270);
                exc.setShape(new RoundRectangle2D.Double(0, 0, exc.getWidth(), exc.getHeight(), 20, 20));
        		centreWindow(exc);  		
        		exc.setVisible(true);
        	}
        });
        ara_txtf = new javax.swing.JTextField();
        kisiler_lbl = new javax.swing.JLabel();
        ara_btn = new javax.swing.JButton();

        kisiler_btn.setBackground(javax.swing.UIManager.getDefaults().getColor("EditorPane.foreground"));
        kisiler_btn.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N
        kisiler_btn.setForeground(new java.awt.Color(0, 0, 255));
        kisiler_btn.setText("Kişiler");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(javax.swing.UIManager.getDefaults().getColor("CheckBox.foreground"));
        setForeground(new java.awt.Color(255, 255, 51));
        setMaximumSize(new java.awt.Dimension(800, 500));
        setMinimumSize(new java.awt.Dimension(800, 500));
        setPreferredSize(new java.awt.Dimension(800, 500));
        setResizable(false);
        getContentPane().setLayout(null);
        
        Object[][] o=new Object[list.size()][3];
        for (int count=0;count<list.size();count++) {
        	o[count][0]=list.get(count).getAd_lbl();
        	o[count][1]=list.get(count).getSoy_lbl();
        	o[count][2]=list.get(count).getKimlikNo_lbl();        	
        }
        
        String[] s= {"Ad", "Soyad", "T.C Kimlik No"};
        jTable1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION))));
        jTable1.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(o,s));
        jTable1.setSelectionBackground(new java.awt.Color(255, 255, 102));
        jTable1.setSelectionForeground(new java.awt.Color(0, 0, 0));
        jScrollPane1.setViewportView(jTable1);
        jScrollPane1.setBounds(10, 76, 773, 245);
        getContentPane().add(jScrollPane1);

        borc_btn.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        borc_btn.setText("Borcu olanları görüntüle");
        borc_btn.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        borc_btn.setPreferredSize(new java.awt.Dimension(161, 23));
        borc_btn.setBounds(10, 355, 161, 23);
        getContentPane().add(borc_btn);

        aidat_btn.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        aidat_btn.setText("Ödenen aidatları görüntüle");
        aidat_btn.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        aidat_btn.setBounds(215, 356, 160, 21);
        getContentPane().add(aidat_btn);

        dosya_btn.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        dosya_btn.setText("Dosya ekle");
        dosya_btn.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        dosya_btn.setMinimumSize(new java.awt.Dimension(161, 23));
        dosya_btn.setPreferredSize(new java.awt.Dimension(161, 23));
        dosya_btn.setBounds(605, 355, 161, 23);
        getContentPane().add(dosya_btn);

        ara_txtf.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        //kimlik_txtf.setText("T.C Kimlik No ");
        ara_txtf.setBounds(500, 40, 220, 25);
        ara_txtf.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                personalActionPerformed(evt);
            }
        });
        getContentPane().add(ara_txtf);

        kisiler_lbl.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N
        kisiler_lbl.setText("Kişiler");
        kisiler_lbl.setBounds(39, 37, 145, 29);
        getContentPane().add(kisiler_lbl);

        ara_btn.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        ara_btn.setText("Ara");
        ara_btn.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        ara_btn.setBounds(730, 40, 43, 25);
        ara_btn.addActionListener(new java.awt.event.ActionListener() {
			@Override
			public void actionPerformed(ActionEvent evt) {
				araButtonAction(evt);
			}
        });
        getContentPane().add(ara_btn);
        
        exit_btn = new JButton("x");
        exit_btn.setBounds(755, 2, 35, 29);
        getContentPane().add(exit_btn);
        exit_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {		
				System.exit(0);
			}
        });
        
        minimize_btn = new JButton("_");
        minimize_btn.setBounds(720, 2, 35, 29);
        minimize_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {		
				setState(JFrame.ICONIFIED);
			}
        });
        getContentPane().add(minimize_btn);

        pack();
    }// </editor-fold>                                                       

    private void personalActionPerformed(KeyEvent evt) {                                            
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
    public static void centreWindow(JFrame frame) {
	    Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
	    int x = (int) ((dimension.getWidth() - frame.getWidth()) / 2);
	    int y = (int) ((dimension.getHeight() - frame.getHeight()) / 2);
	    frame.setLocation(x, y);
	}          
}
