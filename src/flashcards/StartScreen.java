package flashcards;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import java.io.*;

public class StartScreen implements java.io.Serializable {

	public Records records;

	public StartScreen() {
		Records records = null;
		try {
			FileInputStream fileIn = new FileInputStream("records.ser");
			ObjectInputStream in = new ObjectInputStream(fileIn);
			records = (Records) in.readObject();
			in.close();
			fileIn.close();
			System.out.println("Reading records.ser");
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

		this.records = records;
		JFrame signIn = new JFrame("Flash Card");
		signIn.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		signIn.setSize(400, 500);
		signIn.getContentPane().setLayout(null);
		
		JButton LoginButton = new JButton("User Login");
		LoginButton.addActionListener(e -> {new UserLogin(this.records);
		signIn.setVisible(false);});
		LoginButton.setBounds(130, 122, 110, 34);
		signIn.getContentPane().add(LoginButton);
		
		JButton SignUpButton = new JButton("User SignUp");
		SignUpButton.addActionListener(e -> {new UserSignUp(this.records);
		signIn.setVisible(false);});
		SignUpButton.setBounds(130, 196, 110, 34);
		signIn.getContentPane().add(SignUpButton);
		
		JButton AdminButton = new JButton("Admin Login");
		AdminButton.addActionListener(e -> {new AdminLogin(this.records); 
		signIn.setVisible(false);});
		AdminButton.setBounds(130, 268, 110, 34);
		signIn.getContentPane().add(AdminButton);
		signIn.setVisible(true);
	}

	public static void main(String[] args) {
		// Writing to database after all the work
		// StartScreen ss = new StartScreen();
		SwingUtilities.invokeLater(StartScreen::new);
		
	}
}
