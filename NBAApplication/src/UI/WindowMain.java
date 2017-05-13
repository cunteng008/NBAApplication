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
import model.PlayerRenderer;
import model.SingleDBton;
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
	}	
	
	private class PlayerListListener implements MouseListener {

		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			int index = list.getSelectedIndex();
			if(index!=-1){
				if(e.getClickCount()==2){
					WindowRoot windowsMain = new WindowPlayer(SingleDBton.instance().
							getPlayers().get(index));					
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
			playerList = SearchUtil.SearchPlayerRes(searchKey,playerList);
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
		      updateJList();
		    }
		}	
	}
	
	private void updateJList(){
		if(playerList!=null){
			list.setListData(playerList.toArray());
		}		
	}
	
}
