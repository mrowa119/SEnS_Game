import java.awt.GridLayout;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import org.imgscalr.Scalr;

public class Game {
	// public Game(JFrame frame, Menu menu) {

	private final static int width = 20;
	private final static int height = 10;
	private List<int[][]> worlds;
	private int worldId;
	private JLabel[][] board;
	private Character c;
	private static BufferedImage sky=null;
	private static BufferedImage down=null;
	private static BufferedImage ufo=null;
	
	static{
		try {
			sky = ImageIO.read(new File("../img/bg.png"));
			down = ImageIO.read(new File("../img/down.png"));
			ufo = ImageIO.read(new File("../img/ufo.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public Game(JFrame frame, Menu menu) {

		loadTestWorlds();
		worlds = loadTestWorlds();
		board = makeLabels(frame);
		fillBoard(board, worlds.get(0));
		worldId = 0;
		c = new Character(0, height - 2, worlds.get(0), board);
		frame.addKeyListener(new KeyList(c));
		frame.requestFocusInWindow();
	}

	public void start() {
		c.print(board);
	}

	public static void setValue(JLabel label, int value) {
		switch (value) {
		case 0: {
			setSky(label);
			break;
		}
		case 1: {
			setDown(label);
			break;
		}
		case 3: {
			setUfo(label);
			break;
		}
		}
	}

	private static void setSky(JLabel label) {
		// TODO Auto-generated method stub
		//label.setIcon(new ImageIcon(Scalr.resize(sky, label.getHeight(), label.getWidth())));
		label.setIcon(null);
	}
	
	private static void setDown(JLabel label) {
		// TODO Auto-generated method stub
		label.setIcon(new ImageIcon(Scalr.resize(down, label.getHeight(), label.getWidth())));
	}
	
	private static void setUfo(JLabel label) {
		// TODO Auto-generated method stub
		label.setIcon(new ImageIcon(Scalr.resize(ufo, label.getWidth(), label.getHeight())));
	}

	public void fillBoard(JLabel[][] board, int[][] world) {

		for (int i = 0; i < height; i++) {
			for (int j = 0; j < width; j++) {
				setValue(board[i][j], world[i][j]);
			}
		}

	}

	// czy pole aktualny swiat czy jest ostatnie to error koniec swiata
	// jesli nie to wczytaj ten swiat metodá fillworld throw exception opis 1
	// zdanie

	public void isNextWorld(JLabel[][] etykieta, int[][] world,
			Character character) {
		if (this.worlds.size() == worldId) {
			try {
				throw new Exception("brak swiata");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} // brak kolejnego swiata
		}
		fillBoard(etykieta, world);
		worldId++;
	}

	public List<int[][]> loadTestWorlds() {

		worlds = new ArrayList<int[][]>();
		int[][] worldFirst = new int[10][20];

		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 20; j++) {
				worldFirst[i][j] = 0;
			}
		}
		for (int i = 0; i < 20; i++) {
			worldFirst[9][i] = 1;
		}
/*		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 20; j++) {
				System.out.print(worldFirst[i][j]);
			}
			System.out.println();
		}*/
		worlds.add(worldFirst);

		return worlds;
	}

	public JLabel[][] makeLabels(JFrame frame) {

		// //pobieranie z frame wymiarow
		// int frameHeight = frame.getHeight();
		// int frameWidth = frame.getWidth();
		//
		// //oblicznie wymiatow jednego labela
		// int labelHeight = (frameHeight/height);
		// int labelWidth = (frameWidth/width);
		// System.out.println(labelHeight + "\n" + labelWidth);

		// czyszczenie okna
		frame.getContentPane().removeAll();
		frame.repaint();

		GridLayout grid = new GridLayout(10, 20);
		frame.setLayout(grid);

		JLabel arrayOfLabels[][] = new JLabel[10][20];
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 20; j++) {
				arrayOfLabels[i][j] = new JLabel();
				frame.add(arrayOfLabels[i][j]);

			}
		}

		// dopisane, aby elementy pokazywaly sie porawnie bez potrzeby zmiany
		// rozmiaru
		frame.setSize(800, 600);
		frame.setVisible(true);

		return arrayOfLabels;
	}
}
