package com.sw1.gui;

import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.TitledBorder;

import com.sw1.logic.Transition;
import com.sw1.model.ReadyHistoricalTableModel;
import com.sw1.model.ReadyTableModel;

public class JPanelProcess extends JPanel {
	private JTable tableReady;
	private Transition transition;

	public JPanelProcess(Transition transition) {
		// TODO Auto-generated constructor stub
		this.setBorder(new TitledBorder("Listos"));
		this.setLayout(new GridLayout(3, 2));
		this.transition=transition;
		ReadyHistoricalTableModel model = new ReadyHistoricalTableModel(transition);
		
		tableReady = new JTable(model);

		JScrollPane jScrollPane = new JScrollPane(tableReady);
		add(jScrollPane);	
	}
	
	public void removeTable(){
		tableReady.setModel(new ReadyHistoricalTableModel(transition));
		tableReady.repaint();
	}
	
}
