package com.sw1.logic;

import java.util.ArrayList;
import java.util.List;
/**
 * Universidad Pedagogica y Tecnologica de Colombia
 * Docente : Juan Jose Camargo Vega
 * @author Natalie Santiago, Eliana Ayala, Edgar Meneses
 * Sistemas Operativos
 * Version 1.0
 * Clase que contiene los procesos cuando estan en estado de bloqueado
 */
public class Block {
	
	/**
	 * Atributos de la clase bloqueado
	 */
	private List<Process> listLocked;
	private Ready ready;
	private List<Process>  listHistoryLock;
	
	public Block(){
		listLocked = new ArrayList<>();
		listHistoryLock = new ArrayList<Process>();
	}
	
	public Block(Ready ready){
		listLocked = new ArrayList<>();
		listHistoryLock = new ArrayList<Process>();
		this.ready= ready;
	}
	
	public  void add(Process process){
		
			listLocked.add(process);
			addHistoricalProcess(process);
		    throwProcess(process);
		
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
		listHistoryLock.add(processHistorical);

	}
	// mandar  procesos bloqueados a la lista de listos y removerlos de la lista bloqueados
	public void activeProcess(int quantum){
		
		if(listLocked.get(0).getTime()<=quantum){
			listLocked.get(0).setLocked(false);
		}
		ready.add(listLocked.get(0));
		listLocked.remove(0);
	}
	
	public void throwProcess(Process process){
		if (process.isDestroyed()) {
			if(process.isRestart()){
				ready.getRunning().getTransition().addRestart(process);
			}
			ready.getRunning().getTransition().destroyProcess(process, listLocked);
			listLocked.remove(process);
		}else if(process.isRestart()){
			if(listLocked.get(0).getTime()<=ready.getRunning().getTransition().getQuantum()){
				listLocked.get(0).setLocked(false);
			}
			
			listLocked.remove(process);
			ready.getRunning().getTransition().addRestart(process);
			ready.add(process);
		}
	}
	/**
	 * Getters y Setters
	 * @return
	 */
	public List<Process> getListLocked() {
		return listLocked;
	}

	public void setListLocked(List<Process> listLocked) {
		this.listLocked = listLocked;
	}
	
	@Override
	public String toString() {
		return "Block [listLocked=" + listLocked + "]";
	}

	public List<Process> getListHistoryLock() {
		return listHistoryLock;
	}

	public void setListHistoryLock(List<Process> listHistoryLock) {
		this.listHistoryLock = listHistoryLock;
	}

}
