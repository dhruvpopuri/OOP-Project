package flashcards.cards;

import java.util.HashMap;

import flashcards.CardInterface;
import flashcards.Category;
import flashcards.InvalidUserException;
import flashcards.User;
import flashcards.Records;

public class Card implements CardInterface, java.io.Serializable {
    private int card_id;
    private String name;
    private User createdByUser;
    private boolean isPublic;
    private int currentTrainingInterval;
    private Category category;
    private CardType cardType;
    private static int nextId = 1;

    Card(String name, User createdByUser, boolean isPublic, Category category, Records records) {
        this.card_id = nextId;
        nextId++;
        this.name = name;
        this.createdByUser = createdByUser;
        this.isPublic = isPublic;
        this.category = category;
        this.currentTrainingInterval = 5; // Set by default to five seconds

        records.addCard(this); // Adding to records
    }

    public Card setData(User createdByUser, int currentTrainingInterval) {
        this.createdByUser = createdByUser;
        this.currentTrainingInterval = currentTrainingInterval;

        return this;
    }

    // public Card getData() {
    //     System.out.println("Will implement soon");
    //     return this;
    //     // Will implement soon!
    // }

    public void makeCardPublic(User user, boolean publicStatus) throws InvalidUserException {
        if(user.equals(this.createdByUser)) {
            this.isPublic = publicStatus;
        } else {
            throw new InvalidUserException("Only the owner of the card can make it public");
        }
    }

    public User getCreator() {
        return this.createdByUser;
    }

    public int getCurrentTrainingInterval() {
        return this.currentTrainingInterval;
    }

    public void setCurrentTrainingInterval(int interval){
        this.currentTrainingInterval = interval;
    }

    public CardType getCardType() {
        return this.cardType;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public HashMap<String, String> displayQuestion() {
        HashMap<String, String> hs = new HashMap<String, String>();
        System.out.println(name);
        return hs;
    }

    public int getCardID() {
        return this.card_id;
    }

    public void updateLearningInterval(boolean currentAttemptSuccess) {
        if(currentAttemptSuccess) {
            // Will keep reducing till the minimum interval which is 2
            if(currentTrainingInterval>2){
                currentTrainingInterval = currentTrainingInterval - 1;
            }
        } else {
            // Will keep increasing till the maximum interval which is 7 
            if(currentTrainingInterval<7){
                currentTrainingInterval = currentTrainingInterval + 1;
            }
        }
    }
}
