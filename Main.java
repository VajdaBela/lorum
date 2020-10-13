import java.util.Arrays;

public class Main {
	public static void main(String[] args) {
		GameState gs = new GameState(new String[]{"bob", "jill", "sam", "tom"});
		System.out.println(gs);


		gs.deal();
		System.out.println(gs);

		Card[] cs = gs.getPile("bob:hand").getCards();
		System.out.println(Arrays.toString(cs));
	}
}
