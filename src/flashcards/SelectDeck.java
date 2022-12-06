package flashcards;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SelectDeck {
	
	/**
	 * @wbp.parser.entryPoint
	 */
	public SelectDeck() {
		JFrame frame = new JFrame("Revision");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		frame.setSize(400, 500);
		frame.getContentPane().setLayout(null);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(78, 161, 211, 38);
		frame.getContentPane().add(comboBox);
		
		JLabel lblNewLabel = new JLabel("Select Deck to start Revision");
		lblNewLabel.setBounds(78, 118, 179, 33);
		frame.getContentPane().add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Home");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBounds(78, 275, 85, 21);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnStart = new JButton("Start");
		btnStart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnStart.setBounds(204, 275, 85, 21);
		frame.getContentPane().add(btnStart);
		frame.setVisible(true);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SwingUtilities.invokeLater(SelectDeck::new);
	}
}
