/*
    Names: Alexander Truscott, Jun Law
    File: Login.java

    
 */

import java.awt.Color;
import java.awt.Font;
import java.awt.event.*;
import java.util.HashMap;
import java.util.Scanner;
import java.io.*;

import java.util.ArrayList;

import javax.swing.*;

/**
 * This class is the essentially the backend of the Login and data saving using
 * hashmaps and keys
 */
public class Login implements ActionListener{
    private static HashMap<String, String> userNameToPassword = new HashMap<>();
    private static HashMap<String, UserData> passwordToUserdata= new HashMap<>();;

    private JFrame frame = new JFrame();
    private JLabel userLabel = new JLabel("Enter Username");
    private JLabel passwordLabel = new JLabel("Enter Password");

    private JPasswordField passwordEnter = new JPasswordField();
    private JTextField userEnter = new JTextField();
    private JButton login = new JButton("Login");
    private JButton accountCreation = new JButton("Create Account");
    private JLabel currentMessage = new JLabel();

    public static String currentUser = null;
    public static String currentPassword = null;

    public static UserData personalData;
    
    /*
     * This method displays the initial login screen
     */
    public void Layout(){
        frame.add(userLabel);
        frame.add(login);
        frame.add(userEnter);
        frame.add(passwordLabel);
        frame.add(passwordEnter);
        frame.add(currentMessage);
        frame.add(accountCreation);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(3000,3000);
        frame.setLayout(null);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);

        userLabel.setFont(new Font("Arial", Font.BOLD, 20));
        passwordLabel.setFont(new Font("Arial", Font.BOLD, 20));
        userEnter.setFont(new Font(Font.SERIF, Font.PLAIN, 20));
        passwordEnter.setFont(new Font(Font.SERIF, Font.PLAIN, 20));

        userLabel.setBounds(500, 250, 300, 50);
        userEnter.setBounds(750, 250, 300, 50);

        passwordLabel.setBounds(500, 500, 300, 50);
        passwordEnter.setBounds(750, 500, 300, 50);
        frame.setVisible(true);
        
        login.setBounds(500, 700, 250, 50);
        login.setFont(new Font("Arial", Font.BOLD, 20));

        accountCreation.setBounds(800, 700, 250, 50);
        accountCreation.setFont(new Font("Arial", Font.BOLD, 20));

        currentMessage.setVisible(false);
        currentMessage.setBounds(500, 0, 600, 100);
        currentMessage.setForeground(new Color(150, 0, 0));
        currentMessage.setFont(new Font("Arial", Font.BOLD, 25));



