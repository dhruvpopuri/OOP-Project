package flashcards;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.awt.event.ActionEvent;

public class CreateCategory {
	
	/**
	 * @wbp.parser.entryPoint
	 */

	
    public static Records records;
	public CreateCategory(Records records) {
		CreateCategory.records = records;
		JFrame frame = new JFrame("Create Category");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		frame.setSize(400, 500);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Type new Category");
		lblNewLabel.setBounds(32, 51, 112, 13);
		frame.getContentPane().add(lblNewLabel);
		
		JTextField textField = new JTextField();
		textField.setBounds(32, 136, 293, 65);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("Home");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				new HomeScreen(records);
			}
		});
		btnNewButton.setBounds(59, 280, 85, 21);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String category = textField.getText();
					Category cat = new Category(category, records.getSessions().getCurrentLoggedInUser(), records);
					// addCategory(cat);
					frame.setVisible(false);
					new HomeScreen(records);
				} catch (Exception e2) {
					System.out.println(e2.getMessage());
				}
			}
		});
		btnSave.setBounds(220, 280, 85, 21);
		frame.getContentPane().add(btnSave);
		frame.setVisible(true);
	}

	/**
	 * @wbp.parser.entryPoint
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new CreateCategory(records);
			}
		});
	}

	public void addCategory(Category category) {
        records.addCategory(category);
    }

}
