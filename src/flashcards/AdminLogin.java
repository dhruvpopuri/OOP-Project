package flashcards;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;

public class AdminLogin {

	private final JTextField textField;
	private final JPasswordField passwordField;
    public static Records records;
	
	public AdminLogin(Records records) {
		AdminLogin.records = records;
		JFrame frame = new JFrame("Admin Login");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		frame.setSize(400, 500);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("UserName");
		lblNewLabel.setBounds(45, 100, 45, 13);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(45, 216, 107, 13);
		frame.getContentPane().add(lblPassword);
		
		textField = new JTextField();
		textField.setBounds(45, 152, 230, 19);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(45, 270, 230, 19);
		frame.getContentPane().add(passwordField);
		
		JButton btnNewButton = new JButton("Login");
		btnNewButton.addActionListener(actionEvent -> {
			try {
				String username = textField.getText();
				String password = String.valueOf(passwordField.getPassword());
				if (username.equals("admin") && password.equals("5678")) new HomeScreen(records);
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		});
		btnNewButton.setBounds(140, 355, 85, 21);
		frame.getContentPane().add(btnNewButton);
		frame.setVisible(true);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new AdminLogin(records);
			}
		});
	}
}