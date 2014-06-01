package gameGraphic;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;

public class LabelListener implements MouseListener {

	private final JFrame f;
	private final JFrame f1;
	private final JFrame f2;
	public LabelListener() {
		f=new FChar();
		f.setVisible(false);
		f1=new FPiegeur();
		f1.setVisible(false);
		f2=new FTireur();
		f2.setVisible(false);
	}
	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		if(e.getSource().equals(ChoixRobot.l1) || e.getSource().equals(ChoixRobot2.l1)){
			f.setBounds(e.getXOnScreen()+5,e.getYOnScreen()-35,375,500);
			f.setVisible(true);
		}
		else if (e.getSource().equals(ChoixRobot.l2) || e.getSource().equals(ChoixRobot2.l2)){
			f1.setBounds(e.getXOnScreen()+5,e.getYOnScreen()-35,375,500);
			f1.setVisible(true);
		}

		else if(e.getSource().equals(ChoixRobot.l3) || e.getSource().equals(ChoixRobot2.l3)){
			f2.setBounds(e.getXOnScreen()+5,e.getYOnScreen()-35,375,500);
			f2.setVisible(true);
		}
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		f.setVisible(false);
		f1.setVisible(false);
		f2.setVisible(false);

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
