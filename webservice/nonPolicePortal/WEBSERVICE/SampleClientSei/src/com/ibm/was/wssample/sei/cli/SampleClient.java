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
package com.ibm.was.wssample.sei.cli;

import java.util.concurrent.Future;

import javax.xml.namespace.QName;
import javax.xml.ws.BindingProvider;

import com.ibm.was.wssample.sei.echo.*;
import com.ibm.was.wssample.sei.ping.*;
import com.ibm.was.wssample.sei.ping.ObjectFactory;

/**
 * SampleClient
 * main entry point for thinclient jar sample
 * and worker class to communicate with the services
 */
public class SampleClient {

	private int timeout = 240; 				// Error timeout in seconds
	private static final int SLEEPER = 2; 	// Poll delay for async
	private String urlHost = "localhost";
	private String urlPort = "9080";
	private static final String CONTEXT_BASE = "/WSSampleSei/";
	private static final String PING_CONTEXT = CONTEXT_BASE+"PingService";
	private static final String ECHO_CONTEXT = CONTEXT_BASE+"EchoService";
	private static final String PING_CONTEXT12 = CONTEXT_BASE+"PingService12";
	private static final String ECHO_CONTEXT12 = CONTEXT_BASE+"EchoService12";
	private String urlSuffix = "";
	private String message = "HELLO";
	private String servtype = "async";
	private String uriString = "http://" + urlHost + ":" + urlPort;
	private Boolean wireasync = true;
	private Boolean soap12 = false;
	private int count = 1;

	/**
	 * main()
	 * 
	 * see printusage() for command-line arguments
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		SampleClient sample = new SampleClient();
		sample.parseArgs(args);
		sample.CallService();
	}

	/**
	 * parseArgs Read and interpret the command-line arguments
	 * 
	 * @param args
	 */
	public void parseArgs(String[] args) {
		if (args.length >= 1) {
			for (int i = 0; i < args.length; i++) {
				try {
					if ('-' == args[i].charAt(0)) {
						switch (args[i].charAt(1)) {
						case '?':
							printUsage(null);
							System.exit(0);
							break;
						case 'h':
						case 'H':
							urlHost = args[++i];
							break;
						case 'p':
						case 'P':
							urlPort = args[++i];
							break;
						case 'f':
						case 'F':
							urlSuffix = args[++i];
							break;
						case 'm':
						case 'M':
							message = args[++i];
							break;
						case 's':
						case 'S':
							servtype = args[++i];
							if ((!servtype.equalsIgnoreCase("async")) &&
							    (!servtype.equalsIgnoreCase("echo")) &&
							    (!servtype.equalsIgnoreCase("ping")))
							{
								System.out
										.println("ERROR: Attempt to invoke a service that is not supported");
								printUsage(null);
								System.exit(0);
							}
							break;
						case 't':
						case 'T':
							timeout = new Integer(args[++i]).intValue();
							break;
						case 'c':
						case 'C':
							count = new Integer(args[++i]).intValue();
							break;
						case 'w':
						case 'W':
							String parm = args[++i];
							if (parm.equalsIgnoreCase("y"))
							{
								wireasync = true;
							}
							else
							{
								wireasync = false;
							}
							break;
						case '1':
							soap12 = false;
							break;
						case '2':
							soap12 = true;
							break;
						default:
							printUsage(args[i]);
							System.exit(0);
							break;
						}
					}

				} catch (Exception e) {
					System.out.println("Invalid option format.");
					printUsage(null);
					System.exit(0);
				}
				uriString = "http://" + urlHost + ":" + urlPort;
			}
		}
	}

	/**
	 * printUsage Print usage help to output
	 * 
	 * @param invalidOpt -
	 *            if non-null, is the invalid parameter
	 */
	private void printUsage(String invalidOpt) {
		if (null != invalidOpt) {
			System.out.println("Invalid Option: " + invalidOpt);
		}
		System.out.println("Usage:");
		System.out
				.println("  runSampleSei -h [hostname] -p [port] -f [urlSuffix] -m [testMessage] -s [echo|ping|async] -t [timeout] -w [y|n] -c [count] -1 -2");
		System.out.println("Default values:");
		System.out.println("  hostname= localhost");
		System.out.println("  port= 9080");
		System.out.println("  testMessage= HELLO");
		System.out.println("  urlSuffix= /WSSampleSei/EchoService");
		System.out.println("  service= async");
		System.out.println("  timeout= 240 (seconds)");
		System.out.println("  wireasync= y (yes)");
		System.out.println("  count= 1");
		System.out.println("  -1 = soap 1.1 (default)");
		System.out.println("  -2 = soap 1.2");
	}

