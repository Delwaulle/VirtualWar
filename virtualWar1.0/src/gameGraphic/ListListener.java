package gameGraphic;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class ListListener implements MouseListener {

	private final JoueurVsJoueur j;
	public ListListener(JoueurVsJoueur j){
		this.j=j;
	}
	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		gameController.EntrerObstacles.obstacles=j.jl.getSelectedIndex()*0.1;
		//System.out.println(gameController.EntrerObstacles.obstacles);
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

}
