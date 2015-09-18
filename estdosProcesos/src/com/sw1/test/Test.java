package com.sw1.test;

import javax.swing.JFrame;

import com.sw1.gui.MainWindow;
import com.sw1.logic.Transition;

public class Test {
	
	public static void main(String[] args) {
		
   Transition transition = new Transition(5);
	MainWindow ventanaPrincipal = new MainWindow(transition);
	ventanaPrincipal.setVisible(true);
	
	}

}
