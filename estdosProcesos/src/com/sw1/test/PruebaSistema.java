package com.sw1.test;

import javax.print.attribute.standard.Finishings;

import com.sw1.logic.Process;
import com.sw1.logic.Transition;

public class PruebaSistema {
	
	public static void main(String[] args) {
		Transition transition = new Transition(5);
	
		//Process process = new Process(name, locked, priority, time)
		
		transition.runProcess();
	
	}

}
