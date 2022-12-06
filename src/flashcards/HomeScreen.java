package flashcards;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JComboBox;

public class HomeScreen {

	public static List<String> categ =new ArrayList<String>();  
	public static String[] array;
    public static Records records;


	public HomeScreen(Records records) {
		HomeScreen.records = records;
		JFrame frame = new JFrame("Home");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		frame.setSize(400, 500);
		frame.getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("Create New Card");
		btnNewButton.addActionListener(e -> { new FlashCardBuilder(records);
			frame.setVisible(false);
		});
		btnNewButton.setBounds(106, 131, 164, 33);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Start Revision");
		btnNewButton_1.addActionListener(e -> { new Revision();
			frame.setVisible(false);
		});
		btnNewButton_1.setBounds(106, 217, 164, 33);
		frame.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Create new Category");
		btnNewButton_2.addActionListener(e -> { new CreateCategory(records);
			frame.setVisible(false);
		});
		btnNewButton_2.setBounds(106, 304, 164, 33);
		frame.getContentPane().add(btnNewButton_2);
		
		JLabel lblNewLabel_1 = new JLabel("Category");
		lblNewLabel_1.setBounds(10, 30, 114, 13);
		frame.getContentPane().add(lblNewLabel_1);
		
		
		// String test[]={"India","Aus","U.S.A","England","Newzealand"};   
		
  
		JComboBox comboBox = new JComboBox(array);
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
		
		getCategories();
		getArray();
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			   public void run() {
				   new HomeScreen(records);
		   }});
	}

	public static void getCategories() {
        File file = new File("src/flashcards/categories.txt");
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            String line;
            while ((line = br.readLine()) != null) {
				categ.add(line);
            }
            br.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

	public static void getArray(){
		array = categ.toArray(new String[categ.size()]);   
	}
}
