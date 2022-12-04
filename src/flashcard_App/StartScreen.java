package flashcard_App;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class StartScreen {

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
	}
}
