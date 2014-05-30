package gameGraphic;

import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class SliderListener implements ChangeListener {

	Parametres p;
	public SliderListener(Parametres p){
		this.p=p;
	}
	@Override
	public void stateChanged(ChangeEvent e) {
		// TODO Auto-generated method stub
		JSlider source = (JSlider)e.getSource();
		if(source.equals(p.j1)){
			BoardDisplayer.board.hauteur = (int)source.getValue();
		}
		
		else if (source.equals(p.j2)){
			BoardDisplayer.board.largeur = (int)source.getValue();
		}
	}

}
