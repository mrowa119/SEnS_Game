import javax.swing.JLabel;

import org.imgscalr.Scalr;

public class Character {
	private int x;
	private int y;
	private int[][] world;
	private JLabel[][] board;

	public Character(int y, int x, int[][] world, JLabel[][] board) {
		this.x = x;
		this.y = y;
		this.world = world;
		this.board = board;
	}

	public void up() {
		remove(board, world);
		this.x -= 1;
		print(board);
	}

	public void down() {
		remove(board, world);
		this.x += 1;
		print(board);
	}

	public void left() {
		if (y > 0) {
			remove(board, world);
			this.y -= 1;
			print(board);
		}
	}

	public void rigth() {
		remove(board, world);
		this.y += 1;
		print(board);
	}

	public void print(JLabel[][] board) {
		Game.setValue(board[x][y], 3);
	}

	public void remove(JLabel[][] board, int[][] world) {
		Game.setValue(board[x][y], world[x][y]);
	}

	@Override
	public String toString() {
		return "Character [x=" + x + ", y=" + y + "]";
	}

}