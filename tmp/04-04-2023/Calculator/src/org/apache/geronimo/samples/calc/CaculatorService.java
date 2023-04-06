package org.apache.geronimo.samples.calc;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface CaculatorService extends Remote {
	    public int addition(int x, int y) throws RemoteException;
} 
