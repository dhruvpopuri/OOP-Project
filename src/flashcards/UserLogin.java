package flashcards;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

class LoginThread implements Runnable {

    public Thread theThread;
    private final String username;
    private final String password;
    public boolean stopThread = false;
    
    public static Records records;

    LoginThread(String username, String password, Records myRecords) {
        records = myRecords;
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
        while (!stopThread) {
            try {
                User user = getUser(username, password);
                new HomeScreen(records);
                setStopThread(true);
            } catch (Exception e) {
                System.out.println(e.getMessage() + "Error here");
                theThread.stop();
            }
        }
    }

    public User getUser(String username, String password) throws InvalidUserException {
        // System.out.println(username + " " + password);
        // File file = new File("src/flashcards/users.txt");
        // try {
        //     BufferedReader br = new BufferedReader(new FileReader(file));
        //     String line;
        //     while ((line = br.readLine()) != null) {
        //         String[] strings = line.split(".");
        //         if (strings[0].equals(username) && strings[1].equals(password)) {
        //             br.close();
        //             return true;
        //         }
        //     }
        //     br.close();
        //     return false;
        // } catch (IOException e) {
        //     System.out.println(e.getMessage());
        // }
        // return false;
        for(User user: records.getUsers()) {
            System.out.println(user.getUsername() + username + user.getPassword() + password);
            if(user.getUsername().equals(username) && user.getPassword().equals(password)) {
                Session session = new Session(user);
                records.setSession(session);
                return user;
            }
        }

        throw new InvalidUserException("User does not exist");
    }
}

public class UserLogin {

    private final JFrame userLogin;
    private final JTextField textField;
    private final JPasswordField passwordField;
    public static Records records;

    public UserLogin(Records records) {

        UserLogin.records = records;

        userLogin = new JFrame("User Login");
        userLogin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        userLogin.setSize(400, 500);
        userLogin.getContentPane().setLayout(null);

        JLabel lblNewLabel = new JLabel("UserName");
        lblNewLabel.setBounds(44, 99, 195, 25);
        userLogin.getContentPane().add(lblNewLabel);

        JLabel lblPassword = new JLabel("Password");
        lblPassword.setBounds(44, 225, 199, 25);
        userLogin.getContentPane().add(lblPassword);

        textField = new JTextField();
        textField.setBounds(44, 152, 195, 19);
        userLogin.getContentPane().add(textField);
        textField.setColumns(10);

        passwordField = new JPasswordField();
        passwordField.setBounds(44, 282, 195, 19);
        userLogin.getContentPane().add(passwordField);

        JButton btnNewButton = new JButton("Login");
        btnNewButton.addActionListener(actionEvent -> {
            String username = textField.getText();
            String password = String.valueOf(passwordField.getPassword());
            LoginThread loginThread = new LoginThread(username, password, records);
            loginThread.start();
            try {
                loginThread.theThread.join();
                if(loginThread.stopThread == false) {
                    JOptionPane.showMessageDialog(userLogin, "Invalid Username or Password");
                    new UserLogin(records);
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        btnNewButton.setBounds(154, 355, 85, 21);
        userLogin.getContentPane().add(btnNewButton);
        userLogin.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
                     @Override
                        public void run() {
                            new UserLogin(records);
                    }});
    }
}
