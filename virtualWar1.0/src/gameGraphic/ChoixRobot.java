package gameGraphic;

import java.awt.CardLayout;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;

public class ChoixRobot extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	CardLayout cl;
	JPanel pan;
	Image img;
	JButton retour;
	String[] labels = {"Tireurs", "Piegeurs", "Chars"};
	int numPairs = labels.length;
	JPanel p;
	public ChoixRobot(CardLayout cl, JPanel pan) {
		this.cl=cl;
		this.pan=pan;
		this.setLayout(new FlowLayout(0,250,130));
		p=new JPanel();
		p.setLayout(new GridLayout(2,1,50,50));
		p.setOpaque(false);
		@SuppressWarnings("unused")
		SpinnerModel model =new SpinnerNumberModel(0,0,5,1);
		JSpinner spinner1 = new JSpinner(model);
		try {
			img=ImageIO.read(new File("rsc/images/bg1.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		retour=new Bouton("Retour",pan,cl,"jvj");
		p.add(spinner1);
		p.add(retour);
		this.add(p);
		gameController.EntrerIA.rep="iacia";
	}
	@Override
	public void paintComponent(Graphics g) {
		g.drawImage(img,0,0,this);
	}
}
