package com.sw1.gui;

import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.peer.PanelPeer;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

import com.sw1.logic.Transition;

public class MainWindow extends JFrame{

	private JPanelOption panelOption;
	private JPanelFunction panelFunction;
	private Transition transition;

	public static final Dimension DEFOULT_DIMENSION = Toolkit.getDefaultToolkit().getScreenSize();

	public MainWindow(Transition transition) {

		// TODO Auto-generated constructor stub

		this.transition=transition;
		// para que la pantalla tome el maximo tamaño
		this.setExtendedState(MAXIMIZED_BOTH);
		// para eliminar las margenes o bordes del frame
		this.setUndecorated(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		Image icon = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/images/logo.PNG"));
		setIconImage(icon);
		setLayout(null);
		init();
	}

	private void init(){

		System.out.println(this.getSize());

		panelFunction = new JPanelFunction(transition);
		panelFunction.setBounds(0, 0, ((DEFOULT_DIMENSION.width/7)*6), DEFOULT_DIMENSION.height);

		panelOption = new JPanelOption(transition,panelFunction.getReady(),panelFunction.getProcess(),
				panelFunction.getLocked(),panelFunction.getFinished(),panelFunction.getRunning(),this);
		panelOption.setBounds(((DEFOULT_DIMENSION.width/7)*6), 0, DEFOULT_DIMENSION.width/5, DEFOULT_DIMENSION.height);

		add(panelFunction);
		add(panelOption);
	}



}
