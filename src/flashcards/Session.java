package flashcards;

public class Session {
    private User currentLoggedInUser;

    public Session(User user) {
        this.currentLoggedInUser = user;
    }

    public User getCurrentLoggedInUser() {
        return this.currentLoggedInUser;
    }
}
