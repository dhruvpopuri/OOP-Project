package flashcard_App;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.JTextArea;
import javax.swing.JButton;

public class Revision {
	

	private final JFrame frame;
	
	public Revision() {
		frame = new JFrame("Revision");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		frame.setSize(400, 500);
		frame.getContentPane().setLayout(null);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(50, 66, 274, 142);
		frame.getContentPane().add(textArea);
		
		JButton btnNewButton = new JButton("Get Answer");
		btnNewButton.setBounds(141, 291, 85, 21);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNextCard = new JButton("Next Card");
		btnNextCard.setBounds(141, 347, 85, 21);
		frame.getContentPane().add(btnNextCard);
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new Revision();
			}
		});

	}
}
