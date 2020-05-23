import java.awt.*;
import java.awt.event.*;
import java.awt.geom.RoundRectangle2D;
import java.text.DecimalFormat;
import javax.swing.*;

import org.jfree.chart.*;
import org.jfree.chart.entity.ChartEntity;
import org.jfree.chart.labels.PieSectionLabelGenerator;
import org.jfree.chart.labels.StandardPieSectionLabelGenerator;
import org.jfree.chart.plot.PiePlot3D;
import org.jfree.chart.util.Rotation;
import org.jfree.data.general.*;

public class stats extends JFrame{
	int posX;
	int posY;
	int toplam=0;
	public stats(String title,String title2) {

		 initUI(title, title2);
	}
	public void initUI(String title, String chartTitle) {
		setTitle("İstatistikler");
		setForeground(Color.WHITE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 600, 370);
		getContentPane().add(panel);
				
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
		
		PieSectionLabelGenerator gen = new StandardPieSectionLabelGenerator(
			    "{0}: {1} ({2})", new DecimalFormat("0"), new DecimalFormat("0.0%"));
	    String arr[][]= {{"Mühendislik Fakültesi","29"},{"Tıp Fakültesi","20"},
	    		{"İktisadi ve İdari Bilimler Fakültesi","51"},{"Hukuk Fakültesi","5"},
	    		{"Mimarlık ve Tasarım Fakültesi","15"},{"Fen Edebiyat Fakültesi","60"},
	    		{"Yabancı Diller Bölümü","20"},{"Fen Bilimleri Enstitüsü","40"},
	    		{"Sosyal Bilimler Enstitüsü","30"},{"Sağlık Bilimleri Enstitüsü","50"}};
	    PieDataset mezun_bolum_dataset = createDataset(arr);
	    JFreeChart mezun_bolum_chart = createChart(mezun_bolum_dataset, chartTitle,gen);
	    ChartPanel mezun_bolum_chartPanel = new ChartPanel(mezun_bolum_chart);
	    panel.add(mezun_bolum_chartPanel);
	    mezun_bolum_chartPanel.setPreferredSize(new java.awt.Dimension(600, 370));
        mezun_bolum_chartPanel.addChartMouseListener(new ChartMouseListener() {
            @Override
            public void chartMouseClicked(ChartMouseEvent event) {
            	ChartEntity entity = event.getEntity();
                String v=entity.toString();
                if(!"JFreeChartEntity: tooltip = null".equals(v)) {
                	String fakulte=v.split(" ")[2].split("\\(")[1];
                    //System.out.println(fakulte);
                    //setVisible(false);
            		bolum_stats b=new bolum_stats("fakülte",fakulte);
            		b.setVisible(false);
            		b.dispose();
            		b.setUndecorated(true);
            		b.setSize(605,410);
                    b.setShape(new RoundRectangle2D.Double(0, 0, b.getWidth(), b.getHeight(), 20, 20));
            		centreWindow(b);  		
            		b.setVisible(true);
                }               
            }
            @Override
            public void chartMouseMoved(ChartMouseEvent event) {
            }
        });
        JButton btnGeri = new JButton("Geri");
		btnGeri.setBounds(485, 375, 89, 23);
		getContentPane().add(btnGeri);
		btnGeri.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent arg0) {		
        		setVisible(false);
			}
        });
		panel.setBackground(Color.white);
		getContentPane().setBackground(Color.WHITE);
	}

	private  PieDataset createDataset(String [][]arr) {
		DefaultPieDataset set = new DefaultPieDataset();
		for(int x=0;x<arr.length;x++) {
			set.setValue(arr[x][0], Integer.parseInt(arr[x][1]));
			toplam=toplam+Integer.parseInt(arr[x][1]);
		}
		return set;
	}

	private JFreeChart createChart(PieDataset dataset, String title,PieSectionLabelGenerator w) {
		JFreeChart chart = ChartFactory.createPieChart3D(
			title,                  // chart title
	      	dataset,                // data
	        true,                   // include legend
	        true,
	        false
	    );
		PiePlot3D plot = (PiePlot3D) chart.getPlot();
		plot.setStartAngle(290);
		plot.setDirection(Rotation.CLOCKWISE);
		plot.setForegroundAlpha(0.9f);
		plot.setLabelGenerator(w);
		return chart;
	}
	public static void centreWindow(JFrame frame) {
	    Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
	    int x = (int) ((dimension.getWidth() - frame.getWidth()) / 2);
	    int y = (int) ((dimension.getHeight() - frame.getHeight()) / 2);
	    frame.setLocation(x, y);
	}      
}
