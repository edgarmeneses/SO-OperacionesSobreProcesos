package com.sw1.gui;

import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.TitledBorder;

import com.sw1.logic.Transition;
import com.sw1.model.FinishedTableModel;
import com.sw1.model.RunningTableModel;

public class JPanelTableFinished extends JPanel {

	private JTable tableFinished;
	private FinishedTableModel model;
	private Transition transition;

	public JPanelTableFinished(Transition transition) {

		this.transition = transition;
		init();
		tableFinished();
	}

	public void init(){
		this.setBorder(new TitledBorder("Fializado"));
		this.setLayout(new GridLayout(3, 2));
	}

	public void tableFinished(){
		model = new FinishedTableModel(transition);
		tableFinished = new JTable(model);
		JScrollPane jScrollPane = new JScrollPane(tableFinished);
		add(jScrollPane);
	}

	public void removeTable(){

		tableFinished.setModel(new FinishedTableModel(transition));
		tableFinished.repaint();

	}

}
