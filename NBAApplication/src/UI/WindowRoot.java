//WindowRoot.java

package UI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public abstract class WindowRoot extends JFrame{
	protected int width = 1000;
	protected int height = 700;
	
	public WindowRoot(){
		this.getContentPane().setLayout(null);  // 设置默认布局为空
		
	    setSize(width, height);
	    setLocationRelativeTo(null);  // 设置居中显示
	    setVisible(true);
	    setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);  // 只关闭子窗口
	    setResizable(false);
	}	
	
	protected abstract void init();
}
