import java.util.HashMap;
import java.util.Arrays;
import java.util.Set;

public class GameState {
	public HashMap<String, CardHolder> holders = new HashMap<>();

	public GameState(String[] playerNames) {
		for(String player : playerNames) {
			holders.put(player, new CardHolder(player, new String[]{"hand", "collected", "played"}));
		}
	}

	public CardHolder getHolder(String name) {
		return holders.get(name);
	}

	public CardPile getPile(String name) {
		String[] nameParts = name.split(":");
		return getHolder(nameParts[0]).getPile(nameParts[1]);
	}

	public void moveCard(String source, String destination, Card card) {
		getPile(source).exchangeCard(getPile(destination), card);
	}

	public String toString() {
		return holders.toString();
	}

	public Set<String> getHolders() {
		return holders.keySet();
	}

	public void deal() {
		Card[] cards = Card.values();

		for(int i = cards.length; i != 0;) {
			int switchIndex = (int)(Math.random()*i);
			i--;
			Card tmp = cards[switchIndex];
			cards[switchIndex] = cards[i];
			cards[i] = tmp;
		}

		int playerNumber = holders.keySet().size();
		int sizeOfHand = (int)(cards.length / playerNumber);
		CardHolder[] players = holders.values().toArray(new CardHolder[0]);
		for(int i = 0; i < playerNumber; i++) {
			int begining = i * sizeOfHand;
			int end = begining + sizeOfHand;
			players[i].addCards("hand", Arrays.copyOfRange(cards, begining, end));
		}
	}
}
