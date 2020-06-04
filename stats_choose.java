import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import java.awt.*;
import java.awt.event.*;
import java.awt.geom.RoundRectangle2D;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.Arrays;
import java.util.Calendar;

public class stats_choose extends JFrame{
	int posX;
    int posY;
    String spinnerYear="2010";
    public stats_choose(Map<String, Integer> bolum_map,Map<String, Integer> giris_yıl_map,Map<String, 
    		Integer> mezun_yıl_map,Map<String, Integer> calısma_map,Map<String, Integer> il_map,String[][]odeme) {
		initUI(bolum_map,giris_yıl_map,mezun_yıl_map,calısma_map,il_map,odeme);
	}
	public void initUI(Map<String, Integer> bolum_map,Map<String, Integer> giris_yıl_map,Map<String, 
    		Integer> mezun_yıl_map,Map<String, Integer> calısma_map,Map<String, Integer> il_map,String[][]odeme) {
		setResizable(false);
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
    	Date date = new Date();
		LocalDate localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		int year_now = localDate.getYear();
		getContentPane().setSize(370,270);
		
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{1.0};
		getContentPane().setLayout(gridBagLayout);
		
		Component verticalStrut_1 = Box.createVerticalStrut(20);
		GridBagConstraints gbc_verticalStrut_1 = new GridBagConstraints();
		gbc_verticalStrut_1.insets = new Insets(0, 0, 5, 0);
		gbc_verticalStrut_1.gridx = 0;
		gbc_verticalStrut_1.gridy = 0;
		getContentPane().add(verticalStrut_1, gbc_verticalStrut_1);
		
		JButton calısan_btn = new JButton("Çalışanlara göre");
		GridBagConstraints gbc_calısan_btn = new GridBagConstraints();
		gbc_calısan_btn.insets = new Insets(0, 0, 5, 0);
		gbc_calısan_btn.gridx = 0;
		gbc_calısan_btn.gridy = 1;
		gbc_calısan_btn.gridwidth = GridBagConstraints.REMAINDER;
		getContentPane().add(calısan_btn, gbc_calısan_btn);
		calısan_btn.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent arg0) {		
        		stats_general stats=new stats_general("Comparison", "Nerelerde çalışıyorlar?",map_to_array(calısma_map));
				stats.setVisible(false);
				stats.dispose();
				stats.setUndecorated(true);
				stats.setSize(605,410);
				stats.setShape(new RoundRectangle2D.Double(0, 0, stats.getWidth(), stats.getHeight(), 20, 20));
        		centreWindow(stats);  		
        		stats.setVisible(true);
			}
        });
		
		JButton giris_yıl_btn = new JButton("Giriş yılına göre");
		GridBagConstraints gbc_giris_yıl_btn = new GridBagConstraints();
		gbc_giris_yıl_btn.insets = new Insets(0, 0, 5, 0);
		gbc_giris_yıl_btn.gridx = 0;
		gbc_giris_yıl_btn.gridy = 2;
		gbc_giris_yıl_btn.gridwidth = GridBagConstraints.REMAINDER;
		getContentPane().add(giris_yıl_btn, gbc_giris_yıl_btn);
		giris_yıl_btn.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent arg0) {		
        		stats_general stats=new stats_general("Comparison", "Hangi yıl derneğe kayıt oldular?",map_to_array(giris_yıl_map));
				stats.setVisible(false);
				stats.dispose();
				stats.setUndecorated(true);
				stats.setSize(605,410);
				stats.setShape(new RoundRectangle2D.Double(0, 0, stats.getWidth(), stats.getHeight(), 20, 20));
        		centreWindow(stats);  		
        		stats.setVisible(true);
			}
        });
		
		JButton fakulte_btn = new JButton("Bölüme göre");
		GridBagConstraints gbc_fakulte_btn = new GridBagConstraints();
		gbc_fakulte_btn.insets = new Insets(0, 0, 5, 0);
		gbc_fakulte_btn.gridx = 0;
		gbc_fakulte_btn.gridy = 3;
		gbc_fakulte_btn.gridwidth = GridBagConstraints.REMAINDER;
		getContentPane().add(fakulte_btn, gbc_fakulte_btn);
		fakulte_btn.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent arg0) {		
        		stats_general stats=new stats_general("Comparison", "Üyler hangi bölümlerden?",map_to_array(bolum_map));
				stats.setVisible(false);
				stats.dispose();
				stats.setUndecorated(true);
				stats.setSize(605,410);
				stats.setShape(new RoundRectangle2D.Double(0, 0, stats.getWidth(), stats.getHeight(), 20, 20));
        		centreWindow(stats);  		
        		stats.setVisible(true);
			}
        });
		
		JButton mezun_yıl_btn = new JButton("Mezuniyet yılına göre");
		GridBagConstraints gbc_mezun_yıl_btn = new GridBagConstraints();
		gbc_mezun_yıl_btn.insets = new Insets(0, 0, 5, 0);
		gbc_mezun_yıl_btn.gridx = 0;
		gbc_mezun_yıl_btn.gridy = 4;
		gbc_mezun_yıl_btn.gridwidth = GridBagConstraints.REMAINDER;
		getContentPane().add(mezun_yıl_btn, gbc_mezun_yıl_btn);
		mezun_yıl_btn.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent arg0) {		
        		stats_general stats=new stats_general("Comparison", "Hangi yıl mezun oldular?",map_to_array(mezun_yıl_map));
				stats.setVisible(false);
				stats.dispose();
				stats.setUndecorated(true);
				stats.setSize(605,410);
				stats.setShape(new RoundRectangle2D.Double(0, 0, stats.getWidth(), stats.getHeight(), 20, 20));
        		centreWindow(stats);  		
        		stats.setVisible(true);
			}
        });
		
		
		String[] year_str=new String[year_now-2010+1];
		for(int x=0;x<year_now-2010+1;x++) {
			year_str[x]=(2010+x)+"";
		}
		JSpinner spinner = new JSpinner(new SpinnerListModel(year_str));
		GridBagConstraints gbc_spinner = new GridBagConstraints();
		gbc_spinner.weightx = 2.0;
		gbc_spinner.insets = new Insets(0, 100, 5, 0);
		gbc_spinner.gridx = 0;
		gbc_spinner.gridy = 5;
		spinner.addChangeListener((ChangeListener) new ChangeListener() {  
			@Override
			public void stateChanged(ChangeEvent arg0) {
				spinnerYear=(String) spinner.getValue();
			}  
	    });  
		getContentPane().add(spinner, gbc_spinner);
		
		JButton odeme_btn = new JButton("Ödemeye göre");
		GridBagConstraints gbc_odeme_btn = new GridBagConstraints();
		gbc_odeme_btn.weightx = 1.0;
		gbc_odeme_btn.insets = new Insets(0, 0, 5, 80);
		gbc_odeme_btn.gridx = 0;
		gbc_odeme_btn.gridy = 5;
		gbc_odeme_btn.gridwidth = GridBagConstraints.REMAINDER;
		getContentPane().add(odeme_btn, gbc_odeme_btn);
		odeme_btn.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent arg0) {
        		Map<String, Integer> odeme_map=countArray(odeme[Integer.parseInt(spinnerYear)-2010]);
        		stats_general stats=new stats_general("Comparison", "Borç miktarı",map_to_array(odeme_map));
				stats.setVisible(false);
				stats.dispose();
				stats.setUndecorated(true);
				stats.setSize(605,410);
				stats.setShape(new RoundRectangle2D.Double(0, 0, stats.getWidth(), stats.getHeight(), 20, 20));
        		centreWindow(stats);  		
        		stats.setVisible(true);
			}
        });
		
		Component verticalStrut = Box.createVerticalStrut(20);
		GridBagConstraints gbc_verticalStrut = new GridBagConstraints();
		gbc_verticalStrut.insets = new Insets(0, 0, 5, 0);
		gbc_verticalStrut.gridx = 0;
		gbc_verticalStrut.gridy = 7;
		getContentPane().add(verticalStrut, gbc_verticalStrut);
		
		
		JButton geri_btn = new JButton("Geri");
		GridBagConstraints gbc_geri_btn  = new GridBagConstraints();
		gbc_geri_btn.gridx = 0;
		gbc_geri_btn.gridy = 8;
		gbc_geri_btn.anchor = GridBagConstraints.EAST;
		gbc_fakulte_btn.gridwidth = GridBagConstraints.REMAINDER;
		geri_btn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setVisible(false);
			}
		});
		getContentPane().add(geri_btn,gbc_geri_btn );
	}
	
	public static void centreWindow(JFrame frame) {
	    Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
	    int x = (int) ((dimension.getWidth() - frame.getWidth()) / 2);
	    int y = (int) ((dimension.getHeight() - frame.getHeight()) / 2);
	    frame.setLocation(x, y);
	}  
	public String[][] map_to_array(Map<String, Integer> map){
		String[][] arr = new String[map.size()][2];
		Set entries = map.entrySet();
		Iterator entriesIterator = entries.iterator();
		int i = 0;
		while(entriesIterator.hasNext()){
		    Map.Entry mapping = (Map.Entry) entriesIterator.next();

		    arr[i][0] = mapping.getKey().toString();
		    arr[i][1] = mapping.getValue().toString();

		    i++;
		}
		return arr;
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
}
