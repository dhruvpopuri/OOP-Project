package flashcards;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import java.io.*;

public class StartScreen {

	public static Records records;

	public StartScreen() {
		JFrame signIn = new JFrame("Flash Card");
		signIn.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		signIn.setSize(400, 500);
		signIn.getContentPane().setLayout(null);
		
		JButton LoginButton = new JButton("User Login");
		LoginButton.addActionListener(e -> new UserLogin());
		LoginButton.setBounds(130, 122, 110, 34);
		signIn.getContentPane().add(LoginButton);
		
		JButton SignUpButton = new JButton("User SignUp");
		SignUpButton.addActionListener(e -> new UserSignUp());
		SignUpButton.setBounds(130, 196, 110, 34);
		signIn.getContentPane().add(SignUpButton);
		
		JButton AdminButton = new JButton("Admin Login");
		AdminButton.addActionListener(e -> new AdminLogin());
		AdminButton.setBounds(130, 268, 110, 34);
		signIn.getContentPane().add(AdminButton);
		signIn.setVisible(true);
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(StartScreen::new);
		try {
			FileInputStream fileIn = new FileInputStream("records.ser");
			ObjectInputStream in = new ObjectInputStream(fileIn);
			records = (Records) in.readObject();
			in.close();
			fileIn.close();
		} catch (FileNotFoundException f) {
			records = new Records();
		} catch (IOException i) {
			i.printStackTrace();
			return;
		} catch (ClassNotFoundException c) {
			System.out.println("Records class not found");
			c.printStackTrace();
			return;
		}
		// Writing to database after all the work
		try {
			FileOutputStream fileOut =
					new FileOutputStream("records.ser");
			ObjectOutputStream out = new ObjectOutputStream(fileOut);
			out.writeObject(records);
			out.close();
			fileOut.close();
			System.out.printf("Serialized data is saved in records.ser");
		} catch (IOException i) {
			i.printStackTrace();
		}
	}
}
