package flashcards;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;

import flashcards.cards.Card;

import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Timer;
import java.util.TimerTask;
import java.awt.event.ActionEvent;

public class Revision {

	public static Records records;
	public static Card card;
	public static Deck deck;
	
	/**
	 * @wbp.parser.entryPoint
	 */
	public Revision(Card card, Records records, Deck deck) {
		Revision.records = records;
		Revision.card = card;
		Revision.deck = deck;
		JFrame frame = new JFrame("Revision");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		frame.setSize(400, 500);
		frame.getContentPane().setLayout(null);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(50, 66, 274, 142);
		frame.getContentPane().add(textArea);

		HashMap<String, String> hs = records.getSessions().getCurrentLoggedInUser().attemptCard(card);
		textArea.setText(hs.get("question"));


		
		try {
			Thread.sleep(card.getCurrentTrainingInterval()*1000);
			textArea.setText(hs.get("answer"));
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		JButton btnNewButton = new JButton("No");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				card.updateLearningInterval(false);
				Card nextCard = deck.getNextCard(card);
				frame.setVisible(false);
				new Revision(nextCard, records, deck);
			}
		});
		btnNewButton.setBounds(211, 251, 85, 21);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNextCard = new JButton("Yes");
		btnNextCard.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				card.updateLearningInterval(true);
				Card nextCard = deck.getNextCard(card);
				frame.setVisible(false);
				new Revision(nextCard, records, deck);
			}
		});
		btnNextCard.setBounds(81, 251, 85, 21);
		frame.getContentPane().add(btnNextCard);
		
		JLabel lblNewLabel = new JLabel("Got Right Answer?");
		lblNewLabel.setBounds(146, 218, 123, 21);
		frame.getContentPane().add(lblNewLabel);
		
		JButton btnNewButton_1 = new JButton("Home");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				new HomeScreen(records);
			}
		});
		btnNewButton_1.setBounds(146, 328, 85, 21);
		frame.getContentPane().add(btnNewButton_1);
		frame.setVisible(true);
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new Revision(card, records, deck);
			}
		});

	}
}
