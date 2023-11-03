package com.javacodegeeks.examples.jaxws;

import javax.jws.WebService;

@WebService(endpointInterface = "com.javacodegeeks.examples.jaxws.CalculatorI")
public class CalculatorImpl implements CalculatorI {

	@Override
	public int add(int a, int b) {
		return a + b;
	}

	@Override
	public int subtract(int a, int b) {
		return a - b;
	}

	@Override
	public int multiply(int a, int b) {
		return a * b;
	}

	@Override
	public int divide(int a, int b) {
		return a / b;
	}

}
