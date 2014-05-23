package gameGraphic;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class MListener implements MouseListener{

	private boolean bool;
	JLabel l;
	SonMenu son;
	public MListener(JLabel l,SonMenu son){
		this.l=l;
		this.son=son;
	}

	@SuppressWarnings("deprecation")
	@Override
	public void mouseClicked(MouseEvent arg0) {
		if (!bool) {
			l.setIcon(new ImageIcon("rsc/images/son6.png"));
			this.son.stop();

			bool=true;
		}
		else if (bool) {
			l.setIcon(new ImageIcon("rsc/images/son5.png"));
			this.son=new SonMenu();
			this.son.start();
			bool=false;
		}

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
