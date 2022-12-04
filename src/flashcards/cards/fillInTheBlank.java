package flashcards.cards;

import java.util.HashMap;

import flashcards.CardInterface;
import flashcards.User;
import flashcards.Category;
import flashcards.Records;

public class fillInTheBlank extends Card {
    private String question;
    private String correctAnswer;

    fillInTheBlank(String name, User createdByUser, boolean isPublic, Category category, String question, String correctAnswer, Records records){
        super(name, createdByUser, isPublic, category, records);
        this.question = question;
        this.correctAnswer = correctAnswer;
    }

    @Override
    public HashMap<String, String> displayQuestion() {
        HashMap<String, String> hs = new HashMap<String, String>();
        hs.put("question", this.question);
        hs.put("correctAnswer", this.correctAnswer);

        return hs;
    }
}
