package gameGraphic;

import gameWar.Plateau;

import java.awt.CardLayout;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class JoueurVsJoueur extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	CardLayout cl;
	JPanel pan;
	Image img;
	JButton retour;
	JPanel p;
	JButton valider;
	@SuppressWarnings("rawtypes")
	JList jl;
	JScrollPane jp;
	String[] tab;
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public JoueurVsJoueur(CardLayout cl, JPanel pan) {
		this.cl=cl;
		this.pan=pan;
		this.setLayout(new FlowLayout(0,250,130));
		p=new JPanel();
		p.setLayout(new GridLayout(3,1,50,50));
		try {
			img=ImageIO.read(new File("rsc/images/bg1.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		valider=new Bouton("Valider",pan,cl,"robots");
		retour=new Bouton("Retour",pan,cl,"jouer");
		tab = new String[]{"Aucun","10%","20%","30%","40%","50%","60%"};
		jl=new JList(tab);
		jl.setVisibleRowCount(4);
		jp = new JScrollPane(jl);
		jl.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
		jl.setSelectedIndex(0);
		jl.addListSelectionListener(new ListSelectionListener(){

			@Override
			public void valueChanged(ListSelectionEvent arg0) {
				BoardDisplayer.board = new Plateau(jl.getSelectedIndex()*0.1);
			}

		});
		p.setOpaque(false);
		p.add(jp);
		p.add(valider);
		p.add(retour);
		this.add(p);
		gameController.EntrerIA.rep="jcj";
	}
	@Override
	public void paintComponent(Graphics g) {
		g.drawImage(img,0,0,this);
	}
}
