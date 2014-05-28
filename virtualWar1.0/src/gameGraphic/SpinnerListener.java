package gameGraphic;

import javax.swing.JSpinner;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class SpinnerListener implements ChangeListener {

	ChoixRobot p;
	public SpinnerListener(ChoixRobot p){
		this.p=p;
	}
	@Override
	public void stateChanged(ChangeEvent e) {
		JSpinner source = (JSpinner)e.getSource();
		if(p.nbRobots<= 5 && p.nbRobots>0)
			p.valider.setEnabled(true);

		else if ( source.equals(p.spinner1)) {
			p.choix=(int)source.getValue();
			p.nbRobots=p.nbRobots-p.choix;
		}
		else if ( source.equals(p.spinner2)) {
			p.choix2=(int)source.getValue();
			p.nbRobots=p.nbRobots-p.choix2;
		}

		else if ( source.equals(p.spinner3)) {
			p.choix3=(int)source.getValue();
			p.nbRobots=p.nbRobots-p.choix3;
		}

	}

}
