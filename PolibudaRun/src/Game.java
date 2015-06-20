import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class Game {
	List<int[][]> worlds = new ArrayList<int[][]>();

	// potem do wyrzucenia ta lista

	public Game(JFrame frame, Menu menu) {

	}

	public void start(JFrame frame) {
		frame.addKeyListener(new KeyList(c));
	}

	public void fillBoard(JLabel[][] board, int[][] world, Character character) {

	}

	// czy pole aktualny swiat czy jest ostatnie to error koniec swiata
	// jesli nie to wczytaj ten swiat metodá fillworld throw exception opis 1
	// zdanie

	public void setValue(JLabel label, int value) {
		switch (value) {
		case 0: {
			label.setText("N");
			break;
		}
		case 1: {
			label.setText("Z");
			break;
		}
		}
	}

	public void isNextWorld(JLabel[][] etykieta, int[][] world,
			Character character) {
		if (this.worlds.size() == worldId) {
			throw new Exception("brak swiata"); // brak kolejnego swiata
			return;
		}
		fillBoard(etykieta, world, character);
		worldId++;
	}
}
