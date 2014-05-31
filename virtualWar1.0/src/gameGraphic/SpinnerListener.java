package gameGraphic;

import javax.swing.JSpinner;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class SpinnerListener implements ChangeListener {

	static int cpt1;
	static int cpt2;
	static int cpt3;
	ChoixRobot p;
	public SpinnerListener(ChoixRobot p){
		this.p=p;
	}
	@Override
	public void stateChanged(ChangeEvent e) {
		JSpinner source = (JSpinner)e.getSource();
		if(source.equals(p.spinner1)) {
			cpt1=(int)source.getValue();
		}

		else if(source.equals(p.spinner2)) {
			cpt2=(int)source.getValue();
		}

		else if (source.equals(p.spinner3)){
			cpt3=(int)source.getValue();
		}
		System.out.println(cpt3+cpt2+cpt1);
		if(cpt1+cpt2+cpt3==5){
			p.valider.setEnabled(true);
			p.valider.revalidate();
		}
	}

}
