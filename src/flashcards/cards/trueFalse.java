package flashcards.cards;

import java.util.HashMap;

import flashcards.CardInterface;
import flashcards.User;
import flashcards.Category;
import flashcards.Records;

public class trueFalse extends Card {
    private String question;
    private boolean correctAnswer;

    trueFalse(String name, User createdByUser, boolean isPublic, Category category, String question, boolean correctAnswer, Records records) {
        super(name, createdByUser, isPublic, category, records);
        this.question = question;
        this.correctAnswer = correctAnswer;
    }

    @Override
    public HashMap<String, String> displayQuestion() {
        HashMap<String, String> hs = new HashMap<String, String>();
        hs.put("question", this.question);
        hs.put("correctAnswer", Boolean.toString(this.correctAnswer));

        return hs;
    }

    public void editCard(String questionText, boolean answer) {
        this.question = questionText;
        this.correctAnswer = answer;
    }
}
