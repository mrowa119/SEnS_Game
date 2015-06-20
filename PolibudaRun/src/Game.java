import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JLabel;


public class Game {

	private final static int width = 20;
	private final static int height = 10;
	private List<int[][]> worlds;
	private int wolrdId;
	
	public static void main(String args[]) {
		Game g = new Game();
		g.loadTestWorlds();
		
		JFrame frame = new JFrame();
		frame.setSize(800, 600);
		frame.setVisible(true);
		
		g.makeLabels(frame);
		
	}

	public Game() {
		loadTestWorlds();
		Character character = new Character(width, height);
	}
	public Game(JFrame frame, Menu menu){
		
		loadTestWorlds();
		
	}
	
	public void start(){
		
	}
	
	public void fillBoard(JLabel[][] board, int[][] world, Character character){
		
	}
	public void loadTestWorlds(){
		
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
	}
	public void makeLabels(JFrame frame){
		
//		//pobieranie z frame wymiarow
//		int frameHeight = frame.getHeight();
//		int frameWidth = frame.getWidth();
//		
//		//oblicznie wymiatow jednego labela
//		int labelHeight = (frameHeight/height);
//		int labelWidth = (frameWidth/width);
//		System.out.println(labelHeight + "\n" + labelWidth);
		
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
	}
}
