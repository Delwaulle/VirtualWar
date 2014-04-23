package gameGraphic;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JCheckBox;

public class CheckBoxSon extends JCheckBox implements ItemListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private SonMenu son;

	public CheckBoxSon(String nom,SonMenu son){
		super(nom);
		this.son=son;
		this.setSelected(false);
		this.addItemListener(this);
	}

	@SuppressWarnings("deprecation")
	@Override
	public void itemStateChanged(ItemEvent e) {

		if (e.getStateChange() == ItemEvent.SELECTED)
			son.stop();
		else if (e.getStateChange() == ItemEvent.DESELECTED){
			son=new SonMenu();
			son.start();
		}
	}
}
