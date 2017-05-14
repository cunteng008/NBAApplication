package renderer;

import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.ListCellRenderer;

import model.Player;

public class PlayerRenderer extends JPanel implements ListCellRenderer<Player> {
	
	private JLabel lbName = new JLabel();
	  
	public PlayerRenderer(){
		setLayout(new FlowLayout());  
		JPanel panelText = new JPanel(new GridLayout(0, 1));
        panelText.add(lbName);
       
        add(panelText);
	}
	@Override
	public Component getListCellRendererComponent(JList<? extends Player> list, Player player,
			int index, boolean isSelected, boolean cellHasFocus) {
		lbName.setText(player.getName());
		
		  // set Opaque to change background color of JLabel
	    lbName.setOpaque(true);
	    // when select item
	    if (isSelected) {
	        lbName.setBackground(list.getSelectionBackground());
	        setBackground(list.getSelectionBackground());
	    } else { // when don't select
	        lbName.setBackground(list.getBackground());
	        setBackground(list.getBackground());
	    }
		
		return this;
	}
	
}
