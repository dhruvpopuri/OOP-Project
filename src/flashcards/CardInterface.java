package flashcards;

public interface CardInterface {
    CardInterface setData(User createdByUser, int currentTrainingInterval); // Method for the creating user to set the questions
    // CardInterface getData(); // Method to obtain the question data
    // boolean attemptCard(String attemptedAnswer); // Method by which the learner attempts the question
    void makeCardPublic(User user, boolean publicStatus) throws InvalidUserException;
    int getCurrentTrainingInterval();
}
