public class Character {
	private int X;
	private int Y;

	public Character(int x, int y) {
		this.X = x;
		this.Y = y;
	}

	public void up() {
		this.Y += 1;
	}

	public void down() {
		this.Y -= 1;
	}

	public void left() {
		this.X -= 1;
	}

	public void rigth() {
		this.X += 1;
	}
}