package com.sw1.gui;

import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.TitledBorder;

import com.sw1.logic.Transition;
import com.sw1.model.DistroyedTableModel;
import com.sw1.model.FinishedTableModel;
import com.sw1.model.RunningTableModel;

public class JPanelTableDistroyed extends JPanel {

	private JTable tableDistroyed;
	private DistroyedTableModel model;
	private Transition transition;

	public JPanelTableDistroyed(Transition transition) {

		this.transition = transition;
		init();
		tableFinished();
	}

	public void init(){
		this.setBorder(new TitledBorder("Destruidos"));
		this.setLayout(new GridLayout(4, 3));
	}

	public void tableFinished(){
		model = new DistroyedTableModel(transition);
		tableDistroyed = new JTable(model);
		JScrollPane jScrollPane = new JScrollPane(tableDistroyed);
		add(jScrollPane);
	}

	public void removeTable(){

		tableDistroyed.setModel(new FinishedTableModel(transition));
		tableDistroyed.repaint();

	}

}
