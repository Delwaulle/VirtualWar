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

	/**
	 *@param r
	 *description Place un robot dans la cellule Base.
	 */
	@Override
	public void placerSur(Robot r) {
		this.r=r;
	}

	/**
	 *description Vide la case.
	 */
	@Override
	public void videCase() {
		this.r=null;
		this.mine=0;
	}

}
