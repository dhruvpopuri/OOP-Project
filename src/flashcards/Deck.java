package flashcards;

import java.util.ArrayList;

import flashcards.cards.Card;
import flashcards.InvalidUserException;

public class Deck implements java.io.Serializable {
    private String name;
    private ArrayList<Card> cards;
    private User owner;

    Deck(String name, User user, Records records) {
        this.name = name;
        this.cards = new ArrayList<Card>();
        this.owner = user;
        records.addDeck(this);
        user.addDeck(this);
    }

    public String getName() {
        return this.name;
    }

    public void addCard(Card card) {
        cards.add(card);
    }

    public ArrayList<Card> getCards() {
        return this.cards;
    }

    public void deleteCard(Card card, User user) throws InvalidUserException {
        if(owner.equals(user) || card.getCreator().equals(user)) {
            int index = cards.indexOf(card);
            if(index != -1){
                cards.remove(index);
            } else {
                System.out.println("Card does not exist");
            }
        } else {
            throw new InvalidUserException("Only the creator of the card or the owner of the deck can delete it");
        }
    }

    public Card getNextCard(Card c) {
        int index = this.cards.indexOf(c)+1;
        return this.cards.get(index);
    }
}
