import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;

public class KeyList implements KeyListener, Runnable{
	private Character c;
	private JumpMove hm;
	boolean hmBlock;
	private boolean isLeftPressed;
	private boolean isRigthPressed;
	private JFrame frame;
	private Menu menu;

	public KeyList() {

	}

	public KeyList(Character c, JFrame frame, Menu menu) {
		this.c = c;
		hm = new JumpMove(c, this, 4);
		hmBlock = false;
		this.frame=frame;
		this.menu=menu;
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		int c = e.getKeyCode();
		if (!(this.c == null)) {
			switch (c) {
			case KeyEvent.VK_UP:
			case KeyEvent.VK_SPACE: {
				if (!hmBlock) {
					hmBlock = true;
					new Thread(hm).start();
				}
				break;
			}
			case KeyEvent.VK_ESCAPE:{
				frame.setLayout(null);
				menu.createInterface(frame); 
				frame.removeKeyListener(this);
				break;
			}
			case KeyEvent.VK_LEFT: isLeftPressed = true; break;
			case KeyEvent.VK_RIGHT: isRigthPressed = true; break;
			}

		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		int c = e.getKeyCode();
		if (!(this.c == null)) {
			switch (c) {
			case KeyEvent.VK_LEFT: isLeftPressed = false; break;
			case KeyEvent.VK_RIGHT: isRigthPressed = false; break;
			}

		}
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(true){
			if(isLeftPressed){
				this.c.left();
			}
			if(isRigthPressed){
				this.c.rigth();
			}
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
