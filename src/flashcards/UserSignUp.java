package flashcards;

import javax.swing.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class UserSignUp {

    private final JTextField textField;
    private final JTextField textField_1;
    private final JPasswordField textField_2;
    
    public static Records records;

    public UserSignUp(Records records) {

        UserSignUp.records = records;

        JFrame userSignup = new JFrame("User Login");
        userSignup.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        userSignup.setSize(400, 500);
        userSignup.getContentPane().setLayout(null);

        JLabel lblNewLabel = new JLabel("UserName");
        lblNewLabel.setBounds(33, 96, 145, 13);
        userSignup.getContentPane().add(lblNewLabel);

        JLabel lblEmail = new JLabel("Email");
        lblEmail.setBounds(33, 168, 145, 13);
        userSignup.getContentPane().add(lblEmail);

        JLabel lblPassword = new JLabel("Password");
        lblPassword.setBounds(33, 249, 145, 13);
        userSignup.getContentPane().add(lblPassword);

        textField = new JTextField();
        textField.setBounds(33, 119, 237, 19);
        userSignup.getContentPane().add(textField);
        textField.setColumns(10);

        textField_1 = new JTextField();
        textField_1.setColumns(10);
        textField_1.setBounds(33, 199, 237, 19);
        userSignup.getContentPane().add(textField_1);

        textField_2 = new JPasswordField();
        textField_2.setColumns(10);
        textField_2.setBounds(33, 289, 237, 19);
        userSignup.getContentPane().add(textField_2);

        JButton btnNewButton = new JButton("Sign Up");
        btnNewButton.addActionListener(actionEvent -> {
            try {
                String username = textField.getText();
                String email = textField_1.getText();
                String password = String.valueOf(textField_2.getPassword());
                addUser(username, password, email);
                new HomeScreen(records);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        });
        btnNewButton.setBounds(139, 362, 85, 21);
        userSignup.getContentPane().add(btnNewButton);
        userSignup.setVisible(true);
    }

    public void addUser(String username, String password, String email) {
        File file = new File("src/flashcards/users.txt");
        try {
            PrintWriter pw = new PrintWriter(new FileWriter(file, true));
            pw.append(username).append(".").append(password).append(".").append(email).append('\n');
            pw.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
               public void run() {
                   new UserSignUp(records);
           }});
    }
}
