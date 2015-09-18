package com.sw1.logic;

import java.util.ArrayList;
import java.util.Collection;


/**
 * Universidad Pedagogica y Tecnologica de Colombia
 * Docente : Juan Jose Camargo Vega
 * @author Natalie Santiago, Eliana Ayala, Edgar Meneses
 * Sistemas Operativos
 * Version 1.0
 * Clase que contiene los procesos cuando estan en estado de bloqueado
 */
public class Transition  implements Runnable{

	private int quantum;
	private Ready ready;
	private Block block;
	private Running running;
	private ArrayList<Process> finished;
	private ArrayList<Process> destroyed;
	private ArrayList<Process> comunicate;
	private ArrayList<Process> restart;
	private State state;
	

	public Transition(int quantum) {
		finished = new ArrayList<>();
		destroyed = new ArrayList<Process>();
		comunicate= new ArrayList<Process>();
		restart = new ArrayList<Process>();
		this.quantum = quantum;
		this.running = new Running();
		this.ready = new Ready(running);
		this.block = new Block(ready);
		this.running.setBlock(block);
		this.running.setReady(ready);
		this.running.setTransition(this);
		state=State.RUNNING;

	}

	public int getQuantum() {
		return quantum;
	}

	public void setQuantum(int quantum) {
		this.quantum = quantum;
	}
	public ArrayList<Process> getFinished() {
		return finished;
	}
	public void setFinished(ArrayList<Process> finished) {
		this.finished = finished;
	}

	public Ready getReady() {
		return ready;
	}

	public Block getBlock() {
		return block;
	}
	public Running getRunning() {
		return running;
	}

	public ArrayList<Process> getDestroyed() {
		return destroyed;
	}

	public void setDestroyed(ArrayList<Process> destroyed) {
		this.destroyed = destroyed;
	}

	public ArrayList<Process> getComunicate() {
		return comunicate;
	}

	public void setComunicate(ArrayList<Process> comunicate) {
		this.comunicate = comunicate;
	}
	public ArrayList<Process> getRestart() {
		return restart;
	}
	public void setRestart(ArrayList<Process> restart) {
		this.restart = restart;
	}
	@Override
	public String toString() {
		return "Transition [quantum=" + quantum + ", ready=" + ready
				+ ", block=" + block + ", running=" + running + ", finished="
				+ finished + ", destroyed=" + destroyed + ", comunicate="
				+ comunicate + ", state=" + state + "]";
	}

	public void isRunning(Process process){
		//while (!process.getState().equals(State.RUNNING)) {
		ready.dispatch(process);
		//}
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		//Thread thread = Thread.currentThread();
		while (!ready.getReady().isEmpty() || !block.getListLocked().isEmpty()) {
			if (!ready.getReady().isEmpty()) {
				isRunning(ready.getReady().get(0));
				//ready.getReady().remove(0);
			}else {
				block.activeProcess(quantum);
			}

			try {
				Thread.sleep(quantum*100);	
			} catch (InterruptedException e) {
				// TODO: handle exception
				System.out.println(e.getMessage());
			}
		}
		state = State.FINISHED;
	}

	public void start(){
		try {
			Thread thread = new Thread(this);
			thread.start();
			thread.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void runProcess(){
		ready.orderList();
		start();
	}

	public State getState() {
		return state;
	}
	
	public void addRestart(Process process){
		Process processHistorical= new Process();
		processHistorical.setName(process.getName());
		processHistorical.setLocked(process.isLocked());
		processHistorical.setPriority(process.getPriority());
		processHistorical.setState(process.getState());
		processHistorical.setTime(process.getTime());
		processHistorical.setDestroyed(process.isDestroyed());
		processHistorical.setComunicate(process.isComunicate());
		processHistorical.setRestart(process.isRestart());
		restart.add(processHistorical);

	}
	
	public void destroyProcess(Process process, Collection<Process> collections){
		   running.getTransition().getDestroyed().add(process);
		   collections.remove(process);
	}

	
	
	
	
	
	
	
}
