import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;

import javafx.scene.paint.Color;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.BoxLayout;
import javax.swing.JSeparator;
import java.awt.FlowLayout;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.JButton;
import javax.swing.JTextPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


/*personal p = new personal();
		//p.setExtendedState(JFrame.MAXIMIZED_BOTH); 
		p.setSize(700, 600);
		p.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    p.setVisible(true);	*/
public class personal extends JFrame{
	
	JLayeredPane layeredPane;
	
	public personal() {
		
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
		panel_in.setBackground(new java.awt.Color(211, 211, 211));
		panel_in.setBounds(190, 60, 480, 389);
		panel.add(panel_in);
		panel_in.setLayout(null);
		
		JLabel uyeNo_lbl = new JLabel("\u00DCye No:");
		uyeNo_lbl.setForeground(new java.awt.Color(128, 0, 0));
		uyeNo_lbl.setBounds(10, 7, 56, 17);
		uyeNo_lbl.setFont(new Font("Calibri", Font.BOLD, 16));
		panel_in.add(uyeNo_lbl);
		
		JLabel uyeNoDB_lbl = new JLabel("01");  //Üye no database'den çekilecek
		uyeNoDB_lbl.setBounds(125, 7, 48, 17);
		uyeNoDB_lbl.setFont(new Font("Calibri", Font.PLAIN, 16));
		panel_in.add(uyeNoDB_lbl);
		
		JLabel kimlikNo_lbl = new JLabel("T.C. Kimlik No:");
		kimlikNo_lbl.setBounds(264, 7, 112, 17);
		kimlikNo_lbl.setFont(new Font("Calibri", Font.PLAIN, 16));
		panel_in.add(kimlikNo_lbl);
		
		JLabel kimlikNoDB_lbl = new JLabel("11111111111");  //Tc no database'den çekilecek
		kimlikNoDB_lbl.setBounds(361, 7, 109, 17);
		kimlikNoDB_lbl.setFont(new Font("Calibri", Font.PLAIN, 16));
		panel_in.add(kimlikNoDB_lbl);
		
		JLabel ad_lbl = new JLabel("Ad - Soyad:");
		ad_lbl.setForeground(new java.awt.Color(128, 0, 0));
		ad_lbl.setBounds(10, 37, 99, 17);
		ad_lbl.setFont(new Font("Calibri", Font.BOLD, 16));
		panel_in.add(ad_lbl);
		
		JLabel adDB_lbl = new JLabel("A B"); //ad soyad database'den çekilecek
		adDB_lbl.setBounds(125, 37, 345, 17);
		adDB_lbl.setFont(new Font("Calibri", Font.PLAIN, 16));
		panel_in.add(adDB_lbl);
		
		JLabel cinsiyet_lbl = new JLabel("Cinsiyet:");
		cinsiyet_lbl.setForeground(new java.awt.Color(128, 0, 0));
		cinsiyet_lbl.setBounds(10, 67, 65, 17);
		cinsiyet_lbl.setFont(new Font("Calibri", Font.BOLD, 16));
		panel_in.add(cinsiyet_lbl);
		
		JLabel cinsiyetDB_lbl = new JLabel("Bayan"); //cinsiyet database'den çekilecek
		cinsiyetDB_lbl.setBounds(125, 67, 86, 17);
		cinsiyetDB_lbl.setFont(new Font("Calibri", Font.PLAIN, 16));
		panel_in.add(cinsiyetDB_lbl);
		
		JLabel bolum_lbl = new JLabel("B\u00F6l\u00FCm\u00FC:");
		bolum_lbl.setForeground(new java.awt.Color(128, 0, 0));
		bolum_lbl.setBounds(10, 97, 89, 17);
		bolum_lbl.setFont(new Font("Calibri", Font.BOLD, 16));
		panel_in.add(bolum_lbl);
		
		JLabel bolumDB_lbl = new JLabel("\u0130\u015Fletme"); //bölümü database'den çekilecek
		bolumDB_lbl.setBounds(125, 97, 345, 17);
		bolumDB_lbl.setFont(new Font("Calibri", Font.PLAIN, 16));
		panel_in.add(bolumDB_lbl);
		
		JLabel calismayer_lbl = new JLabel("\u00C7al\u015Ft\u0131\u011F\u0131 Yer:");
		calismayer_lbl.setForeground(new java.awt.Color(128, 0, 0));
		calismayer_lbl.setBounds(10, 127, 99, 17);
		calismayer_lbl.setFont(new Font("Calibri", Font.BOLD, 16));
		panel_in.add(calismayer_lbl);
		
		JLabel calısmayerDB_lbl = new JLabel("XYZ"); //çalıştığı yer database'den çekilecek
		calısmayerDB_lbl.setBounds(125, 127, 345, 17);
		calısmayerDB_lbl.setFont(new Font("Calibri", Font.PLAIN, 16));
		panel_in.add(calısmayerDB_lbl);
		
		JLabel mail_lbl = new JLabel("Mail:");
		mail_lbl.setForeground(new java.awt.Color(128, 0, 0));
		mail_lbl.setBounds(10, 157, 56, 17);
		mail_lbl.setFont(new Font("Calibri", Font.BOLD, 16));
		panel_in.add(mail_lbl);
		
		JLabel mailDB_lbl = new JLabel("ab@gmail.com"); //mail adresi database'den çekilecek
		mailDB_lbl.setBounds(125, 157, 345, 17);
		mailDB_lbl.setFont(new Font("Calibri", Font.PLAIN, 16));
		panel_in.add(mailDB_lbl);
		
		JLabel tel_lbl = new JLabel("Telefon:");
		tel_lbl.setForeground(new java.awt.Color(128, 0, 0));
		tel_lbl.setBounds(10, 187, 66, 17);
		tel_lbl.setFont(new Font("Calibri", Font.BOLD, 16));
		panel_in.add(tel_lbl);
		
		JLabel telDB_lbl = new JLabel("05555555555"); //Tel no database'den çekilecek
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
		adres_txtp.setText("S\u00F6\u011F\u00FCt\u00F6z\u00FC, S\u00F6\u011F\u00FCt\u00F6z\u00FC Cd. No:43, 06510 \u00C7ankaya/Ankara");
	
		
		JLabel il_lbl = new JLabel("\u0130l:");
		il_lbl.setForeground(new java.awt.Color(128, 0, 0));
		il_lbl.setBounds(10, 267, 45, 17);
		il_lbl.setFont(new Font("Calibri", Font.BOLD, 16));
		panel_in.add(il_lbl);
		
		JLabel ilDB_lbl = new JLabel("Ankara"); //il database'den çekilecek
		ilDB_lbl.setBounds(125, 267, 167, 17);
		ilDB_lbl.setFont(new Font("Calibri", Font.PLAIN, 16));
		panel_in.add(ilDB_lbl);
		
		JLabel mezTarihi_lbl = new JLabel("Mezuniyet Tarihi:");
		mezTarihi_lbl.setForeground(new java.awt.Color(128, 0, 0));
		mezTarihi_lbl.setBounds(10, 297, 120, 17);
		mezTarihi_lbl.setFont(new Font("Calibri", Font.BOLD, 16));
		panel_in.add(mezTarihi_lbl);
		
		JLabel mezTarihiDB_lbl = new JLabel("01.01.2018"); //mezuniyet tarihi database'den çekilecek
		mezTarihiDB_lbl.setBounds(135, 297, 167, 17);
		mezTarihiDB_lbl.setFont(new Font("Calibri", Font.PLAIN, 16));
		panel_in.add(mezTarihiDB_lbl);
		
		JLabel girisTarihi_lbl = new JLabel("\u00DCye Giri\u015F Tarihi:");
		girisTarihi_lbl.setForeground(new java.awt.Color(128, 0, 0));
		girisTarihi_lbl.setBounds(10, 327, 112, 17);
		girisTarihi_lbl.setFont(new Font("Calibri", Font.BOLD, 16));
		panel_in.add(girisTarihi_lbl);
		
		JLabel girisTarihiDB_lbl = new JLabel("01.01.2018"); //Üye giriş tarihi database'den çekilecek
		girisTarihiDB_lbl.setBounds(125, 327, 140, 17);
		girisTarihiDB_lbl.setFont(new Font("Calibri", Font.PLAIN, 16));
		panel_in.add(girisTarihiDB_lbl);
		
		JLabel uyeDurumu_lbl = new JLabel("\u00DCyelik Durumu:");
		uyeDurumu_lbl.setForeground(new java.awt.Color(128, 0, 0));
		uyeDurumu_lbl.setBounds(10, 357, 123, 17);
		uyeDurumu_lbl.setFont(new Font("Calibri", Font.BOLD, 16));
		panel_in.add(uyeDurumu_lbl);
		
		JLabel uyeDurumuDB_lbl = new JLabel("Aktif \u00DCye"); //üyelik durumu database'den çekilecek
		uyeDurumuDB_lbl.setBounds(125, 357, 140, 17);
		uyeDurumuDB_lbl.setFont(new Font("Calibri", Font.PLAIN, 16));
		panel_in.add(uyeDurumuDB_lbl);
		
		JButton update_btn = new JButton("\u00DCye Bilgilerini G\u00FCncelle");
		update_btn.setForeground(new java.awt.Color(128, 0, 0));
		update_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		update_btn.setFont(new Font("Calibri", Font.BOLD, 14));
		update_btn.setBackground(new java.awt.Color(211, 211, 211));
		update_btn.setBounds(290, 353, 180, 25);
		panel_in.add(update_btn);
		
		JTextPane borc_txtp = new JTextPane();
		borc_txtp.setEditable(false);
		borc_txtp.setBounds(313, 461, 334, 46);
		panel.add(borc_txtp);
		borc_txtp.setBackground(new java.awt.Color(211, 211, 211));
		borc_txtp.setFont(new Font("Calibri", Font.PLAIN, 16));
		borc_txtp.setText("Bor\u00E7lu Oldu\u011Fu Y\u0131l: Bor\u00E7 Miktar\u0131\r\n2019: 60 TL , 2020: 100 TL");
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new java.awt.Color(128, 0, 0), 1, true));
		panel_1.setBackground(new java.awt.Color(211, 211, 211));
		panel_1.setBounds(190, 454, 480, 96);
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
		toplamBorc_txtp.setText("Toplam Bor\u00E7: 160 TL");
		toplamBorc_txtp.setBounds(125, 59, 331, 26);
		panel_1.add(toplamBorc_txtp);
		
		JButton geri_btn = new JButton("Geri");
		geri_btn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				setVisible(false);
				main m = new main();
				m.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				m.setVisible(true);
				centreWindow(m);
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

