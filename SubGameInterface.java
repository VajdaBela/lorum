import java.util.Set;

public abstract class SubGameInterface {
	public GameState gameState;
	public abstract boolean isFinished();
	public abstract void dealPoints();

	public String strongestPlayer() {
		Set<String> players = gameState.getHolders();
		String strongestPlayer = "";

		for(String player : players) {
			if(strongestPlayer.equals("")) {
				strongestPlayer = player;
				continue;
			}
			Card newCard = gs.getPile(player+":played").getCards()[0];
			Card lastCard = gs.getPile(strongestPlayer+":played").getCards()[0];
			if(newCard.isStronger(lastCard)) {
				strongestPlayer = player;
			}
		}

		return strongestPlayer;
	}

	public void moveCards() {
		String strongest = strongestPlayer();
		CardHolder player = gameState.getHolder(strongest);

	}

}
