package flashcard_App;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

class LoginThread implements Runnable {

    private Thread theThread;
    private boolean stopThread = false;
    private String username, password;

    LoginThread (String username, String password) {
        this.username = username;
        this.password = password;
    }

    public void start() {
        if (theThread == null) {
            theThread = new Thread(this);
            theThread.start();
        }
    }

    public void setStopThread(boolean aValue) {
        stopThread = aValue;
    }

    @Override
    public void run() {
        while (true) {
            if (stopThread) break;
            try {
                boolean userExists = doesUserExist(username, password);
                if (!userExists) {
                    // Display Incorrect Credentials
                    JOptionPane.showMessageDialog(null, "Invalid Username or Password");
                    setStopThread(true);
                } else {
                    new HomeScreen();
                    setStopThread(true);
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public boolean doesUserExist(String username, String password) {
        File file = new File("flashcard_App/users.txt");
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            String line;
            while ((line = br.readLine()) != null) {
                if (line.split("\\.")[0].equals(username) && line.split("\\.")[1].equals(password)) {
                    br.close();
                    return true;
                }
            }
            br.close();
            return false;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

public class UserLogin {

    private final JFrame userLogin;
    private final JTextField textField;
    private final JPasswordField passwordField;
    private final JButton btnNewButton;

    public UserLogin() {

        userLogin = new JFrame("User Login");
        userLogin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        userLogin.setSize(400, 500);
        userLogin.getContentPane().setLayout(null);

        JLabel lblNewLabel = new JLabel("Email");
        lblNewLabel.setBounds(44, 99, 79, 25);
        userLogin.getContentPane().add(lblNewLabel);

        JLabel lblPassword = new JLabel("Password");
        lblPassword.setBounds(44, 225, 79, 25);
        userLogin.getContentPane().add(lblPassword);

        textField = new JTextField();
        textField.setBounds(44, 152, 195, 19);
        userLogin.getContentPane().add(textField);
        textField.setColumns(10);

        passwordField = new JPasswordField();
        passwordField.setBounds(44, 282, 195, 19);
        userLogin.getContentPane().add(passwordField);

        btnNewButton = new JButton("Login");
        btnNewButton.addActionListener(actionEvent -> {
            String username = textField.getText();
            String password = String.valueOf(passwordField.getPassword());
            LoginThread loginThread = new LoginThread(username, password);
            loginThread.start();
        });
        btnNewButton.setBounds(154, 355, 85, 21);
        userLogin.getContentPane().add(btnNewButton);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(UserLogin::new);
    }
}
