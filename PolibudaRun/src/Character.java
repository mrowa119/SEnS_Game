import java.awt.Robot;
import java.awt.event.KeyEvent;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import org.imgscalr.Scalr;

public class Character {
	private int x;
	private int y;
	private int[][] world;
	private JLabel[][] board;
	private Game game;
	public boolean isUpMove = false;

	public Character(int y, int x, int[][] world, JLabel[][] board, Game game) {
		this.x = x;
		this.y = y;
		this.world = world;
		this.board = board;
		this.game = game;
	}
	
	public void reset(){
		x = world.length - 2;
		y = 0;
	}
	

	public void up() {
		synchronized (board) {
			if (x > 0)
				if (world[x - 1][y] == 0) {
					remove(board, world);
					this.x -= 1;
					print(board);
				}
		}
	}

	public void down() throws Exception {
		synchronized (board) {
			if (x >= world.length - 1) {
				JOptionPane.showMessageDialog(null, "Przegra³eœ !!!");
				Robot r = new Robot();
				r.keyPress(KeyEvent.VK_ESCAPE);
				
				throw new Exception("Dead");
			} else if (world[x + 1][y] == 0) {
				remove(board, world);
				this.x += 1;
				print(board);
			} else
				throw new Exception("B³¹d spadania");
		}
	}

	public void left() {
		synchronized (board) {
			if (y > 0)
				if (world[x][y - 1] == 0) {

					remove(board, world);
					this.y -= 1;
					print(board);
					if (!isUpMove)
						new Thread(new FallMove(this)).start();
				}
		}
	}

	public void rigth() {
		if (y < world[0].length - 1) {
			synchronized (board) {
				if (world[x][y + 1] == 0) {
					remove(board, world);
					this.y += 1;
					print(board);
					if (!isUpMove)
						new Thread(new FallMove(this)).start();
				}
			}
		} else {
			game.nextWorld();
		}
	}

	public void newWorld(int[][] world) {
		synchronized (board) {
			remove(board, world);
			this.world = world;
			reset();
			print(board);
		}
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