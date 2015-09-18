package com.sw1.logic;

import java.lang.ProcessBuilder.Redirect;
import java.util.ArrayList;
import java.util.Collection;
import java.util.ListResourceBundle;
import java.util.Queue;

public class Ready {

	private ArrayList<Process> historicalReady;
	private ArrayList<Process> ready;
	private Running running;


	public Ready() {
		ready = new ArrayList<Process>();
		historicalReady = new ArrayList<Process>();
		running = new Running();
	}

	public Ready(Running running) {
		this.historicalReady = new ArrayList<Process>();
		this.ready = new ArrayList<Process>();
		this.running = running;
	}


	/**
	 * metodo que permite almacenar un nuevo proceso en la lista de listos
	 * @param process
	 */
	public void add(Process process){
		this.ready.add(process);	
	}

	public void addHistoricalProcess(Process process){
		Process processHistorical= new Process();
		processHistorical.setName(process.getName());
		processHistorical.setLocked(process.isLocked());
		processHistorical.setPriority(process.getPriority());
		processHistorical.setState(process.getState());
		processHistorical.setTime(process.getTime());
		processHistorical.setDestroyed(process.isDestroyed());
		processHistorical.setComunicate(process.isComunicate());
		processHistorical.setRestart(process.isRestart());
		historicalReady.add(processHistorical);

	}

	/**
	 * metoo que permite ordenar la lista de procesos listos
	 */
	public void orderList(){

		for (int vuel = 0; vuel < ready.size()-1; vuel++) {
			for (int i = 0; i < ready.size()-vuel-1; i++) {
				if(ready.get(i).getPriority() > ready.get(i+1).getPriority()){
					Process aux = ready.get(i);
					ready.set(i, ready.get(i+1));
					ready.set(i+1, aux);
				}
			}

		}
	}

	public void dispatch(Process process) {
		
	
		if(process.isDestroyed() && !process.isRunning()){
			historicalReady.add(process);
			running.getTransition().destroyProcess(process, ready);
		}else {
			addHistoricalProcess(process);
			running.add(process);
			ready.remove(process);
		}
	}


	public void historicalAdd(Process process){
		historicalReady.add(process);
	}

	public ArrayList<Process> getHistoricalReady() {
		return historicalReady;
	}

	public void setHistoricalReady(ArrayList<Process> historicalReady) {
		this.historicalReady = historicalReady;
	}

	public ArrayList<Process> getReady() {
		return ready;
	}

	public void setReady(ArrayList<Process> ready) {
		this.ready = ready;
	}



	public Running getRunning() {
		return running;
	}

	public void setRunning(Running running) {
		this.running = running;
	}

	@Override
	public String toString() {
		return "Ready [historicalReady=" + historicalReady + ", ready=" + ready
				+ "]";
	}


}