	/**
	 * CallService Parms were already read. Now call the service proxy classes
	 * 
	 */
	void CallService() {
		for (int index =0; index < count; index ++)
		{
			if (soap12)
			{
				if (servtype.equalsIgnoreCase("echo")) {
					if (0 == urlSuffix.length())
					{
						urlSuffix = ECHO_CONTEXT12;
					}
					buildEcho12(uriString+urlSuffix, message);
				} else if (servtype.equalsIgnoreCase("async")) {
					if (0 == urlSuffix.length())
					{
						urlSuffix = ECHO_CONTEXT12;
					}
					buildAsync12(uriString+urlSuffix, message, timeout, wireasync);
				} else 
				{
					if (0 == urlSuffix.length())
					{
						urlSuffix = PING_CONTEXT12;
					}
					buildPing12(uriString+urlSuffix, message);
				}			
			}
			else
			{
				if (servtype.equalsIgnoreCase("echo")) {
					if (0 == urlSuffix.length())
					{
						urlSuffix = ECHO_CONTEXT;
					}
					buildEcho(uriString+urlSuffix, message);
				} else if (servtype.equalsIgnoreCase("async")) {
					if (0 == urlSuffix.length())
					{
						urlSuffix = ECHO_CONTEXT;
					}
					buildAsync(uriString+urlSuffix, message, timeout, wireasync);
				} else 
				{
					if (0 == urlSuffix.length())
					{
						urlSuffix = PING_CONTEXT;
					}
					buildPing(uriString+urlSuffix, message);
				}
			}
		}
	}
	
