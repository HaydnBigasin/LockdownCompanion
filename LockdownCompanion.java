import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;
import javax.swing.border.Border;

public class LockdownCompanion{
	JFrame frame = new JFrame("Lockdown Companion");
	private JPanel framePanel = new JPanel();
	private JPanel journal = new JPanel();
	private JPanel mood = new JPanel();
	CardLayout cl = new CardLayout();
	
	private String uHome;
	private String fSeparator;
	private String path;
	private JLabel lblDay, l1, l2, l3, l4, l5, l6;
	private JPanel buttonPanel;
	private JRadioButton good, lovely, alright, bored, sad, bad;
	private JButton next;
	
	public LockdownCompanion(){
		frame.getContentPane().setBackground(Color.decode("#d8eaf4"));
		frame.setBounds(100, 100, 400, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(null);
		
		framePanel.setLayout(cl);
		framePanel.setBounds(0, 0, 400, 400);
		
		// Journal Page
		
		journal.setBackground(Color.decode("#d8eaf4"));
		journal.setLayout(null);
		
		JLabel createNew = new JLabel("CREATE A NEW JOURNAL ENTRY");
		createNew.setBounds(46, 16, 301, 25);
		createNew.setForeground(SystemColor.controlDkShadow);
		createNew.setFont(new Font("Leelawadee UI", Font.BOLD, 18));
		journal.add(createNew);
		
		JLabel lblTellMeAbout = new JLabel("Tell me about your day!");
		lblTellMeAbout.setForeground(SystemColor.controlDkShadow);
		lblTellMeAbout.setFont(new Font("Leelawadee UI", Font.BOLD, 18));
		lblTellMeAbout.setBounds(85, 55, 208, 25);
		journal.add(lblTellMeAbout);
		
		JPanel panel = new JPanel();
		panel.setLayout(new BorderLayout());
		panel.setBounds(23, 96, 337, 187);
		JTextArea txt = new JTextArea();
		JScrollPane scroll = new JScrollPane(txt);
		scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		Border border = BorderFactory.createLineBorder(Color.BLACK);
	    txt.setBorder(BorderFactory.createCompoundBorder(border, BorderFactory.createEmptyBorder(5, 5, 5, 5)));
	    txt.setLineWrap(true);
	    txt.setWrapStyleWord(true);
		txt.setForeground(new Color(105, 105, 105));
		txt.setFont(new Font("MS Gothic", Font.PLAIN, 13));
		txt.setText("How was your day? Type here...");
		txt.setBackground(new Color(255, 250, 250));
		panel.add(scroll);
		journal.add(panel);
		
		JButton btnNext = new JButton("Next");
		btnNext.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				cl.show(framePanel, "2");
			}
		});
		btnNext.setForeground(new Color(240, 255, 255));
		btnNext.setFont(new Font("Impact", Font.PLAIN, 13));
		btnNext.setBackground(new Color(119, 136, 153));
		btnNext.setBounds(292, 304, 60, 30);
		journal.add(btnNext);
		
		JButton btnSave = new JButton("Save");
		btnSave.setForeground(new Color(240, 255, 255));
		btnSave.setFont(new Font("Impact", Font.PLAIN, 13));
		btnSave.setBackground(new Color(143, 188, 143));
		btnSave.setBounds(33, 304, 60, 30);
		journal.add(btnSave);
		
		// Mood Rater Page
		
		mood.setFont(new Font("Leelawadee", Font.BOLD, 10));
		mood.setBackground(Color.decode("#d8eaf4"));
		
		lblDay = new JLabel("How would you rate your day? ");
		lblDay.setForeground(new Color(105, 105, 105));
		lblDay.setBounds(60, -17, 266, 91);
		lblDay.setFont(new Font("Leelawadee UI", Font.BOLD, 18));
		
		uHome = System.getProperty("user.home"); // Platform-Flexible Default User Home Directory
		fSeparator = System.getProperty("file.separator"); // Platform-Flexible File Separator
		path = uHome + fSeparator + "Lockdown Companion" + fSeparator + "icons" + fSeparator;
		
		buttonPanel = new JPanel();
		buttonPanel.setLayout(new GridLayout(4, 3));
		buttonPanel.setBounds(42, 59, 300, 225);
		buttonPanel.setAlignmentX(JPanel.CENTER_ALIGNMENT);
		buttonPanel.setOpaque(false);
		
		l1 = new JLabel();
		l1.setIcon(new ImageIcon(path + "good.png"));
		l1.setHorizontalAlignment(JLabel.CENTER);
		good = new JRadioButton("Good");
		good.setForeground(new Color(119, 136, 153));
		good.setFont(new Font("Raleway", Font.BOLD, 12));
		good.setHorizontalAlignment(JButton.CENTER);
		good.setOpaque(false);
		
		l2 = new JLabel();
		l2.setIcon(new ImageIcon(path + "lovely.png"));
		l2.setHorizontalAlignment(JLabel.CENTER);
		lovely = new JRadioButton("Lovely");
		lovely.setForeground(new Color(119, 136, 153));
		lovely.setFont(new Font("Raleway", Font.BOLD, 12));
		lovely.setHorizontalAlignment(JButton.CENTER);
		lovely.setOpaque(false);
		
		l3 = new JLabel();
		l3.setIcon(new ImageIcon(path + "alright.png"));
		l3.setHorizontalAlignment(JLabel.CENTER);
		alright = new JRadioButton("Alright");
		alright.setForeground(new Color(119, 136, 153));
		alright.setFont(new Font("Raleway", Font.BOLD, 12));
		alright.setHorizontalAlignment(JButton.CENTER);
		alright.setOpaque(false);
		
		l4 = new JLabel();
		l4.setIcon(new ImageIcon(path + "bored.png"));
		l4.setHorizontalAlignment(JLabel.CENTER);
		bored = new JRadioButton("Bored");
		bored.setForeground(new Color(119, 136, 153));
		bored.setFont(new Font("Raleway", Font.BOLD, 12));
		bored.setHorizontalAlignment(JButton.CENTER);
		bored.setOpaque(false);
		
		l5 = new JLabel();
		l5.setIcon(new ImageIcon(path + "sad.png"));
		l5.setHorizontalAlignment(JLabel.CENTER);
		sad = new JRadioButton("Sad");
		sad.setForeground(new Color(119, 136, 153));
		sad.setFont(new Font("Raleway", Font.BOLD, 12));
		sad.setHorizontalAlignment(JButton.CENTER);
		sad.setOpaque(false);
		
		l6 = new JLabel();
		l6.setIcon(new ImageIcon(path + "bad.png"));
		l6.setHorizontalAlignment(JLabel.CENTER);
		bad = new JRadioButton("Bad");
		bad.setForeground(new Color(119, 136, 153));
		bad.setFont(new Font("Raleway", Font.BOLD, 12));
		bad.setHorizontalAlignment(JButton.CENTER);
		bad.setOpaque(false);
		
		next = new JButton("Next");
		next.setBackground(new Color(119, 136, 153));
		next.setForeground(new Color(240, 255, 255));
		next.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		next.setBounds(292, 304, 60, 30);
		next.setFont(new Font("Impact", Font.PLAIN, 13));
		mood.add(next);
		
		ButtonGroup group = new ButtonGroup();
		group.add(good);
		group.add(alright);
		group.add(lovely);
		group.add(sad);
		group.add(bored);
		group.add(bad);
		
		buttonPanel.add(l1);
		buttonPanel.add(l2);
		buttonPanel.add(l3);
		buttonPanel.add(good);
		buttonPanel.add(lovely);
		buttonPanel.add(alright);
		buttonPanel.add(l4);
		buttonPanel.add(l5);
		buttonPanel.add(l6);
		buttonPanel.add(bored);
		buttonPanel.add(sad);
		buttonPanel.add(bad);
				
		mood.add(lblDay);
		mood.add(buttonPanel);

		mood.setLayout(null);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				cl.show(framePanel, "1");
			}
		});
		btnBack.setForeground(new Color(240, 255, 255));
		btnBack.setFont(new Font("Impact", Font.PLAIN, 13));
		btnBack.setBackground(new Color(119, 136, 153));
		btnBack.setBounds(33, 304, 60, 30);
		mood.add(btnBack);
		
		frame.add(framePanel);
		framePanel.add(journal, "1");
		framePanel.add(mood, "2");
		cl.show(framePanel, "1");
		
		frame.setVisible(true);
	}
	
	public static void main(String[] args){
		SwingUtilities.invokeLater(new Runnable(){
			@Override
			public void run(){
				new LockdownCompanion();
			}
		});
	}
}