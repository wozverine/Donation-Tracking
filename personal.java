import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;

import javafx.scene.paint.Color;

import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.Font;
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

/*Main method
personal p = new personal();
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
		
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(0, 0, 170, 561);
		lblNewLabel.setIcon(new ImageIcon("image.jpeg"));
		panel.add(lblNewLabel);
		
		JLabel lbluyeBilgileri = new JLabel("\u00DCye Bilgileri");
		lbluyeBilgileri.setBounds(350, 15, 120, 30);
		lbluyeBilgileri.setForeground(new java.awt.Color(139, 0, 0));
		lbluyeBilgileri.setFont(new Font("Calibri", Font.BOLD, 24));
		
		panel.add(lbluyeBilgileri);
		
		JPanel panel_in = new JPanel();
		panel_in.setBorder(new LineBorder(java.awt.Color.DARK_GRAY, 1, true));
		panel_in.setBackground(new java.awt.Color(211, 211, 211));
		panel_in.setBounds(190, 60, 480, 389);
		panel.add(panel_in);
		panel_in.setLayout(null);
		
		JLabel lblyeNo = new JLabel("\u00DCye No:");
		lblyeNo.setForeground(new java.awt.Color(128, 0, 0));
		lblyeNo.setBounds(10, 7, 56, 17);
		lblyeNo.setFont(new Font("Calibri", Font.BOLD, 16));
		panel_in.add(lblyeNo);
		
		JLabel uye_no = new JLabel("01");  //Üye no database'den çekilecek
		uye_no.setBounds(125, 7, 48, 17);
		uye_no.setFont(new Font("Calibri", Font.PLAIN, 16));
		panel_in.add(uye_no);
		
		JLabel lblTcKimlikNo = new JLabel("T.C. Kimlik No:");
		lblTcKimlikNo.setBounds(264, 7, 112, 17);
		lblTcKimlikNo.setFont(new Font("Calibri", Font.PLAIN, 16));
		panel_in.add(lblTcKimlikNo);
		
		JLabel tc_no = new JLabel("11111111111");  //Tc no database'den çekilecek
		tc_no.setBounds(361, 7, 109, 17);
		tc_no.setFont(new Font("Calibri", Font.PLAIN, 16));
		panel_in.add(tc_no);
		
		JLabel lblNewLabel_1 = new JLabel("Ad - Soyad:");
		lblNewLabel_1.setForeground(new java.awt.Color(128, 0, 0));
		lblNewLabel_1.setBounds(10, 37, 99, 17);
		lblNewLabel_1.setFont(new Font("Calibri", Font.BOLD, 16));
		panel_in.add(lblNewLabel_1);
		
		JLabel ad_soyad = new JLabel("A B"); //ad soyad database'den çekilecek
		ad_soyad.setBounds(125, 37, 345, 17);
		ad_soyad.setFont(new Font("Calibri", Font.PLAIN, 16));
		panel_in.add(ad_soyad);
		
		JLabel lblCinsiyet = new JLabel("Cinsiyet:");
		lblCinsiyet.setForeground(new java.awt.Color(128, 0, 0));
		lblCinsiyet.setBounds(10, 67, 65, 17);
		lblCinsiyet.setFont(new Font("Calibri", Font.BOLD, 16));
		panel_in.add(lblCinsiyet);
		
		JLabel cinsiyet = new JLabel("Bayan"); //cinsiyet database'den çekilecek
		cinsiyet.setBounds(125, 67, 86, 17);
		cinsiyet.setFont(new Font("Calibri", Font.PLAIN, 16));
		panel_in.add(cinsiyet);
		
		JLabel lblBlm = new JLabel("B\u00F6l\u00FCm\u00FC:");
		lblBlm.setForeground(new java.awt.Color(128, 0, 0));
		lblBlm.setBounds(10, 97, 89, 17);
		lblBlm.setFont(new Font("Calibri", Font.BOLD, 16));
		panel_in.add(lblBlm);
		
		JLabel bolum = new JLabel("\u0130\u015Fletme"); //bölümü database'den çekilecek
		bolum.setBounds(125, 97, 345, 17);
		bolum.setFont(new Font("Calibri", Font.PLAIN, 16));
		panel_in.add(bolum);
		
		JLabel lblaltYer = new JLabel("\u00C7al\u015Ft\u0131\u011F\u0131 Yer:");
		lblaltYer.setForeground(new java.awt.Color(128, 0, 0));
		lblaltYer.setBounds(10, 127, 99, 17);
		lblaltYer.setFont(new Font("Calibri", Font.BOLD, 16));
		panel_in.add(lblaltYer);
		
		JLabel calýsma_yer = new JLabel("XYZ"); //çalýþtýðý yer database'den çekilecek
		calýsma_yer.setBounds(125, 127, 345, 17);
		calýsma_yer.setFont(new Font("Calibri", Font.PLAIN, 16));
		panel_in.add(calýsma_yer);
		
		JLabel lblMail = new JLabel("Mail:");
		lblMail.setForeground(new java.awt.Color(128, 0, 0));
		lblMail.setBounds(10, 157, 56, 17);
		lblMail.setFont(new Font("Calibri", Font.BOLD, 16));
		panel_in.add(lblMail);
		
		JLabel mail_adr = new JLabel("ab@gmail.com"); //mail adresi database'den çekilecek
		mail_adr.setBounds(125, 157, 345, 17);
		mail_adr.setFont(new Font("Calibri", Font.PLAIN, 16));
		panel_in.add(mail_adr);
		
		JLabel lblTelefon = new JLabel("Telefon:");
		lblTelefon.setForeground(new java.awt.Color(128, 0, 0));
		lblTelefon.setBounds(10, 187, 66, 17);
		lblTelefon.setFont(new Font("Calibri", Font.BOLD, 16));
		panel_in.add(lblTelefon);
		
		JLabel tel_no = new JLabel("05555555555"); //Tel no database'den çekilecek
		tel_no.setBounds(125, 187, 251, 17);
		tel_no.setFont(new Font("Calibri", Font.PLAIN, 16));
		panel_in.add(tel_no);
		
		JLabel lblAdres = new JLabel("Adres:");
		lblAdres.setForeground(new java.awt.Color(128, 0, 0));
		lblAdres.setBounds(10, 217, 56, 17);
		lblAdres.setFont(new Font("Calibri", Font.BOLD, 16));
		panel_in.add(lblAdres);
		
		JTextPane adres = new JTextPane();
		adres.setFont(new Font("Calibri", Font.PLAIN, 16));
		adres.setBackground(new java.awt.Color(211, 211, 211));
		adres.setBounds(120, 210, 350, 59);
		panel_in.add(adres);
		adres.setText("S\u00F6\u011F\u00FCt\u00F6z\u00FC, S\u00F6\u011F\u00FCt\u00F6z\u00FC Cd. No:43, 06510 \u00C7ankaya/Ankara");
	
		
		JLabel lblIl = new JLabel("\u0130l:");
		lblIl.setForeground(new java.awt.Color(128, 0, 0));
		lblIl.setBounds(10, 267, 45, 17);
		lblIl.setFont(new Font("Calibri", Font.BOLD, 16));
		panel_in.add(lblIl);
		
		JLabel il = new JLabel("Ankara"); //il database'den çekilecek
		il.setBounds(125, 267, 167, 17);
		il.setFont(new Font("Calibri", Font.PLAIN, 16));
		panel_in.add(il);
		
		JLabel lblMezuniyetTarihi = new JLabel("Mezuniyet Tarihi:");
		lblMezuniyetTarihi.setForeground(new java.awt.Color(128, 0, 0));
		lblMezuniyetTarihi.setBounds(10, 297, 120, 17);
		lblMezuniyetTarihi.setFont(new Font("Calibri", Font.BOLD, 16));
		panel_in.add(lblMezuniyetTarihi);
		
		JLabel mez_tarih = new JLabel("01.01.2018"); //mezuniyet tarihi database'den çekilecek
		mez_tarih.setBounds(135, 297, 167, 17);
		mez_tarih.setFont(new Font("Calibri", Font.PLAIN, 16));
		panel_in.add(mez_tarih);
		
		JLabel lblyeGiriTarihi = new JLabel("\u00DCye Giri\u015F Tarihi:");
		lblyeGiriTarihi.setForeground(new java.awt.Color(128, 0, 0));
		lblyeGiriTarihi.setBounds(10, 327, 112, 17);
		lblyeGiriTarihi.setFont(new Font("Calibri", Font.BOLD, 16));
		panel_in.add(lblyeGiriTarihi);
		
		JLabel uye_tarih = new JLabel("01.01.2018"); //Üye giriþ tarihi database'den çekilecek
		uye_tarih.setBounds(125, 327, 140, 17);
		uye_tarih.setFont(new Font("Calibri", Font.PLAIN, 16));
		panel_in.add(uye_tarih);
		
		JLabel lblyelikDurumu = new JLabel("\u00DCyelik Durumu:");
		lblyelikDurumu.setForeground(new java.awt.Color(128, 0, 0));
		lblyelikDurumu.setBounds(10, 357, 123, 17);
		lblyelikDurumu.setFont(new Font("Calibri", Font.BOLD, 16));
		panel_in.add(lblyelikDurumu);
		
		JLabel uye_durum = new JLabel("Aktif \u00DCye"); //üyelik durumu database'den çekilecek
		uye_durum.setBounds(125, 357, 140, 17);
		uye_durum.setFont(new Font("Calibri", Font.PLAIN, 16));
		panel_in.add(uye_durum);
		
		JButton update = new JButton("\u00DCye Bilgilerini G\u00FCncelle");
		update.setForeground(new java.awt.Color(128, 0, 0));
		update.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		update.setFont(new Font("Calibri", Font.BOLD, 14));
		update.setBackground(new java.awt.Color(211, 211, 211));
		update.setBounds(290, 353, 180, 25);
		panel_in.add(update);
		
		JTextPane borc = new JTextPane();
		borc.setBounds(313, 461, 334, 46);
		panel.add(borc);
		borc.setBackground(new java.awt.Color(211, 211, 211));
		borc.setFont(new Font("Calibri", Font.PLAIN, 16));
		borc.setText("Bor\u00E7lu Oldu\u011Fu Y\u0131l: Bor\u00E7 Miktar\u0131\r\n2019: 60 TL , 2020: 100 TL");
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new java.awt.Color(128, 0, 0), 1, true));
		panel_1.setBackground(new java.awt.Color(211, 211, 211));
		panel_1.setBounds(190, 454, 480, 96);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JTextPane txtpnBorDurumu = new JTextPane();
		txtpnBorDurumu.setFont(new Font("Calibri", Font.BOLD | Font.ITALIC, 18));
		txtpnBorDurumu.setForeground(new java.awt.Color(139, 0, 0));
		txtpnBorDurumu.setBackground(new java.awt.Color(211, 211, 211));
		txtpnBorDurumu.setEditable(false);
		txtpnBorDurumu.setText("Bor\u00E7 Durumu:");
		txtpnBorDurumu.setBounds(10, 17, 71, 56);
		panel_1.add(txtpnBorDurumu);
		
		JTextPane toplam_borc = new JTextPane();
		toplam_borc.setFont(new Font("Calibri", Font.PLAIN, 17));
		toplam_borc.setEditable(false);
		toplam_borc.setBackground(new java.awt.Color(211, 211, 211));
		toplam_borc.setText("Toplam Bor\u00E7: 160 TL");
		toplam_borc.setBounds(125, 59, 331, 26);
		panel_1.add(toplam_borc);
		
		}
}

