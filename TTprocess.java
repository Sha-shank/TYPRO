package typpingapplication;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Time;
import java.sql.Timestamp;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.Timer;

public abstract class TTprocess extends JFrame implements ActionListener {
	protected JButton startBt;
	protected JButton restartBT;
	protected JButton closeBt;
	protected JLabel timerlb;
	protected JLabel sample;
	protected JTextField typetf;

	// protected static String feeder= "a s d f j k l ; e i r u t y c , g h v n
	// S L C I N \" q p w o x . z / ; . , = [ ] 1 - { } ( ) ! + @ _ # * % \\ &&
	// || < > <= => # // /* */";
	protected static int count = 0;

	protected TypingTutor ttmainwn;
	public boolean running;
	public String[] data;
	public int timerleft;
	public Timer timer;
	public String inputstr;
	public String samplestr;
	public float corcount;
	public float incCount;
	public float timetakken;

	
	public void correctinput() {
		corcount++;

		count++;
		if (count >= data.length) {
			count = 0;
		}
		sample.setForeground(Color.black);
		String nextWord = data[count];
		sample.setText(nextWord);
		typetf.setText("");
	}

	public void incorrectinput() {
		incCount++;
		sample.setForeground(Color.red);
		typetf.setText("");

	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == closeBt) {
			ttmainwn.runningclient = false;
			this.dispose();
		}
		if (e.getSource() == startBt) {
			handleStart();
		} else if (e.getSource() == restartBT) {
			handleStop();
		} else if (e.getSource() == timer) {
			handleTimer();
		}

	}

	protected void initGame() {
		
		
		timerleft = 60;
		running = false;
		count = 0;
		timetakken = 0;
		timer = new Timer(1000, this);

		timerlb.setText("Timer:" + timerleft);
		sample.setText("");
		typetf.setText("");

		startBt.setText("START");
		restartBT.setText("Restart");
		restartBT.setEnabled(false);

	}

	private void handleStart() {

		if (running) {
			running = false;
			timer.stop();
			typetf.setEditable(false);
			timerlb.setText("Timer:" + timerleft);

			startBt.setText("RESUME");
			restartBT.setText("Restart");
		} else {
			running = true;
			if (timetakken == 0) {
				String firstword = data[count];
				sample.setText(firstword);
			}

			timer.start();
			restartBT.setEnabled(true);
			typetf.setEditable(true);
			timerlb.setText("Timer:" + timerleft);

			startBt.setText("PAUSE");
			restartBT.setText("Restart");

		}
	}

	private void handleStop() {
		running = false;
		timer.stop();
		typetf.setEditable(false);
		timerlb.setText("Timer:" + timerleft);

		startBt.setText("RESUME");
		restartBT.setText("Restart");

		int choice = JOptionPane.showOptionDialog(null, "Do you want to restart?", "Typing Tutor", 0, 3, null, null,
				null);
		if (choice == JOptionPane.YES_OPTION) {
			initGame();
		} else {
			handleStart();
		}
	}

	private void handleTimer() {
		if (timerleft > 0) {
			timerleft--;
			timetakken++;
			
			
			
			typetf.setFocusable(true);
			timerlb.setText("Timer:" + String.valueOf(timerleft));

		} else {
			showScore();
			initGame();
		}

	}
	
	public void showScore() {
		float totalcount = corcount + incCount;
		float mins = timetakken / 60;
		float acc = (corcount / totalcount) * 100;
		int speed = (int) (totalcount / mins);
		int netspeed = (int) (corcount / mins);
		JOptionPane.showMessageDialog(null, "Session Complete!\n\nSpeed = " + speed + "wpm  Accuracy = " + acc
				+ "%  Net Speed = " + netspeed + "wpm");
	}

}
