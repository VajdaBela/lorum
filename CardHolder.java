import java.util.HashMap;

public class CardHolder implements CardExchangerInterface {
	HashMap<String, CardPile> piles = new HashMap<>();
	private String name;

	public CardHolder(String name, String[] pileNames) {
		this.name = name;
		for(String pileName : pileNames) {
			piles.put(pileName, new CardPile());
		}
	}

	public void shiftCard(CardExchangerInterface recipient, String source, String destination, Card card) {
		getPile(source).exchangeCard(recipient.getPile(destination), card);
	}

	public CardPile getPile(String name) {
		return piles.get(name);
	}

	public String toString() {
		return piles.toString();
	}

	public void addCards(String pileName, Card[] cards) {
		CardPile pile = getPile(pileName);
		for(Card card : cards) {
			pile.add(card);
		}
	}


}
