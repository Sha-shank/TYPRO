package typpingapplication;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class TTAdv extends TTprocess {

	private static String feeder = "public static void main Scanner System . in abstract final for while try catch";

	public TTAdv(TypingTutor mainwin) {
		super.setTitle("Typing Tutor : Advance");
		setIconImage(mainwin.ic);
		setLayout(new GridLayout(6, 1));

		Font font = new Font(null, 0, 35);

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
		typetf.setFont(font);
		typetf.getText();
		typetf.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				inputstr = typetf.getText();
				samplestr = sample.getText();
				if (inputstr.equals(samplestr)) {
					correctinput();
				} else {
					incorrectinput();
				}
			}
		});
		add(typetf);

		this.ttmainwn = mainwin;

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
