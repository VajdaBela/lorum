public interface CardExchangerInterface {
	public void shiftCard(CardExchangerInterface recipient, String source, String dextination, Card card);
	public CardPile getPile(String pile);
}