	/**
	 * buildPing
	 * Call the ping service 
	 * @param endpointURL The Service endpoint URL
	 * @param input The message string
	 * @return Boolean true if the ping works
	 */
	public boolean buildPing(String endpointURL, String input) {
		try {
			PingServicePortProxy ping = new PingServicePortProxy(null, new QName("http://com/ibm/was/wssample/sei/ping/", "PingService"));
			ping._getDescriptor().setEndpoint(endpointURL);
			System.out.println(">> CLIENT: SEI Ping to " + endpointURL);

			// Configure SOAPAction properties
			BindingProvider bp = (BindingProvider) (ping._getDescriptor()
					.getProxy());
			bp.getRequestContext().put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY,
					endpointURL);
			bp.getRequestContext().put(BindingProvider.SOAPACTION_USE_PROPERTY,
					Boolean.TRUE);
			bp.getRequestContext().put(BindingProvider.SOAPACTION_URI_PROPERTY,
					"pingOperation");

			// Build the input object
			PingStringInput pingParm = 
				new com.ibm.was.wssample.sei.ping.ObjectFactory().createPingStringInput();
			pingParm.setPingInput(input);
			
			// Call the service
			ping.pingOperation(pingParm);
			System.out.println(">> CLIENT: SEI Ping SUCCESS.");
			return true;
		} catch (Exception e) {
			System.out.println(">> CLIENT: ERROR: SEI Ping EXCEPTION.");
			e.printStackTrace();
			return false;
		}
	}

	/**
	 * buildEcho
	 * Call the Echo service (Sync)
	 * @param endpointURL The Service endpoint URL
	 * @param input The message string
	 * @return String from the service 
	 */
	public String buildEcho(String endpointURL, String input) {
		String response = "ERROR!:";
		try {
			EchoServicePortProxy echo = new EchoServicePortProxy(null, new QName("http://com/ibm/was/wssample/sei/echo/", "EchoService"));
			echo._getDescriptor().setEndpoint(endpointURL);

			// Configure SOAPAction properties
			BindingProvider bp = (BindingProvider) (echo._getDescriptor()
					.getProxy());
			bp.getRequestContext().put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY,
					endpointURL);
			bp.getRequestContext().put(BindingProvider.SOAPACTION_USE_PROPERTY,
					Boolean.TRUE);
			bp.getRequestContext().put(BindingProvider.SOAPACTION_URI_PROPERTY,
					"echoOperation");

			// Build the input object
			EchoStringInput echoParm = 
				new com.ibm.was.wssample.sei.echo.ObjectFactory().createEchoStringInput();
			echoParm.setEchoInput(input);
			System.out.println(">> CLIENT: SEI Echo to " + endpointURL);
			
			// Call the service
			response = echo.echoOperation(echoParm).getEchoResponse();
			System.out.println(">> CLIENT: SEI Echo invocation complete.");
			System.out.println(">> CLIENT: SEI Echo response is: " + response);
		} catch (Exception e) {
			System.out.println(">> CLIENT: ERROR: SEI Echo EXCEPTION.");
			e.printStackTrace();
			return response + ">>>ECHO SERVICE EXCEPTION<<< ";
		}
		return response;
	}
	
	/**
	 * buildAsync
	 * Call the Echo service (Async)
	 * @param endpointURL The Service endpoint URL
	 * @param input The message string
	 * @param waiting The Async timeout
	 * @param wireasync true to use Async on the wire
	 * @return String from the service 
	 */
	public String buildAsync(String endpointURL, String input, int waiting, Boolean wireasync) {
		String response = "ERROR!:";
		try {
			EchoServicePortProxy echo = new EchoServicePortProxy(null, new QName("http://com/ibm/was/wssample/sei/echo/", "EchoService"));
			echo._getDescriptor().setEndpoint(endpointURL);

			// Configure SOAPAction properties
			BindingProvider bp = (BindingProvider) (echo._getDescriptor()
					.getProxy());
			bp.getRequestContext().put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY,
					endpointURL);
			bp.getRequestContext().put(BindingProvider.SOAPACTION_USE_PROPERTY,
					Boolean.TRUE);
			bp.getRequestContext().put(BindingProvider.SOAPACTION_URI_PROPERTY,
					"echoOperation");
			if (wireasync)
			{
				bp.getRequestContext().put(com.ibm.wsspi.websvcs.Constants.USE_ASYNC_MEP,							
						Boolean.TRUE);
			}
				
			// Set up the callback handler and create the input object
			EchoServiceCallbackHandler callbackHandler = new EchoServiceCallbackHandler();
			EchoStringInput echoParm = 
				new com.ibm.was.wssample.sei.echo.ObjectFactory().createEchoStringInput();
			echoParm.setEchoInput(input);
			System.out.println(">> CLIENT: SEI Async to " + endpointURL);
			
			// Call the service
			Future<?> resp = echo.echoOperationAsync(echoParm, callbackHandler);
			Thread.sleep(1000);
			while (!resp.isDone()) {
				// Check for timeout
				if (waiting <= 0) {
					System.out
							.println(">> CLIENT: ERROR - SEI Async Timeout waiting for reply.");
					return response + "Async timeout waiting for reply.";
				}
				System.out
						.println(">> CLIENT: SEI Async invocation still not complete");
				Thread.sleep(1000 * SLEEPER);
				waiting -= SLEEPER;
			}

			// Get the response and print it, then return
			EchoStringResponse esr = callbackHandler.getResponse();
			System.out.println(">> CLIENT: SEI Async invocation complete.");
			if (null != esr)
			{
				response = esr.getEchoResponse();
				if (null != response)
				{
					System.out.println(">> CLIENT: SEI Async response is: " + response);
				}
			}
		} catch (Exception e) {
			System.out.println(">> CLIENT: ERROR: SEI Async EXCEPTION.");
			e.printStackTrace();
			return response + ">>>ASYNC SERVICE EXCEPTION<<<";
		}
		return response;
	}
	/**
	 * buildPing12
	 * Call the ping service 
	 * @param endpointURL The Service endpoint URL
	 * @param input The message string
	 * @return Boolean true if the ping works
	 */
	public boolean buildPing12(String endpointURL, String input) {
		try {
			PingService12PortProxy ping = new PingService12PortProxy();
			ping._getDescriptor().setEndpoint(endpointURL);
			System.out.println(">> CLIENT: SEI Ping to " + endpointURL);

			// Build the input object
			PingStringInput pingParm = 
				new com.ibm.was.wssample.sei.ping.ObjectFactory().createPingStringInput();
			pingParm.setPingInput(input);
			
			// Call the service
			ping.pingOperation(pingParm);
			System.out.println(">> CLIENT: SEI Ping SUCCESS.");
			return true;
		} catch (Exception e) {
			System.out.println(">> CLIENT: ERROR: SEI Ping EXCEPTION.");
			e.printStackTrace();
			return false;
		}
	}

	/**
	 * buildEcho12
	 * Call the Echo service (Sync)
	 * @param endpointURL The Service endpoint URL
	 * @param input The message string
	 * @return String from the service 
	 */
	public String buildEcho12(String endpointURL, String input) {
		String response = "ERROR!:";
		try {
			EchoService12PortProxy echo = new EchoService12PortProxy();
			echo._getDescriptor().setEndpoint(endpointURL);

			// Build the input object
			EchoStringInput echoParm = 
				new com.ibm.was.wssample.sei.echo.ObjectFactory().createEchoStringInput();
			echoParm.setEchoInput(input);
			
			System.out.println(">> CLIENT: SEI Echo to " + endpointURL);
			
			// Call the service
			response = echo.echoOperation(echoParm).getEchoResponse();
			
			System.out.println(">> CLIENT: SEI Echo invocation complete.");
			System.out.println(">> CLIENT: SEI Echo response is: " + response);
		} catch (Exception e) {
			System.out.println(">> CLIENT: ERROR: SEI Echo EXCEPTION.");
			e.printStackTrace();
			return response + ">>>ECHO SERVICE EXCEPTION<<< ";
		}
		return response;
	}
	
	/**
	 * buildAsync12
	 * Call the Echo service (Async)
	 * @param endpointURL The Service endpoint URL
	 * @param input The message string
	 * @param waiting The Async timeout
	 * @param wireasync true to use Async on the wire
	 * @return String from the service 
	 */
	public String buildAsync12(String endpointURL, String input, int waiting, Boolean wireasync) {
		String response = "ERROR!:";
		try {
			EchoService12PortProxy echo = new EchoService12PortProxy();
			echo._getDescriptor().setEndpoint(endpointURL);

			// Configure over-the-wire async if specified
			if (wireasync)
			{
				BindingProvider bp = (BindingProvider) (echo._getDescriptor()
						.getProxy());
				bp.getRequestContext().put(com.ibm.wsspi.websvcs.Constants.USE_ASYNC_MEP,							
						Boolean.TRUE);
			}
					
			// Set up the callback handler and create the input object
			EchoServiceCallbackHandler callbackHandler = new EchoServiceCallbackHandler();
			EchoStringInput echoParm = 
				new com.ibm.was.wssample.sei.echo.ObjectFactory().createEchoStringInput();
			echoParm.setEchoInput(input);
			System.out.println(">> CLIENT: SEI Async to " + endpointURL);
			
			// Call the service
			Future<?> resp = echo.echoOperationAsync(echoParm, callbackHandler);
			Thread.sleep(1000);
			while (!resp.isDone()) {
				// Check for timeout
				if (waiting <= 0) {
					System.out
							.println(">> CLIENT: ERROR - SEI Async Timeout waiting for reply.");
					return response + "Async timeout waiting for reply.";
				}
				System.out
						.println(">> CLIENT: SEI Async invocation still not complete");
				Thread.sleep(1000 * SLEEPER);
				waiting -= SLEEPER;
			}

			// Get the response and print it, then return
			EchoStringResponse esr = callbackHandler.getResponse();
			System.out.println(">> CLIENT: SEI Async invocation complete.");
			if (null != esr)
			{
				response = esr.getEchoResponse();
				if (null != response)
				{
					System.out.println(">> CLIENT: SEI Async response is: " + response);
				}
			}
			
		} catch (Exception e) {
			System.out.println(">> CLIENT: ERROR: SEI Async EXCEPTION.");
			e.printStackTrace();
			return response + ">>>ASYNC SERVICE EXCEPTION<<<";
		}
		return response;
	}
	
}
	