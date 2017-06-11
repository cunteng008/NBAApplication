package UI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;

import model.Arena;

import java.awt.Font;

public class WindowArena extends WindowRoot {

	private JFrame frame;
	Arena arena;

	public WindowArena(Arena arena) {
		super();
		this.arena = arena;
		init();
	}

	@Override
	protected void init() {
		
		JLabel lblNewLabel = new JLabel("ArenaTeam");
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 40));
		lblNewLabel.setBounds(10, 199, 237, 53);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("ArenaStart-End");
		lblNewLabel_1.setFont(new Font("宋体", Font.PLAIN, 40));
		lblNewLabel_1.setBounds(10, 262, 280, 62);
		getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Arena");
		lblNewLabel_2.setFont(new Font("宋体", Font.PLAIN, 40));
		lblNewLabel_2.setBounds(10, 334, 228, 62);
		getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("ArenaLocation");
		lblNewLabel_3.setFont(new Font("宋体", Font.PLAIN, 40));
		lblNewLabel_3.setBounds(10, 406, 260, 68);
		getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("ArenaCapacity");
		lblNewLabel_4.setFont(new Font("宋体", Font.PLAIN, 40));
		lblNewLabel_4.setBounds(10, 484, 260, 68);
		getContentPane().add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Logo");
		lblNewLabel_5.setFont(new Font("宋体", Font.PLAIN, 50));
		lblNewLabel_5.setBounds(21, 24, 269, 165);
		getContentPane().add(lblNewLabel_5);
	}
}
