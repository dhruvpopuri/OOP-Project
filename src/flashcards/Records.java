package flashcards;

import java.util.ArrayList;
import flashcards.cards.Card;

public class Records implements java.io.Serializable{
    private ArrayList<Category> categories;
    private ArrayList<Card> cards;
    private ArrayList<Deck> decks;

    Records() {
        categories = new ArrayList<Category>();
        cards = new ArrayList<Card>();
        decks = new ArrayList<Deck>();
    }

    public void addCategory(Category category) {
        this.categories.add(category);
    }

    public void addCard(Card card) {
        this.cards.add(card);
    }

    public void deleteCard(Card card) {
        // Also check if user is the owner
        
        int index = this.cards.indexOf(card);
        if(index != -1) {
            cards.remove(index);
        } // Else throw exception

        // Deleting the card from all the decks as well!

        for(Deck deck: decks) {
            deck.deleteCard(card);
        }
    }

    public void addDeck(Deck deck) {
        this.decks.add(deck);
    }

}
