package gameGraphic;

import javax.swing.JSpinner;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class SpinnerListener implements ChangeListener {

	static int cpt1;
	static int cpt2;
	static int cpt3;
	static int cpt1_2;
	static int cpt2_2;
	static int cpt3_2;
	ChoixRobot p;
	ChoixRobot2 p2;
	boolean b;
	public SpinnerListener(ChoixRobot p){
		this.p=p;
	}
	public SpinnerListener(ChoixRobot2 choixRobot2) {
		this.p2=choixRobot2;
		b=true;
	}
	@Override
	public void stateChanged(ChangeEvent e) {
		if(!b){
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

			if(cpt1+cpt2+cpt3==5){
				p.valider.setEnabled(true);
			}
			else
				p.valider.setEnabled(false);

		}
		else {
			JSpinner source = (JSpinner)e.getSource();
			if(source.equals(p2.spinner1)) {
				cpt1_2=(int)source.getValue();
			}

			else if(source.equals(p2.spinner2)) {
				cpt2_2=(int)source.getValue();
			}

			else if (source.equals(p2.spinner3)){
				cpt3_2=(int)source.getValue();
			}

			if(cpt1_2+cpt2_2+cpt3_2==5){
				p2.valider.setEnabled(true);
			}
			else
				p2.valider.setEnabled(false);
		}
	}

}
