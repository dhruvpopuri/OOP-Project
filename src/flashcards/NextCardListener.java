package flashcards;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JTextArea;
import flashcards.cards.Card;

public class NextCardListener implements ActionListener {
	
	private final JTextArea question;
	private final JTextArea answer;
	private final ArrayList<Card> cardList;
	public NextCardListener(ArrayList<Card> cardList, JTextArea question, JTextArea answer) {
		this.cardList = cardList;
		this.question = question;
		this.answer = answer;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("Button Clicked");
		//  TO DO Call constructor with appropriate arguments
		// Card card = new Card();
		// c:ardList.add(card);
		clearCard();
	}

	private void clearCard() {
		// TODO Auto-generated method stub
		question.setText("");
		answer.setText("");
		question.requestFocus();
		
	}

}
