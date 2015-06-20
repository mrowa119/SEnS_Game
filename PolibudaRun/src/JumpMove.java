
public class JumpMove implements Runnable  {
	private Character c;
	private int maxJumpHeigth = 4;
	private KeyList kl;

	public JumpMove(Character c, KeyList kl, int jumpHeigth) {
		this.c = c;
		this.kl = kl;
		maxJumpHeigth = jumpHeigth;
	}
	
	public void run(){
		c.isUpMove=true;
		up();
		c.isUpMove=false;
		(new FallMove(c)).run();
		kl.hmBlock = false;
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
