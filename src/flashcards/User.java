package flashcards;
import java.util.*;
import java.time.LocalDate;

import flashcards.cards.Card;

public class User implements java.io.Serializable {
    private String email;
    private String password;
    private ArrayList<Integer> cardsOwnedByUser; //Array of IDs of the cards
    private int id;
    private Map<String, Integer> cardsPerDay; //String or DateTime?? String with uniform format of DD/MM/YYYY
    private HashMap<String, Integer> numCardsSeenPerDay;
    private ArrayList<Deck> decks;


    public User(String email, String password, int id) {
        this.email = email;
        this.password = password;
        this.id = id;
        cardsOwnedByUser = new ArrayList<>();
        cardsPerDay = new HashMap<>();
    }

    // public void createCategory(String categoryName){}

    // public void createCard(String cardName, int cardType, int categoryId){}

    // public ArrayList<CardInterface> getCardsOwned() {} //Decide whether to return Cards array or just an array of IDs

    // public ArrayList<Integer> getViewableCategoryCards(int categoryID) {}

    // public String editCard(int cardID, CardInterface card) {} //Should replace card object at that cardID

    // public String deleteCard(int cardID) {}

    // public String togglePublic(int cardID) {}

    // public CardInterface nextCard(DateTime now, int categoryID) {}

    // public void startRevision() {}

    public HashMap<String, String> attemptCard(Card card) {
        // Updating number of cards the user sees per day!
        LocalDate currentDate = LocalDate.now();
        String currentDateString = currentDate.toString();
        if(numCardsSeenPerDay.containsKey(currentDateString)) {
            int currNumber = numCardsSeenPerDay.get(currentDateString);
            numCardsSeenPerDay.put(currentDateString, currNumber+1);
        } else {
            numCardsSeenPerDay.put(currentDateString, 1);
        }

        return card.displayQuestion();
    }

    public HashMap<String, Integer> getNumCardsSeenPerDay() {
        return this.numCardsSeenPerDay;
    }
}