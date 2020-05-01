import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import java.awt.Button;
import java.awt.Color;

import javax.swing.JSplitPane;
import javax.swing.JPanel;
import javax.swing.BoxLayout;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.ScrollPane;
import java.awt.Toolkit;
import java.awt.Component;
import java.awt.Dimension;

import javax.swing.Box;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JScrollPane;
import java.awt.Font;
import javax.swing.JTextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class debts {

	JFrame frmAidatlar;
	private JTable main_t;
	private JTable toplam_t;
	private JTable kisi_t;
	private JTextField textField;

	
	public debts() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		Color maroon=Color.decode("#800000");
		frmAidatlar = new JFrame();
		frmAidatlar.setTitle("Borçlar");
		Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
		frmAidatlar.setBounds(0, 0,screen.width-150,screen.height -150);
		frmAidatlar.setMinimumSize(new Dimension(720, 600));
		//frmAidatlar.setExtendedState(Frame.MAXIMIZED_BOTH);
		frmAidatlar.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel lblBorla = new JLabel("Borçlar");
		lblBorla.setForeground(Color.WHITE);
		lblBorla.setHorizontalAlignment(SwingConstants.LEFT);
		lblBorla.setFont(new Font("Arial", Font.BOLD, 20));
		
		String [] rows= {"ID","İsimler","2012","2013","2014","2015","2016"};
		Object [][] names= {{"1","Ayşe","50","25","25","20","8"},{"2","Mehmet","50","25","25","5","0"},
				{"3","Mahmut","30","0","0","0","20"},{"4","Seval","16","8","0","20","6"},{"5","Ayşe","50","25","25","20","8"},
				{"6","Mehmet","50","25","25","5","0"},{"7","Mahmut","30","0","0","0","20"},{"8","Seval","16","8","0","20","6"}};
		
		String [] years= Arrays.copyOfRange(rows, 2, rows.length);
		Object [][] money= {{"50","25","25","20","10"}};
		Object [][] debt= {{"50","25","25","20","10"}};
		for(int x=2;x<names[0].length;x++){
			int sum=0;
			int debt_count=0;
			for (int i=0;i<names.length;i++) {
				String[] stringAa = Arrays.copyOf(names[i],names[i].length, String[].class);
				String [] stringArray= Arrays.copyOfRange(stringAa, 2, stringAa.length);
				Integer[] intarray=new Integer[stringArray.length];
			    int count=0;
			    for(String str:stringArray){
			        intarray[count]=Integer.parseInt(str);
			        count++;
			    }
				if(intarray[x-2]!=0) {
					debt_count+=1;
				}
			    sum=sum+intarray[x-2];
			}
			money[0][x-2]=sum;
			debt[0][x-2]=debt_count;
		}
		JButton aidatlar_b = new JButton("Aidatlar");
		aidatlar_b.setFont(new Font("Tahoma", Font.PLAIN, 15));
		aidatlar_b.setForeground(Color.WHITE);
		aidatlar_b.setBackground(maroon);
		aidatlar_b.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				frmAidatlar.setVisible(false);
				
				try {
			            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
			                if ("Windows".equals(info.getName())) {
			                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
			                    break;
			                }
			            }
			        } catch (ClassNotFoundException ex) {
			            java.util.logging.Logger.getLogger(aidatlar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
			        } catch (InstantiationException ex) {
			            java.util.logging.Logger.getLogger(aidatlar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
			        } catch (IllegalAccessException ex) {
			            java.util.logging.Logger.getLogger(aidatlar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
			        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
			            java.util.logging.Logger.getLogger(aidatlar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
			        }
			        //</editor-fold>
			        //</editor-fold>

			        /* Create and display the form */
			        java.awt.EventQueue.invokeLater(new Runnable() {
			            public void run() {
			                new aidatlar().setVisible(true);
			            }
			        });
			}
		});
		
		JButton geri_b = new JButton("Geri");
		geri_b.setFont(new Font("Tahoma", Font.PLAIN, 15));
		geri_b.setForeground(Color.WHITE);
		geri_b.setBackground(maroon);
		geri_b.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frmAidatlar.setVisible(false);
				main m = new main();
				m.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				m.setVisible(true);
				centreWindow(m);
			}
		});
		
		JScrollPane top = new JScrollPane();
	
		JScrollPane left = new JScrollPane();
		
		JScrollPane bottom = new JScrollPane();
		
		JLabel lblBorToplam = new JLabel("Borc toplam");
		lblBorToplam.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblBorToplam.setForeground(Color.WHITE);
		
		JLabel lblBorluKiiSays = new JLabel("Borclu kisi sayisi");
		lblBorluKiiSays.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblBorluKiiSays.setForeground(Color.WHITE);
		
		JLabel lblSearch = new JLabel("Arama");
		lblSearch.setForeground(Color.WHITE);
		lblSearch.setFont(new Font("Arial", Font.BOLD, 15));
		
		textField = new JTextField();
		textField.setColumns(10);
		GroupLayout groupLayout = new GroupLayout(frmAidatlar.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(21)
					.addComponent(lblBorla, GroupLayout.PREFERRED_SIZE, 411, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 499, Short.MAX_VALUE)
					.addComponent(lblSearch)
					.addGap(18)
					.addComponent(textField, GroupLayout.PREFERRED_SIZE, 177, GroupLayout.PREFERRED_SIZE)
					.addGap(24))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(247)
					.addComponent(aidatlar_b, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 544, Short.MAX_VALUE)
					.addComponent(geri_b, GroupLayout.PREFERRED_SIZE, 73, GroupLayout.PREFERRED_SIZE)
					.addGap(246))
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(top, GroupLayout.DEFAULT_SIZE, 1180, Short.MAX_VALUE)
					.addContainerGap())
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblBorToplam, GroupLayout.PREFERRED_SIZE, 111, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(1079, Short.MAX_VALUE))
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(left, GroupLayout.DEFAULT_SIZE, 1180, Short.MAX_VALUE)
					.addContainerGap())
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblBorluKiiSays)
					.addContainerGap(1086, Short.MAX_VALUE))
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(bottom, GroupLayout.DEFAULT_SIZE, 1180, Short.MAX_VALUE)
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
							.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(lblSearch))
						.addComponent(lblBorla, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(top, GroupLayout.PREFERRED_SIZE, 306, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(lblBorToplam)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(left, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(lblBorluKiiSays)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(bottom, GroupLayout.PREFERRED_SIZE, 53, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
						.addComponent(geri_b, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(aidatlar_b, GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE))
					.addGap(20))
		);
		
		kisi_t = new JTable(debt,years);
		kisi_t.setEnabled(false);
		bottom.setViewportView(kisi_t);
		
		toplam_t = new JTable(money,years);
		toplam_t.setEnabled(false);
		left.setViewportView(toplam_t);
		
		main_t = new JTable(names,rows);
		main_t.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frmAidatlar.setVisible(false);
        		personal p = new personal();
        		//p.setExtendedState(JFrame.MAXIMIZED_BOTH); 
        		p.setSize(700, 600);
        		p.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        	    p.setVisible(true);
        	    centreWindow(p);
        		
			}
		});
		main_t.setEnabled(false);
		top.setViewportView(main_t);
		frmAidatlar.getContentPane().setLayout(groupLayout);
		frmAidatlar.getContentPane().setBackground(Color.GRAY);		
	}
	public static void centreWindow(JFrame frame) {
	    Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
	    int x = (int) ((dimension.getWidth() - frame.getWidth()) / 2);
	    int y = (int) ((dimension.getHeight() - frame.getHeight()) / 2);
	    frame.setLocation(x, y);
	}
}

