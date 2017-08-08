package typpingapplication;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class TTBasics extends TTprocess{
	
	protected static String feeder= "a s d f j k l ; e i r u t y c , g h v n S L C I N \" q p w o x . z / ; . , = [ ] 1 - { } ( ) ! + @ _ # < > * % \\\\ && || <= => // /* */";
	
	public TTBasics(TypingTutor mainwin){
		super.setTitle("Typing Tutor : Basics");
		setIconImage(mainwin.ic);
		setLayout(new GridLayout(6, 1));

		Font font = new Font(null, 0, 35);
		
		this.ttmainwn = mainwin;
		
		timerlb = new JLabel();
		timerlb.setOpaque(true);
		timerlb.setForeground(Color.blue);
		timerlb.setBackground(Color.white);
		timerlb.setFont(font);
		timerlb.setText("5");
		add(timerlb);

		sample = new JLabel();
		sample.setOpaque(true);
		sample.setForeground(Color.black);
		sample.setBackground(Color.lightGray);
		sample.setFont(font);
		sample.setText("Press Start");
		add(sample);

		typetf = new JTextField();
		typetf.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				inputstr =typetf.getText();
				samplestr = sample.getText();
				if(inputstr.equals(samplestr))
				{
					correctinput();
				}
				else{
					incorrectinput();
				}
			}
		});
		typetf.addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
		typetf.setFont(font);
		typetf.getText();
		add(typetf);

		startBt = new JButton("START");
		startBt.addActionListener(this);
		add(startBt);

		restartBT = new JButton("Restart");
		restartBT.addActionListener(this);
		add(restartBT);

		closeBt = new JButton("CLOSE");
		closeBt.addActionListener(this);
		add(closeBt);
		data = feeder.split(" ");
		initGame();
	}

	
	
	

}
