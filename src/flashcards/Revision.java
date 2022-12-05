package flashcards;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;
import javax.swing.JTextArea;
import javax.swing.JButton;

public class Revision {
	
	public Revision() {
		JFrame frame = new JFrame("Revision");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		frame.setSize(400, 500);
		frame.getContentPane().setLayout(null);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(50, 66, 274, 142);
		frame.getContentPane().add(textArea);
		
		JButton btnNewButton = new JButton("No");
		btnNewButton.setBounds(211, 251, 85, 21);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNextCard = new JButton("Yes");
		btnNextCard.setBounds(81, 251, 85, 21);
		frame.getContentPane().add(btnNextCard);
		
		JLabel lblNewLabel = new JLabel("Got Right Answer?");
		lblNewLabel.setBounds(146, 218, 123, 21);
		frame.getContentPane().add(lblNewLabel);
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SwingUtilities.invokeLater(Revision::new);

	}
}
