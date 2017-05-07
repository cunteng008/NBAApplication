package UI;

import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
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

	public WindowMain() {
		super();
		
		String fileName = "D:/cmj/MyProject/eclipse/NBAprojectWorkspace/NBAApplication/"
				+ "resource/NBAData.txt";
	    MyParser myParser = new MyParser();
	    myParser.parse(fileName, 2);
	    
	    init();		
	}
	
	protected void init(){
		textField = new JTextField();
		textField.setBounds(299, 61, 550, 31);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("搜索");
		btnNewButton.setBounds(859, 61, 86, 31);
		getContentPane().add(btnNewButton);
		
		model = new DefaultListModel<>(); 
		for(Player player:SingleDBton.instance().getPlayers()){
			model.addElement(player);
		}
		list = new JList(model);
		list.setCellRenderer(new PlayerRenderer());
		list.addMouseListener(new PlayerListListener());
		JScrollPane scrollPane = new JScrollPane(list);
		scrollPane.setBounds(299, 114, 660, 547);
		getContentPane().add(scrollPane);
	}
	
	
	class PlayerListListener implements MouseListener {

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

		@Override
		public void mouseEntered(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseExited(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mousePressed(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseReleased(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}
		
	}
	
	
}
