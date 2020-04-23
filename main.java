
import java.io.*;

import javax.swing.*;

public class main {

	public static void main(String[] args) throws IOException{
		// Buradaki kod personal info sayfasını açacak action içine gidecek
		personal p = new personal();
		//p.setExtendedState(JFrame.MAXIMIZED_BOTH); 
		p.setSize(700, 600);
		p.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    p.setVisible(true);	
	}

}
