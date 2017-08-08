package typpingapplication;


import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class TypingTutor extends JFrame implements ActionListener {

	private JLabel greet;
	private JButton basicsBt;
	private JButton keywordsBt;
	private JButton advanceBt;
	private JButton testBt;
	private JButton exitBt;
	private TTprocess process;
	public boolean runningclient = false;
	public Image ic;

	public TypingTutor() {
		super("Typing Tutor - Java Programming");
		ic = Toolkit.getDefaultToolkit().getImage(getClass().getResource("ticon.png"));
		ImageIcon icon = new ImageIcon(ic);
		setIconImage(icon.getImage());
		setLayout(new GridLayout(2,3));
		
		greet = new JLabel("Hello !Let's Get Started");		
		add(greet);


		basicsBt = new JButton("BASIC");
		basicsBt.setToolTipText("Start with alphabets and characters");
		basicsBt.addActionListener(this);
		add(basicsBt);

		keywordsBt = new JButton("Intermediate");
		keywordsBt.setToolTipText("Practice keywords");
		keywordsBt.addActionListener(this);
		add(keywordsBt);

		advanceBt = new JButton("Advance");
		advanceBt.setToolTipText("Practice commands with proper syntax");
		advanceBt.addActionListener(this);
		add(advanceBt);

		testBt = new JButton("Test");
		testBt.setToolTipText("Test your typing skills");
		testBt.addActionListener(this);
		add(testBt);

		exitBt = new JButton("Exit");
		exitBt.addActionListener(this);
		add(exitBt);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == basicsBt) {
			if (!this.runningclient) {
				this.runningclient = true;
				openBasicsWin();
			}

		} else if (e.getSource() == keywordsBt) {
			if (!this.runningclient) {
				this.runningclient = true;
				openInterWin();
			}

		} else if (e.getSource() == advanceBt) {
			if (!this.runningclient) {
				this.runningclient = true;
				openAdvWin();
			}

		} else if (e.getSource() == testBt) {
			if (!this.runningclient) {
				this.runningclient = true;
				openTestWin();
			}

		} else if (e.getSource() == exitBt) {
			int response = JOptionPane.showOptionDialog(null, "DO you want to exit?", "Typing Tutor", 0, 3, null, null,
					null);
			// response: Yes = 0,NO =1,close =-1
			if (response == 0) {
				if (process != null) {
					process.dispose();
				}
				this.dispose();
			}

		}

	}

	public void openBasicsWin() {
		process = new TTBasics(this);
		Dimension screensize = Toolkit.getDefaultToolkit().getScreenSize();
		process.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		process.setSize(screensize.width / 2, screensize.height / 2);
		process.setResizable(false);
		process.setLocationRelativeTo(null);
		process.setVisible(true);

	}

	public void openInterWin() {
		process = new TTInter(this);
		Dimension screensize = Toolkit.getDefaultToolkit().getScreenSize();
		process.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		process.setSize(screensize.width / 2, screensize.height / 2);
		process.setResizable(false);
		process.setLocationRelativeTo(null);
		process.setVisible(true);

	}

	public void openAdvWin() {
		process = new TTAdv(this);
		Dimension screensize = Toolkit.getDefaultToolkit().getScreenSize();
		process.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		process.setSize(screensize.width / 2, screensize.height / 2);
		process.setResizable(false);
		process.setLocationRelativeTo(null);
		process.setVisible(true);

	}

	public void openTestWin() {
		process = new TTtest(this);
		Dimension screensize = Toolkit.getDefaultToolkit().getScreenSize();
		process.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		process.setSize(screensize.width / 2, screensize.height / 2);
		process.setResizable(false);
		process.setLocationRelativeTo(null);
		process.setVisible(true);

	}

}
