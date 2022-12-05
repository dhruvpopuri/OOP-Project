package flashcards;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class AdminPage {
    public AdminPage() {
		JFrame frame = new JFrame("Admin Page");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		frame.setSize(400, 500);
		// frame.getContentPane().setLayout(null);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		SwingUtilities.invokeLater(AdminPage::new);
	}
}
