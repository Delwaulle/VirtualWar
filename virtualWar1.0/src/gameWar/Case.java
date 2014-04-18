package gameWar;

public class Case extends Cellule {

	/* (non-Javadoc)
	 * @see gameWar.Cellule#placerSur(gameWar.Robot)
	 */
	void placerSur(Robot r) {
		this.r=r;
	}

	/* (non-Javadoc)
	 * @see gameWar.Cellule#videCase()
	 */
	void videCase() {
		this.r=null;
		this.mine=0;
		this.base=0;
	}
}
