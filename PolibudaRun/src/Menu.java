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
import javax.swing.JPanel;

import org.imgscalr.Scalr;


public class Menu implements ActionListener {
	
	private final static int frameX=20, frameY=10;
	private JFrame frame;
	private JButton startB;
	private JButton aboutB;
	private JButton quitB;
	private JButton scoreB;

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Hello World!!! \nTestuje sobie");
		Menu m = new Menu();
		m.createInterface(m.createFrame(800, 600));
	}
	
	public JFrame createFrame(int width,int height){
		
		frame = new JFrame("Polibuda Run");
		frame.setSize(width, height);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(null);
		frame.setVisible(true);
		frame.getContentPane().setBackground(new Color(174, 168, 211));
		
		frame.addKeyListener(new KeyList(new Character(5, 5)));
		
		return frame;
	}
	
	public void createInterface(JFrame frame){
		// czyszczenie okna
		frame.getContentPane().removeAll();
		frame.repaint();
		
		//przyciski
		startB = new JButton("nowa gra");
		aboutB = new JButton("o programie");
		quitB = new JButton("wyj�cie");
		scoreB = new JButton("wyniki");

		
		// wygląd przycisków
		startB.setBorderPainted(false);
		startB.setFocusPainted(false);
		startB.setBackground(new Color(46, 204, 113));
		startB.setFont(new Font(Font.SANS_SERIF, 2, 30));
		
		aboutB.setBorderPainted(false);
		aboutB.setFocusPainted(false);
		aboutB.setBackground(new Color(65, 131, 215));
		aboutB.setFont(new Font(Font.SANS_SERIF, 2, 30));
		
		quitB.setBorderPainted(false);
		quitB.setFocusPainted(false);
		quitB.setBackground(new Color(210, 77, 87));
		quitB.setFont(new Font(Font.SANS_SERIF, 2, 30));
		
		scoreB.setBorderPainted(false);
		scoreB.setFocusPainted(false);
		scoreB.setBackground(new Color(249, 255, 54));
		scoreB.setFont(new Font(Font.SANS_SERIF, 2, 30));
		
		//obsluga zdarzen
		startB.addActionListener(this);
		aboutB.addActionListener(this);
		quitB.addActionListener(this);
		scoreB.addActionListener(this);

			
		//umiejscowienie
		
		startB.setBounds(300, 50, 200, 80);
		aboutB.setBounds(300, 150, 200, 80);
		scoreB.setBounds(300, 250, 200, 80);
		quitB.setBounds(300, 350, 200, 80);

		
		// dodawanie sponsorów
		BufferedImage infusion = null;
		BufferedImage primagia = null;
		BufferedImage sens = null;
		try {
			infusion = ImageIO.read(new File("../loga/infusion.png"));
			primagia = ImageIO.read(new File("../loga/primagia.png"));
			sens = ImageIO.read(new File("../loga/sens.png"));
		} catch (Exception ex) {
			System.out.println("nic");
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
	
		//dodawanie
		frame.add(startB);
		frame.add(aboutB);
		frame.add(quitB);
		frame.add(scoreB);
		frame.add(jl_infusion);
		frame.add(jl_primagia);
		frame.add(jl_sens);
		frame.repaint();
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		if(e.getSource() == startB){
			
			Game g = new Game(frame, this);
			g.start();
			
		}
		else if(e.getSource() == aboutB){
			
			About a = new About();
			a.createInterface(frame, this);
		}
		else if(e.getSource() == scoreB)
		{
			Scored s = new Scored();
			s.createInterface(frame, this);
		}
		else{
			frame.dispose();
		}
		
	}
	
	
}
