package elevens;

/**
 * This is a class that tests the Deck class.
 */
public class DeckTester {

	/**
	 * The main method in this class checks the Deck operations for consistency.
	 *	@param args is not used.
	 */
	
	static String[] ranks = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};
	static String[] suits = {"Hearts", "Spades", "Clubs", "Stars"};
	static int[] pointValues = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 10, 10, 10};
	
	
	public static void main(String[] args) {
		/* *** TO BE IMPLEMENTED IN ACTIVITY 2 *** */

		
		Deck deck1 = new Deck(ranks, suits, pointValues);
				System.out.println(deck1);
				deck1.size();

		Deck deck2 = new Deck(ranks, suits, pointValues);
				System.out.println(deck2.deal());
				System.out.println(deck2.deal());
				System.out.println(deck2.deal());
				

		Deck deck3 = new Deck(ranks, suits, pointValues);
				System.out.println(deck3.isEmpty());
				
		Deck newDeck = new Deck(ranks, suits, pointValues);
				newDeck.shuffle();
				System.out.println(newDeck);
	}
}