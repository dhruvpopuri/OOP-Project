package flashcards;
import java.awt.BorderLayout;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.*;
import flashcards.cards.Card;
import flashcards.cards.CardType;
import flashcards.cards.fillInTheBlank;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class FlashCardBuilder {
	
	private final JTextArea question;
	private final JTextArea answer;
	private final ArrayList<Card> cardList;
	private final JFrame frame;
	String selectedValue;
    public static Records records;
    private JTextField textField;
	public Deck deck;
	
	
	public FlashCardBuilder(Records records){
		FlashCardBuilder.records = records;
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
		scrollpane.setBounds(11, 208, 363, 82);
		scrollpane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollpane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		
		JScrollPane scrollpane_question = new JScrollPane(question);
		scrollpane_question.setBounds(11, 23, 363, 162);
		scrollpane_question.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

		scrollpane_question.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		
		JButton nextButton = new JButton("Save Card");
		nextButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Category category = new Category(selectedValue, records.getSessions().getCurrentLoggedInUser(), records);
				if(selectedValue.equals(new String("Fill in the blanks"))){
					Card card = new Card(selectedValue, records.getSessions().getCurrentLoggedInUser(), false, category, CardType.FILL_IN_THE_BLANKS, records);
					deck.addCard(card);

				}
				else if(selectedValue.equals(new String("Multiple choice"))){
					Card card = new Card(selectedValue, records.getSessions().getCurrentLoggedInUser(), false, category, CardType.MULTIPLE_CHOICE, records);
					deck.addCard(card);

				}
				else if(selectedValue.equals(new String("One Word"))){
					Card card = new Card(selectedValue, records.getSessions().getCurrentLoggedInUser(), false, category, CardType.ONE_WORD, records);
					deck.addCard(card);

				}
				else if(selectedValue.equals(new String("True/False"))){
					Card card = new Card(selectedValue, records.getSessions().getCurrentLoggedInUser(), false, category, CardType.TRUE_FALSE, records);
					deck.addCard(card);

				}
				
			}
		});
		nextButton.setBounds(61, 410, 118, 21);
		JButton homeButton = new JButton("Home");
		homeButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				frame.setVisible(false);
				new HomeScreen(records);
			}
		});
		homeButton.setBounds(204, 410, 110, 21);
		
		cardList = new ArrayList<Card>();
		
		JLabel qlabel = new JLabel("Question");
		qlabel.setBounds(153, 10, 91, 13);
		JLabel alabel = new JLabel("Answer");
		alabel.setBounds(153, 190, 80, 13);
		mainPanel.setLayout(null);
		
		
		mainPanel.add(qlabel);
		mainPanel.add(scrollpane_question);
		mainPanel.add(alabel);
		mainPanel.add(scrollpane);
		mainPanel.add(nextButton);
		mainPanel.add(homeButton);
		nextButton.addActionListener(new NextCardListener(cardList, question, answer));
		homeButton.addActionListener(e -> {frame.setVisible(false);
		new HomeScreen(records);});
		
		
		frame.getContentPane().add(BorderLayout.CENTER, mainPanel);
		
		String []choice = {"Fill in the blanks","Multiple choice", "One Word", "True/False" };
		JComboBox comboBox = new JComboBox(choice);
		comboBox.setBounds(102, 379, 161, 21);
		mainPanel.add(comboBox);
		selectedValue = comboBox.getSelectedItem().toString();
		
		JLabel lblNewLabel = new JLabel("Card Type");
		lblNewLabel.setBounds(21, 383, 71, 13);
		mainPanel.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(102, 337, 172, 19);
		mainPanel.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Deck Name");
		lblNewLabel_1.setBounds(21, 340, 71, 13);
		mainPanel.add(lblNewLabel_1);
		
		JButton btnCreate = new JButton("Create");
		btnCreate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				deck = new Deck(textField.getText(), records.getSessions().getCurrentLoggedInUser(), records);
				System.out.println("created new deck");
			}
		});
		btnCreate.setBounds(283, 336, 91, 21);
		mainPanel.add(btnCreate);
		frame.setSize(400, 500);
		frame.setVisible(true);
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new FlashCardBuilder(records);
			}
		});
		
		
	}
}
