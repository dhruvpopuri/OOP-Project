package flashcards;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.JList;

public class AdminPage {
    /**
     * @wbp.parser.entryPoint
     */
    public AdminPage() {
		JFrame frame = new JFrame("Admin Page");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		frame.setSize(400, 500);
		
		JLabel lblNewLabel = new JLabel("Top Contrebutors");
		frame.getContentPane().add(lblNewLabel, BorderLayout.NORTH);
		
		JList list = new JList();
		frame.getContentPane().add(list, BorderLayout.CENTER);
		// frame.getContentPane().setLayout(null);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		SwingUtilities.invokeLater(AdminPage::new);
	}
}
