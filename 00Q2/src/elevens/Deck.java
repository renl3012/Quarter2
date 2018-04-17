package elevens;

	import java.util.List;
	import java.util.ArrayList;
	import java.util.Random;

	/**
	 * The cards class represents a shuffled cards of cards.
	 * It provides several operations including
	 *      initialize, shuffle, deal, and check if empty.
	 */
	public class Deck {

		/**
		 * cards contains all the cards in the cards.
		 */
		//private List<Card> cards;
		
		//Unit 9 - Array version of the cards
		private ArrayList<Card> cards = new ArrayList<Card>();

		/**
		 * size is the number of not-yet-dealt cards.
		 * Cards are dealt from the top (highest index) down.
		 * The next card to be dealt is at size - 1.
		 */
		private int size;


		/**
		 * Creates a new <code>cards</code> instance.<BR>
		 * It pairs each element of ranks with each element of suits,
		 * and produces one of the corresponding card.
		 * @param ranks is an array containing all of the card ranks.
		 * @param suits is an array containing all of the card suits.
		 * @param values is an array containing all of the card point values.
		 */
		public Deck(String[] ranks, String[] suits, int[] values) {
			size = 0;
			/* *** TO BE IMPLEMENTED IN ACTIVITY 2 *** */
			for (int a = 0; a <= suits.length-1; a++){
				String tempSuit = suits[a];
				for (int b = 0; b <= ranks.length-1; b++){
					String tempRank = ranks[b];
					int tempValue = values[b];
					Card tempCard = new Card(tempRank, tempSuit, tempValue);
					cards.add(tempCard);
					size++;
				}	
			}
			this.shuffle();
		}


		/**
		 * Determines if this cards is empty (no undealt cards).
		 * @return true if this cards is empty, false otherwise.
		 */
		public boolean isEmpty() {
			/* *** TO BE IMPLEMENTED IN ACTIVITY 2 *** */
			if (size == 0){
				return true;
			}
			return false;
		}

		/**
		 * Accesses the number of undealt cards in this cards.
		 * @return the number of undealt cards in this cards.
		 */
		public int size() {
			/* *** TO BE IMPLEMENTED IN ACTIVITY 2 *** */
			return size;
		}

		/**
		 * Randomly permute the given collection of cards
		 * and reset the size to represent the entire cards.
		 */
		public void shuffle() {
			/* *** TO BE IMPLEMENTED IN ACTIVITY 4 *** */
			Card storeCard;
			size = cards.size();
			for (int k = cards.size()-1; k >= 0; k--){
				int r = (int)(Math.random()*cards.size());
				storeCard = cards.get(k);
				cards.set(k, cards.get(r));
				cards.set(r, storeCard);
			}
		}

		/**
		 * Deals a card from this cards.
		 * @return the card just dealt, or null if all the cards have been
		 *         previously dealt.
		 */
		public Card deal() {
			/* *** TO BE IMPLEMENTED IN ACTIVITY 2 *** */
			Card dealtCard = cards.get(0);
			if(size > 0){
				size--;
				dealtCard = cards.get(size);
				return dealtCard;
			}
		return dealtCard;
		}

		/**
		 * Generates and returns a string representation of this cards.
		 * @return a string representation of this cards.
		 */
		@Override
		public String toString() {
			String rtn = "size = " + size + "\n\nUndealt cards: \n";


			//Unit 9 - modify to work with Arrays
			
			for (int k = size - 1; k >= 0; k--) {
				rtn = rtn + cards.get(k);
				if (k != 0) {
					rtn = rtn + ", ";
				}
				if ((size - k) % 2 == 0) {
					// Insert carriage returns so entire cards is visible on console.
					rtn = rtn + "\n";
				}
			}

			rtn = rtn + "\nDealt cards: ";
			for (int k = size - 1; k >= size; k--) {
				rtn = rtn + cards.get(k);
				if (k != size) {
					rtn = rtn + ", ";
				}
				if ((k - size) % 2 == 0) {
					// Insert carriage returns so entire cards is visible on console.
					rtn = rtn + "\n";
				}
			}
			

			rtn = rtn + "\n";
			return rtn;
		}
	}