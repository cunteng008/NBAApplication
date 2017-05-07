//Main.java

import java.awt.Container;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.util.HashMap;

import javax.swing.JFrame;

import UI.WindowMain;
import UI.WindowRoot;
import chart.BarChart;

public class Main {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {					
					WindowRoot windowsMain = new WindowMain();					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
