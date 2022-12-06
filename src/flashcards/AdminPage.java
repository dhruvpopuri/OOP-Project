package flashcards;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

import javax.swing.JList;

class sortByContribution implements Comparator<User> {
	public int compare(User u1, User u2) {
		return u2.getCardsOwned().size() - u1.getCardsOwned().size();
	}
}

public class AdminPage {
    /**
     * @wbp.parser.entryPoint
     */
    public AdminPage() {
		JFrame frame = new JFrame("Admin Page");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		frame.setSize(400, 500);
		
		JLabel lblNewLabel = new JLabel("Top Contributors");
		frame.getContentPane().add(lblNewLabel, BorderLayout.NORTH);
		
		
		StartScreen screen = new StartScreen();
		Records records = screen.records;
		ArrayList<User> users = records.getUsers();
		Collections.sort(users, new sortByContribution());
		JList list = new JList(users.toArray());
		frame.getContentPane().add(list, BorderLayout.CENTER);

		frame.setVisible(true);
		// frame.getContentPane().setLayout(null);
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(AdminPage::new);
	}
}
