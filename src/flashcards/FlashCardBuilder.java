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
		scrollpane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollpane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		
		JScrollPane scrollpane_question = new JScrollPane(question);
		scrollpane_question.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

		scrollpane_question.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		
		JButton nextButton = new JButton("Next Card");
		JButton homeButton = new JButton("Home");
		
		cardList = new ArrayList<Card>();
		
		JLabel qlabel = new JLabel("Question");
		JLabel alabel = new JLabel("Answer");
		
		
		mainPanel.add(qlabel);
		mainPanel.add(scrollpane_question);
		mainPanel.add(alabel);
		mainPanel.add(scrollpane);
		mainPanel.add(nextButton);
		mainPanel.add(homeButton);
		nextButton.addActionListener(new NextCardListener(cardList, question, answer));
		
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
