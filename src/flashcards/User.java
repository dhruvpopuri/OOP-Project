package flashcards;

import java.util.*;
import java.time.LocalDate;

import flashcards.cards.Card;

public class User implements java.io.Serializable {
    private String email;
    private String password;
    private ArrayList<Card> cardsOwnedByUser; //Array of IDs of the cards
    private int id;
    private Map<String, Integer> cardsPerDay; //String or DateTime?? String with uniform format of DD/MM/YYYY
    private HashMap<String, Integer> numCardsSeenPerDay;
    private ArrayList<Deck> decks;
    StartScreen startScreen = new StartScreen();
    Records records = startScreen.records;


    public User(String email, String password, int id, Records records) {
        this.email = email;
        this.password = password;
        this.id = id;
        cardsOwnedByUser = new ArrayList<>();
        cardsPerDay = new HashMap<>();
        records.addUser(this);
    }

    public void createCategory(String categoryName) {
        Category category = new Category(categoryName, this, startScreen.records);
        records.addCategory(category);
    }

    public void createCard(String cardName, int cardType, int categoryId) {
        Card card = new Card(cardName, this, false, records.getCategory(categoryId), records);
        cardsOwnedByUser.add(card);
        records.addCard(card);
    }

    public ArrayList<Card> getCardsOwned() {
        return cardsOwnedByUser;
    }

    public ArrayList<Card> getViewableCategoryCards(int categoryID) {
        ArrayList<Card> viewableCards = new ArrayList<>();
        for (int i = 0; i < cardsOwnedByUser.size(); i++) {
            if(cardsOwnedByUser.get(i).category.category_id == categoryID) {
                viewableCards.add(cardsOwnedByUser.get(i));
            }
        }
        return viewableCards;
    }

    public String editCard(int cardID, Card card) {
        for (int i = 0; i < cardsOwnedByUser.size(); i++) {
            if(cardsOwnedByUser.get(i).getCard_id() == cardID) {
                cardsOwnedByUser.set(i, card);
                records.cards.set(i, card);
                return "Success";
            }
        }
        return "Failure";
    } //Should replace card object at that cardID at this users' list and in records

    public String deleteCard(int cardID) throws InvalidUserException {
        for (int i = 0; i < cardsOwnedByUser.size(); i++) {
            if(cardsOwnedByUser.get(i).getCard_id() == cardID) {
                records.deleteCard(cardsOwnedByUser.get(i), this);
                return "Success";
            }
        }
        return "Failure";
    }

    public CardInterface nextCard(Date now, int categoryID) {
    }

    public void startRevision() {
    }

    public HashMap<String, String> attemptCard(Card card) {
        // Updating number of cards the user sees per day!
        LocalDate currentDate = LocalDate.now();
        String currentDateString = currentDate.toString();
        if (numCardsSeenPerDay.containsKey(currentDateString)) {
            int currNumber = numCardsSeenPerDay.get(currentDateString);
            numCardsSeenPerDay.put(currentDateString, currNumber + 1);
        } else {
            numCardsSeenPerDay.put(currentDateString, 1);
        }

        return card.displayQuestion();
    }

    public ArrayList<Card> attemptDeck(Deck d) {
        return d.getCards();
    }

    public HashMap<String, Integer> getNumCardsSeenPerDay() {
        return this.numCardsSeenPerDay;
    }

    public ArrayList<Deck> getUserDecks() {
        return this.decks;
    }
}