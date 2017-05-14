package UI;

import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import listener.OpenFileListener;
import model.Player;
import model.SingleDBton;
import model.Team;
import renderer.PlayerRenderer;
import renderer.TeamRenderer;
import util.MyParser;
import util.SearchUtil;

import java.awt.Font;
import javax.swing.ListSelectionModel;
import java.awt.GridLayout;
import javax.swing.JScrollPane;
import javax.swing.ListModel;
import javax.swing.JList;

public class WindowMain extends WindowRoot{
	
	private JTextField textSearch;
	DefaultListModel<Player> model;
	private JTextField textField;
	JList list;
	List<Player> playerList;
	
	JList jListTeam ;
	List<Team> teamList;

	public WindowMain() {
		super();	    
	    init();		
	}
	
	protected void init(){
		textField = new JTextField();
		textField.setBounds(299, 61, 550, 31);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton btnSearch = new JButton("搜索");
		btnSearch.addActionListener(new SearchListener());;
		btnSearch.setBounds(859, 61, 86, 31);
		getContentPane().add(btnSearch);
		
		model = new DefaultListModel<>(); 
		list = new JList(model);
		list.setCellRenderer(new PlayerRenderer());
		list.addMouseListener(new PlayerListListener());
		JScrollPane scrollPane = new JScrollPane(list);
		scrollPane.setBounds(299, 114, 660, 547);
		getContentPane().add(scrollPane);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 995, 20);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JButton btnOpenData = new JButton("open");
		btnOpenData.addActionListener(new  OpenFileListener(this));
		btnOpenData.setBounds(0, 0, 79, 20);
		panel.add(btnOpenData);
		
		
		DefaultListModel<Team> teamModel = new DefaultListModel<>();
		jListTeam = new JList(teamModel);
		jListTeam.setBounds(0, 0, 1, 1);
		jListTeam.setCellRenderer(new TeamRenderer());
		jListTeam.addMouseListener(new TeamListListener());
		JScrollPane scrollPaneTeam = new JScrollPane(jListTeam);
		scrollPaneTeam.setBounds(32, 114, 220, 547);
		getContentPane().add(scrollPaneTeam);
	}	
	
	private class PlayerListListener implements MouseListener {

		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			int index = list.getSelectedIndex();
			if(index!=-1){
				if(e.getClickCount()==2){
					WindowRoot windowsMain = new WindowPlayer(playerList.get(index));					
				}
			}
		}

		public void mouseEntered(MouseEvent arg0) {}
		public void mouseExited(MouseEvent arg0) {}
		public void mousePressed(MouseEvent arg0) {}
		public void mouseReleased(MouseEvent arg0) {}		
	}
	
	private class TeamListListener implements MouseListener {

		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			int index = jListTeam.getSelectedIndex();
	//为什么team传过来的值为null,是因为静态变量的引用没了吗
			if(index<0){
				return;
			}
			if(e.getClickCount()==2){
				Team team= new Team("","");
				team =(Team) jListTeam.getSelectedValue();
					if(team!=null){
						WindowRoot window = new WindowTeam(index);		
					}
					
									
			}
		
		}
		public void mouseEntered(MouseEvent arg0) {}
		public void mouseExited(MouseEvent arg0) {}
		public void mousePressed(MouseEvent arg0) {}
		public void mouseReleased(MouseEvent arg0) {}		
	}
	private class SearchListener implements ActionListener{

		public void actionPerformed(ActionEvent arg0) {
			String searchKey = textField.getText().toString();
			playerList = SearchUtil.SearchPlayerRes(searchKey,SingleDBton.instance().getPlayers());
			updateJList();
		}
		
	}
	
	private class OpenFileListener implements ActionListener {
		JFrame frame;
		JFileChooser fileChooser = new JFileChooser(new File(System.getProperty("user.dir")));
		public OpenFileListener(JFrame frame){
			super();
			this.frame = frame;
		}
		@Override
		public void actionPerformed(ActionEvent arg0) {		
		    if(fileChooser.showOpenDialog(frame)==JFileChooser.APPROVE_OPTION ){
		      String fileName = fileChooser.getSelectedFile().getAbsolutePath();
		      MyParser myParser = new MyParser();
		      myParser.parse(fileName, 2);
		      playerList = SingleDBton.instance().getPlayers();
		      teamList = SingleDBton.instance().getTeams();
		      updateJList();
		      updateJListTeam();
		    }
		}	
	}
	
	private void updateJList(){
		if(playerList!=null){
			list.setListData(playerList.toArray());
		}		
	}
	private void updateJListTeam(){
		if(teamList!=null){
			jListTeam.setListData(teamList.toArray());
		}		
	}
	
}
