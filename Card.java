enum Card {
	H7, H8, H9, H0, H1, H2, H3, H4,
	B7, B8, B9, B0, B1, B2, B3, B4,
	A7, A8, A9, A0, A1, A2, A3, A4,
	L7, L8, L9, L0, L1, L2, L3, L4;

	public boolean isStronger(Card other) {
		char thisColor = this.name().charAt(0);
		char otherColor = other.name().charAt(0);

		if(thisColor != otherColor) {
			return false;
		}
		if(this.compareTo(other) < 0) {
			return true;
		}
		else return false;

	}
}
