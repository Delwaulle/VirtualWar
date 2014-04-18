package gameWar;

/**
 * @author Loic
 *
 */
public class Case extends Cellule {

	/**
	 * @param r
	 * Place un robot sur une case.
	 */
	@Override
	void placerSur(Robot r) {
		this.r=r;
	}

	/**
	 * vide la case.
	 */
	@Override
	void videCase() {
		this.r=null;
		this.mine=0;
		this.base=0;
	}
}
