package flashcards;

import java.util.ArrayList;

import flashcards.cards.Card;

public class Category implements java.io.Serializable{
    private String name;
    private ArrayList<Card> publicCards;
    private int numberOfPublicCards;
    private User createdByUser;

    Category(String name, User createdByUser, Records records) {
        this.name = name;
        this.numberOfPublicCards = 0;
        this.createdByUser = createdByUser;
        this.publicCards = new ArrayList<Card>();
        records.addCategory(this);
    }

    public int getNumberOfPublicCards(){
        return this.numberOfPublicCards;
    }

    public ArrayList<Card> getPublicCards() {
        return this.publicCards;
    }

    public ArrayList<Card> addCard(Card card) {
        // Check if card public
        this.publicCards.add(card);
        card.setCategory(this);
        this.numberOfPublicCards = this.numberOfPublicCards + 1;

        return this.publicCards;
    }
}
