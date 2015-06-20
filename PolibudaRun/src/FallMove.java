
public class FallMove implements Runnable  {
	private Character c;


	public FallMove(Character c) {
		this.c = c;
	}


	public void run(){
		down();
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
		boolean onAir=true;
		while(onAir){
			synchronized (c) {
				try {
					c.down();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					onAir=false;
					//e.printStackTrace();
				}
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
