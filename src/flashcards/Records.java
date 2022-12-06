package flashcards;

import java.util.ArrayList;
import java.util.concurrent.Flow.Subscriber;

import flashcards.cards.Card;

import java.io.FileOutputStream;
import java.io.*;

public class Records implements java.io.Serializable {
    private ArrayList<Category> categories;
    public ArrayList<Card> cards;
    private ArrayList<Deck> decks;
    private ArrayList<User> users;
    private Session activeSession;

    Records() {
        categories = new ArrayList<Category>();
        cards = new ArrayList<Card>();
        decks = new ArrayList<Deck>();
        users = new ArrayList<User>();
    }

    public ArrayList<User> getUsers() {
        return this.users;
    }

    public void addCategory(Category category) {
        this.categories.add(category);
    }

    public void addCard(Card card) {
        this.cards.add(card);
    }

    public void addUser(User user) {
        System.out.println("Adding user");
        this.users.add(user);
        for(User u: this.users) {
            System.out.println(u.getUsername());
        }
    }

    // public static void saveToDB(Records records) {
    //     try {
	// 		FileOutputStream fileOut =
	// 				new FileOutputStream("records.ser");
	// 		ObjectOutputStream out = new ObjectOutputStream(fileOut);
	// 		out.writeObject(records);
	// 		out.close();
	// 		fileOut.close();
	// 		System.out.printf("Serialized data is saved in records.ser");
	// 	} catch (IOException i) {
	// 		i.printStackTrace();
	// 	}
    // }

    public Session getSessions() {
        return this.activeSession;
    }

    public void setSession(Session session) {
        this.activeSession = session;
    }

    public void deleteCard(Card card, User user) throws InvalidUserException {
        if(card.getCreator().equals(user)){
            int index = this.cards.indexOf(card);
            if(index != -1) {
                cards.remove(index);
            } // Else throw exception

            // Deleting the card from all the decks as well!

            for(Deck deck: decks) {
                deck.deleteCard(card, user);
            }
        } else {
            throw new InvalidUserException("User is not the owner of the card");
        }

    }
    public void addDeck(Deck deck) {
        this.decks.add(deck);
    }

    public Category getCategory(int categoryId) {
        Category _category = null;
        for (Category category: categories) {
            if(category.category_id == categoryId) _category = category;
        }
        return _category;
    }

    public ArrayList<Category> getCategories() {
        return this.categories;
    }
}