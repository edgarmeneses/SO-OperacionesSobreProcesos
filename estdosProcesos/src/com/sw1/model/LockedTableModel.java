package com.sw1.model;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import com.sw1.logic.Transition;
import com.sw1.logic.Process;

public class LockedTableModel extends AbstractTableModel{
	
	
	private static final String [] COLUMNN = {"Proceso","Tiempo"};
	private static final Class [] COLUMNTYPE = {String.class, Integer.class};
	private ArrayList<Object[]> data;
	private Transition transition;
	
	public LockedTableModel(Transition transition) {
		this.transition = transition;
		data = new ArrayList<Object[]>();
		fill();
	}
	
	public void fill(){
		for (Process process : transition.getBlock().getListHistoryLock()) {
			data.add(fillRow(process.getName(),process.getTime()));
		}
		
	}
	
	public Object[] fillRow(String nameProcess, int time){
		return new Object[]{nameProcess, time};
	}


	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return COLUMNN.length;
	}

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return data.size();
	}

	@Override
	public Object getValueAt(int row, int column) {
		// TODO Auto-generated method stub
		return data.get(row)[column];
	}
	@Override
	public String getColumnName(int column) {
		
		return COLUMNN[column];
	}
	
	@Override
	public Class<?> getColumnClass(int columnIndex) {
		
		return COLUMNTYPE[columnIndex];
		
	}

	

}
