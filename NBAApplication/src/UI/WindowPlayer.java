package UI;

import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;

import javax.swing.JTable;
import javax.swing.table.TableColumn;

import chart.BarChart;
import model.Player;
import model.PlayerSeason;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import java.awt.Panel;
import java.awt.Toolkit;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.HashMap;
import java.util.Map;
import java.awt.CardLayout;

public class WindowPlayer extends WindowRoot {

	private JTable table;
	JLabel lblName;
	JLabel lblteam;
	Player player;

	public  WindowPlayer (Player player){
		super();
		this.player = player;
		init();
		setContent();
	}
	@Override
	protected void init() {
		// TODO Auto-generated method stub
		
		JLabel lblNba = new JLabel("   NBA   ");
		lblNba.setIcon(new ImageIcon("/myImg/NBAlogo_show.jpg"));
		lblNba.setBounds(10, 0, 158, 61);
		getContentPane().add(lblNba);
		
		ImageIcon image = new ImageIcon("/myImg/players/库里.png"); 
		image.setImage(image.getImage().getScaledInstance(100,100,Image.SCALE_DEFAULT));
		JLabel label_1 = new JLabel();
		label_1.setIcon(image);
		label_1.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/myImg/players/库里.png"))));
		label_1.setBounds(722, 50, 139, 132);
		getContentPane().add(label_1);
		
		lblName = new JLabel("姓名 ： ");
		lblName.setFont(new Font("宋体", Font.PLAIN, 14));
		lblName.setBounds(10, 89, 313, 25);
		getContentPane().add(lblName);
		
		lblteam = new JLabel("球队 ：");
		lblteam.setFont(new Font("宋体", Font.PLAIN, 14));
		lblteam.setBounds(10, 124, 165, 25);
		getContentPane().add(lblteam);
		
		JLabel lblage = new JLabel("年龄 ：");
		lblage.setFont(new Font("宋体", Font.PLAIN, 14));
		lblage.setBounds(10, 159, 165, 30);
		getContentPane().add(lblage);
		
		String[] columnName = {"赛季","效力于","出场数","得分","年龄"};
		
		Object[][] data = new Object[player.getSeasons().size()][5];
		for(int i=0;i<player.getSeasons().size();i++){
			data[i][0] = player.getSeasons().get(i).getSeason();
			data[i][1] = player.getSeasons().get(i).getTeamAbbr();
			data[i][2] = player.getSeasons().get(i).getGames();
			data[i][3] = player.getSeasons().get(i).getPoints();
			data[i][4] = player.getSeasons().get(i).getAge();
		}
		
		JScrollPane scrollPane = new JScrollPane(table);
	
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 214, 964, 227);
		getContentPane().add(scrollPane_1);
		
		table = new JTable(data,columnName);
		//table.addMouseListener(new TableMouseListener());
		table.setRowSelectionAllowed(false);
		table.setFont(new Font("宋体", Font.PLAIN, 15));
		TableColumn column = null;
		for(int i = 0;i < 5;i++){
			column = table.getColumnModel().getColumn(i);
			column.setPreferredWidth(100);
		}
		scrollPane_1.setViewportView(table);
		table.setFillsViewportHeight(true);
		
		//球员出场数统计图
		String xLabel = "赛季";
		String yLabel = "场数";
		Map<String,Integer> chartData = new HashMap<>();
		for(PlayerSeason playerSeason:player.getSeasons()){
			chartData.put(playerSeason.getSeason(), playerSeason.getGames());
		}
		JPanel playerGamesBarChart = new JPanel();
		playerGamesBarChart.setBounds(10, 451, 537, 200);
		getContentPane().add(playerGamesBarChart);		
		playerGamesBarChart.add( new BarChart(xLabel,yLabel,chartData).getChartPanel());
		playerGamesBarChart.setLayout(new CardLayout(0, 0));
				
		//球员得分数统计图
		yLabel = "分数";
		for(PlayerSeason playerSeason:player.getSeasons()){
			chartData.put(playerSeason.getSeason(), playerSeason.getPoints());
		}
		JPanel playerPointsBarChart = new JPanel();
		playerPointsBarChart.setBounds(547, 451, 437, 200);
		playerPointsBarChart.add(new BarChart(xLabel,yLabel,chartData).getChartPanel());
		getContentPane().add(playerPointsBarChart);
		playerPointsBarChart.setLayout(new CardLayout(0, 0));
	}

	private void setContent(){
		lblName.setText("名字: "+player.getName());
	}
	
}
