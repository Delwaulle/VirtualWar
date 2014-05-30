package gameGraphic;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.border.TitledBorder;

public class Parametres extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	CardLayout cl;
	JPanel pan;
	Image img;
	JButton retour;
	JPanel p;
	public JSlider j1;
	public JSlider j2;
	JCheckBox jc;
	public Parametres(CardLayout cl, JPanel pan) {
		this.cl=cl;
		this.pan=pan;
		this.setLayout(new FlowLayout(0,250,130));
		p=new JPanel();
		p.setLayout(new GridLayout(4,1,50,50));
		j1=new JSlider(JSlider.HORIZONTAL,5, 20, 10);
		j2=new JSlider(JSlider.HORIZONTAL,5, 20, 10);
		j1.setOpaque(false);
		j2.setOpaque(false);
		j1.setPaintLabels(true);
		j2.setPaintLabels(true);
		j1.addChangeListener(new SliderListener(this));
		j2.addChangeListener(new SliderListener(this));
		j1.setMajorTickSpacing(5);
		j1.setMinorTickSpacing(1);
		j1.setPaintTicks(true);
		j2.setMajorTickSpacing(5);
		j2.setMinorTickSpacing(1);
		j2.setPaintTicks(true);
		TitledBorder t1=new TitledBorder("Largeur du plateau");
		TitledBorder t2 = new TitledBorder("Hauteur du plateau");
		t1.setTitleColor(Color.WHITE);
		t2.setTitleColor(Color.WHITE);
		j1.setForeground(Color.WHITE);
		j2.setForeground(Color.WHITE);
		j1.setBorder(t1);
		j2.setBorder(t2);
		jc=new JCheckBox("Désactiver les bruitages.");
		jc.setOpaque(false);
		jc.setForeground(Color.WHITE);
		jc.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				if(jc.isSelected()){
					gameController.SoundController.son=false;
				}
				else {
					gameController.SoundController.son=true;
				}
			}

		});
		p.add(j1);
		p.add(j2);
		p.add(jc);
		p.setOpaque(false);
		try {
			img=ImageIO.read(new File("rsc/images/bg1.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		retour=new Bouton("Retour",pan,cl,"menu");
		p.add(retour);
		this.add(p);
	}

	@Override
	public void paintComponent(Graphics g) {
		g.drawImage(img,0,0,this);
	}
}
