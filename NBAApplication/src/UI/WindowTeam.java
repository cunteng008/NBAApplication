// WindowTeam.java

package UI;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.TextField;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import model.SingleDBton;
import model.Team;

import javax.swing.SwingConstants;

public class WindowTeam extends WindowRoot {
	Team team;
	public WindowTeam(int index) {
		super();
		this.team = SingleDBton.instance().getTeams().get(index);
		init();
	}
	@Override
	protected void init(){
				
		System.out.println(team.getAbbr());	
		JLabel lblNewLabel = new JLabel("LOGO");
		lblNewLabel.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 50));
		lblNewLabel.setBounds(22, 10, 154, 137);
		getContentPane().add(lblNewLabel);
			
		JList list_1 = new JList();
		list_1.setBounds(650, 10, 334, 285);
		getContentPane().add(list_1);
		
		JLabel lblintroduction = new JLabel("New label");
		lblintroduction.setText("<HTML>球队名称: " +team.getName() +"  简称是: "+ team.getAbbr()
										+"</HTML>");
		lblintroduction.setVerticalAlignment(SwingConstants.TOP);
		lblintroduction.setBounds(22, 170, 317, 218);
		getContentPane().add(lblintroduction);
	}
}
