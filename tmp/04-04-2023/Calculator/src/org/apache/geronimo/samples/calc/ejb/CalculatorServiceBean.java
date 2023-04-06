package org.apache.geronimo.samples.calc.ejb;

import java.rmi.RemoteException;

import javax.ejb.EJBException;
import javax.ejb.SessionBean;

import org.apache.geronimo.samples.calc.CaculatorService;

/**
 * 
 * @ejb.bean name="CalculatorServiceBean"
 *       type="Stateless"
 *       local-jndi-name="java:comp/env/ejb/CalculatorService"
 *       view-type="local"
 *       
 * @ejb.interface generate="local" local-class="org.apache.geronimo.samples.calc.ejb.CalculatorServiceLocal"
 * @ejb.home generate="local" local-class="org.apache.geronimo.samples.calc.ejb.CalculatorServiceHomeLocal"
 *
 */

public class CalculatorServiceBean implements SessionBean, CaculatorService{
	
	/**
	 * @ejb.interface-method view-type="local"
	 */
	public int addition(int x, int y) throws RemoteException {
		return x+y;
	}
	
	/**
	 * @ejb.create-method
	 * 
	 */
	public void ejbCreate() throws javax.ejb.CreateException {
	}

	public void ejbPostCreate() throws javax.ejb.CreateException {
	}

	protected javax.ejb.SessionContext context = null;

	public void setSessionContext(javax.ejb.SessionContext ctx) {
		this.context = ctx;
	}

	protected javax.ejb.SessionContext getSessionContext() {
		return this.context;		
	}

	public void ejbActivate() throws EJBException, RemoteException {

	}

	public void ejbPassivate() throws EJBException, RemoteException {

	}

	public void ejbRemove() throws EJBException, RemoteException {

	}

}
