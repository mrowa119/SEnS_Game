import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class Menu implements ActionListener {
	
	private final static int frameX=20, frameY=10;
	private JFrame frame;
	private JButton startB;
	private JButton aboutB;
	private JButton quitB;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Hello World!!! \nTestuje sobie");
		Menu m = new Menu();
		m.createInterface(m.createFrame(800, 600));
	}
	
	public JFrame createFrame(int width,int height){
		
		frame = new JFrame("Dupa");
		frame.setSize(width, height);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(null);
		frame.setVisible(true);
		
		return frame;
	}
	
	public void createInterface(JFrame frame){
		
		
		//przyciski
		startB = new JButton("nowa gra");
		aboutB = new JButton("o programie");
		quitB = new JButton("wyjœcie");
		
		//obsluga zdarzen
		startB.addActionListener(this);
		aboutB.addActionListener(this);
		quitB.addActionListener(this);
			
		//umiejscowienie
		
		startB.setBounds(320, 100, 160, 80);
		aboutB.setBounds(320, 200, 160, 80);
		quitB.setBounds(320, 300, 160, 80);
		
		
		//dodawanie
		frame.add(startB);
		frame.add(aboutB);
		frame.add(quitB);
		
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
		else{
			
			frame.dispose();
		}
		
	}
	
	
}
