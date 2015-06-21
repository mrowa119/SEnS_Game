import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextPane;
import javax.swing.text.DefaultStyledDocument;
import javax.swing.text.Style;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyleContext;
import javax.swing.text.StyledDocument;

import org.imgscalr.Scalr;

public class Scored implements ActionListener {
	Menu menu = null;
	JFrame frame = null;
	JButton b_back = null;

	public void createInterface(JFrame frame, Menu menu) {
		// ustawianie okna i menu w klasie
		this.frame = frame;
		this.menu = menu;

		// czyszczenie okna
		frame.getContentPane().removeAll();
		frame.repaint();

		// tworzenie buttona z powrotem do menu
		b_back = new JButton("< MENU");
		b_back.setBorderPainted(false);
		b_back.setFocusPainted(false);
		b_back.setBackground(new Color(65, 131, 215));
		b_back.setBounds(0, 0, 150, 50);
		b_back.setFont(new Font(Font.SANS_SERIF, 2, 30));
		b_back.addActionListener(this);

		// wczytywanie danych z pliku
		FileReader fr = null;
		String linia = "";
		String x = "";
		String[] tab = new String[50];

		// OTWIERANIE PLIKU:
		try {
			fr = new FileReader(new File("../save.txt"));
		} catch (FileNotFoundException e) {
			System.out.println("BLAD PRZY OTWIERANIU PLIKU!");
			System.exit(1);
		}
		BufferedReader bfr = new BufferedReader(fr);
		// ODCZYT KOLEJNYCH LINII Z PLIKU:
		try {
			while ((linia = bfr.readLine()) != null) {
				x += linia + " ";
			}
			tab = x.split(" ");

		} catch (IOException e) {
			System.out.println("BLAD ODCZYTU Z PLIKU!");
			System.exit(2);
		}

		// ZAMYKANIE PLIKU
		try {
			fr.close();
		} catch (IOException e) {
			System.out.println("BLAD PRZY ZAMYKANIU PLIKU!");
			System.exit(3);
		}
		// dzielenie danych na loginy i wyniki
		String a = "";
		String b = "";
		for (int i = 0; i < tab.length; i++) {
			if (i % 2 == 0) {
				a += tab[i] + "\n";
			} else {
				b += tab[i] + "\n";
			}
		}
		StyledDocument document = new DefaultStyledDocument();
		Style defaultStyle = document.getStyle(StyleContext.DEFAULT_STYLE);
		StyleConstants.setAlignment(defaultStyle, StyleConstants.ALIGN_LEFT);
		JTextPane jtp_scored = new JTextPane(document);
		jtp_scored.setBackground(Color.BLACK);
		jtp_scored.setOpaque(false);
		jtp_scored.setEditable(false);
		jtp_scored.setFont(new Font(Font.SANS_SERIF, 3, 30));
		jtp_scored.setBounds(50, 50, 300, 600);
		jtp_scored.setText(a);

		StyledDocument document2 = new DefaultStyledDocument();
		Style defaultStyle2 = document2.getStyle(StyleContext.DEFAULT_STYLE);
		StyleConstants.setAlignment(defaultStyle2, StyleConstants.ALIGN_RIGHT);
		JTextPane jtp_scored2 = new JTextPane(document2);
		jtp_scored2.setBackground(Color.BLACK);
		jtp_scored2.setOpaque(false);
		jtp_scored2.setEditable(false);
		jtp_scored2.setFont(new Font(Font.SANS_SERIF, 3, 30));
		jtp_scored2.setBounds(350, 50, 300, 600);

		jtp_scored2.setText(b);

		// dodawanie sponsorÃ³w
		BufferedImage infusion = null;
		BufferedImage primagia = null;
		BufferedImage sens = null;
		try {
			infusion = ImageIO.read(new File("../loga/infusion.png"));
			primagia = ImageIO.read(new File("../loga/primagia.png"));
			sens = ImageIO.read(new File("../loga/sens.png"));
		} catch (Exception ex) {
			System.out.println("Brak plików graficznych.");
		}

		infusion = Scalr.resize(infusion, 200, 200);
		primagia = Scalr.resize(primagia, 200, 200);
		sens = Scalr.resize(sens, 200, 200);

		JLabel jl_infusion = new JLabel(new ImageIcon(infusion));
		JLabel jl_primagia = new JLabel(new ImageIcon(primagia));
		JLabel jl_sens = new JLabel(new ImageIcon(sens));

		jl_infusion.setBounds(50, 400, 200, 200);
		jl_primagia.setBounds(300, 400, 200, 200);
		jl_sens.setBounds(550, 400, 200, 200);

		// organizacja okna
		frame.setTitle("Wyniki");
		frame.add(b_back);
		frame.add(jtp_scored);
		frame.add(jtp_scored2);
		frame.add(jl_infusion);
		frame.add(jl_primagia);
		frame.add(jl_sens);
		frame.validate();
		frame.repaint();
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		menu.createInterface(frame);

	}
}