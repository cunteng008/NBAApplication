package listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFileChooser;
import javax.swing.JFrame;

import util.MyParser;

public class OpenFileListener implements ActionListener {
	JFrame frame;
	JFileChooser fileChooser = new JFileChooser();
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
	    }
	}	
}
