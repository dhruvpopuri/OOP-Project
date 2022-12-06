package flashcards;
import java.awt.BorderLayout;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.*;
import flashcards.cards.Card;


public class FlashCardBuilder {
	
	private final JTextArea question;
	private final JTextArea answer;
	private final ArrayList<Card> cardList;
	private final JFrame frame;
	
	
	public FlashCardBuilder(){
		frame = new JFrame("Flash Card");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel mainPanel = new JPanel();
		
		Font getFont = new Font("Helvetica Neue", Font.BOLD, 20);
		question = new JTextArea(6,20);
		question.setLineWrap(true);
		question.setWrapStyleWord(true);
		question.setFont(getFont);
		

		answer = new JTextArea(6,20);
		answer.setLineWrap(true);
		answer.setWrapStyleWord(true);
		answer.setFont(getFont);
		
		JScrollPane scrollpane = new JScrollPane(answer);
		scrollpane.setBounds(11, 208, 363, 162);
		scrollpane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollpane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		
		JScrollPane scrollpane_question = new JScrollPane(question);
		scrollpane_question.setBounds(11, 23, 363, 162);
		scrollpane_question.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

		scrollpane_question.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		
		JButton nextButton = new JButton("Next Card");
		nextButton.setBounds(102, 410, 77, 21);
		JButton homeButton = new JButton("Home");
		homeButton.setBounds(204, 410, 59, 21);
		
		cardList = new ArrayList<Card>();
		
		JLabel qlabel = new JLabel("Question");
		qlabel.setBounds(173, 5, 40, 13);
		JLabel alabel = new JLabel("Answer");
		alabel.setBounds(176, 190, 34, 13);
		mainPanel.setLayout(null);
		
		
		mainPanel.add(qlabel);
		mainPanel.add(scrollpane_question);
		mainPanel.add(alabel);
		mainPanel.add(scrollpane);
		mainPanel.add(nextButton);
		mainPanel.add(homeButton);
		nextButton.addActionListener(new NextCardListener(cardList, question, answer));
		homeButton.addActionListener(e -> {frame.setVisible(false);
		new HomeScreen();});
		
		JMenuBar menuBar = new JMenuBar();
		JMenu cardMenu = new JMenu("Cards");

		JMenuItem newMenuItem = new JMenuItem("New");
		JMenuItem saveMenuItem = new JMenuItem("Save");
		
		cardMenu.add(newMenuItem);
		cardMenu.add(saveMenuItem);

		menuBar.add(cardMenu);
		frame.setJMenuBar(menuBar);
		
		newMenuItem.addActionListener(new NewMenuItemListener());
		saveMenuItem.addActionListener(new SaveMenuItemListener());
		
		
		frame.getContentPane().add(BorderLayout.CENTER, mainPanel);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(102, 379, 161, 21);
		mainPanel.add(comboBox);
		
		JLabel lblNewLabel = new JLabel("Card Type");
		lblNewLabel.setBounds(21, 383, 71, 13);
		mainPanel.add(lblNewLabel);
		frame.setSize(400, 500);
		frame.setVisible(true);
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new FlashCardBuilder();
			}
		});
		
		
	}

}
