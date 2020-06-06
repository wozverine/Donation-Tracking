import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;



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
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.awt.Color;


/*personal p = new personal();
		//p.setExtendedState(JFrame.MAXIMIZED_BOTH); 
		p.setSize(700, 600);
		p.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    p.setVisible(true);	*/
public class yeni_uye extends JFrame{
	JLayeredPane layeredPane;
	JTextField uye_no;
	JTextField yeni_ad;
	JTextField yeni_soyad;
	JTextField yeni_cinsiyet;
	JTextField yeni_bolum;
	JTextField yeni_calısma;
	JTextField yeni_mail;
	JTextField yeni_tel;
	JTextField yeni_adres;
	JTextField yeni_il;
	JTextField yeni_mezun_day;
	JTextField yeni_uye_day;
	JTextField yeni_durum;
	JTextField txtTc;
	int posX;
	int posY;
	Date date = new Date();
	LocalDate localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
	int year  = localDate.getYear();
	int month=localDate.getMonthValue();
	int day=localDate.getDayOfMonth();
	JTextField yeni_mezun_month;
	JTextField yeni_mezun_year;
	JTextField yeni_uye_month;
	JTextField yeni_uye_year;
	public yeni_uye(boolean is_new) {
		//move window
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
        //move window
		
		JPanel panel = new JPanel();
		panel.setBackground(new java.awt.Color(211, 211, 211));
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel uyeBilgileri_lbl = new JLabel("\u00DCye Bilgileri");
		uyeBilgileri_lbl.setBounds(214, 15, 120, 30);
		uyeBilgileri_lbl.setForeground(new java.awt.Color(139, 0, 0));
		uyeBilgileri_lbl.setFont(new Font("Calibri", Font.BOLD, 24));	
		panel.add(uyeBilgileri_lbl);
		
		JPanel panel_in = new JPanel();
		panel_in.setBorder(new LineBorder(java.awt.Color.DARK_GRAY, 1, true));
		panel_in.setBackground(new java.awt.Color(211, 211, 211));
		panel_in.setBounds(25, 56, 519, 486);
		panel.add(panel_in);
		panel_in.setLayout(null);
		
		JLabel uyeNo_lbl = new JLabel("\u00DCye No:");
		uyeNo_lbl.setForeground(new java.awt.Color(128, 0, 0));
		uyeNo_lbl.setBounds(10, 7, 56, 17);
		uyeNo_lbl.setFont(new Font("Calibri", Font.BOLD, 16));
		panel_in.add(uyeNo_lbl);
		
		JLabel kimlikNo_lbl = new JLabel("T.C. Kimlik No:");
		kimlikNo_lbl.setForeground(new Color(128, 0, 0));
		kimlikNo_lbl.setBounds(249, 7, 112, 17);
		kimlikNo_lbl.setFont(new Font("Calibri", Font.BOLD, 16));
		panel_in.add(kimlikNo_lbl);
		
		JLabel ad_lbl = new JLabel("Adı:");
		ad_lbl.setForeground(new java.awt.Color(128, 0, 0));
		ad_lbl.setBounds(10, 37, 99, 17);
		ad_lbl.setFont(new Font("Calibri", Font.BOLD, 16));
		panel_in.add(ad_lbl);
		
		JLabel cinsiyet_lbl = new JLabel("Cinsiyet:");
		cinsiyet_lbl.setForeground(new java.awt.Color(128, 0, 0));
		cinsiyet_lbl.setBounds(10, 95, 65, 17);
		cinsiyet_lbl.setFont(new Font("Calibri", Font.BOLD, 16));
		panel_in.add(cinsiyet_lbl);
		
		JLabel bolum_lbl = new JLabel("B\u00F6l\u00FCm\u00FC:");
		bolum_lbl.setForeground(new java.awt.Color(128, 0, 0));
		bolum_lbl.setBounds(10, 125, 89, 17);
		bolum_lbl.setFont(new Font("Calibri", Font.BOLD, 16));
		panel_in.add(bolum_lbl);
		
		JLabel calismayer_lbl = new JLabel("\u00C7al\u015Ft\u0131\u011F\u0131 Yer:");
		calismayer_lbl.setForeground(new java.awt.Color(128, 0, 0));
		calismayer_lbl.setBounds(10, 155, 99, 17);
		calismayer_lbl.setFont(new Font("Calibri", Font.BOLD, 16));
		panel_in.add(calismayer_lbl);
		
		JLabel mail_lbl = new JLabel("Mail:");
		mail_lbl.setForeground(new java.awt.Color(128, 0, 0));
		mail_lbl.setBounds(10, 185, 56, 17);
		mail_lbl.setFont(new Font("Calibri", Font.BOLD, 16));
		panel_in.add(mail_lbl);
		
		JLabel tel_lbl = new JLabel("Telefon:");
		tel_lbl.setForeground(new java.awt.Color(128, 0, 0));
		tel_lbl.setBounds(10, 215, 66, 17);
		tel_lbl.setFont(new Font("Calibri", Font.BOLD, 16));
		panel_in.add(tel_lbl);
		
		JLabel adres_lbl = new JLabel("Adres:");
		adres_lbl.setForeground(new java.awt.Color(128, 0, 0));
		adres_lbl.setBounds(10, 245, 56, 17);
		adres_lbl.setFont(new Font("Calibri", Font.BOLD, 16));
		panel_in.add(adres_lbl);
			
		JLabel il_lbl = new JLabel("\u0130l:");
		il_lbl.setForeground(new java.awt.Color(128, 0, 0));
		il_lbl.setBounds(10, 295, 45, 17);
		il_lbl.setFont(new Font("Calibri", Font.BOLD, 16));
		panel_in.add(il_lbl);
		
		JLabel mezTarihi_lbl = new JLabel("Mezuniyet Tarihi:");
		mezTarihi_lbl.setForeground(new java.awt.Color(128, 0, 0));
		mezTarihi_lbl.setBounds(10, 341, 120, 17);
		mezTarihi_lbl.setFont(new Font("Calibri", Font.BOLD, 16));
		panel_in.add(mezTarihi_lbl);
		
		JLabel girisTarihi_lbl = new JLabel("\u00DCye Giri\u015F Tarihi:");
		girisTarihi_lbl.setForeground(new java.awt.Color(128, 0, 0));
		girisTarihi_lbl.setBounds(10, 371, 112, 17);
		girisTarihi_lbl.setFont(new Font("Calibri", Font.BOLD, 16));
		panel_in.add(girisTarihi_lbl);
		
		JLabel uyeDurumu_lbl = new JLabel("\u00DCyelik Durumu:");
		uyeDurumu_lbl.setForeground(new java.awt.Color(128, 0, 0));
		uyeDurumu_lbl.setBounds(10, 401, 123, 17);
		uyeDurumu_lbl.setFont(new Font("Calibri", Font.BOLD, 16));
		panel_in.add(uyeDurumu_lbl);
		
		JButton new_btn = new JButton("Yeni Üye Ekle");
		if(is_new) {new_btn.setText("Güncelle");};
		new_btn.setForeground(new java.awt.Color(128, 0, 0));
		new_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int ID = Integer.parseInt(uye_no.getText());
				String Gender=yeni_cinsiyet.getText();
				String Name=yeni_ad.getText();
				String Surname=yeni_soyad.getText();
				String Work=yeni_calısma.getText();
				String Mail=yeni_mail.getText();
				long TC=Long.parseLong(txtTc.getText());
				String Graduation=yeni_mezun_day.getText()+"-"+yeni_mezun_month.getText()+"-"+yeni_mezun_year.getText();
				String Department=yeni_bolum.getText();
				long Phone=Long.parseLong(yeni_tel.getText());
				String Address=yeni_adres.getText();
				String City=yeni_il.getText();
				String Mood=yeni_durum.getText();
				String Enter=yeni_uye_day.getText()+"-"+yeni_uye_month.getText()+"-"+yeni_uye_year.getText();
				if(is_new) {
					Database_methods dbmethods3 = new Database_methods();
					dbmethods3.AddClient(ID, Gender, Name,  Surname, Work, Mail, TC,
							Graduation, Department, Phone, Address, City, Mood, Enter);
					dbmethods3.AddAB(ID, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
				}else {
					Database_methods dbmethods3 = new Database_methods();
					
					dbmethods3.updateClient(ID, Gender, Name,  Surname, Work, Mail, TC,
							Graduation, Department, Phone, Address, City, Mood, Enter);
				}
				dispose();
			}
		});
		new_btn.setFont(new Font("Calibri", Font.BOLD, 14));
		new_btn.setBackground(new java.awt.Color(211, 211, 211));
		new_btn.setBounds(249, 450, 180, 25);
		panel_in.add(new_btn);
		
		uye_no = new JTextField();
		uye_no.setFont(new Font("Calibri", Font.PLAIN, 10));
		uye_no.setBounds(76, 5, 163, 20);
		panel_in.add(uye_no);
		uye_no.setColumns(10);
		
		JLabel lblSoyad = new JLabel("Soyadı:");
		lblSoyad.setForeground(new Color(128, 0, 0));
		lblSoyad.setFont(new Font("Calibri", Font.BOLD, 16));
		lblSoyad.setBounds(10, 65, 99, 17);
		panel_in.add(lblSoyad);
		
		yeni_ad = new JTextField();
		yeni_ad.setFont(new Font("Calibri", Font.PLAIN, 10));
		yeni_ad.setColumns(10);
		yeni_ad.setBounds(108, 35, 253, 20);
		panel_in.add(yeni_ad);
		
		yeni_soyad = new JTextField();
		yeni_soyad.setFont(new Font("Calibri", Font.PLAIN, 10));
		yeni_soyad.setColumns(10);
		yeni_soyad.setBounds(108, 63, 253, 20);
		panel_in.add(yeni_soyad);
		
		yeni_cinsiyet = new JTextField();
		yeni_cinsiyet.setFont(new Font("Calibri", Font.PLAIN, 10));
		yeni_cinsiyet.setColumns(10);
		yeni_cinsiyet.setBounds(108, 93, 253, 20);
		panel_in.add(yeni_cinsiyet);
		
		yeni_bolum = new JTextField();
		yeni_bolum.setFont(new Font("Calibri", Font.PLAIN, 10));
		yeni_bolum.setColumns(10);
		yeni_bolum.setBounds(109, 123, 252, 20);
		panel_in.add(yeni_bolum);
		
		yeni_calısma = new JTextField();
		yeni_calısma.setFont(new Font("Calibri", Font.PLAIN, 10));
		yeni_calısma.setColumns(10);
		yeni_calısma.setBounds(108, 153, 253, 20);
		panel_in.add(yeni_calısma);
		
		yeni_mail = new JTextField();
		yeni_mail.setFont(new Font("Calibri", Font.PLAIN, 10));
		yeni_mail.setColumns(10);
		yeni_mail.setBounds(108, 183, 253, 20);
		panel_in.add(yeni_mail);
		
		yeni_tel = new JTextField();
		yeni_tel.setFont(new Font("Calibri", Font.PLAIN, 10));
		yeni_tel.setColumns(10);
		yeni_tel.setBounds(108, 213, 253, 20);
		panel_in.add(yeni_tel);
		
		yeni_adres = new JTextField();
		yeni_adres.setFont(new Font("Calibri", Font.PLAIN, 10));
		yeni_adres.setColumns(10);
		yeni_adres.setBounds(108, 243, 253, 39);
		panel_in.add(yeni_adres);
		
		yeni_il = new JTextField();
		yeni_il.setFont(new Font("Calibri", Font.PLAIN, 10));
		yeni_il.setColumns(10);
		yeni_il.setBounds(108, 293, 253, 20);
		panel_in.add(yeni_il);
		
		yeni_mezun_day = new JTextField();
		yeni_mezun_day.setText("GG");
		yeni_mezun_day.setFont(new Font("Calibri", Font.PLAIN, 11));
		yeni_mezun_day.setColumns(10);
		yeni_mezun_day.setBounds(150, 339, 25, 20);
		panel_in.add(yeni_mezun_day);
		
		yeni_uye_day = new JTextField();
		yeni_uye_day.setText(String.format("%02d", day));
		yeni_uye_day.setFont(new Font("Calibri", Font.PLAIN, 11));
		yeni_uye_day.setColumns(10);
		yeni_uye_day.setBounds(150, 369, 25, 20);
		panel_in.add(yeni_uye_day);
		
		yeni_durum = new JTextField();
		yeni_durum.setText("AKTİF");
		yeni_durum.setFont(new Font("Calibri", Font.PLAIN, 11));
		yeni_durum.setColumns(10);
		yeni_durum.setBounds(150, 399, 163, 20);
		panel_in.add(yeni_durum);
		
		txtTc = new JTextField();
		txtTc.setFont(new Font("Calibri", Font.PLAIN, 10));
		txtTc.setColumns(10);
		txtTc.setBounds(355, 5, 154, 20);
		panel_in.add(txtTc);
		
		JButton geri_btn = new JButton("İptal");
		geri_btn.setFont(new Font("Calibri", Font.BOLD, 14));
		geri_btn.setForeground(new Color(128, 0, 0));
		geri_btn.setBounds(430, 450, 79, 25);
		geri_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {		
				dispose();
			}
        });
		panel_in.add(geri_btn);
		
		yeni_mezun_month = new JTextField();
		yeni_mezun_month.setFont(new Font("Calibri", Font.PLAIN, 11));
		yeni_mezun_month.setText("MM");
		yeni_mezun_month.setBounds(178, 339, 32, 20);
		panel_in.add(yeni_mezun_month);
		yeni_mezun_month.setColumns(10);
		
		yeni_mezun_year = new JTextField();
		yeni_mezun_year.setFont(new Font("Calibri", Font.PLAIN, 11));
		yeni_mezun_year.setText("YYYY");
		yeni_mezun_year.setBounds(214, 339, 45, 20);
		panel_in.add(yeni_mezun_year);
		yeni_mezun_year.setColumns(10);
		
		yeni_uye_month = new JTextField();
		yeni_uye_month.setFont(new Font("Calibri", Font.PLAIN, 11));
		yeni_uye_month.setBounds(178, 369, 32, 20);
		yeni_uye_month.setText(String.format("%02d", month));
		panel_in.add(yeni_uye_month);
		yeni_uye_month.setColumns(10);
		
		yeni_uye_year = new JTextField();
		yeni_uye_year.setFont(new Font("Calibri", Font.PLAIN, 11));
		yeni_uye_year.setBounds(214, 369, 45, 20);
		yeni_uye_year.setText(String.format("%04d", year));
		panel_in.add(yeni_uye_year);
		yeni_uye_year.setColumns(10);
		
		JButton minimize_btn = new JButton("_");
        minimize_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {		
				setState(JFrame.ICONIFIED);
			}
        });
		minimize_btn.setBounds(529, 11, 39, 34);
		panel.add(minimize_btn);
	}
	public static void centreWindow(JFrame frame) {
	    Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
	    int x = (int) ((dimension.getWidth() - frame.getWidth()) / 2);
	    int y = (int) ((dimension.getHeight() - frame.getHeight()) / 2);
	    frame.setLocation(x, y);
	}
}
