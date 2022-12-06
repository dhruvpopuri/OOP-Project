package flashcards.cards;

import java.util.ArrayList;
import java.util.HashMap;

import flashcards.CardInterface;
import flashcards.User;
import flashcards.Category;
import flashcards.Records;

public class multipleChoice extends Card {
    private String question;
    private String correctAnswer;
    private ArrayList<String> choices;

    public void setChoices(ArrayList<String> choices) {
        this.choices = choices;
    }

    public void addChoice(String choice) {
        this.choices.add(choice);
    }

    public multipleChoice(String name, User createdByUser, boolean isPublic, Category category, String question, String correctAnswer, Records records){
        super(name, createdByUser, isPublic, category, CardType.MULTIPLE_CHOICE, records);
        this.question = question;
        this.correctAnswer = correctAnswer;
        this.choices = new ArrayList<String>();
    }

    @Override
    public HashMap<String, String> displayQuestion() {
        HashMap<String, String> hs = new HashMap<String, String>();
        hs.put("question", this.question);
        hs.put("correctAnswer", this.correctAnswer);

        int choice_index = 1;
        for(String choice: this.choices) {
            hs.put("Choice " + Integer.toString(choice_index), choice);
        }

        hs.put("currentTimeInterval", Integer.toString(super.getCurrentTrainingInterval())); // For the frontend to decide how long to show the card, currently stored as a string
        return hs;
    }

    public void editCard(String questionText, String answerText) {
        this.question = questionText;
        this.correctAnswer = answerText;
    }
}