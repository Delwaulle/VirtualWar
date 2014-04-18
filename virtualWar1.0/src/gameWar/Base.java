package gameWar;

/**
 * @author Robin
 *
 */
public class Base extends Cellule {
	
	/**
	 * @param equipe
	 */
	public Base (int equipe) {
		this.base=equipe;
	}
	
	/* (non-Javadoc)
	 * @see gameWar.Cellule#placerSur(gameWar.Robot)
	 */
	public void placerSur(Robot r) {
		this.r=r;
	}
	
	/* (non-Javadoc)
	 * @see gameWar.Cellule#videCase()
	 */
	public void videCase() {
		this.r=null;
		this.mine=0;
	}

}
