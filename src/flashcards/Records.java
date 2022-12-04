package flashcards;

import java.util.ArrayList;
import flashcards.cards.Card;

public class Records implements java.io.Serializable{
    private ArrayList<Category> categories;
    private ArrayList<Card> cards;
    private ArrayList<Deck> decks;

    public void addCategory(Category category) {
        this.categories.add(category);
    }

    public void addCard(Card card) {
        this.cards.add(card);
    }

    public void addDeck(Deck deck) {
        this.decks.add(deck);
    }

}
