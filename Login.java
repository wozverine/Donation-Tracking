import java.awt.BorderLayout;
import javax.swing.*;
import javax.swing.border.AbstractBorder;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.RoundRectangle2D;

public class Login  extends javax.swing.JFrame{
	
	JPasswordField password_pf = new JPasswordField();  
	JTextField username_txtf = new JTextField();
	JLabel sifre_btn = new JLabel();
	JLabel username_lbl = new JLabel();
	JButton login_btn = new JButton();
	JButton exit_btn = new JButton();

	public Login() {
		
		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        		
		JLayeredPane layeredPane = new JLayeredPane();
		layeredPane.setBackground(Color.LIGHT_GRAY);
		layeredPane.setBounds(0, 0, 500, 500);
		getContentPane().add(layeredPane, BorderLayout.CENTER);
		layeredPane.setLayout(null);
		
		JLabel hatırla_lbl = new JLabel();
		
		hatırla_lbl.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
		hatırla_lbl.setForeground(new java.awt.Color(255, 255, 255));
		hatırla_lbl.setHorizontalAlignment(SwingConstants.LEFT);
		hatırla_lbl.setText("Giriş bilgilerini kaydet");
		hatırla_lbl.setBounds(482, 395, 206, 30);
		layeredPane.add(hatırla_lbl);
		JCheckBox hatırla_cb = new JCheckBox();
		
		        hatırla_cb.setBorder(null);
		        hatırla_cb.setBounds(460, 400, 20, 20);
		        layeredPane.add(hatırla_cb);
		        password_pf.addMouseListener(new MouseAdapter() {
		        	@Override
		        	public void mouseClicked(MouseEvent e) {
		        		password_pf.setText("");
		        	}
		        });
		        
		        password_pf.setEchoChar('*');
		        password_pf.setFont(new java.awt.Font("Calibri", 0, 20)); // NOI18N
		        password_pf.setForeground(new java.awt.Color(204, 204, 204));
		        password_pf.setText("Password");
		        password_pf.setBorder(null);
		        password_pf.setOpaque(false);
		        password_pf.setBounds(460, 320, 308, 40);
		        layeredPane.add(password_pf);
		        login_btn.addMouseListener(new MouseAdapter() {
		        	@Override
		        	public void mouseClicked(MouseEvent e) {
		        		 try {
		        		        for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
		        		            if ("Nimbus".equals(info.getName())) {
		        		                javax.swing.UIManager.setLookAndFeel(info.getClassName());
		        		                break;
		        		            }
		        		        }
		        		    } catch (ClassNotFoundException ex) {
		        		        java.util.logging.Logger.getLogger(main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		        		    } catch (InstantiationException ex) {
		        		        java.util.logging.Logger.getLogger(main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		        		    } catch (IllegalAccessException ex) {
		        		        java.util.logging.Logger.getLogger(main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		        		    } catch (javax.swing.UnsupportedLookAndFeelException ex) {
		        		        java.util.logging.Logger.getLogger(main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		        		    }
		        		    //</editor-fold>

		        		    /* Create and display the form */
		        		    java.awt.EventQueue.invokeLater(new Runnable() {
		        		        public void run() {
		        		            setVisible(false);
		        		            main x=new main();
		        		            x.setVisible(true);
		        		            centreWindow(x);
		        		        	//new main().setVisible(true);
		        		        }
		        		    });
		        	}
		        });
		        
		        login_btn.setIcon(new javax.swing.ImageIcon(getClass().getResource("login_button.png"))); // NOI18N
		        login_btn.setBorder(null);
		        login_btn.setBorderPainted(false);
		        login_btn.setContentAreaFilled(false);
		        login_btn.setBounds(392, 431, 232, 46);
		        layeredPane.add(login_btn);
		        
		        exit_btn.addMouseListener(new MouseAdapter() {
		        	@Override
		        	public void mouseClicked(MouseEvent e) {
		        		 try {
		        		        for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
		        		            if ("Nimbus".equals(info.getName())) {
		        		                javax.swing.UIManager.setLookAndFeel(info.getClassName());
		        		                break;
		        		            }
		        		        }
		        		    } catch (ClassNotFoundException ex) {
		        		        java.util.logging.Logger.getLogger(main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		        		    } catch (InstantiationException ex) {
		        		        java.util.logging.Logger.getLogger(main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		        		    } catch (IllegalAccessException ex) {
		        		        java.util.logging.Logger.getLogger(main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		        		    } catch (javax.swing.UnsupportedLookAndFeelException ex) {
		        		        java.util.logging.Logger.getLogger(main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		        		    }
		        		    //</editor-fold>

		        		    /* Create and display the form */
		        		    java.awt.EventQueue.invokeLater(new Runnable() {
		        		        public void run() {
		        		            setVisible(false);
		        		        }
		        		    });
		        	}
		        });
		        
		        exit_btn.setIcon(new javax.swing.ImageIcon(getClass().getResource("login_button.png"))); // NOI18N
		        exit_btn.setBorder(null);
		        exit_btn.setBorderPainted(false);
		        exit_btn.setContentAreaFilled(false);
		        exit_btn.setBounds(600, 431, 232, 46);
		        layeredPane.add(exit_btn);
		        
		        username_txtf.addMouseListener(new MouseAdapter() {
		        	@Override
		        	public void mouseClicked(MouseEvent e) {
		        		username_txtf.setText("");
		        	}
		        });

		        username_txtf.setFont(new java.awt.Font("Calibri", 0, 20)); // NOI18N
		        username_txtf.setForeground(new java.awt.Color(204, 204, 204));
		        username_txtf.setText("Kullanıcı adını giriniz");
		        username_txtf.setBorder(null);
		        username_txtf.setOpaque(false);
		        username_txtf.setBounds(460, 180, 308, 40);
		        layeredPane.add(username_txtf);
		        
		        sifre_btn.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N
		        sifre_btn.setForeground(new java.awt.Color(255, 255, 255));
		        sifre_btn.setHorizontalAlignment(SwingConstants.LEFT);
		        sifre_btn.setText("Şifre");
		        sifre_btn.setBounds(460, 280, 330, 30);
		        layeredPane.add(sifre_btn);

		        username_lbl.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N
		        username_lbl.setForeground(new java.awt.Color(255, 255, 255));
		        username_lbl.setHorizontalAlignment(SwingConstants.LEFT);
		        username_lbl.setText("Kullanıcı Adı");
		        username_lbl.setBounds(460, 140, 264, 30);
		        layeredPane.add(username_lbl);
		        
		JLabel loginLeft_lbl = new JLabel("");
		loginLeft_lbl.setIcon(new javax.swing.ImageIcon(getClass().getResource("login_left.png")));
		loginLeft_lbl.setBounds(0, 0, 400, 500);
		layeredPane.add(loginLeft_lbl);
		
		JLabel loginRight_lbl = new JLabel("");
		loginRight_lbl.setIcon(new javax.swing.ImageIcon(getClass().getResource("login_right.png")));
		loginRight_lbl.setBounds(395, 0, 400, 500);
		layeredPane.add(loginRight_lbl);	
	}
	
	public static void centreWindow(JFrame frame) {
	    Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
	    int x = (int) ((dimension.getWidth() - frame.getWidth()) / 2);
	    int y = (int) ((dimension.getHeight() - frame.getHeight()) / 2);
	    frame.setLocation(x, y);
	}
	public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Login l = new Login();
                l.setSize(795,500);
                l.setUndecorated(true);
                l.setShape(new RoundRectangle2D.Double(0, 0, l.getWidth(), l.getHeight(), 20, 20));
                centreWindow(l);
                l.setVisible(true);
            }
        });
    }
}
