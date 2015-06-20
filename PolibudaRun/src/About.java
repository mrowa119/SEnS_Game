import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;

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

public class About implements ActionListener {
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
		
		// tworzenie pola tekstowego
		String tekst = 
				"Ta oto\n politechnczna gierka\npowsta³a w ramach projektu\n\"Juwenaliowe Coding Dojo\"\norganizowanego"
				+ "przez ko³o nauowe\n\"SEnS\".";
		
		StyledDocument document = new DefaultStyledDocument();
		Style defaultStyle = document.getStyle(StyleContext.DEFAULT_STYLE);
		StyleConstants.setAlignment(defaultStyle, StyleConstants.ALIGN_CENTER);
		JTextPane jtp_about = new JTextPane(document);
		jtp_about.setBackground(Color.BLACK);
		jtp_about.setOpaque(false);
		jtp_about.setEditable(false);
		jtp_about.setFont(new Font(Font.SANS_SERIF, 3, 30));
		jtp_about.setText(tekst);
		jtp_about.setBounds(100, 50, 600, 300);
		
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
		frame.setTitle("O gierce...");
		frame.add(b_back);
		frame.add(jtp_about);
		frame.add(jl_infusion);
		frame.add(jl_primagia);
		frame.add(jl_sens);
		frame.validate();
		frame.repaint();
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		menu.createInterface(frame);
	}
}
