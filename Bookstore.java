import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;


public class Bookstore extends JFrame implements ActionListener{

    private JTextField txtAmount; //textfield for amount input
    private JLabel lblAmount, lblGenre; //labels for amount and genre
    private JButton btnAdd,btnBuy; //buttons for add and buy
    private JRadioButton golden,silver,non; //raddio buttons for memberships
    private JComboBox cbox; //combo box object for genres
    
    
    
    public Bookstore(){ //bookstore constructor
        
       setLayout(null); //null layout for individual design
		
            Object[] genres = {"Science[10p]","History[15p]","Drama[5p]","Romance[7p]"}; //array for book genres
                
    		txtAmount= new JTextField();
                txtAmount.setBounds(100,80,90,30); //textfield object and its position and quantity informations
                
                lblAmount= new JLabel("Amount");
                lblAmount.setBounds(20,50,90,90); //amount object and its position and quantity informations
		
                lblGenre= new JLabel("Genre");
                lblGenre.setBounds(20,250,90,90); //genre object and its position and quantity informations
		
                btnAdd= new JButton("Add");
                btnAdd.setBounds(260,50,90,60); //add button and its position and quantity informations
                
                btnBuy= new JButton("Buy");
                btnBuy.setBounds(350,50,90,60); //buy button and its position and quantity informations
                
                golden = new JRadioButton("Golden Member");
                golden.setBounds(50, 150, 130,80); //golden member button and its position and quantity informations
                
                silver = new JRadioButton("Silver Member");
                silver.setBounds(180, 150, 130,80); //silver member button and its position and quantity informations
                
                non = new JRadioButton("Non member");
                non.setBounds(310, 150, 120,80); //non member button and its position and quantity informations
                
                ButtonGroup bg = new ButtonGroup(); //buttongroup object for choosing only one membership
                bg.add(golden);
                bg.add(silver);
                bg.add(non);
                
                
                cbox = new JComboBox(genres); //combobox object with book genres array inside and its position and quantity informations
                cbox.setBounds(250,250,200,70);
        
                add(lblAmount);
		add(txtAmount);
		add(lblGenre);
		add(btnAdd);
		add(btnBuy);
                add(golden);
                add(silver);
                add(non);
                add(cbox);
                //adding all objects to the frame
                
                btnAdd.addActionListener(this);
                btnBuy.addActionListener(this);
                
                //activating all the buttons by action listener
                
                setSize(500,400);
		setTitle("BOOKSTORE");
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                
                //properties for the frame
        
        
        
    }
    
    
    
    
    public static void main(String[] args) {
        new Bookstore(); //running the application
    }
    
    
    
    int book_amount_total = 0; //total variable to calculate total bought books
    double golden_member_discount = 0.15; //discount for golden membership
    double silver_member_discount = 0.10; //discount for silver membership
    int allBookPrice = 5; //all books are 5$
    
    public void add(){ //helper add method for add button
      book_amount_total+=Integer.parseInt(txtAmount.getText()); //counting the total books the customer bought by taking the input from textfield
            System.out.println("You added " + txtAmount.getText().toString() + " " + cbox.getSelectedItem() + " " + " books,click to BUY for to end your shopping." );  
        
    }
    
    public void buy(){ //helper buy method for buy button
        if(golden.isSelected()){ //if clause for golden membership
            double discedPrice = (allBookPrice-(golden_member_discount*allBookPrice));
            System.out.println("You bought totally " + book_amount_total + " books and you will pay : " + book_amount_total*discedPrice + " $ for all!" );
            System.out.println("You are a golden member! Your 15% discount is ready!");
        }
        else if(silver.isSelected()){ //if clause for silver membership
            double discedPrice = (allBookPrice-(silver_member_discount*allBookPrice));
            System.out.println("You bought totally " + book_amount_total + " books and you will pay : " + book_amount_total*discedPrice + " $ for all!" );
            System.out.println("You are a silver member! Your 10% discount is ready!");
        }
        else if(non.isSelected()) //if clause for normal customer
            System.out.println("You bought totally " + book_amount_total + " books and you will pay : " + book_amount_total*allBookPrice + " $ for all!" );
       
        }
    
    @Override
    public void actionPerformed(ActionEvent e) { //actions for all 
        if(Integer.parseInt(txtAmount.getText()) <= 0) //Warning message for negative integers and zero amount
            JOptionPane.showMessageDialog(null,"Amount must be bigger than 0! Run the program again.");
        if(e.getSource().equals(btnAdd)) 
            add();
        if(e.getSource().equals(btnBuy))
            buy();
       
    }
    
}