import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.SwingUtilities;

public class ShowProgressBar extends JPanel {

  JProgressBar pbar;

  int min = 0;
  int max ;

  public ShowProgressBar(int max) {
	  	pbar = new JProgressBar();
	  	this.max = max;
	    pbar.setMinimum(min);
	    pbar.setMaximum(max);
	    add(pbar);
	    
	    JFrame frame = new JFrame("Progress Bar Example");
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    frame.setContentPane(this);
	    frame.pack();
	    frame.setVisible(true);

	   start();
  }
  private void start(){
	  for (int i = min; i <= max; i++) {
	      final int percent = i;
	      try {
	        SwingUtilities.invokeLater(new Runnable() {
	          public void run() {
	            updateBar(percent);
	          }
	        });
	        Thread.sleep(100);
	      } catch (InterruptedException e) {
	      }
	    }
  }

  public void updateBar(int newValue) {
    pbar.setValue(newValue);
  }

}