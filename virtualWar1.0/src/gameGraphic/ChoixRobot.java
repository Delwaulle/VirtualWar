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
	JPanel p;
	int nbRobots;
	int choix;
	JSpinner spinner1;
	JSpinner spinner2;
	JSpinner spinner3;
	@SuppressWarnings("unused")
	public ChoixRobot(CardLayout cl, JPanel pan) {
		this.cl=cl;
		this.pan=pan;
		this.setLayout(new FlowLayout(0,250,130));
		p=new JPanel();
		nbRobots=5;
		p.setLayout(new GridLayout(4,1,50,50));
		p.setOpaque(false);
		SpinnerModel model1 =new SpinnerNumberModel(0,0,nbRobots-choix,1);
		spinner1 = new JSpinner(model1);
		spinner1.addChangeListener(new SpinnerListener(this));
		SpinnerModel model2 =new SpinnerNumberModel(0,0,nbRobots-choix,1);
		spinner2 = new JSpinner(model2);
		spinner2.addChangeListener(new SpinnerListener(this));
		SpinnerModel model3 =new SpinnerNumberModel(0,0,nbRobots-choix,1);
		spinner3 = new JSpinner(model3);
		spinner3.addChangeListener(new SpinnerListener(this));
		try {
			img=ImageIO.read(new File("rsc/images/bg1.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		retour=new Bouton("Retour",pan,cl,"jvj");
		p.add(spinner1);
		p.add(spinner2);
		p.add(spinner3);
		p.add(retour);
		this.add(p);
		gameController.EntrerIA.rep="iacia";
	}
	@Override
	public void paintComponent(Graphics g) {
		g.drawImage(img,0,0,this);
	}
}
