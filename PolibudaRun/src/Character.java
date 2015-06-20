public class Character {
	private int x;
	private int y;

	
	public Character(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public void up() {
		this.y += 1;
	}

	public void down() {
		this.y -= 1;
	}

	public void left() {
		this.x -= 1;
	}

	public void rigth() {
		this.x += 1;
	}

	@Override
	public String toString() {
		return "Character [x=" + x + ", y=" + y + "]";
	}
	
	
}