package chartTest;

import static org.junit.Assert.*;

import java.awt.Container;
import java.awt.GridLayout;
import java.util.HashMap;

import javax.swing.JFrame;

import org.jfree.chart.ChartPanel;
import org.junit.Before;
import org.junit.Test;

import chart.BarChart;

public class BarChartTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testGetChartPanel() {
		
		String x = "赛季";
		String y = "得分";
		HashMap<String,Integer> data = new HashMap<String,Integer>();
		data.put("2010-2011", 19);
		data.put("2011-2012", 20);
		data.put("2012-2013", 19);
		data.put("2013-2014", 20);
		
		BarChart barChart = new BarChart(x,y,data);
		
		JFrame f = new JFrame("tongjitu");
		Container contentPane = f.getContentPane();
		contentPane.setLayout(new GridLayout(2,1));
		contentPane.add(barChart.getChartPanel());
		f.pack();
		f.setVisible(true);  
		
	}

}
