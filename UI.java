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


public class UI {

    public static void welcome() {
        JFrame fFrame = new JFrame("Welcome");
        fFrame.setSize(3000, 3000);
        fFrame.setExtendedState(fFrame.MAXIMIZED_BOTH);
        fFrame.setVisible(true);
        fFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fFrame.setLayout(null);

        JLabel welcome = new JLabel("Welcome!");
        welcome.setFont(new Font("Arial", Font.BOLD, 80));
        welcome.setBounds(575, 225, 700, 300);
        fFrame.add(welcome);

        JButton startButton = new JButton("Click here to begin");
        startButton.setBounds(625, 475, 250, 50);
        startButton.setFont( new Font("Arial", Font.PLAIN, 20));
        fFrame.add(startButton);

        ActionListener clickedBegin = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                categories();
            }
        };

        startButton.addActionListener(clickedBegin);

    }

    public static void categories() {

        JFrame frame = new JFrame("Categories");
        frame.setSize(400, 300);
        frame.setExtendedState(frame.MAXIMIZED_BOTH);

        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);

        JLabel browse = new JLabel("What would you like to browse?");
        browse.setFont( new Font("Arial", Font.PLAIN, 35));
        browse.setBounds(525, 300, 500, 100);
        frame.add(browse);

        JButton shirtButton = new JButton("Shirts");
        shirtButton.setBounds(450, 450, 100, 50);
        shirtButton.setFont( new Font("Arial", Font.PLAIN, 20));
        frame.add(shirtButton);

        ActionListener clickedShirts = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                shirts();
            }
        };

        shirtButton.addActionListener(clickedShirts);

        JButton pantsButton = new JButton("Pants");
        pantsButton.setBounds(700, 450, 100, 50);
        pantsButton.setFont( new Font("Arial", Font.PLAIN, 20));
        frame.add(pantsButton);

        ActionListener clickedPants = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pants();
            }
        };

        pantsButton.addActionListener(clickedPants);


        JButton shoesButton = new JButton("Shoes");
        shoesButton.setBounds(950, 450, 100, 50);
        shoesButton.setFont( new Font("Arial", Font.PLAIN, 20));
        frame.add(shoesButton);

        ActionListener clickedShoes = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                shoes();
            }
        };

        shoesButton.addActionListener(clickedShoes);

    }

    public static void shirts() {

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

        ActionListener addedToCart = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Item added to cart");
                JOptionPane.showMessageDialog(null, "Item added to cart", "Cart", JOptionPane.INFORMATION_MESSAGE);
            }
        };

        // icons
        ImageIcon firstShirt = new ImageIcon("blueShirt.jpg");
        Image i1 = firstShirt.getImage().getScaledInstance(70, 70, Image.SCALE_SMOOTH);
        ImageIcon j1 = new ImageIcon(i1);

        JLabel pic1 = new JLabel();
        pic1.setBounds(325, 230, 80, 80);
        pic1.setIcon(j1);
        layers.add(pic1, Integer.valueOf(1));

        ImageIcon secondShirt = new ImageIcon("redShirt.jpg");
        Image i2 = secondShirt.getImage().getScaledInstance(70, 70, Image.SCALE_SMOOTH);
        ImageIcon j2 = new ImageIcon(i2);

        JLabel pic2 = new JLabel();
        pic2.setBounds(325, 420, 80, 80);
        pic2.setIcon(j2);
        layers.add(pic2, Integer.valueOf(1));

        ImageIcon thirdShirt = new ImageIcon("yellowShirt1.png");
        Image i3 = thirdShirt.getImage().getScaledInstance(70, 70, Image.SCALE_SMOOTH);
        ImageIcon j3 = new ImageIcon(i3);

        JLabel pic3 = new JLabel();
        pic3.setBounds(325, 580, 80, 80);
        pic3.setIcon(j3);
        layers.add(pic3, Integer.valueOf(1));

        // item labels
        JLabel t1 = new JLabel("Blue shirt - $5");
        t1.setBounds(325, 290, 80, 80);
        layers.add(t1, Integer.valueOf(1));

        JLabel t2 = new JLabel("Red shirt - $3");
        t2.setBounds(325, 470, 80, 80);
        layers.add(t2, Integer.valueOf(1));

        JLabel t3 = new JLabel("Yellow shirt - $2");
        t3.setBounds(325, 630, 130, 80);
        layers.add(t3, Integer.valueOf(1));

        // descriptions
        JLabel d1 = new JLabel("Description");
        d1.setBounds(550, 200, 100, 200);
        layers.add(d1, Integer.valueOf(1));

        JLabel d2 = new JLabel("Description");
        d2.setBounds(550, 370, 100, 200);
        layers.add(d2, Integer.valueOf(1));

        JLabel d3 = new JLabel ("Description");
        d3.setBounds(550,530, 100, 200);
        layers.add(d3, Integer.valueOf(1));

        // buttons
        JButton shirt1 = new JButton("Add to cart");
        shirt1.setBounds(1100, 250, 100, 50);
        layers.add(shirt1, Integer.valueOf(1));
        shirt1.addActionListener(addedToCart);

        JButton shirt2 = new JButton("Add to cart");
        shirt2.setBounds(1100, 440, 100, 50);
        layers.add(shirt2, Integer.valueOf(1));
        shirt2.addActionListener(addedToCart);

        JButton shirt3 = new JButton("Add to cart");
        shirt3.setBounds(1100, 600, 100, 50);
        layers.add(shirt3, Integer.valueOf(1));
        shirt3.addActionListener(addedToCart);

        ActionListener clickBack = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sFrame.dispose();
            }
        };

        JButton back = new JButton("Back");
        back.setBounds(1400, 750, 100, 50);
        layers.add(back, Integer.valueOf(1));
        back.addActionListener(clickBack);
        sFrame.setContentPane(layers);

        ActionListener clickedCart = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cart();
            }
        };

        JButton cart = new JButton("Cart");
        cart.setBounds(1400, 50, 100, 50);
        layers.add(cart, Integer.valueOf(1));
        cart.addActionListener(clickedCart);
        sFrame.setContentPane(layers);
        
    }

    public static void cart() {
        JFrame cFrame = new JFrame("Cart");
        cFrame.setSize(400, 300);
        cFrame.setExtendedState(cFrame.MAXIMIZED_BOTH);

        cFrame.setVisible(true);
        cFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        cFrame.setLayout(null);

        ActionListener clickBack = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cFrame.dispose();
            }
        };

        JButton back = new JButton("Back");
        back.setBounds(1400, 750, 100, 50);
        cFrame.add(back);
        back.addActionListener(clickBack);

        JLabel cartTitle = new JLabel("Cart");
        cartTitle.setFont( new Font("Arial", Font.BOLD, 40));
        cartTitle.setBounds(50, 0, 400, 200);
        cFrame.add(cartTitle);
        
    }

    public static void pants() {

        JFrame pFrame = new JFrame("Pants");
        pFrame.setSize(400, 300);
        pFrame.setExtendedState(pFrame.MAXIMIZED_BOTH);

        pFrame.setVisible(true);
        pFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pFrame.setLayout(null);

        JLayeredPane layers = new JLayeredPane();

        UI uiInstance = new UI(); 
        drawGrid grid = uiInstance.new drawGrid();
        grid.setBounds(0, 0, 3000, 3000);
        layers.add(grid, Integer.valueOf(0));

        ActionListener addedToCart = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Item added to cart");
                JOptionPane.showMessageDialog(null, "Item added to cart", "Cart", JOptionPane.INFORMATION_MESSAGE);
            }
        };

        // icons
        ImageIcon firstPants = new ImageIcon("blackPants.png");
        Image i1 = firstPants.getImage().getScaledInstance(70, 70, Image.SCALE_SMOOTH);
        ImageIcon j1 = new ImageIcon(i1);

        JLabel pic1 = new JLabel();
        pic1.setBounds(325, 230, 80, 80);
        pic1.setIcon(j1);
        layers.add(pic1, Integer.valueOf(1));

        ImageIcon secondPants = new ImageIcon("brownPants1.jpg");
        Image i2 = secondPants.getImage().getScaledInstance(70, 70, Image.SCALE_SMOOTH);
        ImageIcon j2 = new ImageIcon(i2);

        JLabel pic2 = new JLabel();
        pic2.setBounds(325, 420, 80, 80);
        pic2.setIcon(j2);
        layers.add(pic2, Integer.valueOf(1));

        ImageIcon thirdPants = new ImageIcon("jeans.png");
        Image i3 = thirdPants.getImage().getScaledInstance(70, 70, Image.SCALE_SMOOTH);
        ImageIcon j3 = new ImageIcon(i3);

        JLabel pic3 = new JLabel();
        pic3.setBounds(325, 580, 80, 80);
        pic3.setIcon(j3);
        layers.add(pic3, Integer.valueOf(1));

        // item labels
        JLabel t1 = new JLabel("Black pants - $7");
        t1.setBounds(325, 290, 80, 80);
        layers.add(t1, Integer.valueOf(1));

        JLabel t2 = new JLabel("Brown pants - $8");
        t2.setBounds(325, 470, 80, 80);
        layers.add(t2, Integer.valueOf(1));

        JLabel t3 = new JLabel("Jeans - $10");
        t3.setBounds(325, 630, 130, 80);
        layers.add(t3, Integer.valueOf(1));

        // descriptions
        JLabel d1 = new JLabel("Description");
        d1.setBounds(550, 200, 100, 200);
        layers.add(d1, Integer.valueOf(1));

        JLabel d2 = new JLabel("Description");
        d2.setBounds(550, 370, 100, 200);
        layers.add(d2, Integer.valueOf(1));

        JLabel d3 = new JLabel ("Description");
        d3.setBounds(550,530, 100, 200);
        layers.add(d3, Integer.valueOf(1));

        // buttons
        JButton pants1 = new JButton("Add to cart");
        pants1.setBounds(1100, 250, 100, 50);
        layers.add(pants1, Integer.valueOf(1));
        pants1.addActionListener(addedToCart);

        JButton pants2 = new JButton("Add to cart");
        pants2.setBounds(1100, 440, 100, 50);
        layers.add(pants2, Integer.valueOf(1));
        pants2.addActionListener(addedToCart);

        JButton pants3 = new JButton("Add to cart");
        pants3.setBounds(1100, 600, 100, 50);
        layers.add(pants3, Integer.valueOf(1));
        pants3.addActionListener(addedToCart);

        ActionListener clickBack = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pFrame.dispose();
            }
        };

        JButton back = new JButton("Back");
        back.setBounds(1400, 750, 100, 50);
        layers.add(back, Integer.valueOf(1));
        back.addActionListener(clickBack);
        pFrame.setContentPane(layers);

        ActionListener clickedCart = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cart();
            }
        };

        JButton cart = new JButton("Cart");
        cart.setBounds(1400, 50, 100, 50);
        layers.add(cart, Integer.valueOf(1));
        cart.addActionListener(clickedCart);
        pFrame.setContentPane(layers);
        
    }

    public static void shoes() {

        JFrame shFrame = new JFrame("Shoes");
        shFrame.setSize(400, 300);
        shFrame.setExtendedState(shFrame.MAXIMIZED_BOTH);

        shFrame.setVisible(true);
        shFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        shFrame.setLayout(null);

        JLayeredPane layers = new JLayeredPane();

        UI uiInstance = new UI(); 
        drawGrid grid = uiInstance.new drawGrid();
        grid.setBounds(0, 0, 3000, 3000);
        layers.add(grid, Integer.valueOf(0));

        ActionListener addedToCart = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Item added to cart");
                JOptionPane.showMessageDialog(null, "Item added to cart", "Cart", JOptionPane.INFORMATION_MESSAGE);
            }
        };

        // icons
        ImageIcon firstShoes = new ImageIcon("converse.png");
        Image i1 = firstShoes.getImage().getScaledInstance(70, 70, Image.SCALE_SMOOTH);
        ImageIcon j1 = new ImageIcon(i1);

        JLabel pic1 = new JLabel();
        pic1.setBounds(325, 230, 80, 80);
        pic1.setIcon(j1);
        layers.add(pic1, Integer.valueOf(1));

        ImageIcon secondShoes = new ImageIcon("dressShoes.png");
        Image i2 = secondShoes.getImage().getScaledInstance(70, 70, Image.SCALE_SMOOTH);
        ImageIcon j2 = new ImageIcon(i2);

        JLabel pic2 = new JLabel();
        pic2.setBounds(325, 420, 80, 80);
        pic2.setIcon(j2);
        layers.add(pic2, Integer.valueOf(1));

        ImageIcon thirdShoes = new ImageIcon("runningShoes.png");
        Image i3 = thirdShoes.getImage().getScaledInstance(70, 70, Image.SCALE_SMOOTH);
        ImageIcon j3 = new ImageIcon(i3);

        JLabel pic3 = new JLabel();
        pic3.setBounds(325, 580, 80, 80);
        pic3.setIcon(j3);
        layers.add(pic3, Integer.valueOf(1));

        // item labels
        JLabel t1 = new JLabel("Converse - $8");
        t1.setBounds(325, 290, 80, 80);
        layers.add(t1, Integer.valueOf(1));

        JLabel t2 = new JLabel("Dress shoes - $12");
        t2.setBounds(325, 470, 80, 80);
        layers.add(t2, Integer.valueOf(1));

        JLabel t3 = new JLabel("Tennis shoes - $9");
        t3.setBounds(325, 630, 130, 80);
        layers.add(t3, Integer.valueOf(1));

        // descriptions
        JLabel d1 = new JLabel("Description");
        d1.setBounds(550, 200, 100, 200);
        layers.add(d1, Integer.valueOf(1));

        JLabel d2 = new JLabel("Description");
        d2.setBounds(550, 370, 100, 200);
        layers.add(d2, Integer.valueOf(1));

        JLabel d3 = new JLabel ("Description");
        d3.setBounds(550,530, 100, 200);
        layers.add(d3, Integer.valueOf(1));

        // buttons
        JButton shoes1 = new JButton("Add to cart");
        shoes1.setBounds(1100, 250, 100, 50);
        layers.add(shoes1, Integer.valueOf(1));
        shoes1.addActionListener(addedToCart);

        JButton shoes2 = new JButton("Add to cart");
        shoes2.setBounds(1100, 440, 100, 50);
        layers.add(shoes2, Integer.valueOf(1));
        shoes2.addActionListener(addedToCart);

        JButton shoes3 = new JButton("Add to cart");
        shoes3.setBounds(1100, 600, 100, 50);
        layers.add(shoes3, Integer.valueOf(1));
        shoes3.addActionListener(addedToCart);

        ActionListener clickBack = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                shFrame.dispose();
            }
        };

        JButton back = new JButton("Back");
        back.setBounds(1400, 750, 100, 50);
        layers.add(back, Integer.valueOf(1));
        back.addActionListener(clickBack);
        shFrame.setContentPane(layers);

        ActionListener clickedCart = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cart();
            }
        };

        JButton cart = new JButton("Cart");
        cart.setBounds(1400, 50, 100, 50);
        layers.add(cart, Integer.valueOf(1));
        cart.addActionListener(clickedCart);
        shFrame.setContentPane(layers);

    }

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

    public static void main (String[] args) {
        welcome();
    
    }

}
