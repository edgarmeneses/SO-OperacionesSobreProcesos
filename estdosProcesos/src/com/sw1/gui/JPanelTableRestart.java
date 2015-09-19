package com.sw1.gui;

import java.awt.GridLayout;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.TitledBorder;

import com.sw1.logic.Process;
import com.sw1.logic.Transition;
import com.sw1.model.RestartTableModel;

public class JPanelTableRestart extends JPanel{
	

	private JTable tableRestart;
	private RestartTableModel model;
	private Transition transition;


	public JPanelTableRestart(Transition transition) {

		this.transition = transition;
		init();
		tableLocked();
	}

	public void init(){
		this.setLayout(new GridLayout(3, 2));
		this.setBorder(new TitledBorder("Restaurados"));
	}


	public void tableLocked(){
		model = new RestartTableModel(transition);
		tableRestart = new JTable(model);
		JScrollPane jScrollPane = new JScrollPane(tableRestart);
		add(jScrollPane);
	}

	public void removeTable(){
		tableRestart.setModel(new RestartTableModel(transition));
		tableRestart.repaint();
	}

}
