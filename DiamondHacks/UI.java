import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Graphics;
import javax.swing.ImageIcon;
import java.awt.Image; 
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import java.awt.Font;
import javax.swing.JOptionPane;
import java.util.ArrayList;



public class UI {
    // add to cart buttons
    JButton shirt1 = new JButton("Add to cart");
    JButton shirt2 = new JButton("Add to cart");
    JButton shirt3 = new JButton("Add to cart");

    JButton pants1 = new JButton("Add to cart");
    JButton pants2 = new JButton("Add to cart");
    JButton pants3 = new JButton("Add to cart");

    JButton shoes1 = new JButton("Add to cart");
    JButton shoes2 = new JButton("Add to cart");
    JButton shoes3 = new JButton("Add to cart");


    /*
     * The welcome screen after the user logins in
     */
    public void welcome() {

        JFrame fFrame = new JFrame("Welcome");
        fFrame.setSize(3000, 3000);
        fFrame.setExtendedState(fFrame.MAXIMIZED_BOTH);
        fFrame.setVisible(true);
        fFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fFrame.setLayout(null);

        // displays welcome message
        JLabel welcome = new JLabel("Welcome!");
        welcome.setFont(new Font("Arial", Font.BOLD, 80));
        welcome.setBounds(575, 225, 700, 300);
        fFrame.add(welcome);

        // click here to begin button
        JButton startButton = new JButton("Click here to begin");
        startButton.setBounds(625, 475, 250, 50);
        startButton.setFont( new Font("Arial", Font.PLAIN, 20));
        fFrame.add(startButton);

        // if the user clicks the begin button, they are taken to the browse categories page
        ActionListener clickedBegin = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                categories();
            }
        };
        startButton.addActionListener(clickedBegin);
    }

    /**
     * The browse categories screen after the user clicks begin
     */
    public void categories() {

        JFrame frame = new JFrame("Categories");
        frame.setSize(400, 300);
        frame.setExtendedState(frame.MAXIMIZED_BOTH);

        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);

        // displays message
        JLabel browse = new JLabel("What would you like to browse?");
        browse.setFont( new Font("Arial", Font.PLAIN, 35));
        browse.setBounds(525, 300, 500, 100);
        frame.add(browse);

        // shirt button
        JButton shirtButton = new JButton("Shirts");
        shirtButton.setBounds(450, 450, 100, 50);
        shirtButton.setFont( new Font("Arial", Font.PLAIN, 20));
        frame.add(shirtButton);

        // if the user clicks shirts, they are taken to the store page for shirts
        ActionListener clickedShirts = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                shirts();
            }
        };
        shirtButton.addActionListener(clickedShirts);

        // pants button
        JButton pantsButton = new JButton("Pants");
        pantsButton.setBounds(700, 450, 100, 50);
        pantsButton.setFont( new Font("Arial", Font.PLAIN, 20));
        frame.add(pantsButton);

        // if the user clicks pants, they are taken to the store page for pants
        ActionListener clickedPants = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pants();
            }
        };
        pantsButton.addActionListener(clickedPants);

        // shoes button
        JButton shoesButton = new JButton("Shoes");
        shoesButton.setBounds(950, 450, 100, 50);
        shoesButton.setFont( new Font("Arial", Font.PLAIN, 20));
        frame.add(shoesButton);

        // if the user clicks shoes, they are taken to the store page for shoes
        ActionListener clickedShoes = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                shoes();
            }
        };
        shoesButton.addActionListener(clickedShoes);

        // if the user clicks cart, they are taken to the cart page
        ActionListener clickedCart = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cart();
            }
        };

        // add cart button
        JButton cart = new JButton("Cart");
        cart.setBounds(1400, 50, 100, 50);
        cart.setFont( new Font("Arial", Font.PLAIN, 20));
        frame.add(cart);
        cart.addActionListener(clickedCart);

    }

    /**
     * Page with pictures, descriptions, and prices where user can shop for shirts
     */
    public void shirts() {

        JFrame sFrame = new JFrame("Shirts");
        sFrame.setSize(3000, 3000);
        sFrame.setExtendedState(sFrame.MAXIMIZED_BOTH);
        
        JLayeredPane layers = new JLayeredPane();
        
        UI uiInstance = new UI(); 
        drawGrid grid = uiInstance.new drawGrid();
        grid.setBounds(0, 0, 3000, 3000);
        layers.add(grid, Integer.valueOf(0));
        
        sFrame.setVisible(true);
        sFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        layers.setLayout(null);

        // update cart if user clicks "add to cart" button for each item
        ActionListener addedToCart = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == shirt1){
                    ProductInfo blueShirt = new ProductInfo("Blue Shirt", Double.parseDouble("5"), "Images/blueShirt.jpg", 
                    "An amazing, awesome, BEAUTIFUL, blue shirt.", "Shirts");
                    System.out.println("Blue Shirt added to cart");
                    JOptionPane.showMessageDialog(null, "Blue Shirt added to cart", "Cart", JOptionPane.INFORMATION_MESSAGE);
                    Login.personalData.addProductToCart(blueShirt);
                    Login.hashSave("Practice.txt");
                }
                else if (e.getSource() == shirt2) {
                    ProductInfo redShirt = new ProductInfo("Red Shirt", Double.parseDouble("3"), "Images/redShirt.jpg", "A bold, majestic choice.", "Shirts");
                    System.out.println("Red Shirt added to cart");
                    JOptionPane.showMessageDialog(null, "Red Shirt added to cart", "Cart", JOptionPane.INFORMATION_MESSAGE);
                    Login.personalData.addProductToCart(redShirt);
                    Login.hashSave("Practice.txt");
                }
                else {
                    ProductInfo yellowShirt = new ProductInfo("Yellow Shirt", Double.parseDouble("2"), "Images/yellowShirt1.png", "A brave pick for a color.", "Shirts");
                    System.out.println("Yellow Shirt added to cart");
                    JOptionPane.showMessageDialog(null, "Yellow Shirt added to cart", "Cart", JOptionPane.INFORMATION_MESSAGE);
                    Login.personalData.addProductToCart(yellowShirt);
                    Login.hashSave("Practice.txt");
                }
            }
        };

        // icons for each item
        ImageIcon firstShirt = new ImageIcon("Images/blueShirt.jpg");
        Image i1 = firstShirt.getImage().getScaledInstance(70, 70, Image.SCALE_SMOOTH);
        ImageIcon j1 = new ImageIcon(i1);

        JLabel pic1 = new JLabel();
        pic1.setBounds(325, 230, 80, 80);
        pic1.setIcon(j1);
        layers.add(pic1, Integer.valueOf(1));

        ImageIcon secondShirt = new ImageIcon("Images/redShirt.jpg");
        Image i2 = secondShirt.getImage().getScaledInstance(70, 70, Image.SCALE_SMOOTH);
        ImageIcon j2 = new ImageIcon(i2);

        JLabel pic2 = new JLabel();
        pic2.setBounds(325, 420, 80, 80);
        pic2.setIcon(j2);
        layers.add(pic2, Integer.valueOf(1));

        ImageIcon thirdShirt = new ImageIcon("Images/yellowShirt1.png");
        Image i3 = thirdShirt.getImage().getScaledInstance(70, 70, Image.SCALE_SMOOTH);
        ImageIcon j3 = new ImageIcon(i3);

        JLabel pic3 = new JLabel();
        pic3.setBounds(325, 580, 80, 80);
        pic3.setIcon(j3);
        layers.add(pic3, Integer.valueOf(1));

        // name and prices listed for each item
        JLabel t1 = new JLabel("Blue shirt - $5");
        t1.setBounds(325, 290, 80, 80);
        layers.add(t1, Integer.valueOf(1));

        JLabel t2 = new JLabel("Red shirt - $3");
        t2.setBounds(325, 470, 80, 80);
        layers.add(t2, Integer.valueOf(1));

        JLabel t3 = new JLabel("Yellow shirt - $2");
        t3.setBounds(325, 630, 130, 80);
        layers.add(t3, Integer.valueOf(1));

        // description for each item
        JLabel d1 = new JLabel("An amazing, awesome, BEAUTIFUL, blue shirt.");
        d1.setBounds(550, 200, 100, 200);
        layers.add(d1, Integer.valueOf(1));

        JLabel d2 = new JLabel("A bold, majestic choice.");
        d2.setBounds(550, 370, 100, 200);
        layers.add(d2, Integer.valueOf(1));

        JLabel d3 = new JLabel ("A brave pick for a color.");
        d3.setBounds(550,530, 100, 200);
        layers.add(d3, Integer.valueOf(1));

        // add to cart button for each item
        shirt1.setBounds(1100, 250, 100, 50);
        shirt1.setFont(new Font("Arial", Font.PLAIN, 13));
        layers.add(shirt1, Integer.valueOf(1));
        shirt1.addActionListener(addedToCart);

        shirt2.setBounds(1100, 440, 100, 50);
        shirt2.setFont( new Font("Arial", Font.PLAIN, 13));
        layers.add(shirt2, Integer.valueOf(1));
        shirt2.addActionListener(addedToCart);

        shirt3.setBounds(1100, 600, 100, 50);
        shirt3.setFont( new Font("Arial", Font.PLAIN, 13));
        layers.add(shirt3, Integer.valueOf(1));
        shirt3.addActionListener(addedToCart);

        // if the back button is clicked, the user is taken to the previous page
        ActionListener clickBack = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sFrame.dispose();
            }
        };

        // back button
        JButton back = new JButton("Back");
        back.setBounds(1400, 750, 100, 50);
        back.setFont( new Font("Arial", Font.PLAIN, 20));
        layers.add(back, Integer.valueOf(1));
        back.addActionListener(clickBack);
        sFrame.setContentPane(layers);

        // if the cart button is clicked, the user is taken to the cart page
        ActionListener clickedCart = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cart();
            }
        };

        // cart button
        JButton cart = new JButton("Cart");
        cart.setBounds(1400, 50, 100, 50);
        shirt1.setFont( new Font("Arial", Font.PLAIN, 20));
        layers.add(cart, Integer.valueOf(1));
        cart.addActionListener(clickedCart);
        sFrame.setContentPane(layers);
        
    }

    /**
     * the cart page that shows a list of the user's items currently in their cart
     */
    public static void cart() {
        JFrame cFrame = new JFrame("Cart");
        cFrame.setSize(400, 300);
        cFrame.setExtendedState(cFrame.MAXIMIZED_BOTH);

        cFrame.setVisible(true);
        cFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        cFrame.setLayout(null);

        // if the back button is clicked, the user is taken to the prevous page
        ActionListener clickBack = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cFrame.dispose();
            }
        };

        // back button
        JButton back = new JButton("Back");
        back.setBounds(1400, 750, 100, 50);
        back.setFont( new Font("Arial", Font.PLAIN, 20));
        cFrame.add(back);
        back.addActionListener(clickBack);

        // displays "Cart"
        JLabel cartTitle = new JLabel("Cart");
        cartTitle.setFont( new Font("Arial", Font.BOLD, 40));
        cartTitle.setBounds(50, 0, 400, 200);
        cFrame.add(cartTitle);

        // if the user clicks the checkout button, their total is displayed 
        ActionListener clickedCheckout = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Double sum = 0.0;
                for (int i = 0; i < Login.personalData.cart().size(); i++) {
                    if (Login.personalData.cart().get(i).getName() == null) {
                        continue;
                    }
                    sum += Login.personalData.cart().get(i).getPrice();
                }
                JOptionPane.showMessageDialog(null, "Your total is $" + sum, "Checkout", JOptionPane.INFORMATION_MESSAGE);
            }
        };

        // checkout button
        JButton checkoutButton = new JButton("Checkout");
        checkoutButton.setFont( new Font("Arial", Font.PLAIN, 16));
        checkoutButton.setBounds(1400, 50, 100, 50);
        cFrame.add(checkoutButton);
        checkoutButton.addActionListener(clickedCheckout);
        
        // displays each item in cart with the icon, name, and price
        ArrayList<ProductInfo> cart = Login.personalData.cart();
        for (int i = 0; i < cart.size(); i++){
            
            int index = i;
            if (cart.get(i).getName() == null){
                continue;
            }
            ImageIcon image = new ImageIcon(cart.get(i).getImageFileName());
            ImageIcon actualImage = new ImageIcon(image.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH));
            JLabel picture = new JLabel();
            picture.setBounds(100, 150 * (i+1), 50, 50);
            picture.setIcon(actualImage);
            cFrame.add(picture);

            JLabel info = new JLabel("Item: " + cart.get(i).getName() + " - $" + cart.get(i).getPrice());
            info.setBounds(450, 150 * (i + 1), 200, 50);
            info.setFont( new Font("Arial", Font.PLAIN, 16));

            // remove item button
            JButton removeItemButton = new JButton("Remove " + cart.get(i).getName());
            removeItemButton.setFont( new Font("Arial", Font.PLAIN, 16));
            removeItemButton.setBounds(950, 150 * (i + 1), 200, 50);
            cFrame.add(info);
            cFrame.add(removeItemButton);

            // if the remove button is clicked, remove item and update cart
            ActionListener clickedRemove = new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (e.getSource() == removeItemButton) {
                        Login.personalData.removeProductFromCart(cart.get(index));
                        Login.hashSave("Practice.txt");
                        int placeholder = cFrame.EXIT_ON_CLOSE;
                        cart();
                    }
                }
            };
            removeItemButton.addActionListener(clickedRemove);

        }

    }

    /**
     * Page where the user can shop for pants
     */
    public void pants() {

        JFrame pFrame = new JFrame("Pants");
        pFrame.setSize(400, 300);
        pFrame.setExtendedState(pFrame.MAXIMIZED_BOTH);

        pFrame.setVisible(true);
        pFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pFrame.setLayout(null);

        JLayeredPane layers = new JLayeredPane();

        // draws grid
        UI uiInstance = new UI(); 
        drawGrid grid = uiInstance.new drawGrid();
        grid.setBounds(0, 0, 3000, 3000);
        layers.add(grid, Integer.valueOf(0));

        // for each item, if the "add to cart" button is clicked, update the cart
        ActionListener addedToCart = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == pants1){ 
                    ProductInfo blackPants = new ProductInfo("Black Pants", Double.parseDouble("7"), "Images/blackPants.png", "An amazing choice for a sleek look.", "Pants");
                    
                    System.out.println("Black Pants added to cart");
                    JOptionPane.showMessageDialog(null, "Black Pants added to cart", "Cart", JOptionPane.INFORMATION_MESSAGE);
                    Login.personalData.addProductToCart(blackPants);
                    Login.hashSave("Practice.txt");
                }
                else if (e.getSource() == pants2) {
                    ProductInfo brownPants = new ProductInfo("Brown Pants", Double.parseDouble("8"), "Images/brownPants1.jpg",  "Can't go wrong with brown.", "Pants");
                    System.out.println("Brown Pants added to cart");
                    JOptionPane.showMessageDialog(null, "Brown Parts added to cart", "Cart", JOptionPane.INFORMATION_MESSAGE);
                    Login.personalData.addProductToCart(brownPants);
                    Login.hashSave("Practice.txt");
                }
                else {
                    ProductInfo jeans = new ProductInfo("Jeans", Double.parseDouble("10"), "Images/jeans.png", "Very durable, great choice.", "Pants");
                    System.out.println("Jeans added to cart");
                    JOptionPane.showMessageDialog(null, "Jeans added to cart", "Cart", JOptionPane.INFORMATION_MESSAGE);
                    Login.personalData.addProductToCart(jeans);
                    Login.hashSave("Practice.txt");
                }
            }
        };

        // icons for each item
        ImageIcon firstPants = new ImageIcon("Images/blackPants.png");
        Image i1 = firstPants.getImage().getScaledInstance(70, 70, Image.SCALE_SMOOTH);
        ImageIcon j1 = new ImageIcon(i1);

        JLabel pic1 = new JLabel();
        pic1.setBounds(325, 230, 80, 80);
        pic1.setIcon(j1);
        layers.add(pic1, Integer.valueOf(1));

        ImageIcon secondPants = new ImageIcon("Images/brownPants1.jpg");
        Image i2 = secondPants.getImage().getScaledInstance(70, 70, Image.SCALE_SMOOTH);
        ImageIcon j2 = new ImageIcon(i2);

        JLabel pic2 = new JLabel();
        pic2.setBounds(325, 420, 80, 80);
        pic2.setIcon(j2);
        layers.add(pic2, Integer.valueOf(1));

        ImageIcon thirdPants = new ImageIcon("Images/jeans.png");
        Image i3 = thirdPants.getImage().getScaledInstance(70, 70, Image.SCALE_SMOOTH);
        ImageIcon j3 = new ImageIcon(i3);

        JLabel pic3 = new JLabel();
        pic3.setBounds(325, 580, 80, 80);
        pic3.setIcon(j3);
        layers.add(pic3, Integer.valueOf(1));

        // item price and name
        JLabel t1 = new JLabel("Black pants - $7");
        t1.setBounds(325, 290, 200, 80);
        layers.add(t1, Integer.valueOf(1));

        JLabel t2 = new JLabel("Brown pants - $8");
        t2.setBounds(325, 470, 200, 80);
        layers.add(t2, Integer.valueOf(1));

        JLabel t3 = new JLabel("Jeans - $10");
        t3.setBounds(325, 630, 130, 80);
        layers.add(t3, Integer.valueOf(1));

        // description for each item
        JLabel d1 = new JLabel("An amazing choice for a sleek look.");
        d1.setBounds(550, 200, 100, 200);
        layers.add(d1, Integer.valueOf(1));

        JLabel d2 = new JLabel("Can't go wrong with brown.");
        d2.setBounds(550, 370, 100, 200);
        layers.add(d2, Integer.valueOf(1));

        JLabel d3 = new JLabel ("Very durable, great choice.");
        d3.setBounds(550,530, 100, 200);
        layers.add(d3, Integer.valueOf(1));

        // "add to cart" button for each item
        pants1.setBounds(1100, 250, 100, 50);
        pants1.setFont( new Font("Arial", Font.PLAIN, 13));
        layers.add(pants1, Integer.valueOf(1));
        pants1.addActionListener(addedToCart);

        pants2.setBounds(1100, 440, 100, 50);
        pants2.setFont( new Font("Arial", Font.PLAIN, 13));
        layers.add(pants2, Integer.valueOf(1));
        pants2.addActionListener(addedToCart);

        pants3.setBounds(1100, 600, 100, 50);
        pants3.setFont( new Font("Arial", Font.PLAIN, 13));
        layers.add(pants3, Integer.valueOf(1));
        pants3.addActionListener(addedToCart);

        // if the back button is clicked, go to the previous page
        ActionListener clickBack = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pFrame.dispose();
            }
        };

        // back button
        JButton back = new JButton("Back");
        back.setBounds(1400, 750, 100, 50);
        back.setFont( new Font("Arial", Font.PLAIN, 20));
        layers.add(back, Integer.valueOf(1));
        back.addActionListener(clickBack);
        pFrame.setContentPane(layers);

        // if the cart button is clicked, go to the cart page
        ActionListener clickedCart = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cart();
            }
        };

        // cart button
        JButton cart = new JButton("Cart");
        cart.setBounds(1400, 50, 100, 50);
        cart.setFont( new Font("Arial", Font.PLAIN, 20));
        layers.add(cart, Integer.valueOf(1));
        cart.addActionListener(clickedCart);
        pFrame.setContentPane(layers);
        
    }

    /**
     * The shoes store page
     */
    public void shoes() {

        JFrame shFrame = new JFrame("Shoes");
        shFrame.setSize(400, 300);
        shFrame.setExtendedState(shFrame.MAXIMIZED_BOTH);

        shFrame.setVisible(true);
        shFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        shFrame.setLayout(null);

        JLayeredPane layers = new JLayeredPane();

        // draws grid
        UI uiInstance = new UI(); 
        drawGrid grid = uiInstance.new drawGrid();
        grid.setBounds(0, 0, 3000, 3000);
        layers.add(grid, Integer.valueOf(0));

        // for each item, if the "add to cart" button is clicked, update cart 
        ActionListener addedToCart = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == shoes1) {
                    ProductInfo converse = new ProductInfo("Converse", Double.parseDouble("8"), "Images/converse.png", "A very very nice choice", "Shoes");
                    System.out.println("Converse added to cart");
                    JOptionPane.showMessageDialog(null, "Converse added to cart", "Cart", JOptionPane.INFORMATION_MESSAGE);
                    Login.personalData.addProductToCart(converse);
                    Login.hashSave("Practice.txt");
                }
                else if (e.getSource() == shoes2) {
                    ProductInfo dressShoes = new ProductInfo("Dress Shoes", Double.parseDouble("12"), "Images/dressShoes.png", "How neat and tidy you'll look.", "Shoes");
                    System.out.println("Dress Shoes added to cart");
                    JOptionPane.showMessageDialog(null, "Dress Shoes added to cart", "Cart", JOptionPane.INFORMATION_MESSAGE);
                    Login.personalData.addProductToCart(dressShoes);
                    Login.hashSave("Practice.txt");
                }
                else {
                    ProductInfo tennisShoes = new ProductInfo("Tennis Shoes", Double.parseDouble("9"), "Images/runningShoes.png", "The fastest shoes you will ever wear.", "Shoes");
                    System.out.println("Tennis Shoes added to cart");
                    JOptionPane.showMessageDialog(null, "Tennis Shoes added to cart", "Cart", JOptionPane.INFORMATION_MESSAGE);
                    Login.personalData.addProductToCart(tennisShoes);
                    Login.hashSave("Practice.txt");
                }
            }
        };

        // icons for each item
        ImageIcon firstShoes = new ImageIcon("Images/converse.png");
        Image i1 = firstShoes.getImage().getScaledInstance(70, 70, Image.SCALE_SMOOTH);
        ImageIcon j1 = new ImageIcon(i1);

        JLabel pic1 = new JLabel();
        pic1.setBounds(325, 230, 80, 80);
        pic1.setIcon(j1);
        layers.add(pic1, Integer.valueOf(1));

        ImageIcon secondShoes = new ImageIcon("Images/dressShoes.png");
        Image i2 = secondShoes.getImage().getScaledInstance(70, 70, Image.SCALE_SMOOTH);
        ImageIcon j2 = new ImageIcon(i2);

        JLabel pic2 = new JLabel();
        pic2.setBounds(325, 420, 80, 80);
        pic2.setIcon(j2);
        layers.add(pic2, Integer.valueOf(1));

        ImageIcon thirdShoes = new ImageIcon("Images/runningShoes.png");
        Image i3 = thirdShoes.getImage().getScaledInstance(70, 70, Image.SCALE_SMOOTH);
        ImageIcon j3 = new ImageIcon(i3);

        JLabel pic3 = new JLabel();
        pic3.setBounds(325, 580, 80, 80);
        pic3.setIcon(j3);
        layers.add(pic3, Integer.valueOf(1));

        // item labels with price and name
        JLabel t1 = new JLabel("Converse - $8");
        t1.setBounds(325, 290, 80, 80);
        layers.add(t1, Integer.valueOf(1));

        JLabel t2 = new JLabel("Dress shoes - $12");
        t2.setBounds(325, 470, 200, 80);
        layers.add(t2, Integer.valueOf(1));

        JLabel t3 = new JLabel("Tennis shoes - $9");
        t3.setBounds(325, 630, 130, 80);
        layers.add(t3, Integer.valueOf(1));

        // description for each item
        JLabel d1 = new JLabel("A very very nice choice");
        d1.setBounds(550, 200, 100, 200);
        layers.add(d1, Integer.valueOf(1));

        JLabel d2 = new JLabel("How neat and tidy you'll look.");
        d2.setBounds(550, 370, 100, 200);
        layers.add(d2, Integer.valueOf(1));

        JLabel d3 = new JLabel ("The fastest shoes you will ever wear.");
        d3.setBounds(550,530, 100, 200);
        layers.add(d3, Integer.valueOf(1));

        // add to cart button for each item
        shoes1.setBounds(1100, 250, 100, 50);
        shoes1.setFont( new Font("Arial", Font.PLAIN, 13));
        layers.add(shoes1, Integer.valueOf(1));
        shoes1.addActionListener(addedToCart);

        shoes2.setBounds(1100, 440, 100, 50);
        shoes2.setFont( new Font("Arial", Font.PLAIN, 13));
        layers.add(shoes2, Integer.valueOf(1));
        shoes2.addActionListener(addedToCart);

        shoes3.setBounds(1100, 600, 100, 50);
        shoes3.setFont( new Font("Arial", Font.PLAIN, 13));
        layers.add(shoes3, Integer.valueOf(1));
        shoes3.addActionListener(addedToCart);

        // if the back button is clicked, go to the previous page
        ActionListener clickBack = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                shFrame.dispose();
            }
        };

        // back button
        JButton back = new JButton("Back");
        back.setBounds(1400, 750, 100, 50);
        back.setFont( new Font("Arial", Font.PLAIN, 20));
        layers.add(back, Integer.valueOf(1));
        back.addActionListener(clickBack);
        shFrame.setContentPane(layers);

        // if the cart button is clicked, go to the cart page
        ActionListener clickedCart = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cart();
            }
        };

        // cart button
        JButton cart = new JButton("Cart");
        cart.setBounds(1400, 50, 100, 50);
        cart.setFont( new Font("Arial", Font.PLAIN, 20));
        layers.add(cart, Integer.valueOf(1));
        cart.addActionListener(clickedCart);
        shFrame.setContentPane(layers);

    }

    /**
     * Draws a grid using lines
     */
    protected class drawGrid extends JPanel{
        @Override
        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.drawLine(200,200, 1300,200); // horizontals
            g.drawLine(200,700, 1300,700); 

            g.drawLine(200, 200, 200, 700); // verticals
            g.drawLine(1300, 200, 1300, 700);

            g.drawLine(200, 375, 1300, 375); // horizontals
            g.drawLine(200, 550, 1300, 550);

            g.drawLine(500, 200, 500, 700); // verticals
            g.drawLine(1000, 200, 1000, 700);

        }
    }
}