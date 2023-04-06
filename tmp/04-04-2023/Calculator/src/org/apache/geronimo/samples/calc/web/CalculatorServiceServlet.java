package org.apache.geronimo.samples.calc.web;

import java.rmi.RemoteException;

import org.apache.geronimo.samples.calc.CaculatorService;


public class CalculatorServiceServlet implements CaculatorService{

	public int addition(int x, int y) throws RemoteException {
		return x+y;
	}
	
}
