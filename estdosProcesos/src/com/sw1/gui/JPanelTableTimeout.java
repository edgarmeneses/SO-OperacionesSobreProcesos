package com.sw1.gui;

import java.awt.GridLayout;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.TitledBorder;

import com.sw1.logic.Process;
import com.sw1.logic.Transition;
import com.sw1.model.TimeoutTableModel;

public class JPanelTableTimeout extends JPanel{
	
	private JTable tableTimeout;
	private TimeoutTableModel model;
	private Transition transition;


	public JPanelTableTimeout(Transition transition) {

		this.transition = transition;
		init();
		tableTimeout();
	}

	public void init(){
		this.setLayout(new GridLayout(3, 2));
		this.setBorder(new TitledBorder("Expirados"));
	}


	public void tableTimeout(){
		model = new TimeoutTableModel(transition);
		tableTimeout = new JTable(model);
		JScrollPane jScrollPane = new JScrollPane(tableTimeout);
		add(jScrollPane);
	}

	public void removeTable(){
		tableTimeout.setModel(new TimeoutTableModel(transition));
		tableTimeout.repaint();
	}

}
