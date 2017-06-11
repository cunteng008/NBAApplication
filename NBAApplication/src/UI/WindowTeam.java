// WindowTeam.java

package UI;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.TableColumn;

import chart.BarChart;
import chart.PieChart;
import model.Player;
import model.PlayerSeason;
import model.SingleDBton;
import model.Team;
import model.TeamSeason;
import util.SearchUtil;

import javax.swing.SwingConstants;

public class WindowTeam extends WindowRoot {
	Team team;
	private JTable table;
	
	public WindowTeam(Team team) {
		super();
		this.team = team;
		init();
	}
	@Override
	protected void init(){
		
		JLabel lblintroduction = new JLabel("New label");
		lblintroduction.setFont(new Font("宋体", Font.PLAIN, 28));
		lblintroduction.setText("<HTML>简介：<br />球队全名: " + team.getName() 
		+"   成立于: "+ team.getTeamFrom() + "<br />"
		+"   共进行了"+ team.getGames() + "场比赛" + "<br />"
		+"   共胜" + team.getWins() + "场" 
		+"   负" + team.getLosses() + "场" + "<br />"
		+"   获得" + team.getChampions() + "次冠军"
										+"</HTML>");
		lblintroduction.setVerticalAlignment(SwingConstants.TOP);
		lblintroduction.setBounds(22, 170, 615, 214);
		getContentPane().add(lblintroduction);;
		
		String title = "胜场与负场饼图";
		HashMap chartData = new HashMap<>();
		chartData.put("负", team.getLosses());
		chartData.put("胜", team.getWins());

		JPanel teamGamesPieChart = new JPanel();
		teamGamesPieChart.setBounds(708, 199, 286, 229);
		getContentPane().add(teamGamesPieChart);		
		teamGamesPieChart.add( new PieChart(chartData,title).getChartPanel());
		teamGamesPieChart.setLayout(new CardLayout(0, 0));
		
		title = "球场饼图";
		HashMap chartData1 = new HashMap<>();
		for(TeamSeason teamSeason:team.getTeamSeasons()){
			chartData1.put(teamSeason.getArenaName(), 1);
		}
		JPanel ArenaPieChart = new JPanel();
		ArenaPieChart.setBounds(708, 0, 286, 201);
		ArenaPieChart.add(new PieChart(chartData1,title).getChartPanel());
		getContentPane().add(ArenaPieChart);
		ArenaPieChart.setLayout(new CardLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane(table);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(14, 441, 964, 241);
		getContentPane().add(scrollPane_1);
		

        String[] columnName = {"赛季","球场","教练","阵容"};
		
		Object[][] data = new Object[team.getTeamSeasons().size()][4];
		for(int i=0;i<team.getTeamSeasons().size();i++){
			data[i][0] = team.getTeamSeasons().get(i).getSeason();
			data[i][1] = team.getTeamSeasons().get(i).getArenaName();
			data[i][2] = team.getTeamSeasons().get(i).getCoaches();
			data[i][3] = team.getTeamSeasons().get(i).getPlayerNames();
		}
		
		table = new JTable(data,columnName);
		//table.addMouseListener(new TableMouseListener());
		table.setRowSelectionAllowed(false);
		table.setFont(new Font("宋体", Font.PLAIN, 15));
		TableColumn column = null;
		for(int i = 0;i < 4;i++){
			column = table.getColumnModel().getColumn(i);
			column.setPreferredWidth(100);
		}
		scrollPane_1.setViewportView(table);
		table.setFillsViewportHeight(true);
		
		JLabel lblTeamName = new JLabel("球队简称");
		lblTeamName.setFont(new Font("宋体", Font.PLAIN, 45));
		lblTeamName.setHorizontalAlignment(SwingConstants.CENTER);
		lblTeamName.setBounds(22, 13, 209, 152);
		getContentPane().add(lblTeamName);
		lblTeamName.setText(team.getAbbr());
	}
}
