

import java.awt.BorderLayout;
import javax.swing.*;


import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Login  extends javax.swing.JFrame{
	
	JPasswordField jPasswordField = new JPasswordField();  
	JTextField jTextField_username = new JTextField();
	JLabel jLabel6 = new JLabel();
	JLabel jLabel4 = new JLabel();
	JLabel jLabel1 = new JLabel();
	JLabel jLabel2 = new JLabel();
	JLabel jLabel5 = new JLabel();
	JButton jButton1 = new JButton();

	public Login() {
		
		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		
		JLayeredPane layeredPane = new JLayeredPane();
		layeredPane.setBackground(Color.LIGHT_GRAY);
		layeredPane.setBounds(0, 0, 500, 500);
		getContentPane().add(layeredPane, BorderLayout.CENTER);
		layeredPane.setLayout(null);
		
		JLabel jLabel7 = new JLabel();
		
		jLabel7.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
		jLabel7.setForeground(new java.awt.Color(255, 255, 255));
		jLabel7.setHorizontalAlignment(SwingConstants.LEFT);
		jLabel7.setText("Giriş bilgilerini kaydet");
		jLabel7.setBounds(482, 395, 206, 30);
		layeredPane.add(jLabel7);
		JCheckBox jCheckBox1 = new JCheckBox();
		
		        jCheckBox1.setBorder(null);
		        jCheckBox1.setBounds(460, 400, 20, 20);
		        layeredPane.add(jCheckBox1);
		        jPasswordField.addMouseListener(new MouseAdapter() {
		        	@Override
		        	public void mouseClicked(MouseEvent e) {
		        		jPasswordField.setText("");
		        	}
		        });
		        
		        jPasswordField.setEchoChar('*');
		        jPasswordField.setFont(new java.awt.Font("Calibri", 0, 20)); // NOI18N
		        jPasswordField.setForeground(new java.awt.Color(204, 204, 204));
		        jPasswordField.setText("Password");
		        jPasswordField.setBorder(null);
		        jPasswordField.setOpaque(false);
		        jPasswordField.setBounds(460, 320, 308, 40);
		        layeredPane.add(jPasswordField);
		        jButton1.addMouseListener(new MouseAdapter() {
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
		        		        	new main().setVisible(true);
		        		        }
		        		    });
		        	}
		        });
		        
		        jButton1.setIcon(new ImageIcon("C:\\Users\\serra\\Desktop\\ui tobb\\login_button.png")); // NOI18N
		        jButton1.setBorder(null);
		        jButton1.setBorderPainted(false);
		        jButton1.setContentAreaFilled(false);
		        jButton1.setBounds(492, 431, 232, 46);
		        layeredPane.add(jButton1);
		        jTextField_username.addMouseListener(new MouseAdapter() {
		        	@Override
		        	public void mouseClicked(MouseEvent e) {
		        		jTextField_username.setText("");
		        	}
		        });

		        jTextField_username.setFont(new java.awt.Font("Calibri", 0, 20)); // NOI18N
		        jTextField_username.setForeground(new java.awt.Color(204, 204, 204));
		        jTextField_username.setText("Kullanıcı adını giriniz");
		        jTextField_username.setBorder(null);
		        jTextField_username.setOpaque(false);
		        jTextField_username.setBounds(460, 180, 308, 40);
		        layeredPane.add(jTextField_username);
		        
		        jLabel6.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N
		        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
		        jLabel6.setHorizontalAlignment(SwingConstants.LEFT);
		        jLabel6.setText("Şifre");
		        jLabel6.setBounds(460, 280, 330, 30);
		        layeredPane.add(jLabel6);

		        jLabel4.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N
		        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
		        jLabel4.setHorizontalAlignment(SwingConstants.LEFT);
		        jLabel4.setText("Kullanıcı Adı");
		        jLabel4.setBounds(460, 140, 264, 30);
		        layeredPane.add(jLabel4);
		        
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("C:\\Users\\serra\\Desktop\\ui tobb\\login_left.png"));
		label.setBounds(0, 0, 400, 500);
		layeredPane.add(label);
		
		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon("C:\\Users\\serra\\Desktop\\ui tobb\\login_right.png"));
		label_1.setBounds(395, 0, 400, 500);
		layeredPane.add(label_1);
		
		
  
        
		
		
		
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
                l.setSize(812,540);
                l.setVisible(true);
            }
        });
    }
}
