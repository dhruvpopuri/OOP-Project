package flashcards;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import flashcards.cards.Card;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class SelectDeck {

	public static Records records;
	
	/**
	 * @wbp.parser.entryPoint
	 */
	public SelectDeck(Records records) {
		SelectDeck.records = records;
		User user = records.getSessions().getCurrentLoggedInUser();
		JFrame frame = new JFrame("Revision");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		frame.setSize(400, 500);
		frame.getContentPane().setLayout(null);
		
		JComboBox comboBox = new JComboBox(getDeckArray(user.getUserDecks()));
		comboBox.setBounds(78, 161, 211, 38);
		frame.getContentPane().add(comboBox);
		
		JLabel lblNewLabel = new JLabel("Select Deck to start Revision");
		lblNewLabel.setBounds(78, 118, 179, 33);
		frame.getContentPane().add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Home");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBounds(78, 275, 85, 21);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnStart = new JButton("Start");
		btnStart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String deckName = comboBox.getSelectedItem().toString();
				Deck myDeck = null;
				for(Deck d: records.getSessions().getCurrentLoggedInUser().getUserDecks()) {
					if(d.getName().equals(deckName)) {
						myDeck = d;
					}
				}
				if(myDeck==null) {
					// No such deck found!
					return;
				}
				frame.setVisible(false);
				for(Card card: myDeck.getCards()) {
					new Revision(card, records);
					frame.setVisible(true);
				}
			}
		});
		btnStart.setBounds(204, 275, 85, 21);
		frame.getContentPane().add(btnStart);
		frame.setVisible(true);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			   public void run() {
				   new SelectDeck(records);
		   }});
	}

	public String[] getDeckArray(ArrayList<Deck> deck) {
		for(Deck d: deck) {
			System.out.println(d.getName());
		}
		String[] deckArray = new String[deck.size()];
		int index = 0;
		for(Deck d: deck){
			deckArray[index++] = d.getName();
		} 
		return deckArray;
	}
}