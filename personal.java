import java.awt.event.*;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;	
import javax.swing.border.LineBorder;
import javax.swing.filechooser.FileSystemView;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.RoundRectangle2D;


/*personal p = new personal();
		//p.setExtendedState(JFrame.MAXIMIZED_BOTH); 
		p.setSize(700, 600);
		p.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    p.setVisible(true);	*/
public class personal extends JFrame{	
	JLayeredPane layeredPane;
	
	public personal(ArrayList<person> list,person person,boolean changed) {
		JPanel panel = new JPanel();
		panel.setBackground(new java.awt.Color(211, 211, 211));
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
				
		JLabel image_lbl = new JLabel("");
		image_lbl.setBounds(0, 0, 170, 561);
		image_lbl.setIcon(new javax.swing.ImageIcon(getClass().getResource("image.jpeg")));
		panel.add(image_lbl);
		
		JLabel uyeBilgileri_lbl = new JLabel("\u00DCye Bilgileri");
		uyeBilgileri_lbl.setBounds(350, 15, 120, 30);
		uyeBilgileri_lbl.setForeground(new java.awt.Color(139, 0, 0));
		uyeBilgileri_lbl.setFont(new Font("Calibri", Font.BOLD, 24));
		
		panel.add(uyeBilgileri_lbl);
		
		JPanel panel_in = new JPanel();
		panel_in.setBorder(new LineBorder(java.awt.Color.DARK_GRAY, 1, true));
		panel_in.setBackground(Color.WHITE);
		panel_in.setBounds(190, 60, 480, 389);
		panel.add(panel_in);
		panel_in.setLayout(null);
		
		JLabel uyeNo_lbl = new JLabel("\u00DCye No:");
		uyeNo_lbl.setForeground(new java.awt.Color(128, 0, 0));
		uyeNo_lbl.setBounds(10, 7, 56, 17);
		uyeNo_lbl.setFont(new Font("Calibri", Font.BOLD, 16));
		panel_in.add(uyeNo_lbl);
		
		JLabel uyeNoDB_lbl = new JLabel(Integer.toString(person.getUyeNo_lbl())); 
		uyeNoDB_lbl.setBounds(125, 7, 48, 17);
		uyeNoDB_lbl.setFont(new Font("Calibri", Font.PLAIN, 16));
		panel_in.add(uyeNoDB_lbl);
		
		JLabel kimlikNo_lbl = new JLabel("T.C. Kimlik No:");
		kimlikNo_lbl.setBounds(264, 7, 112, 17);
		kimlikNo_lbl.setFont(new Font("Calibri", Font.PLAIN, 16));
		panel_in.add(kimlikNo_lbl);
		
		JLabel kimlikNoDB_lbl = new JLabel(Long.toString(person.getKimlikNo_lbl())); 
		kimlikNoDB_lbl.setBounds(361, 7, 109, 17);
		kimlikNoDB_lbl.setFont(new Font("Calibri", Font.PLAIN, 16));
		panel_in.add(kimlikNoDB_lbl);
		
		JLabel ad_lbl = new JLabel("Ad - Soyad:");
		ad_lbl.setForeground(new java.awt.Color(128, 0, 0));
		ad_lbl.setBounds(10, 37, 99, 17);
		ad_lbl.setFont(new Font("Calibri", Font.BOLD, 16));
		panel_in.add(ad_lbl);
		
		JLabel adDB_lbl = new JLabel(person.getAd_lbl() + " " + person.getSoy_lbl());
		adDB_lbl.setBounds(125, 37, 345, 17);
		adDB_lbl.setFont(new Font("Calibri", Font.PLAIN, 16));
		panel_in.add(adDB_lbl);
		
		JLabel cinsiyet_lbl = new JLabel("Cinsiyet:");
		cinsiyet_lbl.setForeground(new java.awt.Color(128, 0, 0));
		cinsiyet_lbl.setBounds(10, 67, 65, 17);
		cinsiyet_lbl.setFont(new Font("Calibri", Font.BOLD, 16));
		panel_in.add(cinsiyet_lbl);
		
		JLabel cinsiyetDB_lbl = new JLabel(person.getCinsiyet_lbl()); 
		cinsiyetDB_lbl.setBounds(125, 67, 86, 17);
		cinsiyetDB_lbl.setFont(new Font("Calibri", Font.PLAIN, 16));
		panel_in.add(cinsiyetDB_lbl);
		
		JLabel bolum_lbl = new JLabel("B\u00F6l\u00FCm\u00FC:");
		bolum_lbl.setForeground(new java.awt.Color(128, 0, 0));
		bolum_lbl.setBounds(10, 97, 89, 17);
		bolum_lbl.setFont(new Font("Calibri", Font.BOLD, 16));
		panel_in.add(bolum_lbl);
		
		JLabel bolumDB_lbl = new JLabel(person.getBolum_lbl());
		bolumDB_lbl.setBounds(125, 97, 345, 17);
		bolumDB_lbl.setFont(new Font("Calibri", Font.PLAIN, 16));
		panel_in.add(bolumDB_lbl);
		
		JLabel calismayer_lbl = new JLabel("\u00C7al\u015Ft\u0131\u011F\u0131 Yer:");
		calismayer_lbl.setForeground(new java.awt.Color(128, 0, 0));
		calismayer_lbl.setBounds(10, 127, 99, 17);
		calismayer_lbl.setFont(new Font("Calibri", Font.BOLD, 16));
		panel_in.add(calismayer_lbl);
		
		JLabel calısmayerDB_lbl = new JLabel(person.getCalismayer_lbl());
		calısmayerDB_lbl.setBounds(125, 127, 345, 17);
		calısmayerDB_lbl.setFont(new Font("Calibri", Font.PLAIN, 16));
		panel_in.add(calısmayerDB_lbl);
		
		JLabel mail_lbl = new JLabel("Mail:");
		mail_lbl.setForeground(new java.awt.Color(128, 0, 0));
		mail_lbl.setBounds(10, 157, 56, 17);
		mail_lbl.setFont(new Font("Calibri", Font.BOLD, 16));
		panel_in.add(mail_lbl);
		
		JLabel mailDB_lbl = new JLabel(person.getMail_lbl()); 
		mailDB_lbl.setBounds(125, 157, 345, 17);
		mailDB_lbl.setFont(new Font("Calibri", Font.PLAIN, 16));
		panel_in.add(mailDB_lbl);
		
		JLabel tel_lbl = new JLabel("Telefon:");
		tel_lbl.setForeground(new java.awt.Color(128, 0, 0));
		tel_lbl.setBounds(10, 187, 66, 17);
		tel_lbl.setFont(new Font("Calibri", Font.BOLD, 16));
		panel_in.add(tel_lbl);
		
		JLabel telDB_lbl = new JLabel(Long.toString(person.getTel_lbl())); 
		telDB_lbl.setBounds(125, 187, 251, 17);
		telDB_lbl.setFont(new Font("Calibri", Font.PLAIN, 16));
		panel_in.add(telDB_lbl);
		
		JLabel adres_lbl = new JLabel("Adres:");
		adres_lbl.setForeground(new java.awt.Color(128, 0, 0));
		adres_lbl.setBounds(10, 217, 56, 17);
		adres_lbl.setFont(new Font("Calibri", Font.BOLD, 16));
		panel_in.add(adres_lbl);
		
		JTextPane adres_txtp = new JTextPane();
		adres_txtp.setEditable(false);
		adres_txtp.setFont(new Font("Calibri", Font.PLAIN, 16));
		adres_txtp.setBackground(new java.awt.Color(211, 211, 211));
		adres_txtp.setBounds(120, 210, 350, 53);
		panel_in.add(adres_txtp);
		adres_txtp.setText(person.getAdres_lbl());
			
		JLabel il_lbl = new JLabel("\u0130l:");
		il_lbl.setForeground(new java.awt.Color(128, 0, 0));
		il_lbl.setBounds(10, 267, 45, 17);
		il_lbl.setFont(new Font("Calibri", Font.BOLD, 16));
		panel_in.add(il_lbl);
		
		JLabel ilDB_lbl = new JLabel(person.getIl_lbl()); 
		ilDB_lbl.setBounds(125, 267, 167, 17);
		ilDB_lbl.setFont(new Font("Calibri", Font.PLAIN, 16));
		panel_in.add(ilDB_lbl);
		
		JLabel mezTarihi_lbl = new JLabel("Mezuniyet Tarihi:");
		mezTarihi_lbl.setForeground(new java.awt.Color(128, 0, 0));
		mezTarihi_lbl.setBounds(10, 297, 120, 17);
		mezTarihi_lbl.setFont(new Font("Calibri", Font.BOLD, 16));
		panel_in.add(mezTarihi_lbl);
		
		JLabel mezTarihiDB_lbl = new JLabel(person.getMezTarihi_lbl()); 
		mezTarihiDB_lbl.setBounds(135, 297, 167, 17);
		mezTarihiDB_lbl.setFont(new Font("Calibri", Font.PLAIN, 16));
		panel_in.add(mezTarihiDB_lbl);
		
		JLabel girisTarihi_lbl = new JLabel("\u00DCye Giri\u015F Tarihi:");
		girisTarihi_lbl.setForeground(new java.awt.Color(128, 0, 0));
		girisTarihi_lbl.setBounds(10, 327, 112, 17);
		girisTarihi_lbl.setFont(new Font("Calibri", Font.BOLD, 16));
		panel_in.add(girisTarihi_lbl);
		
		JLabel girisTarihiDB_lbl = new JLabel(person.getGirisTarihi_lbl()); 
		girisTarihiDB_lbl.setBounds(125, 327, 140, 17);
		girisTarihiDB_lbl.setFont(new Font("Calibri", Font.PLAIN, 16));
		panel_in.add(girisTarihiDB_lbl);
		
		JLabel uyeDurumu_lbl = new JLabel("\u00DCyelik Durumu:");
		uyeDurumu_lbl.setForeground(new java.awt.Color(128, 0, 0));
		uyeDurumu_lbl.setBounds(10, 357, 123, 17);
		uyeDurumu_lbl.setFont(new Font("Calibri", Font.BOLD, 16));
		panel_in.add(uyeDurumu_lbl);
		
		JLabel uyeDurumuDB_lbl = new JLabel(person.getUyeDurumu_lbl()); 
		uyeDurumuDB_lbl.setBounds(125, 357, 140, 17);
		uyeDurumuDB_lbl.setFont(new Font("Calibri", Font.PLAIN, 16));
		panel_in.add(uyeDurumuDB_lbl);
		
		JButton update_btn = new JButton("\u00DCye Bilgilerini G\u00FCncelle");
		update_btn.setForeground(new java.awt.Color(128, 0, 0));
		update_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {	
				dispose();
				update_uye y = new update_uye(person);
				y.txtTc.setText(kimlikNoDB_lbl.getText());
				y.uye_no.setText(uyeNoDB_lbl.getText());
				String[] ad_array = adDB_lbl.getText().split(" ");
				String ad=ad_array[0];
				if(ad_array.length>2) {
					ad=ad_array[0]+" "+ad_array[1]; 
				}
				y.yeni_ad.setText(ad);
				y.yeni_soyad.setText(ad_array[ad_array.length-1]);
				y.yeni_cinsiyet.setText(cinsiyetDB_lbl.getText());
				y.yeni_bolum.setText(bolumDB_lbl.getText());
				y.yeni_calısma.setText(calısmayerDB_lbl.getText());
				y.yeni_mail.setText(mailDB_lbl.getText());
				y.yeni_tel.setText(telDB_lbl.getText());
				y.yeni_adres.setText(adres_txtp.getText());
				y.yeni_il.setText(ilDB_lbl.getText());
				y.yeni_mezun_day.setText(mezTarihiDB_lbl.getText().split("-")[0]);
				y.yeni_mezun_month.setText(mezTarihiDB_lbl.getText().split("-")[1]);
				y.yeni_mezun_year.setText(mezTarihiDB_lbl.getText().split("-")[2]);
				
				y.yeni_uye_day.setText(girisTarihiDB_lbl.getText().split("-")[0]);
				y.yeni_uye_month.setText(girisTarihiDB_lbl.getText().split("-")[1]);
				y.yeni_uye_year.setText(girisTarihiDB_lbl.getText().split("-")[2]);
				y.yeni_durum.setText(uyeDurumuDB_lbl.getText());
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
		update_btn.setFont(new Font("Calibri", Font.BOLD, 14));
		update_btn.setBackground(new java.awt.Color(211, 211, 211));
		update_btn.setBounds(290, 353, 180, 25);
		panel_in.add(update_btn);
		
		JButton uye_file = new JButton("Üyelik Formu");
		uye_file.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if (Desktop.isDesktopSupported()) {
				    try {
				    	String documentpath=FileSystemView.getFileSystemView().getDefaultDirectory().getPath()+
				    			"\\Donation Tracking"+"\\Belgeler\\";
				        File myFile = new File(documentpath+kimlikNoDB_lbl.getText()+".pdf");
				        Desktop.getDesktop().open(myFile);
				    } catch (IOException ex) {
				        // no application registered for PDFs
				    }
				}

			}
		});
		uye_file.setForeground(new Color(128, 0, 0));
		uye_file.setFont(new Font("Calibri", Font.BOLD, 14));
		uye_file.setBackground(new Color(211, 211, 211));
		uye_file.setBounds(290, 324, 180, 25);
		panel_in.add(uye_file);
		
		JTextPane borc_txtp = new JTextPane();
		borc_txtp.setEditable(false);
		borc_txtp.setBounds(313, 461, 334, 64);
		panel.add(borc_txtp);
		borc_txtp.setBackground(new java.awt.Color(211, 211, 211));
		borc_txtp.setFont(new Font("Calibri", Font.PLAIN, 16));
		
		int [] year = new int[50];
		int [] borc = new int[50];
		int count=0;
		int toplam = 0;
		String show = null;
	
		for(int i=0; i<person.getBorcarray().length; i++) {
			if(person.getBorcarray()[i] > 0 && ! Integer.toString(person.getBorcarray()[i]).equals("")) {
				borc[count] = person.getBorcarray()[i];
				year[count] = 2010+i;
				count++;
			}
		}
		show = "Borçlu Olduğu Yıl: Borç Miktarı\n";
		for(int i=0; i<count; i++) {
			show =  show + year[i] + ": " + borc[i] + " TL , ";
			toplam = toplam+ borc[i];
		}
		borc_txtp.setText(show);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new java.awt.Color(128, 0, 0), 1, true));
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(190, 454, 480, 103);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JTextPane borcDurumu_txtp = new JTextPane();
		borcDurumu_txtp.setFont(new Font("Calibri", Font.BOLD | Font.ITALIC, 18));
		borcDurumu_txtp.setForeground(new java.awt.Color(139, 0, 0));
		borcDurumu_txtp.setBackground(new java.awt.Color(211, 211, 211));
		borcDurumu_txtp.setEditable(false);
		borcDurumu_txtp.setText("Bor\u00E7 Durumu:");
		borcDurumu_txtp.setBounds(10, 17, 71, 56);
		panel_1.add(borcDurumu_txtp);
		
		JTextPane toplamBorc_txtp = new JTextPane();
		toplamBorc_txtp.setFont(new Font("Calibri", Font.PLAIN, 17));
		toplamBorc_txtp.setEditable(false);
		toplamBorc_txtp.setBackground(new java.awt.Color(211, 211, 211));
		toplamBorc_txtp.setText("Toplam Bor\u00E7: "+ toplam + " TL");
		toplamBorc_txtp.setBounds(123, 70, 331, 26);
		panel_1.add(toplamBorc_txtp);
		
		JButton geri_btn = new JButton("Geri");
		geri_btn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
				setVisible(false);
				if(changed){
					Database_methods dbmethods3 = new Database_methods();
					ArrayList<person> pArr = dbmethods3.GetPerson();
					main m=new main(pArr);	
					m.setVisible(false);
					m.dispose();
					m.setUndecorated(true);
					m.setShape(new RoundRectangle2D.Double(0, 0, m.getWidth(), m.getHeight(), 20, 20));
					m.setVisible(true);
					centreWindow(m);
				}else {
					main m=new main(list);	
					m.setVisible(false);
					m.dispose();
					m.setUndecorated(true);
					m.setShape(new RoundRectangle2D.Double(0, 0, m.getWidth(), m.getHeight(), 20, 20));
					m.setVisible(true);
					centreWindow(m);
				}
			}
		});
		geri_btn.setBounds(612, 11, 62, 23);
		panel.add(geri_btn);	
	}
	public static void centreWindow(JFrame frame) {
	    Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
	    int x = (int) ((dimension.getWidth() - frame.getWidth()) / 2);
	    int y = (int) ((dimension.getHeight() - frame.getHeight()) / 2);
	    frame.setLocation(x, y);
	}
}
