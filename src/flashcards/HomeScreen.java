package flashcards;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JComboBox;

public class HomeScreen {


	public HomeScreen() {
		JFrame frame = new JFrame("Home");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		frame.setSize(400, 500);
		frame.getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("Create New Card");
		btnNewButton.addActionListener(e -> { new FlashCardBuilder();
			frame.setVisible(false);
		});
		btnNewButton.setBounds(106, 131, 164, 33);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Start Revision");
		btnNewButton_1.addActionListener(e -> { new Revision();
		});
		btnNewButton_1.setBounds(106, 217, 164, 33);
		frame.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Create new Category");
		btnNewButton_2.addActionListener(e -> { new CreateCategory();
		});
		btnNewButton_2.setBounds(106, 304, 164, 33);
		frame.getContentPane().add(btnNewButton_2);
		
		JLabel lblNewLabel_1 = new JLabel("Category");
		lblNewLabel_1.setBounds(10, 30, 114, 13);
		frame.getContentPane().add(lblNewLabel_1);
		
		
		String test[]={"India","Aus","U.S.A","England","Newzealand"};   
		JComboBox comboBox = new JComboBox(test);
		comboBox.setBounds(106, 20, 164, 33);
		frame.getContentPane().add(comboBox);
		
		JButton btnNewButton_1_1 = new JButton("Log out");
		btnNewButton_1_1.addActionListener(e -> { frame.setVisible(false);
			new StartScreen();
		});
		btnNewButton_1_1.setBounds(106, 387, 164, 33);
		frame.getContentPane().add(btnNewButton_1_1);
		frame.setVisible(true);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SwingUtilities.invokeLater(HomeScreen::new);
	}
}
