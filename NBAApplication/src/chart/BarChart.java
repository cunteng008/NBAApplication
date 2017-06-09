package chart;

import java.awt.Container;
import java.awt.Font;
import java.awt.Frame;
import java.awt.GridLayout;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JFrame;

import org.jfree.chart.ChartFactory;         //瀵煎叆閿欎簡鍖咃紝瀵兼垚 浜哾emon.jar.瀹虫垜涓�鐩寸敤涓嶄簡閲岄潰鐨勭被
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.CategoryLabelPositions;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;

//璇存槑锛屽彲浠ヨ緭鍏,y纭畾妯酱绾电殑鍐呭锛岃緭鍏ヤ竴涓搱甯岃〃锛屼骇鐢熺浉搴旂殑鐩存柟鍥�
public class BarChart{
	
	ChartPanel	chartPanel;
	private String xLabel;
	private String yLable;
	private Map data;
	
	public  BarChart(String xLabel,String yLabel,Map data){
		setBarChart(xLabel,yLabel,data);		
	}
	
	private void init(){
		//鏋勯�犲嚱鏁�
		CategoryDataset dataset = getDataSet(xLabel,yLable,data);    //澹版槑涓�涓暟鎹泦
		JFreeChart chart = ChartFactory.createBarChart3D(
				"",  //title,
				xLabel,  //categoryAxisLabel,
				yLable,  //valueAxisLabel, 
				dataset,  // 鐢荤粺璁″浘闇�瑕佹暟鎹泦
				PlotOrientation.VERTICAL,//orientation,
				true,   //legend,骞插槢鐢ㄧ殑 ,鏄惁鐢熸垚鍥句緥 
				false,  //tooltips,鏄惁鐢熸垚宸ュ叿
				false);  //urls鏄惁鐢熸垚url
	
		//浠庤繖閲屽紑濮�
		CategoryPlot plot=chart.getCategoryPlot();  //鑾峰彇鍥捐〃鍖哄煙瀵硅薄聽聽
		CategoryAxis domainAxis=plot.getDomainAxis();//姘村钩搴曢儴鍒楄〃聽聽
		domainAxis.setLabelFont(new Font("榛戜綋",Font.BOLD,14));  //姘村钩搴曢儴鏍囬聽聽
		domainAxis.setTickLabelFont(new Font("瀹嬩綋",Font.BOLD,12));  //鍨傜洿鏍囬聽聽
		domainAxis.setCategoryLabelPositions(CategoryLabelPositions.DOWN_90);   //!!!!!
		ValueAxis rangeAxis=plot.getRangeAxis();//鑾峰彇鏌辩姸聽聽
		rangeAxis.setLabelFont(new Font("榛戜綋",Font.BOLD,15));
		chart.getLegend().setItemFont(new Font("榛戜綋", Font.BOLD, 15));
		chart.getTitle().setFont(new Font("瀹嬩綋",Font.BOLD,20));//璁剧疆鏍囬瀛椾綋聽聽
		
		//鍒拌繖閲岀粨鏉燂紝铏界劧浠ｇ爜鏈夌偣澶氾紝浣嗗彧涓轰竴涓洰鐨勶紝瑙ｅ喅姹夊瓧涔辩爜闂聽
		chartPanel = new ChartPanel(chart,true);
	}
	
	 //getdataset锛屾敹闆嗘暟鎹泦锛屼互浣滀负杞寲鐨勫師鏉愭枡
     private  CategoryDataset getDataSet(String x, String y,Map data){
    	 
    	  //鏍规嵁閿�兼帓搴�
    	  Object[] key = data.keySet().toArray();
    	  Arrays.sort(key);
    	  // 浼犲叆鐨勫搱甯岄敭鍊间负璧涘
    	  DefaultCategoryDataset dataset = new DefaultCategoryDataset();
    	  for(int i = 0;i<key.length;i++){    		     		 
    		  int defen = (int) data.get(key[i]);
    		  String s =(String) key[i];
    
    		  dataset.addValue(defen,"",s);
    	  }
		  return dataset; 
     }
     

     
     // 涓�涓璞″彲浠ョ敾澶氭
     public void setBarChart(String xLabel,String yLabel,Map data){
    	this.xLabel = xLabel;
 		this.yLable = yLabel;
 		this.data = data;	
 		init();
     }
          
     public ChartPanel getChartPanel(){
		return chartPanel;
     }   //杩斿洖閫氳繃鏋勯�犲嚱鏁板緱鍒扮殑闈㈡澘
 
}