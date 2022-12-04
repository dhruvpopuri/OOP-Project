package flashcards.cards;

import java.util.HashMap;

import flashcards.CardInterface;
import flashcards.Category;
import flashcards.User;
import flashcards.Records;

public class Card implements CardInterface, java.io.Serializable {
    private int card_id;
    private String name;
    private User createdByUser;
    private boolean isPublic;
    private int currentTrainingInterval;
    private Category category;

    Card(String name, User createdByUser, boolean isPublic, Category category, Records records) {
        this.name = name;
        this.createdByUser = createdByUser;
        this.isPublic = isPublic;
        this.category = category;
        this.currentTrainingInterval = 5; // Set by default to five seconds

        records.addCard(this); // Adding to records
        // To figure out ids
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

    public void makeCardPublic(User user, boolean publicStatus) {
        if(user.equals(this.createdByUser)) {
            this.isPublic = publicStatus;
        }
        // Throw permission error when different user tries to do it
    }

    public int getCurrentTrainingInterval() {
        return this.currentTrainingInterval;
    }

    public void setCurrentTrainingInterval(int interval){
        this.currentTrainingInterval = interval;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public HashMap<String, String> displayQuestion() {
        HashMap<String, String> hs = new HashMap<String, String>();
        System.out.println(name);
        return hs;
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
