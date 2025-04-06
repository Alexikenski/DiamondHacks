/**
 * Encrypts user data
 */

import java.util.ArrayList;
import java.util.Collection;


public class UserData {
    // Arraylists to hold user data
    private ArrayList<ArrayList<ProductInfo>> shoppingHistory = new ArrayList<>();
    private ArrayList<ProductInfo> cart = new ArrayList<>();
    private String Encryption; 
    private ArrayList<Integer> encryptCode = new ArrayList<>();

    private final static String commaHolder2DArray = "'@#%";
    private final static String commaHolder3DArray = "'^%#";

    // no argument constructor
    public UserData(){}

    /**
     * Generates random encryption
     * @param newUserPassword - the password to encrypt
     */
    public UserData(String newUserPassword){
        System.out.println(newUserPassword);
        generateEncryption(newUserPassword);
    }

    /**
     * Initializes variables
     * @param shoppingHistory
     * @param cart
     * @param Encryption
     * @param encryptCode
     */
    public UserData(ArrayList<ArrayList<ProductInfo>> shoppingHistory, ArrayList<ProductInfo> cart,
    String Encryption, ArrayList<Integer> encryptCode){
        for (int i = 0; i < shoppingHistory.size(); i++){
            this.shoppingHistory.add(shoppingHistory.get(i));
        }
        for (int i = 0; i < cart.size(); i++){
            this.cart.add(cart.get(i));
        }
        for (int i = 0; i < encryptCode.size(); i++){
            this.encryptCode.add(encryptCode.get(i));
        }
        this.Encryption = Encryption;
    }

    /**
     * Adds products to shopping list
     * @param products - list of products
     */
    public void updateHistory(ArrayList<ProductInfo> products){
        shoppingHistory.add(0, products);
    }

    /**
     * Adds product to cart
     * @param product - product to be added
     */
    public void addProductToCart(ProductInfo product){
        cart.add(product);
    }

    /**
     * Removes product from cart
     * @param product - product to be removed
     */
    public void removeProductFromCart(ProductInfo product){
        for (int i = 0; i < cart.size(); i++){
            if (product.equals(cart.get(i))){
                cart.remove(i);
                break;
            }
        }
    }

    /**
     * Generates encryption
     * @param password - the password to be encrypted
     */
    public void generateEncryption(String password){
        String encrypt = "";
        for (int i = 0; i < password.length(); i++){
            char randomCharacter = (char) ((int)(Math.random() * 94) + 32);
            System.out.println(password.charAt(i) + " " + randomCharacter);
            encryptCode.add(Integer.valueOf(password.charAt(i) + randomCharacter));
            encrypt += randomCharacter;
        }
        Encryption = encrypt;
    }

    /**
     * Decrypts passworc
     * @param password - the password to decrypt
     * @return if decryption was successfull
     */
    public boolean decrypt(String password){
        String encryption = "";
        for (int i = 0; i < encryptCode.size(); i++){
            encryption += (char) (encryptCode.get(i) - password.charAt(i));
        }
        if (encryption.equals(Encryption)){
            return true;
        } else {
            return false;
        }
    }

    /**
     * Sets up shopping history
     * @param dataString - string to separate
     * @return shopping history information
     */
    public static ArrayList<ArrayList<ProductInfo>> setUpShoppingHistory(String dataString){
        String[] seperate = dataString.split(commaHolder2DArray);
        ArrayList<ArrayList<ProductInfo>> info = new ArrayList<>();
        for (int i = 0; i < seperate.length; i++){
            String[] products = seperate[i].split(commaHolder3DArray);
            ArrayList<ProductInfo> historyProd = new ArrayList<>();
            for (int a = 0; a < products.length; a++){
                historyProd.add(new ProductInfo(products[0]));
            }
            info.add(historyProd);
        }
        return info;
    }

    // gets product information
    public ArrayList<ArrayList<ProductInfo>> getShoppingHistory(){
        return shoppingHistory;
    }

    public ArrayList<ProductInfo> cart(){
        return cart;
    }

    public String getEncryption(){
        return Encryption;
    }

    public void setEncryption(String Encryption){
        this.Encryption = Encryption;
    }

    public void setCart(ArrayList<ProductInfo> cart){
        this.cart = cart;
    }

    public void setShoppingHistory(ArrayList<ArrayList<ProductInfo>> shoppingHistory){
        this.shoppingHistory = shoppingHistory;
    }

    public void setEncryptCode(ArrayList<Integer> encryptCode){
        this.encryptCode = encryptCode;
    }

    /**
     * @return the data in the form of a String
     */
    @Override
    public String toString(){
        String userDataString = "{";
        userDataString += "Encryption=" + Encryption +",";
        userDataString += "ShoppingHistory={";
        for (int i = 0; i < shoppingHistory.size(); i++){
            userDataString += "{";
            for (int a = 0; a < shoppingHistory.get(i).size(); a++){
                if (a + 1 != shoppingHistory.get(i).size()){
                    userDataString += shoppingHistory.get(i).get(a).toString() + "'^%#";
                } else {
                    userDataString += shoppingHistory.get(i).get(a).toString();
                }
            }
            userDataString += "}'@#%";
        }
        userDataString += "},";
        userDataString += "cart={";
        for (int i = 0; i < cart.size(); i++){
            if (i + 1 != cart.size()){
                userDataString += cart.get(i).toString() + "'@#%";
            } else {
                userDataString += cart.get(i).toString();
            }
        }
        userDataString += "},encryptionCode={";
        for (int i = 0; i < encryptCode.size(); i++){
            if (i + 1 != encryptCode.size()){
                userDataString += encryptCode.get(i) + "'@#%";
            } else {
                userDataString += encryptCode.get(i);
            }
        }
        userDataString += "}}";
        return userDataString;
    }
}
