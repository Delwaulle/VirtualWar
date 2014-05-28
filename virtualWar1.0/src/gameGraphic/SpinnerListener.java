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
		p.choix=(int)source.getValue();
		System.out.println(source.getValue());
	}

}
