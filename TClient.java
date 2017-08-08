package typpingapplication;


import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JFrame;

public class TClient {
	public static void main(String[] args){
		TypingTutor t = new TypingTutor();
		t.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Dimension screensize = Toolkit.getDefaultToolkit().getScreenSize();
		t.setSize(screensize.width/3,screensize.height/3);
		t.setResizable(false);
		t.setLocationRelativeTo(null);
		t.setVisible(true);
		
		
		
	}


}
