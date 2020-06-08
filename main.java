import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;
import java.io.File;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.swing.*;
import javax.swing.filechooser.FileSystemView;
import javax.swing.table.*;

public class main extends javax.swing.JFrame {	
    private javax.swing.JLabel kisiler_lbl;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField ara_txtf;
    private JButton exit_btn;
    private JButton minimize_btn;
    private JButton stats_btn;
    private JButton aidat_bilgi_btn;
    private javax.swing.JButton kisiler_btn;
    private javax.swing.JButton borc_btn;
    private javax.swing.JButton aidat_btn;
    private javax.swing.JButton dosya_btn;
    private javax.swing.JButton ara_btn;
    int posX;
    int posY;
    public main(ArrayList<person> list) {
    	initComponents(list);
    }

    private void initComponents(ArrayList<person> list) {
    	//move window
    	this.addMouseListener(new MouseAdapter(){
  			public void mousePressed(MouseEvent e){
  				posX=e.getX();
    			posY=e.getY();
  			}	
    	});
    	this.addMouseMotionListener(new MouseAdapter(){
    		public void mouseDragged(MouseEvent evt){		
    			setLocation (evt.getXOnScreen()-posX,evt.getYOnScreen()-posY);	        					
    		}
    	});
    	//move window
    	//Create folder and log
    	try {
    		String documentpath=FileSystemView.getFileSystemView().getDefaultDirectory().getPath()+"\\Donation Tracking";
    		File file = new File(documentpath);
    		file.mkdir();
    
            File file_2 = new File(documentpath+"\\logs.txt");
            
            
            File file3=new File(documentpath+"\\Belgeler");
            file3.mkdir();
    		//System.out.println("Directory created successfully");
    		
    	}catch(Exception e){
    		System.out.println("Sorry couldn’t create specified directory "+e);
    	}
    	
    	//Create folder and log
    	
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jTable1.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent arg0) {
        		//setVisible(false);
        		dispose();
        		int rowSelected =jTable1.getSelectedRow();
        		//list.get(rowSelected);
        		//personal p = new personal(list, rowSelected,false);
        		personal p = new personal(list,list.get(rowSelected),false);
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
        
        
        stats_btn = new JButton("İstatistikler");
        stats_btn.setFont(new Font("Arial", Font.PLAIN, 12));
        stats_btn.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        stats_btn.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent arg0) {	
        		String []bolum=new String[list.size()];
        		String []giris_yıl=new String[list.size()];
        		String []mezun_yıl=new String[list.size()];
        		String []calısma=new String[list.size()];
        		String []il=new String[list.size()];
        		Date date = new Date();
        		LocalDate localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        		int year_now = localDate.getYear();
        		String[][]odeme=new String[year_now-2010+1][list.size()];
        		if(list!=null) {
        			int sum=0;
        			for(int x=0;x<list.size();x++) {
        				bolum[x]=list.get(x).getBolum_lbl();
        				String []giris=list.get(x).getGirisTarihi_lbl().split("-");
        				giris_yıl[x]=giris[giris.length-1];
        				String []mezun=list.get(x).getMezTarihi_lbl().split("-");
        				mezun_yıl[x]=mezun[mezun.length-1];
        				calısma[x]=list.get(x).getCalismayer_lbl();
        				il[x]=list.get(x).getIl_lbl();
        			}
        			int len=bolum.length;
        			for(int x=0;x<year_now-2010+1;x++) {
        				for(int t=0;t<len;t++) {
        					odeme[x][t]=Integer.toString(list.get(t).getBorcarray()[x]);
        				}
        			}

        		}
        		Map<String, Integer> bolum_map=countArray(bolum);
        		Map<String, Integer> giris_yıl_map=countArray(giris_yıl);
        		Map<String, Integer> mezun_yıl_map=countArray(mezun_yıl);
        		Map<String, Integer> calısma_map=countArray(calısma);
        		Map<String, Integer> il_map=countArray(il);
        		
        		stats_choose stats=new stats_choose(bolum_map,giris_yıl_map,mezun_yıl_map,calısma_map,il_map,odeme);
        		stats.setVisible(false);
				stats.dispose();
				stats.setUndecorated(true);
				stats.setSize(370,270);
				stats.setShape(new RoundRectangle2D.Double(0, 0, stats.getWidth(), stats.getHeight(), 20, 20));
        		centreWindow(stats);  		
        		stats.setVisible(true);
        	}
        });
        stats_btn.setBounds(389, 356, 98, 23);
        getContentPane().add(stats_btn);
        
        borc_btn = new javax.swing.JButton();
        borc_btn.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		//setVisible(false);
        		EventQueue.invokeLater(new Runnable() {
        			public void run() {
        				try {
        					borclar window = new borclar(list);
        					//window.frmBorclar.setVisible(true);
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
        aidat_btn = new javax.swing.JButton();
        aidat_btn.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		//setVisible(false);
        		EventQueue.invokeLater(new Runnable() {
        			public void run() {
        				try {
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
        dosya_btn = new javax.swing.JButton();
        dosya_btn.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent arg0) {
        		//setVisible(false);
        		dispose();
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
        
        ara_txtf = new javax.swing.JTextField();
        ara_txtf.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        //kimlik_txtf.setText("T.C Kimlik No");
        ara_txtf.setBounds(500, 40, 220, 25);
        ara_txtf.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                personalActionPerformed(evt);
            }
        });
        getContentPane().add(ara_txtf);
        
        kisiler_lbl = new javax.swing.JLabel();
        kisiler_lbl.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N
        kisiler_lbl.setText("Kişiler");
        kisiler_lbl.setBounds(39, 37, 145, 29);
        getContentPane().add(kisiler_lbl);
        
        kisiler_btn = new javax.swing.JButton();
        kisiler_btn.setBackground(javax.swing.UIManager.getDefaults().getColor("EditorPane.foreground"));
        kisiler_btn.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N
        kisiler_btn.setForeground(new java.awt.Color(0, 0, 255));
        kisiler_btn.setText("Kişiler");
        
        borc_btn.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        borc_btn.setText("Borcu olanları görüntüle");
        borc_btn.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        borc_btn.setPreferredSize(new java.awt.Dimension(161, 23));
        borc_btn.setBounds(10, 356, 161, 23);
        getContentPane().add(borc_btn);

        aidat_btn.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        aidat_btn.setText("Ödenen aidatları görüntüle");
        aidat_btn.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        aidat_btn.setBounds(204, 357, 160, 21);
        getContentPane().add(aidat_btn);

        dosya_btn.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        dosya_btn.setText("Dosya ekle");
        dosya_btn.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        dosya_btn.setMinimumSize(new java.awt.Dimension(161, 23));
        dosya_btn.setPreferredSize(new java.awt.Dimension(161, 23));
        dosya_btn.setBounds(685, 355, 98, 23);
        getContentPane().add(dosya_btn);
        
        ara_btn = new javax.swing.JButton();
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
        
        aidat_bilgi_btn = new JButton("Aidat Bilgileri");
        aidat_bilgi_btn.setFont(new Font("Arial", Font.PLAIN, 12));
        aidat_bilgi_btn.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        aidat_bilgi_btn.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		aidat_info l = new aidat_info();
        		l.setSize(480,460);
        		l.setUndecorated(true);
        		l.setShape(new RoundRectangle2D.Double(0, 0, l.getWidth(), l.getHeight(), 20, 20));
        		l.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        		l.setVisible(true);
        		centreWindow(l);
        	}
        });
        aidat_bilgi_btn.setBounds(523, 356, 123, 23);
        getContentPane().add(aidat_bilgi_btn);
        pack();
    }                                                    

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
    
    public Map<String, Integer> countArray(String[] arr) {
        int len = arr.length;
        Map<String, Integer> map = new HashMap<String, Integer>();
        for(int i = 0; i < len; i++) {
            String key = arr[i];
            if (map.containsKey(key)) {
                int value = map.get(key);
                map.put(key, value + 1);
            } else {
                map.put(key, 1);
            }
        }
        return map;
    }
    public int sum(int arr[]) {
    	int sum_arr=0;
    	for(int x=0;x<arr.length;x++) {
    		sum_arr=sum_arr+arr[x];
    	}
    	return sum_arr;
    }
    
}
