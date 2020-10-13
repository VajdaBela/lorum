import java.util.HashSet;

public class CardPile {
	private HashSet<Card> cards = new HashSet<>();

	public void exchangeCard(CardPile destination, Card card) {
		remove(card);
		destination.add(card);
	}

	public void add(Card card) {
		cards.add(card);
	}

	public void remove(Card card) {
		cards.remove(card);
	}

	public String toString() {
		return cards.toString();
	}

	public Card[] getCards() {
		return cards.toArray(new Card[0]);
	}
}