        login.addActionListener(this);
        accountCreation.addActionListener(this);
    }


    /** 
     * This method reacts to events due to user activity in the Login Browser
     * @param event the event which was activated based on the users input
     */
    @Override
    public void actionPerformed(ActionEvent event){
        currentMessage.setVisible(true);
        boolean success = LoginCheck(event);
        if (!success){
            System.out.println("Fail");
        } else {
            System.out.println("Logged In");
        }
    }

    /** 
     * This method checks the current buttons and does actions for which one was pressed
     * @param event the event which was activated based on the users input
     * @return boolean if login was successful
     */
    public boolean LoginCheck(ActionEvent event){
        //Login Button being Pressed
        if (event.getSource() == login && login.getText() == "Login"){
            String username = userEnter.getText();
            String password = String.valueOf(passwordEnter.getPassword());
            try{
                if (userNameToPassword.get(username) != null){
                    if (passwordToUserdata.get(userNameToPassword.get(username)).decrypt(password)){
                        currentUser = username;
                        currentPassword = password;
                        personalData = passwordToUserdata.get(userNameToPassword.get(username));
                        UI newWindow = new UI();
                        newWindow.welcome();
                        return true;
                    } else {
                        throw new NullPointerException();
                    }
                } else {
                    currentMessage.setForeground(new Color(150,0,0));
                    currentMessage.setText("Username or Password can not be found");
                    currentMessage.setVisible(true);
                    return false;
                }
            } catch (NullPointerException e){
                currentMessage.setForeground(new Color(150,0,0));
                currentMessage.setText("Username or Password can not be found");
                currentMessage.setVisible(true);
                return false;
            }
            
        }
        //Create Account button being Pressed
        if (event.getSource() == accountCreation && accountCreation.getText() == "Create Account"){
            currentMessage.setVisible(false);
            userLabel.setText("Create new Username");
            passwordLabel.setText("Create new Password");
            login.setText("Create Account");
            accountCreation.setText("Return");
            return false;
        }
        //Create Account button being Pressed in Account Creation
        if (event.getSource() == login && login.getText() == "Create Account"){
            String username = userEnter.getText();
            String password = String.valueOf(passwordEnter.getPassword());
            boolean running = false;
            System.out.println("User: " + username);
            try{
                if (userNameToPassword.get(username) != null){
                    currentMessage.setForeground(new Color(150,0,0));
                    currentMessage.setText("Username is already in use");
                    currentMessage.setVisible(true);
                } else {
                    running = true;
                    userNameToPassword.put(username, password);
                    passwordToUserdata.put(password, new UserData(password));

                    currentMessage.setForeground(new Color(0,150,0));
                    currentMessage.setText("Account Creation was Successful.");
                    hashSave("Practice.txt");
                    currentMessage.setVisible(true);
                }
            } catch (NullPointerException e){
                if (!running){
                    userNameToPassword.put(username, password);
                    passwordToUserdata.put(password, new UserData(password));

                    currentMessage.setForeground(new Color(0,150,0));
                    currentMessage.setText("Account Creation was Successful.");
                    hashSave("Practice.txt");
                    currentMessage.setVisible(true);
                }
            }
            return false;
        }
        //Return button being pressed in Account Creation
        if (event.getSource() == accountCreation && accountCreation.getText() == "Return"){
            userLabel.setText("Enter Username");
            passwordLabel.setText("Enter Password");

            login.setText("Login");
            accountCreation.setText("Create Account");
            return false;
        }
        return false;
    }

    /**
     * A helper method to help search for a certain set of characters in a string
     * @param search String that is being Searched
     * @param key String to search for
     * @return index where key starts at
     */
    public static int indexLaunchHelper(String search, String key){
        int index = -1;
        for (int i = 0; i < search.length() - key.length(); i++){
            if (search.substring(i, i + key.length()).equals(key)){
                index = i;
            }
        }
        return index;
    }
    /**
     * Looks into the HashMapInfo for the data saving and reorganizes data based on the values in the document
     * @param hashMapInfo String value of document name
     */
    public static void hashLaunch(String hashMapInfo){
        if (hashMapInfo == null){
            throw new NullPointerException();
        }

        try {
            File dataFile = new File(hashMapInfo);
            if (!dataFile.exists()){
                dataFile.createNewFile();
            }
            Scanner reader = new Scanner(dataFile);
            while (reader.hasNextLine()){
                String userInfo = reader.nextLine();
                UserData data = new UserData();
                //Updates users Encryption Data
                if (userInfo.contains("Encryption")){
                    int index = indexLaunchHelper(userInfo, "Encryption") + "Encryption".length();
                    if (index != -1){
                        int lastindex = 0;
                        for (int i = index + 1; i < userInfo.length(); i++){
                            if (userInfo.charAt(i) == ','){
                                lastindex = i;
                                break;
                            }
                        }
                        data.setEncryption(userInfo.substring(index + 1, lastindex));
                    }
                }
                //Updates users ShoppingHistory Data
                if (userInfo.contains("ShoppingHistory")){
                    int index = indexLaunchHelper(userInfo, "ShoppingHistory") + "ShoppingHistory".length();
                    if (index != -1){
                        int lastindex = 0;
                        for (int i = index + 1; i < userInfo.length(); i++){
                            if (userInfo.charAt(i) == ','){
                                lastindex = i;
                                break;
                            }
                        }
                        String newString = userInfo.substring(index + 1, lastindex - 1);
                        ArrayList<ArrayList<ProductInfo>> userHistory = UserData.setUpShoppingHistory(newString);
                        data.setShoppingHistory(userHistory);
                        
                    }
                }
                //Updates users Cart Data
                if (userInfo.contains("cart")){
                    int index = indexLaunchHelper(userInfo, "cart") + "cart".length();
                    if (index != -1){
                        int lastindex = 0;
                        for (int i = index + 1; i < userInfo.length(); i++){
                            if (userInfo.charAt(i) == ','){
                                lastindex = i;
                                break;
                            }
                        }
                        String newString = userInfo.substring(index + 2, lastindex - 1);
                        System.out.println(newString);
                        ArrayList<ProductInfo> newcart = new ArrayList<>();
                        String[] products = newString.split("'@#%"); 
                        for (int i = 0; i < products.length; i++){
                            newcart.add(new ProductInfo(products[i]));
                        }
                        data.setCart(newcart);
                    }
                }
                //Updates users encryptionCode Data
                if (userInfo.contains("encryptionCode")){
                    int index = indexLaunchHelper(userInfo, "encryptionCode") + "encryptionCode".length();
                    if (index != -1){
                        int lastindex = 0;
                        for (int i = index + 2; i < userInfo.length(); i++){
                            if (userInfo.charAt(i) == '}'){
                                lastindex = i;
                                break;
                            }
                        }
                        String newString = userInfo.substring(index + 2, lastindex);
                        ArrayList<Integer> encryptionCode = new ArrayList<>();
                        String[] codes = newString.split("'@#%"); 
                        for (int i = 0; i < codes.length; i++){
                            encryptionCode.add(Integer.parseInt(codes[i]));
                        }
                        data.setEncryptCode(encryptionCode);
                    }
                }
                //Updates users Username and Password Data
                if (userInfo.contains("Username")){
                    int index = indexLaunchHelper(userInfo, "Username") + "Username".length() + 1;
                    int lastindex = 0;
                    if (index != -1){
                        for (int i = index; i < userInfo.length(); i++){
                            if (userInfo.charAt(i) == '|'){
                                lastindex = i;
                                break;
                            }
                        }
                    }
                    if (userInfo.contains("Password")){
                        int indexpass = indexLaunchHelper(userInfo, "Password") + "Password".length() + 1;
                        if (indexpass != -1){
                            int lastindexpass = 0;
                            for (int i = indexpass; i < userInfo.length(); i++){
                                if (userInfo.charAt(i) == '{'){
                                    lastindexpass = i - 1;
                                    break;
                                }
                            }
                            userNameToPassword.put(userInfo.substring(index, lastindex), userInfo.substring(indexpass, lastindexpass));
                            passwordToUserdata.put(userInfo.substring(indexpass, lastindexpass), data);
                        }
                    }
                }
            }
            reader.close();
        } 
        catch (IOException e){
            System.out.println("Something Went Wrong");
        }
        
        
    }

    /**
     * Saves current HashMapData a specific way in the file provided
     * @param hashMapInfo String to save data to
     */
    public static void hashSave(String hashMapInfo){
        if (hashMapInfo == null){
            throw new NullPointerException();
        }

        try {
            File dataFile = new File(hashMapInfo);
            if (!dataFile.exists()){
                dataFile.createNewFile();
            } else {
                if (dataFile.delete()){
                    dataFile.createNewFile();
                } else {
                    throw new IOException();
                }

            }
            FileWriter writer = new FileWriter(dataFile);
            for (String key : userNameToPassword.keySet()){
                String userData = "Username=" + key + "||Password=" + userNameToPassword.get(key) + "=" + 
                    passwordToUserdata.get(userNameToPassword.get(key)).toString() + "\n";
                writer.write(userData);
            }
            writer.close();
        }
        catch (IOException e){
            System.out.println("Something Went Wrong");
        }
        catch(IndexOutOfBoundsException e){
            System.out.println("Something went terribly wrong");
            throw new IndexOutOfBoundsException();
        }
    }

    public static void main(String[] args){
        Login l = new Login();
        l.hashLaunch("Practice.txt");
        l.Layout();
    }
}