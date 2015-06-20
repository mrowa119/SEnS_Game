
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class Game {
	//public Game(JFrame frame, Menu menu) {

	private final static int width = 20;
	private final static int height = 10;
	private List<int[][]> worlds;
	private int worldId;
	private JLabel[][] board;

	public Game(JFrame frame, Menu menu){
		
		loadTestWorlds();
		Character character = new Character(width, height);
		worlds = loadTestWorlds();
		board = makeLabels(frame);
		fillBoard(board, worlds.get(0), character);
	}

	public void start() {

	}

	public void fillBoard(JLabel[][] board, int[][] world, Character character) {

	}

	// czy pole aktualny swiat czy jest ostatnie to error koniec swiata
	// jesli nie to wczytaj ten swiat metod� fillworld throw exception opis 1
	// zdanie

	public void CzyJestNastepnySwiat(JLabel[][] etykieta, int[][] world,
			Character character) {
		if (this.worlds.size() == worldId) {
			try {
				throw new Exception("brak swiata");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} // brak kolejnego swiata
		}
		fillBoard(etykieta, world, character);
		worldId++;
	}
	public List loadTestWorlds(){
		
		worlds = new ArrayList<int[][]>();
		int[][] worldFirst = new int[10][20];
		
		for(int i = 0; i < 9; i++){
			for(int j = 0; j < 20; j++){
				worldFirst[i][j] = 0;
			}
		}
		for(int i = 0; i < 20; i++){
			worldFirst[9][i] = 1;
		}
		for(int i = 0; i < 10; i++){
			for(int j = 0; j < 20; j++){
				System.out.print(worldFirst[i][j]);
			}
			System.out.println();
		}
		worlds.add(worldFirst);
		
		return worlds;
	}
	public JLabel[][] makeLabels(JFrame frame){
		
//		//pobieranie z frame wymiarow
//		int frameHeight = frame.getHeight();
//		int frameWidth = frame.getWidth();
//		
//		//oblicznie wymiatow jednego labela
//		int labelHeight = (frameHeight/height);
//		int labelWidth = (frameWidth/width);
//		System.out.println(labelHeight + "\n" + labelWidth);
		
		// czyszczenie okna
		frame.getContentPane().removeAll();
		frame.repaint();
		
		GridLayout grid = new GridLayout(10, 20);
		frame.setLayout(grid);
		
		JLabel arrayOfLabels[][] = new JLabel[10][20];
		for(int i = 0; i < 10; i++){
			for(int j = 0; j < 20; j++){
				arrayOfLabels[i][j] = new JLabel("x");
				frame.add(arrayOfLabels[i][j]);
				
			}
		}
		
		//dopisane, aby elementy pokazywaly sie porawnie bez potrzeby zmiany rozmiaru 
		frame.setSize(800, 600);
		frame.setVisible(true);
		
		return arrayOfLabels;
	}
}
