/**
# COPYRIGHT LICENSE: 
# This information contains sample code provided in source code form. You may 
# copy, modify, and distribute these sample programs in any form without 
# payment to IBM for the purposes of developing, using, marketing or 
# distributing application programs conforming to the application programming
# interface for the operating platform for which the sample code is written. 
# Notwithstanding anything to the contrary, IBM PROVIDES THE SAMPLE SOURCE CODE
# ON AN "AS IS" BASIS AND IBM DISCLAIMS ALL WARRANTIES, EXPRESS OR IMPLIED, 
# INCLUDING, BUT NOT LIMITED TO, ANY IMPLIED WARRANTIES OR CONDITIONS OF 
# MERCHANTABILITY, SATISFACTORY QUALITY, FITNESS FOR A PARTICULAR PURPOSE, 
# TITLE, AND ANY WARRANTY OR CONDITION OF NON-INFRINGEMENT. IBM SHALL NOT BE 
# LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL OR CONSEQUENTIAL DAMAGES
# ARISING OUT OF THE USE OR OPERATION OF THE SAMPLE SOURCE CODE. IBM HAS NO 
# OBLIGATION TO PROVIDE MAINTENANCE, SUPPORT, UPDATES, ENHANCEMENTS OR 
# MODIFICATIONS TO THE SAMPLE SOURCE CODE.
**/
package com.ibm.was.wssample.sei.servlets;

import java.io.IOException;
import javax.servlet.Servlet;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ibm.was.wssample.sei.cli.*;
import com.ibm.was.wssample.sei.echo.*;
import com.ibm.was.wssample.sei.ping.*;

/**
 * SampleController main entry point for JSP servlet
 * 
 */
public class SampleController extends HttpServlet implements Servlet {

	private static final int TIMEOUT = 240; // Async timeout
	private static final long serialVersionUID = 1039362106123493799L;
	private static final String CONTEXT_BASE = "/WSSampleSei/";
	private static final String PING_CONTEXT = CONTEXT_BASE + "PingService";
	private static final String ECHO_CONTEXT = CONTEXT_BASE + "EchoService";
	private static final String PING_CONTEXT12 = CONTEXT_BASE + "PingService12";
	private static final String ECHO_CONTEXT12 = CONTEXT_BASE + "EchoService12";
	private static final String INDEX_JSP_LOCATION = "/WEB-INF/jsp/demo.jsp";
	private static final String PING_RESPONSE_GOOD = "Message delivered successfully. Please check server logs to confirm message delivery.";
	private static final String PING_RESPONSE_BAD = "ERROR: Failure in client before message delivery.";
	private String uriString = "";
	private String soapString = "";
	private int count = 1;

	public SampleController() {
		super();
	}

	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		processRequest(req, resp);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		processRequest(req, resp);
	}

	/**
	 * processRequest Reads the posted parameters and calls the service
	 */
	private void processRequest(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		ServletContext context = getServletContext();
		String msgString = req.getParameter("msgstring");
		String svc = req.getParameter("msgservice");
		String cnt = req.getParameter("msgcount");
		String result = "";
                req.setAttribute("PingSelected", " ");
                req.setAttribute("EchoSelected", " ");
                req.setAttribute("AsyncSelected", " ");
                req.setAttribute("AsyncWireSelected", " ");

		if (null == msgString || "" == msgString) {
			// Set up the default values to use
			uriString = "http://localhost:"+req.getServerPort();
			soapString = "";
			formatOutput(req, uriString, "", "");			
			req.setAttribute("uridef", uriString);
			req.setAttribute("soapdef", soapString);
			req.setAttribute("messageS", " ");
			req.setAttribute("messageR", " ");
			req.setAttribute("msgcount", new Integer(count).toString());
			req.setAttribute("PingSelected", "selected");
			context.getRequestDispatcher(INDEX_JSP_LOCATION).forward(req, resp);
		} else {
			// Get the parms from the request
			uriString = req.getParameter("uri");
			soapString = req.getParameter("soap12");
			if (null != soapString)
			{
				soapString = "checked";
			}
			else
			{
				soapString = "";
			}

			// Strip tags out of input
			uriString = stripTags(uriString);
			msgString = stripTags(msgString);

			// Get count
			if ((null != cnt) && ("" != cnt))
			{
				count = new Integer(cnt).intValue();
			}
			
			// Set the values to be on the refreshed page			
			req.setAttribute("msgstring", req.getAttribute("msgstring"));
			req.setAttribute("uridef", uriString);
			req.setAttribute("soapdef", soapString);
			req.setAttribute("msgcount", new Integer(count).toString());
			req.setAttribute(svc+"Selected", "selected");

			// Now call the service
			SampleClient client = new SampleClient();
			System.out.println(">> SERVLET: Request count = "+count);
			
			// Loop on the count
			for (int index =0; index < count; index++)
			{
				System.out.println(">> SERVLET: Request index: "+ (index+1));
				if (0 == soapString.length())
				{
					if (svc.equalsIgnoreCase(("Async"))) {
						result  += client.buildAsync(uriString + ECHO_CONTEXT, msgString,
								TIMEOUT, false);
					} else 	if (svc.equalsIgnoreCase(("AsyncWire"))) {
						result += client.buildAsync(uriString + ECHO_CONTEXT, msgString,
								TIMEOUT, true);
					}
					else if (svc.equalsIgnoreCase("Echo")) {
						result += client.buildEcho(uriString + ECHO_CONTEXT, msgString);
					} else {
						if (client.buildPing(uriString + PING_CONTEXT, msgString)) {
							result += PING_RESPONSE_GOOD;
						} else {
							result += PING_RESPONSE_BAD;
						}
					}
				}
				else  // SOAP1.2
				{
					if (svc.equalsIgnoreCase(("Async"))) {
						result += client.buildAsync12(uriString + ECHO_CONTEXT12, msgString,
								TIMEOUT, false);
					} else 	if (svc.equalsIgnoreCase(("AsyncWire"))) {
						result += client.buildAsync12(uriString + ECHO_CONTEXT12, msgString,
								TIMEOUT, true);
					}
					else if (svc.equalsIgnoreCase("Echo")) {
						result += client.buildEcho12(uriString + ECHO_CONTEXT12, msgString);
					} else {
						if (client.buildPing12(uriString + PING_CONTEXT12, msgString)) {
							result += PING_RESPONSE_GOOD;
						} else {
							result += PING_RESPONSE_BAD;
						}
					}	
				}	
				result += "\n";
			}
			
			// Format the output and refresh the panel
			formatOutput(req, uriString, msgString, result);
			context.getRequestDispatcher(INDEX_JSP_LOCATION).forward(req, resp);
		}
	}

	/**
	 * formatOutput Format the transaction data into the HTML text area
	 */
	private void formatOutput(HttpServletRequest req, String endpointURL,
			String request, String received) {
		req.setAttribute("messageS", "\n" + "Connecting to... " + endpointURL
				+ "\n\n" + "Message Request: \n" + request + "\n");
		req.setAttribute("messageR", "\n" + "Message Response: \n" + received
				+ "\n");
	}

	/**
	 * Strips HTML tags out of input string
	 * 
	 * @param input  String that was passed to servet
	 * 
	 * @return String stripped of HTML Tags
	 */
	private String stripTags(String input)
	{
		return (input.replace("<", "&lt;").replace(">", "&gt;").replace("\"", "&quot;").replace("'", "&apos;"));
	}

}