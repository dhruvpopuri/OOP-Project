package flashcards.cards;

import java.util.HashMap;

import flashcards.CardInterface;
import flashcards.User;
import flashcards.Category;
import flashcards.Records;

public class fillInTheBlank extends Card {
    private String question;
    private String correctAnswer;

    public fillInTheBlank(String name, User createdByUser, boolean isPublic, Category category, String question, String correctAnswer, Records records){
        super(name, createdByUser, isPublic, category, CardType.FILL_IN_THE_BLANKS, records);
        this.question = question;
        this.correctAnswer = correctAnswer;
    }

    @Override
    public HashMap<String, String> displayQuestion() {
        HashMap<String, String> hs = new HashMap<String, String>();
        hs.put("question", this.question);
        hs.put("correctAnswer", this.correctAnswer);

        hs.put("currentTimeInterval", Integer.toString(super.getCurrentTrainingInterval()));

        return hs;
    }

    public void editCard(String questionText, String answerText) {
        this.question = questionText;
        this.correctAnswer = answerText;
    }
}