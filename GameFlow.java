import java.util.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.List;
import java.awt.Graphics;
import java.awt.Graphics2D;



public class GameFlow extends JPanel
{
	private Deck deck;
	private Player [] players;
	private int numplayers;
	
	Scanner in = new Scanner( System.in);
	Random random = new Random ();
	
	public GameFlow()
	{
		deck = new Deck();
		JFrame window = new JFrame() ;
		window.setTitle("EKASI JACK");
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setResizable(true);
		window.setSize(500,500);
		window.setLocationRelativeTo(null);
		window.setVisible(true);
		
		//this handles the imageicon at the top left corner
		ImageIcon logo = new ImageIcon("logo.png");
		window.setIconImage(logo.getImage());
		//window.getContentPane().setBackground(Color.GREEN);
		
		JPanel panel = new JPanel();
		panel.setLayout(new BorderLayout());
		panel.setBackground(Color.GREEN);
		window.add(panel);
		
		// buttons
		JPanel buttons = new JPanel();
		buttons.setLayout(new BoxLayout(buttons,BoxLayout.Y_AXIS));
		JButton start = new JButton ( "START");
		JButton exit = new JButton("EXIT");
		start.setAlignmentX(Component.CENTER_ALIGNMENT);
		exit.setAlignmentX(Component.CENTER_ALIGNMENT);
		buttons.add(Box.createVerticalGlue()); 
        buttons.add(start);
		buttons.add(Box.createVerticalGlue()); 
		buttons.add(Box.createRigidArea(new Dimension(200, 100)));
		buttons.add(exit);
        buttons.add(Box.createVerticalGlue());
		
        panel.add(buttons,BorderLayout.SOUTH);
		window.getContentPane().setBackground(Color.GREEN);
		window.add(panel);
		
		//for the text
		JLabel welcome = new JLabel("EKASI JACK",JLabel.CENTER);
		welcome.setFont( new Font ("Serif",Font.BOLD,100));
		welcome.setForeground(Color.RED);
		welcome.setBackground(Color.LIGHT_GRAY);
		welcome.setOpaque(true);
		panel.add(welcome,BorderLayout.CENTER);
		
		//for the buttons to actually do something
		start.addActionListener(new ActionListener () {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(window,"Only 2 or more players can play this game");
				gamewindow();
			}
		});
		exit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		
	}
		
		
	public void gamewindow() {
		JFrame game = new JFrame();
		game.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		game.setResizable(true);
		game.setSize(500,500);
		game.getContentPane().setBackground(Color.BLACK);
		game.setLocationRelativeTo(null);
		//game.setVisible(true);
		
		ImageIcon logo2 = new ImageIcon("logo.png");
		game.setIconImage(logo2.getImage());
	
		
		// now for the graphics
		JPanel gamepanel = new JPanel();
	
		
	}
	
		
	
	
	
	public void playersMethod()
	{
		while (true) //emsures that only between 2 and 5 players are entered
		{
			System.out.println("There can only be two to five players in this game.");
			
			numplayers = in.nextInt();
			
			if(numplayers<2 || numplayers >5) //if the number of players is invalid, we ask them to enter again
			{
				continue;
			}
			
			else
			{  JoptionPane.showMessageDialog("There can only be 2 to 5 players");
				break;
			}
			game.setVisible(true);
		}
		
		
		players = new Player[numplayers]; // this  will store the array of player objects
		
		// a for loop to populate the player array
		for (int i =0 ; i < players.length ; i ++ )
		{
			players[i] = new Player ("Player" +( i+1));
		}
		// so this will have  PLayer 1, Player 2 , Player 3,Player 4 up to Player 5
	}
	
	public Player[] getPlayers()
	{
		return players;
    }
	
	public void handingCardsMethod() 
	{
		int cardstodistribute = 41/numplayers;
		int remainingcards= (41%numplayers)*numplayers;
		//while ( deck.getsize() !=0){
		    for ( int i =0 ; i< players.length; i++)
			{
				// this will call the distribute method from the deck class by 
				//giving it n(cardstodistribute)
				List<Card>maincards = deck.Distribute(cardstodistribute);
				for(int j =0 ; j < maincards.size();j++)
				{
					players[i].addcards(maincards.get(j));
				}//above for loop adds cards in the player's hands
				
			    if ( players[i].getHand().size() == cardstodistribute)
				{
					maincards.clear();
				}	
			}
		
		    for (int k=0 ; k< remainingcards; k++)
			{
				List<Card> extracard = deck.Distribute(remainingcards);
				for(int m =0; m<extracard.size();m++)
				{
					players[k].addcards( extracard.get(m));
			
			    }
			
				// players[k]. matchingcards();
               	// i commented this out because it just give the end result doesnt show the cards before removing so makes debugging hard
		    }
			// i just put this into chat to do it to make debugging easier, we can remove it later
			
			for (int i = 0; i < players.length; i++)
			{
				System.out.println("Player " + (i + 1) + " hand before removing matching cards: " + players[i].getHand() +"\n");
				players[i].matchingcards(); // Remove matching cards from each player's hand
				System.out.println("Player " + (i + 1) + " hand after removing matching cards: " + players[i].getHand() + "\n");
            }
	}
	
	public void play()
	{
		Hand hand = new Hand(players[1].getHand());
		//while()
		System.out.println("Which card would you like to give to the next player?");
		System.out.println("Face (0 - Clubs, 1 - diamonds, 2 - hearts, 3 - spades): ");
		int facePos = in.nextInt();
		
		System.out.println("Number (enter 1 if you wish to select Ace): ");
		int numPos = in.nextInt();
		
		Card card = new Card(facePos, numPos);
		
		hand.swap(card);
		
	}
}	