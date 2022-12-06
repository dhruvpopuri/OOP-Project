package flashcards;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Revision {
	
	/**
	 * @wbp.parser.entryPoint
	 */
	public Revision() {
		JFrame frame = new JFrame("Revision");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		frame.setSize(400, 500);
		frame.getContentPane().setLayout(null);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(50, 66, 274, 142);
		frame.getContentPane().add(textArea);
		
		JButton btnNewButton = new JButton("No");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBounds(211, 251, 85, 21);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNextCard = new JButton("Yes");
		btnNextCard.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNextCard.setBounds(81, 251, 85, 21);
		frame.getContentPane().add(btnNextCard);
		
		JLabel lblNewLabel = new JLabel("Got Right Answer?");
		lblNewLabel.setBounds(146, 218, 123, 21);
		frame.getContentPane().add(lblNewLabel);
		
		JButton btnNewButton_1 = new JButton("Home");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_1.setBounds(146, 328, 85, 21);
		frame.getContentPane().add(btnNewButton_1);
		frame.setVisible(true);
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SwingUtilities.invokeLater(Revision::new);

	}
}
