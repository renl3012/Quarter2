package elevens;

import java.util.List;
import java.util.ArrayList;

/**
 * The ElevensBoard class represents the board in a game of Elevens.
 */
public class ElevensAssessment extends Board{

	/**
	 * The size (number of cards) on the board.
	 */
	private static final int BOARD_SIZE = 9;

	/**
	 * The ranks of the cards for this game to be sent to the deck.
	 */
	private static final String[] RANKS =
		{"ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "jack", "queen", "king"};

	/**
	 * The suits of the cards for this game to be sent to the deck.
	 */
	private static final String[] SUITS =
		{"spades", "hearts", "diamonds", "clubs"};

	/**
	 * The values of the cards for this game to be sent to the deck.
	 */
	private static final int[] POINT_VALUES =
		{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 0, 0, 0};


	/**
	 * Creates a new <code>ElevensBoard</code> instance.
	 */
	public ElevensAssessment() {
		super(BOARD_SIZE, RANKS, SUITS, POINT_VALUES);
		
		System.out.println("Lucy Ren");
		System.out.println("Period 4");
		System.out.println("3/28/18");
		System.out.println("F106-01");
		
	}

	
	/**
	 * Determines if the selected cards form a valid group for removal.
	 * In Elevens, the legal groups are (1) a pair of non-face cards
	 * whose values add to 11, and (2) a group of three cards consisting of
	 * a jack, a queen, and a king in some order.
	 * @param selectedCards the list of the indices of the selected cards.
	 * @return true if the selected cards form a valid group for removal;
	 *         false otherwise.
	 */
	@Override
	public boolean isLegal(List<Integer> selectedCards) {
		/* *** TO BE IMPLEMENTED IN ACTIVITY 9 *** */
		
		if (selectedCards.size() == 3 && containsJQK(selectedCards)){
			return true;
		}
		else if (selectedCards.size() == 2 && containsPairSum11(selectedCards)){
			return true;
		}
		else if (selectedCards.size() == 3 && sum3(selectedCards)){
			return true;
		}
		else if(selectedCards.size() == 2 && sameFace(selectedCards)){
			return true;
		}
		return false;

	}

	/**
	 * Determine if there are any legal plays left on the board.
	 * In Elevens, there is a legal play if the board contains
	 * (1) a pair of non-face cards whose values add to 11, or (2) a group
	 * of three cards consisting of a jack, a queen, and a king in some order.
	 * @return true if there is a legal play left on the board;
	 *         false otherwise.
	 */
	
	@Override
	public boolean anotherPlayIsPossible() {
		/* *** TO BE IMPLEMENTED IN ACTIVITY 9 *** */
		
		ArrayList<Integer> checkCards = new ArrayList<Integer>();
		for (int i = 0; i <= 8; i++){
			checkCards.add(i);
		}
		if (containsJQK(checkCards)){
			return true;
		}
		else if (containsPairSum11(checkCards)){
			return true;
		}
		else if (sum3(checkCards)){
			return true;
		}
		else if(sameFace(checkCards)){
			return true;
		}
		System.out.println("Sorry, you lose.");
		return false;
	}


	/**
	 * Check for an 11-pair in the selected cards.
	 * @param selectedCards selects a subset of this board.  It is list
	 *                      of indexes into this board that are searched
	 *                      to find an 11-pair.
	 * @return true if the board entries in selectedCards
	 *              contain an 11-pair; false otherwise.
	 */
	private boolean containsPairSum11(List<Integer> selectedCards) {
		/* *** TO BE IMPLEMENTED IN ACTIVITY 9 *** */
		int total = 0;
		for (int cardA:selectedCards){
			for (int cardB:selectedCards){
				total += (super.cardAt(cardA)).pointValue();
				total += (super.cardAt(cardB)).pointValue();
				if (total == 11){
					return true;
				}
				total = 0;
			}
		}
		return false;
	}

	/**
	 * Check for a JQK in the selected cards.
	 * @param selectedCards selects a subset of this board.  It is list
	 *                      of indexes into this board that are searched
	 *                      to find a JQK group.
	 * @return true if the board entries in selectedCards
	 *              include a jack, a queen, and a king; false otherwise.
	 */
	private boolean containsJQK(List<Integer> selectedCards) {
		/* *** TO BE IMPLEMENTED IN ACTIVITY 9 *** */
		int total = 0;
		boolean j = false, q = false, k = false;

		/*for (int face:selectedCards){
			if(cards[face].rank() == "jack"){
				j = true;
			}
			else if(cards[face].rank() == "queen"){
				q = true;
			}
			else if(cards[face].rank() == "king"){
				k = true;
			}
		}*/
		
		for (int face:selectedCards){
			if((super.cardAt(face)).rank() == "jack"){
				j = true;
			}
			else if((super.cardAt(face)).rank() == "queen"){
				q = true;
			}
			else if((super.cardAt(face)).rank() == "king"){
				k = true;
			}
		}
		return (j&&q)&&k;
	}
	
	private boolean sum3(List<Integer> selectedCards){
		int total = 0;
		for (int cardA:selectedCards){
			for (int cardB:selectedCards){
				for (int cardC:selectedCards){
					total += (super.cardAt(cardA)).pointValue();
					total += (super.cardAt(cardB)).pointValue();
					total += (super.cardAt(cardC)).pointValue();
					if (total == 11){
						return true;
					}
					total = 0;
				}
			}	
		}
		return false;
	}
	
	private boolean sameFace(List<Integer> selectedCards){
		boolean pair = false;
		for(int face:selectedCards){
			for(int face2:selectedCards){
				if((super.cardAt(face)).rank() == "jack" && (super.cardAt(face2)).rank() == "jack"){
					pair = true;
				}
				else if ((super.cardAt(face)).rank() == "queen" && (super.cardAt(face2)).rank() == "queen"){
					pair = true;
				}
				else if ((super.cardAt(face)).rank() == "king" && (super.cardAt(face2)).rank() == "king"){
					pair = true;
				}
			}
		}
		return pair;
	}
	
}