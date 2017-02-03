import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class CardWindow extends JFrame{
	
	private static final int WIDTH = 800;
	private static final int HEIGHT = 800;
	private Deck newDeck = new Deck();
	private JTextField inputCardsField;
	
	public CardWindow()
	{
		super();
		setSize(WIDTH, HEIGHT);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Card Window");
		
		JPanel container = new JPanel();
		container.setLayout(new BoxLayout(container, BoxLayout.X_AXIS));
		
		JPanel defaultButtonsPanel = new JPanel();
		add(defaultButtonsPanel);

		JButton displayDeck = new JButton("Display Deck");
		displayDeck.addActionListener(new displayDeckButtonListener());
		
		JButton shuffleDeck = new JButton("Shuffle Deck");
		shuffleDeck.addActionListener(new shuffleDeckButtonListener());
		
		JButton drawCard = new JButton("Draw Card");
		drawCard.addActionListener(new drawCardButtonListener());
		
		JButton resetDeck = new JButton("Reset Deck");
		resetDeck.addActionListener(new resetDeckButtonListener());
		
		defaultButtonsPanel.add(displayDeck);
		defaultButtonsPanel.add(shuffleDeck);
		defaultButtonsPanel.add(resetDeck);
		
		JPanel p1 = new JPanel();
		p1.add(new JLabel("Enter the amount of cards you want to draw:"));
		inputCardsField = new JTextField(5);
		p1.add(inputCardsField);
		JButton drawCards = new JButton("Draw Cards");
		drawCards.addActionListener(new drawMultipleCards());
		p1.add(drawCards);
		
		container.add(defaultButtonsPanel);
		container.add(p1);
		
		add(container);
	}
	
	private class displayDeckButtonListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			newDeck.printList();
			System.out.println();
		}
	}
	
	private class shuffleDeckButtonListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			newDeck.shuffle();
			newDeck.printList();
			System.out.println();
		}
	}
	
	private class drawCardButtonListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			System.out.println(newDeck.drawFromDeck());
			System.out.println();
		}
	}
	
	private class resetDeckButtonListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			newDeck = new Deck();
			newDeck.printList();
		}
	}
	
	private class drawMultipleCards implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			try
			{
				Integer cardsDrawn = Integer.parseInt(inputCardsField.getText());
				try
				{
					if (cardsDrawn >= 0 && cardsDrawn <= newDeck.getTotalSize())
					{
						System.out.println(newDeck.drawFromDeck(cardsDrawn));
						System.out.println();
					}
					else
					{
						throw new InvalidNumberException();
					}
				}
				catch (InvalidNumberException error)
				{
					JFrame frame = new JFrame();
					frame.setVisible(true);
					frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
					JOptionPane.showMessageDialog(frame, "Please enter an integer value between 0 and " + newDeck.getTotalSize());
				}
			}
			catch (NumberFormatException error)
			{
				JFrame frame = new JFrame();
				frame.setVisible(true);
				frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
				JOptionPane.showMessageDialog(frame, "Please enter an integer value");
			}
		}
	}
}
