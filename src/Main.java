import java.util.*;

class User {
    private String email;
    private String password;
    private ArrayList<Integer> cardsOwnedByUser; //Array of IDs of the cards
    private int id;
    private Map<String, Integer> cardsPerDay; //String or DateTime??


    public User(String email, String password, int id) {
        this.email = email;
        this.password = password;
        this.id = id;
        cardsOwnedByUser = new ArrayList<>();
        cardsPerDay = new HashMap<>();
    }

    public void createCategory(String categoryName){}

    public void createCard(String cardName, int cardType, int categoryId){}

    public ArrayList<Card> getCardsOwned() {} //Decide whether to return Cards array or just an array of IDs

    public ArrayList<Integer> getViewableCategoryCards(int categoryID) {}

    public String editCard(int cardID, Card card) {} //Should replace card object at that cardID

    public String deleteCard(int cardID) {}

    public String togglePublic(int cardID) {}

    public Card nextCard(DateTime now, int categoryID) {}

    public void startRevision() {}
}