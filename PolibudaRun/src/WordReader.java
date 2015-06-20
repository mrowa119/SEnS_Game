import java.util.ArrayList;
import java.util.List;

// te biblioteki moga byc nie potrzebne
import javax.swing.JFrame;
import javax.swing.JLabel;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class WordReader {
	static int[][] wczytaj(String filename) { // wczytana bez .txt
		List<int[][]> lista = new ArrayList<int[][]>();
		filename += ".txt";
		File plik = new File(filename);
		// Scanner odczyt = new Scanner(new File("nazwa_pliku.txt"));
		Scanner scanner = new Scanner(plik);
		BufferedReader fileReader = null;
		fileReader = new BufferedReader(new FileReader(path));
		String readedData, readedData2;
		int maxX, maxY, iloscSwiatow;
		if (plik.isFile()) {
			readedData = fileReader.readLine(); // po to zeby ominac poczatkowa
												// linijke
			maxX = scanner.nextInt();
			maxY = scanner.nextInt();
			iloscSwiatow = scanner.nextInt();
			for (int i = 0; i < iloscSwiatow; i++) { //zewnetrzna petla dla ilosci swiatow
				for (int y = 0; y < maxY; y++) {
					for (int x = 0; x < maxX; x++) {
						lista[x][y] = scanner.nextInt();
					}
				}
			}
		}
		// else throw new Exception("plik" << filename << "nie istnieje");

		return lista;
	}
}
