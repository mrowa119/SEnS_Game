
public class HorizontalMove implements Runnable  {
	private Character c;
	private final int maxJumpHeigth = 4;
	private KeyList kl;

	public HorizontalMove(Character c, KeyList kl) {
		this.c = c;
		this.kl = kl;
	}

	public HorizontalMove() {
	}
	
	public void run(){
		up();
		down();
		kl.hmBlock = false;
	}

	private void down() {
		if( c==null ){
			try {
				throw new Exception("Brak Postaci");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		for(int i=0;i<maxJumpHeigth;i++){
			synchronized (c) {
				c.down();
			}
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

	private void up() {
		if( c==null ){
			try {
				throw new Exception("Brak Postaci");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		for(int i=0;i<maxJumpHeigth;i++){
			synchronized (c) {
				c.up();
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
