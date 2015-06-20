import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyList implements KeyListener {
	private Character c;
	private HorizontalMove hm;
	boolean hmBlock;

	public KeyList() {

	}

	public KeyList(Character c) {
		this.c = c;
		hm = new HorizontalMove(c, this);
		hmBlock = false;
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		int c = e.getKeyCode();
		if (!(this.c == null)) {
			switch (c) {
			case KeyEvent.VK_UP: {
				if (!hmBlock) {
					hmBlock = true;
					new Thread(hm).start();
				}
				break;
			}
			case KeyEvent.VK_LEFT:
				this.c.left();
				break;
			case KeyEvent.VK_RIGHT:
				this.c.rigth();
				break;
			}
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}
}
