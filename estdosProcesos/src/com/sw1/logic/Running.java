package com.sw1.logic;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

import com.sw1.logic.Process;

/***
 * clase en_Ejecucion
 * permite manejar las opciones que tiene un proceso en el estado en ejecucion
 * @author Edgar Meneses
 *
 */
public class Running {

	private Queue<Process> running;
	private ArrayList<Process> runningHystory;
	private ArrayList<Process> expirateTime;
	private Ready ready;
	private Block block;
	private Transition transition;

	public Running() {

		runningHystory = new ArrayList<Process>();
		expirateTime = new ArrayList<Process>();
		running = new LinkedList<Process>();

	}

	public Running(	Ready ready, Block block, Transition transition) {
		this.running = new LinkedList<Process>();
		this.runningHystory = new ArrayList<Process>();
		this.expirateTime = new ArrayList<Process>();
		this.ready = ready;
		this.block = block;
		this.transition = transition;
	}
	
	public void comunicate(Process process){
		if(process.isComunicate()){
			transition.getComunicate().add(process);
			// si al ejecutarse la priemra vez el proceso se libera de la comunicacion
			//se deja asi pero si se debe comunicar siempre que se ejecute se cambia a true
			process.setComunicate(false);
		}
	}


	/**
	 * metodo que permite bloequear un proceso
	 * al bloquear el proceso que se esta ejecutando este pasa a la lista de procesos bloqueados
	 *
	 *Eliminar de ejecucion 
	 *lista de bloqueo 
	 * @param process
	 */
	public void block(Process process){
		block.add(process);
	}

	/**
	 * metodo de expiracion de tiempo 
	 * si el proceso 
	 * @param process
	 */
	public void timeOut(Process process){
		//Process process = running.poll();
		process.setState(State.READY);
		ready.add(process);


	}
	/**
	 * metodo cuando un proceso ha terminado su ejecucion
	 * @param process
	 */
	public void finished(Process process){
		transition.getFinished().add(process);
	}

	public void add(Process process){
		process.setState(State.RUNNING);
		comunicate(process);
		running.add(process);
		run();
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
		runningHystory.add(processHistorical);

	}
	
	public void addExpirateTime(Process process){
		Process processHistorical= new Process();
		processHistorical.setName(process.getName());
		processHistorical.setLocked(process.isLocked());
		processHistorical.setPriority(process.getPriority());
		processHistorical.setState(process.getState());
		processHistorical.setTime(process.getTime());
		processHistorical.setDestroyed(process.isDestroyed());
		processHistorical.setComunicate(process.isComunicate());
		processHistorical.setRestart(process.isRestart());
		expirateTime.add(processHistorical);

	}
	/**
	 * metodo que permite ejecutar el proceso
	 */
	public void run(){
		addHistoricalProcess(running.peek());
		validateTime(running.peek());
		throwprocess(running.poll());
	}
	/**
	 * manda el prceso donde corresponda
	 */
	public void throwprocess(Process process){
		if(process.isLocked()){
			block.add(process);
		}else if (process.isDestroyed()) {
			transition.destroyProcess(process, running);
		}
		else{
			if(process.getTime() == 0){
				process.setState(State.FINISHED);
				transition.getFinished().add(process);
			}else{
				process.setState(State.READY);
				addExpirateTime(process);
				ready.add(process);
			}
		}
	}

	public void subtract(Process process){
		process.setTime(process.getTime()-transition.getQuantum());
	}
	private void validateTime(Process process){

		if (process.getTime() > transition.getQuantum()) {

			subtract(process);
		}else {
			process.setTime(0);
		}
	}

	public Queue<Process> getRunning() {
		return running;
	}

	public void setRunning(Queue<Process> running) {
		this.running = running;
	}
	
	public Ready getReady() {
		return ready;
	}
	public void setReady(Ready ready) {
		this.ready = ready;
	}
	public Block getBlock() {
		return block;
	}
	public void setBlock(Block block) {
		this.block = block;
	}
	public Transition getTransition() {
		return transition;
	}
	public void setTransition(Transition transition) {
		this.transition = transition;
	}
	public ArrayList<Process> getRunningHystory() {
		return runningHystory;
	}

	public void setRunningHystory(ArrayList<Process> runningHystory) {
		this.runningHystory = runningHystory;
	}

	public ArrayList<Process> getExpirateTime() {
		return expirateTime;
	}

	public void setExpirateTime(ArrayList<Process> expirateTime) {
		this.expirateTime = expirateTime;
	}

	@Override
	public String toString() {
		return "Running [running=" + running + ", runningHystory="
				+ runningHystory + ", ready=" + ready + ", block=" + block
				+ ", transition=" + transition + "]";
	}

}
